package com.zj.fastlauncher;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.zj.fastlauncher.db.entities.ActCanJump;
import com.zj.fastlauncher.utils.PrintUtils;
import com.zj.tools.mylibrary.ZJHandlerUtil;
import com.zj.tools.mylibrary.ZJLog;

import java.util.ArrayList;
import java.util.List;

public class BaseAccessibilityService extends AccessibilityService {

    public static BaseAccessibilityService service;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // variables

    /**
     * 基础的跳过数据库, 记录所有可跳过的界面
     */
    private static final List<String> listActCanJump = new ArrayList<String>() {
        {
            add("Splash".toLowerCase());
            add("Welcome".toLowerCase());
            add("Adver".toLowerCase());
        }
    };
    private static final String[] KEY_WORDS = {"跳过"};
    /**
     * 是否开启 '智能跳过界面' 功能
     */
    private static boolean jumpFuncEnable = true;
    /**
     * 记录当前顶层界面全路径
     * {@link #getClassPath(AccessibilityEvent)}
     */
    private String forggroundActivity = null;
    /**
     * 记录当前顶层界面所属的pkg
     */
    private CharSequence forggroundPkg;
    /**
     * 记录当前顶层界面是否跳过成功
     */
    private boolean isCurJumpOk = false;
    /**
     * 记录当前App启动的Acticity次数
     */
    private int curAppActivityCount = 0;


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // out-funcs

    public static void setJumpFuncEnable(boolean enable) {
        BaseAccessibilityService.jumpFuncEnable = enable;
    }

    public static boolean getJumpFuncEnable() {
        return BaseAccessibilityService.jumpFuncEnable;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // in-funcs

    @Override
    public void onInterrupt() {
        ZJLog.e("服务被中断!!!");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        try {
            final AccessibilityServiceInfo serviceInfo = getServiceInfo();
            serviceInfo.flags |= AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS;
            setServiceInfo(serviceInfo);
        } catch (Exception e) {
            ZJLog.e("错误: " + Log.getStackTraceString(e));
        }
        service = this;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        if (event == null) {
            ZJLog.e("event == null");
            return;
        }

        AccessibilityNodeInfo source = null;
        int eventType;
        String classPath;
        try {
            source = event.getSource();
            eventType = event.getEventType();
            classPath = getClassPath(event);
            updateForgroundActivity(eventType, classPath, event.getPackageName().toString());
//            doJump(getRootInActiveWindow());
            print(event);
        } catch (NullPointerException e) {
            ZJLog.e("event == null");
            return;
        }
    }

    private void print(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED) {
            AccessibilityNodeInfo source = event.getSource();
            final Rect outBounds = new Rect();
            source.getBoundsInScreen(outBounds);
            ZJLog.d("点击坐标位置 = " + outBounds);
        }
    }

    /**
     * 更新顶层界面信息
     */
    private void updateForgroundActivity(int eventType, String classPath, String pkg) {
        if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            ZJLog.d("进入界面 = " + classPath);
            isCurJumpOk = false;
            final String newActivity = classPath;
            final String newPkg = pkg;
            if (TextUtils.equals(forggroundPkg, newPkg)) {
                curAppActivityCount += 1;
            } else {
                curAppActivityCount = 1;
            }
            forggroundPkg = newPkg;
            forggroundActivity = newActivity;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // jump-funcs

    /**
     * 使用查询'跳过'Text的方式来执行跳过(抓到直接执行跳过)
     */
    private void doJump(AccessibilityNodeInfo source) {

        // 酷狗音乐执行内置跳过规则
        if (forggroundActivity.equals("com.kugou.android/com.kugou.android.app.splash.SplashActivity")) {
            ZJLog.d("酷狗执行内置跳过规则");
            ZJHandlerUtil.postToMain(new Runnable() {
                @Override
                public void run() {
                    if (forggroundActivity.equals("com.kugou.android/com.kugou.android.app.splash.SplashActivity")) {
                        final Rect outBounds = new Rect(880, 146, 1043, 216);
                        mockClick(outBounds);
                    }
                }
            }, 500);
            return;
        }

        if ((curAppActivityCount <= 2 || isCanJump(forggroundActivity)) && !isCurJumpOk) {

            final List<AccessibilityNodeInfo> result = new ArrayList<>();
            for (String keyWord : KEY_WORDS) {
                final List<AccessibilityNodeInfo> r = source.findAccessibilityNodeInfosByText(keyWord);
                if (r != null && !r.isEmpty()) {
                    result.addAll(r);
                }
            }
            ZJLog.d("查找跳过控件, 结果=" + PrintUtils.getListString(result));
            if (!result.isEmpty()) {
                isCurJumpOk = true;
                for (AccessibilityNodeInfo info : result) {
                    if (!info.performAction(AccessibilityNodeInfo.ACTION_CLICK)) {
                        if (info.getParent() == null || !info.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK)) {
                            ZJLog.d("执行手势跳过 id=" + info.getViewIdResourceName());
                            final Rect outBounds = new Rect();
                            info.getBoundsInScreen(outBounds);
                            mockClick(outBounds);
                        } else {
                            ZJLog.d("执行父控件跳过 id=" + info.getParent().getViewIdResourceName());
                        }
                    } else {
                        ZJLog.d("执行跳过 id=" + info.getViewIdResourceName());
                    }
                }
            }
        }
    }

    private boolean isCanJump(String activity) {

        for (String s : listActCanJump) {
            if (activity.toLowerCase().contains(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 模拟坐标点击
     */
    private boolean mockClick(Rect outBounds) {
        float X = outBounds.centerX();
        float Y = outBounds.centerY();
        long startTime = 0;
        long duration = 20;
        Path path = new Path();
        path.moveTo(X, Y);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            GestureDescription.Builder builder = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, startTime, duration));
            return dispatchGesture(builder.build(), null, null);
        } else {
            return false;
        }
    }

    public boolean mockClick(float orix, float oriy) {
        final float x = Math.max(orix, 0f);
        final float y = Math.max(oriy, 0f);
        ZJLog.d("开始模拟点击, orix=" + orix + ",oriy=" + oriy + ", targetx=" + x + ", targety=" + y);
        long startTime = 0;
        long duration = 20;
        Path path = new Path();
        path.moveTo(x, y);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            GestureDescription.Builder builder = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, startTime, duration));
            return dispatchGesture(builder.build(), new GestureResultCallback() {
                @Override
                public void onCompleted(GestureDescription gestureDescription) {
                    super.onCompleted(gestureDescription);
                    ZJLog.d("完成模拟点击, targetx=" + x + ", targety=" + y);
                }
            }, null);
        } else {
            return false;
        }
    }

    /**
     * 获取界面的全路径
     */
    private String getClassPath(AccessibilityEvent event) {
        if (event == null) {
            return "";
        }
        return event.getPackageName().toString() + "/" + event.getClassName().toString();
    }
}
