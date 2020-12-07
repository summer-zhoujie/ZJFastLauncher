package com.wpengapp.support;

import java.lang.reflect.Array;

/* renamed from: com.wpengapp.support.ˇ */
public final class ByteMatrix {

    /* renamed from: ֏ */
    public final byte[][] f1501;

    /* renamed from: ؠ */
    public final int f1502;

    /* renamed from: ހ */
    public final int f1503;

    public ByteMatrix(int i, int i2) {
        this.f1501 = (byte[][]) Array.newInstance(byte.class, new int[]{i2, i});
        this.f1502 = i;
        this.f1503 = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f1502 * 2 * this.f1503) + 2);
        for (int i = 0; i < this.f1503; i++) {
            byte[] bArr = this.f1501[i];
            for (int i2 = 0; i2 < this.f1502; i2++) {
                byte b = bArr[i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }

    /* renamed from: ֏ */
    public byte mo8340(int i, int i2) {
        return this.f1501[i2][i];
    }

    /* renamed from: ֏ */
    public void mo8341(int i, int i2, int i3) {
        this.f1501[i2][i] = (byte) i3;
    }

    /* renamed from: ֏ */
    public void mo8342(int i, int i2, boolean z) {
        this.f1501[i2][i] = z ? (byte) 1 : 0;
    }
}
