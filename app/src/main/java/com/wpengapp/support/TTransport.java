package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Ũ */
public abstract class TTransport {
    /* renamed from: ֏ */
    public abstract int mo8015(byte[] bArr, int i, int i2);

    /* renamed from: ֏ */
    public void mo8016(int i) {
    }

    /* renamed from: ֏ */
    public void mo8017(byte[] bArr) {
        mo8020(bArr, 0, bArr.length);
    }

    /* renamed from: ֏ */
    public byte[] mo8018() {
        return null;
    }

    /* renamed from: ؠ */
    public int mo8019() {
        return 0;
    }

    /* renamed from: ؠ */
    public abstract void mo8020(byte[] bArr, int i, int i2);

    /* renamed from: ހ */
    public int mo8021() {
        return -1;
    }

    /* renamed from: ހ */
    public int mo8022(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int r1 = mo8015(bArr, i + i3, i2 - i3);
            if (r1 > 0) {
                i3 += r1;
            } else {
                throw new TTransportException("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
        }
        return i3;
    }
}
