package com.wpengapp.support;

import android.content.Context;
import java.util.regex.Pattern;

/* renamed from: com.wpengapp.support.ݔ */
public class UTDIdTracker extends AbstractIdTracker {

    /* renamed from: ށ */
    public static final Pattern f2518 = Pattern.compile("UTDID\">([^<]+)");

    /* renamed from: ނ */
    public Context f2519;

    public UTDIdTracker(Context context) {
        super("utdid");
        this.f2519 = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053 A[SYNTHETIC, Splitter:B:17:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public String mo8028() {
        /*
            r7 = this;
            java.lang.String r0 = "com.ut.device.UTDevice"
            r1 = 0
            r2 = 1
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0022 }
            java.lang.String r3 = "getUtdid"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0022 }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x0022 }
            java.lang.reflect.Method r0 = r0.getMethod(r3, r4)     // Catch:{ Exception -> 0x0022 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0022 }
            android.content.Context r4 = r7.f2519     // Catch:{ Exception -> 0x0022 }
            r3[r6] = r4     // Catch:{ Exception -> 0x0022 }
            java.lang.Object r0 = r0.invoke(r1, r3)     // Catch:{ Exception -> 0x0022 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0022 }
            return r0
        L_0x0022:
            android.content.Context r0 = r7.f2519
            java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r0 = com.wpengapp.support.DeviceConfig.m2313((android.content.Context) r0, (java.lang.String) r3)
            if (r0 != 0) goto L_0x002d
            goto L_0x0049
        L_0x002d:
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r3 = "mounted"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0049
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0049 }
            java.lang.String r0 = r0.getCanonicalPath()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = ".UTSystemConfig/Global/Alvin2.xml"
            r3.<init>(r0, r4)     // Catch:{ Exception -> 0x0049 }
            goto L_0x004a
        L_0x0049:
            r3 = r1
        L_0x004a:
            if (r3 == 0) goto L_0x007f
            boolean r0 = r3.exists()
            if (r0 != 0) goto L_0x0053
            goto L_0x007f
        L_0x0053:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x007b }
            r0.<init>(r3)     // Catch:{ Exception -> 0x007b }
            java.lang.String r3 = com.wpengapp.support.HelperUtils.m2468((java.io.InputStream) r0)     // Catch:{ all -> 0x0076 }
            if (r3 != 0) goto L_0x005f
            goto L_0x0070
        L_0x005f:
            java.util.regex.Pattern r4 = f2518     // Catch:{ all -> 0x0076 }
            java.util.regex.Matcher r3 = r4.matcher(r3)     // Catch:{ all -> 0x0076 }
            boolean r4 = r3.find()     // Catch:{ all -> 0x0076 }
            if (r4 == 0) goto L_0x0070
            java.lang.String r2 = r3.group(r2)     // Catch:{ all -> 0x0076 }
            goto L_0x0071
        L_0x0070:
            r2 = r1
        L_0x0071:
            com.wpengapp.support.HelperUtils.m2474(r0)     // Catch:{ Exception -> 0x007b }
            r1 = r2
            goto L_0x007f
        L_0x0076:
            r2 = move-exception
            com.wpengapp.support.HelperUtils.m2474(r0)     // Catch:{ Exception -> 0x007b }
            throw r2     // Catch:{ Exception -> 0x007b }
        L_0x007b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.UTDIdTracker.mo8028():java.lang.String");
    }
}
