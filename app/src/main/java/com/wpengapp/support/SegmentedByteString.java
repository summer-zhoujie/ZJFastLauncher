package com.wpengapp.support;

import java.util.Arrays;

/* renamed from: com.wpengapp.support.ő */
public final class SegmentedByteString extends ByteString {

    /* renamed from: ރ */
    public final transient byte[][] f830;

    /* renamed from: ބ */
    public final transient int[] f831;

    public SegmentedByteString(Buffer r8, int i) {
        super((byte[]) null);
        C0751.m1966(r8.f2997, 0, (long) i);
        int i2 = 0;
        Segment r3 = r8.f2996;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = r3.f3330;
            int i6 = r3.f3329;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                r3 = r3.f3333;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f830 = new byte[i4][];
        this.f831 = new int[(i4 * 2)];
        Segment r0 = r8.f2996;
        int i7 = 0;
        while (i2 < i) {
            this.f830[i7] = r0.f3328;
            i2 += r0.f3330 - r0.f3329;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f831;
            iArr[i7] = i2;
            iArr[this.f830.length + i7] = r0.f3329;
            r0.f3331 = true;
            i7++;
            r0 = r0.f3333;
        }
    }

    private Object writeReplace() {
        return mo8006();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString r5 = (ByteString) obj;
            if (r5.mo8002() != mo8002() || !mo7996(0, r5, 0, mo8002())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f2165;
        if (i != 0) {
            return i;
        }
        int length = this.f830.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f830[i2];
            int[] iArr = this.f831;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f2165 = i3;
        return i3;
    }

    public String toString() {
        return mo8006().toString();
    }

    /* renamed from: ֏ */
    public String mo7994() {
        return mo8006().mo7994();
    }

    /* renamed from: ؠ */
    public String mo7999() {
        return mo8006().mo7999();
    }

    /* renamed from: ހ */
    public ByteString mo8000() {
        return mo8006().mo8000();
    }

    /* renamed from: ށ */
    public ByteString mo8001() {
        return mo8006().mo8001();
    }

    /* renamed from: ނ */
    public int mo8002() {
        return this.f831[this.f830.length - 1];
    }

    /* renamed from: ރ */
    public ByteString mo8003() {
        return mo8006().mo8003();
    }

    /* renamed from: ބ */
    public byte[] mo8004() {
        int[] iArr = this.f831;
        byte[][] bArr = this.f830;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f831;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f830[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* renamed from: ޅ */
    public String mo8005() {
        return mo8006().mo8005();
    }

    /* renamed from: ކ */
    public final ByteString mo8006() {
        return new ByteString(mo8004());
    }

    /* renamed from: ֏ */
    public ByteString mo7993(int i, int i2) {
        return mo8006().mo7993(i, i2);
    }

    /* renamed from: ؠ */
    public final int mo7998(int i) {
        int binarySearch = Arrays.binarySearch(this.f831, 0, this.f830.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    /* renamed from: ֏ */
    public byte mo7992(int i) {
        int i2;
        C0751.m1966((long) this.f831[this.f830.length - 1], (long) i, 1);
        int r0 = mo7998(i);
        if (r0 == 0) {
            i2 = 0;
        } else {
            i2 = this.f831[r0 - 1];
        }
        int[] iArr = this.f831;
        byte[][] bArr = this.f830;
        return bArr[r0][(i - i2) + iArr[bArr.length + r0]];
    }

    /* renamed from: ֏ */
    public void mo7995(Buffer r12) {
        int length = this.f830.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f831;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            Segment r5 = new Segment(this.f830[i], i3, (i3 + i4) - i2, true, false);
            Segment r2 = r12.f2996;
            if (r2 == null) {
                r5.f3334 = r5;
                r5.f3333 = r5;
                r12.f2996 = r5;
            } else {
                r2.f3334.mo9382(r5);
            }
            i++;
            i2 = i4;
        }
        r12.f2997 += (long) i2;
    }

    /* renamed from: ֏ */
    public boolean mo7996(int i, ByteString r9, int i2, int i3) {
        int i4;
        if (i < 0 || i > mo8002() - i3) {
            return false;
        }
        int r1 = mo7998(i);
        while (i3 > 0) {
            if (r1 == 0) {
                i4 = 0;
            } else {
                i4 = this.f831[r1 - 1];
            }
            int min = Math.min(i3, ((this.f831[r1] - i4) + i4) - i);
            int[] iArr = this.f831;
            byte[][] bArr = this.f830;
            if (!r9.mo7997(i2, bArr[r1], (i - i4) + iArr[bArr.length + r1], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            r1++;
        }
        return true;
    }

    /* renamed from: ֏ */
    public boolean mo7997(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > mo8002() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int r1 = mo7998(i);
        while (i3 > 0) {
            if (r1 == 0) {
                i4 = 0;
            } else {
                i4 = this.f831[r1 - 1];
            }
            int min = Math.min(i3, ((this.f831[r1] - i4) + i4) - i);
            int[] iArr = this.f831;
            byte[][] bArr2 = this.f830;
            if (!C0751.m1968(bArr2[r1], (i - i4) + iArr[bArr2.length + r1], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            r1++;
        }
        return true;
    }
}
