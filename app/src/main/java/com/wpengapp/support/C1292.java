package com.wpengapp.support;

import android.app.ProgressDialog;
import com.wpengapp.support.licensing.activity.InputContactActivity;

/* renamed from: com.wpengapp.support.ဧ */
/* compiled from: CheckDeviceManager */
class C1292 implements InputContactActivity.C0453 {

    /* renamed from: ֏ */
    public final /* synthetic */ UserInfo f3638;

    public C1292(UserInfo r1) {
        this.f3638 = r1;
    }

    /* renamed from: ֏ */
    public void mo7857(String str, boolean z, InputContactActivity inputContactActivity) {
        ProgressDialog progressDialog = new ProgressDialog(inputContactActivity);
        progressDialog.setMessage(inputContactActivity.getString(R$string.pw_wait));
        progressDialog.setCancelable(false);
        C0936.m2467(progressDialog);
        C1307.m3559(this.f3638, str, (RetCallback) new C0481(this, progressDialog, inputContactActivity));
    }
}
