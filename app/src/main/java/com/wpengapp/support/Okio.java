package com.wpengapp.support;

import java.io.OutputStream;

/* renamed from: com.wpengapp.support.ŋ */
public final class Okio implements Sink {

    /* renamed from: ֏ */
    public final /* synthetic */ C1166 f825;

    /* renamed from: ؠ */
    public final /* synthetic */ OutputStream f826;

    public Okio(C1166 r1, OutputStream outputStream) {
        this.f825 = r1;
        this.f826 = outputStream;
    }

    public void close() {
        this.f826.close();
    }

    public void flush() {
        this.f826.flush();
    }

    public String toString() {
        return outline.m2546(outline.m2549("sink("), (Object) this.f826, ")");
    }

    /* renamed from: ֏ */
    public void mo7985(Buffer r7, long j) {
        C0751.m1966(r7.f2997, 0, j);
        while (j > 0) {
            this.f825.mo9112();
            Segment r0 = r7.f2996;
            int min = (int) Math.min(j, (long) (r0.f3330 - r0.f3329));
            this.f826.write(r0.f3328, r0.f3329, min);
            r0.f3329 += min;
            long j2 = (long) min;
            j -= j2;
            r7.f2997 -= j2;
            if (r0.f3329 == r0.f3330) {
                r7.f2996 = r0.mo9380();
                SegmentPool.m1854(r0);
            }
        }
    }

    /* renamed from: ؠ */
    public C1166 mo7986() {
        return this.f825;
    }
}
