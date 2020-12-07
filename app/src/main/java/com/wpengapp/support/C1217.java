package com.wpengapp.support;

import java.io.IOException;

/* renamed from: com.wpengapp.support.ທ */
/* compiled from: AsyncTimeout */
public class C1217 implements Source {

    /* renamed from: ֏ */
    public final /* synthetic */ Source f3474;

    /* renamed from: ؠ */
    public final /* synthetic */ AsyncTimeout f3475;

    public C1217(AsyncTimeout r1, Source r2) {
        this.f3475 = r1;
        this.f3474 = r2;
    }

    public void close() {
        try {
            this.f3474.close();
            this.f3475.mo8138(true);
        } catch (IOException e) {
            e = e;
            AsyncTimeout r1 = this.f3475;
            if (r1.mo8140()) {
                e = r1.mo8136(e);
            }
            throw e;
        } catch (Throwable th) {
            this.f3475.mo8138(false);
            throw th;
        }
    }

    public String toString() {
        return outline.m2546(outline.m2549("AsyncTimeout.source("), (Object) this.f3474, ")");
    }

    /* renamed from: ؠ */
    public long mo8055(Buffer r2, long j) {
        this.f3475.mo8139();
        try {
            long r22 = this.f3474.mo8055(r2, j);
            this.f3475.mo8138(true);
            return r22;
        } catch (IOException e) {
            e = e;
            AsyncTimeout r3 = this.f3475;
            if (r3.mo8140()) {
                e = r3.mo8136(e);
            }
            throw e;
        } catch (Throwable th) {
            this.f3475.mo8138(false);
            throw th;
        }
    }

    /* renamed from: ؠ */
    public C1166 mo7988() {
        return this.f3475;
    }
}
