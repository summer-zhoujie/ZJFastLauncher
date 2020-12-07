package com.wpengapp.support;

import android.app.ProgressDialog;
import com.wpengapp.support.licensing.activity.VerifyContactActivity;

/* renamed from: com.wpengapp.support.ʋ */
/* compiled from: UserRecoveryManager */
class C0595 implements RetCallback<Void> {

    /* renamed from: ֏ */
    public final /* synthetic */ ProgressDialog f1336;

    /* renamed from: ؠ */
    public final /* synthetic */ VerifyContactActivity f1337;

    public C0595(C0870 r1, ProgressDialog progressDialog, VerifyContactActivity verifyContactActivity) {
        this.f1336 = progressDialog;
        this.f1337 = verifyContactActivity;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        Void voidR = (Void) obj;
        C0536.m1326();
        C0678.m1734(1);
        this.f1336.dismiss();
        this.f1337.finish();
        C0826.m2172(R$string.wpengpay_is_full, new Object[0]);
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        this.f1336.dismiss();
        C0826.m2177((CharSequence) str);
    }
}
