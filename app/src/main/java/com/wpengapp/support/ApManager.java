package com.wpengapp.support;

import android.os.Build;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.wpengapp.support.ഽ */
public class ApManager {

    /* renamed from: ֏ */
    public static boolean f3346;

    /* renamed from: ؠ */
    public static boolean f3347;

    /* renamed from: ހ */
    public static final AtomicInteger f3348 = new AtomicInteger();

    /* renamed from: ֏ */
    public static /* synthetic */ void m3174() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", String.valueOf(AppUtils.m1158()));
        hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device", C0719.m1816());
        StatisticsManager.m733("def", "apls_timeout", hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0188, code lost:
        r14 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0255  */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m3175() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 1
            r3 = 26
            if (r0 == r3) goto L_0x027a
            r3 = 27
            if (r0 != r3) goto L_0x000e
            goto L_0x027a
        L_0x000e:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "enable_ap"
            java.lang.String r4 = "true"
            java.lang.String r3 = com.wpengapp.support.C1063.m2859((java.lang.String) r3, (java.lang.String) r4)
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0025
            f3347 = r2
            return r1
        L_0x0025:
            com.wpengapp.support.Ĩ r3 = com.wpengapp.support.C0465.f791
            r4 = 10000(0x2710, double:4.9407E-320)
            com.wpengapp.support.AppUtils.m1147((java.lang.Runnable) r3, (long) r4)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "START,"
            r6.<init>(r0)
            long r7 = java.lang.System.currentTimeMillis()
            r6.append(r7)
            java.lang.String r7 = ";"
            r6.append(r7)
            long r8 = android.os.SystemClock.uptimeMillis()
            android.app.Application r0 = com.wpengapp.support.AppUtils.m1160()     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            java.lang.String r11 = "ap34"
            java.io.InputStream r0 = r0.open(r11)     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            byte[] r0 = com.wpengapp.support.FileUtils.m1133((java.io.InputStream) r0)     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            java.lang.String r11 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCIhUGSlwx/fSBeRJ3EHhmTWTXMcqCJxzlsNWNvg+4V11Em+ELwbj/ditHY3tUn/0RupNmRw3EWv1K4YoA3/51eDYcLi2VyiWcsbKX+xsyyy//l942zZe8lR5W7zLnLqmwnZIl0ZXIlumtkZfLge+dVchYiD7/jKJmMU/VTXn0yzwIDAQAB"
            byte[] r0 = com.wpengapp.support.Utils.m1898((byte[]) r0, (java.lang.String) r11)     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            android.app.Application r12 = com.wpengapp.support.AppUtils.m1160()     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            java.io.File r12 = r12.getFilesDir()     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            r13.<init>()     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            java.lang.String r14 = "ap/"
            r13.append(r14)     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            r13.append(r8)     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            java.util.concurrent.atomic.AtomicInteger r14 = f3348     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            int r14 = r14.getAndIncrement()     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            r13.append(r14)     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            r11.<init>(r12, r13)     // Catch:{ Exception -> 0x01aa, all -> 0x01a3 }
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r13.<init>()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r13.append(r14)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r14 = ""
            r13.append(r14)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r12.<init>(r11, r13)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.io.ByteArrayInputStream r13 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r13.<init>(r0)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            com.wpengapp.support.FileUtils.m1129((java.io.InputStream) r13, (java.io.File) r12)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r0 = "LSFILE,"
            r6.append(r0)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r6.append(r13)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r6.append(r7)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r0 = "null"
            java.lang.String r12 = r12.getAbsolutePath()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r13 = "com.wpengapp.ap.LocalService"
            r14 = 6
            java.lang.String[] r14 = new java.lang.String[r14]     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            boolean r15 = f3346     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r14[r1] = r15     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r14[r2] = r0     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r0 = 2
            java.lang.String r15 = com.wpengapp.support.AppUtils.m1163()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r14[r0] = r15     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r0 = 3
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r15.<init>()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r10 = com.wpengapp.support.ApiConstant.m2593()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r15.append(r10)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r10 = "/"
            r15.append(r10)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r10 = com.wpengapp.support.C1279.m3425()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r10 = r10.toLowerCase()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r15.append(r10)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r10 = r15.toString()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r14[r0] = r10     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r0 = 4
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r14[r0] = r10     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r0 = 5
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r14[r0] = r10     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.Process r0 = com.wpengapp.support.C1279.m3399((boolean) r1, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String[]) r14)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r10.<init>()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r12 = "sh proc "
            r10.append(r12)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r10.append(r0)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r10.toString()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.lang.String r10 = "EXEC,"
            r6.append(r10)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r6.append(r12)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r6.append(r7)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.io.InputStreamReader r12 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.io.InputStream r13 = r0.getInputStream()     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r12.<init>(r13)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            r10.<init>(r12)     // Catch:{ Exception -> 0x01a0, all -> 0x019e }
            java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ Exception -> 0x019c, all -> 0x0196 }
            java.io.InputStreamReader r13 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x019c, all -> 0x0196 }
            java.io.InputStream r0 = r0.getErrorStream()     // Catch:{ Exception -> 0x019c, all -> 0x0196 }
            r13.<init>(r0)     // Catch:{ Exception -> 0x019c, all -> 0x0196 }
            r12.<init>(r13)     // Catch:{ Exception -> 0x019c, all -> 0x0196 }
            java.lang.String r0 = r10.readLine()     // Catch:{ Exception -> 0x0194 }
            r13 = r0
        L_0x0148:
            if (r13 == 0) goto L_0x0188
            r6.append(r13)     // Catch:{ Exception -> 0x0186 }
            r6.append(r7)     // Catch:{ Exception -> 0x0186 }
            java.lang.String r0 = "APLS_FINISH_SUCCESS_CREATE"
            boolean r0 = r13.startsWith(r0)     // Catch:{ Exception -> 0x0186 }
            if (r0 != 0) goto L_0x0184
            java.lang.String r0 = "APLS_FINISH_SUCCESS_AUTO_EXIT"
            boolean r0 = r13.startsWith(r0)     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x0161
            goto L_0x0184
        L_0x0161:
            java.lang.String r0 = "APLS_FINISH_ERR"
            boolean r0 = r13.startsWith(r0)     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x016a
            goto L_0x0188
        L_0x016a:
            java.lang.String r0 = "APLS_FINISH_SUCCESS_NORMAL"
            boolean r0 = r13.startsWith(r0)     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x0176
            com.wpengapp.support.FileUtils.m1130((java.io.File) r11)     // Catch:{ Exception -> 0x0186 }
            goto L_0x0188
        L_0x0176:
            java.lang.String r0 = "APLS_FINISH"
            boolean r0 = r13.startsWith(r0)     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x017f
            goto L_0x0188
        L_0x017f:
            java.lang.String r13 = r10.readLine()     // Catch:{ Exception -> 0x0186 }
            goto L_0x0148
        L_0x0184:
            r14 = 1
            goto L_0x0189
        L_0x0186:
            r0 = move-exception
            goto L_0x01af
        L_0x0188:
            r14 = 0
        L_0x0189:
            if (r14 != 0) goto L_0x0192
            java.lang.String r0 = m3173(r12)     // Catch:{ Exception -> 0x0190 }
            goto L_0x01b4
        L_0x0190:
            r0 = move-exception
            goto L_0x01b0
        L_0x0192:
            r0 = 0
            goto L_0x01b4
        L_0x0194:
            r0 = move-exception
            goto L_0x01ae
        L_0x0196:
            r0 = move-exception
            r16 = r10
            r12 = 0
            goto L_0x026e
        L_0x019c:
            r0 = move-exception
            goto L_0x01ad
        L_0x019e:
            r0 = move-exception
            goto L_0x01a5
        L_0x01a0:
            r0 = move-exception
            r10 = 0
            goto L_0x01ad
        L_0x01a3:
            r0 = move-exception
            r11 = 0
        L_0x01a5:
            r12 = 0
            r16 = 0
            goto L_0x026e
        L_0x01aa:
            r0 = move-exception
            r10 = 0
            r11 = 0
        L_0x01ad:
            r12 = 0
        L_0x01ae:
            r13 = 0
        L_0x01af:
            r14 = 0
        L_0x01b0:
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x026b }
        L_0x01b4:
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r10)
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r12)
            com.wpengapp.support.FileUtils.m1130((java.io.File) r11)
            f3347 = r2
            java.lang.String r2 = "END,"
            r6.append(r2)
            long r10 = java.lang.System.currentTimeMillis()
            r6.append(r10)
            r6.append(r7)
            java.lang.String r2 = r6.toString()
            long r6 = android.os.SystemClock.uptimeMillis()
            long r6 = r6 - r8
            if (r13 != 0) goto L_0x01db
            r10 = 0
            goto L_0x01e3
        L_0x01db:
            java.lang.String r8 = ","
            java.lang.String[] r8 = r13.split(r8)
            r10 = r8[r1]
        L_0x01e3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r8 = "Start Ret "
            r1.append(r8)
            r1.append(r10)
            java.lang.String r8 = ", time "
            r1.append(r8)
            r1.append(r6)
            java.lang.String r8 = "ms, log "
            r1.append(r8)
            r1.append(r2)
            r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r8 = "Err "
            r1.append(r8)
            r1.append(r0)
            r1.toString()
            com.wpengapp.support.AppUtils.m1152((java.lang.Runnable) r3)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            int r3 = com.wpengapp.support.AppUtils.m1158()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r8 = "ver"
            r1.put(r8, r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r8 = "sdk"
            r1.put(r8, r3)
            java.lang.String r3 = com.wpengapp.support.C0719.m1816()
            java.lang.String r8 = "device"
            r1.put(r8, r3)
            java.lang.String r3 = java.lang.String.valueOf(r14)
            java.lang.String r8 = "ret"
            r1.put(r8, r3)
            java.lang.String r3 = "line"
            r1.put(r3, r10)
            if (r14 != 0) goto L_0x0251
            java.lang.String r3 = "err"
            r1.put(r3, r0)
        L_0x0251:
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x025a
            java.lang.String r0 = "log"
            r1.put(r0, r2)
        L_0x025a:
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r2 = "tc"
            r1.put(r2, r0)
            java.lang.String r0 = "def"
            java.lang.String r2 = "apls3"
            com.wpengapp.support.StatisticsManager.m733(r0, r2, r1)
            return r14
        L_0x026b:
            r0 = move-exception
            r16 = r10
        L_0x026e:
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r16)
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r12)
            com.wpengapp.support.FileUtils.m1130((java.io.File) r11)
            f3347 = r2
            throw r0
        L_0x027a:
            f3347 = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.ApManager.m3175():boolean");
    }

    /* renamed from: ֏ */
    public static String m3173(BufferedReader bufferedReader) {
        StringBuilder sb = new StringBuilder();
        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            sb.append(readLine);
            sb.append("\n");
            readLine = bufferedReader.readLine();
        }
        return sb.toString();
    }
}
