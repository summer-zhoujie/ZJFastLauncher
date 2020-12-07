package com.wpengapp.support;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.support.p000v4.text.BidiFormatter;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.umeng.analytics.social.UMSocialConstants;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;

/* renamed from: com.wpengapp.support.ѣ */
/* compiled from: DeviceUtils */
public class C0719 {

    /* renamed from: ֏ */
    public static final String f1855 = "ѣ";

    /* renamed from: ؠ */
    public static String f1856;

    /* renamed from: ހ */
    public static String f1857;

    /* renamed from: ށ */
    public static String f1858;

    /* renamed from: ނ */
    public static final Application f1859 = AppUtils.getApplication();

    /* renamed from: ރ */
    public static Double f1860;

    /* renamed from: ބ */
    public static String f1861;

    /* renamed from: ޅ */
    public static int f1862 = -1;

    /* renamed from: ކ */
    public static Boolean f1863;

    @SuppressLint({"HardwareIds"})
    /* renamed from: ֏ */
    public static String m1812() {
        String str;
        try {
            str = Settings.Secure.getString(f1859.getContentResolver(), UMSocialConstants.f260s);
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            return BidiFormatter.EMPTY_STRING;
        }
        return str.trim();
    }

    /* renamed from: ؠ */
    public static String m1815(String str) {
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
            if (str2 != null) {
                return str2;
            }
            return BidiFormatter.EMPTY_STRING;
        } catch (Exception e) {
            String str3 = f1855;
            e.getMessage();
            return BidiFormatter.EMPTY_STRING;
        }
    }

    /* renamed from: ހ */
    public static String m1816() {
        if (TextUtils.isEmpty(f1858)) {
            f1858 = (Build.BRAND + "-" + Build.MODEL).replaceAll(" ", BidiFormatter.EMPTY_STRING).trim().toUpperCase();
        }
        return f1858;
    }

    /* renamed from: ށ */
    public static String m1817() {
        String str;
        try {
            str = ((TelephonyManager) f1859.getSystemService("phone")).getNetworkOperatorName();
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            return BidiFormatter.EMPTY_STRING;
        }
        return str.trim();
    }

    /* renamed from: ނ */
    public static String m1818() {
        String str;
        try {
            str = ((TelephonyManager) f1859.getSystemService("phone")).getSimCountryIso();
        } catch (Exception e) {
            String str2 = f1855;
            e.getMessage();
            str = BidiFormatter.EMPTY_STRING;
        }
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.getDefault();
        sb.append(locale.getLanguage() + "_" + locale.getCountry());
        sb.append("_");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: ރ */
    public static int m1819() {
        int r5;
        int i = f1862;
        if (i > -1) {
            return i;
        }
        try {
            int length = new File("/sys/devices/system/cpu/").listFiles(new DeviceUtils()).length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                String r52 = FileUtils.m1134(new File("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq"));
                if (r52 != null && (r5 = Utils.m1857(r52.trim(), 0)) > 0) {
                    i2 += r5;
                }
            }
            f1862 = i2;
            return i2;
        } catch (Exception e) {
            String str = f1855;
            e.getMessage();
            return -1;
        }
    }

    /* renamed from: ބ */
    public static String m1820() {
        String str;
        if (!TextUtils.isEmpty(f1857)) {
            return f1857;
        }
        String r0 = m1812();
        if (TextUtils.isEmpty(r0)) {
            StringBuilder r02 = outline.m2549("F");
            r02.append(MD5Utils.m1342(m1812() + Build.BOARD + Build.BOOTLOADER + Build.BRAND + Build.CPU_ABI + Build.CPU_ABI2 + Build.DEVICE + Build.DISPLAY + Build.FINGERPRINT + Build.HARDWARE + Build.ID + Build.MODEL + Build.MANUFACTURER + Build.PRODUCT + Build.TAGS + Build.TYPE + Build.USER));
            str = r02.toString();
        } else {
            StringBuilder r1 = outline.m2549("A");
            StringBuilder r03 = outline.m2549(r0);
            r03.append(m1816());
            r1.append(MD5Utils.m1342(r03.toString()));
            str = r1.toString();
        }
        f1857 = str.toUpperCase();
        return f1857;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    @Deprecated
    /* renamed from: ޅ */
    public static String m1821() {
        String str;
        String str2 = null;
        try {
            str = ((TelephonyManager) f1859.getSystemService("phone")).getDeviceId();
        } catch (Throwable unused) {
            str = null;
        }
        boolean z = false;
        if (!TextUtils.isEmpty(str) && str.length() >= 2) {
            char charAt = str.charAt(1);
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    break;
                } else if (charAt != str.charAt(i)) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        if (z) {
            str2 = str;
        }
        if (str2 == null) {
            return BidiFormatter.EMPTY_STRING;
        }
        return str2.trim();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c A[SYNTHETIC, Splitter:B:22:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Deprecated
    /* renamed from: ކ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m1822() {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = ":"
            r2 = 0
            r3 = 0
            r4 = 1
            java.lang.String r5 = "wifi.interface"
            java.lang.String r5 = m1815(r5)     // Catch:{ Throwable -> 0x0065 }
            java.net.NetworkInterface r5 = java.net.NetworkInterface.getByName(r5)     // Catch:{ Throwable -> 0x0065 }
            byte[] r5 = r5.getHardwareAddress()     // Catch:{ Throwable -> 0x0065 }
            int r6 = r5.length     // Catch:{ Throwable -> 0x0065 }
            r7 = 6
            if (r6 != r7) goto L_0x0065
            r7 = r0
            r6 = 0
        L_0x001b:
            int r8 = r5.length     // Catch:{ Throwable -> 0x0065 }
            if (r6 >= r8) goto L_0x0066
            byte r8 = r5[r6]     // Catch:{ Throwable -> 0x0065 }
            if (r8 < 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            int r8 = r8 + 256
        L_0x0025:
            java.lang.String r8 = java.lang.Integer.toHexString(r8)     // Catch:{ Throwable -> 0x0065 }
            int r9 = r8.length()     // Catch:{ Throwable -> 0x0065 }
            if (r9 != r4) goto L_0x0040
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0065 }
            r9.<init>()     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r10 = "0"
            r9.append(r10)     // Catch:{ Throwable -> 0x0065 }
            r9.append(r8)     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r8 = r9.toString()     // Catch:{ Throwable -> 0x0065 }
        L_0x0040:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0065 }
            r9.<init>()     // Catch:{ Throwable -> 0x0065 }
            r9.append(r7)     // Catch:{ Throwable -> 0x0065 }
            r9.append(r8)     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r7 = r9.toString()     // Catch:{ Throwable -> 0x0065 }
            int r8 = r5.length     // Catch:{ Throwable -> 0x0065 }
            int r8 = r8 - r4
            if (r6 == r8) goto L_0x0062
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0065 }
            r8.<init>()     // Catch:{ Throwable -> 0x0065 }
            r8.append(r7)     // Catch:{ Throwable -> 0x0065 }
            r8.append(r1)     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r7 = r8.toString()     // Catch:{ Throwable -> 0x0065 }
        L_0x0062:
            int r6 = r6 + 1
            goto L_0x001b
        L_0x0065:
            r7 = r2
        L_0x0066:
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 == 0) goto L_0x0080
            android.app.Application r5 = f1859     // Catch:{ Throwable -> 0x0080 }
            java.lang.String r6 = "wifi"
            java.lang.Object r5 = r5.getSystemService(r6)     // Catch:{ Throwable -> 0x0080 }
            android.net.wifi.WifiManager r5 = (android.net.wifi.WifiManager) r5     // Catch:{ Throwable -> 0x0080 }
            android.net.wifi.WifiInfo r5 = r5.getConnectionInfo()     // Catch:{ Throwable -> 0x0080 }
            java.lang.String r7 = r5.getMacAddress()     // Catch:{ Throwable -> 0x0080 }
            java.lang.String r5 = f1855     // Catch:{ Throwable -> 0x0080 }
        L_0x0080:
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 == 0) goto L_0x0087
            goto L_0x00a3
        L_0x0087:
            java.lang.String[] r1 = r7.split(r1)
            int r5 = r1.length
            r6 = 0
            r8 = 0
        L_0x008e:
            if (r6 >= r5) goto L_0x009f
            r9 = r1[r6]
            java.lang.String r10 = "00"
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L_0x009c
            int r8 = r8 + 1
        L_0x009c:
            int r6 = r6 + 1
            goto L_0x008e
        L_0x009f:
            r1 = 5
            if (r8 >= r1) goto L_0x00a3
            r3 = 1
        L_0x00a3:
            if (r3 != 0) goto L_0x00a6
            goto L_0x00a7
        L_0x00a6:
            r2 = r7
        L_0x00a7:
            if (r2 != 0) goto L_0x00aa
            goto L_0x00ae
        L_0x00aa:
            java.lang.String r0 = r2.trim()
        L_0x00ae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0719.m1822():java.lang.String");
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    /* renamed from: އ */
    public static String m1823() {
        String str;
        try {
            str = ((TelephonyManager) f1859.getSystemService("phone")).getLine1Number();
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            return BidiFormatter.EMPTY_STRING;
        }
        return str.trim();
    }

    /* renamed from: ވ */
    public static String m1824() {
        Display defaultDisplay = ((WindowManager) f1859.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.heightPixels + "x" + displayMetrics.widthPixels;
    }

    /* renamed from: މ */
    public static String m1825() {
        return MD5Utils.m1342(Build.VERSION.INCREMENTAL + Build.VERSION.SDK_INT + Build.VERSION.RELEASE + Build.DISPLAY);
    }

    @SuppressLint({"MissingPermission"})
    @Deprecated
    /* renamed from: ފ */
    public static String m1826() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                String serial = Build.getSerial();
                if (m1813(serial)) {
                    return serial;
                }
            }
        } catch (Exception e) {
            String str = f1855;
            e.getMessage();
        } catch (Throwable unused) {
            return BidiFormatter.EMPTY_STRING;
        }
        String str2 = Build.SERIAL;
        if (m1813(str2)) {
            return str2;
        }
        for (String r3 : new String[]{"ro.serialno", "ro.boot.serialno"}) {
            String r32 = m1815(r3);
            if (m1813(r32)) {
                return r32;
            }
        }
        return BidiFormatter.EMPTY_STRING;
    }

    /* renamed from: ދ */
    public static String[] m1827() {
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, new String[]{"/system/bin", "/system/xbin", "/system/sbin", "/sbin", "/vendor/bin", "/su/bin"});
        try {
            String str = System.getenv("PATH");
            if (!TextUtils.isEmpty(str)) {
                hashSet.addAll(Arrays.asList(str.split(":")));
            }
        } catch (Exception e) {
            String str2 = f1855;
            e.getMessage();
        }
        String[] strArr = new String[hashSet.size()];
        hashSet.toArray(strArr);
        return strArr;
    }

    /* renamed from: ތ */
    public static boolean m1828() {
        Boolean bool = f1863;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        try {
            String[] r2 = m1827();
            int length = r2.length;
            int i = 0;
            while (i < length) {
                File file = new File(r2[i], "su");
                if (!file.exists() || !file.canExecute()) {
                    i++;
                } else {
                    f1863 = true;
                    return true;
                }
            }
        } catch (Exception e) {
            String str = f1855;
            e.getMessage();
        }
        f1863 = false;
        return false;
    }

    /* renamed from: ލ */
    public static boolean m1829() {
        return Build.MANUFACTURER.contains("QiKU");
    }

    /* renamed from: ގ */
    public static boolean m1830() {
        return Build.MANUFACTURER.contains("HUAWEI");
    }

    /* renamed from: ޏ */
    public static boolean m1831() {
        String str = Build.BRAND;
        if (str != null && str.toLowerCase().contains("meizu")) {
            return true;
        }
        String str2 = Build.VERSION.INCREMENTAL;
        if (str2 != null && str2.toLowerCase().contains("flyme")) {
            return true;
        }
        String str3 = Build.DISPLAY;
        if (str3 != null && str3.toLowerCase().contains("flyme")) {
            return true;
        }
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: ސ */
    public static boolean m1832() {
        return !TextUtils.isEmpty(m1815("ro.miui.ui.version.name"));
    }

    /* renamed from: ֏ */
    public static boolean m1813(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.toLowerCase(Locale.US).trim();
        if (TextUtils.isEmpty(trim) || trim.contains("*") || EnvironmentCompat.MEDIA_UNKNOWN.equals(trim) || "0123456789abcdef".equals(trim) || trim.length() < 2) {
            return false;
        }
        char charAt = trim.charAt(1);
        for (int i = 0; i < trim.length(); i++) {
            if (charAt != trim.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ؠ */
    public static double m1814() {
        Double d = f1860;
        if (d != null) {
            return d.doubleValue();
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.os.PowerProfile");
            f1860 = Double.valueOf(((Double) cls.getMethod("getBatteryCapacity", new Class[0]).invoke(cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{AppUtils.getApplication()}), new Object[0])).doubleValue());
            return f1860.doubleValue();
        } catch (Throwable th) {
            String str = f1855;
            th.getMessage();
            return 0.0d;
        }
    }
}
