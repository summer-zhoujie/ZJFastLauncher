package com.wpengapp.support;

import android.widget.Toast;

/* renamed from: com.wpengapp.support.З */
class UIUtils implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ CharSequence f1789;

    public UIUtils(CharSequence charSequence) {
        this.f1789 = charSequence;
    }

    public void run() {
        Toast makeText = Toast.makeText(AppUtils.getApplication(), this.f1789, 0);
        SafeToastHooker.m2640(makeText);
        makeText.show();
    }
}
