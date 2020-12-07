package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ႎ */
public final class BarcodeRow {

    /* renamed from: ֏ */
    public final byte[] f3695;

    /* renamed from: ؠ */
    public int f3696 = 0;

    public BarcodeRow(int i) {
        this.f3695 = new byte[i];
    }

    /* renamed from: ֏ */
    public void mo9553(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f3696;
            this.f3696 = i3 + 1;
            this.f3695[i3] = z ? (byte) 1 : 0;
        }
    }
}
