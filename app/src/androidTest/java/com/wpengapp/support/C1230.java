package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ອ */
/* compiled from: AccTask */
class C1230 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ AccTask f3504;

    public C1230(AccTask r1) {
        this.f3504 = r1;
    }

    public void run() {
        TaskCallback r0 = this.f3504.f2430;
        if (r0 != null) {
            r0.error();
        }
    }
}
