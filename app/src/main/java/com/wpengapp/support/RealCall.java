package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Ā */
class RealCall extends AsyncTimeout {

    /* renamed from: ވ */
    public final /* synthetic */ C1140 f725;

    public RealCall(C1140 r1) {
        this.f725 = r1;
    }

    /* renamed from: ކ */
    public void mo7905() {
        RetryAndFollowUpInterceptor r0 = this.f725.f3234;
        r0.f3250 = true;
        StreamAllocation r02 = r0.f3248;
        if (r02 != null) {
            r02.mo8922();
        }
    }
}
