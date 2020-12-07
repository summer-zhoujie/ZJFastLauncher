package com.wpengapp.support;

import android.os.Handler;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.wpengapp.support.ب */
/* compiled from: AccTaskManager */
public class C0840 {

    /* renamed from: ֏ */
    public static LinkedBlockingQueue<AccTask> f2223 = new LinkedBlockingQueue<>();

    /* renamed from: ؠ */
    public static volatile AccTask f2224;

    /* renamed from: ހ */
    public static final Handler f2225;

    /* renamed from: ށ */
    public static long f2226;

    static {
        C1076 r0 = new C1076("AccTaskManager");
        r0.start();
        f2225 = new Handler(r0.getLooper());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        return;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m2250(com.wpengapp.support.AccTask r4, com.wpengapp.support.TaskCallback r5) {
        /*
            java.lang.Class<com.wpengapp.support.ب> r0 = com.wpengapp.support.C0840.class
            monitor-enter(r0)
            if (r4 == 0) goto L_0x005a
            boolean r1 = r4.f2432     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x000a
            goto L_0x005a
        L_0x000a:
            r4.f2430 = r5     // Catch:{ all -> 0x0057 }
            r5 = 1
            r4.f2432 = r5     // Catch:{ all -> 0x0057 }
            boolean r1 = r4 instanceof com.wpengapp.support.AccTaskGroup     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0045
            com.wpengapp.support.ɢ r4 = (com.wpengapp.support.AccTaskGroup) r4     // Catch:{ all -> 0x0057 }
            java.util.List<com.wpengapp.support.ۇ> r1 = r4.f1243     // Catch:{ all -> 0x0057 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0057 }
        L_0x001b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x0052
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0057 }
            com.wpengapp.support.ۇ r2 = (com.wpengapp.support.AccTask) r2     // Catch:{ all -> 0x0057 }
            r2.f2432 = r5     // Catch:{ all -> 0x0057 }
            java.util.concurrent.LinkedBlockingQueue<com.wpengapp.support.ۇ> r3 = f2223     // Catch:{ all -> 0x0057 }
            boolean r3 = r3.offer(r2)     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x003d
            r4.mo8877()     // Catch:{ all -> 0x0057 }
            java.util.concurrent.LinkedBlockingQueue<com.wpengapp.support.ۇ> r5 = f2223     // Catch:{ all -> 0x0057 }
            java.util.List<com.wpengapp.support.ۇ> r4 = r4.f1243     // Catch:{ all -> 0x0057 }
            r5.removeAll(r4)     // Catch:{ all -> 0x0057 }
            monitor-exit(r0)
            return
        L_0x003d:
            com.wpengapp.support.Ɉ r3 = new com.wpengapp.support.Ɉ     // Catch:{ all -> 0x0057 }
            r3.<init>(r2, r4)     // Catch:{ all -> 0x0057 }
            r2.f2430 = r3     // Catch:{ all -> 0x0057 }
            goto L_0x001b
        L_0x0045:
            java.util.concurrent.LinkedBlockingQueue<com.wpengapp.support.ۇ> r5 = f2223     // Catch:{ all -> 0x0057 }
            boolean r5 = r5.offer(r4)     // Catch:{ all -> 0x0057 }
            if (r5 != 0) goto L_0x0052
            r4.mo8877()     // Catch:{ all -> 0x0057 }
            monitor-exit(r0)
            return
        L_0x0052:
            m2251()     // Catch:{ all -> 0x0057 }
            monitor-exit(r0)
            return
        L_0x0057:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x005a:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0840.m2250(com.wpengapp.support.ۇ, com.wpengapp.support.Ⴢ):void");
    }

    /* renamed from: ؠ */
    public static void m2251() {
        f2225.post(new C0782());
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2249(AccTask r4) {
        if (r4 != null) {
            f2225.postDelayed(new AccTaskManager(r4), 300);
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2248() {
        if (f2224 != null && f2224.mo8878()) {
            StringBuilder r0 = outline.m2549("[Task Run time] ");
            r0.append(System.currentTimeMillis() - f2226);
            r0.append("ms, ");
            r0.append(f2224);
            r0.toString();
            if (!f2224.f2436 && f2224.f2434 != null) {
                f2223.removeAll(f2224.f2434.f1243);
            }
            f2224 = null;
        }
        m2251();
    }
}
