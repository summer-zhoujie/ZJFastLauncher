package com.wpengapp.support;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.p000v4.text.BidiFormatter;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.AnalyticsConstants;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.social.UMSocialConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.wpengapp.support.ڃ */
public class DeviceConfig {

    /* renamed from: ֏ */
    public static final String f2377 = "com.wpengapp.support.ڃ";

    /* renamed from: ֏ */
    public static boolean m2313(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() == 0) {
                    return true;
                }
            } catch (Exception unused) {
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: ؠ */
    public static String m2315() {
        if (!AnalyticsConstants.f102e) {
            return null;
        }
        String[] strArr = {"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
        int i = 0;
        while (i < strArr.length) {
            try {
                String r2 = m2310(strArr[i]);
                if (r2 != null) {
                    return r2;
                }
                i++;
            } catch (Exception e) {
                MLog.m1777(f2377, "open file  Failed", e);
            }
        }
        return null;
    }

    /* renamed from: ހ */
    public static String m2317(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Exception e) {
            MLog.m1770(MLog.f1805, f2377, e);
            return null;
        }
    }

    /* renamed from: ށ */
    public static Locale m2319(Context context) {
        Locale locale;
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Exception unused) {
            MLog.m1775(f2377, "fail to read user config locale");
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    /* renamed from: ނ */
    public static String m2321(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (m2313(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            MLog.m1778(f2377, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return BidiFormatter.EMPTY_STRING;
        } catch (Exception e) {
            String str = f2377;
            StringBuilder r4 = outline.m2549("Could not get mac address.");
            r4.append(e.toString());
            MLog.m1778(str, r4.toString());
            return BidiFormatter.EMPTY_STRING;
        }
    }

    /* renamed from: ރ */
    public static String m2322(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            return BidiFormatter.EMPTY_STRING;
        }
    }

    /* renamed from: ބ */
    public static String m2323(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return BidiFormatter.EMPTY_STRING;
        }
    }

    /* renamed from: ޅ */
    public static String m2324(Context context) {
        if (MobclickAgent.EScenarioType.E_UM_ANALYTICS_OEM.toValue() == AnalyticsConfig.getVerticalType(context) || MobclickAgent.EScenarioType.E_UM_GAME_OEM.toValue() == AnalyticsConfig.getVerticalType(context)) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 23) {
                String string = Settings.Secure.getString(context.getContentResolver(), UMSocialConstants.f260s);
                MLog.m1771(f2377, outline.m2556("getDeviceId, android_id: ", string));
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                String r1 = m2315();
                MLog.m1771(f2377, outline.m2556("getDeviceId, mc: ", r1));
                if (!TextUtils.isEmpty(r1)) {
                    return r1;
                }
                if (telephonyManager != null) {
                    try {
                        if (m2313(context, "android.permission.READ_PHONE_STATE")) {
                            r1 = telephonyManager.getDeviceId();
                            String str = f2377;
                            MLog.m1771(str, "getDeviceId, IMEI: " + r1);
                        }
                    } catch (Exception e) {
                        MLog.m1774(f2377, "No IMEI.", e);
                    }
                }
                if (!TextUtils.isEmpty(r1)) {
                    return r1;
                }
                int i = Build.VERSION.SDK_INT;
                String str2 = Build.SERIAL;
                MLog.m1771(f2377, outline.m2556("getDeviceId, serial no: ", str2));
                return str2;
            }
            String string2 = Settings.Secure.getString(context.getContentResolver(), UMSocialConstants.f260s);
            MLog.m1771(f2377, outline.m2556("getDeviceId: Secure.ANDROID_ID: ", string2));
            if (!TextUtils.isEmpty(string2)) {
                return string2;
            }
            MLog.m1778(f2377, "No IMEI.");
            String r12 = m2334(context);
            if (!TextUtils.isEmpty(r12) || telephonyManager == null) {
                return r12;
            }
            try {
                if (m2313(context, "android.permission.READ_PHONE_STATE")) {
                    return telephonyManager.getDeviceId();
                }
                return r12;
            } catch (Exception e2) {
                MLog.m1774(f2377, "No IMEI.", e2);
                return r12;
            }
        } else {
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
            int i2 = Build.VERSION.SDK_INT;
            String str3 = BidiFormatter.EMPTY_STRING;
            if (i2 >= 23) {
                if (telephonyManager2 != null) {
                    try {
                        if (m2313(context, "android.permission.READ_PHONE_STATE")) {
                            str3 = telephonyManager2.getDeviceId();
                            String str4 = f2377;
                            MLog.m1771(str4, "getDeviceId, IMEI: " + str3);
                        }
                    } catch (Exception e3) {
                        MLog.m1774(f2377, "No IMEI.", e3);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
                String r13 = m2315();
                MLog.m1771(f2377, outline.m2556("getDeviceId, mc: ", r13));
                if (!TextUtils.isEmpty(r13)) {
                    return r13;
                }
                String string3 = Settings.Secure.getString(context.getContentResolver(), UMSocialConstants.f260s);
                MLog.m1771(f2377, outline.m2556("getDeviceId, android_id: ", string3));
                if (!TextUtils.isEmpty(string3)) {
                    return string3;
                }
                int i3 = Build.VERSION.SDK_INT;
                String str5 = Build.SERIAL;
                MLog.m1771(f2377, outline.m2556("getDeviceId, serial no: ", str5));
                return str5;
            }
            if (telephonyManager2 != null) {
                try {
                    if (m2313(context, "android.permission.READ_PHONE_STATE")) {
                        str3 = telephonyManager2.getDeviceId();
                    }
                } catch (Exception e4) {
                    MLog.m1774(f2377, "No IMEI.", e4);
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
            MLog.m1778(f2377, "No IMEI.");
            String r132 = m2334(context);
            if (!TextUtils.isEmpty(r132)) {
                return r132;
            }
            MLog.m1778(f2377, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
            String string4 = Settings.Secure.getString(context.getContentResolver(), UMSocialConstants.f260s);
            MLog.m1771(f2377, outline.m2556("getDeviceId: Secure.ANDROID_ID: ", string4));
            return string4;
        }
    }

    /* renamed from: ކ */
    public static String m2325(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (m2313(context, "android.permission.READ_PHONE_STATE")) {
            return telephonyManager.getSubscriberId();
        }
        return null;
    }

    /* renamed from: އ */
    public static String m2326(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (m2313(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
            return BidiFormatter.EMPTY_STRING;
        } catch (Exception e) {
            e.printStackTrace();
            return BidiFormatter.EMPTY_STRING;
        }
    }

    /* renamed from: ވ */
    public static String[] m2327(Context context) {
        String[] strArr = {BidiFormatter.EMPTY_STRING, BidiFormatter.EMPTY_STRING};
        try {
            if (!m2313(context, "android.permission.ACCESS_NETWORK_STATE")) {
                strArr[0] = BidiFormatter.EMPTY_STRING;
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = BidiFormatter.EMPTY_STRING;
                return strArr;
            } else if (connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = "Wi-Fi";
                return strArr;
            } else {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "2G/3G";
                    strArr[1] = networkInfo.getSubtypeName();
                    return strArr;
                }
                return strArr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: މ */
    public static boolean m2328(Context context) {
        return "Wi-Fi".equals(m2327(context)[0]);
    }

    /* renamed from: ފ */
    public static boolean m2329(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: ދ */
    public static int m2330(Context context) {
        try {
            Calendar instance = Calendar.getInstance(m2319(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / 3600000;
            }
            return 8;
        } catch (Exception e) {
            MLog.m1770(f2377, "error in getTimeZone", e);
            return 8;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060 A[RETURN] */
    /* renamed from: ތ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m2331(Context r5) {
        /*
            com.wpengapp.support.ρ r0 = com.wpengapp.support.ImprintHandler.m1668((android.content.Context) r5)
            com.wpengapp.support.ρ$֏ r0 = r0.f1682
            java.lang.String r0 = r0.f1695
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            java.lang.String r0 = ""
        L_0x000d:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "cn"
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x001f
            boolean r5 = r0.equals(r2)
            if (r5 == 0) goto L_0x001e
            return r3
        L_0x001e:
            return r4
        L_0x001f:
            java.lang.String r0 = m2325(r5)
            if (r0 != 0) goto L_0x0038
            java.lang.String[] r5 = m2332(r5)
            r5 = r5[r4]
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0060
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0060
            return r3
        L_0x0038:
            android.content.res.Resources r0 = r5.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.mcc
            r1 = 460(0x1cc, float:6.45E-43)
            if (r0 == r1) goto L_0x0061
            r1 = 461(0x1cd, float:6.46E-43)
            if (r0 != r1) goto L_0x004b
            goto L_0x0061
        L_0x004b:
            if (r0 != 0) goto L_0x0060
            java.lang.String[] r5 = m2332(r5)
            r5 = r5[r4]
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0060
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0060
            return r3
        L_0x0060:
            return r4
        L_0x0061:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.DeviceConfig.m2331(android.content.Context):boolean");
    }

    /* renamed from: ލ */
    public static String[] m2332(Context context) {
        String[] strArr = new String[2];
        try {
            Locale r4 = m2319(context);
            if (r4 != null) {
                strArr[0] = r4.getCountry();
                strArr[1] = r4.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Exception e) {
            MLog.m1777(f2377, "error in getLocaleInfo", e);
            return strArr;
        }
    }

    /* renamed from: ގ */
    public static String m2333(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("UMENG_APPKEY");
            if (string != null) {
                return string.trim();
            }
            MLog.m1775(f2377, "getAppkey failed. the applicationinfo is null!");
            return null;
        } catch (Exception e) {
            MLog.m1777(f2377, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", e);
            return null;
        }
    }

    /* renamed from: ޏ */
    public static String m2334(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return m2321(context);
        }
        String r0 = m2315();
        return r0 == null ? m2321(context) : r0;
    }

    /* renamed from: ސ */
    public static int[] m2335(Context context) {
        int i;
        int i2;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                i = m2307((Object) displayMetrics, "noncompatWidthPixels");
                i2 = m2307((Object) displayMetrics, "noncompatHeightPixels");
            } else {
                i = -1;
                i2 = -1;
            }
            if (i == -1 || i2 == -1) {
                i = displayMetrics.widthPixels;
                i2 = displayMetrics.heightPixels;
            }
            int[] iArr = new int[2];
            if (i > i2) {
                iArr[0] = i2;
                iArr[1] = i;
            } else {
                iArr[0] = i;
                iArr[1] = i2;
            }
            return iArr;
        } catch (Exception e) {
            MLog.m1777(f2377, "read resolution fail", e);
            return null;
        }
    }

    /* renamed from: ޑ */
    public static String m2336(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("UMENG_CHANNEL")) == null) {
                return "Unknown";
            }
            String obj2 = obj.toString();
            if (obj2 != null) {
                return obj2;
            }
            MLog.m1771(f2377, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            return "Unknown";
        } catch (Exception e) {
            MLog.m1771(f2377, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            e.printStackTrace();
            return "Unknown";
        }
    }

    /* renamed from: ޒ */
    public static String m2337(Context context) {
        return context.getPackageName();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d A[SYNTHETIC, Splitter:B:16:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0038 A[SYNTHETIC, Splitter:B:22:0x0038] */
    /* renamed from: ހ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Properties m2318() {
        /*
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0027 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0027 }
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ IOException -> 0x0027 }
            java.lang.String r5 = "build.prop"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x0027 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0027 }
            r0.load(r2)     // Catch:{ IOException -> 0x0020, all -> 0x001d }
            r2.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x001d:
            r0 = move-exception
            r1 = r2
            goto L_0x0036
        L_0x0020:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0028
        L_0x0025:
            r0 = move-exception
            goto L_0x0036
        L_0x0027:
            r2 = move-exception
        L_0x0028:
            r2.printStackTrace()     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0035:
            return r0
        L_0x0036:
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0040:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.DeviceConfig.m2318():java.util.Properties");
    }

    /* renamed from: ؠ */
    public static String m2316(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    /* renamed from: ֏ */
    public static String[] m2314(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Exception e) {
            MLog.m1777(f2377, "Could not read gpu infor:", e);
            return new String[0];
        }
    }

    /* renamed from: ށ */
    public static boolean m2320() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049 A[SYNTHETIC, Splitter:B:25:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0058 A[SYNTHETIC, Splitter:B:34:0x0058] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m2310(String r7) {
        /*
            java.io.FileReader r0 = new java.io.FileReader
            r0.<init>(r7)
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0027, all -> 0x0024 }
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r0, r3)     // Catch:{ IOException -> 0x0027, all -> 0x0024 }
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x0022 }
            r0.close()     // Catch:{ IOException -> 0x0015 }
            goto L_0x0019
        L_0x0015:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0019:
            r2.close()     // Catch:{ IOException -> 0x001d }
            goto L_0x004c
        L_0x001d:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x004c
        L_0x0022:
            r3 = move-exception
            goto L_0x0029
        L_0x0024:
            r7 = move-exception
            r2 = r1
            goto L_0x004e
        L_0x0027:
            r3 = move-exception
            r2 = r1
        L_0x0029:
            java.lang.String r4 = f2377     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r5.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r6 = "Could not read from file "
            r5.append(r6)     // Catch:{ all -> 0x004d }
            r5.append(r7)     // Catch:{ all -> 0x004d }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x004d }
            com.wpengapp.support.MLog.m1777(r4, r7, r3)     // Catch:{ all -> 0x004d }
            r0.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0047:
            if (r2 == 0) goto L_0x004c
            r2.close()     // Catch:{ IOException -> 0x001d }
        L_0x004c:
            return r1
        L_0x004d:
            r7 = move-exception
        L_0x004e:
            r0.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0056:
            if (r2 == 0) goto L_0x0060
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0060:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.DeviceConfig.m2310(java.lang.String):java.lang.String");
    }

    /* renamed from: ֏ */
    public static String m2308() {
        String str = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                str = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                MLog.m1777(f2377, "Could not read from file /proc/cpuinfo", e);
            }
        } catch (FileNotFoundException e2) {
            MLog.m1777(f2377, "Could not open file /proc/cpuinfo", e2);
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : BidiFormatter.EMPTY_STRING;
    }

    /* renamed from: ֏ */
    public static int m2307(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: ֏ */
    public static String m2309(Context context) {
        PackageInfo packageInfo;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(m2337(context), 64);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
        try {
            certificateFactory = CertificateFactory.getInstance("X509");
        } catch (CertificateException e2) {
            e2.printStackTrace();
            certificateFactory = null;
        }
        try {
            x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
        } catch (CertificateException e3) {
            e3.printStackTrace();
            x509Certificate = null;
        }
        try {
            return m2312(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return null;
        } catch (CertificateEncodingException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static String m2312(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = outline.m2556("0", hexString);
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    /* renamed from: ֏ */
    public static String m2311(Properties properties) {
        String property = properties.getProperty("ro.yunos.version");
        if (!TextUtils.isEmpty(property)) {
            return property;
        }
        return null;
    }
}
