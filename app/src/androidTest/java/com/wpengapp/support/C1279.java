package com.wpengapp.support;

import android.accessibilityservice.AccessibilityService;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.ActivityChooserView;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.wpengapp.baseui.widget.HtmlTextHelper$ClickURLSpan;
import com.wpengapp.http.RequestHelper;
import com.wpengapp.support.accservice.AccNodeSelector;
import com.wpengapp.support.licensing.activity.VerifyContactActivity;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import org.json.JSONObject;

/* renamed from: com.wpengapp.support.ྌ */
/* compiled from: HighLevelEncoder */
public final class C1279 {

    /* renamed from: ֏ */
    public static boolean f3601;

    /* renamed from: ؠ */
    public static C0844 f3602;

    /* renamed from: ހ */
    public static C0844 f3603;

    /* renamed from: ށ */
    public static HostnameVerifier f3604;

    /* renamed from: ނ */
    public static String f3605;

    /* renamed from: ރ */
    public static TheBackupHandler f3606;

    /* renamed from: ֏ */
    public static boolean m3419(String str) {
        return "POST".equals(str) || "PUT".equals(str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m3425() {
        /*
            java.lang.String r0 = com.wpengapp.support.AppUtils.m1163()
            int r1 = r0.hashCode()
            switch(r1) {
                case -2076751439: goto L_0x0068;
                case -983647613: goto L_0x005e;
                case -860944164: goto L_0x0054;
                case -781655868: goto L_0x004a;
                case -248618682: goto L_0x0040;
                case -193202128: goto L_0x0036;
                case -134616940: goto L_0x002c;
                case 506389359: goto L_0x0022;
                case 1142145625: goto L_0x0018;
                case 1611952165: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0073
        L_0x000d:
            java.lang.String r1 = "com.wpengapp.screenlight"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 9
            goto L_0x0074
        L_0x0018:
            java.lang.String r1 = "com.pw.dsb"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 1
            goto L_0x0074
        L_0x0022:
            java.lang.String r1 = "com.pw.screenclicker"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 6
            goto L_0x0074
        L_0x002c:
            java.lang.String r1 = "com.pw.homemanager"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 2
            goto L_0x0074
        L_0x0036:
            java.lang.String r1 = "com.pw.pccontrol"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 4
            goto L_0x0074
        L_0x0040:
            java.lang.String r1 = "com.pw.accservice.quickbar"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 0
            goto L_0x0074
        L_0x004a:
            java.lang.String r1 = "com.pw.smartbar"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 7
            goto L_0x0074
        L_0x0054:
            java.lang.String r1 = "com.pw.keymodifier"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 3
            goto L_0x0074
        L_0x005e:
            java.lang.String r1 = "com.pw.pccontrolsf"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 5
            goto L_0x0074
        L_0x0068:
            java.lang.String r1 = "com.wpengapp.lightstart"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 8
            goto L_0x0074
        L_0x0073:
            r0 = -1
        L_0x0074:
            switch(r0) {
                case 0: goto L_0x0095;
                case 1: goto L_0x0092;
                case 2: goto L_0x008f;
                case 3: goto L_0x008c;
                case 4: goto L_0x0089;
                case 5: goto L_0x0086;
                case 6: goto L_0x0083;
                case 7: goto L_0x0080;
                case 8: goto L_0x007d;
                case 9: goto L_0x007a;
                default: goto L_0x0077;
            }
        L_0x0077:
            java.lang.String r0 = "defapp"
            return r0
        L_0x007a:
            java.lang.String r0 = "ScreenLight"
            return r0
        L_0x007d:
            java.lang.String r0 = "LightStart"
            return r0
        L_0x0080:
            java.lang.String r0 = "SBAR"
            return r0
        L_0x0083:
            java.lang.String r0 = "LOCK"
            return r0
        L_0x0086:
            java.lang.String r0 = "PCC2"
            return r0
        L_0x0089:
            java.lang.String r0 = "PCC"
            return r0
        L_0x008c:
            java.lang.String r0 = "KEY"
            return r0
        L_0x008f:
            java.lang.String r0 = "HOME"
            return r0
        L_0x0092:
            java.lang.String r0 = "DBAR"
            return r0
        L_0x0095:
            java.lang.String r0 = "QBAR"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1279.m3425():java.lang.String");
    }

    /* renamed from: ؠ */
    public static boolean m3428(char c) {
        return c >= '0' && c <= '9';
    }

    /* renamed from: ހ */
    public static String m3431() {
        return "CREATE INDEX IF NOT EXISTS " + "nat" + " ON " + "t_nr" + "(" + "a" + "," + "t" + ")";
    }

    /* renamed from: ހ */
    public static boolean m3432(char c) {
        return c >= 128 && c <= 255;
    }

    /* renamed from: ށ */
    public static String m3434() {
        return outline.m2545("CREATE TABLE IF NOT EXISTS t_nr (", "_id integer primary key autoincrement, a varchar, ti varchar, c varchar, ch varchar, t integer ", ")");
    }

    /* renamed from: ނ */
    public static AccessibilityNodeInfo m3436() {
        return AccServiceHelper.m2018((AccessibilityService) AccServiceHelper.m2019());
    }

    /* renamed from: ނ */
    public static boolean m3438(char c) {
        return c == 13 || c == '*' || c == '>';
    }

    /* renamed from: ރ */
    public static String m3439() {
        try {
            return ApiConstant.m2593() + "/" + m3425().toLowerCase() + "/" + Utils.m1868("cqN+zN024JbUa4qtah8swA==", "llal1la1231");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* renamed from: ބ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m3442() {
        /*
            java.lang.String r0 = com.wpengapp.support.AppUtils.m1163()
            int r1 = r0.hashCode()
            r2 = -2076751439(0xffffffff843749b1, float:-2.1545384E-36)
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L_0x001f
            r2 = 506389359(0x1e2ee36f, float:9.2585155E-21)
            if (r1 == r2) goto L_0x0015
            goto L_0x0029
        L_0x0015:
            java.lang.String r1 = "com.pw.screenclicker"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 0
            goto L_0x002a
        L_0x001f:
            java.lang.String r1 = "com.wpengapp.lightstart"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = -1
        L_0x002a:
            if (r0 == 0) goto L_0x003a
            if (r0 == r3) goto L_0x0031
            java.lang.String r0 = ""
            return r0
        L_0x0031:
            int r0 = com.wpengapp.support.R$string.pw_share_intro_skad
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r0 = com.wpengapp.support.Utils.m1864((int) r0, (java.lang.Object[]) r1)
            return r0
        L_0x003a:
            int r0 = com.wpengapp.support.R$string.pw_share_intro_lock
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r0 = com.wpengapp.support.Utils.m1864((int) r0, (java.lang.Object[]) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1279.m3442():java.lang.String");
    }

    /* renamed from: ޅ */
    public static AccessibilityNodeInfo m3443(AccessibilityNodeInfo accessibilityNodeInfo) {
        return AccServiceHelper.m2008(accessibilityNodeInfo);
    }

    /* renamed from: ֏ */
    public static boolean m3421(String... strArr) {
        if (strArr.length == 0) {
            return false;
        }
        Set<String> stringSet = CommonSP.f935.getStringSet("readmark", (Set) null);
        if (CollectionUtils.m1657((Collection) stringSet)) {
            return true;
        }
        for (String contains : strArr) {
            if (!stringSet.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ހ */
    public static Float m3430(AccessibilityNodeInfo accessibilityNodeInfo) {
        return m3398(m3433(accessibilityNodeInfo));
    }

    /* renamed from: ށ */
    public static Rect m3433(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        try {
            Rect rect = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect);
            return rect;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ނ */
    public static AccessibilityNodeInfo m3437(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i = 0;
        while (accessibilityNodeInfo != null) {
            try {
                if (accessibilityNodeInfo.isClickable()) {
                    return accessibilityNodeInfo;
                }
                AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
                AccessibilityNodeInfo r2 = AccServiceHelper.m2007(i, accessibilityNodeInfo, parent);
                if (r2 != null) {
                    return r2;
                }
                i++;
                accessibilityNodeInfo = parent;
            } catch (Exception e) {
                e.getMessage();
                return null;
            }
        }
        return accessibilityNodeInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0017 A[Catch:{ Exception -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0018 A[Catch:{ Exception -> 0x002b }] */
    /* renamed from: ރ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m3440(AccessibilityNodeInfo r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x000e
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = r3.getViewIdResourceName()     // Catch:{ Exception -> 0x000a }
            goto L_0x000f
        L_0x000a:
            r3 = move-exception
            r3.getMessage()
        L_0x000e:
            r3 = r0
        L_0x000f:
            java.lang.String r1 = "/"
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x002b }
            if (r2 == 0) goto L_0x0018
            goto L_0x002f
        L_0x0018:
            int r2 = r3.indexOf(r1)     // Catch:{ Exception -> 0x002b }
            if (r2 >= 0) goto L_0x0020
            r0 = r3
            goto L_0x002f
        L_0x0020:
            int r1 = r3.indexOf(r1)     // Catch:{ Exception -> 0x002b }
            int r1 = r1 + 1
            java.lang.String r0 = r3.substring(r1)     // Catch:{ Exception -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r3 = move-exception
            r3.getMessage()
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1279.m3440(android.view.accessibility.AccessibilityNodeInfo):java.lang.String");
    }

    /* renamed from: ؠ */
    public static AppToastRecord m3423(Cursor cursor) {
        AppToastRecord r0 = new AppToastRecord();
        r0.f1636 = Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id")));
        r0.f1637 = cursor.getString(cursor.getColumnIndex("a"));
        r0.f1638 = cursor.getString(cursor.getColumnIndex("c"));
        r0.f1639 = Long.valueOf(cursor.getLong(cursor.getColumnIndex("t")));
        return r0;
    }

    /* renamed from: ށ */
    public static boolean m3435(char c) {
        if (m3438(c) || c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    /* renamed from: ބ */
    public static CharSequence m3441(AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            return accessibilityNodeInfo.getText();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static Process m3399(boolean z, String str, String str2, String... strArr) {
        Process process;
        if (z) {
            try {
                process = Runtime.getRuntime().exec("su");
            } catch (IOException unused) {
                process = null;
            }
        } else {
            process = Runtime.getRuntime().exec("sh");
        }
        if (process == null) {
            return null;
        }
        OutputStream outputStream = process.getOutputStream();
        String parent = new File(str).getParent();
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (String append : strArr) {
                sb.append(" \"");
                sb.append(append);
                sb.append("\"");
            }
        }
        try {
            for (String str3 : new String[]{outline.m2556("export CLASSPATH=", str), "exec app_process " + parent + " " + str2 + sb.toString()}) {
                outputStream.write((str3 + "\n").getBytes());
                outputStream.flush();
            }
            return process;
        } catch (Exception e) {
            e.getMessage();
            return process;
        }
    }

    /* renamed from: ؠ */
    public static File m3424(Context context) {
        File r2 = m3395(context);
        File file = new File(r2, "uil-images");
        return (file.exists() || file.mkdir()) ? file : r2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ec  */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static List<com.wpengapp.support.AppToastRecord> m3426(int r18, String r19) {
        /*
            r1 = r18
            long r2 = java.lang.System.currentTimeMillis()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.String r5 = "tl"
            java.lang.String r6 = "t"
            if (r1 <= 0) goto L_0x0013
            r0 = r5
            goto L_0x0014
        L_0x0013:
            r0 = r6
        L_0x0014:
            r7 = 0
            boolean r8 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            if (r8 != 0) goto L_0x0035
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r8.<init>()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r9 = "a=\""
            r8.append(r9)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r9 = r19
            r8.append(r9)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r9 = "\""
            r8.append(r9)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r12 = r8
            goto L_0x0036
        L_0x0035:
            r12 = r7
        L_0x0036:
            android.database.sqlite.SQLiteDatabase r9 = com.wpengapp.support.DBHelper.m1180()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r10 = "t_atr"
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r8.<init>()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r8.append(r0)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r0 = " desc"
            r8.append(r0)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r16 = r8.toString()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r17 = 0
            android.database.Cursor r8 = r9.query(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            if (r8 == 0) goto L_0x00c3
            boolean r0 = r8.moveToFirst()     // Catch:{ Exception -> 0x00b6 }
            if (r0 == 0) goto L_0x00c3
        L_0x005f:
            com.wpengapp.support.ڙ r0 = new com.wpengapp.support.ڙ     // Catch:{ Exception -> 0x00b6 }
            r0.<init>()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r9 = "a"
            int r9 = r8.getColumnIndex(r9)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ Exception -> 0x00b6 }
            r0.f1637 = r9     // Catch:{ Exception -> 0x00b6 }
            if (r1 <= 0) goto L_0x008d
            java.lang.String r9 = "cl"
            int r9 = r8.getColumnIndex(r9)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ Exception -> 0x00ab }
            r0.f1638 = r9     // Catch:{ Exception -> 0x00ab }
            int r9 = r8.getColumnIndex(r5)     // Catch:{ Exception -> 0x00ab }
            long r9 = r8.getLong(r9)     // Catch:{ Exception -> 0x00ab }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x00ab }
            r0.f1639 = r9     // Catch:{ Exception -> 0x00ab }
            goto L_0x00a7
        L_0x008d:
            java.lang.String r9 = "c"
            int r9 = r8.getColumnIndex(r9)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ Exception -> 0x00ab }
            r0.f1638 = r9     // Catch:{ Exception -> 0x00ab }
            int r9 = r8.getColumnIndex(r6)     // Catch:{ Exception -> 0x00ab }
            long r9 = r8.getLong(r9)     // Catch:{ Exception -> 0x00ab }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x00ab }
            r0.f1639 = r9     // Catch:{ Exception -> 0x00ab }
        L_0x00a7:
            r4.add(r0)     // Catch:{ Exception -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r0 = move-exception
            com.wpengapp.support.C0975.m2602(r0)     // Catch:{ Exception -> 0x00b6 }
        L_0x00af:
            boolean r0 = r8.moveToNext()     // Catch:{ Exception -> 0x00b6 }
            if (r0 != 0) goto L_0x005f
            goto L_0x00c3
        L_0x00b6:
            r0 = move-exception
            goto L_0x00bd
        L_0x00b8:
            r0 = move-exception
            goto L_0x0188
        L_0x00bb:
            r0 = move-exception
            r8 = r7
        L_0x00bd:
            r0.getMessage()     // Catch:{ all -> 0x0186 }
            com.wpengapp.support.C0975.m2602(r0)     // Catch:{ all -> 0x0186 }
        L_0x00c3:
            com.wpengapp.support.DBHelper.m1179((android.database.Cursor) r8)
            long r5 = java.lang.System.currentTimeMillis()
            r0 = -7
            java.util.Date r8 = com.wpengapp.support.DateUtils.m2700()
            java.util.Calendar r9 = java.util.Calendar.getInstance()
            r9.setTime(r8)
            r8 = 5
            r9.add(r8, r0)
            java.util.Date r0 = r9.getTime()
            long r8 = r0.getTime()
            java.util.Iterator r10 = r4.iterator()
        L_0x00e6:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0161
            java.lang.Object r0 = r10.next()
            r11 = r0
            com.wpengapp.support.ڙ r11 = (com.wpengapp.support.AppToastRecord) r11
            java.lang.String r0 = r11.f1637
            r12 = 0
            java.lang.String r13 = ""
            if (r1 <= 0) goto L_0x010b
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            r13.<init>()     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            java.lang.String r14 = " AND LENGTH(c)>"
            r13.append(r14)     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            r13.append(r1)     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x014d, all -> 0x014b }
        L_0x010b:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            r14.<init>()     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            java.lang.String r15 = "SELECT COUNT(*) AS count FROM t_tr WHERE a=? AND t>?"
            r14.append(r15)     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            r14.append(r13)     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            java.lang.String r13 = r14.toString()     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            android.database.sqlite.SQLiteDatabase r14 = com.wpengapp.support.DBHelper.m1180()     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            r15 = 2
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            r15[r12] = r0     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            r0 = 1
            java.lang.String r16 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            r15[r0] = r16     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            android.database.Cursor r13 = r14.rawQuery(r13, r15)     // Catch:{ Exception -> 0x014d, all -> 0x014b }
            if (r13 == 0) goto L_0x0155
            boolean r0 = r13.moveToFirst()     // Catch:{ Exception -> 0x0149 }
            if (r0 == 0) goto L_0x0155
        L_0x0138:
            java.lang.String r0 = "count"
            int r0 = r13.getColumnIndex(r0)     // Catch:{ Exception -> 0x0149 }
            int r12 = r13.getInt(r0)     // Catch:{ Exception -> 0x0149 }
            boolean r0 = r13.moveToNext()     // Catch:{ Exception -> 0x0149 }
            if (r0 != 0) goto L_0x0138
            goto L_0x0155
        L_0x0149:
            r0 = move-exception
            goto L_0x014f
        L_0x014b:
            r0 = move-exception
            goto L_0x015d
        L_0x014d:
            r0 = move-exception
            r13 = r7
        L_0x014f:
            r0.getMessage()     // Catch:{ all -> 0x015b }
            com.wpengapp.support.C0975.m2602(r0)     // Catch:{ all -> 0x015b }
        L_0x0155:
            com.wpengapp.support.DBHelper.m1179((android.database.Cursor) r13)
            r11.f2413 = r12
            goto L_0x00e6
        L_0x015b:
            r0 = move-exception
            r7 = r13
        L_0x015d:
            com.wpengapp.support.DBHelper.m1179((android.database.Cursor) r7)
            throw r0
        L_0x0161:
            long r0 = java.lang.System.currentTimeMillis()
            com.wpengapp.support.ࢫ r7 = com.wpengapp.support.C1001.f2882
            java.util.Collections.sort(r4, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "getAppToastRecords "
            r7.append(r8)
            long r2 = r5 - r2
            r7.append(r2)
            java.lang.String r2 = ", "
            r7.append(r2)
            long r0 = r0 - r5
            r7.append(r0)
            r7.toString()
            return r4
        L_0x0186:
            r0 = move-exception
            r7 = r8
        L_0x0188:
            com.wpengapp.support.DBHelper.m1179((android.database.Cursor) r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1279.m3426(int, java.lang.String):java.util.List");
    }

    /* renamed from: ֏ */
    public static List<NodeInfo> m3403(AccessibilityNodeInfo accessibilityNodeInfo, float f, boolean z) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        "Root node is " + accessibilityNodeInfo;
        ArrayList arrayList = new ArrayList();
        try {
            m3411(accessibilityNodeInfo, (List<NodeInfo>) arrayList, f, z);
        } catch (Throwable th) {
            th.getMessage();
        }
        StringBuilder r2 = outline.m2549("loadNodes ");
        r2.append(arrayList.size());
        r2.toString();
        return arrayList;
    }

    /* renamed from: ֏ */
    public static void m3407(int i, String str, String str2, long j) {
        if (Logger.f1344) {
            Logger.m1473("Request", "\nHttp url : " + str + "\nHttp code : " + i + "\nHttp time : " + j + "ms" + "\nHttp content : " + str2, 8);
        }
    }

    /* renamed from: ֏ */
    public static int m3383(ByteMatrix r10, boolean z) {
        int i;
        int i2;
        if (z) {
            i = r10.f1503;
        } else {
            i = r10.f1502;
        }
        if (z) {
            i2 = r10.f1502;
        } else {
            i2 = r10.f1503;
        }
        byte[][] bArr = r10.f1501;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3;
            int i6 = 0;
            byte b = -1;
            for (int i7 = 0; i7 < i2; i7++) {
                byte b2 = z ? bArr[i4][i7] : bArr[i7][i4];
                if (b2 == b) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i5 += (i6 - 5) + 3;
                    }
                    i6 = 1;
                    b = b2;
                }
            }
            i3 = i6 >= 5 ? (i6 - 5) + 3 + i5 : i5;
        }
        return i3;
    }

    /* renamed from: ֏ */
    public static void m3412(TextView textView, CharSequence charSequence, HtmlTextHelper r11) {
        if (charSequence != null) {
            textView.setText(Html.fromHtml(charSequence.toString()));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            if (textView.getText() instanceof Spannable) {
                Spannable spannable = (Spannable) textView.getText();
                URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannable);
                for (URLSpan uRLSpan : uRLSpanArr) {
                    spannableStringBuilder.removeSpan(uRLSpan);
                    int spanStart = spannable.getSpanStart(uRLSpan);
                    int spanEnd = spannable.getSpanEnd(uRLSpan);
                    spannableStringBuilder.setSpan(new HtmlTextHelper$ClickURLSpan(uRLSpan.getURL(), spannable.subSequence(spanStart, spanEnd), r11), spanStart, spanEnd, 33);
                }
                textView.setText(spannableStringBuilder);
            }
        }
    }

    /* renamed from: ؠ */
    public static boolean m3429(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo r0 = m3437(accessibilityNodeInfo);
        if (r0 == null) {
            return accessibilityNodeInfo.performAction(16);
        }
        return r0.performAction(16);
    }

    /* renamed from: ֏ */
    public static void m3411(AccessibilityNodeInfo accessibilityNodeInfo, List<NodeInfo> list, float f, boolean z) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        Rect r6;
        Float r4;
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            NodeInfo r2 = null;
            try {
                accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(i);
            } catch (Exception e) {
                e.getMessage();
                accessibilityNodeInfo2 = null;
            }
            if (accessibilityNodeInfo2 != null) {
                if (accessibilityNodeInfo2.isVisibleToUser() && ((!z || accessibilityNodeInfo2.isClickable() || accessibilityNodeInfo2.isCheckable() || accessibilityNodeInfo2.isEditable()) && (r4 = m3398(r6)) != null && r4.floatValue() > 0.0f && r4.floatValue() <= f)) {
                    AccNodeSelector selector = AccNodeSelector.getSelector(accessibilityNodeInfo2);
                    CharSequence r9 = m3441(accessibilityNodeInfo2);
                    String r10 = m3440(accessibilityNodeInfo2);
                    if (selector != null || !TextUtils.isEmpty(r9) || !TextUtils.isEmpty(r10)) {
                        r2 = new NodeInfo(accessibilityNodeInfo2, (r6 = m3433(accessibilityNodeInfo2)), r4.floatValue(), selector, r9, r10);
                    }
                }
                if (r2 != null) {
                    list.add(r2);
                }
                m3411(accessibilityNodeInfo2, list, f, z);
            }
        }
    }

    /* renamed from: ؠ */
    public static void m3427(long j) {
        "deleteExpire " + j;
        DBHelper.m1180().beginTransaction();
        Cursor cursor = null;
        try {
            DBHelper.m1180().delete("t_tr", "t<?", new String[]{String.valueOf(j)});
            cursor = DBHelper.m1180().query("t_atr", (String[]) null, "t<? or tl<?", new String[]{String.valueOf(j), String.valueOf(j)}, (String) null, (String) null, (String) null, (String) null);
            if (cursor == null || !cursor.moveToFirst()) {
                DBHelper.m1180().setTransactionSuccessful();
                DBHelper.m1179(cursor);
                DBHelper.m1180().endTransaction();
            }
            do {
                m3409(cursor.getLong(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("a")));
            } while (cursor.moveToNext());
            DBHelper.m1180().setTransactionSuccessful();
            DBHelper.m1179(cursor);
            DBHelper.m1180().endTransaction();
        } catch (Exception e) {
            e.getMessage();
            C0975.m2602(e);
        } catch (Throwable th) {
            DBHelper.m1179((Cursor) null);
            DBHelper.m1180().endTransaction();
            throw th;
        }
    }

    /* renamed from: ֏ */
    public static AccessibilityNodeInfo m3388(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull CharSequence charSequence, @NonNull String... strArr) {
        int i = Build.VERSION.SDK_INT;
        if (!(strArr == null || strArr.length == 0)) {
            for (String str : strArr) {
                try {
                    List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(charSequence + ":id/" + str);
                    if (!CollectionUtils.m1657((Collection) findAccessibilityNodeInfosByViewId)) {
                        AccessibilityNodeInfo accessibilityNodeInfo2 = findAccessibilityNodeInfosByViewId.get(0);
                        if (TextUtils.equals(charSequence, accessibilityNodeInfo2.getPackageName())) {
                            return accessibilityNodeInfo2;
                        }
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        return null;
    }

    /* renamed from: ֏ */
    public static File m3395(Context context) {
        return m3396(context, true);
    }

    /* renamed from: ֏ */
    public static String m3400() {
        return ApiConstant.m2593() + "/" + m3425().toLowerCase();
    }

    /* renamed from: ֏ */
    public static Executor m3404(int i, int i2, QueueProcessingType r10) {
        return new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, r10 == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue(), new DefaultConfigurationFactory(i2, "uil-pool-"));
    }

    /* renamed from: ֏ */
    public static boolean m3418(InputStream inputStream, OutputStream outputStream, IoUtils r8, int i) {
        int available = inputStream.available();
        if (available <= 0) {
            available = 512000;
        }
        byte[] bArr = new byte[i];
        if (m3417(r8, 0, available)) {
            return false;
        }
        int i2 = 0;
        do {
            int read = inputStream.read(bArr, 0, i);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i2 += read;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!m3417(r8, i2, available));
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static File m3396(Context r6, boolean r7) {
        /*
            java.lang.String r0 = ""
            java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch:{ IncompatibleClassChangeError | NullPointerException -> 0x0006 }
        L_0x0006:
            r1 = 1
            r2 = 0
            r3 = 0
            if (r7 == 0) goto L_0x006a
            java.lang.String r7 = "mounted"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x006a
            java.lang.String r7 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r7 = r6.checkCallingOrSelfPermission(r7)
            if (r7 != 0) goto L_0x001d
            r7 = 1
            goto L_0x001e
        L_0x001d:
            r7 = 0
        L_0x001e:
            if (r7 == 0) goto L_0x006a
            java.io.File r7 = new java.io.File
            java.io.File r0 = new java.io.File
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r5 = "Android"
            r0.<init>(r4, r5)
            java.lang.String r4 = "data"
            r7.<init>(r0, r4)
            java.io.File r0 = new java.io.File
            java.io.File r4 = new java.io.File
            java.lang.String r5 = r6.getPackageName()
            r4.<init>(r7, r5)
            java.lang.String r7 = "cache"
            r0.<init>(r4, r7)
            boolean r7 = r0.exists()
            if (r7 != 0) goto L_0x006b
            boolean r7 = r0.mkdirs()
            if (r7 != 0) goto L_0x0056
            java.lang.Object[] r7 = new java.lang.Object[r3]
            java.lang.String r0 = "Unable to create external cache directory"
            com.wpengapp.support.L.m2162(r0, r7)
            goto L_0x006a
        L_0x0056:
            java.io.File r7 = new java.io.File     // Catch:{ IOException -> 0x0061 }
            java.lang.String r4 = ".nomedia"
            r7.<init>(r0, r4)     // Catch:{ IOException -> 0x0061 }
            r7.createNewFile()     // Catch:{ IOException -> 0x0061 }
            goto L_0x006b
        L_0x0061:
            java.lang.Object[] r7 = new java.lang.Object[r3]
            r4 = 4
            java.lang.String r5 = "Can't create \".nomedia\" file in application external cache directory"
            com.wpengapp.support.L.m2158(r4, r2, r5, r7)
            goto L_0x006b
        L_0x006a:
            r0 = r2
        L_0x006b:
            if (r0 != 0) goto L_0x0071
            java.io.File r0 = r6.getCacheDir()
        L_0x0071:
            if (r0 != 0) goto L_0x0097
            java.lang.String r7 = "/data/data/"
            java.lang.StringBuilder r7 = com.wpengapp.support.outline.m2549(r7)
            java.lang.String r6 = r6.getPackageName()
            r7.append(r6)
            java.lang.String r6 = "/cache/"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.Object[] r7 = new java.lang.Object[r1]
            r7[r3] = r6
            java.lang.String r0 = "Can't define system cache directory! '%s' will be used."
            com.wpengapp.support.L.m2162(r0, r7)
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
        L_0x0097:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1279.m3396(android.content.Context, boolean):java.io.File");
    }

    /* renamed from: ֏ */
    public static File m3397(String str, List<String> list, String str2) {
        String str3;
        byte[] bArr;
        String str4;
        if (str != null) {
            str = str.trim();
        }
        BackupPackage r0 = new BackupPackage();
        r0.f2318 = str;
        f3606.mo8866();
        r0.f2320 = AppUtils.m1163();
        AppUtils.m1158();
        r0.f2319 = System.currentTimeMillis();
        f3606.mo8864();
        r0.f2321 = new HashMap();
        try {
            Iterator<String> it = list.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                str3 = BidiFormatter.EMPTY_STRING;
                if (!hasNext) {
                    break;
                }
                String next = it.next();
                IBackupItem r4 = f3606.mo8859(next);
                if (r4 == null) {
                    str4 = str3;
                } else {
                    str4 = r4.mo8364();
                }
                if (str4 != null) {
                    str3 = str4;
                }
                r0.f2321.put(next, str3);
            }
            String r8 = GsonUtil.m2742(r0);
            try {
                String r2 = f3606.mo8863();
                if (TextUtils.isEmpty(r2)) {
                    bArr = r8.getBytes("UTF-8");
                } else {
                    try {
                        bArr = Utils.m1897(Utils.m1904(r8, r2 + f3605));
                    } catch (Exception e) {
                        e.getMessage();
                        bArr = r8.getBytes("UTF-8");
                    }
                }
                long j = r0.f2319;
                StringBuilder r02 = outline.m2550(SystemUtils.m3519(AppUtils.m1163()).replace(" ", str3).trim(), "_");
                r02.append(DateUtils.m2699(new Date(j), "yyMMddHHmm"));
                String sb = r02.toString();
                if (!TextUtils.isEmpty(str)) {
                    sb = outline.m2545(sb, "_", str);
                }
                StringBuilder r03 = outline.m2550(sb, ".");
                r03.append(f3606.mo8860());
                File file = new File(str2, r03.toString());
                String name = file.getName();
                int lastIndexOf = name.lastIndexOf(".");
                String substring = name.substring(lastIndexOf + 1);
                String substring2 = name.substring(0, lastIndexOf);
                int i = 1;
                while (file.exists()) {
                    String parent = file.getParent();
                    i++;
                    file = new File(parent, substring2 + "(" + i + ")." + substring);
                }
                if (FileUtils.m1136(file, bArr)) {
                    return file;
                }
                return null;
            } catch (Exception e2) {
                e2.getMessage();
                return null;
            }
        } catch (Exception e3) {
            e3.getMessage();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static NotifyRecord m3394(Cursor cursor) {
        NotifyRecord r0 = new NotifyRecord();
        r0.f3459 = Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id")));
        r0.f3460 = cursor.getString(cursor.getColumnIndex("a"));
        r0.f3461 = cursor.getString(cursor.getColumnIndex("ti"));
        r0.f3462 = cursor.getString(cursor.getColumnIndex("c"));
        r0.f3463 = cursor.getString(cursor.getColumnIndex("ch"));
        r0.f3464 = Long.valueOf(cursor.getLong(cursor.getColumnIndex("t")));
        return r0;
    }

    /* renamed from: ֏ */
    public static AccessibilityNodeInfo m3390(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull String str, C1156 r7) {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        try {
            List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
            if (CollectionUtils.m1657((Collection) findAccessibilityNodeInfosByText)) {
                return null;
            }
            Iterator<AccessibilityNodeInfo> it = findAccessibilityNodeInfosByText.iterator();
            AccessibilityNodeInfo accessibilityNodeInfo3 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AccessibilityNodeInfo next = it.next();
                if (r7 == null || !r7.mo8009(next)) {
                    if (accessibilityNodeInfo3 == null) {
                        accessibilityNodeInfo3 = next;
                    }
                    CharSequence text = next.getText();
                    if (TextUtils.isEmpty(text)) {
                        text = next.getContentDescription();
                    }
                    if (text != null && str.contentEquals(text)) {
                        accessibilityNodeInfo2 = next;
                        break;
                    }
                }
            }
            return accessibilityNodeInfo2 == null ? accessibilityNodeInfo3 : accessibilityNodeInfo2;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a A[RETURN] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m3417(com.wpengapp.support.IoUtils r3, int r4, int r5) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x002a
            com.wpengapp.support.ჼ r3 = (com.wpengapp.support.C1336) r3
            boolean r1 = r3.f3825
            r2 = 1
            if (r1 != 0) goto L_0x001f
            boolean r1 = r3.mo9634()
            if (r1 != 0) goto L_0x0019
            boolean r3 = r3.mo9635()
            if (r3 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r3 = 1
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            goto L_0x0020
        L_0x001f:
            r3 = 1
        L_0x0020:
            if (r3 != 0) goto L_0x002a
            int r4 = r4 * 100
            int r4 = r4 / r5
            r3 = 75
            if (r4 >= r3) goto L_0x002a
            return r2
        L_0x002a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1279.m3417(com.wpengapp.support.ĺ, int, int):boolean");
    }

    /* renamed from: ֏ */
    public static void m3414(ToastRecord r2, ContentValues contentValues) {
        contentValues.put("_id", r2.f1636);
        contentValues.put("a", r2.f1637);
        contentValues.put("c", r2.f1638);
        contentValues.put("t", r2.f1639);
    }

    /* renamed from: ֏ */
    public static ToastRecord m3393(Cursor cursor) {
        ToastRecord r0 = new ToastRecord();
        r0.f1636 = Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id")));
        r0.f1637 = cursor.getString(cursor.getColumnIndex("a"));
        r0.f1638 = cursor.getString(cursor.getColumnIndex("c"));
        r0.f1639 = Long.valueOf(cursor.getLong(cursor.getColumnIndex("t")));
        return r0;
    }

    /* renamed from: ֏ */
    public static boolean m3420(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ֏ */
    public static boolean m3422(byte[][] bArr, int i, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == 1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ֏ */
    public static AccessibilityNodeInfo m3392(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull String... strArr) {
        return m3391(accessibilityNodeInfo, (String) null, (C1156) null, strArr);
    }

    /* renamed from: ֏ */
    public static void m3410(Context context, UserInfo r2) {
        C1307.m3565();
        VerifyContactActivity.m885(context, new C0870(r2));
    }

    /* renamed from: ֏ */
    public static AccessibilityNodeInfo m3391(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, String str, C1156 r6, @NonNull String... strArr) {
        AccessibilityNodeInfo r2;
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2) && !"-1".equals(str2) && (r2 = m3390(accessibilityNodeInfo, str2, r6)) != null && (TextUtils.isEmpty(str) || TextUtils.equals(str, r2.getPackageName()))) {
                return r2;
            }
        }
        return null;
    }

    /* renamed from: ֏ */
    public static AccessibilityNodeInfo m3389(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull String str) {
        try {
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i = 0; i < childCount; i++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
                if (TextUtils.equals(str, child.getClassName())) {
                    return child;
                }
                AccessibilityNodeInfo r2 = m3389(child, str);
                if (r2 != null) {
                    return r2;
                }
            }
            return null;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static ThreadFactory m3405(int i, String str) {
        return new DefaultConfigurationFactory(i, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static List<com.wpengapp.support.ToastRecord> m3402(int r12, int r13, int r14, String r15) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090 }
            r2.<init>()     // Catch:{ Exception -> 0x0090 }
            int r12 = r12 * r13
            r2.append(r12)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r12 = ","
            r2.append(r12)     // Catch:{ Exception -> 0x0090 }
            r2.append(r13)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r11 = r2.toString()     // Catch:{ Exception -> 0x0090 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x0090 }
            r12.<init>()     // Catch:{ Exception -> 0x0090 }
            boolean r13 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x0090 }
            if (r13 != 0) goto L_0x0040
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090 }
            r13.<init>()     // Catch:{ Exception -> 0x0090 }
            java.lang.String r2 = "a=\""
            r13.append(r2)     // Catch:{ Exception -> 0x0090 }
            r13.append(r15)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r15 = "\""
            r13.append(r15)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0090 }
            r12.add(r13)     // Catch:{ Exception -> 0x0090 }
        L_0x0040:
            if (r14 <= 0) goto L_0x0056
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090 }
            r13.<init>()     // Catch:{ Exception -> 0x0090 }
            java.lang.String r15 = "LENGTH(c)>"
            r13.append(r15)     // Catch:{ Exception -> 0x0090 }
            r13.append(r14)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0090 }
            r12.add(r13)     // Catch:{ Exception -> 0x0090 }
        L_0x0056:
            int r13 = r12.size()     // Catch:{ Exception -> 0x0090 }
            if (r13 <= 0) goto L_0x0064
            java.lang.String r13 = " AND "
            java.lang.String r12 = android.text.TextUtils.join(r13, r12)     // Catch:{ Exception -> 0x0090 }
            r6 = r12
            goto L_0x0065
        L_0x0064:
            r6 = r1
        L_0x0065:
            android.database.sqlite.SQLiteDatabase r3 = com.wpengapp.support.DBHelper.m1180()     // Catch:{ Exception -> 0x0090 }
            java.lang.String r4 = "t_tr"
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "_id desc"
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0090 }
            if (r1 == 0) goto L_0x008a
            boolean r12 = r1.moveToFirst()     // Catch:{ Exception -> 0x0090 }
            if (r12 == 0) goto L_0x008a
        L_0x007d:
            com.wpengapp.support.Ρ r12 = m3393((android.database.Cursor) r1)     // Catch:{ Exception -> 0x0090 }
            r0.add(r12)     // Catch:{ Exception -> 0x0090 }
            boolean r12 = r1.moveToNext()     // Catch:{ Exception -> 0x0090 }
            if (r12 != 0) goto L_0x007d
        L_0x008a:
            com.wpengapp.support.DBHelper.m1179((android.database.Cursor) r1)
            return r0
        L_0x008e:
            r12 = move-exception
            goto L_0x009b
        L_0x0090:
            r12 = move-exception
            r12.getMessage()     // Catch:{ all -> 0x008e }
            com.wpengapp.support.C0975.m2602(r12)     // Catch:{ all -> 0x008e }
            com.wpengapp.support.DBHelper.m1179((android.database.Cursor) r1)
            return r0
        L_0x009b:
            com.wpengapp.support.DBHelper.m1179((android.database.Cursor) r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1279.m3402(int, int, int, java.lang.String):java.util.List");
    }

    /* renamed from: ֏ */
    public static long m3387(NotifyRecord r4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", r4.f3459);
        contentValues.put("a", r4.f3460);
        contentValues.put("ti", r4.f3461);
        contentValues.put("c", r4.f3462);
        contentValues.put("ch", r4.f3463);
        contentValues.put("t", r4.f3464);
        return DBHelper.m1180().insertWithOnConflict("t_nr", (String) null, contentValues, 4);
    }

    /* renamed from: ֏ */
    public static String m3401(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return new String(bArr, "UTF-8");
        }
        try {
            byte[] r2 = Utils.m1886(bArr);
            return Utils.m1870(r2, str + f3605);
        } catch (Exception e) {
            e.getMessage();
            return new String(bArr, "UTF-8");
        }
    }

    /* renamed from: ֏ */
    public static void m3408(long j) {
        "deleteExpire " + j;
        DBHelper.m1180().beginTransaction();
        try {
            DBHelper.m1180().delete("t_nr", "t<?", new String[]{String.valueOf(j)});
            DBHelper.m1180().setTransactionSuccessful();
        } catch (Exception e) {
            e.getMessage();
            C0975.m2602(e);
        } catch (Throwable th) {
            DBHelper.m1180().endTransaction();
            throw th;
        }
        DBHelper.m1180().endTransaction();
    }

    /* renamed from: ֏ */
    public static int m3385(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        CharSequence charSequence2 = charSequence;
        int i3 = i;
        if (i3 >= charSequence.length()) {
            return i2;
        }
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int r3 = m3386(fArr, iArr, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bArr);
                int i6 = 0;
                for (int i7 = 0; i7 < 6; i7++) {
                    i6 += bArr[i7];
                }
                if (iArr[0] == r3) {
                    return 0;
                }
                if (i6 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (i6 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (i6 != 1 || bArr[2] <= 0) {
                    return (i6 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence2.charAt(i5);
            i4++;
            if (m3428(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (m3432(charAt)) {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (charAt == ' ' || (charAt >= '0' && charAt <= '9') || (charAt >= 'A' && charAt <= 'Z')) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (m3432(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (charAt == ' ' || (charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'z')) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (m3432(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (m3435(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (m3432(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (charAt >= ' ' && charAt <= '^') {
                fArr[4] = fArr[4] + 0.75f;
            } else if (m3432(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            fArr[5] = fArr[5] + 1.0f;
            if (i4 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                m3386(fArr, iArr2, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bArr2);
                int i8 = 0;
                for (int i9 = 0; i9 < 6; i9++) {
                    i8 += bArr2[i9];
                }
                if (iArr2[0] < iArr2[5] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (i8 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (i8 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (i8 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        int i10 = i3 + i4 + 1;
                        while (i10 < charSequence.length()) {
                            char charAt2 = charSequence2.charAt(i10);
                            if (!m3438(charAt2)) {
                                if (!m3435(charAt2)) {
                                    break;
                                }
                                i10++;
                            } else {
                                return 3;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    /* renamed from: ֏ */
    public static void m3415(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", C0719.m1812());
            jSONObject.put("bc", String.valueOf(C0719.m1814()));
            jSONObject.put("ctf", String.valueOf(C0719.m1819()));
            map.put("da", RequestHelper.m338(jSONObject.toString()));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ int m3384(AppToastRecord r0, AppToastRecord r1) {
        Long l = r0.f1639;
        if (l == null) {
            return 1;
        }
        Long l2 = r1.f1639;
        if (l2 == null) {
            return -1;
        }
        return -l.compareTo(l2);
    }

    /* renamed from: ֏ */
    public static Float m3398(Rect rect) {
        if (rect == null) {
            return null;
        }
        try {
            return Float.valueOf(((((float) rect.width()) * ((float) rect.height())) / ((float) C0826.m2169().f2152)) / ((float) C0826.m2169().f2153));
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static void m3413(ToastRecord r7) {
        ContentValues contentValues = new ContentValues();
        m3414(r7, contentValues);
        DBHelper.m1180().insertWithOnConflict("t_tr", (String) null, contentValues, 4);
        ContentValues contentValues2 = new ContentValues();
        m3414(r7, contentValues2);
        int r1 = Utils.m1857(C1063.m2859("skad_toast_len", (String) null), 10);
        String str = r7.f1638;
        if (str == null || str.length() < r1) {
            List<ToastRecord> r72 = m3402(0, 1, r1, r7.f1637);
            if (CollectionUtils.m1657((Collection) r72)) {
                contentValues2.put("tl", (Long) null);
                contentValues2.put("cl", (String) null);
            } else {
                contentValues2.put("tl", r72.get(0).f1639);
                contentValues2.put("cl", r72.get(0).f1638);
            }
        } else {
            contentValues2.put("cl", r7.f1638);
            contentValues2.put("tl", r7.f1639);
        }
        DBHelper.m1180().insertWithOnConflict("t_atr", (String) null, contentValues2, 5);
    }

    /* renamed from: ֏ */
    public static boolean m3416(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect r1 = m3433(accessibilityNodeInfo);
        return r1 != null && r1.left > 0 && r1.top > 0 && r1.width() > 0 && r1.height() > 0;
    }

    /* renamed from: ֏ */
    public static int m3386(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i2 = i;
        for (int i3 = 0; i3 < 6; i3++) {
            iArr[i3] = (int) Math.ceil((double) fArr[i3]);
            int i4 = iArr[i3];
            if (i2 > i4) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i4;
            }
            if (i2 == i4) {
                bArr[i3] = (byte) (bArr[i3] + 1);
            }
        }
        return i2;
    }

    /* renamed from: ֏ */
    public static void m3406(char c) {
        String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    /* renamed from: ֏ */
    public static void m3409(long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(j));
        contentValues.put("a", str);
        List<ToastRecord> r2 = m3402(0, 1, Utils.m1857(C1063.m2859("skad_toast_len", (String) null), 10), str);
        if (CollectionUtils.m1657((Collection) r2)) {
            contentValues.put("tl", (Long) null);
            contentValues.put("cl", (String) null);
        } else {
            contentValues.put("tl", r2.get(0).f1639);
            contentValues.put("cl", r2.get(0).f1638);
        }
        List<ToastRecord> r10 = m3402(0, 1, 0, str);
        if (CollectionUtils.m1657((Collection) r10)) {
            contentValues.put("t", (Long) null);
            contentValues.put("c", (String) null);
        } else {
            contentValues.put("t", r10.get(0).f1639);
            contentValues.put("c", r10.get(0).f1638);
        }
        if (contentValues.get("t") == null) {
            DBHelper.m1180().delete("t_atr", "_id=?", new String[]{String.valueOf(j)});
            return;
        }
        DBHelper.m1180().insertWithOnConflict("t_atr", (String) null, contentValues, 5);
    }
}
