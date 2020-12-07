package com.wpengapp.support;

import android.view.View;

/* renamed from: com.wpengapp.support.ː */
class BaseActivity implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.baseui.BaseActivity f1543;

    public BaseActivity(com.wpengapp.baseui.BaseActivity baseActivity) {
        this.f1543 = baseActivity;
    }

    public void onClick(View view) {
        try {
            this.f1543.onBackPressed();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
