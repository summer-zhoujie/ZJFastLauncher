package com.wpengapp.support;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.wpengapp.support.Ƴ */
public class AppSetupListActivity implements TextWatcher {

    /* renamed from: ֏ */
    public final /* synthetic */ Runnable f957;

    public AppSetupListActivity(com.wpengapp.lightstart.activity.AppSetupListActivity appSetupListActivity, Runnable runnable) {
        this.f957 = runnable;
    }

    public void afterTextChanged(Editable editable) {
        AppUtils.m1152(this.f957);
        AppUtils.m1147(this.f957, 500);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
