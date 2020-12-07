package com.wpengapp.support;

import java.io.IOException;
import java.util.List;

/* renamed from: com.wpengapp.support.Ҹ */
/* compiled from: Http2Connection */
class C0740 extends NamedRunnable {

    /* renamed from: ؠ */
    public final /* synthetic */ int f1909;

    /* renamed from: ހ */
    public final /* synthetic */ List f1910;

    /* renamed from: ށ */
    public final /* synthetic */ boolean f1911;

    /* renamed from: ނ */
    public final /* synthetic */ C0586 f1912;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0740(C0586 r1, String str, Object[] objArr, int i, List list, boolean z) {
        super(str, objArr);
        this.f1912 = r1;
        this.f1909 = i;
        this.f1910 = list;
        this.f1911 = z;
    }

    /* renamed from: ֏ */
    public void mo8071() {
        ((C0798) this.f1912.f1288).mo8689(this.f1909, this.f1910, this.f1911);
        try {
            this.f1912.f1295.mo9450(this.f1909, C1193.CANCEL);
            synchronized (this.f1912) {
                this.f1912.f1297.remove(Integer.valueOf(this.f1909));
            }
        } catch (IOException unused) {
        }
    }
}
