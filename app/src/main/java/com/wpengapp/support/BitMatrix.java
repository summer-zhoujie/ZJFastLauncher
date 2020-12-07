package com.wpengapp.support;

import java.util.Arrays;

/* renamed from: com.wpengapp.support.ࢥ */
public final class BitMatrix implements Cloneable {

    /* renamed from: ֏ */
    public final int f2830;

    /* renamed from: ؠ */
    public final int f2831;

    /* renamed from: ހ */
    public final int f2832;

    /* renamed from: ށ */
    public final int[] f2833;

    public BitMatrix(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f2830 = i;
        this.f2831 = i2;
        this.f2832 = (i + 31) / 32;
        this.f2833 = new int[(this.f2832 * i2)];
    }

    public Object clone() {
        return new BitMatrix(this.f2830, this.f2831, this.f2832, (int[]) this.f2833.clone());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix r4 = (BitMatrix) obj;
        if (this.f2830 == r4.f2830 && this.f2831 == r4.f2831 && this.f2832 == r4.f2832 && Arrays.equals(this.f2833, r4.f2833)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f2830;
        return Arrays.hashCode(this.f2833) + (((((((i * 31) + i) * 31) + this.f2831) * 31) + this.f2832) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f2830 + 1) * this.f2831);
        for (int i = 0; i < this.f2831; i++) {
            for (int i2 = 0; i2 < this.f2830; i2++) {
                sb.append(mo9092(i2, i) ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: ֏ */
    public boolean mo9092(int i, int i2) {
        return ((this.f2833[(i / 32) + (i2 * this.f2832)] >>> (i & 31)) & 1) != 0;
    }

    /* renamed from: ؠ */
    public void mo9094(int i, int i2) {
        int i3 = (i / 32) + (i2 * this.f2832);
        int[] iArr = this.f2833;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    /* renamed from: ֏ */
    public void mo9090() {
        int length = this.f2833.length;
        for (int i = 0; i < length; i++) {
            this.f2833[i] = 0;
        }
    }

    /* renamed from: ؠ */
    public int mo9093() {
        return this.f2831;
    }

    /* renamed from: ֏ */
    public void mo9091(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.f2831 || i5 > this.f2830) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.f2832 * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f2833;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.f2830 = i;
        this.f2831 = i2;
        this.f2832 = i3;
        this.f2833 = iArr;
    }
}
