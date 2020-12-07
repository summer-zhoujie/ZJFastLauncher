package com.wpengapp.support;

import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.wpengapp.support.ř */
public class WPengServer {

    /* renamed from: ֏ */
    public static boolean f836 = false;

    /* renamed from: ؠ */
    public static Application f837 = null;

    /* renamed from: ހ */
    public static int f838 = 0;

    /* renamed from: ށ */
    public static String f839 = null;

    /* renamed from: ނ */
    public static String f840 = null;

    /* renamed from: ރ */
    public static String f841 = "-1";

    /* renamed from: ބ */
    public static String f842 = null;

    /* renamed from: ޅ */
    public static String f843 = null;

    /* renamed from: ކ */
    public static String f844 = null;

    /* renamed from: އ */
    public static String f845 = "";

    /* renamed from: ވ */
    public static long f846;

    /* renamed from: މ */
    public static long f847;

    /* renamed from: ފ */
    public static final List<C0486> f848 = new CopyOnWriteArrayList();

    /* renamed from: ދ */
    public static boolean f849 = false;

    /* renamed from: ތ */
    public static C0484 f850;

    /* renamed from: ލ */
    public static C0485 f851;

    /* renamed from: com.wpengapp.support.ř$֏ */
    /* compiled from: WPengServer */
    public interface C0484 {
    }

    /* renamed from: com.wpengapp.support.ř$ؠ */
    /* compiled from: WPengServer */
    public interface C0485 {
    }

    /* renamed from: com.wpengapp.support.ř$ހ */
    /* compiled from: WPengServer */
    public interface C0486 {
    }

    /* renamed from: ֏ */
    public static void m1073(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "-1";
        }
        f841 = str;
    }

    /* renamed from: ؠ */
    public static void m1074(String str) {
        C0826.m2180((CharSequence) str);
    }

    /* renamed from: ֏ */
    public static String m1071(int i) {
        return f837.getString(i);
    }

    /* renamed from: ֏ */
    public static long m1070() {
        long j = f846;
        if (j == 0) {
            return System.currentTimeMillis();
        }
        return (SystemClock.elapsedRealtime() + j) - f847;
    }

    /* renamed from: ֏ */
    public static void m1072(C0486 r2, boolean z) {
        synchronized (f848) {
            if (r2 != null) {
                f848.add(r2);
            }
            if (!f849) {
                f849 = true;
                new C0694(ApiConstant.f2707).mo8757(z);
            }
        }
    }
}
