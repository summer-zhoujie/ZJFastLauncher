package com.wpengapp.support;

import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.support.p000v4.app.NotificationCompatJellybean;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.JsonArray;
import com.umeng.analytics.AnalyticsConstants;
import com.umeng.analytics.social.UMSocialConstants;
import com.wpengapp.http.RequestHelper;
import com.wpengapp.support.activity.CommonWebActivity;
import com.wpengapp.support.licensing.model.AppDevice;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* renamed from: com.wpengapp.support.ҟ */
public class Utils {

    /* renamed from: ֏ */
    public static String f1896;

    /* renamed from: ؠ */
    public static BrandConfig f1897;

    /* renamed from: ހ */
    public static int f1898;

    /* renamed from: ֏ */
    public static final byte m1855(byte b, int i, boolean z) {
        return (byte) (z ? b | (1 << i) : b & (~(1 << i)));
    }

    /* renamed from: ֏ */
    public static String m1864(int i, Object... objArr) {
        return AppUtils.getApplication().getResources().getString(i, objArr);
    }

    /* renamed from: ֏ */
    public static final boolean m1879(byte b, int i) {
        return (b & (1 << i)) != 0;
    }

    /* renamed from: ؠ */
    public static boolean m1893() {
        if (SystemUtils.f3711 < 23) {
            return m1908();
        }
        if (C0719.m1831()) {
            return m1908();
        }
        return Settings.canDrawOverlays(AppUtils.getApplication());
    }

    /* renamed from: ހ */
    public static String m1901(Context context) {
        if (TextUtils.isEmpty(f1896)) {
            f1896 = RemoteSP.m1202(UMSocialConstants.f254m, (String) null);
            if (TextUtils.isEmpty(f1896)) {
                f1896 = MCPTool.m1261(context.getApplicationContext(), (String) null, (String) null);
                if (TextUtils.isEmpty(f1896)) {
                    f1896 = BaseApplication.f562 ? "WPeng_debug" : "WPeng";
                } else {
                    RemoteSP.m1206(UMSocialConstants.f254m, (Object) f1896, false);
                }
            }
        }
        return f1896;
    }

