package com.wpengapp.support;

import java.io.InputStream;

/* renamed from: com.wpengapp.support.ಒ */
/* compiled from: Buffer */
class C1162 extends InputStream {

    /* renamed from: ֏ */
    public final /* synthetic */ Buffer f3301;

    public C1162(Buffer r1) {
        this.f3301 = r1;
    }

    public int available() {
        return (int) Math.min(this.f3301.f2997, 2147483647L);
    }

    public void close() {
    }

    public int read() {
        Buffer r0 = this.f3301;
        if (r0.f2997 > 0) {
            return r0.readByte() & 255;
        }
        return -1;
    }

    public String toString() {
        return outline.m2546(new StringBuilder(), (Object) this.f3301, ".inputStream()");
    }

    public int read(byte[] bArr, int i, int i2) {
        return this.f3301.mo9189(bArr, i, i2);
    }
}
