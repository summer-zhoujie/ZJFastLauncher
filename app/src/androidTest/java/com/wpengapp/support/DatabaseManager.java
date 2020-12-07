package com.wpengapp.support;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.wpengapp.support.ਹ */
public class DatabaseManager {

    /* renamed from: ֏ */
    public static DatabaseManager f3106;

    /* renamed from: ؠ */
    public static SQLiteOpenHelper f3107;

    /* renamed from: ހ */
    public AtomicInteger f3108 = new AtomicInteger();

    /* renamed from: ށ */
    public AtomicInteger f3109 = new AtomicInteger();

    /* renamed from: ނ */
    public SQLiteDatabase f3110;

    /* renamed from: ֏ */
    public static synchronized DatabaseManager m2934(Context context) {
        DatabaseManager r2;
        synchronized (DatabaseManager.class) {
            if (f3106 == null) {
                m2935(context);
            }
            r2 = f3106;
        }
        return r2;
    }

    /* renamed from: ؠ */
    public static synchronized void m2935(Context context) {
        synchronized (DatabaseManager.class) {
            if (f3106 == null) {
                f3106 = new DatabaseManager();
                f3107 = UMCCDBHelper.m2604(context);
            }
        }
    }

    /* renamed from: ހ */
    public synchronized void mo9277() {
        if (this.f3108.decrementAndGet() == 0) {
            this.f3110.close();
        }
        if (this.f3109.decrementAndGet() == 0) {
            this.f3110.close();
        }
    }

    /* renamed from: ֏ */
    public synchronized SQLiteDatabase mo9275() {
        if (this.f3108.incrementAndGet() == 1) {
            this.f3110 = f3107.getReadableDatabase();
        }
        return this.f3110;
    }

    /* renamed from: ؠ */
    public synchronized SQLiteDatabase mo9276() {
        if (this.f3108.incrementAndGet() == 1) {
            this.f3110 = f3107.getWritableDatabase();
        }
        return this.f3110;
    }
}
