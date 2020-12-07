package com.wpengapp.support;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.wpengapp.support.ҥ */
/* compiled from: Util */
class C0733 implements ThreadFactory {

    /* renamed from: ֏ */
    public final /* synthetic */ String f1900;

    /* renamed from: ؠ */
    public final /* synthetic */ boolean f1901;

    public C0733(String str, boolean z) {
        this.f1900 = str;
        this.f1901 = z;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f1900);
        thread.setDaemon(this.f1901);
        return thread;
    }
}
