package com.wpengapp.support;

import android.app.Notification;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;
import com.umeng.analytics.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.wpengapp.support.ŝ */
/* compiled from: CatchWindowManager */
public class C0488 {

    /* renamed from: ֏ */
    public static final String f860 = Toast.class.getName();

    /* renamed from: ؠ */
    public static long f861;

    /* renamed from: ހ */
    public static long f862;

    /* renamed from: ށ */
    public static long f863;

    /* renamed from: ނ */
    public static long f864;

    /* renamed from: ރ */
    public static final RemoteMethod f865 = new CatchWindowManager("CWMT");

    /* renamed from: ބ */
    public static final RemoteMethod f866 = new C0796("CWMN");

    /* renamed from: ֏ */
    public static void m1081() {
        if (C1146.m3072()) {
            f861 = SystemClock.elapsedRealtime();
            long j = f861;
            f862 = j;
            f863 = j;
            f864 = 31680000;
            f865.mo8565();
            f866.mo8565();
            AppUtils.m1147((Runnable) C0522.f967, 60000);
        }
    }

    /* renamed from: ؠ */
    public static void m1088(Long l) {
        if (l != null && l.longValue() != -1) {
            m1089(l, (String) null);
        }
    }

    /* renamed from: ށ */
    public static /* synthetic */ void m1094() {
        List<PackageInfo> r0 = SystemUtils.m3525();
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<ToastRecord> arrayList = new ArrayList<>();
        loop0:
        for (int i = 0; i < 10000; i++) {
            int i2 = 0;
            for (PackageInfo next : r0) {
                ToastRecord r8 = new ToastRecord();
                r8.f1637 = next.packageName;
                r8.f1638 = next.packageName + "\n" + next.versionName + "\n" + next.toString();
                i2++;
                r8.f1639 = Long.valueOf((currentTimeMillis - (((long) i) * AnalyticsConstants.f107j)) - (((long) i2) * 60000));
                arrayList.add(r8);
                if (arrayList.size() >= 1000) {
                    break loop0;
                }
            }
        }
        DBHelper.m1180().beginTransaction();
        try {
            for (ToastRecord r1 : arrayList) {
                C1279.m3413(r1);
            }
            DBHelper.m1180().setTransactionSuccessful();
        } catch (Exception e) {
            e.getMessage();
            C0975.m2602(e);
        } catch (Throwable th) {
            DBHelper.m1180().endTransaction();
            throw th;
        }
        DBHelper.m1180().endTransaction();
        C0826.m2180((CharSequence) "insertToastTestData success: " + arrayList.size());
        "insertToastTestData success: " + arrayList.size();
    }

    /* renamed from: ނ */
    public static /* synthetic */ void m1095() {
        List<PackageInfo> r0 = SystemUtils.m3525();
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<NotifyRecord> arrayList = new ArrayList<>();
        loop0:
        for (int i = 0; i < 10000; i++) {
            int i2 = 0;
            for (PackageInfo next : r0) {
                NotifyRecord r8 = new NotifyRecord();
                r8.f3460 = next.packageName;
                r8.f3461 = "新版发布啦！！！！！！！！！！23423423423";
                r8.f3462 = next.packageName + "\n" + next.versionName + "\n" + next.toString();
                r8.f3461 = m1093(r8.f3461);
                r8.f3462 = m1093(r8.f3462);
                i2++;
                r8.f3464 = Long.valueOf((currentTimeMillis - (((long) i) * AnalyticsConstants.f107j)) - (((long) i2) * 60000));
                arrayList.add(r8);
                if (arrayList.size() >= 50000) {
                    break loop0;
                }
            }
        }
        DBHelper.m1180().beginTransaction();
        try {
            for (NotifyRecord r1 : arrayList) {
                C1279.m3387(r1);
            }
            DBHelper.m1180().setTransactionSuccessful();
        } catch (Exception e) {
            e.getMessage();
            C0975.m2602(e);
        } catch (Throwable th) {
            DBHelper.m1180().endTransaction();
            throw th;
        }
        DBHelper.m1180().endTransaction();
        C0826.m2180((CharSequence) "insertNotifyTestData success: " + arrayList.size());
        "insertNotifyTestData success: " + arrayList.size();
    }

