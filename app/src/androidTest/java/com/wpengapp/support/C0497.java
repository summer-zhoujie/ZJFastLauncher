package com.wpengapp.support;

import com.wpengapp.support.activity.WPengVersionActivity;
import com.wpengapp.support.activity.WechatSubscriptionActivity;
import com.wpengapp.support.model.GzhConfig;

/* renamed from: com.wpengapp.support.ů */
/* compiled from: WPengVersionActivity */
public class C0497 implements HtmlTextHelper {

    /* renamed from: ֏ */
    public final /* synthetic */ WPengVersionActivity f884;

    public C0497(WPengVersionActivity wPengVersionActivity) {
        this.f884 = wPengVersionActivity;
    }

    /* renamed from: ֏ */
    public void mo7949(String str, CharSequence charSequence) {
        if ("wechat".equals(str)) {
            SystemUtils.m3513((CharSequence) C0771.m2078());
            C0826.m2180((CharSequence) this.f884.getString(R$string.pw_copy_success) + "\n" + C0771.m2078());
        } else if ("qq".equals(str)) {
            SystemUtils.m3513((CharSequence) C0771.m2073());
            C0826.m2180((CharSequence) this.f884.getString(R$string.pw_copy_success) + "\n" + C0771.m2073());
        } else if (!"gzh".equals(str)) {
        } else {
            if (!GzhConfig.getConfig().appCode) {
                C0826.m2179(R$string.pw_coming_soon, new Object[0]);
            } else {
                WechatSubscriptionActivity.m839(this.f884, "AppCodeDialog");
            }
        }
    }
}
