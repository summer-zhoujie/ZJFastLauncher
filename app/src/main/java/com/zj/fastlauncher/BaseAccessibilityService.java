package com.zj.fastlauncher;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.zj.fastlauncher.db.DaoHelper;
import com.zj.fastlauncher.db.entities.ActCanJump;
import com.zj.fastlauncher.utils.PrintUtils;
import com.zj.tools.mylibrary.ZJHandlerUtil;
import com.zj.tools.mylibrary.ZJLog;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BaseAccessibilityService extends AccessibilityService {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // variables

    /**
     * 基础的跳过数据库, 记录所有可跳过的界面
     */
    private static final List<ActCanJump> listActCanJump = new ArrayList<ActCanJump>() {
        {
        }
    };
    /**
     * 开启自动录入时自动跳过这些界面
     */
    private static final List<String> needNotRecord = new ArrayList<String>() {
        {
            add("com.zj.fastlauncher/com.zj.fastlauncher.MainActivity");
        }
    };
    private static final String[] KEY_WORDS = {"跳过"};
    /**
     * 是否开启 '智能跳过界面' 功能
     */
    private static boolean jumpFuncEnable = true;
    /**
     * 是否开启 '自动记录下能跳过的界面' 功能
     */
    private static boolean autoRecordFuncEnable = false;
    /**
     * 记录当前顶层界面全路径
     * {@link #getClassPath(AccessibilityEvent)}
     */
    private String forggroundActivity = null;
    /**
     * 记录当前顶层界面是否跳过成功
     */
    private boolean isCurJumpOk = false;
    /**
     * 记录当前App启动的Acticity次数
     */
    private int curAppActivityCount = 1;
    /**
     * 记录当前界面是否弹出了按钮记录的弹窗
     */
    private boolean isCurActShowRecordDialog = false;
    /**
     * 记录当前界面是否自动录入成功
     */
    private boolean isCurActRecordOk = false;


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // out-funcs

    public static void setJumpFuncEnable(boolean enable) {
        BaseAccessibilityService.jumpFuncEnable = enable;
    }

    public static boolean getJumpFuncEnable() {
        return BaseAccessibilityService.jumpFuncEnable;
    }

    public static void setAutorecordFuncEnable(boolean enable) {
        BaseAccessibilityService.autoRecordFuncEnable = enable;
    }

    public static boolean getAutorecordFuncEnable() {
        return BaseAccessibilityService.autoRecordFuncEnable;
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
        restoreJumpDataFromDB();
        try {
            final AccessibilityServiceInfo serviceInfo = getServiceInfo();
            serviceInfo.flags |= AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS;
            setServiceInfo(serviceInfo);
        } catch (Exception e) {
            ZJLog.e("错误: " + Log.getStackTraceString(e));
        }
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
            updateForgroundActivity(eventType, classPath);
            watchIfNeedRecord(source);
            //TODO Summer
//            watchIfNeedJump(eventType, source);
            justDoJumpWithKeyWords(source);
        } catch (NullPointerException e) {
            ZJLog.e("event == null");
            return;
        }
    }

    /**
     * 更新顶层界面信息
     */
    private void updateForgroundActivity(int eventType, String classPath) {
        if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            ZJLog.d("进入界面 = " + classPath);
            isCurJumpOk = false;
            isCurActShowRecordDialog = false;
            isCurActRecordOk = false;
            final String newActivity = classPath;
            if (TextUtils.equals(forggroundActivity, newActivity)) {
                curAppActivityCount += 1;
            } else {
                curAppActivityCount = 1;
            }
            forggroundActivity = newActivity;
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // autorecord-funcs

    /**
     * 监听界面事件, 如果有必要执行录入程序
     */
    private void watchIfNeedRecord(AccessibilityNodeInfo source) {
        if (!autoRecordFuncEnable || isCurActShowRecordDialog) {
            return;
        }

        // 不在可跳转列表里 && 不是当前工具App && 不在忽略列表里 && 是App的第一个Activity
        if (!isCurForggroundActivityContainsInListActCanJump(listActCanJump, forggroundActivity)
                && !forggroundActivity.contains("com.zj.fastlauncher")
                && !needNotRecord.contains(forggroundActivity)
                && curAppActivityCount <= 2) {
            final List<AccessibilityNodeInfo> result = findJumpClickableView(source);
            if (result != null && !result.isEmpty()) {
                ZJLog.d("弹窗提示用户收录");
                isCurActShowRecordDialog = true;
                final ActCanJump e = generateEntityWaitToBeRecord(forggroundActivity, result);
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    showRecordConfirmDialog(forggroundActivity, e);
                } else {
                    ZJHandlerUtil.postToMain(new Runnable() {
                        @Override
                        public void run() {
                            showRecordConfirmDialog(forggroundActivity, e);
                        }
                    });
                }
            }
        }
    }

    private boolean isCurForggroundActivityContainsInListActCanJump(List<ActCanJump> list, String curforggroundactivity) {
        if (list != null && !list.isEmpty()) {
            for (ActCanJump actCanJump : list) {
                if (TextUtils.equals(actCanJump.getAct(), curforggroundactivity)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断当前界面是否是Activity
     *
     * @return true 是
     */
    private boolean isActivity(AccessibilityEvent event) {
        ComponentName cName = new ComponentName(event.getPackageName().toString(), event.getClassName().toString());
        ActivityInfo activityInfo;
        try {
            activityInfo = getPackageManager().getActivityInfo(cName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            activityInfo = null;
        }
        final boolean isActivity = activityInfo != null;
        return isActivity;
    }

    /**
     * 生成一个{@link ActCanJump}实例, 等待被录入
     */
    private ActCanJump generateEntityWaitToBeRecord(String classPath, List<AccessibilityNodeInfo> result) {
        final ActCanJump e = new ActCanJump();
        e.setAct(classPath);
        final StringBuilder builder = new StringBuilder();
        for (AccessibilityNodeInfo info : result) {
            builder.append(info.getViewIdResourceName());
        }
        final String s = builder.toString();
        final String substring = s.substring(0, s.length() - 1);
        e.setJumpIds(substring);
        ZJLog.d("生成一个等待被录入的实例, " + e);
        return e;
    }

    /**
     * 显示记录的确认弹窗
     */
    private void showRecordConfirmDialog(final String classPath, final ActCanJump e) {
        final SweetAlertDialog dialog = new SweetAlertDialog(getApplicationContext(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("捕获!")
                .setContentText("捕获到可跳过的界面" + classPath + ", 是否录入")
                .setCancelText("不需要")
                .setConfirmText("录入")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismiss();
                        needNotRecord.add(classPath);
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        ZJLog.d("恭喜, 录入成功, " + e);
                        isCurActRecordOk = true;
                        sDialog.dismiss();
                        DaoHelper.getInstance().getNewSession().getActCanJumpDao().insert(e);
                        listActCanJump.add(e);
                    }
                });
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_PANEL);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                dialog.getWindow().setType(2038);
            } else {
                dialog.getWindow().setType(2003);
            }
            dialog.show();
        } catch (Exception exp) {
            exp.getMessage();
        }
    }

    /**
     * 从数据库读取最新的数据, 用来匹配跳过
     */
    private void restoreJumpDataFromDB() {
        final List<ActCanJump> r = DaoHelper.getInstance().getNewSession().getActCanJumpDao().loadAll();
        if (r != null && !r.isEmpty()) {
            for (ActCanJump item : r) {
                if (!listActCanJump.contains(item)) {
                    listActCanJump.add(item);
                }
            }
        }
        ZJLog.d("依赖数据库 = " + PrintUtils.getListString(listActCanJump));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // jump-funcs

    /**
     * 监听界面事件, 如果有必要执行跳过程序
     */
    private void watchIfNeedJump(int eventType, AccessibilityNodeInfo source) {
        if (!jumpFuncEnable) {
            return;
        }

        switch (eventType) {
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                doJump(source);
                break;
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
//                ZJLog.d("界面刷新 = " + classPath);
                doJump(source);
                break;
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
                if (getCanJumpRecord(forggroundActivity) != null) {
                    ZJLog.d("控件被点击, id = " + source.getViewIdResourceName());
                }
                break;
        }
    }

    /**
     * 尝试跳过开屏广告
     */
    private void doJump(AccessibilityNodeInfo source) {
        doJumpWithKeyIds(source);
        doJumpWithKeyWords(source);
    }

    /**
     * 使用查询'id'的方式来执行跳过
     */
    private void doJumpWithKeyIds(AccessibilityNodeInfo source) {
        final ActCanJump canJumpRecord = getCanJumpRecord(forggroundActivity);
        if (canJumpRecord != null && !isCurJumpOk) {
            final String s = canJumpRecord.getAct();
            if (TextUtils.isEmpty(s)) {
                return;
            }
            final List<AccessibilityNodeInfo> r = source.findAccessibilityNodeInfosByViewId(s);
            if (r == null || r.isEmpty()) {
                return;
            }

            isCurJumpOk = true;
            for (AccessibilityNodeInfo i : r) {
                ZJLog.d("查询id=" + s + "成功, 结果=" + r.get(0).getViewIdResourceName());
                AccessibilityNodeInfo info = findAClickableView(i);
                if (info == null) {
                    break;
                }
                ZJLog.d("执行跳过 id=" + i.getViewIdResourceName());
                info.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }
    }

    /**
     * 使用查询'跳过'Text的方式来执行跳过
     */
    private void doJumpWithKeyWords(AccessibilityNodeInfo source) {
        final ActCanJump canJumpRecord = getCanJumpRecord(forggroundActivity);
        if (canJumpRecord != null && !isCurJumpOk) {
            final List<AccessibilityNodeInfo> result = findJumpClickableView(source);
            if (result != null && !result.isEmpty()) {
                isCurJumpOk = true;
                for (AccessibilityNodeInfo info : result) {
                    ZJLog.d("执行跳过 id=" + info.getViewIdResourceName());
                    info.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }
    }

    /**
     * 使用查询'跳过'Text的方式来执行跳过(抓到直接执行跳过)
     */
    private void justDoJumpWithKeyWords(AccessibilityNodeInfo source) {
        if (!forggroundActivity.contains("com.zj.fastlauncher")
                && curAppActivityCount <= 2 && !isCurJumpOk) {
            final List<AccessibilityNodeInfo> result = findJumpClickableView(source);
            if (result != null && !result.isEmpty()) {
                isCurJumpOk = true;
                for (AccessibilityNodeInfo info : result) {
                    ZJLog.d("执行跳过 id=" + info.getViewIdResourceName());
                    info.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }
    }

    /**
     * 查找当前界面是否含有跳过并且可以点击的控件
     *
     * @return 返回查询的结果, 可能返回null
     */
    private List<AccessibilityNodeInfo> findJumpClickableView(AccessibilityNodeInfo source) {
        List<AccessibilityNodeInfo> r = null;
        for (String keyWord : KEY_WORDS) {
            try {
                r = source.findAccessibilityNodeInfosByText(keyWord);
            } catch (Exception e) {
                return null;
            }
            if (r != null && !r.isEmpty()) {
                break;
            }
        }
        if (r == null || r.isEmpty()) {
            return null;
        }
        List<AccessibilityNodeInfo> result = new ArrayList<>();
        for (AccessibilityNodeInfo i : r) {
            AccessibilityNodeInfo info = findAClickableView(i);
            if (info == null) {
                break;
            }
            ZJLog.d("查询" + PrintUtils.getArrayString(KEY_WORDS) + "成功, 结果=" + info.getViewIdResourceName());
            result.add(info);
        }
        return result;
    }

    /**
     * 找到一个可以点击的控件 ( 自己或者父类 )
     */
    private AccessibilityNodeInfo findAClickableView(AccessibilityNodeInfo i) {
        if (i.isClickable()) {
            return i;
        }

        // 15层迭代查看有没有能点击的控件
        AccessibilityNodeInfo info = i;
        for (int index = 0; index < 15; index++) {
            info = info.getParent();
            ZJLog.d("findparent = " + (info == null ? "null" : info.getViewIdResourceName()));
            if (info == null) {
                return null;
            }
            if (info.isClickable()) {
                return info;
            }
        }

        return null;
    }

    /**
     * 根据本地数据查询, 当前界面是否可以被跳过, 如果可以被跳过, 返回跳过的配置
     *
     * @param classPath 界面全路径, 由 {@link #getClassPath(AccessibilityEvent)} 生成
     * @return ActCanJump != null 可以被跳过; ActCanJump == null 不能被跳过
     */
    private ActCanJump getCanJumpRecord(String classPath) {
        if (!listActCanJump.isEmpty()) {
            for (ActCanJump actCanJump : listActCanJump) {
                if (TextUtils.equals(actCanJump.getAct(), classPath)) {
                    return actCanJump;
                }
            }
        }
        return null;
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
