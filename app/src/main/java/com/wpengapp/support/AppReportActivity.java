package com.wpengapp.support;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.wpengapp.support.ך */
public class AppReportActivity implements TextWatcher {

    /* renamed from: ֏ */
    public final /* synthetic */ Runnable f2143;

    public AppReportActivity(com.wpengapp.lightstart.activity.AppReportActivity appReportActivity, Runnable runnable) {
        this.f2143 = runnable;
    }

    public void afterTextChanged(Editable editable) {
        AppUtils.m1152(this.f2143);
        AppUtils.m1147(this.f2143, 500);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
