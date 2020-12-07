package com.wpengapp.support.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wpengapp.support.ActivityKiller;
import com.wpengapp.support.C1063;
import com.wpengapp.support.R$color;
import com.wpengapp.support.R$drawable;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.licensing.activity.WechatReadQrDemoActivity;

public class RewardActivity extends WPengBaseActivity {
    /* renamed from: ֏ */
    public static void m804(Context context) {
        SystemUtils.m3510(context, new Intent(context, RewardActivity.class));
    }

    public void onClick(View view) {
        if (view.getId() == R$id.tv_demo) {
            mo7420((Class<?>) WechatReadQrDemoActivity.class);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String r5 = C1063.m2859("reward_qr", (String) null);
        if (TextUtils.isEmpty(r5)) {
            finish();
            return;
        }
        setContentView(R$layout.pw_activity_qr_pay);
        mo7434().setBackgroundColor(0);
        findViewById(R$id.toolbarLine).setVisibility(4);
        ActivityKiller.f1598.put(this, this);
        findViewById(R$id.tv_amount).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R$id.img_qr);
        imageView.post(new com.wpengapp.support.RewardActivity(this, imageView, r5));
        findViewById(R$id.layout_save_qr).setVisibility(0);
        findViewById(R$id.tv_open_alipay).setVisibility(8);
        findViewById(R$id.tv_has_paid).setVisibility(8);
        ((TextView) findViewById(R$id.tv_title)).setText(R$string.pw_reward_title);
        findViewById(R$id.layout_top).setBackgroundResource(R$color.pw_wechat_bg);
        ((ImageView) findViewById(R$id.img_qr_icon)).setImageResource(R$drawable.pw_ic_wechat);
    }

    /* renamed from: ֏ */
    public boolean mo7423() {
        return true;
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return BidiFormatter.EMPTY_STRING;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }
}
