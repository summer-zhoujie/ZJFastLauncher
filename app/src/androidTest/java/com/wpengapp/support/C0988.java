package com.wpengapp.support;

import com.wpengapp.support.activity.WPengVersionActivity;

/* renamed from: com.wpengapp.support.ࠂ */
/* compiled from: WPengVersionActivity */
class C0988 implements QueryCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ int f2775;

    /* renamed from: ؠ */
    public final /* synthetic */ WPengVersionActivity f2776;

    public C0988(WPengVersionActivity wPengVersionActivity, int i) {
        this.f2776 = wPengVersionActivity;
        this.f2775 = i;
    }

    /* renamed from: ֏ */
    public void mo8024(C1114 r1, boolean z, boolean z2, int i) {
        if (!z) {
            r1.mo9297((OnDialogClickListener) null, (OnDialogClickListener) new C0843(this));
        } else if (z2) {
            this.f2776.mo7844(r1.f3172);
            this.f2776.mo7413(R$string.wpengpay_pay_success);
        } else {
            this.f2776.mo7842(this.f2775, r1.f3172);
        }
    }
}
