package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Ⴎ */
/* compiled from: UMCCAggregatedManager */
class C1306 extends Callback {

    /* renamed from: a */
    public final /* synthetic */ Callback f3735a;

    /* renamed from: ֏ */
    public final /* synthetic */ C1315 f3736;

    public C1306(C1315 r1, Callback r2) {
        this.f3736 = r1;
        this.f3735a = r2;
    }

    /* renamed from: a */
    public void mo7310a(Object obj, boolean z) {
        if (obj instanceof UMCCAggregatedListObject) {
            this.f3736.f3759 = (UMCCAggregatedListObject) obj;
        }
        this.f3735a.mo7310a("success", false);
    }
}
