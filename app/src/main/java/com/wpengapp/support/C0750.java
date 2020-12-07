package com.wpengapp.support;

import android.os.Bundle;

/* renamed from: com.wpengapp.support.ӟ */
/* compiled from: lambda */
public final /* synthetic */ class C0750 implements Runnable {

    /* renamed from: ֏ */
    private final /* synthetic */ Bundle f1933;

    public /* synthetic */ C0750(Bundle bundle) {
        this.f1933 = bundle;
    }

    public final void run() {
        C0488.m1089(Long.valueOf(this.f1933.getLong("id", -1)), this.f1933.getString("app"));
    }
}
