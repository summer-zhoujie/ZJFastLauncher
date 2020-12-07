package com.wpengapp.support;

import android.app.ProgressDialog;
import com.wpengapp.baseui.BaseActivity;

/* renamed from: com.wpengapp.support.ւ */
/* compiled from: BaseActivity */
class C0814 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ String f2102;

    /* renamed from: ؠ */
    public final /* synthetic */ BaseActivity f2103;

    public C0814(BaseActivity baseActivity, String str) {
        this.f2103 = baseActivity;
        this.f2102 = str;
    }

    public void run() {
        if (this.f2103.f273 == null) {
            synchronized ("BaseActivity") {
                if (this.f2103.f273 == null) {
                    this.f2103.f273 = new ProgressDialog(this.f2103);
                    this.f2103.f273.setCancelable(false);
                }
            }
        }
        if (this.f2103.mo7429()) {
            try {
                this.f2103.f273.setMessage(this.f2102);
                this.f2103.f273.show();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
