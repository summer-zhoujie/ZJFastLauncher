package com.wpengapp.support;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.provider.Settings;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.TooltipCompatHandler;
import android.text.TextUtils;
import android.util.Log;
import com.wpengapp.support.StatCallback;

/* renamed from: com.wpengapp.support.ԧ */
public class SystemApi {

    /* renamed from: ֏ */
    public static final IBinder f1978 = new Binder();

    /* renamed from: ؠ */
    public static Application f1979;

    /* renamed from: ހ */
    public static String f1980;

    /* renamed from: ށ */
    public static StatCallback f1981 = new StatCallback.C0472();

    /* renamed from: ނ */
    public static boolean f1982;

    /* renamed from: ރ */
    public static Runnable f1983 = new C0880();

    /* renamed from: ބ */
    public static int f1984 = -1;

    /* renamed from: ޅ */
    public static Intent f1985;

    /* renamed from: ֏ */
    public static synchronized void m2046(Application application) {
        synchronized (SystemApi.class) {
            m2047(application, (String) null);
        }
    }

    /* renamed from: ؠ */
    public static int m2051(Context context) {
        int r0 = m2044(context);
        if (r0 != 0) {
            f1981.mo7963(r0);
            return r0;
        } else if (TextUtils.isEmpty(C0983.m2615())) {
            f1981.mo7963(4);
            return 4;
        } else {
            try {
                context.getPackageManager().getPackageInfo(C0983.m2615(), 0);
                int i = C0983.m2611().f905;
                if (i <= 0) {
                    f1981.mo7963(3);
                    return 3;
                } else if (i < 10003) {
                    f1981.mo7963(2);
                    return 2;
                } else {
                    f1981.mo7963(0);
                    return 0;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f1981.mo7963(4);
                return 4;
            }
        }
    }

    /* renamed from: ހ */
    public static String m2053() {
        return "xp/xp";
    }

    /* renamed from: ށ */
    public static String m2054() {
        try {
            return Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + C0983.m2615() + "/wpenglog";
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ނ */
    public static String m2055() {
        try {
            return Environment.getExternalStorageDirectory().getPath() + "/WPengApp/WXPS/log";
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ރ */
    public static IMainService m2056() {
        IMainService r0 = C0983.m2614();
        return (r0 != null || !m2048()) ? r0 : C0983.m2614();
    }

    /* renamed from: ބ */
    public static /* synthetic */ void m2057() {
        C0983.f2756.removeCallbacks(f1983);
        C0983.f2756.postDelayed(f1983, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_SHORT_MS);
    }

    /* renamed from: ֏ */
    public static synchronized void m2047(Application application, String str) {
        synchronized (SystemApi.class) {
            if (f1979 == null) {
                f1979 = application;
                Object obj = null;
                try {
                    ApplicationInfo applicationInfo = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128);
                    if (applicationInfo != null) {
                        if (applicationInfo.metaData != null) {
                            obj = applicationInfo.metaData.get("WXPS_APP_KEY");
                        }
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
                f1980 = (String) obj;
                C0983.m2613(application, str, C0689.f1787);
            }
        }
    }

    /* renamed from: ֏ */
    public static int m2044(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.wpengapp.xposed", 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            int i = packageInfo.versionCode;
            if (applicationInfo == null || i <= 0) {
                return 1;
            }
            if (i < 10003) {
                return 2;
            }
            return 0;
        } catch (Exception unused) {
            return 1;
        }
    }

    /* renamed from: ؠ */
    public static String m2052() {
        return C0983.m2615();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e8 A[Catch:{ Exception -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0101 A[Catch:{ Exception -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x012e A[SYNTHETIC, Splitter:B:38:0x012e] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m2048() {
        /*
            java.lang.String r0 = "ms"
            java.lang.String r1 = "Connect service time "
            long r2 = android.os.SystemClock.elapsedRealtime()
            r4 = 0
            r5 = 0
            android.app.Application r6 = f1979     // Catch:{ Exception -> 0x00ff }
            int r6 = m2044((android.content.Context) r6)     // Catch:{ Exception -> 0x00ff }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ff }
            r7.<init>()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r8 = "Install status "
            r7.append(r8)     // Catch:{ Exception -> 0x00ff }
            r7.append(r6)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r14 = r7.toString()     // Catch:{ Exception -> 0x00ff }
            if (r6 == 0) goto L_0x0047
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r12 = r6 - r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r12)
            r2.append(r0)
            r2.toString()
            com.wpengapp.support.Ļ r9 = f1981
            android.app.Application r0 = f1979
            int r11 = com.wpengapp.support.XPFramework.m1235(r0)
            r10 = 0
            r9.mo7966(r10, r11, r12, r14)
            return r5
        L_0x0047:
            com.wpengapp.support.Ž r6 = com.wpengapp.support.C0983.m2611()     // Catch:{ Exception -> 0x00ff }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ff }
            r7.<init>()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r8 = "Running status "
            r7.append(r8)     // Catch:{ Exception -> 0x00ff }
            r7.append(r6)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r14 = r7.toString()     // Catch:{ Exception -> 0x00ff }
            int r7 = r6.f905     // Catch:{ Exception -> 0x015d, all -> 0x015a }
            if (r7 > 0) goto L_0x0084
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r12 = r6 - r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r12)
            r2.append(r0)
            r2.toString()
            com.wpengapp.support.Ļ r9 = f1981
            android.app.Application r0 = f1979
            int r11 = com.wpengapp.support.XPFramework.m1235(r0)
            r10 = 0
            r9.mo7966(r10, r11, r12, r14)
            return r5
        L_0x0084:
            int r7 = r6.f905     // Catch:{ Exception -> 0x00ff }
            r8 = 10003(0x2713, float:1.4017E-41)
            if (r7 >= r8) goto L_0x00c9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ff }
            r7.<init>()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r9 = "Version error: "
            r7.append(r9)     // Catch:{ Exception -> 0x00ff }
            int r6 = r6.f905     // Catch:{ Exception -> 0x00ff }
            r7.append(r6)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r6 = "<"
            r7.append(r6)     // Catch:{ Exception -> 0x00ff }
            r7.append(r8)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r14 = r7.toString()     // Catch:{ Exception -> 0x00ff }
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r12 = r6 - r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r12)
            r2.append(r0)
            r2.toString()
            com.wpengapp.support.Ļ r9 = f1981
            android.app.Application r0 = f1979
            int r11 = com.wpengapp.support.XPFramework.m1235(r0)
            r10 = 0
            r9.mo7966(r10, r11, r12, r14)
            return r5
        L_0x00c9:
            java.util.List<java.lang.Integer> r7 = r6.f907     // Catch:{ Exception -> 0x00ff }
            r9 = 1
            if (r7 == 0) goto L_0x00e5
            java.util.List<java.lang.Integer> r7 = r6.f907     // Catch:{ Exception -> 0x00ff }
            boolean r7 = r7.isEmpty()     // Catch:{ Exception -> 0x00ff }
            if (r7 != 0) goto L_0x00e5
            java.util.List<java.lang.Integer> r6 = r6.f907     // Catch:{ Exception -> 0x00ff }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00ff }
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x00ff }
            if (r6 != 0) goto L_0x00e3
            goto L_0x00e5
        L_0x00e3:
            r6 = 0
            goto L_0x00e6
        L_0x00e5:
            r6 = 1
        L_0x00e6:
            if (r6 == 0) goto L_0x0101
            android.app.Application r6 = f1979     // Catch:{ Exception -> 0x00ff }
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r7 = "xp/ls"
            java.io.InputStream r6 = r6.open(r7)     // Catch:{ Exception -> 0x00ff }
            byte[] r6 = com.wpengapp.support.Utils.m1885((java.io.InputStream) r6)     // Catch:{ Exception -> 0x00ff }
            com.wpengapp.support.Վ r6 = com.wpengapp.support.C0983.m2612(r6)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r7 = "installAndGetService null"
            goto L_0x0107
        L_0x00ff:
            r6 = move-exception
            goto L_0x0163
        L_0x0101:
            com.wpengapp.support.ʗ r6 = com.wpengapp.support.C0983.m2614()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r7 = "getService null"
        L_0x0107:
            r15 = r7
            if (r6 != 0) goto L_0x012e
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r13 = r6 - r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r13)
            r2.append(r0)
            r2.toString()
            com.wpengapp.support.Ļ r10 = f1981
            android.app.Application r0 = f1979
            int r12 = com.wpengapp.support.XPFramework.m1235(r0)
            r11 = 0
            r10.mo7966(r11, r12, r13, r15)
            return r5
        L_0x012e:
            java.lang.String r7 = f1980     // Catch:{ Exception -> 0x00ff }
            r6.mo8267(r7)     // Catch:{ Exception -> 0x00ff }
            f1982 = r9     // Catch:{ Exception -> 0x00ff }
            r11 = 1
            r15 = 0
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r13 = r4 - r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r13)
            r2.append(r0)
            r2.toString()
            com.wpengapp.support.Ļ r10 = f1981
            android.app.Application r0 = f1979
            int r12 = com.wpengapp.support.XPFramework.m1235(r0)
            r10.mo7966(r11, r12, r13, r15)
            return r9
        L_0x015a:
            r5 = move-exception
            r11 = r14
            goto L_0x018b
        L_0x015d:
            r6 = move-exception
            r4 = r14
            goto L_0x0163
        L_0x0160:
            r5 = move-exception
            r11 = r4
            goto L_0x018b
        L_0x0163:
            java.lang.String r12 = android.util.Log.getStackTraceString(r6)     // Catch:{ all -> 0x0160 }
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r10 = r6 - r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r10)
            r2.append(r0)
            r2.toString()
            com.wpengapp.support.Ļ r7 = f1981
            android.app.Application r0 = f1979
            int r9 = com.wpengapp.support.XPFramework.m1235(r0)
            r8 = 0
            r7.mo7966(r8, r9, r10, r12)
            return r5
        L_0x018b:
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r9 = r6 - r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r9)
            r2.append(r0)
            r2.toString()
            com.wpengapp.support.Ļ r6 = f1981
            android.app.Application r0 = f1979
            int r8 = com.wpengapp.support.XPFramework.m1235(r0)
            r7 = 0
            r6.mo7966(r7, r8, r9, r11)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.SystemApi.m2048():boolean");
    }

    /* renamed from: ֏ */
    public static void m2045(int i, Intent intent) {
        IMainService r0;
        f1984 = i;
        f1985 = intent;
        if (intent != null && (r0 = m2056()) != null) {
            try {
                r0.mo8266(f1978, i, intent, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_SHORT_MS);
            } catch (Exception e) {
                e.getMessage();
                f1981.mo7964("kp", Log.getStackTraceString(e));
            }
        }
    }

    /* renamed from: ֏ */
    public static boolean m2049(Context context, String str, String str2) {
        boolean z;
        String str3;
        IMainService r1 = m2056();
        if (r1 == null) {
            return false;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
            if (string == null) {
                string = BidiFormatter.EMPTY_STRING;
            }
            String str4 = str + "/" + str2;
            if (string.contains(str4)) {
                String str5 = BidiFormatter.EMPTY_STRING;
                for (String str6 : string.split(":")) {
                    if (!TextUtils.isEmpty(str6) && !str6.contains(str)) {
                        if (str5.length() != 0) {
                            str5 = str5 + ":";
                        }
                        str5 = str5 + str6;
                    }
                }
                string = str5;
                z = true;
            } else {
                z = false;
            }
            if (string.length() != 0) {
                str3 = string + ":";
            } else {
                str3 = string;
            }
            String str7 = str3 + str4;
            if (z) {
                if (TextUtils.isEmpty(string)) {
                    string = BidiFormatter.EMPTY_STRING;
                }
                r1.mo8270("enabled_accessibility_services", string);
                r1.mo8269("accessibility_enabled", 1);
            }
            r1.mo8270("enabled_accessibility_services", str7);
            r1.mo8269("accessibility_enabled", 1);
            f1981.mo7967(true);
            return true;
        } catch (Exception e) {
            e.getMessage();
            f1981.mo7967(false);
            f1981.mo7964("openacc", Log.getStackTraceString(e));
            return false;
        }
    }

    /* renamed from: ֏ */
    public static boolean m2050(String str) {
        return "wxps".equals(str);
    }
}
