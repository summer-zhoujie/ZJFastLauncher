package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ഗ */
/* compiled from: Http2Connection */
class C1168 extends NamedRunnable {

    /* renamed from: ؠ */
    public final /* synthetic */ int f3335;

    /* renamed from: ހ */
    public final /* synthetic */ C1193 f3336;

    /* renamed from: ށ */
    public final /* synthetic */ C0586 f3337;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1168(C0586 r1, String str, Object[] objArr, int i, C1193 r5) {
        super(str, objArr);
        this.f3337 = r1;
        this.f3335 = i;
        this.f3336 = r5;
    }

    /* renamed from: ֏ */
    public void mo8071() {
        ((C0798) this.f3337.f1288).mo8686(this.f3335, this.f3336);
        synchronized (this.f3337) {
            this.f3337.f1297.remove(Integer.valueOf(this.f3335));
        }
    }
}
