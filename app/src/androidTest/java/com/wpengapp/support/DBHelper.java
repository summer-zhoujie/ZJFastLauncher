package com.wpengapp.support;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.wpengapp.support.ż */
public class DBHelper extends SQLiteOpenHelper {

    /* renamed from: ֏ */
    public static DBHelper f904 = new DBHelper(AppUtils.getApplication());

    public DBHelper(Context context) {
        super(context, "main.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    /* renamed from: އ */
    public static SQLiteDatabase m1180() {
        return f904.getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            mo8051(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            e.getMessage();
            C0975.m2602(e);
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            sQLiteDatabase.execSQL(C1279.m3434());
            sQLiteDatabase.execSQL(C1279.m3431());
        }
    }

    /* renamed from: ֏ */
    public final void mo8051(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_tr (" + "_id integer primary key autoincrement, a varchar, c varchar, t integer " + ")");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS " + "at" + " ON " + "t_tr" + "(" + "a" + "," + "t" + ")");
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS t_atr (");
        sb.append("_id integer primary key autoincrement, a varchar not null unique, c varchar, cl varchar, t integer, tl integer ");
        sb.append(")");
        sQLiteDatabase.execSQL(sb.toString());
        sQLiteDatabase.execSQL(C1279.m3434());
        sQLiteDatabase.execSQL(C1279.m3431());
    }

    /* renamed from: ֏ */
    public static void m1179(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
