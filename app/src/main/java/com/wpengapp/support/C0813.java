package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.wpengapp.support.ր */
/* compiled from: PatchLoader */
public class C0813 {

    /* renamed from: ֏ */
    public static final String f2099 = new File(AppUtils.getApplication().getFilesDir(), "ptl").getAbsolutePath();

    /* renamed from: ؠ */
    public static C1063.C1065 f2100 = new C0545();

    /* renamed from: ހ */
    public static Runnable f2101 = new C1326();

    /* renamed from: ֏ */
    public static /* synthetic */ void m2148() {
        boolean z;
        try {
            List<AppPatch> r0 = m2151();
            File file = new File(f2099);
            if (CollectionUtils.m1657((Collection) r0)) {
                FileUtils.m1130(file);
                return;
            }
            for (AppPatch r3 : r0) {
                try {
                    m2149(r3);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    Iterator<AppPatch> it = r0.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (name.equals(String.valueOf(it.next().f1928))) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        FileUtils.m1130(file2);
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    /* renamed from: ؠ */
    public static List<AppPatch> m2151() {
        String r1 = C1063.m2859("sp_apppt", (String) null);
        if (TextUtils.isEmpty(r1)) {
            return null;
        }
        return (List) GsonUtil.m2741(r1, new C0857().getType());
    }

    /* renamed from: ހ */
    public static void m2152() {
        if (C1146.m3072()) {
            AppUtils.m1152(f2101);
            AppUtils.m1147(f2101, 5000);
            C1063.C1065 r0 = f2100;
            C1063.f3038.put(r0, r0);
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: ֏ */
    public static void m2149(AppPatch r6) {
        File r0 = m2147((long) r6.f1928);
        if (!r0.exists()) {
            Request.C0874 r1 = new Request.C0874();
            r1.mo8833(r6.f1930);
            C1154 r62 = ((C1140) C1279.f3602.mo8741(r1.mo8835())).mo9320().f1355;
            long r12 = r62.mo7906();
            if (r12 <= 2147483647L) {
                BufferedSource r63 = r62.mo7908();
                try {
                    byte[] r3 = r63.mo8492();
                    Util.m946((Closeable) r63);
                    if (r12 == -1 || r12 == ((long) r3.length)) {
                        try {
                            r3 = Utils.m1899(r3, "aud1ndsacdn2.com".getBytes());
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        FileUtils.m1136(r0, r3);
                        return;
                    }
                    throw new IOException("Content-Length (" + r12 + ") and stream length (" + r3.length + ") disagree");
                } catch (Throwable th) {
                    Util.m946((Closeable) r63);
                    throw th;
                }
            } else {
                throw new IOException("Cannot buffer entire body for content length: " + r12);
            }
        }
    }

    /* renamed from: ֏ */
    public static byte[] m2150(int i) {
        File r2 = m2147((long) i);
        byte[] bArr = null;
        if (!r2.exists()) {
            return null;
        }
        byte[] r22 = FileUtils.m1138(r2);
        if (r22 != null) {
            try {
                bArr = Utils.m1887(r22, "aud1ndsacdn2.com".getBytes("UTF-8"));
            } catch (Exception e) {
                e.getMessage();
                return r22;
            }
        }
        return bArr;
    }

    /* renamed from: ֏ */
    public static File m2147(long j) {
        String str = f2099;
        return new File(str, BidiFormatter.EMPTY_STRING + j);
    }
}
