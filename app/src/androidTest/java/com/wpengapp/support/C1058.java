package com.wpengapp.support;

/* renamed from: com.wpengapp.support.থ */
/* compiled from: UMCCAggregatedListObject */
class C1058 extends Callback {

    /* renamed from: a */
    public final /* synthetic */ Callback f3023a;

    /* renamed from: ֏ */
    public final /* synthetic */ UMCCAggregatedListObject f3024;

    public C1058(UMCCAggregatedListObject r1, Callback r2) {
        this.f3024 = r1;
        this.f3023a = r2;
    }

    /* renamed from: a */
    public void mo7310a(Object obj, boolean z) {
        UMCCAggregatedObject r2 = (UMCCAggregatedObject) obj;
        this.f3024.f912.remove(Utils.m1869(r2.f3178));
        this.f3024.f912.put(r2.f3178, r2);
        this.f3023a.mo7310a(this, false);
    }
}
