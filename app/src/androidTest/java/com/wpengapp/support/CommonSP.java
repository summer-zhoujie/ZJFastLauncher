package com.wpengapp.support;

import android.content.SharedPreferences;

/* renamed from: com.wpengapp.support.ơ */
public class CommonSP {

    /* renamed from: ֏ */
    public static final SharedPreferences f935 = AppUtils.m1149("wpecom");

    /* renamed from: ֏ */
    public static SharedPreferences.Editor m1229() {
        return f935.edit();
    }

    /* renamed from: ֏ */
    public static long m1228(String str, long j) {
        return f935.getLong(str, j);
    }
}
