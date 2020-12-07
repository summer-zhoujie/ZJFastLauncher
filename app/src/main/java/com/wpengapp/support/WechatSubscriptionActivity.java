package com.wpengapp.support;

import com.wpengapp.support.licensing.activity.WechatReadQrDemoActivity;
import com.wpengapp.support.model.GzhConfig;

/* renamed from: com.wpengapp.support.ǜ */
class WechatSubscriptionActivity implements HtmlTextHelper {

    /* renamed from: ֏ */
    public final /* synthetic */ GzhConfig f987;

    /* renamed from: ؠ */
    public final /* synthetic */ com.wpengapp.support.activity.WechatSubscriptionActivity f988;

    public WechatSubscriptionActivity(com.wpengapp.support.activity.WechatSubscriptionActivity wechatSubscriptionActivity, GzhConfig gzhConfig) {
        this.f988 = wechatSubscriptionActivity;
        this.f987 = gzhConfig;
    }

    /* renamed from: ֏ */
    public void mo7949(String str, CharSequence charSequence) {
        if ("gzh".equals(str)) {
            SystemUtils.m3513((CharSequence) this.f987.name);
            C0826.m2180((CharSequence) this.f988.getString(R$string.pw_copy_success) + "\n" + this.f987.name);
        } else if ("demo".equals(str)) {
            this.f988.mo7420((Class<?>) WechatReadQrDemoActivity.class);
        }
    }
}
