package com.wpengapp.support;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.content.FileProvider;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.wpengapp.support.Ɛ */
public class FileManager {

    /* renamed from: ֏ */
    public static final String f914 = outline.m2548(new StringBuilder(), FileUtils.f893, "/WPengApp");

    /* renamed from: ֏ */
    public static void m1193() {
        TaskManager.m2715((Runnable) new C1050());
    }

    /* renamed from: ؠ */
    public static String m1196() {
        StringBuilder r0 = outline.m2549("crash");
        r0.append(DateUtils.m2699(DateUtils.m2700(), "yyyyMMdd_HHmmss"));
        r0.append(".err");
        return r0.toString();
    }

    /* renamed from: ހ */
    public static File m1198() {
        File r0 = m1199();
        if (r0 == null) {
            return null;
        }
        return new File(r0, "cache");
    }

    /* renamed from: ށ */
    public static File m1199() {
        File externalCacheDir = AppUtils.getApplication().getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = AppUtils.getApplication().getExternalFilesDir((String) null);
        }
        if (externalCacheDir != null) {
            externalCacheDir = externalCacheDir.getParentFile();
        }
        if (externalCacheDir == null) {
            return null;
        }
        return new File(externalCacheDir, "app");
    }

    /* renamed from: ނ */
    public static File m1200() {
        File r0 = m1199();
        if (r0 == null) {
            return null;
        }
        return new File(r0, "crash");
    }

    /* renamed from: ֏ */
    public static Uri m1192(File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        Application r0 = AppUtils.getApplication();
        return FileProvider.getUriForFile(r0, AppUtils.m1163() + ".WPengAppFileProvider", file);
    }

    /* renamed from: ؠ */
    public static boolean m1197(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return SystemUtils.m3514((Context) AppUtils.getApplication(), m1192(file), FileUtils.m1137(file.getPath()));
    }

    /* renamed from: ֏ */
    public static boolean m1195(Uri uri) {
        String r0 = FileUtils.m1124(uri);
        if (TextUtils.isEmpty(r0)) {
            return SystemUtils.m3518(uri);
        }
        File file = new File(r0);
        if (!file.exists()) {
            return SystemUtils.m3518(uri);
        }
        return m1197(file);
    }

    /* renamed from: ֏ */
    public static void m1194(File file, long j) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File r3 : listFiles) {
                    m1194(r3, j);
                }
            }
            if (file.lastModified() < j) {
                file.delete();
            }
        }
    }
}
