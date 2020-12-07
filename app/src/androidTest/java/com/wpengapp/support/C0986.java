package com.wpengapp.support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.wpengapp.support.activity.LauncherActivity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.ߪ */
/* compiled from: ForceCloseHelper */
public class C0986 {

    /* renamed from: ֏ */
    public static final String f2760 = (AppUtils.m1163() + ".ACTION_SHOW_FORCE_CLOSE_DIALOG");

    /* renamed from: ؠ */
    public static boolean f2761;

    /* JADX WARNING: Can't wrap try/catch for region: R(16:8|9|10|(1:12)(1:13)|14|15|16|17|18|(1:20)|21|(1:25)|26|(1:28)|(4:30|(2:33|(2:34|(2:36|(2:50|38))(1:51)))(0)|32|(1:40))|(3:42|43|44)(2:45|46)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x006d */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fc A[DONT_GENERATE] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean m2621(Context r12) {
        /*
            java.lang.Class<com.wpengapp.support.ߪ> r0 = com.wpengapp.support.C0986.class
            monitor-enter(r0)
            boolean r1 = f2761     // Catch:{ all -> 0x00fe }
            r2 = 0
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)
            return r2
        L_0x000a:
            r1 = 1
            f2761 = r1     // Catch:{ all -> 0x00fe }
            android.content.Context r12 = r12.getApplicationContext()     // Catch:{ all -> 0x00fe }
            java.lang.String r3 = "forceclose"
            android.content.SharedPreferences r3 = r12.getSharedPreferences(r3, r2)     // Catch:{ all -> 0x00fe }
            android.content.SharedPreferences$Editor r4 = r3.edit()     // Catch:{ all -> 0x00fe }
            java.lang.String r5 = "SP_IS_EXITED"
            boolean r5 = r3.getBoolean(r5, r1)     // Catch:{ all -> 0x00fe }
            java.lang.String r6 = "SP_IS_EXITED"
            android.content.SharedPreferences$Editor r6 = r4.putBoolean(r6, r2)     // Catch:{ all -> 0x00fe }
            r6.apply()     // Catch:{ all -> 0x00fe }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
            r6.<init>()     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = "Service Started, Last Service exit: "
            r6.append(r7)     // Catch:{ all -> 0x00fe }
            r6.append(r5)     // Catch:{ all -> 0x00fe }
            r6.toString()     // Catch:{ all -> 0x00fe }
            if (r5 != 0) goto L_0x003e
            r5 = 1
            goto L_0x003f
        L_0x003e:
            r5 = 0
        L_0x003f:
            java.lang.String r6 = "SP_LAST_APP_VERSION"
            java.lang.String r7 = ""
            java.lang.String r6 = r3.getString(r6, r7)     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = ""
            android.content.pm.PackageManager r8 = r12.getPackageManager()     // Catch:{ NameNotFoundException -> 0x006d }
            java.lang.String r9 = r12.getPackageName()     // Catch:{ NameNotFoundException -> 0x006d }
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r9, r2)     // Catch:{ NameNotFoundException -> 0x006d }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x006d }
            r9.<init>()     // Catch:{ NameNotFoundException -> 0x006d }
            int r10 = r8.versionCode     // Catch:{ NameNotFoundException -> 0x006d }
            r9.append(r10)     // Catch:{ NameNotFoundException -> 0x006d }
            java.lang.String r10 = ","
            r9.append(r10)     // Catch:{ NameNotFoundException -> 0x006d }
            long r10 = r8.lastUpdateTime     // Catch:{ NameNotFoundException -> 0x006d }
            r9.append(r10)     // Catch:{ NameNotFoundException -> 0x006d }
            java.lang.String r7 = r9.toString()     // Catch:{ NameNotFoundException -> 0x006d }
        L_0x006d:
            boolean r6 = r7.equals(r6)     // Catch:{ all -> 0x00fe }
            if (r6 != 0) goto L_0x007d
            java.lang.String r5 = "SP_LAST_APP_VERSION"
            android.content.SharedPreferences$Editor r5 = r4.putString(r5, r7)     // Catch:{ all -> 0x00fe }
            r5.apply()     // Catch:{ all -> 0x00fe }
            r5 = 0
        L_0x007d:
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00fe }
            if (r5 == 0) goto L_0x008b
            r8 = 300000(0x493e0, double:1.482197E-318)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x008b
            r5 = 0
        L_0x008b:
            java.lang.String r6 = "SP_SYSTEM_INCREMENTAL"
            java.lang.String r7 = ""
            java.lang.String r3 = r3.getString(r6, r7)     // Catch:{ all -> 0x00fe }
            java.lang.String r6 = com.wpengapp.support.C0719.m1825()     // Catch:{ all -> 0x00fe }
            boolean r3 = r3.equals(r6)     // Catch:{ all -> 0x00fe }
            if (r3 != 0) goto L_0x00a7
            java.lang.String r3 = "SP_SYSTEM_INCREMENTAL"
            android.content.SharedPreferences$Editor r3 = r4.putString(r3, r6)     // Catch:{ all -> 0x00fe }
            r3.apply()     // Catch:{ all -> 0x00fe }
            r5 = 0
        L_0x00a7:
            if (r5 == 0) goto L_0x00dd
            java.lang.String r3 = r12.getPackageName()     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = "activity"
            java.lang.Object r4 = r12.getSystemService(r4)     // Catch:{ all -> 0x00fe }
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4     // Catch:{ all -> 0x00fe }
            java.util.List r4 = r4.getRunningAppProcesses()     // Catch:{ all -> 0x00fe }
            boolean r6 = com.wpengapp.support.CollectionUtils.m1657((java.util.Collection) r4)     // Catch:{ all -> 0x00fe }
            if (r6 == 0) goto L_0x00c1
        L_0x00bf:
            r3 = 0
            goto L_0x00da
        L_0x00c1:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00fe }
        L_0x00c5:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x00fe }
            if (r6 == 0) goto L_0x00bf
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x00fe }
            android.app.ActivityManager$RunningAppProcessInfo r6 = (android.app.ActivityManager.RunningAppProcessInfo) r6     // Catch:{ all -> 0x00fe }
            java.lang.String r6 = r6.processName     // Catch:{ all -> 0x00fe }
            boolean r6 = r3.equals(r6)     // Catch:{ all -> 0x00fe }
            if (r6 == 0) goto L_0x00c5
            r3 = 1
        L_0x00da:
            if (r3 != 0) goto L_0x00dd
            r5 = 0
        L_0x00dd:
            if (r5 == 0) goto L_0x00fc
            android.app.Application r2 = com.wpengapp.support.AppUtils.m1160()     // Catch:{ all -> 0x00fe }
            android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = f2760     // Catch:{ all -> 0x00fe }
            r3.<init>(r4)     // Catch:{ all -> 0x00fe }
            r2.sendBroadcast(r3)     // Catch:{ all -> 0x00fe }
            com.wpengapp.support.द r2 = new com.wpengapp.support.द     // Catch:{ all -> 0x00fe }
            r2.<init>(r12)     // Catch:{ all -> 0x00fe }
            r3 = 1000(0x3e8, double:4.94E-321)
            com.wpengapp.support.AppUtils.m1147((java.lang.Runnable) r2, (long) r3)     // Catch:{ all -> 0x00fe }
            m2620()     // Catch:{ all -> 0x00fe }
            monitor-exit(r0)
            return r1
        L_0x00fc:
            monitor-exit(r0)
            return r2
        L_0x00fe:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0986.m2621(android.content.Context):boolean");
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: ؠ */
    public static synchronized void m2622(Context context) {
        synchronized (C0986.class) {
            f2761 = false;
            context.getSharedPreferences("forceclose", 0).edit().putBoolean("SP_IS_EXITED", true).commit();
        }
    }

    /* renamed from: ֏ */
    public static void m2620() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", String.valueOf(AppUtils.m1158()));
        hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("brand", Build.BRAND);
        hashMap.put("device", C0719.m1816());
        hashMap.put("is_admin", String.valueOf(DeviceAdminHelper.m724()));
        PowerManager powerManager = (PowerManager) AppUtils.m1153("power");
        if (powerManager != null && Build.VERSION.SDK_INT >= 23) {
            hashMap.put("is_ignore_battery", String.valueOf(powerManager.isIgnoringBatteryOptimizations(AppUtils.m1163())));
        }
        hashMap.put("exclude_recents", String.valueOf(LauncherActivity.f635));
        UMengManager.m1406("FORCE_CLOSE", (Map<String, String>) hashMap);
    }
}
