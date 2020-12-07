package com.wpengapp.support;

import com.wpengapp.support.C0837;

/* renamed from: com.wpengapp.support.ˬ */
class FloatBall implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ byte f1552;

    /* renamed from: ؠ */
    public final /* synthetic */ byte f1553;

    /* renamed from: ހ */
    public final /* synthetic */ C0837 f1554;

    public FloatBall(C0837 r1, byte b, byte b2) {
        this.f1554 = r1;
        this.f1552 = b;
        this.f1553 = b2;
    }

    public void run() {
        C0837.C0839 r0 = (C0837.C0839) this.f1554.f2201.get(this.f1552);
        if (r0 != null) {
            r0.f2218 = this.f1553;
        }
    }
}
