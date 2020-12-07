package com.wpengapp.support;

import java.util.Arrays;

/* renamed from: com.wpengapp.support.ࢤ */
public final class BitArray implements Cloneable {

    /* renamed from: ֏ */
    public int[] f2828;

    /* renamed from: ؠ */
    public int f2829;

    public BitArray() {
        this.f2829 = 0;
        this.f2828 = new int[1];
    }

    public Object clone() {
        return new BitArray((int[]) this.f2828.clone(), this.f2829);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray r4 = (BitArray) obj;
        if (this.f2829 != r4.f2829 || !Arrays.equals(this.f2828, r4.f2828)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f2828) + (this.f2829 * 31);
    }

    public String toString() {
        int i = this.f2829;
        StringBuilder sb = new StringBuilder((i / 8) + i + 1);
        for (int i2 = 0; i2 < this.f2829; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(mo9085(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    /* renamed from: ֏ */
    public int mo9080() {
        return (this.f2829 + 7) / 8;
    }

    /* renamed from: ؠ */
    public boolean mo9085(int i) {
        return ((1 << (i & 31)) & this.f2828[i / 32]) != 0;
    }

    /* renamed from: ֏ */
    public final void mo9081(int i) {
        int[] iArr = this.f2828;
        if (i > (iArr.length << 5)) {
            int[] iArr2 = new int[((i + 31) / 32)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f2828 = iArr2;
        }
    }

    public BitArray(int[] iArr, int i) {
        this.f2828 = iArr;
        this.f2829 = i;
    }

    /* renamed from: ֏ */
    public void mo9084(boolean z) {
        mo9081(this.f2829 + 1);
        if (z) {
            int[] iArr = this.f2828;
            int i = this.f2829;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f2829++;
    }

    /* renamed from: ֏ */
    public void mo9082(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        mo9081(this.f2829 + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            mo9084(z);
            i2--;
        }
    }

    /* renamed from: ֏ */
    public void mo9083(BitArray r4) {
        int i = r4.f2829;
        mo9081(this.f2829 + i);
        for (int i2 = 0; i2 < i; i2++) {
            mo9084(r4.mo9085(i2));
        }
    }
}
