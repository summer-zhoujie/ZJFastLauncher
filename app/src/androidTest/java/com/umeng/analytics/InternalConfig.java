package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.umeng.analytics.e */
public class InternalConfig {

    /* renamed from: a */
    public static String[] f145a = new String[2];

    /* renamed from: a */
    public static void m114a(Context context, String str, String str2) {
        String[] strArr = f145a;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            StoreHelper.m156a(context).mo7339a(str, str2);
        }
    }

    /* renamed from: b */
    public static void m116b(Context context) {
        String[] strArr = f145a;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            StoreHelper.m156a(context).mo7342b();
        }
    }

    /* renamed from: a */
    public static String[] m115a(Context context) {
        String[] a;
        if (!TextUtils.isEmpty(f145a[0]) && !TextUtils.isEmpty(f145a[1])) {
            return f145a;
        }
        if (context == null || (a = StoreHelper.m156a(context).mo7341a()) == null) {
            return null;
        }
        String[] strArr = f145a;
        strArr[0] = a[0];
        strArr[1] = a[1];
        return strArr;
    }
}
