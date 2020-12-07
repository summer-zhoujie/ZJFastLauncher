package com.wpengapp.support;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileObserver;
import android.support.annotation.Nullable;
import com.wpengapp.support.permission.RequestPermissionHelper;
import java.io.File;

/* renamed from: com.wpengapp.support.װ */
public class MiadManager {

    /* renamed from: ֏ */
    public static C0831 f2168;

    /* renamed from: ؠ */
    public static final RemoteMethod f2169 = new C1232("MIADMA");

    /* renamed from: ހ */
    public static Runnable f2170 = C0573.f1229;

    /* renamed from: com.wpengapp.support.װ$֏ */
    /* compiled from: MiadManager */
    private static class C0831 extends FileObserver {
        public C0831(String str) {
            super(str, 1536);
        }

        public void onEvent(int i, @Nullable String str) {
            if (this != MiadManager.f2168) {
                stopWatching();
                return;
            }
            if (BaseApplication.f562) {
                "miad event " + i + ", " + str;
            }
            AppUtils.m1152(MiadManager.f2170);
            AppUtils.m1147(MiadManager.f2170, 5000);
        }
    }

    /* renamed from: ֏ */
    public static void m2210(boolean z) {
        if (!C1146.m3072()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z);
            C1146.m3071(f2169.f1927, bundle, (RemoteCallback) null);
        } else if (z) {
            AppUtils.m1147(f2170, 5000);
        } else {
            AppUtils.m1152(f2170);
            C0831 r3 = f2168;
            if (r3 != null) {
                r3.stopWatching();
                f2168 = null;
            }
            FileUtils.m1132(m2208());
        }
    }

    /* renamed from: ؠ */
    public static void m2211() {
        if (C1146.m3072() && m2214()) {
            f2169.mo8565();
            m2210(SpHandler.f1753.mo8104().booleanValue());
        }
    }

    /* renamed from: ހ */
    public static /* synthetic */ void m2212() {
        try {
            if (RequestPermissionHelper.m899("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE")) {
                File file = new File(m2208());
                if (!file.exists()) {
                    m2209(file);
                } else if (!file.isFile()) {
                    if (FileUtils.m1130(file)) {
                        m2209(file);
                    }
                }
            }
            C0831 r0 = f2168;
            if (r0 != null) {
                r0.stopWatching();
            }
            f2168 = new C0831(m2208());
            f2168.startWatching();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ނ */
    public static boolean m2214() {
        return BaseApplication.f562 || C0719.m1832();
    }

    /* renamed from: ֏ */
    public static void m2209(File file) {
        FileUtils.m1123(file.getParent(), file.getName());
    }

    @SuppressLint({"SdCardPath"})
    /* renamed from: ֏ */
    public static String m2208() {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return "/sdcard/miad";
            }
            return externalStorageDirectory.getPath() + "/miad";
        } catch (Exception e) {
            e.getMessage();
            return "/sdcard/miad";
        }
    }
}
