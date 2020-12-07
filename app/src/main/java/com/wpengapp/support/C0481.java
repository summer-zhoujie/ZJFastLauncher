package com.wpengapp.support;

import android.app.ProgressDialog;
import com.wpengapp.support.licensing.activity.InputContactActivity;

/* renamed from: com.wpengapp.support.ō */
/* compiled from: CheckDeviceManager */
class C0481 implements RetCallback<Boolean> {

    /* renamed from: ֏ */
    public final /* synthetic */ ProgressDialog f827;

    /* renamed from: ؠ */
    public final /* synthetic */ InputContactActivity f828;

    public C0481(C1292 r1, ProgressDialog progressDialog, InputContactActivity inputContactActivity) {
        this.f827 = progressDialog;
        this.f828 = inputContactActivity;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        Boolean bool = (Boolean) obj;
        C0536.m1326();
        C0678.m1734(1);
        this.f827.dismiss();
        this.f828.finish();
        C0826.m2172(R$string.wpengpay_is_full, new Object[0]);
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        this.f827.dismiss();
        C0826.m2177((CharSequence) str);
    }
}
