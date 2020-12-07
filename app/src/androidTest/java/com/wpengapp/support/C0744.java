package com.wpengapp.support;

import android.app.ProgressDialog;

/* renamed from: com.wpengapp.support.ӌ */
/* compiled from: AppOrderHandler */
class C0744 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C1114 f1919;

    public C0744(C1114 r1) {
        this.f1919 = r1;
    }

    public void run() {
        C1114 r0 = this.f1919;
        String string = r0.f3170.getString(R$string.pw_wait);
        if (r0.f3169 == null) {
            r0.f3169 = new ProgressDialog(r0.f3170);
            r0.f3169.setMessage(string);
            r0.f3169.setCancelable(false);
        }
        C0936.m2467(r0.f3169);
    }
}
