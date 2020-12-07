package com.wpengapp.support;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: com.wpengapp.support.ਟ */
public interface BufferedSource extends Source, ReadableByteChannel {
    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    short readShort();

    void skip(long j);

    /* renamed from: ֏ */
    long mo8484(byte b);

    /* renamed from: ֏ */
    ByteString mo8486(long j);

    /* renamed from: ֏ */
    Buffer mo8487();

    /* renamed from: ֏ */
    String mo8488(Charset charset);

    /* renamed from: ֏ */
    boolean mo8489(long j, ByteString r3);

    /* renamed from: ؠ */
    String mo8490(long j);

    /* renamed from: ހ */
    byte[] mo8492();

    /* renamed from: ށ */
    boolean mo8493();

    /* renamed from: ށ */
    byte[] mo8494(long j);

    /* renamed from: ނ */
    String mo8495();

    /* renamed from: ނ */
    void mo8496(long j);

    /* renamed from: ރ */
    int mo8497();

    /* renamed from: ބ */
    short mo8498();

    /* renamed from: ޅ */
    long mo8499();

    /* renamed from: ކ */
    InputStream mo8500();
}
