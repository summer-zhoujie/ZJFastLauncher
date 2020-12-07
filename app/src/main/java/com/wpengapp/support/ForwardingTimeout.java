package com.wpengapp.support;

import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ঔ */
public class ForwardingTimeout extends C1166 {

    /* renamed from: ނ */
    public C1166 f3011;

    public ForwardingTimeout(C1166 r2) {
        if (r2 != null) {
            this.f3011 = r2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: ֏ */
    public C1166 mo9111(long j, TimeUnit timeUnit) {
        return this.f3011.mo9111(j, timeUnit);
    }

    /* renamed from: ؠ */
    public C1166 mo9211() {
        return this.f3011.mo9211();
    }

    /* renamed from: ހ */
    public long mo9212() {
        return this.f3011.mo9212();
    }

    /* renamed from: ށ */
    public boolean mo9213() {
        return this.f3011.mo9213();
    }

    /* renamed from: ނ */
    public void mo9112() {
        this.f3011.mo9112();
    }

    /* renamed from: ֏ */
    public C1166 mo9110(long j) {
        return this.f3011.mo9110(j);
    }

    /* renamed from: ֏ */
    public C1166 mo9210() {
        return this.f3011.mo9210();
    }
}
