package com.wpengapp.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* renamed from: com.wpengapp.support.ӑ */
/* compiled from: Okio */
public final class C0745 {

    /* renamed from: ֏ */
    public static final Logger f1920 = Logger.getLogger(C0745.class.getName());

    /* renamed from: ֏ */
    public static BufferedSource m1951(Source r1) {
        return new C0697(r1);
    }

    /* renamed from: ؠ */
    public static Source m1954(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            C0546 r0 = new C0546(socket);
            return new C1217(r0, m1949(socket.getInputStream(), r0));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    /* renamed from: ֏ */
    public static BufferedSink m1950(Sink r1) {
        return new RealBufferedSink(r1);
    }

    /* renamed from: ֏ */
    public static Sink m1952(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            C0546 r0 = new C0546(socket);
            OutputStream outputStream = socket.getOutputStream();
            if (outputStream != null) {
                return new C1144(r0, new Okio(r0, outputStream));
            }
            throw new IllegalArgumentException("out == null");
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    /* renamed from: ֏ */
    public static Source m1948(InputStream inputStream) {
        return m1949(inputStream, new C1166());
    }

    /* renamed from: ֏ */
    public static Source m1949(InputStream inputStream, C1166 r2) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (r2 != null) {
            return new C1222(r2, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: ֏ */
    public static boolean m1953(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
