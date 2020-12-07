package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ມ */
/* compiled from: PayManager */
class C1224 implements QueryCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ Runnable f3495;

    /* renamed from: ؠ */
    public final /* synthetic */ Runnable f3496;

    public C1224(C1067 r1, Runnable runnable, Runnable runnable2) {
        this.f3495 = runnable;
        this.f3496 = runnable2;
    }

    /* renamed from: ֏ */
    public void mo8024(C1114 r1, boolean z, boolean z2, int i) {
        if (!z || !r1.f3172.mo8705()) {
            this.f3496.run();
        } else {
            this.f3495.run();
        }
    }
}
