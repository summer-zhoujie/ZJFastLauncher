package com.wpengapp.support;

import android.text.TextUtils;
import com.wpengapp.support.C1063;

/* renamed from: com.wpengapp.support.ε */
/* compiled from: SkipTexts */
public class C0647 {

    /* renamed from: ֏ */
    public static final String[] f1656 = {"跳过", "Skip".toLowerCase(), "略過", "跳過"};

    /* renamed from: ؠ */
    public static final String[] f1657 = {"Splash".toLowerCase(), "Welcome".toLowerCase(), "Adver".toLowerCase()};

    /* renamed from: ހ */
    public static String[] f1658;

    /* renamed from: ށ */
    public static String[] f1659;

    /* renamed from: ނ */
    public static String[] f1660;

    /* renamed from: ރ */
    public static String[] f1661;

    /* renamed from: ބ */
    public static Integer f1662 = null;

    /* renamed from: ޅ */
    public static C1063.C1065 f1663 = new SkipTexts();

    static {
        C1063.C1065 r0 = f1663;
        C1063.f3038.put(r0, r0);
    }

    /* renamed from: ֏ */
    public static String[] m1654() {
        String[] strArr;
        String[] strArr2 = f1661;
        if (strArr2 != null) {
            return strArr2;
        }
        String r0 = C1063.m2859("skad_report_texts", (String) null);
        if (TextUtils.isEmpty(r0)) {
            strArr = new String[0];
        } else {
            strArr = r0.toLowerCase().split(",");
        }
        f1661 = strArr;
        return strArr;
    }

    /* renamed from: ؠ */
    public static String[] m1655() {
        String[] strArr = f1660;
        if (strArr != null) {
            return strArr;
        }
        String r1 = C1063.m2859("skad_skip_ids", (String) null);
        if (TextUtils.isEmpty(r1)) {
            f1660 = null;
        } else {
            f1660 = r1.toLowerCase().split(",");
        }
        return f1660;
    }

    /* renamed from: ހ */
    public static String[] m1656() {
        String[] strArr;
        String[] strArr2 = f1658;
        if (strArr2 != null) {
            return strArr2;
        }
        String r0 = C1063.m2859("skad_skip_texts", (String) null);
        if (TextUtils.isEmpty(r0)) {
            strArr = f1656;
        } else {
            strArr = r0.toLowerCase().split(",");
        }
        f1658 = strArr;
        return strArr;
    }

    /* renamed from: ֏ */
    public static boolean m1653(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        int lastIndexOf = lowerCase.lastIndexOf(".");
        if (lastIndexOf > -1) {
            lowerCase = lowerCase.substring(lastIndexOf + 1);
        }
        String[] strArr = f1659;
        if (strArr == null) {
            String r0 = C1063.m2859("skad_splash_texts", (String) null);
            if (TextUtils.isEmpty(r0)) {
                strArr = f1657;
            } else {
                strArr = r0.toLowerCase().split(",");
            }
            f1659 = strArr;
        }
        for (String contains : strArr) {
            if (lowerCase.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
