package com.wpengapp.support;

import android.app.Dialog;

/* renamed from: com.wpengapp.support.ķ */
class DialogUtils implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Dialog f802;

    public DialogUtils(Dialog dialog) {
        this.f802 = dialog;
    }

    public void run() {
        try {
            this.f802.show();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
