package com.wpengapp.support;

import android.support.p003v7.widget.ActivityChooserView;
import java.util.List;

/* renamed from: com.wpengapp.support.ȳ */
public final class HttpHeaders {
    static {
        ByteString.m2188("\"\\");
        ByteString.m2188("\t ,=");
    }

    /* renamed from: ֏ */
    public static long m1355(Response r2) {
        String r22 = r2.f1354.mo8178("Content-Length");
        if (r22 == null) {
            return -1;
        }
        try {
            return Long.parseLong(r22);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: ؠ */
    public static boolean m1358(Response r8) {
        if (r8.f1349.f2365.equals("HEAD")) {
            return false;
        }
        int i = r8.f1351;
        if (((i >= 100 && i < 200) || i == 204 || i == 304) && m1355(r8) == -1) {
            String r82 = r8.f1354.mo8178("Transfer-Encoding");
            if (r82 == null) {
                r82 = null;
            }
            if ("chunked".equalsIgnoreCase(r82)) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: ֏ */
    public static void m1356(C1229 r1, HttpUrl r2, Headers r3) {
        if (r1 != C1229.f3503) {
            List<Cookie> r32 = Cookie.m1467(r2, r3);
            if (!r32.isEmpty()) {
                ((CookieJar) r1).mo8210(r2, r32);
            }
        }
    }

    /* renamed from: ֏ */
    public static int m1354(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: ؠ */
    public static int m1357(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == 9)) {
            i++;
        }
        return i;
    }

    /* renamed from: ֏ */
    public static int m1353(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
