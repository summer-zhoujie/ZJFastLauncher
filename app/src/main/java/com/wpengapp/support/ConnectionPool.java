package com.wpengapp.support;

/* renamed from: com.wpengapp.support.צ */
class ConnectionPool implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C1000 f2161;

    public ConnectionPool(C1000 r1) {
        this.f2161 = r1;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
        L_0x0000:
            com.wpengapp.support.ࡖ r0 = r6.f2161
            long r1 = java.lang.System.nanoTime()
            long r0 = r0.mo9063((long) r1)
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0011
            return
        L_0x0011:
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0000
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r0 / r2
            long r2 = r2 * r4
            long r0 = r0 - r2
            com.wpengapp.support.ࡖ r2 = r6.f2161
            monitor-enter(r2)
            com.wpengapp.support.ࡖ r3 = r6.f2161     // Catch:{ InterruptedException -> 0x002b }
            int r1 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
            r3.wait(r4, r1)     // Catch:{ InterruptedException -> 0x002b }
            goto L_0x002b
        L_0x0029:
            r0 = move-exception
            goto L_0x002d
        L_0x002b:
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            goto L_0x0000
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.ConnectionPool.run():void");
    }
}
