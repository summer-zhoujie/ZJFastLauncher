package com.wpengapp.support;

import android.app.Dialog;
import android.os.Build;

/* renamed from: com.wpengapp.support.ถ */
/* compiled from: DialogUtils */
public final class C1186 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Dialog f3377;

    public C1186(Dialog dialog) {
        this.f3377 = dialog;
    }

    public void run() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f3377.getWindow().setType(2038);
            } else {
                this.f3377.getWindow().setType(2003);
            }
            this.f3377.show();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