    /* renamed from: ށ */
    public static BrandConfig m1905() {
        BrandConfig r0 = f1897;
        if (r0 != null) {
            return r0;
        }
        if ("Huawei".equalsIgnoreCase(Build.BRAND) || "HONOR".equalsIgnoreCase(Build.BRAND)) {
            f1897 = new Huawei();
        } else if ("vivo".equalsIgnoreCase(Build.BRAND)) {
            f1897 = new Vivo();
        } else if ("OPPO".equalsIgnoreCase(Build.BRAND) || "Realme".equalsIgnoreCase(Build.BRAND)) {
            f1897 = new Oppo();
        } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND) || "Redmi".equalsIgnoreCase(Build.BRAND)) {
            f1897 = new Xiaomi();
        } else if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
            f1897 = new Meizu();
        } else if ("Samsung".equalsIgnoreCase(Build.BRAND)) {
            f1897 = new Samsung();
        } else if ("ONEPLUS".equalsIgnoreCase(Build.BRAND)) {
            f1897 = new OnePlus();
        } else {
            f1897 = new OtherBrand();
        }
        return f1897;
    }

    @Deprecated
    /* renamed from: ނ */
    public static String m1907() {
        if (Build.VERSION.SDK_INT >= 29) {
            return BidiFormatter.EMPTY_STRING;
        }
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(C0719.m1820());
        jsonArray.add(C0719.m1821());
        jsonArray.add(C0719.m1826());
        jsonArray.add(C0719.m1822());
        jsonArray.add(C0719.m1823());
        jsonArray.add(C0719.m1817());
        jsonArray.add(Build.BRAND);
        jsonArray.add(Build.MODEL);
        jsonArray.add(C0719.m1824());
        jsonArray.add(Build.VERSION.RELEASE + " (" + Build.VERSION.SDK_INT + ") " + Build.DISPLAY);
        jsonArray.add(C0678.f1766.getPackageName());
        jsonArray.add(BidiFormatter.EMPTY_STRING);
        jsonArray.add(C0719.m1818());
        try {
            return RequestHelper.m338(jsonArray.toString());
        } catch (Exception e) {
            e.getMessage();
            return BidiFormatter.EMPTY_STRING;
        }
    }

    /* renamed from: ރ */
    public static boolean m1908() {
        if ("OPPO".equalsIgnoreCase(Build.BRAND)) {
            return true;
        }
        if (SystemUtils.f3711 >= 19) {
            if (m1856(24) == 0) {
                return true;
            }
            return false;
        } else if (!C0719.m1832() || (AppUtils.getApplication().getApplicationInfo().flags & 134217728) == 134217728) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: ބ */
    public static void m1909() {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.appEnterActivity");
            SystemUtils.m3510((Context) null, intent);
        } catch (Exception unused) {
            m1910();
        }
    }

    /* renamed from: ޅ */
    public static void m1910() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", AppUtils.m1163(), (String) null));
            SystemUtils.m3510((Context) null, intent);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ކ */
    public static void m1911() {
        if (SystemUtils.f3711 < 23) {
            if (C0719.m1832()) {
                m1913();
            } else if (C0719.m1831()) {
                m1912();
            } else if (C0719.m1830()) {
                try {
                    Intent intent = new Intent(AppUtils.m1163());
                    intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
                    SystemUtils.m3510((Context) null, intent);
                } catch (Exception e) {
                    e.getMessage();
                    try {
                        Intent intent2 = new Intent();
                        intent2.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                        SystemUtils.m3510((Context) null, intent2);
                    } catch (Exception e2) {
                        e2.getMessage();
                        m1873();
                    }
                }
            } else if (C0719.m1829()) {
                Intent intent3 = new Intent();
                intent3.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
                try {
                    SystemUtils.m3510((Context) null, intent3);
                } catch (Exception unused) {
                    m1909();
                }
            } else {
                m1910();
            }
        } else if (C0719.m1831()) {
            m1912();
        } else {
            try {
                Intent intent4 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                intent4.setData(Uri.parse("package:" + AppUtils.m1163()));
                SystemUtils.m3510((Context) null, intent4);
            } catch (Exception e3) {
                e3.getMessage();
                m1910();
            }
        }
    }

    /* renamed from: އ */
    public static void m1912() {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("packageName", AppUtils.m1163());
        try {
            SystemUtils.m3510((Context) null, intent);
        } catch (Exception e) {
            e.getMessage();
            m1910();
        }
    }

    /* renamed from: ވ */
    public static void m1913() {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", AppUtils.m1163());
        try {
            SystemUtils.m3510((Context) null, intent);
        } catch (Exception e) {
            e.getMessage();
            Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent2.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity"));
            intent2.putExtra("extra_pkgname", AppUtils.m1163());
            try {
                SystemUtils.m3510((Context) null, intent2);
            } catch (Exception e2) {
                e2.getMessage();
                Intent intent3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                intent3.setPackage("com.miui.securitycenter");
                intent3.putExtra("extra_pkgname", AppUtils.m1163());
                try {
                    SystemUtils.m3510((Context) null, intent3);
                } catch (Exception e3) {
                    e3.getMessage();
                    m1910();
                }
            }
        }
    }

    /* renamed from: މ */
    public static void m1914() {
        if (SystemUtils.f3711 < 23) {
            if (C0719.m1832()) {
                m1913();
            } else if (C0719.m1831()) {
                m1912();
            } else if (C0719.m1830()) {
                m1873();
            } else if (C0719.m1829()) {
                try {
                    Intent intent = new Intent();
                    intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.appEnterActivity");
                    SystemUtils.m3510((Context) null, intent);
                } catch (Exception unused) {
                    m1910();
                }
            } else {
                m1910();
            }
        } else if (C0719.m1831()) {
            m1912();
        } else {
            m1910();
        }
    }

    /* renamed from: ֏ */
    public static long m1859(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    /* renamed from: ֏ */
    public static SharedPreferences m1861(Context context) {
        return context.getSharedPreferences("umeng_general_config", 0);
    }

    /* renamed from: ֏ */
    public static boolean m1883(Bitmap bitmap, Bitmap.CompressFormat compressFormat, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(str);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bitmap.compress(compressFormat, 100, fileOutputStream2);
                fileOutputStream2.flush();
                FileUtils.close((Closeable) fileOutputStream2);
                return true;
            } catch (Exception e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    e.getMessage();
                    FileUtils.close((Closeable) fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    FileUtils.close((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                FileUtils.close((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.getMessage();
            FileUtils.close((Closeable) fileOutputStream);
            return false;
        }
    }

    /* renamed from: ؠ */
    public static boolean m1895(String str) {
        return !str.equals("GET") && !str.equals("HEAD");
    }

    /* renamed from: ؠ */
    public static C1049 m1890(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            AdvertisingId r0 = new AdvertisingId((C1068) null);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, r0, 1)) {
                try {
                    C1053 r1 = new C1053(r0.mo8916());
                    C1049 r3 = new C1049(r1.mo9224(), r1.mo9225(true));
                    context.unbindService(r0);
                    return r3;
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    context.unbindService(r0);
                    throw th;
                }
            } else {
                throw new IOException("Google Play connection failed");
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ހ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m1902(String r7) {
        /*
            if (r7 == 0) goto L_0x0069
            int r0 = r7.length()
            if (r0 != 0) goto L_0x000a
            goto L_0x0069
        L_0x000a:
            r0 = 0
            r1 = 0
            byte[] r2 = android.util.Base64.decode(r7, r0)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            r4.<init>()     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0040, all -> 0x003e }
        L_0x0023:
            int r5 = r2.read(r1)     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            r6 = -1
            if (r5 == r6) goto L_0x002e
            r4.write(r1, r0, r5)     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            goto L_0x0023
        L_0x002e:
            java.lang.String r0 = "UTF-8"
            java.lang.String r7 = r4.toString(r0)     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r2)
        L_0x0037:
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r3)
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r4)
            return r7
        L_0x003e:
            r7 = move-exception
            goto L_0x005e
        L_0x0040:
            r0 = move-exception
            goto L_0x0046
        L_0x0042:
            r7 = move-exception
            goto L_0x005f
        L_0x0044:
            r0 = move-exception
            r4 = r1
        L_0x0046:
            r1 = r2
            goto L_0x0055
        L_0x0048:
            r7 = move-exception
            r2 = r1
            goto L_0x005f
        L_0x004b:
            r0 = move-exception
            r4 = r1
            goto L_0x0055
        L_0x004e:
            r7 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x005f
        L_0x0052:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x0055:
            r0.getMessage()     // Catch:{ all -> 0x005c }
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r1)
            goto L_0x0037
        L_0x005c:
            r7 = move-exception
            r2 = r1
        L_0x005e:
            r1 = r4
        L_0x005f:
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r2)
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r3)
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r1)
            throw r7
        L_0x0069:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Utils.m1902(java.lang.String):java.lang.String");
    }

    /* renamed from: ֏ */
    public static int m1857(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    /* renamed from: ֏ */
    public static String m1865(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = (instance.get(12) / 6) + 1 + (instance.get(11) * 10);
        long j2 = 0;
        try {
            long time = j - new SimpleDateFormat("yyyy").parse("1970").getTime();
            long j3 = time / AnalyticsConstants.f107j;
            if (time % AnalyticsConstants.f107j > 0) {
                j2 = 1;
            }
            j2 += j3;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf((j2 * 240) + ((long) (i - 1)));
    }

    /* renamed from: ށ */
    public static void m1906(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstant.m2593() + "/romsetting");
        sb.append("?brand=");
        sb.append(m1905().getName());
        sb.append("&appId=");
        sb.append(AppUtils.m1163());
        CommonWebActivity.m784(context, sb.toString(), context.getString(R$string.pw_rom_setting_guide), true, (String) null);
    }

    /* renamed from: ؠ */
    public static String m1891(String str, String str2) {
        return Base64.encodeToString(m1899(str.getBytes(), str2.getBytes()), 0);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* renamed from: ؠ */
    public static int m1889(SQLiteDatabase sQLiteDatabase, String str) {
        ? r0 = 0;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, r0);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (Exception e) {
            MLog.m1776("count error " + e.toString());
            if (r0 != 0) {
                r0.close();
            }
            return 0;
        } catch (Throwable th) {
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    /* renamed from: ֏ */
    public static Bitmap m1862(Drawable drawable) {
        return m1863(drawable, -1, -1);
    }

    /* renamed from: ؠ */
    public static byte[] m1897(byte[] bArr) {
        ZipOutputStream zipOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            } catch (Exception e) {
                e = e;
                zipOutputStream = null;
                try {
                    e.getMessage();
                    FileUtils.close((Closeable) byteArrayOutputStream);
                    FileUtils.close((Closeable) zipOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    FileUtils.close((Closeable) byteArrayOutputStream);
                    FileUtils.close((Closeable) zipOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = null;
                FileUtils.close((Closeable) byteArrayOutputStream);
                FileUtils.close((Closeable) zipOutputStream);
                throw th;
            }
            try {
                zipOutputStream.putNextEntry(new ZipEntry("0"));
                zipOutputStream.write(bArr);
                zipOutputStream.finish();
                zipOutputStream.closeEntry();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                FileUtils.close((Closeable) byteArrayOutputStream);
                FileUtils.close((Closeable) zipOutputStream);
                return byteArray;
            } catch (Exception e2) {
                e = e2;
                e.getMessage();
                FileUtils.close((Closeable) byteArrayOutputStream);
                FileUtils.close((Closeable) zipOutputStream);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            zipOutputStream = null;
            e.getMessage();
            FileUtils.close((Closeable) byteArrayOutputStream);
            FileUtils.close((Closeable) zipOutputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            zipOutputStream = null;
            FileUtils.close((Closeable) byteArrayOutputStream);
            FileUtils.close((Closeable) zipOutputStream);
            throw th;
        }
    }

    /* renamed from: ހ */
    public static AppDevice m1900() {
        String[] strArr;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        BufferedWriter bufferedWriter;
        InputStream inputStream;
        AppDevice appDevice = new AppDevice();
        appDevice.channel = WPengServer.f842;
        appDevice.deviceId = C0719.m1820();
        appDevice.carrier = C0719.m1817();
        appDevice.imei = C0719.m1821();
        appDevice.f701sn = C0719.m1826();
        appDevice.mac = C0719.m1822();
        appDevice.tel = C0719.m1823();
        appDevice.model = C0719.m1816();
        appDevice.resolution = C0719.m1824();
        appDevice.osVersion = String.valueOf(Build.VERSION.SDK_INT);
        appDevice.osInfo = Build.VERSION.RELEASE + " (" + Build.VERSION.SDK_INT + ") " + Build.DISPLAY;
        appDevice.language = C0719.m1818();
        appDevice.root = Integer.valueOf(C0719.m1828() ? 1 : 0);
        appDevice.battery = Double.valueOf(C0719.m1814());
        appDevice.cpuTotalFreq = Integer.valueOf(C0719.m1819());
        appDevice.aid = C0719.m1812();
        String str = C0719.f1861;
        if (str == null) {
            str = null;
            try {
                Process exec = Runtime.getRuntime().exec("sh");
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(exec.getOutputStream()));
                try {
                    bufferedWriter.write("cat /proc/cpuinfo | grep Hardware\n");
                    bufferedWriter.write("exit\n");
                    bufferedWriter.flush();
                    exec.waitFor();
                    inputStream = exec.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = inputStream.read(bArr, 0, bArr.length);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (Exception e2) {
                                e = e2;
                                String str2 = C0719.f1855;
                                e.getMessage();
                                FileUtils.close((Closeable) inputStream);
                                FileUtils.close((Closeable) byteArrayOutputStream);
                                FileUtils.close((Closeable) bufferedWriter);
                                appDevice.cpu = str;
                                int i = Build.VERSION.SDK_INT;
                                strArr = Build.SUPPORTED_ABIS;
                                appDevice.abi = strArr[0];
                                return appDevice;
                            }
                        }
                        byteArrayOutputStream.flush();
                        String trim = new String(byteArrayOutputStream.toByteArray()).trim();
                        if (!TextUtils.isEmpty(trim)) {
                            String[] split = trim.split(":");
                            if (split.length > 1) {
                                C0719.f1861 = split[1].trim();
                                str = C0719.f1861;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                        String str22 = C0719.f1855;
                        e.getMessage();
                        FileUtils.close((Closeable) inputStream);
                        FileUtils.close((Closeable) byteArrayOutputStream);
                        FileUtils.close((Closeable) bufferedWriter);
                        appDevice.cpu = str;
                        int i2 = Build.VERSION.SDK_INT;
                        strArr = Build.SUPPORTED_ABIS;
                        appDevice.abi = strArr[0];
                        return appDevice;
                    }
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                    byteArrayOutputStream = null;
                    String str222 = C0719.f1855;
                    e.getMessage();
                    FileUtils.close((Closeable) inputStream);
                    FileUtils.close((Closeable) byteArrayOutputStream);
                    FileUtils.close((Closeable) bufferedWriter);
                    appDevice.cpu = str;
                    int i22 = Build.VERSION.SDK_INT;
                    strArr = Build.SUPPORTED_ABIS;
                    appDevice.abi = strArr[0];
                    return appDevice;
                }
            } catch (Exception e5) {
                e = e5;
                inputStream = null;
                bufferedWriter = null;
                byteArrayOutputStream = null;
                String str2222 = C0719.f1855;
                e.getMessage();
                FileUtils.close((Closeable) inputStream);
                FileUtils.close((Closeable) byteArrayOutputStream);
                FileUtils.close((Closeable) bufferedWriter);
                appDevice.cpu = str;
                int i222 = Build.VERSION.SDK_INT;
                strArr = Build.SUPPORTED_ABIS;
                appDevice.abi = strArr[0];
                return appDevice;
            }
        }
        appDevice.cpu = str;
        int i2222 = Build.VERSION.SDK_INT;
        strArr = Build.SUPPORTED_ABIS;
        if (strArr != null && strArr.length > 0) {
            appDevice.abi = strArr[0];
        }
        return appDevice;
    }

    /* renamed from: ֏ */
    public static Bitmap m1863(Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (i > 0 && i2 > 0) {
                int height = bitmap.getHeight();
                int width = bitmap.getWidth();
                Matrix matrix = new Matrix();
                matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        if (i <= 0 || i2 <= 0) {
            i = drawable.getIntrinsicWidth();
            i2 = drawable.getIntrinsicHeight();
            bitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } else {
            bitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        Bitmap bitmap3 = bitmap2;
        Canvas canvas = new Canvas(bitmap3);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(canvas);
        return bitmap3;
    }

    /* renamed from: ֏ */
    public static byte[] m1885(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr2, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e = e;
                try {
                    e.getMessage();
                    m1878((Closeable) byteArrayOutputStream);
                    m1878((Closeable) inputStream);
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            byteArrayOutputStream = null;
            e.getMessage();
            m1878((Closeable) byteArrayOutputStream);
            m1878((Closeable) inputStream);
            return bArr;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            byteArrayOutputStream = null;
            th = th3;
            m1878((Closeable) byteArrayOutputStream);
            m1878((Closeable) inputStream);
            throw th;
        }
        m1878((Closeable) byteArrayOutputStream);
        m1878((Closeable) inputStream);
        return bArr;
    }

    /* renamed from: ؠ */
    public static int m1888(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return instance.get(5);
    }

    /* renamed from: ؠ */
    public static boolean m1896(List<ComponentName> list) {
        boolean z;
        if (CollectionUtils.m1657((Collection) list)) {
            return false;
        }
        for (ComponentName next : list) {
            if (TextUtils.isEmpty(next.getClassName())) {
                z = SystemUtils.m3530(next.getPackageName());
                continue;
            } else {
                z = SystemUtils.m3528(next.getPackageName(), next.getClassName());
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ؠ */
    public static byte[] m1899(byte[] bArr, byte[] bArr2) {
        SecureRandom secureRandom = new SecureRandom();
        SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("DES/ECB/PKCS5Padding");
        instance.init(1, generateSecret, secureRandom);
        return instance.doFinal(bArr);
    }

    /* renamed from: ֏ */
    public static boolean m1881(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            if (m1889(sQLiteDatabase, str) < 0) {
                return true;
            }
            sQLiteDatabase.execSQL("delete from " + str);
            return true;
        } catch (SQLException e) {
            StringBuilder r3 = outline.m2549("cleanTableData faild!");
            r3.append(e.toString());
            MLog.m1776(r3.toString());
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b1, code lost:
        if (r1 == 0) goto L_0x00b6;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m1894(SQLiteDatabase r6, com.wpengapp.support.Callback r7) {
        /*
            java.lang.String r0 = "key"
            r1 = 0
            r2 = 0
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SQLException -> 0x0080 }
            r3.<init>()     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = "select * from aggregated_cache"
            android.database.Cursor r1 = r6.rawQuery(r4, r1)     // Catch:{ SQLException -> 0x0080 }
        L_0x000f:
            boolean r6 = r1.moveToNext()     // Catch:{ SQLException -> 0x0080 }
            if (r6 == 0) goto L_0x0082
            com.wpengapp.support.શ r6 = new com.wpengapp.support.શ     // Catch:{ SQLException -> 0x0080 }
            r6.<init>()     // Catch:{ SQLException -> 0x0080 }
            int r4 = r1.getColumnIndex(r0)     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ SQLException -> 0x0080 }
            java.util.List r4 = m1871((java.lang.String) r4)     // Catch:{ SQLException -> 0x0080 }
            r6.f3178 = r4     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = "label"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ SQLException -> 0x0080 }
            java.util.List r4 = m1871((java.lang.String) r4)     // Catch:{ SQLException -> 0x0080 }
            r6.f3179 = r4     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = "count"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ SQLException -> 0x0080 }
            int r4 = r1.getInt(r4)     // Catch:{ SQLException -> 0x0080 }
            long r4 = (long) r4     // Catch:{ SQLException -> 0x0080 }
            r6.f3182 = r4     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = "value"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ SQLException -> 0x0080 }
            int r4 = r1.getInt(r4)     // Catch:{ SQLException -> 0x0080 }
            long r4 = (long) r4     // Catch:{ SQLException -> 0x0080 }
            r6.f3181 = r4     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = "timeWindowNum"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ SQLException -> 0x0080 }
            r6.f3183 = r4     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = "totalTimestamp"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ SQLException -> 0x0080 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ SQLException -> 0x0080 }
            r6.f3180 = r4     // Catch:{ SQLException -> 0x0080 }
            int r4 = r1.getColumnIndex(r0)     // Catch:{ SQLException -> 0x0080 }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ SQLException -> 0x0080 }
            java.util.List r4 = m1871((java.lang.String) r4)     // Catch:{ SQLException -> 0x0080 }
            r3.put(r4, r6)     // Catch:{ SQLException -> 0x0080 }
            goto L_0x000f
        L_0x007e:
            r6 = move-exception
            goto L_0x00b7
        L_0x0080:
            r6 = move-exception
            goto L_0x0092
        L_0x0082:
            int r6 = r3.size()     // Catch:{ SQLException -> 0x0080 }
            if (r6 <= 0) goto L_0x008c
            r7.mo7310a(r3, r2)     // Catch:{ SQLException -> 0x0080 }
            goto L_0x00b3
        L_0x008c:
            java.lang.String r6 = "faild"
            r7.mo7310a(r6, r2)     // Catch:{ SQLException -> 0x0080 }
            goto L_0x00b3
        L_0x0092:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x007e }
            r7.mo7310a(r0, r2)     // Catch:{ all -> 0x007e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r7.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r0 = "cacheToMemory happen "
            r7.append(r0)     // Catch:{ all -> 0x007e }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x007e }
            r7.append(r6)     // Catch:{ all -> 0x007e }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x007e }
            com.wpengapp.support.MLog.m1776(r6)     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x00b6
        L_0x00b3:
            r1.close()
        L_0x00b6:
            return r2
        L_0x00b7:
            if (r1 == 0) goto L_0x00bc
            r1.close()
        L_0x00bc:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Utils.m1894(android.database.sqlite.SQLiteDatabase, com.wpengapp.support.ಏ):boolean");
    }

    /* renamed from: ֏ */
    public static String m1867(HttpUrl r2) {
        String r0 = r2.mo9367();
        String r22 = r2.mo9370();
        if (r22 == null) {
            return r0;
        }
        return r0 + '?' + r22;
    }

    /* renamed from: ֏ */
    public static int m1856(int i) {
        if (SystemUtils.f3711 >= 19) {
            try {
                return ((Integer) new Reflect((Object) (AppOpsManager) AppUtils.getApplication().getSystemService("appops")).getMethod("checkOp", Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), AppUtils.m1163()).cls).intValue();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return 0;
    }

    /* renamed from: ހ */
    public static byte[] m1904(String str, String str2) {
        return m1899(str.getBytes(), str2.getBytes());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* renamed from: ހ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static List<String> m1903(SQLiteDatabase r5) {
        /*
            r0 = 0
            java.lang.String r1 = "limitedck"
            int r1 = m1889((android.database.sqlite.SQLiteDatabase) r5, (java.lang.String) r1)     // Catch:{ SQLException -> 0x0033, all -> 0x002e }
            if (r1 <= 0) goto L_0x0052
            java.lang.String r1 = "select * from limitedck"
            android.database.Cursor r5 = r5.rawQuery(r1, r0)     // Catch:{ SQLException -> 0x0033, all -> 0x002e }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ SQLException -> 0x002c }
            r1.<init>()     // Catch:{ SQLException -> 0x002c }
        L_0x0014:
            boolean r2 = r5.moveToNext()     // Catch:{ SQLException -> 0x002c }
            if (r2 == 0) goto L_0x0028
            java.lang.String r2 = "ck"
            int r2 = r5.getColumnIndex(r2)     // Catch:{ SQLException -> 0x002c }
            java.lang.String r2 = r5.getString(r2)     // Catch:{ SQLException -> 0x002c }
            r1.add(r2)     // Catch:{ SQLException -> 0x002c }
            goto L_0x0014
        L_0x0028:
            r5.close()
            return r1
        L_0x002c:
            r1 = move-exception
            goto L_0x0035
        L_0x002e:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x0054
        L_0x0033:
            r1 = move-exception
            r5 = r0
        L_0x0035:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r2.<init>()     // Catch:{ all -> 0x0053 }
            java.lang.String r3 = "loadLimitCKFromDB error "
            r2.append(r3)     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0053 }
            r2.append(r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0053 }
            com.wpengapp.support.MLog.m1776(r1)     // Catch:{ all -> 0x0053 }
            if (r5 == 0) goto L_0x0052
            r5.close()
        L_0x0052:
            return r0
        L_0x0053:
            r0 = move-exception
        L_0x0054:
            if (r5 == 0) goto L_0x0059
            r5.close()
        L_0x0059:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Utils.m1903(android.database.sqlite.SQLiteDatabase):java.util.List");
    }

    /* renamed from: ֏ */
    public static void m1878(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ֏ */
    public static long m1858(long j, int i) {
        int i2;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i3 = (instance.get(12) / 6) + 1 + (instance.get(11) * 10);
        int i4 = instance.get(13);
        if (i == 1002) {
            i2 = 360 - (((instance.get(12) % 6) * 60) + i4);
        } else if (i == 1001) {
            i2 = 60 - (i4 % 60);
            if (i3 % 6 == 0) {
                i2 += 60;
            }
        } else {
            i2 = 0;
        }
        return (long) (i2 * 1000);
    }

    /* renamed from: ֏ */
    public static boolean m1882(SQLiteDatabase sQLiteDatabase, Collection<UMCCAggregatedObject> collection) {
        try {
            sQLiteDatabase.beginTransaction();
            if (m1889(sQLiteDatabase, "aggregated_cache") > 0) {
                m1881(sQLiteDatabase, "aggregated_cache");
            }
            for (UMCCAggregatedObject r1 : collection) {
                sQLiteDatabase.insert("aggregated_cache", (String) null, m1860(r1));
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            return true;
        } catch (SQLException unused) {
            MLog.m1776("insert to Aggregated cache table faild!");
            sQLiteDatabase.endTransaction();
            return false;
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    /* renamed from: ؠ */
    public static byte[] m1898(byte[] bArr, String str) {
        byte[] bArr2;
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, generatePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 128) {
                    bArr2 = instance.doFinal(bArr, i, 128);
                } else {
                    bArr2 = instance.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                i2++;
                i = i2 * 128;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    /* renamed from: ֏ */
    public static String m1869(List<String> list) {
        return TextUtils.join("!", list);
    }

    /* renamed from: ֏ */
    public static String m1868(String str, String str2) {
        if (str == null) {
            return null;
        }
        return new String(m1887(Base64.decode(str, 0), str2.getBytes("UTF-8")), "UTF-8");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b8  */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<String, List<com.wpengapp.support.UMEntry.C0551>> m1892(SQLiteDatabase r8) {
        /*
            r0 = 0
            java.lang.String r1 = "aggregated"
            int r1 = m1889((android.database.sqlite.SQLiteDatabase) r8, (java.lang.String) r1)     // Catch:{ SQLException -> 0x0095, all -> 0x0090 }
            if (r1 <= 0) goto L_0x00b4
            java.lang.String r1 = "select * from aggregated"
            android.database.Cursor r8 = r8.rawQuery(r1, r0)     // Catch:{ SQLException -> 0x0095, all -> 0x0090 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ SQLException -> 0x008e }
            r1.<init>()     // Catch:{ SQLException -> 0x008e }
        L_0x0014:
            boolean r2 = r8.moveToNext()     // Catch:{ SQLException -> 0x008e }
            if (r2 == 0) goto L_0x008a
            java.lang.String r2 = "key"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ SQLException -> 0x008e }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ SQLException -> 0x008e }
            boolean r3 = r1.containsKey(r2)     // Catch:{ SQLException -> 0x008e }
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r1.get(r2)     // Catch:{ SQLException -> 0x008e }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLException -> 0x008e }
            r1.remove(r2)     // Catch:{ SQLException -> 0x008e }
            goto L_0x0039
        L_0x0034:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLException -> 0x008e }
            r3.<init>()     // Catch:{ SQLException -> 0x008e }
        L_0x0039:
            com.wpengapp.support.ȴ$ށ r4 = new com.wpengapp.support.ȴ$ށ     // Catch:{ SQLException -> 0x008e }
            r4.<init>()     // Catch:{ SQLException -> 0x008e }
            java.lang.String r5 = "label"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ SQLException -> 0x008e }
            java.lang.String r5 = r8.getString(r5)     // Catch:{ SQLException -> 0x008e }
            java.util.List r5 = m1871((java.lang.String) r5)     // Catch:{ SQLException -> 0x008e }
            r4.f1113 = r5     // Catch:{ SQLException -> 0x008e }
            java.lang.String r5 = "value"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ SQLException -> 0x008e }
            long r5 = r8.getLong(r5)     // Catch:{ SQLException -> 0x008e }
            r4.f1109 = r5     // Catch:{ SQLException -> 0x008e }
            java.lang.String r5 = "totalTimestamp"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ SQLException -> 0x008e }
            long r5 = r8.getLong(r5)     // Catch:{ SQLException -> 0x008e }
            r4.f1110 = r5     // Catch:{ SQLException -> 0x008e }
            java.lang.String r5 = "timeWindowNum"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ SQLException -> 0x008e }
            java.lang.String r5 = r8.getString(r5)     // Catch:{ SQLException -> 0x008e }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ SQLException -> 0x008e }
            r4.f1111 = r5     // Catch:{ SQLException -> 0x008e }
            java.lang.String r5 = "count"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ SQLException -> 0x008e }
            long r5 = r8.getLong(r5)     // Catch:{ SQLException -> 0x008e }
            int r6 = (int) r5     // Catch:{ SQLException -> 0x008e }
            r4.f1112 = r6     // Catch:{ SQLException -> 0x008e }
            r3.add(r4)     // Catch:{ SQLException -> 0x008e }
            r1.put(r2, r3)     // Catch:{ SQLException -> 0x008e }
            goto L_0x0014
        L_0x008a:
            r8.close()
            return r1
        L_0x008e:
            r1 = move-exception
            goto L_0x0097
        L_0x0090:
            r8 = move-exception
            r7 = r0
            r0 = r8
            r8 = r7
            goto L_0x00b6
        L_0x0095:
            r1 = move-exception
            r8 = r0
        L_0x0097:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            r2.<init>()     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = "readAllAggregatedDataForUpload error "
            r2.append(r3)     // Catch:{ all -> 0x00b5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b5 }
            r2.append(r1)     // Catch:{ all -> 0x00b5 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00b5 }
            com.wpengapp.support.MLog.m1776(r1)     // Catch:{ all -> 0x00b5 }
            if (r8 == 0) goto L_0x00b4
            r8.close()
        L_0x00b4:
            return r0
        L_0x00b5:
            r0 = move-exception
        L_0x00b6:
            if (r8 == 0) goto L_0x00bb
            r8.close()
        L_0x00bb:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Utils.m1892(android.database.sqlite.SQLiteDatabase):java.util.Map");
    }

    /* renamed from: ֏ */
    public static List<String> m1871(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    /* renamed from: ֏ */
    public static boolean m1884(Callback r4, SQLiteDatabase sQLiteDatabase, Collection<UMCCAggregatedObject> collection) {
        try {
            sQLiteDatabase.beginTransaction();
            for (UMCCAggregatedObject r1 : collection) {
                sQLiteDatabase.insert("aggregated", (String) null, m1860(r1));
            }
            sQLiteDatabase.setTransactionSuccessful();
            m1881(sQLiteDatabase, "aggregated_cache");
            r4.mo7310a("success", false);
            sQLiteDatabase.endTransaction();
            return true;
        } catch (SQLException unused) {
            MLog.m1776("insert to Aggregated cache table faild!");
            sQLiteDatabase.endTransaction();
            return false;
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    /* renamed from: ֏ */
    public static String m1870(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        return new String(m1887(bArr, str.getBytes("UTF-8")), "UTF-8");
    }

    /* renamed from: ֏ */
    public static boolean m1880(SQLiteDatabase sQLiteDatabase, Callback r4) {
        try {
            sQLiteDatabase.beginTransaction();
            if (m1889(sQLiteDatabase, "aggregated_cache") <= 0) {
                r4.mo7310a("faild", false);
                return false;
            }
            sQLiteDatabase.execSQL("insert into aggregated(key, count, value, totalTimestamp, timeWindowNum, label) select key, count, value, totalTimestamp, timeWindowNum, label from aggregated_cache");
            sQLiteDatabase.setTransactionSuccessful();
            m1881(sQLiteDatabase, "aggregated_cache");
            r4.mo7310a("success", false);
            sQLiteDatabase.endTransaction();
            return true;
        } catch (SQLException e) {
            r4.mo7310a(false, false);
            MLog.m1776("cacheToAggregatedTable happen " + e.toString());
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* renamed from: ֏ */
    public static ContentValues m1860(UMCCAggregatedObject r3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", m1869(r3.f3178));
        contentValues.put(NotificationCompatJellybean.KEY_LABEL, m1869(r3.f3179));
        contentValues.put("count", Long.valueOf(r3.f3182));
        contentValues.put("value", Long.valueOf(r3.f3181));
        contentValues.put("totalTimestamp", Long.valueOf(r3.f3180));
        contentValues.put("timeWindowNum", r3.f3183);
        return contentValues;
    }

    /* renamed from: ֏ */
    public static byte[] m1887(byte[] bArr, byte[] bArr2) {
        SecureRandom secureRandom = new SecureRandom();
        SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("DES/ECB/PKCS5Padding");
        instance.init(2, generateSecret, secureRandom);
        return instance.doFinal(bArr);
    }

    /* renamed from: ֏ */
    public static byte[] m1886(byte[] bArr) {
        ZipInputStream zipInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ZipInputStream zipInputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                zipInputStream = new ZipInputStream(byteArrayInputStream);
            } catch (Exception e) {
                e = e;
                zipInputStream = null;
                byteArrayOutputStream2 = null;
                try {
                    e.getMessage();
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    FileUtils.close((Closeable) byteArrayInputStream);
                    FileUtils.close((Closeable) zipInputStream);
                    FileUtils.close((Closeable) byteArrayOutputStream3);
                    return bArr2;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                }
            } catch (Throwable th2) {
                th = th2;
                zipInputStream2 = null;
                th = th;
                zipInputStream = zipInputStream2;
                byteArrayOutputStream = zipInputStream2;
                FileUtils.close((Closeable) byteArrayInputStream);
                FileUtils.close((Closeable) zipInputStream);
                FileUtils.close((Closeable) byteArrayOutputStream);
                throw th;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                try {
                    zipInputStream.getNextEntry();
                    byte[] bArr3 = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr3);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream4.write(bArr3, 0, read);
                    }
                    bArr2 = byteArrayOutputStream4.toByteArray();
                    byteArrayOutputStream3 = byteArrayOutputStream4;
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream2 = byteArrayOutputStream4;
                    e.getMessage();
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    FileUtils.close((Closeable) byteArrayInputStream);
                    FileUtils.close((Closeable) zipInputStream);
                    FileUtils.close((Closeable) byteArrayOutputStream3);
                    return bArr2;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream2 = null;
                e.getMessage();
                byteArrayOutputStream3 = byteArrayOutputStream2;
                FileUtils.close((Closeable) byteArrayInputStream);
                FileUtils.close((Closeable) zipInputStream);
                FileUtils.close((Closeable) byteArrayOutputStream3);
                return bArr2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                byteArrayOutputStream = null;
                th = th4;
                FileUtils.close((Closeable) byteArrayInputStream);
                FileUtils.close((Closeable) zipInputStream);
                FileUtils.close((Closeable) byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            zipInputStream = null;
            byteArrayInputStream = null;
            byteArrayOutputStream2 = null;
            e.getMessage();
            byteArrayOutputStream3 = byteArrayOutputStream2;
            FileUtils.close((Closeable) byteArrayInputStream);
            FileUtils.close((Closeable) zipInputStream);
            FileUtils.close((Closeable) byteArrayOutputStream3);
            return bArr2;
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            zipInputStream2 = null;
            th = th;
            zipInputStream = zipInputStream2;
            byteArrayOutputStream = zipInputStream2;
            FileUtils.close((Closeable) byteArrayInputStream);
            FileUtils.close((Closeable) zipInputStream);
            FileUtils.close((Closeable) byteArrayOutputStream);
            throw th;
        }
        FileUtils.close((Closeable) byteArrayInputStream);
        FileUtils.close((Closeable) zipInputStream);
        FileUtils.close((Closeable) byteArrayOutputStream3);
        return bArr2;
    }

    /* renamed from: ֏ */
    public static void m1876(SQLiteDatabase sQLiteDatabase, boolean z, Callback r3) {
        m1881(sQLiteDatabase, "system");
        m1881(sQLiteDatabase, "aggregated");
        if (!z) {
            m1881(sQLiteDatabase, "limitedck");
            r3.mo7310a("success", false);
        }
    }

    /* renamed from: ֏ */
    public static void m1874(SQLiteDatabase sQLiteDatabase, String str, long j, long j2) {
        try {
            int r1 = m1889(sQLiteDatabase, "system");
            C1086.C1087.f3084.mo9264();
            if (r1 < 128) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", str);
                contentValues.put("timeStamp", Long.valueOf(j2));
                contentValues.put("count", Long.valueOf(j));
                sQLiteDatabase.insert("system", (String) null, contentValues);
            } else if (r1 == 128) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("key", AnalyticsConstants.f118u);
                contentValues2.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
                contentValues2.put("count", 1);
                sQLiteDatabase.insert("system", (String) null, contentValues2);
            } else {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("update system set count=count+1 where key like '" + AnalyticsConstants.f118u + "'");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            }
        } catch (SQLException unused) {
            if (sQLiteDatabase == null) {
            }
        } catch (SQLException unused2) {
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
    }

    /* renamed from: ֏ */
    public static void m1873() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            SystemUtils.m3510((Context) null, intent);
        } catch (Exception e) {
            e.getMessage();
            try {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
                SystemUtils.m3510((Context) null, intent2);
            } catch (Exception e2) {
                e2.getMessage();
                m1910();
            }
        }
    }

    /* renamed from: ֏ */
    public static void m1877(Callback r4, SQLiteDatabase sQLiteDatabase, List<String> list) {
        try {
            sQLiteDatabase.beginTransaction();
            if (m1889(sQLiteDatabase, "limitedck") > 0) {
                m1881(sQLiteDatabase, "limitedck");
            }
            for (String put : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ck", put);
                sQLiteDatabase.insert("limitedck", (String) null, contentValues);
            }
            sQLiteDatabase.setTransactionSuccessful();
            r4.mo7310a("success", false);
        } catch (SQLException e) {
            MLog.m1776("insertToLimitCKTable error " + e.toString());
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1875(SQLiteDatabase r16, java.util.Map<String, com.wpengapp.support.UMCCSystemBuffer> r17, com.wpengapp.support.Callback r18) {
        /*
            r0 = r16
            r1 = 0
            java.lang.String r2 = "__ag_of"
            r3 = r17
            java.lang.Object r2 = r3.get(r2)     // Catch:{ SQLException -> 0x00a8 }
            com.wpengapp.support.ಓ r2 = (com.wpengapp.support.UMCCSystemBuffer) r2     // Catch:{ SQLException -> 0x00a8 }
            if (r2 != 0) goto L_0x0010
            return
        L_0x0010:
            java.lang.String r3 = "system where key=\"__ag_of\""
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x00a8 }
            r4.<init>()     // Catch:{ SQLException -> 0x00a8 }
            java.lang.String r5 = "select * from "
            r4.append(r5)     // Catch:{ SQLException -> 0x00a8 }
            r4.append(r3)     // Catch:{ SQLException -> 0x00a8 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLException -> 0x00a8 }
            android.database.Cursor r4 = r0.rawQuery(r4, r1)     // Catch:{ SQLException -> 0x00a8 }
            r4.moveToFirst()     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            r5 = 0
            r9 = r5
            r8 = 0
        L_0x002e:
            boolean r11 = r4.isAfterLast()     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            java.lang.String r12 = "timeStamp"
            java.lang.String r13 = "count"
            if (r11 != 0) goto L_0x0066
            int r11 = r4.getCount()     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            if (r11 <= 0) goto L_0x0062
            int r8 = r4.getColumnIndex(r13)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            int r8 = r4.getInt(r8)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            int r9 = r4.getColumnIndex(r12)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            long r9 = r4.getLong(r9)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            r11.<init>()     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            java.lang.String r12 = "delete from "
            r11.append(r12)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            r11.append(r3)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            java.lang.String r11 = r11.toString()     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            r0.execSQL(r11)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
        L_0x0062:
            r4.moveToNext()     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            goto L_0x002e
        L_0x0066:
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            r3.<init>()     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            java.lang.String r11 = "key"
            java.lang.String r14 = r2.f3302     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            r3.put(r11, r14)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            if (r8 != 0) goto L_0x0079
            long r14 = r2.f3304     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            goto L_0x007d
        L_0x0077:
            r0 = move-exception
            goto L_0x00c7
        L_0x0079:
            long r14 = (long) r8     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            long r7 = r2.f3304     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            long r14 = r14 + r7
        L_0x007d:
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            r3.put(r13, r7)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x008a
            long r9 = r2.f3303     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
        L_0x008a:
            java.lang.Long r2 = java.lang.Long.valueOf(r9)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            r3.put(r12, r2)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            java.lang.String r2 = "system"
            r0.insert(r2, r1, r3)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            java.lang.String r0 = "success"
            r1 = r18
            r2 = 0
            r1.mo7310a(r0, r2)     // Catch:{ SQLException -> 0x00a2, all -> 0x0077 }
            r4.close()
            goto L_0x00c6
        L_0x00a2:
            r0 = move-exception
            r1 = r4
            goto L_0x00a9
        L_0x00a5:
            r0 = move-exception
            r4 = r1
            goto L_0x00c7
        L_0x00a8:
            r0 = move-exception
        L_0x00a9:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r2.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "save to system table error "
            r2.append(r3)     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a5 }
            r2.append(r0)     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00a5 }
            com.wpengapp.support.MLog.m1776(r0)     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x00c6
            r1.close()
        L_0x00c6:
            return
        L_0x00c7:
            if (r4 == 0) goto L_0x00cc
            r4.close()
        L_0x00cc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Utils.m1875(android.database.sqlite.SQLiteDatabase, java.util.Map, com.wpengapp.support.ಏ):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0067  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m1866(SQLiteDatabase r6) {
        /*
            r0 = 0
            r6.beginTransaction()     // Catch:{ SQLException -> 0x0041, all -> 0x003e }
            java.lang.String r1 = "aggregated_cache"
            int r1 = m1889((android.database.sqlite.SQLiteDatabase) r6, (java.lang.String) r1)     // Catch:{ SQLException -> 0x0041, all -> 0x003e }
            if (r1 > 0) goto L_0x0015
            r1 = 0
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ SQLException -> 0x0041, all -> 0x003e }
            r6.endTransaction()
            return r0
        L_0x0015:
            java.lang.String r1 = "select * from aggregated_cache"
            android.database.Cursor r1 = r6.rawQuery(r1, r0)     // Catch:{ SQLException -> 0x0041, all -> 0x003e }
            boolean r2 = r1.moveToLast()     // Catch:{ SQLException -> 0x0039, all -> 0x0035 }
            if (r2 == 0) goto L_0x002b
            java.lang.String r2 = "timeWindowNum"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ SQLException -> 0x0039, all -> 0x0035 }
            java.lang.String r0 = r1.getString(r2)     // Catch:{ SQLException -> 0x0039, all -> 0x0035 }
        L_0x002b:
            r6.setTransactionSuccessful()     // Catch:{ SQLException -> 0x0039, all -> 0x0035 }
            r1.close()
            r6.endTransaction()
            return r0
        L_0x0035:
            r0 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x0065
        L_0x0039:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x0043
        L_0x003e:
            r1 = move-exception
            r2 = r0
            goto L_0x0065
        L_0x0041:
            r1 = move-exception
            r2 = r0
        L_0x0043:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r3.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = "queryLastTimeWindowNumFromCache error "
            r3.append(r4)     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0064 }
            r3.append(r1)     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0064 }
            com.wpengapp.support.MLog.m1776(r1)     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x0060
            r2.close()
        L_0x0060:
            r6.endTransaction()
            return r0
        L_0x0064:
            r1 = move-exception
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            r2.close()
        L_0x006a:
            r6.endTransaction()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Utils.m1866(android.database.sqlite.SQLiteDatabase):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<String, List<com.wpengapp.support.UMEntry.C0552>> m1872(com.wpengapp.support.Callback r7, SQLiteDatabase r8) {
        /*
            r0 = 0
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ SQLException -> 0x006a, all -> 0x0067 }
            r1.<init>()     // Catch:{ SQLException -> 0x006a, all -> 0x0067 }
            java.lang.String r2 = "system"
            int r2 = m1889((android.database.sqlite.SQLiteDatabase) r8, (java.lang.String) r2)     // Catch:{ SQLException -> 0x006a, all -> 0x0067 }
            if (r2 <= 0) goto L_0x0060
            java.lang.String r2 = "select * from system"
            android.database.Cursor r8 = r8.rawQuery(r2, r0)     // Catch:{ SQLException -> 0x006a, all -> 0x0067 }
        L_0x0014:
            boolean r2 = r8.moveToNext()     // Catch:{ SQLException -> 0x005e }
            if (r2 == 0) goto L_0x0061
            java.lang.String r2 = "key"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ SQLException -> 0x005e }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ SQLException -> 0x005e }
            boolean r3 = r1.containsKey(r2)     // Catch:{ SQLException -> 0x005e }
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r1.get(r2)     // Catch:{ SQLException -> 0x005e }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLException -> 0x005e }
            r1.remove(r2)     // Catch:{ SQLException -> 0x005e }
            goto L_0x0039
        L_0x0034:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLException -> 0x005e }
            r3.<init>()     // Catch:{ SQLException -> 0x005e }
        L_0x0039:
            com.wpengapp.support.ȴ$ނ r4 = new com.wpengapp.support.ȴ$ނ     // Catch:{ SQLException -> 0x005e }
            r4.<init>()     // Catch:{ SQLException -> 0x005e }
            java.lang.String r5 = "timeStamp"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ SQLException -> 0x005e }
            long r5 = r8.getLong(r5)     // Catch:{ SQLException -> 0x005e }
            r4.f1115 = r5     // Catch:{ SQLException -> 0x005e }
            java.lang.String r5 = "count"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ SQLException -> 0x005e }
            long r5 = r8.getLong(r5)     // Catch:{ SQLException -> 0x005e }
            int r6 = (int) r5     // Catch:{ SQLException -> 0x005e }
            r4.f1114 = r6     // Catch:{ SQLException -> 0x005e }
            r3.add(r4)     // Catch:{ SQLException -> 0x005e }
            r1.put(r2, r3)     // Catch:{ SQLException -> 0x005e }
            goto L_0x0014
        L_0x005e:
            r1 = move-exception
            goto L_0x006c
        L_0x0060:
            r8 = r0
        L_0x0061:
            if (r8 == 0) goto L_0x0066
            r8.close()
        L_0x0066:
            return r1
        L_0x0067:
            r7 = move-exception
            r8 = r0
            goto L_0x0091
        L_0x006a:
            r1 = move-exception
            r8 = r0
        L_0x006c:
            java.lang.String r2 = "faild"
            r3 = 0
            r7.mo7310a(r2, r3)     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r7.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "readAllSystemDataForUpload error "
            r7.append(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0090 }
            r7.append(r1)     // Catch:{ all -> 0x0090 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0090 }
            com.wpengapp.support.MLog.m1776(r7)     // Catch:{ all -> 0x0090 }
            if (r8 == 0) goto L_0x008f
            r8.close()
        L_0x008f:
            return r0
        L_0x0090:
            r7 = move-exception
        L_0x0091:
            if (r8 == 0) goto L_0x0096
            r8.close()
        L_0x0096:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Utils.m1872(com.wpengapp.support.ಏ, android.database.sqlite.SQLiteDatabase):java.util.Map");
    }
}
