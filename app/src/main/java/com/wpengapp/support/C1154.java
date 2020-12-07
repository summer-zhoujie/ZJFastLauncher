package com.wpengapp.support;

import java.io.Closeable;

/* renamed from: com.wpengapp.support.ம */
/* compiled from: ResponseBody */
public abstract class C1154 implements Closeable {
    /* renamed from: ֏ */
    public static C1154 m3095(MediaType r3, byte[] bArr) {
        Buffer r0 = new Buffer();
        r0.write(bArr);
        return new ResponseBody(r3, (long) bArr.length, r0);
    }

    public void close() {
        Util.m946((Closeable) mo7908());
    }

    /* renamed from: އ */
    public abstract long mo7906();

    /* renamed from: ވ */
    public abstract MediaType mo7907();

    /* renamed from: މ */
    public abstract BufferedSource mo7908();
}
