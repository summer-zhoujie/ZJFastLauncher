package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import java.util.Formatter;

/* renamed from: com.wpengapp.support.Ь */
public class MLog {

    /* renamed from: ֏ */
    public static boolean f1804 = false;

    /* renamed from: ؠ */
    public static String f1805 = "MobclickAgent";

    /* renamed from: ֏ */
    public static void m1771(String str, Object... objArr) {
        String str2 = BidiFormatter.EMPTY_STRING;
        try {
            if (str.contains("%")) {
                m1770(f1805, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = objArr[0];
            }
            m1770(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m1772(th);
        }
    }

    /* renamed from: ؠ */
    public static void m1775(String str, Object... objArr) {
        String str2 = BidiFormatter.EMPTY_STRING;
        try {
            if (str.contains("%")) {
                m1777(f1805, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = objArr[0];
            }
            m1777(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m1772(th);
        }
    }

    /* renamed from: ހ */
    public static void m1778(String str, Object... objArr) {
        String str2 = BidiFormatter.EMPTY_STRING;
        try {
            if (str.contains("%")) {
                m1774(f1805, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = objArr[0];
            }
            m1774(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m1772(th);
        }
    }

    /* renamed from: ֏ */
    public static void m1772(Throwable th) {
        m1777(f1805, (String) null, th);
    }

    /* renamed from: ؠ */
    public static void m1773(String str) {
        m1774(f1805, str, (Throwable) null);
    }

    /* renamed from: ހ */
    public static void m1776(String str) {
        m1777(f1805, str, (Throwable) null);
    }

    /* renamed from: ֏ */
    public static void m1769(String str) {
        m1770(f1805, str, (Throwable) null);
    }

    /* renamed from: ؠ */
    public static void m1774(String str, String str2, Throwable th) {
        if (f1804 && th != null) {
            if (str2 != null) {
                try {
                    th.toString() + ":  [" + str2 + "]";
                } catch (Throwable unused) {
                    return;
                }
            } else {
                th.toString();
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                "        at  " + stackTraceElement.toString();
            }
        }
    }

    /* renamed from: ހ */
    public static void m1777(String str, String str2, Throwable th) {
        if (f1804 && th != null) {
            if (str2 != null) {
                try {
                    th.toString() + ":  [" + str2 + "]";
                } catch (Throwable unused) {
                    return;
                }
            } else {
                th.toString();
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                "        at  " + stackTraceElement.toString();
            }
        }
    }

    /* renamed from: ֏ */
    public static void m1770(String str, String str2, Throwable th) {
        if (f1804 && th != null) {
            if (str2 != null) {
                try {
                    th.toString() + ":  [" + str2 + "]";
                } catch (Throwable unused) {
                    return;
                }
            } else {
                th.toString();
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                "        at  " + stackTraceElement.toString();
            }
        }
    }
}
