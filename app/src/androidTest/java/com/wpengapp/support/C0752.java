package com.wpengapp.support;

import java.io.IOException;

/* renamed from: com.wpengapp.support.ӧ */
/* compiled from: Http2Connection */
class C0752 extends NamedRunnable {

    /* renamed from: ؠ */
    public final /* synthetic */ int f1937;

    /* renamed from: ހ */
    public final /* synthetic */ C1193 f1938;

    /* renamed from: ށ */
    public final /* synthetic */ C0586 f1939;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0752(C0586 r1, String str, Object[] objArr, int i, C1193 r5) {
        super(str, objArr);
        this.f1939 = r1;
        this.f1937 = i;
        this.f1938 = r5;
    }

    /* renamed from: ֏ */
    public void mo8071() {
        try {
            C0586 r0 = this.f1939;
            r0.f1295.mo9450(this.f1937, this.f1938);
        } catch (IOException unused) {
            this.f1939.mo8242();
        }
    }
}
