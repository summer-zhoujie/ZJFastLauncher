package com.wpengapp.support;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.wpengapp.support.ȏ */
class RealBufferedSource extends InputStream {

    /* renamed from: ֏ */
    public final /* synthetic */ C0697 f1054;

    public RealBufferedSource(C0697 r1) {
        this.f1054 = r1;
    }

    public int available() {
        C0697 r0 = this.f1054;
        if (!r0.f1808) {
            return (int) Math.min(r0.f1806.f2997, 2147483647L);
        }
        throw new IOException("closed");
    }

    public void close() {
        C0697 r0 = this.f1054;
        if (!r0.f1808) {
            r0.f1808 = true;
            r0.f1807.close();
            r0.f1806.mo9201();
        }
    }

    public int read() {
        C0697 r0 = this.f1054;
        if (!r0.f1808) {
            Buffer r1 = r0.f1806;
            if (r1.f2997 == 0 && r0.f1807.mo8055(r1, 8192) == -1) {
                return -1;
            }
            return this.f1054.f1806.readByte() & 255;
        }
        throw new IOException("closed");
    }

    public String toString() {
        return outline.m2546(new StringBuilder(), (Object) this.f1054, ".inputStream()");
    }

    public int read(byte[] bArr, int i, int i2) {
        if (!this.f1054.f1808) {
            C0751.m1966((long) bArr.length, (long) i, (long) i2);
            C0697 r0 = this.f1054;
            Buffer r1 = r0.f1806;
            if (r1.f2997 == 0 && r0.f1807.mo8055(r1, 8192) == -1) {
                return -1;
            }
            return this.f1054.f1806.mo9189(bArr, i, i2);
        }
        throw new IOException("closed");
    }
}
