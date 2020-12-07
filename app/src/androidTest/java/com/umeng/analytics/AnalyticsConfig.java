package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.wpengapp.support.DeviceConfig;
import com.wpengapp.support.MLog;

public class AnalyticsConfig {
    public static boolean ACTIVITY_DURATION_OPEN = true;
    public static boolean CATCH_EXCEPTION = true;
    public static boolean COMPRESS_DATA = true;
    public static boolean ENABLE_MEMORY_BUFFER = true;
    public static final boolean FLAG_INTERNATIONAL = false;
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";

    /* renamed from: a */
    public static double[] f62a = null;

    /* renamed from: b */
    public static String f63b = null;

    /* renamed from: c */
    public static String f64c = null;

    /* renamed from: d */
    public static String f65d = null;

    /* renamed from: e */
    public static int f66e = 0;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType = null;
    public static String mWrapperVersion = null;
    public static boolean sEncrypt = false;
    public static int sLatentWindow;

    /* renamed from: a */
    public static void m36a(boolean z) {
        sEncrypt = z;
    }

    /* renamed from: b */
    public static void m37b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f65d = str;
            StoreHelper.m156a(context).mo7346c(f65d);
        }
    }

    public static String getAppkey(Context context) {
        if (TextUtils.isEmpty(f63b)) {
            f63b = DeviceConfig.m2333(context);
            if (TextUtils.isEmpty(f63b)) {
                f63b = StoreHelper.m156a(context).mo7345c();
            }
        }
        return f63b;
    }

    public static String getChannel(Context context) {
        if (TextUtils.isEmpty(f64c)) {
            f64c = DeviceConfig.m2336(context);
        }
        return f64c;
    }

    public static double[] getLocation() {
        return f62a;
    }

    public static String getSDKVersion(Context context) {
        return AnalyticsConstants.f100c;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f65d)) {
            f65d = StoreHelper.m156a(context).mo7348e();
        }
        return f65d;
    }

    public static int getVerticalType(Context context) {
        if (f66e == 0) {
            f66e = StoreHelper.m156a(context).mo7349f();
        }
        return f66e;
    }

    /* renamed from: a */
    public static void m34a(Context context, String str) {
        if (context == null) {
            f63b = str;
            return;
        }
        String r0 = DeviceConfig.m2333(context);
        if (!TextUtils.isEmpty(r0)) {
            f63b = r0;
            if (!r0.equals(str)) {
                MLog.m1773("Appkey和AndroidManifest.xml中配置的不一致 ");
                return;
            }
            return;
        }
        String c = StoreHelper.m156a(context).mo7345c();
        if (TextUtils.isEmpty(c)) {
            StoreHelper.m156a(context).mo7338a(str);
        } else if (!c.equals(str)) {
            MLog.m1773("Appkey和上次配置的不一致 ");
            StoreHelper.m156a(context).mo7338a(str);
        }
        f63b = str;
    }

    /* renamed from: a */
    public static void m35a(String str) {
        f64c = str;
    }

    /* renamed from: a */
    public static void m33a(Context context, int i) {
        f66e = i;
        StoreHelper.m156a(context).mo7336a(f66e);
    }
}
