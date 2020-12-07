package com.wpengapp.support.licensing.activity;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.wpengapp.support.ActivityKiller;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.activity.WPengBaseActivity;

public class WechatReadQrDemoActivity extends WPengBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PackageInfo r2 = SystemUtils.m3524("com.tencent.mm");
        if (r2 == null || r2.versionCode >= 1580) {
            setContentView(R$layout.pw_activity_wechat_read_qr_demo_new);
        } else {
            setContentView(R$layout.pw_activity_wechat_read_qr_demo);
        }
        ActivityKiller.f1598.put(this, this);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return "操作演示";
    }
}
