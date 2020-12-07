package com.wpengapp.support;

import android.app.Dialog;

/* renamed from: com.wpengapp.support.ş */
/* compiled from: DialogUtils */
class C0489 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Dialog f867;

    public C0489(Dialog dialog) {
        this.f867 = dialog;
    }

    public void run() {
        try {
            this.f867.dismiss();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