    /* renamed from: ރ */
    public static /* synthetic */ void m1096() {
        C1279.m3427(System.currentTimeMillis() - 2592000000L);
        C1279.m3408(System.currentTimeMillis() - 2592000000L);
        NotifyImageManager.m1921(System.currentTimeMillis() - 2592000000L);
    }

    /* renamed from: ހ */
    public static void m1092(String str) {
        if (!TextUtils.isEmpty(str)) {
            m1089((Long) null, str);
        }
    }

    /* renamed from: ؠ */
    public static void m1089(Long l, String str) {
        String str2;
        AppToastRecord r1 = null;
        if (!C1146.m3072()) {
            Bundle bundle = new Bundle();
            if (l != null) {
                bundle.putLong("id", l.longValue());
            }
            bundle.putString("app", str);
            C1146.m3071(f865.f1927, bundle, (RemoteCallback) null);
        } else if (l != null && l.longValue() != -1) {
            DBHelper.m1180().beginTransaction();
            try {
                String[] strArr = {String.valueOf(l)};
                Cursor query = DBHelper.m1180().query("t_tr", (String[]) null, "_id=?", strArr, (String) null, (String) null, (String) null, (String) null);
                if (query != null) {
                    str2 = query.moveToFirst() ? query.getString(query.getColumnIndex("a")) : null;
                    query.close();
                } else {
                    str2 = null;
                }
                DBHelper.m1180().delete("t_tr", "_id=?", strArr);
                if (str2 == null) {
                    DBHelper.m1180().setTransactionSuccessful();
                } else {
                    Cursor query2 = DBHelper.m1180().query("t_atr", (String[]) null, "a=?", new String[]{str2}, (String) null, (String) null, (String) null, (String) null);
                    if (query2 != null) {
                        if (query2.moveToFirst()) {
                            r1 = C1279.m3423(query2);
                        }
                        query2.close();
                    }
                    if (r1 == null) {
                        DBHelper.m1180().setTransactionSuccessful();
                    } else {
                        C1279.m3409(r1.f1636.longValue(), str2);
                        DBHelper.m1180().setTransactionSuccessful();
                    }
                }
            } catch (Exception e) {
                e.getMessage();
                C0975.m2602(e);
            } catch (Throwable th) {
                DBHelper.m1180().endTransaction();
                throw th;
            }
            DBHelper.m1180().endTransaction();
        } else if (!TextUtils.isEmpty(str)) {
            DBHelper.m1180().beginTransaction();
            try {
                String[] strArr2 = {str};
                DBHelper.m1180().delete("t_tr", "a=?", strArr2);
                DBHelper.m1180().delete("t_atr", "a=?", strArr2);
                DBHelper.m1180().setTransactionSuccessful();
            } catch (Exception e2) {
                e2.getMessage();
                C0975.m2602(e2);
            } catch (Throwable th2) {
                DBHelper.m1180().endTransaction();
                throw th2;
            }
            DBHelper.m1180().endTransaction();
        } else {
            DBHelper.m1180().beginTransaction();
            try {
                DBHelper.m1180().delete("t_tr", (String) null, (String[]) null);
                DBHelper.m1180().delete("t_atr", (String) null, (String[]) null);
                DBHelper.m1180().setTransactionSuccessful();
            } catch (Exception e3) {
                e3.getMessage();
                C0975.m2602(e3);
            } catch (Throwable th3) {
                DBHelper.m1180().endTransaction();
                throw th3;
            }
            DBHelper.m1180().endTransaction();
        }
    }

