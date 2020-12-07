package com.wpengapp.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.wpengapp.support.Ԑ */
public class TIOStreamTransport extends TTransport {

    /* renamed from: ֏ */
    public InputStream f1973 = null;

    /* renamed from: ؠ */
    public OutputStream f1974 = null;

    public TIOStreamTransport(OutputStream outputStream) {
        this.f1974 = outputStream;
    }

    /* renamed from: ֏ */
    public int mo8015(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.f1973;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new TTransportException(4);
            } catch (IOException e) {
                throw new TTransportException(0, (Throwable) e);
            }
        } else {
            throw new TTransportException(1, "Cannot read from null inputStream");
        }
    }

    /* renamed from: ؠ */
    public void mo8020(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f1974;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e) {
                throw new TTransportException(0, (Throwable) e);
            }
        } else {
            throw new TTransportException(1, "Cannot write to null outputStream");
        }
    }
}
