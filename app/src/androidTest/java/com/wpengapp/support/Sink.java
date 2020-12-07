package com.wpengapp.support;

import java.io.Closeable;
import java.io.Flushable;

/* renamed from: com.wpengapp.support.อ */
public interface Sink extends Closeable, Flushable {
    void close();

    void flush();

    /* renamed from: ֏ */
    void mo7985(Buffer r1, long j);

    /* renamed from: ؠ */
    C1166 mo7986();
}
