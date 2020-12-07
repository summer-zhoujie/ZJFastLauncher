package com.wpengapp.support;

import com.wpengapp.support.Interceptor;

/* renamed from: com.wpengapp.support.α */
public final class ConnectInterceptor implements Interceptor {

    /* renamed from: ֏ */
    public final C0844 f1653;

    public ConnectInterceptor(C0844 r1) {
        this.f1653 = r1;
    }

    /* renamed from: ֏ */
    public Response mo7909(C1094 r6) {
        RealInterceptorChain r0 = (RealInterceptorChain) r6;
        Request r1 = r0.f3287;
        StreamAllocation r2 = r0.f3283;
        return r0.mo9348(r1, r2, r2.mo8920(this.f1653, r6, !r1.f2365.equals("GET")), r2.mo8927());
    }
}
