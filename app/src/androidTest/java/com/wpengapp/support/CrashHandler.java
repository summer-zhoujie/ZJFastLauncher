package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ӻ */
public final class CrashHandler implements Runnable {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r1 != false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r1 = new java.util.HashMap();
        r1.put("MainThreadError", "catch");
        com.wpengapp.support.C0975.m2601(java.lang.Thread.currentThread(), r0, true, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r0.getClass().getName().endsWith("RemoteServiceException") != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r1 = false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
        L_0x0000:
            android.os.Looper.loop()     // Catch:{ Exception -> 0x0006, Throwable -> 0x0004 }
            goto L_0x0000
        L_0x0004:
            r0 = move-exception
            throw r0
        L_0x0006:
            r0 = move-exception
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "RemoteServiceException"
            boolean r1 = r1.endsWith(r2)
            r2 = 1
            if (r1 != 0) goto L_0x0021
            boolean r1 = com.wpengapp.support.C1146.m3072()
            if (r1 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r1 = 0
            goto L_0x0022
        L_0x0021:
            r1 = 1
        L_0x0022:
            if (r1 == 0) goto L_0x0038
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r3 = "MainThreadError"
            java.lang.String r4 = "catch"
            r1.put(r3, r4)
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            com.wpengapp.support.C0975.m2601(r3, r0, r2, r1)
            goto L_0x0000
        L_0x0038:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.CrashHandler.run():void");
    }
}
