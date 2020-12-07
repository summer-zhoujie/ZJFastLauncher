package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import java.io.InputStream;
import java.util.Locale;

/* renamed from: com.wpengapp.support.ۦ */
public interface ImageDownloader {

    /* renamed from: com.wpengapp.support.ۦ$֏ */
    /* compiled from: ImageDownloader */
    public enum C0912 {
        HTTP("http"),
        HTTPS("https"),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN(BidiFormatter.EMPTY_STRING);
        

        /* renamed from: ކ */
        public String f2456;

        /* renamed from: އ */
        public String f2457;

        /* access modifiers changed from: public */
        C0912(String str) {
            this.f2456 = str;
            this.f2457 = outline.m2556(str, "://");
        }

        /* renamed from: ހ */
        public static C0912 m2393(String str) {
            if (str != null) {
                for (C0912 r3 : values()) {
                    if (r3.mo8891(str)) {
                        return r3;
                    }
                }
            }
            return UNKNOWN;
        }

        /* renamed from: ֏ */
        public final boolean mo8891(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.f2457);
        }

        /* renamed from: ؠ */
        public String mo8892(String str) {
            if (mo8891(str)) {
                return str.substring(this.f2457.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[]{str, this.f2456}));
        }

        /* renamed from: ށ */
        public String mo8893(String str) {
            return outline.m2548(new StringBuilder(), this.f2457, str);
        }
    }

    /* renamed from: ֏ */
    InputStream mo8094(String str, Object obj);
}
