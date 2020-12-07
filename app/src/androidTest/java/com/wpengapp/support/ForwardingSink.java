package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ڽ */
public abstract class ForwardingSink implements Sink {

    /* renamed from: ֏ */
    public final Sink f2421;

    public ForwardingSink(Sink r2) {
        if (r2 != null) {
            this.f2421 = r2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() {
        this.f2421.close();
    }

    public void flush() {
        this.f2421.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f2421.toString() + ")";
    }

    /* renamed from: ؠ */
    public C1166 mo7986() {
        return this.f2421.mo7986();
    }
}
