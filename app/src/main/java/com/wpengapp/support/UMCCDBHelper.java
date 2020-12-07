package com.wpengapp.support;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.wpengapp.support.ߡ */
public class UMCCDBHelper extends SQLiteOpenHelper {

    /* renamed from: ֏ */
    public static Context f2746;

    /* renamed from: ؠ */
    public String f2747;

    /* renamed from: com.wpengapp.support.ߡ$֏ */
    /* compiled from: UMCCDBHelper */
    private static class C0979 {

        /* renamed from: ֏ */
        public static final UMCCDBHelper f2748;

        static {
            Context context = UMCCDBHelper.f2746;
            StringBuilder r0 = outline.m2549("/data/data/");
            r0.append(context.getPackageName());
            r0.append("/databases/cc/");
            f2748 = new UMCCDBHelper(context, r0.toString(), "cc.db", (SQLiteDatabase.CursorFactory) null, 1, (C1164) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UMCCDBHelper(Context r1, String r2, String r3, SQLiteDatabase.CursorFactory r4, int r5, com.wpengapp.support.C1164 r6) {
        /*
            r0 = this;
            com.wpengapp.support.ਨ r6 = new com.wpengapp.support.ਨ
            r6.<init>(r1, r2)
            if (r3 == 0) goto L_0x000f
            java.lang.String r1 = ""
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0011
        L_0x000f:
            java.lang.String r3 = "cc.db"
        L_0x0011:
            r0.<init>(r6, r3, r4, r5)
            android.database.sqlite.SQLiteDatabase r1 = r0.getWritableDatabase()     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            java.lang.String r2 = "aggregated"
            boolean r2 = r0.mo9039(r2, r1)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            if (r2 == 0) goto L_0x0028
            java.lang.String r2 = "aggregated_cache"
            boolean r2 = r0.mo9039(r2, r1)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            if (r2 != 0) goto L_0x002b
        L_0x0028:
            r0.mo9041(r1)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
        L_0x002b:
            java.lang.String r2 = "system"
            boolean r2 = r0.mo9039(r2, r1)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            if (r2 != 0) goto L_0x0036
            r0.mo9040(r1)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
        L_0x0036:
            java.lang.String r2 = "limitedck"
            boolean r2 = r0.mo9039(r2, r1)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            if (r2 != 0) goto L_0x0044
            r0.mo9038((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ Exception -> 0x0044, all -> 0x0042 }
            goto L_0x0044
        L_0x0042:
            r1 = move-exception
            throw r1
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.UMCCDBHelper.<init>(android.content.Context, java.lang.String, java.lang.String, android.database.sqlite.SQLiteDatabase$CursorFactory, int, com.wpengapp.support.ಠ):void");
    }

    /* renamed from: ֏ */
    public static synchronized UMCCDBHelper m2604(Context context) {
        UMCCDBHelper r1;
        synchronized (UMCCDBHelper.class) {
            f2746 = context;
            r1 = C0979.f2748;
        }
        return r1;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            mo9041(sQLiteDatabase);
            try {
                this.f2747 = "create table if not exists system(Id INTEGER primary key autoincrement, key TEXT, timeStamp INTEGER, count INTEGER)";
                sQLiteDatabase.execSQL(this.f2747);
            } catch (SQLException unused) {
                MLog.m1776("create system table error!");
            }
            try {
                this.f2747 = "create table if not exists limitedck(Id INTEGER primary key autoincrement, ck TEXT unique)";
                sQLiteDatabase.execSQL(this.f2747);
            } catch (SQLException unused2) {
                MLog.m1776("create reference table error!");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* renamed from: ؠ */
    public final boolean mo9040(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2747 = "create table if not exists system(Id INTEGER primary key autoincrement, key TEXT, timeStamp INTEGER, count INTEGER)";
            sQLiteDatabase.execSQL(this.f2747);
            return true;
        } catch (SQLException unused) {
            MLog.m1776("create system table error!");
            return false;
        }
    }

    /* renamed from: ހ */
    public final boolean mo9041(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2747 = "create table if not exists aggregated_cache(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
            sQLiteDatabase.execSQL(this.f2747);
            this.f2747 = "create table if not exists aggregated(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
            sQLiteDatabase.execSQL(this.f2747);
            return true;
        } catch (SQLException unused) {
            MLog.m1776("create aggregated table error!");
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r1 == 0) goto L_0x0040;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9039(String r5, SQLiteDatabase r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003c, all -> 0x0035 }
            r2.<init>()     // Catch:{ Exception -> 0x003c, all -> 0x0035 }
            java.lang.String r3 = "select count(*) as c from sqlite_master where type ='table' and name ='"
            r2.append(r3)     // Catch:{ Exception -> 0x003c, all -> 0x0035 }
            java.lang.String r5 = r5.trim()     // Catch:{ Exception -> 0x003c, all -> 0x0035 }
            r2.append(r5)     // Catch:{ Exception -> 0x003c, all -> 0x0035 }
            java.lang.String r5 = "' "
            r2.append(r5)     // Catch:{ Exception -> 0x003c, all -> 0x0035 }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x003c, all -> 0x0035 }
            android.database.Cursor r1 = r6.rawQuery(r5, r1)     // Catch:{ Exception -> 0x003c, all -> 0x0035 }
            boolean r5 = r1.moveToNext()     // Catch:{ Exception -> 0x003c, all -> 0x0035 }
            if (r5 == 0) goto L_0x0031
            int r5 = r1.getInt(r0)     // Catch:{ Exception -> 0x003c, all -> 0x0035 }
            if (r5 <= 0) goto L_0x0031
            r5 = 1
            r0 = 1
        L_0x0031:
            r1.close()
            goto L_0x0040
        L_0x0035:
            r5 = move-exception
            if (r1 == 0) goto L_0x003b
            r1.close()
        L_0x003b:
            throw r5
        L_0x003c:
            if (r1 == 0) goto L_0x0040
            goto L_0x0031
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.UMCCDBHelper.mo9039(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    /* renamed from: ֏ */
    public final boolean mo9038(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2747 = "create table if not exists limitedck(Id INTEGER primary key autoincrement, ck TEXT unique)";
            sQLiteDatabase.execSQL(this.f2747);
            return true;
        } catch (SQLException unused) {
            MLog.m1776("create reference table error!");
            return false;
        }
    }
}
