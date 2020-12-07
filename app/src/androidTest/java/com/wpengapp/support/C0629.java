package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ͽ */
/* compiled from: AccTaskManager */
public final class C0629 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ AccTask f1604;

    public C0629(AccTask r1) {
        this.f1604 = r1;
    }

    public void run() {
        if (!this.f1604.mo8878()) {
            StringBuilder r0 = outline.m2549("[Task Timeout]: ");
            r0.append(this.f1604);
            r0.toString();
        }
        this.f1604.mo8877();
        C0840.m2248();
    }
}
