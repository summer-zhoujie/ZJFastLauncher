package com.wpengapp.support;

import android.widget.Toast;

/* renamed from: com.wpengapp.support.ड़ */
/* compiled from: UIUtils */
class C1039 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ CharSequence f2989;

    public C1039(CharSequence charSequence) {
        this.f2989 = charSequence;
    }

    public void run() {
        Toast makeText = Toast.makeText(AppUtils.getApplication(), this.f2989, 1);
        SafeToastHooker.m2640(makeText);
        makeText.show();
    }
}
