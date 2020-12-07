package com.wpengapp.support;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.wpengapp.support.ຝ */
/* compiled from: Okio */
class C1222 implements Source {

    /* renamed from: ֏ */
    public final /* synthetic */ C1166 f3492;

    /* renamed from: ؠ */
    public final /* synthetic */ InputStream f3493;

    public C1222(C1166 r1, InputStream inputStream) {
        this.f3492 = r1;
        this.f3493 = inputStream;
    }

    public void close() {
        this.f3493.close();
    }

    public String toString() {
        return outline.m2546(outline.m2549("source("), (Object) this.f3493, ")");
    }

    /* renamed from: ؠ */
    public long mo8055(Buffer r4, long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (i == 0) {
            return 0;
        } else {
            try {
                this.f3492.mo9112();
                Segment r0 = r4.mo9195(1);
                int read = this.f3493.read(r0.f3328, r0.f3330, (int) Math.min(j, (long) (8192 - r0.f3330)));
                if (read == -1) {
                    return -1;
                }
                r0.f3330 += read;
                long j2 = (long) read;
                r4.f2997 += j2;
                return j2;
            } catch (AssertionError e) {
                if (C0745.m1953(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }
    }

    /* renamed from: ؠ */
    public C1166 mo7988() {
        return this.f3492;
    }
}
