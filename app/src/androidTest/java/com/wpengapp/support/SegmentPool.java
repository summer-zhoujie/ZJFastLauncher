package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Ҟ */
public final class SegmentPool {

    /* renamed from: ֏ */
    public static Segment f1894;

    /* renamed from: ؠ */
    public static long f1895;

    /* renamed from: ֏ */
    public static Segment m1853() {
        synchronized (SegmentPool.class) {
            if (f1894 == null) {
                return new Segment();
            }
            Segment r1 = f1894;
            f1894 = r1.f3333;
            r1.f3333 = null;
            f1895 -= 8192;
            return r1;
        }
    }

    /* renamed from: ֏ */
    public static void m1854(Segment r8) {
        if (r8.f3333 != null || r8.f3334 != null) {
            throw new IllegalArgumentException();
        } else if (!r8.f3331) {
            synchronized (SegmentPool.class) {
                if (f1895 + 8192 <= 65536) {
                    f1895 += 8192;
                    r8.f3333 = f1894;
                    r8.f3330 = 0;
                    r8.f3329 = 0;
                    f1894 = r8;
                }
            }
        }
    }
}
