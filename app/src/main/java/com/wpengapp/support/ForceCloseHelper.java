package com.wpengapp.support;

import android.view.View;

/* renamed from: com.wpengapp.support.Ղ */
class ForceCloseHelper implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ FloatWindow f2017;

    public ForceCloseHelper(C1022 r1, FloatWindow r2) {
        this.f2017 = r2;
    }

    public void onClick(View view) {
        Utils.m1906(view.getContext());
        this.f2017.mo9027();
    }
}
