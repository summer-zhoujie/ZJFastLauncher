package com.wpengapp.support;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.wpengapp.support.ʳ */
class StrictLineReader extends ByteArrayOutputStream {

    /* renamed from: ֏ */
    public final /* synthetic */ C0612 f1387;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StrictLineReader(C0612 r1, int i) {
        super(i);
        this.f1387 = r1;
    }

    public String toString() {
        int i = this.count;
        try {
            return new String(this.buf, 0, (i <= 0 || this.buf[i + -1] != 13) ? this.count : i - 1, this.f1387.f1457.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
