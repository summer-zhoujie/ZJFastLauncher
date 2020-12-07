package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;

/* renamed from: com.wpengapp.support.ଚ */
/* compiled from: AppOrderHandler */
class C1125 implements QueryCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ UseAppCodeListener f3193;

    /* renamed from: ؠ */
    public final /* synthetic */ String f3194;

    /* renamed from: ހ */
    public final /* synthetic */ C1114 f3195;

    public C1125(C1114 r1, UseAppCodeListener r2, String str) {
        this.f3195 = r1;
        this.f3193 = r2;
        this.f3194 = str;
    }

    /* renamed from: ֏ */
    public void mo8024(C1114 r1, boolean z, boolean z2, int i) {
        if (!z) {
            this.f3195.mo9297((OnDialogClickListener) new C1117(this), (OnDialogClickListener) new C1045(this));
        } else if (z2) {
            C0826.m2179(R$string.wpengpay_app_code_use_success, new Object[0]);
            this.f3193.mo8519(true, BidiFormatter.EMPTY_STRING, ErrorCode.SUCCESS);
        } else {
            this.f3195.mo9298(this.f3194, this.f3193);
        }
    }
}
