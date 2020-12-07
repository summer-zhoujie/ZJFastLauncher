package com.wpengapp.support;

import java.io.InputStream;

/* renamed from: com.wpengapp.support.ۥ */
public class ContentLengthInputStream extends InputStream {

    /* renamed from: ֏ */
    public final InputStream f2446;

    /* renamed from: ؠ */
    public final int f2447;

    public ContentLengthInputStream(InputStream inputStream, int i) {
        this.f2446 = inputStream;
        this.f2447 = i;
    }

    public int available() {
        return this.f2447;
    }

    public void close() {
        this.f2446.close();
    }

    public void mark(int i) {
        this.f2446.mark(i);
    }

    public boolean markSupported() {
        return this.f2446.markSupported();
    }

    public int read() {
        return this.f2446.read();
    }

    public void reset() {
        this.f2446.reset();
    }

    public long skip(long j) {
        return this.f2446.skip(j);
    }

    public int read(byte[] bArr) {
        return this.f2446.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) {
        return this.f2446.read(bArr, i, i2);
    }
}
