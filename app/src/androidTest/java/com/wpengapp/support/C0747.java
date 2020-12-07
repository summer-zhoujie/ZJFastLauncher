package com.wpengapp.support;

import android.app.ProgressDialog;
import com.wpengapp.support.licensing.activity.InputContactActivity;

/* renamed from: com.wpengapp.support.Ӗ */
/* compiled from: AppOrderHandler */
class C0747 implements InputContactActivity.C0453 {

    /* renamed from: ֏ */
    public final /* synthetic */ String f1924;

    /* renamed from: ؠ */
    public final /* synthetic */ UseAppCodeListener f1925;

    /* renamed from: ހ */
    public final /* synthetic */ C1114 f1926;

    public C0747(C1114 r1, String str, UseAppCodeListener r3) {
        this.f1926 = r1;
        this.f1924 = str;
        this.f1925 = r3;
    }

    /* renamed from: ֏ */
    public void mo7857(String str, boolean z, InputContactActivity inputContactActivity) {
        ProgressDialog progressDialog = new ProgressDialog(inputContactActivity);
        progressDialog.setMessage(inputContactActivity.getString(R$string.pw_wait));
        progressDialog.setCancelable(false);
        C0936.m2467(progressDialog);
        C0536.m1304(this.f1924, str, new C1078(this, progressDialog, inputContactActivity));
    }
}
