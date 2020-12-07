package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ก */
/* compiled from: TaskManager */
public final class C1176 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Runnable f3354;

    public C1176(Runnable runnable) {
        this.f3354 = runnable;
    }

    public void run() {
        try {
            this.f3354.run();
        } catch (Throwable th) {
            TaskManager.m2716(th);
        }
    }
}
