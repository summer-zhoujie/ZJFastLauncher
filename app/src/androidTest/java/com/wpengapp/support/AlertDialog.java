package com.wpengapp.support;

import android.app.Dialog;
import android.content.Context;

/* renamed from: com.wpengapp.support.Ǐ */
public class AlertDialog extends Dialog implements IDialog {
    public AlertDialog(Context context, int i) {
        super(context, i);
    }

    public void show() {
        try {
            super.show();
        } catch (Exception e) {
            e.getMessage();
        }
        DialogLifecycleCallbacks.m1408(this);
    }
}
