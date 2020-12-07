package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ഒ */
public final class Segment {

    /* renamed from: ֏ */
    public final byte[] f3328;

    /* renamed from: ؠ */
    public int f3329;

    /* renamed from: ހ */
    public int f3330;

    /* renamed from: ށ */
    public boolean f3331;

    /* renamed from: ނ */
    public boolean f3332;

    /* renamed from: ރ */
    public Segment f3333;

    /* renamed from: ބ */
    public Segment f3334;

    public Segment() {
        this.f3328 = new byte[8192];
        this.f3332 = true;
        this.f3331 = false;
    }

    /* renamed from: ֏ */
    public final Segment mo9380() {
        Segment r0 = this.f3333;
        if (r0 == this) {
            r0 = null;
        }
        Segment r2 = this.f3334;
        r2.f3333 = this.f3333;
        this.f3333.f3334 = r2;
        this.f3333 = null;
        this.f3334 = null;
        return r0;
    }

    /* renamed from: ؠ */
    public final Segment mo9384() {
        this.f3331 = true;
        return new Segment(this.f3328, this.f3329, this.f3330, true, false);
    }

    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f3328 = bArr;
        this.f3329 = i;
        this.f3330 = i2;
        this.f3331 = z;
        this.f3332 = z2;
    }

    /* renamed from: ֏ */
    public final Segment mo9382(Segment r2) {
        r2.f3334 = this;
        r2.f3333 = this.f3333;
        this.f3333.f3334 = r2;
        this.f3333 = r2;
        return r2;
    }

    /* renamed from: ֏ */
    public final Segment mo9381(int i) {
        Segment r0;
        if (i <= 0 || i > this.f3330 - this.f3329) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            r0 = mo9384();
        } else {
            r0 = SegmentPool.m1853();
            System.arraycopy(this.f3328, this.f3329, r0.f3328, 0, i);
        }
        r0.f3330 = r0.f3329 + i;
        this.f3329 += i;
        this.f3334.mo9382(r0);
        return r0;
    }

    /* renamed from: ֏ */
    public final void mo9383(Segment r5, int i) {
        if (r5.f3332) {
            int i2 = r5.f3330;
            if (i2 + i > 8192) {
                if (!r5.f3331) {
                    int i3 = r5.f3329;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = r5.f3328;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        r5.f3330 -= r5.f3329;
                        r5.f3329 = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f3328, this.f3329, r5.f3328, r5.f3330, i);
            r5.f3330 += i;
            this.f3329 += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
