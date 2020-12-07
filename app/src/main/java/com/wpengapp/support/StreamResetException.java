package com.wpengapp.support;

import java.io.IOException;

/* renamed from: com.wpengapp.support.Ѱ */
public final class StreamResetException extends IOException {

    /* renamed from: ֏ */
    public final C1193 f1865;

    public StreamResetException(C1193 r2) {
        super(outline.m2554("stream was reset: ", (Object) r2));
        this.f1865 = r2;
    }
}
