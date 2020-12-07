package com.wpengapp.support;

import android.content.Context;
import com.wpengapp.support.activity.AboutActivity;

/* renamed from: com.wpengapp.support.ϝ */
/* compiled from: AboutActivity */
class C0663 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ AboutActivity f1726;

    public C0663(AboutActivity aboutActivity) {
        this.f1726 = aboutActivity;
    }

    public void run() {
        AboutActivity aboutActivity = this.f1726;
        AboutActivity.C0450 r1 = AboutActivity.f616;
        C0771.m2069((Context) aboutActivity, r1 == null ? null : r1.mo7558());
        this.f1726.mo7430();
    }
}
