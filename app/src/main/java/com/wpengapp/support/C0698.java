package com.wpengapp.support;

import android.app.Activity;

/* renamed from: com.wpengapp.support.а */
/* compiled from: AppUtils */
class C0698 implements Runnable {
    public void run() {
        for (Activity next : AppUtils.m1154()) {
            if (next != null) {
                next.finish();
            }
        }
    }
}
