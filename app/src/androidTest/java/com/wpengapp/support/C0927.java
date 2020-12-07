package com.wpengapp.support;

import java.io.IOException;

/* renamed from: com.wpengapp.support.ݑ */
/* compiled from: Http2Connection */
class C0927 extends NamedRunnable {

    /* renamed from: ؠ */
    public final /* synthetic */ int f2513;

    /* renamed from: ހ */
    public final /* synthetic */ Buffer f2514;

    /* renamed from: ށ */
    public final /* synthetic */ int f2515;

    /* renamed from: ނ */
    public final /* synthetic */ boolean f2516;

    /* renamed from: ރ */
    public final /* synthetic */ C0586 f2517;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0927(C0586 r1, String str, Object[] objArr, int i, Buffer r5, int i2, boolean z) {
        super(str, objArr);
        this.f2517 = r1;
        this.f2513 = i;
        this.f2514 = r5;
        this.f2515 = i2;
        this.f2516 = z;
    }

    /* renamed from: ֏ */
    public void mo8071() {
        try {
            ((C0798) this.f2517.f1288).mo8687(this.f2513, this.f2514, this.f2515, this.f2516);
            this.f2517.f1295.mo9450(this.f2513, C1193.CANCEL);
            synchronized (this.f2517) {
                this.f2517.f1297.remove(Integer.valueOf(this.f2513));
            }
        } catch (IOException unused) {
        }
    }
}
