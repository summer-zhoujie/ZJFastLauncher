package com.wpengapp.support;

import android.content.Context;
import com.wpengapp.support.UMEntry;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.ų */
public class UMCCStorageManager {

    /* renamed from: ֏ */
    public static Context f888;

    /* renamed from: com.wpengapp.support.ų$֏ */
    /* compiled from: UMCCStorageManager */
    private static final class C0499 {

        /* renamed from: ֏ */
        public static final UMCCStorageManager f889 = new UMCCStorageManager((C0795) null);
    }

    public /* synthetic */ UMCCStorageManager(C0795 r1) {
        Context context = f888;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r6.mo7310a(false, false);
        com.wpengapp.support.MLog.m1776("load agg data error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        com.wpengapp.support.DatabaseManager.m2934(f888).mo9277();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005d, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003e */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8031(Callback r6) {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = f888     // Catch:{ Exception -> 0x003e }
            com.wpengapp.support.ਹ r1 = com.wpengapp.support.DatabaseManager.m2934(r1)     // Catch:{ Exception -> 0x003e }
            android.database.sqlite.SQLiteDatabase r1 = r1.mo9275()     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = com.wpengapp.support.Utils.m1866((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ Exception -> 0x003e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = com.wpengapp.support.Utils.m1865((long) r3)     // Catch:{ Exception -> 0x003e }
            java.lang.String r4 = "0"
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x003e }
            if (r4 == 0) goto L_0x002e
            java.lang.String r1 = "faild"
            r6.mo7310a(r1, r0)     // Catch:{ Exception -> 0x003e }
            android.content.Context r6 = f888
            com.wpengapp.support.ਹ r6 = com.wpengapp.support.DatabaseManager.m2934(r6)
            r6.mo9277()
            return
        L_0x002e:
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x003e }
            if (r2 != 0) goto L_0x0038
            com.wpengapp.support.Utils.m1880((android.database.sqlite.SQLiteDatabase) r1, (com.wpengapp.support.Callback) r6)     // Catch:{ Exception -> 0x003e }
            goto L_0x004a
        L_0x0038:
            com.wpengapp.support.Utils.m1894((android.database.sqlite.SQLiteDatabase) r1, (com.wpengapp.support.Callback) r6)     // Catch:{ Exception -> 0x003e }
            goto L_0x004a
        L_0x003c:
            r6 = move-exception
            goto L_0x0054
        L_0x003e:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x003c }
            r6.mo7310a(r1, r0)     // Catch:{ all -> 0x003c }
            java.lang.String r6 = "load agg data error"
            com.wpengapp.support.MLog.m1776(r6)     // Catch:{ all -> 0x003c }
        L_0x004a:
            android.content.Context r6 = f888
            com.wpengapp.support.ਹ r6 = com.wpengapp.support.DatabaseManager.m2934(r6)
            r6.mo9277()
            return
        L_0x0054:
            android.content.Context r0 = f888
            com.wpengapp.support.ਹ r0 = com.wpengapp.support.DatabaseManager.m2934(r0)
            r0.mo9277()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.UMCCStorageManager.mo8031(com.wpengapp.support.ಏ):void");
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: ؠ */
    public Map<String, List<UMEntry.C0552>> mo8037(Callback r2) {
        try {
            Map<String, List<UMEntry.C0552>> r22 = Utils.m1872(r2, DatabaseManager.m2934(f888).mo9275());
            DatabaseManager.m2934(f888).mo9277();
            return r22;
        } catch (Exception e) {
            e.printStackTrace();
            DatabaseManager.m2934(f888).mo9277();
            return null;
        } catch (Throwable th) {
            DatabaseManager.m2934(f888).mo9277();
            throw th;
        }
    }

    /* renamed from: ހ */
    public void mo8039(Callback r2, Map<List<String>, UMCCAggregatedObject> map) {
        try {
            Utils.m1884(r2, DatabaseManager.m2934(f888).mo9276(), map.values());
        } catch (Exception unused) {
            MLog.m1776("cacheToData error");
        } catch (Throwable th) {
            DatabaseManager.m2934(f888).mo9277();
            throw th;
        }
        DatabaseManager.m2934(f888).mo9277();
    }

    /* renamed from: ؠ */
    public void mo8038(Callback r2, Map<String, UMCCSystemBuffer> map) {
        try {
            Utils.m1875(DatabaseManager.m2934(f888).mo9276(), map, r2);
        } catch (Exception unused) {
            MLog.m1776("arrgetated system buffer exception");
        } catch (Throwable th) {
            DatabaseManager.m2934(f888).mo9277();
            throw th;
        }
        DatabaseManager.m2934(f888).mo9277();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: ؠ */
    public List<String> mo8036() {
        try {
            List<String> r0 = Utils.m1903(DatabaseManager.m2934(f888).mo9275());
            DatabaseManager.m2934(f888).mo9277();
            return r0;
        } catch (Exception unused) {
            MLog.m1776("loadCKToMemory exception");
            DatabaseManager.m2934(f888).mo9277();
            return null;
        } catch (Throwable th) {
            DatabaseManager.m2934(f888).mo9277();
            throw th;
        }
    }

    /* renamed from: ֏ */
    public void mo8034(Callback r2, Map<List<String>, UMCCAggregatedObject> map) {
        try {
            Utils.m1882(DatabaseManager.m2934(f888).mo9276(), map.values());
            r2.mo7310a("success", false);
        } catch (Exception unused) {
            MLog.m1776("save agg data error");
        } catch (Throwable th) {
            DatabaseManager.m2934(f888).mo9277();
            throw th;
        }
        DatabaseManager.m2934(f888).mo9277();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: ֏ */
    public Map<String, List<UMEntry.C0551>> mo8030() {
        try {
            Map<String, List<UMEntry.C0551>> r0 = Utils.m1892(DatabaseManager.m2934(f888).mo9275());
            DatabaseManager.m2934(f888).mo9277();
            return r0;
        } catch (Exception unused) {
            MLog.m1776("upload agg date error");
            DatabaseManager.m2934(f888).mo9277();
            return null;
        } catch (Throwable th) {
            DatabaseManager.m2934(f888).mo9277();
            throw th;
        }
    }

    /* renamed from: ֏ */
    public void mo8035(Callback r2, boolean z) {
        try {
            Utils.m1876(DatabaseManager.m2934(f888).mo9276(), z, r2);
        } catch (Exception unused) {
            MLog.m1776("notifyUploadSuccess error");
        } catch (Throwable th) {
            DatabaseManager.m2934(f888).mo9277();
            throw th;
        }
        DatabaseManager.m2934(f888).mo9277();
    }

    /* renamed from: ֏ */
    public void mo8032(Callback r8, String str, long j, long j2) {
        try {
            Utils.m1874(DatabaseManager.m2934(f888).mo9276(), str, j, j2);
            r8.mo7310a("success", false);
        } catch (Exception unused) {
            MLog.m1776("package size to big or envelopeOverflowPackageCount exception");
        } catch (Throwable th) {
            DatabaseManager.m2934(f888).mo9277();
            throw th;
        }
        DatabaseManager.m2934(f888).mo9277();
    }

    /* renamed from: ֏ */
    public void mo8033(Callback r2, List<String> list) {
        try {
            Utils.m1877(r2, DatabaseManager.m2934(f888).mo9276(), list);
        } catch (Exception unused) {
            MLog.m1776("saveToLimitCKTable exception");
        } catch (Throwable th) {
            DatabaseManager.m2934(f888).mo9277();
            throw th;
        }
        DatabaseManager.m2934(f888).mo9277();
    }
}
