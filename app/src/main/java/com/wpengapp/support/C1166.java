package com.wpengapp.support;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ಳ */
/* compiled from: Timeout */
public class C1166 {

    /* renamed from: ֏ */
    public static final C1166 f3323 = new Timeout();

    /* renamed from: ؠ */
    public boolean f3324;

    /* renamed from: ހ */
    public long f3325;

    /* renamed from: ށ */
    public long f3326;

    /* renamed from: ֏ */
    public C1166 mo9111(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit != null) {
            this.f3326 = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    /* renamed from: ؠ */
    public C1166 mo9211() {
        this.f3326 = 0;
        return this;
    }

    /* renamed from: ހ */
    public long mo9212() {
        if (this.f3324) {
            return this.f3325;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: ށ */
    public boolean mo9213() {
        return this.f3324;
    }

    /* renamed from: ނ */
    public void mo9112() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f3324 && this.f3325 - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    /* renamed from: ֏ */
    public C1166 mo9110(long j) {
        this.f3324 = true;
        this.f3325 = j;
        return this;
    }

    /* renamed from: ֏ */
    public C1166 mo9210() {
        this.f3324 = false;
        return this;
    }
}
