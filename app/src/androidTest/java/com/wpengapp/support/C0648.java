package com.wpengapp.support;

import android.app.ProgressDialog;
import com.wpengapp.baseui.BaseActivity;

/* renamed from: com.wpengapp.support.ι */
/* compiled from: BaseActivity */
class C0648 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ BaseActivity f1668;

    public C0648(BaseActivity baseActivity) {
        this.f1668 = baseActivity;
    }

    public void run() {
        ProgressDialog progressDialog = this.f1668.f273;
        if (progressDialog != null) {
            try {
                progressDialog.dismiss();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
