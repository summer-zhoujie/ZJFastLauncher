package com.wpengapp.support;

/* renamed from: com.wpengapp.support.т */
/* compiled from: FloatBall */
public class C0708 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ float f1823;

    /* renamed from: ؠ */
    public final /* synthetic */ float f1824;

    /* renamed from: ހ */
    public final /* synthetic */ float f1825;

    /* renamed from: ށ */
    public final /* synthetic */ C0837 f1826;

    public C0708(C0837 r1, float f, float f2, float f3) {
        this.f1826 = r1;
        this.f1823 = f;
        this.f1824 = f2;
        this.f1825 = f3;
    }

    public void run() {
        this.f1826.f2182.mo9027();
        this.f1826.f2184.setScaleX(this.f1823);
        this.f1826.f2184.setScaleY(this.f1824);
        this.f1826.f2184.setAlpha(this.f1825);
    }
}
