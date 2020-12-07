package com.wpengapp.support;

import android.app.ProgressDialog;

/* renamed from: com.wpengapp.support.ė */
class WpAlipay implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ boolean f772;

    /* renamed from: ؠ */
    public final /* synthetic */ String f773;

    /* renamed from: ހ */
    public final /* synthetic */ C0768 f774;

    public WpAlipay(C0768 r1, boolean z, String str) {
        this.f774 = r1;
        this.f772 = z;
        this.f773 = str;
    }

    public void run() {
        ProgressDialog progressDialog = this.f774.f1977.f3734;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        WpAlipayCallback r0 = this.f774.f1976;
        if (r0 != null) {
            r0.mo8503(this.f772, this.f773);
        }
    }
}
