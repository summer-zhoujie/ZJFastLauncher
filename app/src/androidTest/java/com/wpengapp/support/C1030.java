package com.wpengapp.support;

import com.wpengapp.support.activity.WPengVersionActivity;

/* renamed from: com.wpengapp.support.य */
/* compiled from: WPengVersionActivity */
class C1030 implements HtmlTextHelper {

    /* renamed from: ֏ */
    public final /* synthetic */ WPengVersionActivity f2950;

    public C1030(WPengVersionActivity wPengVersionActivity) {
        this.f2950 = wPengVersionActivity;
    }

    /* renamed from: ֏ */
    public void mo7949(String str, CharSequence charSequence) {
        if ("wechat".equals(str)) {
            SystemUtils.m3513((CharSequence) C0771.m2078());
            C0826.m2180((CharSequence) this.f2950.getString(R$string.pw_copy_success) + "\n" + C0771.m2078());
            return;
        }
        SystemUtils.m3513((CharSequence) C0771.m2073());
        C0826.m2180((CharSequence) this.f2950.getString(R$string.pw_copy_success) + "\n" + C0771.m2073());
    }
}
