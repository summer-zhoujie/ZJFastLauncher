package com.wpengapp.support;

import android.os.Build;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.wpengapp.support.ɝ */
public class ForegroundAppManager {

    /* renamed from: ֏ */
    public static final CopyOnWriteArraySet<OnForegroundChangeListener> f1239 = new CopyOnWriteArraySet<>();

    /* renamed from: ؠ */
    public static String f1240;

    /* renamed from: ހ */
    public static String f1241;

    /* renamed from: ށ */
    public static Runnable f1242 = new C0897();

    /* renamed from: ֏ */
    public static String m1391() {
        return m1393(f1241, f1240);
    }

    /* renamed from: ؠ */
    public static boolean m1396(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if ("com.jincheng.supercaculator".equals(str) && str2.endsWith("SplashActivity")) {
            return true;
        }
        if ("com.tencent.tmgp.sgame".equals(str) && "android.widget.FrameLayout".equals(str2) && !"com.tencent.tmgp.sgame".equals(f1241)) {
            return true;
        }
        if ("com.mcdonalds.gma.cn".equals(str) && "android.widget.FrameLayout".equals(str2)) {
            return true;
        }
        if (!"com.didapinche.booking".equals(str) || !"com.didapinche.booking.home.activity.StartActivity".equals(str2)) {
            return false;
        }
        return true;
    }

    /* renamed from: ހ */
    public static void m1397(String str, String str2) {
        Iterator<OnForegroundChangeListener> it = f1239.iterator();
        while (it.hasNext()) {
            try {
                it.next().mo8502(str, str2);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: ֏ */
    public static String m1393(String str, String str2) {
        if (str == null || str2 == null) {
            return BidiFormatter.EMPTY_STRING;
        }
        if (str2.startsWith(".")) {
            str2 = outline.m2556(str, str2);
        }
        return outline.m2545(str, "/", str2);
    }

    /* renamed from: ֏ */
    public static String m1392(String str) {
        if (str == null) {
            return str;
        }
        String[] split = str.split("/");
        if (split.length != 2) {
            return str;
        }
        if (split[1].startsWith(split[0])) {
            return split[1].substring(split[0].length());
        }
        return split[1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069 A[Catch:{ Exception -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1394(android.view.accessibility.AccessibilityEvent r4) {
        /*
            java.lang.String r0 = ""
            int r1 = r4.getEventType()
            r2 = 32
            if (r1 != r2) goto L_0x0077
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0073 }
            r1.<init>()     // Catch:{ Exception -> 0x0073 }
            r1.append(r0)     // Catch:{ Exception -> 0x0073 }
            java.lang.CharSequence r2 = r4.getClassName()     // Catch:{ Exception -> 0x0073 }
            r1.append(r2)     // Catch:{ Exception -> 0x0073 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0073 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0073 }
            r2.<init>()     // Catch:{ Exception -> 0x0073 }
            r2.append(r0)     // Catch:{ Exception -> 0x0073 }
            java.lang.CharSequence r4 = r4.getPackageName()     // Catch:{ Exception -> 0x0073 }
            r2.append(r4)     // Catch:{ Exception -> 0x0073 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x0073 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0054 }
            r0.<init>()     // Catch:{ Exception -> 0x0054 }
            r0.setClassName(r4, r1)     // Catch:{ Exception -> 0x0054 }
            android.app.Application r2 = com.wpengapp.support.AppUtils.m1160()     // Catch:{ Exception -> 0x0054 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ Exception -> 0x0054 }
            r3 = 0
            java.util.List r0 = r2.queryIntentActivities(r0, r3)     // Catch:{ Exception -> 0x0054 }
            if (r0 == 0) goto L_0x0058
            int r2 = r0.size()     // Catch:{ Exception -> 0x0054 }
            if (r2 <= 0) goto L_0x0058
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0054 }
            android.content.pm.ResolveInfo r0 = (android.content.pm.ResolveInfo) r0     // Catch:{ Exception -> 0x0054 }
            goto L_0x0059
        L_0x0054:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x0073 }
        L_0x0058:
            r0 = 0
        L_0x0059:
            if (r0 != 0) goto L_0x0061
            boolean r0 = m1396(r4, r1)     // Catch:{ Exception -> 0x0073 }
            if (r0 == 0) goto L_0x0077
        L_0x0061:
            java.lang.String r0 = f1240     // Catch:{ Exception -> 0x0073 }
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x0073 }
            if (r0 != 0) goto L_0x0077
            f1240 = r1     // Catch:{ Exception -> 0x0073 }
            f1241 = r4     // Catch:{ Exception -> 0x0073 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0073 }
            m1397(r4, r1)     // Catch:{ Exception -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r4 = move-exception
            r4.getMessage()
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.ForegroundAppManager.m1394(android.view.accessibility.AccessibilityEvent):void");
    }

    /* renamed from: ֏ */
    public static void m1395(OnForegroundChangeListener r2) {
        if (r2 != null) {
            synchronized (f1239) {
                f1239.add(r2);
                int i = Build.VERSION.SDK_INT;
            }
        }
    }
}
