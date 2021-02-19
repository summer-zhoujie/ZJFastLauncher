package com.zj.fastlauncher;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // variables

    private LinearLayout llOnOffService;
    private SwitchCompat swiitchOnOffService;
    private static final int GET_OVERLAY_PERMISSION_REQUESTCODE = 1000;


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
//        // 自动记录下能跳过的界面
//        else if (id == R.id.ll_auto_record) {
//            // 没有系统弹窗权限
//            if (!isHaveOverlayPermission()) {
//                new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
//                        .setTitleText("请允许显示在其他应用上层")
//                        .setContentText("使用此项功能需要允许显示在其他应用上层")
//                        .setCustomImage(R.mipmap.ic_launcher)
//                        .setConfirmText("立即允许")
//                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                            @Override
//                            public void onClick(SweetAlertDialog sweetAlertDialog) {
//                                getOverlayPermission();
//                                sweetAlertDialog.dismiss();
//                            }
//                        })
//                        .show();
//
//                return;
//            }
//        }
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