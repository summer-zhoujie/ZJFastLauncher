package com.zj.fastlauncher;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.zj.fastlauncher.db.DaoHelper;
import com.zj.tools.mylibrary.ZJConvertUtils;
import com.zj.tools.mylibrary.ZJLog;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // variables

    private LinearLayout llOnOffService;
    private SwitchCompat swiitchOnOffService;
    private static final int GET_OVERLAY_PERMISSION_REQUESTCODE = 1000;
    private LinearLayout llClick;
    private SwitchCompat switchClick;
    private View inflate;
    private WindowManager windowManager;
    private View inflate2;


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // in-funcs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        llOnOffService = findViewById(R.id.ll_on_off_service);
        swiitchOnOffService = findViewById(R.id.switch_on_off_service);
        llOnOffService.setOnClickListener(this);

        llClick = findViewById(R.id.ll_click);
        switchClick = findViewById(R.id.switch_click);
        llClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();

        // 智能跳过界面
        if (id == R.id.ll_on_off_service) {
            final boolean selected = v.isSelected();
            if (selected) {
                // 执行关闭
                BaseAccessibilityService.setJumpFuncEnable(false);
                updateJumpFuncStatus();
            } else {
                // 执行开启
                BaseAccessibilityService.setJumpFuncEnable(true);
                if (serviceIsRunning()) {
                    updateJumpFuncStatus();
                } else {
                    startAccessibilityService();
                }
            }
        }
        // 自动记录下能跳过的界面
        else if (id == R.id.ll_click) {
            // 没有系统弹窗权限
            if (!isHaveOverlayPermission()) {
                new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("请允许显示在其他应用上层")
                        .setContentText("使用此项功能需要允许显示在其他应用上层")
                        .setCustomImage(R.mipmap.ic_launcher)
                        .setConfirmText("立即允许")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                getOverlayPermission();
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();

                return;
            }
            showCLickOptsDialog();
        }
    }

    private void showCLickOptsDialog() {

        if (inflate != null && inflate.getParent() != null) {
            return;
        }


        final WindowManager.LayoutParams defaultLayoutParams1 = getDefaultLayoutParams();
        final WindowManager.LayoutParams defaultLayoutParams2 = getDefaultLayoutParams();
        if (inflate == null) {
            inflate = LayoutInflater.from(this).inflate(R.layout.float_view_layout, null);
            final View btClick = inflate.findViewById(R.id.bt_test);
            btClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    inflate2.setFocusable(false);
                    inflate2.setClickable(false);
                    if (BaseAccessibilityService.service != null && inflate2 != null) {
                        final int[] outLocation = new int[2];
                        inflate2.getLocationOnScreen(outLocation);
                        final int[] inWindow = new int[2];
                        inflate2.getLocationInWindow(inWindow);
                        ZJLog.d("outLocation = " + outLocation[0] + "-" + outLocation[1] + ", inWindow = " + inWindow[0] + "-" + inWindow[1]);
                        ZJLog.d("width = " + inflate2.getWidth() + ", height = " + inflate2.getHeight());
                        final float x = outLocation[0] * 1.0f + inflate2.getWidth() / 2.0f;
                        final float y = outLocation[1] * 1.0f + inflate2.getHeight() / 2.0f;
                        // x=1003.0,y=184.0
                        final boolean b = BaseAccessibilityService.service.mockClick(x, y);
                        ZJLog.d("模拟点击是否成功 = " + b);
                    }
                    inflate2.setFocusable(true);
                    inflate2.setClickable(true);
                }
            });
            btClick.setOnTouchListener(new View.OnTouchListener() {
                int lastX;
                int lastY;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int rawX = (int) event.getRawX();
                    int rawY = (int) event.getRawY();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            lastX = rawX;
                            lastY = rawY;
                            break;
                        case MotionEvent.ACTION_MOVE:
                            defaultLayoutParams1.x += rawX - lastX;
                            defaultLayoutParams1.y += rawY - lastY;
                            windowManager.updateViewLayout(v, defaultLayoutParams1);
                            lastX = rawX;
                            lastY = rawY;
                            break;
                    }
                    return false;
                }
            });

            if (inflate2 == null) {
                defaultLayoutParams2.width = ZJConvertUtils.dp2px(30);
                defaultLayoutParams2.height = ZJConvertUtils.dp2px(30);
                inflate2 = LayoutInflater.from(this).inflate(R.layout.float_view_layout2, null);
                final View btClick2 = inflate2.findViewById(R.id.bt_test);
                btClick2.setOnTouchListener(new View.OnTouchListener() {
                    int lastX;
                    int lastY;

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        int rawX = (int) event.getRawX();
                        int rawY = (int) event.getRawY();
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                lastX = rawX;
                                lastY = rawY;
                                break;
                            case MotionEvent.ACTION_MOVE:
                                defaultLayoutParams2.x += rawX - lastX;
                                defaultLayoutParams2.y += rawY - lastY;
                                windowManager.updateViewLayout(v, defaultLayoutParams2);
                                lastX = rawX;
                                lastY = rawY;
                                break;
                        }
                        return true;
                    }
                });
//            inflate.findViewById(R.id.bt_exit).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    click2ClearFloatView();
//                }
//            });
            }

            if (windowManager == null) {
                windowManager = (WindowManager) getApplicationContext().getSystemService(WINDOW_SERVICE);
            }
            windowManager.addView(inflate, defaultLayoutParams1);
            windowManager.addView(inflate2, defaultLayoutParams2);
        }


    }

    private WindowManager.LayoutParams getDefaultLayoutParams() {
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        // 设置为始终
        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        // 设置弹出的Window不持有焦点
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 大小
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        // 位置
        layoutParams.gravity = Gravity.START | Gravity.TOP;
        // 设置背景透明
        layoutParams.format = PixelFormat.TRANSLUCENT;
        return layoutParams;
    }

    public void click2ClearFloatView() {
        if (inflate != null && windowManager != null) {
            windowManager.removeView(inflate);
        }
    }

    /**
     * 是否有系统弹窗权限0
     *
     * @return true 有; false 没有
     */
    private boolean isHaveOverlayPermission() {
        return !(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this));
    }

    /**
     * 请求系统弹窗权限
     */
    @TargetApi(Build.VERSION_CODES.M)
    private void getOverlayPermission() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, GET_OVERLAY_PERMISSION_REQUESTCODE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        // 考虑到无法得到用户前往设置界面配置的结果, 在这里做一次刷新
        updateJumpFuncStatus();
    }

    /**
     * 更新 '智能跳过界面' 功能的视图状态
     */
    private void updateJumpFuncStatus() {
        if (llOnOffService != null) {
            final boolean selected = serviceIsRunning() && BaseAccessibilityService.getJumpFuncEnable();
            llOnOffService.setSelected(selected);
            swiitchOnOffService.setChecked(selected);
        }
    }

    /**
     * 判断自己的应用的AccessibilityService是否在运行
     *
     * @return
     */
    private boolean serviceIsRunning() {
        ActivityManager am = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> services = am.getRunningServices(Short.MAX_VALUE);
        for (ActivityManager.RunningServiceInfo info : services) {
            if (info.service.getClassName().equals(getPackageName() + ".BaseAccessibilityService")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 前往设置界面开启服务
     */
    private void startAccessibilityService() {
        new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("开启辅助功能")
                .setContentText("使用此项功能需要您开启辅助功能")
                .setCustomImage(R.mipmap.ic_launcher)
                .setConfirmText("立即开启")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        // 隐式调用系统设置界面
                        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                        startActivity(intent);
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }


}