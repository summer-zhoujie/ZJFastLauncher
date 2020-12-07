package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Պ */
/* compiled from: PayManager */
class C0785 implements QueryCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ Runnable f2033;

    /* renamed from: ؠ */
    public final /* synthetic */ Runnable f2034;

    public C0785(C0904 r1, Runnable runnable, Runnable runnable2) {
        this.f2033 = runnable;
        this.f2034 = runnable2;
    }

    /* renamed from: ֏ */
    public void mo8024(C1114 r1, boolean z, boolean z2, int i) {
        if (!z || !r1.f3172.mo8705() || !r1.f3172.f2125) {
            this.f2034.run();
        } else {
            this.f2033.run();
        }
    }
}
