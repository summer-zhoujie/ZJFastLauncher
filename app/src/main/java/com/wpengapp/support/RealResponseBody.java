package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ߐ */
public final class RealResponseBody extends C1154 {

    /* renamed from: ֏ */
    public final String f2691;

    /* renamed from: ؠ */
    public final long f2692;

    /* renamed from: ހ */
    public final BufferedSource f2693;

    public RealResponseBody(String str, long j, BufferedSource r4) {
        this.f2691 = str;
        this.f2692 = j;
        this.f2693 = r4;
    }

    /* renamed from: އ */
    public long mo7906() {
        return this.f2692;
    }

    /* renamed from: ވ */
    public MediaType mo7907() {
        String str = this.f2691;
        if (str != null) {
            return MediaType.m2279(str);
        }
        return null;
    }

    /* renamed from: މ */
    public BufferedSource mo7908() {
        return this.f2693;
    }
}
