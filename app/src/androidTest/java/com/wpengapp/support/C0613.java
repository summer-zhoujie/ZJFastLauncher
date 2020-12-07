package com.wpengapp.support;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.wpengapp.support.ʿ */
/* compiled from: Util */
public final class C0613 {

    /* renamed from: ֏ */
    public static final Charset f1461 = Charset.forName("US-ASCII");

    static {
        Charset.forName("UTF-8");
    }

    /* renamed from: ֏ */
    public static void m1534(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    m1534(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    throw new IOException(outline.m2554("failed to delete file: ", (Object) file2));
                }
            }
            return;
        }
        throw new IOException(outline.m2554("not a readable directory: ", (Object) file));
    }

    /* renamed from: ֏ */
    public static void m1533(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
