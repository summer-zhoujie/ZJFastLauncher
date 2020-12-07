package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ເ */
/* compiled from: FloatBall */
public class C1236 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ float f3508;

    /* renamed from: ؠ */
    public final /* synthetic */ float f3509;

    /* renamed from: ހ */
    public final /* synthetic */ float f3510;

    /* renamed from: ށ */
    public final /* synthetic */ C0837 f3511;

    public C1236(C0837 r1, float f, float f2, float f3) {
        this.f3511 = r1;
        this.f3508 = f;
        this.f3509 = f2;
        this.f3510 = f3;
    }

    public void run() {
        this.f3511.f2182.mo9027();
        this.f3511.f2185.setScaleX(this.f3508);
        this.f3511.f2185.setScaleY(this.f3509);
        this.f3511.f2185.setAlpha(this.f3510);
    }
}
