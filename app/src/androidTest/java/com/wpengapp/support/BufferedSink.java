package com.wpengapp.support;

import java.nio.channels.WritableByteChannel;

/* renamed from: com.wpengapp.support.ǡ */
public interface BufferedSink extends Sink, WritableByteChannel {
    void flush();

    BufferedSink write(byte[] bArr);

    BufferedSink writeByte(int i);

    BufferedSink writeInt(int i);

    BufferedSink writeShort(int i);

    /* renamed from: ֏ */
    BufferedSink mo8111(String str);

    /* renamed from: ֏ */
    Buffer mo8112();

    /* renamed from: ހ */
    BufferedSink mo8113(long j);
}
