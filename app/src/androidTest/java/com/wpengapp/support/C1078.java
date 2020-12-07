package com.wpengapp.support;

import android.app.ProgressDialog;
import com.wpengapp.support.licensing.activity.InputContactActivity;

/* renamed from: com.wpengapp.support.ৱ */
/* compiled from: AppOrderHandler */
class C1078 implements UseAppCodeListener {

    /* renamed from: ֏ */
    public final /* synthetic */ ProgressDialog f3055;

    /* renamed from: ؠ */
    public final /* synthetic */ InputContactActivity f3056;

    /* renamed from: ހ */
    public final /* synthetic */ C0747 f3057;

    public C1078(C0747 r1, ProgressDialog progressDialog, InputContactActivity inputContactActivity) {
        this.f3057 = r1;
        this.f3055 = progressDialog;
        this.f3056 = inputContactActivity;
    }

    /* renamed from: ֏ */
    public void mo8519(boolean z, String str, ErrorCode r5) {
        this.f3055.dismiss();
        if (z) {
            this.f3056.finish();
            C0826.m2172(R$string.wpengpay_app_code_use_success, new Object[0]);
            this.f3057.f1925.mo8519(z, str, r5);
        } else if (r5 == ErrorCode.APP_CODE_USED) {
            C0747 r3 = this.f3057;
            r3.f1926.mo9296(this.f3056, r3.f1925);
        } else {
            C0826.m2177((CharSequence) str);
        }
    }
}
