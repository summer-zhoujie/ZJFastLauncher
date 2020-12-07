package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ੲ */
public final class TMemoryInputTransport extends TTransport {

    /* renamed from: ֏ */
    public byte[] f3111;

    /* renamed from: ؠ */
    public int f3112;

    /* renamed from: ހ */
    public int f3113;

    /* renamed from: ֏ */
    public byte[] mo8018() {
        return this.f3111;
    }

    /* renamed from: ؠ */
    public void mo9278(byte[] bArr) {
        int length = bArr.length;
        this.f3111 = bArr;
        this.f3112 = 0;
        this.f3113 = 0 + length;
    }

    /* renamed from: ހ */
    public int mo8021() {
        return this.f3113 - this.f3112;
    }

    /* renamed from: ֏ */
    public int mo8015(byte[] bArr, int i, int i2) {
        int i3 = this.f3113 - this.f3112;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i2 > 0) {
            System.arraycopy(this.f3111, this.f3112, bArr, i, i2);
            this.f3112 += i2;
        }
        return i2;
    }

    /* renamed from: ֏ */
    public void mo8016(int i) {
        this.f3112 += i;
    }

    /* renamed from: ؠ */
    public void mo8020(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    /* renamed from: ؠ */
    public int mo8019() {
        return this.f3112;
    }
}
