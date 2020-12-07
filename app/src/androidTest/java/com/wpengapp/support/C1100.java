package com.wpengapp.support;

import com.wpengapp.support.licensing.activity.QrPayActivity;

/* renamed from: com.wpengapp.support.ઘ */
/* compiled from: PayManager */
class C1100 implements QrPayActivity.C0454 {

    /* renamed from: ֏ */
    public final /* synthetic */ PayManager f3134;

    public C1100(PayManager r1) {
        this.f3134 = r1;
    }

    /* renamed from: ֏ */
    public void mo7862(boolean z, String str) {
        "QrPayCallback " + z + ", " + str;
        PayManager r0 = this.f3134;
        C0678.m1732(z, str, r0.f856, r0.f857);
    }
}
