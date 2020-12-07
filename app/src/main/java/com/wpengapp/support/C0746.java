package com.wpengapp.support;

import java.io.IOException;

/* renamed from: com.wpengapp.support.ӓ */
/* compiled from: Http2Connection */
class C0746 extends NamedRunnable {

    /* renamed from: ؠ */
    public final /* synthetic */ int f1921;

    /* renamed from: ހ */
    public final /* synthetic */ long f1922;

    /* renamed from: ށ */
    public final /* synthetic */ C0586 f1923;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0746(C0586 r1, String str, Object[] objArr, int i, long j) {
        super(str, objArr);
        this.f1923 = r1;
        this.f1921 = i;
        this.f1922 = j;
    }

    /* renamed from: ֏ */
    public void mo8071() {
        try {
            this.f1923.f1295.mo9449(this.f1921, this.f1922);
        } catch (IOException unused) {
            this.f1923.mo8242();
        }
    }
}
