package com.wpengapp.support;

import android.content.Context;
import com.wpengapp.support.C0678;
import com.wpengapp.support.activity.WPengVersionActivity;

/* renamed from: com.wpengapp.support.ແ */
/* compiled from: WPengVersionActivity */
class C1237 implements C0678.C0680 {

    /* renamed from: ֏ */
    public final /* synthetic */ WPengVersionActivity f3512;

    public C1237(WPengVersionActivity wPengVersionActivity) {
        this.f3512 = wPengVersionActivity;
    }

    /* renamed from: ֏ */
    public void mo8029(UserInfo r4, boolean z, String str) {
        if (z) {
            C0826.m2172(R$string.wpengpay_pay_success, new Object[0]);
        } else {
            if ((this.f3512.getString(R$string.wpengpay_error_cause) + this.f3512.getString(R$string.wpengpay_error_user_cancel)).equals(str)) {
                C0826.m2179(R$string.wpengpay_error_user_cancel, new Object[0]);
            } else {
                C1114.m2999((Context) this.f3512, str);
            }
        }
        this.f3512.mo7844(r4);
    }
}
