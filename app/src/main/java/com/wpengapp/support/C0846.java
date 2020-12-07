package com.wpengapp.support;

import android.view.View;

/* renamed from: com.wpengapp.support.ح */
/* compiled from: InputContactActivity */
class C0846 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C1071 f2287;

    public C0846(C1071 r1) {
        this.f2287 = r1;
    }

    public void run() {
        View findFocus = this.f2287.f3046.f678.findFocus();
        this.f2287.f3046.f678.fullScroll(130);
        if (findFocus != null) {
            findFocus.requestFocus();
        }
    }
}
