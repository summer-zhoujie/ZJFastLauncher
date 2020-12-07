package com.wpengapp.support;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: com.wpengapp.support.ʾ */
/* compiled from: StrictLineReader */
public class C0612 implements Closeable {

    /* renamed from: ֏ */
    public final InputStream f1456;

    /* renamed from: ؠ */
    public final Charset f1457;

    /* renamed from: ހ */
    public byte[] f1458;

    /* renamed from: ށ */
    public int f1459;

    /* renamed from: ނ */
    public int f1460;

    public C0612(InputStream inputStream, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (charset.equals(C0613.f1461)) {
            this.f1456 = inputStream;
            this.f1457 = charset;
            this.f1458 = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() {
        synchronized (this.f1456) {
            if (this.f1458 != null) {
                this.f1458 = null;
                this.f1456.close();
            }
        }
    }

    /* renamed from: އ */
    public final void mo8309() {
        InputStream inputStream = this.f1456;
        byte[] bArr = this.f1458;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f1459 = 0;
            this.f1460 = read;
            return;
        }
        throw new EOFException();
    }

    /* renamed from: ވ */
    public String mo8310() {
        int i;
        int i2;
        synchronized (this.f1456) {
            if (this.f1458 != null) {
                if (this.f1459 >= this.f1460) {
                    mo8309();
                }
                for (int i3 = this.f1459; i3 != this.f1460; i3++) {
                    if (this.f1458[i3] == 10) {
                        if (i3 != this.f1459) {
                            i2 = i3 - 1;
                            if (this.f1458[i2] == 13) {
                                String str = new String(this.f1458, this.f1459, i2 - this.f1459, this.f1457.name());
                                this.f1459 = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f1458, this.f1459, i2 - this.f1459, this.f1457.name());
                        this.f1459 = i3 + 1;
                        return str2;
                    }
                }
                StrictLineReader r1 = new StrictLineReader(this, (this.f1460 - this.f1459) + 80);
                loop1:
                while (true) {
                    r1.write(this.f1458, this.f1459, this.f1460 - this.f1459);
                    this.f1460 = -1;
                    mo8309();
                    i = this.f1459;
                    while (true) {
                        if (i != this.f1460) {
                            if (this.f1458[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f1459) {
                    r1.write(this.f1458, this.f1459, i - this.f1459);
                }
                this.f1459 = i + 1;
                String r12 = r1.toString();
                return r12;
            }
            throw new IOException("LineReader is closed");
        }
    }
}
