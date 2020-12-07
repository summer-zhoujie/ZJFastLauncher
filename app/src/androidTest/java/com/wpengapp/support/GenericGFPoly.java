package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ࢨ */
public final class GenericGFPoly {

    /* renamed from: ֏ */
    public final GenericGF f2878;

    /* renamed from: ؠ */
    public final int[] f2879;

    public GenericGFPoly(GenericGF r5, int[] iArr) {
        if (iArr.length != 0) {
            this.f2878 = r5;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f2879 = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f2879 = new int[]{0};
                return;
            }
            this.f2879 = new int[(length - i)];
            int[] iArr2 = this.f2879;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(mo9101() * 8);
        for (int r1 = mo9101(); r1 >= 0; r1--) {
            int r2 = mo9102(r1);
            if (r2 != 0) {
                if (r2 < 0) {
                    sb.append(" - ");
                    r2 = -r2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (r1 == 0 || r2 != 1) {
                    int r22 = this.f2878.mo9097(r2);
                    if (r22 == 0) {
                        sb.append('1');
                    } else if (r22 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(r22);
                    }
                }
                if (r1 != 0) {
                    if (r1 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(r1);
                    }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: ֏ */
    public int mo9101() {
        return this.f2879.length - 1;
    }

    /* renamed from: ؠ */
    public boolean mo9105() {
        return this.f2879[0] == 0;
    }

    /* renamed from: ֏ */
    public int mo9102(int i) {
        int[] iArr = this.f2879;
        return iArr[(iArr.length - 1) - i];
    }

    /* renamed from: ֏ */
    public GenericGFPoly mo9104(GenericGFPoly r8) {
        if (!this.f2878.equals(r8.f2878)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (mo9105()) {
            return r8;
        } else {
            if (r8.mo9105()) {
                return this;
            }
            int[] iArr = this.f2879;
            int[] iArr2 = r8.f2879;
            if (iArr.length > iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr4[i] = GenericGF.m2675(iArr[i - length], iArr2[i]);
            }
            return new GenericGFPoly(this.f2878, iArr4);
        }
    }

    /* renamed from: ֏ */
    public GenericGFPoly mo9103(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f2878.f2874;
        } else {
            int length = this.f2879.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f2878.mo9099(this.f2879[i3], i2);
            }
            return new GenericGFPoly(this.f2878, iArr);
        }
    }
}
