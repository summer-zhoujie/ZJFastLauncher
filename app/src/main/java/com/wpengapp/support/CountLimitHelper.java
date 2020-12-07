package com.wpengapp.support;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.wpengapp.support.ħ */
public class CountLimitHelper {

    /* renamed from: ֏ */
    public static long f786 = System.currentTimeMillis();

    /* renamed from: ؠ */
    public static final ConcurrentHashMap<String, C0464> f787 = new ConcurrentHashMap<>();

    /* renamed from: com.wpengapp.support.ħ$֏ */
    /* compiled from: CountLimitHelper */
    private static class C0464 {

        /* renamed from: ֏ */
        public long f788 = System.currentTimeMillis();

        /* renamed from: ؠ */
        public AtomicInteger f789 = new AtomicInteger(0);

        /* renamed from: ހ */
        public long f790;

        public C0464(long j) {
            this.f790 = j;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r1 >= r3) goto L_0x0042;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m998(String r9, long r10, int r12) {
        /*
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wpengapp.support.ħ$֏> r0 = f787
            java.lang.Object r0 = r0.get(r9)
            com.wpengapp.support.ħ$֏ r0 = (com.wpengapp.support.CountLimitHelper.C0464) r0
            long r1 = java.lang.System.currentTimeMillis()
            if (r0 == 0) goto L_0x001a
            long r3 = r0.f788
            long r5 = r1 - r3
            int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r7 > 0) goto L_0x001a
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0042
        L_0x001a:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wpengapp.support.ħ$֏> r0 = f787
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wpengapp.support.ħ$֏> r3 = f787     // Catch:{ all -> 0x0060 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ all -> 0x0060 }
            com.wpengapp.support.ħ$֏ r3 = (com.wpengapp.support.CountLimitHelper.C0464) r3     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0036
            long r4 = r3.f788     // Catch:{ all -> 0x0060 }
            long r6 = r1 - r4
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 > 0) goto L_0x0036
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r1 = r3
            goto L_0x0040
        L_0x0036:
            com.wpengapp.support.ħ$֏ r1 = new com.wpengapp.support.ħ$֏     // Catch:{ all -> 0x0060 }
            r1.<init>(r10)     // Catch:{ all -> 0x0060 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wpengapp.support.ħ$֏> r10 = f787     // Catch:{ all -> 0x0060 }
            r10.put(r9, r1)     // Catch:{ all -> 0x0060 }
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            r0 = r1
        L_0x0042:
            java.util.concurrent.atomic.AtomicInteger r9 = r0.f789
            int r9 = r9.get()
            r10 = 1
            if (r9 < r12) goto L_0x004f
            m996()
            return r10
        L_0x004f:
            java.util.concurrent.atomic.AtomicInteger r9 = r0.f789
            int r9 = r9.incrementAndGet()
            if (r9 <= r12) goto L_0x005b
            m996()
            return r10
        L_0x005b:
            m996()
            r9 = 0
            return r9
        L_0x0060:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.CountLimitHelper.m998(java.lang.String, long, int):boolean");
    }

    /* renamed from: ֏ */
    public static boolean m997(String str, long j) {
        return m998(str, j, 1);
    }

    /* renamed from: ֏ */
    public static void m996() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = f786;
        if (currentTimeMillis - j >= 300000 || currentTimeMillis < j) {
            synchronized (f787) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (Map.Entry next : f787.entrySet()) {
                    C0464 r6 = (C0464) next.getValue();
                    if (r6 != null) {
                        long j2 = r6.f788;
                        if (currentTimeMillis - j2 < r6.f790 && currentTimeMillis >= j2) {
                        }
                    }
                    arrayList.add(next.getKey());
                }
                for (String remove : arrayList) {
                    f787.remove(remove);
                }
                f786 = currentTimeMillis;
            }
        }
    }
}
