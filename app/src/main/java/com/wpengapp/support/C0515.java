package com.wpengapp.support;

import com.wpengapp.support.activity.WPengVersionActivity;

/* renamed from: com.wpengapp.support.ƛ */
/* compiled from: WPengVersionActivity */
class C0515 implements QueryCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ WPengVersionActivity f934;

    public C0515(WPengVersionActivity wPengVersionActivity) {
        this.f934 = wPengVersionActivity;
    }

    /* renamed from: ֏ */
    public void mo8024(C1114 r1, boolean z, boolean z2, int i) {
        if (!z) {
            r1.mo9297((OnDialogClickListener) null, (OnDialogClickListener) new C0991(this));
        } else if (z2) {
            this.f934.mo7844(r1.f3172);
            this.f934.mo7413(R$string.wpengpay_pay_success);
        } else {
            this.f934.mo7843(r1.f3172);
        }
    }
}
