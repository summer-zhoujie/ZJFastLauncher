package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ŏ */
public abstract class ForwardingSource implements Source {

    /* renamed from: ֏ */
    public final Source f829;

    public ForwardingSource(Source r2) {
        if (r2 != null) {
            this.f829 = r2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f829.toString() + ")";
    }

    /* renamed from: ؠ */
    public C1166 mo7988() {
        return this.f829.mo7988();
    }
}
