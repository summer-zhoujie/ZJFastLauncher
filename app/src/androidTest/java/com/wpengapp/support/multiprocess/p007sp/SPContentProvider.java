package com.wpengapp.support.multiprocess.p007sp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.outline;

@Deprecated
/* renamed from: com.wpengapp.support.multiprocess.sp.SPContentProvider */
public class SPContentProvider extends ContentProvider {

    /* renamed from: ֏ */
    public static String f704 = (AppUtils.m1163() + ".sfsp");

    /* renamed from: ؠ */
    public static final String[] f705 = {"value"};

    /* renamed from: ހ */
    public Context f706;

    /* renamed from: ށ */
    public UriMatcher f707;

    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        String queryParameter = uri.getQueryParameter("name");
        this.f706.getSharedPreferences(queryParameter, 0).edit().remove(uri.getQueryParameter("key")).apply();
        return 1;
    }

    public String getType(@NonNull Uri uri) {
        return null;
    }

    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        String queryParameter = uri.getQueryParameter("name");
        String queryParameter2 = uri.getQueryParameter("key");
        SharedPreferences.Editor edit = this.f706.getSharedPreferences(queryParameter, 0).edit();
        int match = this.f707.match(uri);
        if (match == 1) {
            edit.putString(queryParameter2, contentValues.getAsString("value")).apply();
            return null;
        } else if (match == 2) {
            edit.putInt(queryParameter2, contentValues.getAsInteger("value").intValue()).apply();
            return null;
        } else if (match == 3) {
            edit.putLong(queryParameter2, contentValues.getAsLong("value").longValue()).apply();
            return null;
        } else if (match != 4) {
            edit.putString(queryParameter2, contentValues.getAsString("value")).apply();
            return null;
        } else {
            edit.putBoolean(queryParameter2, contentValues.getAsBoolean("value").booleanValue()).apply();
            return null;
        }
    }

    public boolean onCreate() {
        Context context = getContext();
        outline.m2552("SPContentProvider onCreate, ", (Object) context);
        if (context == null) {
            this.f706 = AppUtils.getApplication();
        } else {
            this.f706 = context.getApplicationContext();
        }
        f704 = this.f706.getPackageName() + ".sfsp";
        this.f707 = new UriMatcher(-1);
        this.f707.addURI(f704, "string", 1);
        this.f707.addURI(f704, "int", 2);
        this.f707.addURI(f704, "long", 3);
        this.f707.addURI(f704, "bool", 4);
        return true;
    }

    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object obj;
        String queryParameter = uri.getQueryParameter("name");
        String queryParameter2 = uri.getQueryParameter("key");
        String queryParameter3 = uri.getQueryParameter("defValue");
        SharedPreferences sharedPreferences = this.f706.getSharedPreferences(queryParameter, 0);
        MatrixCursor matrixCursor = new MatrixCursor(f705, 1);
        int match = this.f707.match(uri);
        if (match == 1) {
            obj = sharedPreferences.getString(queryParameter2, queryParameter3);
        } else if (match == 2) {
            obj = Integer.valueOf(sharedPreferences.getInt(queryParameter2, Integer.parseInt(queryParameter3)));
        } else if (match == 3) {
            obj = Long.valueOf(sharedPreferences.getLong(queryParameter2, Long.parseLong(queryParameter3)));
        } else if (match != 4) {
            obj = sharedPreferences.getString(queryParameter2, queryParameter3);
        } else {
            obj = Integer.valueOf(sharedPreferences.getBoolean(queryParameter2, Boolean.parseBoolean(queryParameter3)) ? 1 : 0);
        }
        matrixCursor.newRow().add(obj);
        return matrixCursor;
    }

    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
