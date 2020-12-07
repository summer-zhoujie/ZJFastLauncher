package com.wpengapp.support;

import android.app.KeyguardManager;

/* renamed from: com.wpengapp.support.হ */
/* compiled from: lambda */
public final /* synthetic */ class C1072 implements Runnable {

    /* renamed from: ֏ */
    private final /* synthetic */ KeyguardManager.KeyguardLock f3047;

    public /* synthetic */ C1072(KeyguardManager.KeyguardLock keyguardLock) {
        this.f3047 = keyguardLock;
    }

    public final void run() {
        NotificationEventHandler.m994(this.f3047);
    }
}
