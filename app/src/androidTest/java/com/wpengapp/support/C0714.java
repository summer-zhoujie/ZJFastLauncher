package com.wpengapp.support;

import android.os.Bundle;

/* renamed from: com.wpengapp.support.є */
/* compiled from: lambda */
public final /* synthetic */ class C0714 implements Runnable {

    /* renamed from: ֏ */
    private final /* synthetic */ Bundle f1841;

    public /* synthetic */ C0714(Bundle bundle) {
        this.f1841 = bundle;
    }

    public final void run() {
        C0488.m1085(Long.valueOf(this.f1841.getLong("id", -1)), this.f1841.getString("app"));
    }
}
