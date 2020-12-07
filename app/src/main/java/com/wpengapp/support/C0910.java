package com.wpengapp.support;

import java.io.IOException;
import java.util.List;

/* renamed from: com.wpengapp.support.ے */
/* compiled from: Http2Connection */
class C0910 extends NamedRunnable {

    /* renamed from: ؠ */
    public final /* synthetic */ int f2443;

    /* renamed from: ހ */
    public final /* synthetic */ List f2444;

    /* renamed from: ށ */
    public final /* synthetic */ C0586 f2445;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0910(C0586 r1, String str, Object[] objArr, int i, List list) {
        super(str, objArr);
        this.f2445 = r1;
        this.f2443 = i;
        this.f2444 = list;
    }

    /* renamed from: ֏ */
    public void mo8071() {
        ((C0798) this.f2445.f1288).mo8688(this.f2443, (List<Header>) this.f2444);
        try {
            this.f2445.f1295.mo9450(this.f2443, C1193.CANCEL);
            synchronized (this.f2445) {
                this.f2445.f1297.remove(Integer.valueOf(this.f2443));
            }
        } catch (IOException unused) {
        }
    }
}