    /* renamed from: ֏ */
    public static void m1082(AccessibilityEvent accessibilityEvent) {
        Notification notification;
        Bundle bundle;
        Icon icon;
        Icon icon2;
        if (accessibilityEvent != null && accessibilityEvent.getEventType() == 64) {
            if (SpHandler.f1760.mo8104().booleanValue()) {
                CharSequence className = accessibilityEvent.getClassName();
                if (!TextUtils.isEmpty(className) && className.toString().startsWith(f860)) {
                    CharSequence packageName = accessibilityEvent.getPackageName();
                    List text = accessibilityEvent.getText();
                    if (!TextUtils.equals(AppUtils.m1163(), packageName) && !CollectionUtils.m1657((Collection) text)) {
                        String join = TextUtils.join("\n", text);
                        if (!join.trim().isEmpty()) {
                            TaskManager.m2720(new C0965(packageName, join));
                        }
                    }
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - f863 > f864) {
                f863 = elapsedRealtime;
                TaskManager.m2718(new C1321());
            }
            if (SpHandler.f1763.mo8104().booleanValue()) {
                Parcelable parcelableData = accessibilityEvent.getParcelableData();
                if ((parcelableData instanceof Notification) && (bundle = notification.extras) != null) {
                    try {
                        ApplicationInfo applicationInfo = (ApplicationInfo) bundle.get("android.appInfo");
                        if (applicationInfo != null) {
                            String str = applicationInfo.packageName;
                            CharSequence charSequence = (CharSequence) bundle.get(NotificationCompat.EXTRA_TEXT);
                            CharSequence charSequence2 = (CharSequence) bundle.get(NotificationCompat.EXTRA_TITLE);
                            if (!TextUtils.isEmpty(charSequence) || !TextUtils.isEmpty(charSequence2)) {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    icon2 = (notification = (Notification) parcelableData).getLargeIcon();
                                    icon = notification.getSmallIcon();
                                } else {
                                    icon2 = null;
                                    icon = null;
                                }
                                TaskManager.m2720(new C0479(str, charSequence2, charSequence, icon2, icon, Build.VERSION.SDK_INT >= 26 ? notification.getChannelId() : null));
                            }
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
        }
    }

    /* renamed from: ށ */
    public static String m1093(String str) {
        try {
            return Utils.m1891(str, "CWM@$@#$)*(&@#^!FASDKLJ");
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m1083(CharSequence charSequence, String str) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        ToastRecord r2 = new ToastRecord();
        Cursor cursor = null;
        if (charSequence == null) {
            str2 = null;
        } else {
            str2 = charSequence.toString();
        }
        r2.f1637 = str2;
        r2.f1638 = str;
        r2.f1639 = Long.valueOf(currentTimeMillis);
        DBHelper.m1180().beginTransaction();
        try {
            C1279.m3413(r2);
            DBHelper.m1180().setTransactionSuccessful();
        } catch (Exception e) {
            e.getMessage();
            C0975.m2602(e);
        } catch (Throwable th) {
            DBHelper.m1180().endTransaction();
            throw th;
        }
        DBHelper.m1180().endTransaction();
        if (SystemClock.elapsedRealtime() - f861 > 82800000) {
            f861 = SystemClock.elapsedRealtime();
            C1279.m3427(currentTimeMillis - 2592000000L);
            int i = 0;
            try {
                cursor = DBHelper.m1180().rawQuery("SELECT COUNT(*) AS count FROM t_tr WHERE t>=? AND t<?", new String[]{String.valueOf(currentTimeMillis - AnalyticsConstants.f107j), String.valueOf(currentTimeMillis)});
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        i = cursor.getInt(cursor.getColumnIndex("count"));
                    } while (cursor.moveToNext());
                }
            } catch (Exception e2) {
                e2.getMessage();
                C0975.m2602(e2);
            } catch (Throwable th2) {
                DBHelper.m1179((Cursor) null);
                throw th2;
            }
            DBHelper.m1179(cursor);
            UMengManager.m1405("CATCH_TOAST_DAU", String.valueOf(i));
            UMengManager.m1405("CATCH_TOAST", String.valueOf(str.length()));
        }
    }

    /* renamed from: ؠ */
    public static void m1087() {
        if (BaseApplication.f562) {
            if (!C1146.m3072()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("itd", true);
                C1146.m3071(f865.f1927, bundle, (RemoteCallback) null);
                return;
            }
            C0826.m2180((CharSequence) "insertTestData...");
            TaskManager.m2720(C0531.f1003);
            TaskManager.m2720(C0828.f2156);
        }
    }

    /* renamed from: ؠ */
    public static void m1090(String str) {
        if (!TextUtils.isEmpty(str)) {
            m1085((Long) null, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m1086(String r5, CharSequence r6, CharSequence r7, Icon r8, Icon r9, String r10) {
        /*
            long r8 = java.lang.System.currentTimeMillis()
            r0 = 0
            if (r5 != 0) goto L_0x0009
            r5 = r0
            goto L_0x000d
        L_0x0009:
            java.lang.String r5 = r5.toString()
        L_0x000d:
            if (r6 != 0) goto L_0x0011
            r6 = r0
            goto L_0x0019
        L_0x0011:
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = m1093(r6)
        L_0x0019:
            if (r7 != 0) goto L_0x001d
            r7 = r0
            goto L_0x0025
        L_0x001d:
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = m1093(r7)
        L_0x0025:
            java.lang.Long r1 = java.lang.Long.valueOf(r8)
            android.database.sqlite.SQLiteDatabase r2 = com.wpengapp.support.DBHelper.m1180()
            r2.beginTransaction()
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x006b }
            r2.<init>()     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = "_id"
            r2.put(r3, r0)     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = "a"
            r2.put(r3, r5)     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = "ti"
            r2.put(r3, r6)     // Catch:{ Exception -> 0x006b }
            java.lang.String r6 = "c"
            r2.put(r6, r7)     // Catch:{ Exception -> 0x006b }
            java.lang.String r6 = "ch"
            r2.put(r6, r10)     // Catch:{ Exception -> 0x006b }
            java.lang.String r6 = "t"
            r2.put(r6, r1)     // Catch:{ Exception -> 0x006b }
            android.database.sqlite.SQLiteDatabase r6 = com.wpengapp.support.DBHelper.m1180()     // Catch:{ Exception -> 0x006b }
            r7 = 4
            java.lang.String r10 = "t_nr"
            long r6 = r6.insertWithOnConflict(r10, r0, r2, r7)     // Catch:{ Exception -> 0x006b }
            android.database.sqlite.SQLiteDatabase r10 = com.wpengapp.support.DBHelper.m1180()     // Catch:{ Exception -> 0x0066 }
            r10.setTransactionSuccessful()     // Catch:{ Exception -> 0x0066 }
            goto L_0x0075
        L_0x0066:
            r10 = move-exception
            goto L_0x006f
        L_0x0068:
            r5 = move-exception
            goto L_0x0105
        L_0x006b:
            r6 = move-exception
            r10 = r6
            r6 = -1
        L_0x006f:
            r10.getMessage()     // Catch:{ all -> 0x0068 }
            com.wpengapp.support.C0975.m2602(r10)     // Catch:{ all -> 0x0068 }
        L_0x0075:
            android.database.sqlite.SQLiteDatabase r10 = com.wpengapp.support.DBHelper.m1180()
            r10.endTransaction()
            java.lang.String r10 = com.wpengapp.support.NotifyImageManager.m1916(r5, r6)
            int r1 = com.wpengapp.support.NotifyImageManager.f1905
            r2 = 0
            com.wpengapp.support.NotifyImageManager.m1919(r0, r10, r2, r1)
            java.lang.String r5 = com.wpengapp.support.NotifyImageManager.m1920(r5, r6)
            int r6 = com.wpengapp.support.NotifyImageManager.f1903
            int r7 = com.wpengapp.support.NotifyImageManager.f1904
            com.wpengapp.support.NotifyImageManager.m1919(r0, r5, r6, r7)
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r3 = f862
            long r5 = r5 - r3
            r3 = 82800000(0x4ef6d80, double:4.09086355E-316)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0104
            long r5 = android.os.SystemClock.elapsedRealtime()
            f862 = r5
            r5 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            long r5 = r8 - r5
            com.wpengapp.support.C1279.m3408((long) r5)
            com.wpengapp.support.NotifyImageManager.m1921(r5)
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            long r5 = r8 - r5
            java.lang.String r7 = "SELECT COUNT(*) AS count FROM t_nr WHERE t>=? AND t<?"
            android.database.sqlite.SQLiteDatabase r10 = com.wpengapp.support.DBHelper.m1180()     // Catch:{ Exception -> 0x00ec }
            r1 = 2
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ Exception -> 0x00ec }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00ec }
            r1[r2] = r5     // Catch:{ Exception -> 0x00ec }
            r5 = 1
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x00ec }
            r1[r5] = r6     // Catch:{ Exception -> 0x00ec }
            android.database.Cursor r0 = r10.rawQuery(r7, r1)     // Catch:{ Exception -> 0x00ec }
            if (r0 == 0) goto L_0x00f3
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x00ec }
            if (r5 == 0) goto L_0x00f3
        L_0x00d9:
            java.lang.String r5 = "count"
            int r5 = r0.getColumnIndex(r5)     // Catch:{ Exception -> 0x00ec }
            int r2 = r0.getInt(r5)     // Catch:{ Exception -> 0x00ec }
            boolean r5 = r0.moveToNext()     // Catch:{ Exception -> 0x00ec }
            if (r5 != 0) goto L_0x00d9
            goto L_0x00f3
        L_0x00ea:
            r5 = move-exception
            goto L_0x0100
        L_0x00ec:
            r5 = move-exception
            r5.getMessage()     // Catch:{ all -> 0x00ea }
            com.wpengapp.support.C0975.m2602(r5)     // Catch:{ all -> 0x00ea }
        L_0x00f3:
            com.wpengapp.support.DBHelper.m1179((android.database.Cursor) r0)
            java.lang.String r5 = java.lang.String.valueOf(r2)
            java.lang.String r6 = "CATCH_NOTIFY_DAU"
            com.wpengapp.support.UMengManager.m1405((java.lang.String) r6, (java.lang.String) r5)
            goto L_0x0104
        L_0x0100:
            com.wpengapp.support.DBHelper.m1179((android.database.Cursor) r0)
            throw r5
        L_0x0104:
            return
        L_0x0105:
            android.database.sqlite.SQLiteDatabase r6 = com.wpengapp.support.DBHelper.m1180()
            r6.endTransaction()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0488.m1086(java.lang.String, java.lang.CharSequence, java.lang.CharSequence, android.graphics.drawable.Icon, android.graphics.drawable.Icon, java.lang.String):void");
    }

    /* renamed from: ֏ */
    public static String m1080(String str) {
        try {
            return Utils.m1868(str, "CWM@$@#$)*(&@#^!FASDKLJ");
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: ֏ */
    public static void m1084(Long l) {
        if (l != null && l.longValue() != -1) {
            m1085(l, (String) null);
        }
    }

    /* renamed from: ֏ */
    public static void m1085(Long l, String str) {
        if (!C1146.m3072()) {
            Bundle bundle = new Bundle();
            if (l != null) {
                bundle.putLong("id", l.longValue());
            }
            bundle.putString("app", str);
            C1146.m3071(f866.f1927, bundle, (RemoteCallback) null);
        } else if (l != null && l.longValue() != -1) {
            DBHelper.m1180().beginTransaction();
            try {
                DBHelper.m1180().delete("t_nr", "_id=?", new String[]{String.valueOf(l)});
                DBHelper.m1180().setTransactionSuccessful();
            } catch (Exception e) {
                e.getMessage();
                C0975.m2602(e);
            } catch (Throwable th) {
                DBHelper.m1180().endTransaction();
                throw th;
            }
            DBHelper.m1180().endTransaction();
            NotifyImageManager.m1917(l.longValue());
        } else if (!TextUtils.isEmpty(str)) {
            DBHelper.m1180().beginTransaction();
            try {
                DBHelper.m1180().delete("t_nr", "a=?", new String[]{str});
                DBHelper.m1180().setTransactionSuccessful();
            } catch (Exception e2) {
                e2.getMessage();
                C0975.m2602(e2);
            } catch (Throwable th2) {
                DBHelper.m1180().endTransaction();
                throw th2;
            }
            DBHelper.m1180().endTransaction();
            NotifyImageManager.m1918(str);
        } else {
            DBHelper.m1180().beginTransaction();
            try {
                DBHelper.m1180().delete("t_nr", (String) null, (String[]) null);
                DBHelper.m1180().setTransactionSuccessful();
            } catch (Exception e3) {
                e3.getMessage();
                C0975.m2602(e3);
            } catch (Throwable th3) {
                DBHelper.m1180().endTransaction();
                throw th3;
            }
            DBHelper.m1180().endTransaction();
            FileUtils.m1132(NotifyImageManager.f1902);
        }
    }
}
