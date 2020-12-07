package com.wpengapp.support;

import android.os.Process;

/* renamed from: com.wpengapp.support.ஃ */
/* compiled from: lambda */
public final /* synthetic */ class C1148 implements Runnable {

    /* renamed from: ֏ */
    public static final /* synthetic */ C1148 f3268 = new C1148();

    private /* synthetic */ C1148() {
    }

    public final void run() {
        Process.killProcess(Process.myPid());
    }
}
