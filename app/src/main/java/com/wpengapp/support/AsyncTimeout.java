package com.wpengapp.support;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ȃ */
public class AsyncTimeout extends C1166 {

    /* renamed from: ނ */
    public static final long f1026 = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: ރ */
    public static final long f1027 = TimeUnit.MILLISECONDS.toNanos(f1026);

    /* renamed from: ބ */
    public static AsyncTimeout f1028;

    /* renamed from: ޅ */
    public boolean f1029;

    /* renamed from: ކ */
    public AsyncTimeout f1030;

    /* renamed from: އ */
    public long f1031;

    /* renamed from: com.wpengapp.support.ȃ$֏ */
    /* compiled from: AsyncTimeout */
    private static final class C0535 extends Thread {
        public C0535() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.mo7905();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<com.wpengapp.support.ȃ> r0 = com.wpengapp.support.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                com.wpengapp.support.ȃ r1 = com.wpengapp.support.AsyncTimeout.m1292()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                com.wpengapp.support.ȃ r2 = com.wpengapp.support.AsyncTimeout.f1028     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                com.wpengapp.support.AsyncTimeout.f1028 = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.mo7905()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.AsyncTimeout.C0535.run():void");
        }
    }

    /* renamed from: ֏ */
    public static synchronized void m1290(AsyncTimeout r7, long j, boolean z) {
        synchronized (AsyncTimeout.class) {
            if (f1028 == null) {
                f1028 = new AsyncTimeout();
                new C0535().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                r7.f1031 = Math.min(j, r7.mo9212() - nanoTime) + nanoTime;
            } else if (i != 0) {
                r7.f1031 = j + nanoTime;
            } else if (z) {
                r7.f1031 = r7.mo9212();
            } else {
                throw new AssertionError();
            }
            long j2 = r7.f1031 - nanoTime;
            AsyncTimeout r10 = f1028;
            while (true) {
                if (r10.f1030 == null) {
                    break;
                }
                AsyncTimeout r3 = r10.f1030;
                if (j2 < r3.f1031 - nanoTime) {
                    break;
                }
                r10 = r3;
            }
            r7.f1030 = r10.f1030;
            r10.f1030 = r7;
            if (r10 == f1028) {
                AsyncTimeout.class.notify();
            }
        }
    }

    /* renamed from: ރ */
    public static AsyncTimeout m1292() {
        AsyncTimeout r0 = f1028.f1030;
        if (r0 == null) {
            long nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(f1026);
            if (f1028.f1030 != null || System.nanoTime() - nanoTime < f1027) {
                return null;
            }
            return f1028;
        }
        long nanoTime2 = r0.f1031 - System.nanoTime();
        if (nanoTime2 > 0) {
            long j = nanoTime2 / 1000000;
            AsyncTimeout.class.wait(j, (int) (nanoTime2 - (1000000 * j)));
            return null;
        }
        f1028.f1030 = r0.f1030;
        r0.f1030 = null;
        return r0;
    }

    /* renamed from: ބ */
    public final void mo8139() {
        if (!this.f1029) {
            long j = this.f3326;
            boolean z = this.f3324;
            if (j != 0 || z) {
                this.f1029 = true;
                m1290(this, j, z);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* renamed from: ޅ */
    public final boolean mo8140() {
        if (!this.f1029) {
            return false;
        }
        this.f1029 = false;
        return m1291(this);
    }

    /* renamed from: ކ */
    public void mo7905() {
    }

    /* renamed from: ֏ */
    public static synchronized boolean m1291(AsyncTimeout r3) {
        synchronized (AsyncTimeout.class) {
            AsyncTimeout r1 = f1028;
            while (r1 != null) {
                AsyncTimeout r2 = r1.f1030;
                if (r2 == r3) {
                    r1.f1030 = r3.f1030;
                    r3.f1030 = null;
                    return false;
                }
                r1 = r2;
            }
            return true;
        }
    }

    /* renamed from: ֏ */
    public final void mo8138(boolean z) {
        if (mo8140() && z) {
            throw mo8136((IOException) null);
        }
    }

    /* renamed from: ֏ */
    public IOException mo8136(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }
}
