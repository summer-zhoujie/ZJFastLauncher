package com.wpengapp.support;

import com.wpengapp.support.Interceptor;
import java.util.List;

/* renamed from: com.wpengapp.support.ய */
public final class RealInterceptorChain implements Interceptor.C1094 {

    /* renamed from: ֏ */
    public final List<Interceptor> f3282;

    /* renamed from: ؠ */
    public final StreamAllocation f3283;

    /* renamed from: ހ */
    public final HttpCodec f3284;

    /* renamed from: ށ */
    public final RealConnection f3285;

    /* renamed from: ނ */
    public final int f3286;

    /* renamed from: ރ */
    public final Request f3287;

    /* renamed from: ބ */
    public final Call f3288;

    /* renamed from: ޅ */
    public final C1318 f3289;

    /* renamed from: ކ */
    public final int f3290;

    /* renamed from: އ */
    public final int f3291;

    /* renamed from: ވ */
    public final int f3292;

    /* renamed from: މ */
    public int f3293;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation r2, HttpCodec r3, RealConnection r4, int i, Request r6, Call r7, C1318 r8, int i2, int i3, int i4) {
        this.f3282 = list;
        this.f3285 = r4;
        this.f3283 = r2;
        this.f3284 = r3;
        this.f3286 = i;
        this.f3287 = r6;
        this.f3288 = r7;
        this.f3289 = r8;
        this.f3290 = i2;
        this.f3291 = i3;
        this.f3292 = i4;
    }

    /* renamed from: ֏ */
    public Response mo9347(Request r4) {
        return mo9348(r4, this.f3283, this.f3284, this.f3285);
    }

    /* renamed from: ֏ */
    public Response mo9348(Request r19, StreamAllocation r20, HttpCodec r21, RealConnection r22) {
        if (this.f3286 < this.f3282.size()) {
            this.f3293++;
            if (this.f3284 == null) {
                Request r10 = r19;
            } else if (!this.f3285.mo8664(r19.f2364)) {
                StringBuilder r3 = outline.m2549("network interceptor ");
                r3.append(this.f3282.get(this.f3286 - 1));
                r3.append(" must retain the same host and port");
                throw new IllegalStateException(r3.toString());
            }
            if (this.f3284 == null || this.f3293 <= 1) {
                String str = " must call proceed() exactly once";
                RealInterceptorChain r4 = new RealInterceptorChain(this.f3282, r20, r21, r22, this.f3286 + 1, r19, this.f3288, this.f3289, this.f3290, this.f3291, this.f3292);
                Interceptor r42 = this.f3282.get(this.f3286);
                Response r5 = r42.mo7909(r4);
                if (r21 != null && this.f3286 + 1 < this.f3282.size() && r4.f3293 != 1) {
                    throw new IllegalStateException(outline.m2544("network interceptor ", (Object) r42, str));
                } else if (r5 == null) {
                    throw new NullPointerException(outline.m2544("interceptor ", (Object) r42, " returned null"));
                } else if (r5.f1355 != null) {
                    return r5;
                } else {
                    throw new IllegalStateException(outline.m2544("interceptor ", (Object) r42, " returned a response with no body"));
                }
            } else {
                StringBuilder r32 = outline.m2549("network interceptor ");
                r32.append(this.f3282.get(this.f3286 - 1));
                r32.append(" must call proceed() exactly once");
                throw new IllegalStateException(r32.toString());
            }
        } else {
            throw new AssertionError();
        }
    }
}
