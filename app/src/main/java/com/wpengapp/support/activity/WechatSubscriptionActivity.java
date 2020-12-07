package com.wpengapp.support.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.wpengapp.support.AccServiceHelper;
import com.wpengapp.support.BaseEvent;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C1146;
import com.wpengapp.support.C1279;
import com.wpengapp.support.GzhEvent;
import com.wpengapp.support.HtmlTextHelper;
import com.wpengapp.support.Image;
import com.wpengapp.support.R$drawable;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.RemoteCallback;
import com.wpengapp.support.RemoteMethod;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.UMengManager;
import com.wpengapp.support.model.GzhConfig;
import java.util.HashMap;
import java.util.Map;

public class WechatSubscriptionActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public static Class[] f660;

    /* renamed from: ؠ */
    public static final RemoteMethod f661 = new C0926("onekeys");

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.pw_activity_wechat_subscription);
        mo7434().setBackgroundColor(0);
        findViewById(R$id.toolbarLine).setVisibility(4);
        GzhConfig config = GzhConfig.getConfig();
        if (TextUtils.isEmpty(config.name)) {
            finish();
            return;
        }
        ((TextView) findViewById(R$id.tv_intro)).setText(config.intro);
        TextView textView = (TextView) findViewById(R$id.tv_name);
        C0826.m2176(textView);
        textView.setText(config.name);
        textView.setOnClickListener(new C1070(this, config));
        textView.setOnLongClickListener(new C1150(this, config));
        C1279.m3412((TextView) findViewById(R$id.tv_help_tips), (CharSequence) getString(R$string.pw_subscript_help2, new Object[]{config.name}), (HtmlTextHelper) new WechatSubscriptionActivity(this, config));
        ImageView imageView = (ImageView) findViewById(R$id.img_qr);
        imageView.post(new C0816(this, imageView, config));
        Image.m3366().mo8349(config.icon, (ImageView) findViewById(R$id.img_qr_icon));
        TextView textView2 = (TextView) findViewById(R$id.tv_one);
        if (!GzhConfig.getConfig().oneKey || !AccServiceHelper.m2016(f660)) {
            textView2.setVisibility(8);
        } else {
            textView2.setOnClickListener(new C1216(this));
        }
    }

    /* renamed from: ֏ */
    public boolean mo7423() {
        return true;
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, R$drawable.baseui_icon_toolbar_back_dark);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return null;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ގ */
    public final void mo7848() {
        if (!AccServiceHelper.m2016(f660)) {
            C0826.m2179(R$string.pw_subscript_gzh_fail, GzhConfig.getConfig().name);
        } else if (SystemUtils.m3524("com.tencent.mm") == null) {
            C0826.m2179(R$string.pw_subscript_gzh_fail2, new Object[0]);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("gzh_onekey", "Click");
            UMengManager.m1406("gzh_onekey", (Map<String, String>) hashMap);
            C1146.m3071(f661.f1927, (Bundle) null, (RemoteCallback) null);
        }
    }

    /* renamed from: ֏ */
    public static boolean m839(Context context, String str) {
        try {
            SystemUtils.m3510(context, new Intent(context, WechatSubscriptionActivity.class));
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            UMengManager.m1403((BaseEvent) new GzhEvent(str));
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
