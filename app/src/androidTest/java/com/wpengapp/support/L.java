package com.wpengapp.support;

import android.util.Log;

/* renamed from: com.wpengapp.support.ו */
public final class L {

    /* renamed from: ֏ */
    public static volatile boolean f2134 = false;

    /* renamed from: ؠ */
    public static volatile boolean f2135 = true;

    /* renamed from: ֏ */
    public static void m2159(String str, Object... objArr) {
        if (f2134) {
            m2158(3, (Throwable) null, str, objArr);
        }
    }

    /* renamed from: ؠ */
    public static void m2161(String str, Object... objArr) {
        m2158(6, (Throwable) null, str, objArr);
    }

    /* renamed from: ހ */
    public static void m2162(String str, Object... objArr) {
        m2158(5, (Throwable) null, str, objArr);
    }

    /* renamed from: ֏ */
    public static void m2160(Throwable th) {
        m2158(6, th, (String) null, new Object[0]);
    }

    /* renamed from: ֏ */
    public static void m2158(int i, Throwable th, String str, Object... objArr) {
        if (f2135) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format("%1$s\n%2$s", new Object[]{str, Log.getStackTraceString(th)});
            }
            Log.println(i, C0619.f1546, str);
        }
    }
}
