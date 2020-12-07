package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ࢧ */
public final class GenericGF {

    /* renamed from: ֏ */
    public static final GenericGF f2866 = new GenericGF(4201, 4096, 1);

    /* renamed from: ؠ */
    public static final GenericGF f2867 = new GenericGF(1033, 1024, 1);

    /* renamed from: ހ */
    public static final GenericGF f2868 = new GenericGF(67, 64, 1);

    /* renamed from: ށ */
    public static final GenericGF f2869 = new GenericGF(19, 16, 1);

    /* renamed from: ނ */
    public static final GenericGF f2870 = new GenericGF(285, 256, 0);

    /* renamed from: ރ */
    public static final GenericGF f2871 = new GenericGF(301, 256, 1);

    /* renamed from: ބ */
    public final int[] f2872;

    /* renamed from: ޅ */
    public final int[] f2873;

    /* renamed from: ކ */
    public final GenericGFPoly f2874;

    /* renamed from: އ */
    public final int f2875;

    /* renamed from: ވ */
    public final int f2876;

    /* renamed from: މ */
    public final int f2877;

    static {
        GenericGF r0 = f2868;
    }

    public GenericGF(int i, int i2, int i3) {
        this.f2876 = i;
        this.f2875 = i2;
        this.f2877 = i3;
        this.f2872 = new int[i2];
        this.f2873 = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f2872[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f2873[this.f2872[i6]] = i6;
        }
        this.f2874 = new GenericGFPoly(this, new int[]{0});
        int[] iArr = {1};
        if (iArr.length != 0) {
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i7 = 1;
                while (i7 < length && iArr[i7] == 0) {
                    i7++;
                }
                if (i7 == length) {
                    new int[1][0] = 0;
                    return;
                }
                int[] iArr2 = new int[(length - i7)];
                System.arraycopy(iArr, i7, iArr2, 0, iArr2.length);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: ֏ */
    public static int m2675(int i, int i2) {
        return i ^ i2;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f2876) + ',' + this.f2875 + ')';
    }

    /* renamed from: ֏ */
    public int mo9096(int i) {
        if (i != 0) {
            return this.f2872[(this.f2875 - this.f2873[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* renamed from: ؠ */
    public GenericGFPoly mo9098(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f2874;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new GenericGFPoly(this, iArr);
        }
    }

    /* renamed from: ހ */
    public int mo9099(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f2872;
        int[] iArr2 = this.f2873;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f2875 - 1)];
    }

    /* renamed from: ؠ */
    public int mo9097(int i) {
        if (i != 0) {
            return this.f2873[i];
        }
        throw new IllegalArgumentException();
    }
}
