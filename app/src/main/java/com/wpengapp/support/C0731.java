package com.wpengapp.support;

import com.wpengapp.xposed.sdk.LaunchService;

/* renamed from: com.wpengapp.support.ҙ */
/* compiled from: lambda */
public final /* synthetic */ class C0731 implements Runnable {

    /* renamed from: ֏ */
    private final /* synthetic */ LaunchService f1888;

    public /* synthetic */ C0731(LaunchService launchService) {
        this.f1888 = launchService;
    }

    public final void run() {
        this.f1888.stopSelf();
    }
}
