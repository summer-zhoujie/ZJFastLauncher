package com.wpengapp.support;

import java.lang.reflect.Array;

/* renamed from: com.wpengapp.support.ႁ */
public final class BarcodeMatrix {

    /* renamed from: ֏ */
    public final BarcodeRow[] f3691;

    /* renamed from: ؠ */
    public int f3692;

    /* renamed from: ހ */
    public final int f3693;

    /* renamed from: ށ */
    public final int f3694;

    public BarcodeMatrix(int i, int i2) {
        this.f3691 = new BarcodeRow[i];
        int length = this.f3691.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f3691[i3] = new BarcodeRow(((i2 + 4) * 17) + 1);
        }
        this.f3694 = i2 * 17;
        this.f3693 = i;
        this.f3692 = -1;
    }

    /* renamed from: ֏ */
    public BarcodeRow mo9551() {
        return this.f3691[this.f3692];
    }

    /* renamed from: ֏ */
    public byte[][] mo9552(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{this.f3693 * i2, this.f3694 * i});
        int i3 = this.f3693 * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i3 - i4) - 1;
            BarcodeRow r5 = this.f3691[i4 / i2];
            byte[] bArr2 = new byte[(r5.f3695.length * i)];
            for (int i6 = 0; i6 < bArr2.length; i6++) {
                bArr2[i6] = r5.f3695[i6 / i];
            }
            bArr[i5] = bArr2;
        }
        return bArr;
    }
}
