package com.wpengapp.support;

import android.support.p000v4.internal.view.SupportMenu;
import android.support.p003v7.widget.ActivityChooserView;
import com.wpengapp.support.Http2Reader;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ʂ */
/* compiled from: Http2Connection */
public final class C0586 implements Closeable {

    /* renamed from: ֏ */
    public static final ExecutorService f1278 = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.m943("OkHttp Http2Connection", true));

    /* renamed from: ؠ */
    public final boolean f1279;

    /* renamed from: ހ */
    public final C0588 f1280;

    /* renamed from: ށ */
    public final Map<Integer, Http2Stream> f1281 = new LinkedHashMap();

    /* renamed from: ނ */
    public final String f1282;

    /* renamed from: ރ */
    public int f1283;

    /* renamed from: ބ */
    public int f1284;

    /* renamed from: ޅ */
    public boolean f1285;

    /* renamed from: ކ */
    public final ScheduledExecutorService f1286;

    /* renamed from: އ */
    public final ExecutorService f1287;

    /* renamed from: ވ */
    public final PushObserver f1288;

    /* renamed from: މ */
    public boolean f1289;

    /* renamed from: ފ */
    public long f1290 = 0;

    /* renamed from: ދ */
    public long f1291;

    /* renamed from: ތ */
    public Settings f1292 = new Settings();

    /* renamed from: ލ */
    public final Settings f1293 = new Settings();

    /* renamed from: ގ */
    public final Socket f1294;

    /* renamed from: ޏ */
    public final Http2Writer f1295;

    /* renamed from: ސ */
    public final C0590 f1296;

    /* renamed from: ޑ */
    public final Set<Integer> f1297 = new LinkedHashSet();

    /* renamed from: com.wpengapp.support.ʂ$֏ */
    /* compiled from: Http2Connection */
    public static class C0587 {

        /* renamed from: ֏ */
        public Socket f1298;

        /* renamed from: ؠ */
        public String f1299;

        /* renamed from: ހ */
        public BufferedSource f1300;

        /* renamed from: ށ */
        public BufferedSink f1301;

        /* renamed from: ނ */
        public C0588 f1302 = C0588.f1306;

        /* renamed from: ރ */
        public PushObserver f1303 = PushObserver.f1864;

        /* renamed from: ބ */
        public boolean f1304;

        /* renamed from: ޅ */
        public int f1305;

        public C0587(boolean z) {
            this.f1304 = z;
        }
    }

    /* renamed from: com.wpengapp.support.ʂ$ؠ */
    /* compiled from: Http2Connection */
    public static abstract class C0588 {

        /* renamed from: ֏ */
        public static final C0588 f1306 = new C0766();

        /* renamed from: ֏ */
        public abstract void mo8245(Http2Stream r1);

        /* renamed from: ֏ */
        public void mo8246(C0586 r1) {
        }
    }

    /* renamed from: com.wpengapp.support.ʂ$ހ */
    /* compiled from: Http2Connection */
    final class C0589 extends NamedRunnable {

        /* renamed from: ؠ */
        public final boolean f1307;

        /* renamed from: ހ */
        public final int f1308;

        /* renamed from: ށ */
        public final int f1309;

        public C0589(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", C0586.this.f1282, Integer.valueOf(i), Integer.valueOf(i2));
            this.f1307 = z;
            this.f1308 = i;
            this.f1309 = i2;
        }

        /* renamed from: ֏ */
        public void mo8071() {
            C0586.this.mo8236(this.f1307, this.f1308, this.f1309);
        }
    }

    public C0586(C0587 r24) {
        C0587 r1 = r24;
        this.f1288 = r1.f1303;
        boolean z = r1.f1304;
        this.f1279 = z;
        this.f1280 = r1.f1302;
        this.f1284 = z ? 1 : 2;
        if (r1.f1304) {
            this.f1284 += 2;
        }
        if (r1.f1304) {
            this.f1292.mo9621(7, 16777216);
        }
        this.f1282 = r1.f1299;
        this.f1286 = new ScheduledThreadPoolExecutor(1, Util.m943(Util.m937("OkHttp %s Writer", this.f1282), false));
        if (r1.f1305 != 0) {
            ScheduledExecutorService scheduledExecutorService = this.f1286;
            C0589 r9 = new C0589(false, 0, 0);
            int i = r1.f1305;
            scheduledExecutorService.scheduleAtFixedRate(r9, (long) i, (long) i, TimeUnit.MILLISECONDS);
        }
        this.f1287 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.m943(Util.m937("OkHttp %s Push Observer", this.f1282), true));
        this.f1293.mo9621(7, SupportMenu.USER_MASK);
        this.f1293.mo9621(5, 16384);
        this.f1291 = (long) this.f1293.mo9620();
        this.f1294 = r1.f1298;
        this.f1295 = new Http2Writer(r1.f1301, this.f1279);
        this.f1296 = new C0590(new Http2Reader(r1.f1300, this.f1279));
    }

    public void close() {
        mo8235(C1193.NO_ERROR, C1193.CANCEL);
    }

    /* renamed from: ؠ */
    public boolean mo8239(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* renamed from: ހ */
    public synchronized Http2Stream mo8240(int i) {
        Http2Stream remove;
        remove = this.f1281.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    /* renamed from: ރ */
    public synchronized void mo8241(long j) {
        this.f1290 += j;
        if (this.f1290 >= ((long) (this.f1292.mo9620() / 2))) {
            mo8228(0, this.f1290);
            this.f1290 = 0;
        }
    }

    /* renamed from: އ */
    public final void mo8242() {
        try {
            mo8235(C1193.PROTOCOL_ERROR, C1193.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    /* renamed from: ވ */
    public synchronized boolean mo8243() {
        return this.f1285;
    }

    /* renamed from: މ */
    public synchronized int mo8244() {
        int i;
        Settings r0 = this.f1293;
        i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        if ((r0.f3799 & 16) != 0) {
            i = r0.f3800[4];
        }
        return i;
    }

    /* renamed from: ؠ */
    public void mo8237(int i, C1193 r10) {
        try {
            this.f1286.execute(new C0752(this, "OkHttp %s stream %d", new Object[]{this.f1282, Integer.valueOf(i)}, i, r10));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: ֏ */
    public synchronized Http2Stream mo8226(int i) {
        return this.f1281.get(Integer.valueOf(i));
    }

    /* renamed from: ؠ */
    public void mo8238(int i, List<Header> list, boolean z) {
        try {
            mo8233((NamedRunnable) new C0740(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f1282, Integer.valueOf(i)}, i, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.wpengapp.support.Http2Stream mo8227(int r11, List<com.wpengapp.support.Header> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            com.wpengapp.support.แ r7 = r10.f1295
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0078 }
            int r0 = r10.f1284     // Catch:{ all -> 0x0075 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            com.wpengapp.support.ภ r0 = com.wpengapp.support.C1193.REFUSED_STREAM     // Catch:{ all -> 0x0075 }
            r10.mo8234((com.wpengapp.support.C1193) r0)     // Catch:{ all -> 0x0075 }
        L_0x0013:
            boolean r0 = r10.f1285     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x006f
            int r8 = r10.f1284     // Catch:{ all -> 0x0075 }
            int r0 = r10.f1284     // Catch:{ all -> 0x0075 }
            int r0 = r0 + 2
            r10.f1284 = r0     // Catch:{ all -> 0x0075 }
            com.wpengapp.support.ȁ r9 = new com.wpengapp.support.ȁ     // Catch:{ all -> 0x0075 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0075 }
            if (r13 == 0) goto L_0x003c
            long r0 = r10.f1291     // Catch:{ all -> 0x0075 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003c
            long r0 = r9.f1005     // Catch:{ all -> 0x0075 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r13 = 0
            goto L_0x003d
        L_0x003c:
            r13 = 1
        L_0x003d:
            boolean r0 = r9.mo8129()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x004c
            java.util.Map<java.lang.Integer, com.wpengapp.support.ȁ> r0 = r10.f1281     // Catch:{ all -> 0x0075 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0075 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0075 }
        L_0x004c:
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            if (r11 != 0) goto L_0x0055
            com.wpengapp.support.แ r0 = r10.f1295     // Catch:{ all -> 0x0078 }
            r0.mo9454((boolean) r6, (int) r8, (int) r11, (java.util.List<com.wpengapp.support.Header>) r12)     // Catch:{ all -> 0x0078 }
            goto L_0x005e
        L_0x0055:
            boolean r0 = r10.f1279     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0067
            com.wpengapp.support.แ r0 = r10.f1295     // Catch:{ all -> 0x0078 }
            r0.mo9448((int) r11, (int) r8, (java.util.List<com.wpengapp.support.Header>) r12)     // Catch:{ all -> 0x0078 }
        L_0x005e:
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x0066
            com.wpengapp.support.แ r11 = r10.f1295
            r11.flush()
        L_0x0066:
            return r9
        L_0x0067:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0078 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0078 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x006f:
            com.wpengapp.support.ɞ r11 = new com.wpengapp.support.ɞ     // Catch:{ all -> 0x0075 }
            r11.<init>()     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0586.mo8227(int, java.util.List, boolean):com.wpengapp.support.ȁ");
    }

    /* renamed from: com.wpengapp.support.ʂ$ށ */
    /* compiled from: Http2Connection */
    class C0590 extends NamedRunnable implements Http2Reader.C1047 {

        /* renamed from: ؠ */
        public final Http2Reader f1311;

        public C0590(Http2Reader r4) {
            super("OkHttp %s", C0586.this.f1282);
            this.f1311 = r4;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1 = com.wpengapp.support.C1193.f3395;
            r0 = com.wpengapp.support.C1193.f3395;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r2 = r4.f1312;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x002b, code lost:
            r2 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001c */
        /* renamed from: ֏ */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo8071() {
            /*
                r4 = this;
                com.wpengapp.support.ภ r0 = com.wpengapp.support.C1193.INTERNAL_ERROR
                com.wpengapp.support.এ r1 = r4.f1311     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                r1.mo9206((com.wpengapp.support.Http2Reader.C1047) r4)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            L_0x0007:
                com.wpengapp.support.এ r1 = r4.f1311     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                r2 = 0
                boolean r1 = r1.mo9208((boolean) r2, (com.wpengapp.support.Http2Reader.C1047) r4)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                com.wpengapp.support.ภ r1 = com.wpengapp.support.C1193.NO_ERROR     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                com.wpengapp.support.ภ r0 = com.wpengapp.support.C1193.CANCEL     // Catch:{ IOException -> 0x001c }
                com.wpengapp.support.ʂ r2 = com.wpengapp.support.C0586.this     // Catch:{ IOException -> 0x0025 }
                goto L_0x0022
            L_0x0018:
                r2 = move-exception
                r1 = r0
                goto L_0x002c
            L_0x001b:
                r1 = r0
            L_0x001c:
                com.wpengapp.support.ภ r1 = com.wpengapp.support.C1193.PROTOCOL_ERROR     // Catch:{ all -> 0x002b }
                com.wpengapp.support.ภ r0 = com.wpengapp.support.C1193.PROTOCOL_ERROR     // Catch:{ all -> 0x002b }
                com.wpengapp.support.ʂ r2 = com.wpengapp.support.C0586.this     // Catch:{ IOException -> 0x0025 }
            L_0x0022:
                r2.mo8235((com.wpengapp.support.C1193) r1, (com.wpengapp.support.C1193) r0)     // Catch:{ IOException -> 0x0025 }
            L_0x0025:
                com.wpengapp.support.এ r0 = r4.f1311
                com.wpengapp.support.Util.m946((java.io.Closeable) r0)
                return
            L_0x002b:
                r2 = move-exception
            L_0x002c:
                com.wpengapp.support.ʂ r3 = com.wpengapp.support.C0586.this     // Catch:{ IOException -> 0x0031 }
                r3.mo8235((com.wpengapp.support.C1193) r1, (com.wpengapp.support.C1193) r0)     // Catch:{ IOException -> 0x0031 }
            L_0x0031:
                com.wpengapp.support.এ r0 = r4.f1311
                com.wpengapp.support.Util.m946((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0586.C0590.mo8071():void");
        }

        /* renamed from: ֏ */
        public void mo8247(int i, int i2, int i3, boolean z) {
        }

        /* renamed from: ؠ */
        public void mo8253() {
        }

        /* renamed from: ؠ */
        public void mo8254(boolean z, Settings r10) {
            try {
                C0586.this.f1286.execute(new C0658(this, "OkHttp %s ACK Settings", new Object[]{C0586.this.f1282}, z, r10));
            } catch (RejectedExecutionException unused) {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
            r0.mo8122(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0079, code lost:
            r0.mo8130();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* renamed from: ֏ */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo8251(boolean r10, int r11, int r12, List<com.wpengapp.support.Header> r13) {
            /*
                r9 = this;
                com.wpengapp.support.ʂ r12 = com.wpengapp.support.C0586.this
                boolean r12 = r12.mo8239((int) r11)
                if (r12 == 0) goto L_0x000e
                com.wpengapp.support.ʂ r12 = com.wpengapp.support.C0586.this
                r12.mo8238(r11, r13, r10)
                return
            L_0x000e:
                com.wpengapp.support.ʂ r12 = com.wpengapp.support.C0586.this
                monitor-enter(r12)
                com.wpengapp.support.ʂ r0 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x0071 }
                com.wpengapp.support.ȁ r0 = r0.mo8226((int) r11)     // Catch:{ all -> 0x0071 }
                if (r0 != 0) goto L_0x0073
                com.wpengapp.support.ʂ r0 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x0071 }
                boolean r0 = r0.f1285     // Catch:{ all -> 0x0071 }
                if (r0 == 0) goto L_0x0021
                monitor-exit(r12)     // Catch:{ all -> 0x0071 }
                return
            L_0x0021:
                com.wpengapp.support.ʂ r0 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x0071 }
                int r0 = r0.f1283     // Catch:{ all -> 0x0071 }
                if (r11 > r0) goto L_0x0029
                monitor-exit(r12)     // Catch:{ all -> 0x0071 }
                return
            L_0x0029:
                int r0 = r11 % 2
                com.wpengapp.support.ʂ r1 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x0071 }
                int r1 = r1.f1284     // Catch:{ all -> 0x0071 }
                r2 = 2
                int r1 = r1 % r2
                if (r0 != r1) goto L_0x0035
                monitor-exit(r12)     // Catch:{ all -> 0x0071 }
                return
            L_0x0035:
                com.wpengapp.support.Ʌ r8 = com.wpengapp.support.Util.m955((java.util.List<com.wpengapp.support.Header>) r13)     // Catch:{ all -> 0x0071 }
                com.wpengapp.support.ȁ r13 = new com.wpengapp.support.ȁ     // Catch:{ all -> 0x0071 }
                com.wpengapp.support.ʂ r5 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x0071 }
                r6 = 0
                r3 = r13
                r4 = r11
                r7 = r10
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0071 }
                com.wpengapp.support.ʂ r10 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x0071 }
                r10.f1283 = r11     // Catch:{ all -> 0x0071 }
                com.wpengapp.support.ʂ r10 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x0071 }
                java.util.Map<java.lang.Integer, com.wpengapp.support.ȁ> r10 = r10.f1281     // Catch:{ all -> 0x0071 }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0071 }
                r10.put(r0, r13)     // Catch:{ all -> 0x0071 }
                java.util.concurrent.ExecutorService r10 = com.wpengapp.support.C0586.f1278     // Catch:{ all -> 0x0071 }
                com.wpengapp.support.ଡ r0 = new com.wpengapp.support.ଡ     // Catch:{ all -> 0x0071 }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0071 }
                r3 = 0
                com.wpengapp.support.ʂ r4 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x0071 }
                java.lang.String r4 = r4.f1282     // Catch:{ all -> 0x0071 }
                r2[r3] = r4     // Catch:{ all -> 0x0071 }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0071 }
                r2[r3] = r11     // Catch:{ all -> 0x0071 }
                r0.<init>(r9, r1, r2, r13)     // Catch:{ all -> 0x0071 }
                r10.execute(r0)     // Catch:{ all -> 0x0071 }
                monitor-exit(r12)     // Catch:{ all -> 0x0071 }
                return
            L_0x0071:
                r10 = move-exception
                goto L_0x007d
            L_0x0073:
                monitor-exit(r12)     // Catch:{ all -> 0x0071 }
                r0.mo8122((java.util.List<com.wpengapp.support.Header>) r13)
                if (r10 == 0) goto L_0x007c
                r0.mo8130()
            L_0x007c:
                return
            L_0x007d:
                monitor-exit(r12)     // Catch:{ all -> 0x0071 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0586.C0590.mo8251(boolean, int, int, java.util.List):void");
        }

        /* JADX WARNING: type inference failed for: r2v12, types: [java.lang.Object[]] */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|7|17|18|19|20|21) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0069 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: ֏ */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo8252(boolean r10, com.wpengapp.support.Settings r11) {
            /*
                r9 = this;
                com.wpengapp.support.ʂ r0 = com.wpengapp.support.C0586.this
                com.wpengapp.support.แ r0 = r0.f1295
                monitor-enter(r0)
                com.wpengapp.support.ʂ r1 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x00a4 }
                monitor-enter(r1)     // Catch:{ all -> 0x00a4 }
                com.wpengapp.support.ʂ r2 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x00a1 }
                com.wpengapp.support.შ r2 = r2.f1293     // Catch:{ all -> 0x00a1 }
                int r2 = r2.mo9620()     // Catch:{ all -> 0x00a1 }
                r3 = 0
                if (r10 == 0) goto L_0x001e
                com.wpengapp.support.ʂ r10 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x00a1 }
                com.wpengapp.support.შ r10 = r10.f1293     // Catch:{ all -> 0x00a1 }
                r10.f3799 = r3     // Catch:{ all -> 0x00a1 }
                int[] r10 = r10.f3800     // Catch:{ all -> 0x00a1 }
                java.util.Arrays.fill(r10, r3)     // Catch:{ all -> 0x00a1 }
            L_0x001e:
                com.wpengapp.support.ʂ r10 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x00a1 }
                com.wpengapp.support.შ r10 = r10.f1293     // Catch:{ all -> 0x00a1 }
                r10.mo9622(r11)     // Catch:{ all -> 0x00a1 }
                com.wpengapp.support.ʂ r10 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x00a1 }
                com.wpengapp.support.შ r10 = r10.f1293     // Catch:{ all -> 0x00a1 }
                int r10 = r10.mo9620()     // Catch:{ all -> 0x00a1 }
                r11 = -1
                r4 = 0
                r5 = 0
                if (r10 == r11) goto L_0x005b
                if (r10 == r2) goto L_0x005b
                int r10 = r10 - r2
                long r10 = (long) r10     // Catch:{ all -> 0x00a1 }
                com.wpengapp.support.ʂ r2 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x00a1 }
                java.util.Map<java.lang.Integer, com.wpengapp.support.ȁ> r2 = r2.f1281     // Catch:{ all -> 0x00a1 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00a1 }
                if (r2 != 0) goto L_0x005c
                com.wpengapp.support.ʂ r2 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x00a1 }
                java.util.Map<java.lang.Integer, com.wpengapp.support.ȁ> r2 = r2.f1281     // Catch:{ all -> 0x00a1 }
                java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x00a1 }
                com.wpengapp.support.ʂ r4 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x00a1 }
                java.util.Map<java.lang.Integer, com.wpengapp.support.ȁ> r4 = r4.f1281     // Catch:{ all -> 0x00a1 }
                int r4 = r4.size()     // Catch:{ all -> 0x00a1 }
                com.wpengapp.support.ȁ[] r4 = new com.wpengapp.support.Http2Stream[r4]     // Catch:{ all -> 0x00a1 }
                java.lang.Object[] r2 = r2.toArray(r4)     // Catch:{ all -> 0x00a1 }
                r4 = r2
                com.wpengapp.support.ȁ[] r4 = (com.wpengapp.support.Http2Stream[]) r4     // Catch:{ all -> 0x00a1 }
                goto L_0x005c
            L_0x005b:
                r10 = r5
            L_0x005c:
                monitor-exit(r1)     // Catch:{ all -> 0x00a1 }
                com.wpengapp.support.ʂ r1 = com.wpengapp.support.C0586.this     // Catch:{ IOException -> 0x0069 }
                com.wpengapp.support.แ r1 = r1.f1295     // Catch:{ IOException -> 0x0069 }
                com.wpengapp.support.ʂ r2 = com.wpengapp.support.C0586.this     // Catch:{ IOException -> 0x0069 }
                com.wpengapp.support.შ r2 = r2.f1293     // Catch:{ IOException -> 0x0069 }
                r1.mo9452(r2)     // Catch:{ IOException -> 0x0069 }
                goto L_0x006e
            L_0x0069:
                com.wpengapp.support.ʂ r1 = com.wpengapp.support.C0586.this     // Catch:{ all -> 0x00a4 }
                r1.mo8242()     // Catch:{ all -> 0x00a4 }
            L_0x006e:
                monitor-exit(r0)     // Catch:{ all -> 0x00a4 }
                if (r4 == 0) goto L_0x008b
                int r0 = r4.length
                r1 = 0
            L_0x0073:
                if (r1 >= r0) goto L_0x008b
                r2 = r4[r1]
                monitor-enter(r2)
                long r7 = r2.f1005     // Catch:{ all -> 0x0088 }
                long r7 = r7 + r10
                r2.f1005 = r7     // Catch:{ all -> 0x0088 }
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 <= 0) goto L_0x0084
                r2.notifyAll()     // Catch:{ all -> 0x0088 }
            L_0x0084:
                monitor-exit(r2)     // Catch:{ all -> 0x0088 }
                int r1 = r1 + 1
                goto L_0x0073
            L_0x0088:
                r10 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0088 }
                throw r10
            L_0x008b:
                java.util.concurrent.ExecutorService r10 = com.wpengapp.support.C0586.f1278
                com.wpengapp.support.Ʃ r11 = new com.wpengapp.support.Ʃ
                r0 = 1
                java.lang.Object[] r0 = new java.lang.Object[r0]
                com.wpengapp.support.ʂ r1 = com.wpengapp.support.C0586.this
                java.lang.String r1 = r1.f1282
                r0[r3] = r1
                java.lang.String r1 = "OkHttp %s settings"
                r11.<init>(r9, r1, r0)
                r10.execute(r11)
                return
            L_0x00a1:
                r10 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00a1 }
                throw r10     // Catch:{ all -> 0x00a4 }
            L_0x00a4:
                r10 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00a4 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0586.C0590.mo8252(boolean, com.wpengapp.support.შ):void");
        }

        /* renamed from: ֏ */
        public void mo8250(boolean z, int i, int i2) {
            if (z) {
                synchronized (C0586.this) {
                    boolean unused = C0586.this.f1289 = false;
                    C0586.this.notifyAll();
                }
                return;
            }
            try {
                C0586.this.f1286.execute(new C0589(true, i, i2));
            } catch (RejectedExecutionException unused2) {
            }
        }

        /* renamed from: ֏ */
        public void mo8249(int i, C1193 r5, ByteString r6) {
            Http2Stream[] r62;
            r6.mo8002();
            synchronized (C0586.this) {
                r62 = (Http2Stream[]) C0586.this.f1281.values().toArray(new Http2Stream[C0586.this.f1281.size()]);
                C0586.this.f1285 = true;
            }
            for (Http2Stream r1 : r62) {
                if (r1.f1006 > i && r1.mo8128()) {
                    r1.mo8127(C1193.REFUSED_STREAM);
                    C0586.this.mo8240(r1.f1006);
                }
            }
        }

        /* renamed from: ֏ */
        public void mo8248(int i, long j) {
            if (i == 0) {
                synchronized (C0586.this) {
                    C0586.this.f1291 += j;
                    C0586.this.notifyAll();
                }
                return;
            }
            Http2Stream r4 = C0586.this.mo8226(i);
            if (r4 != null) {
                synchronized (r4) {
                    r4.f1005 += j;
                    if (j > 0) {
                        r4.notifyAll();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.f1291), r8.f1295.f3453);
        r6 = (long) r3;
        r8.f1291 -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0058 */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8232(int r9, boolean r10, com.wpengapp.support.Buffer r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            com.wpengapp.support.แ r12 = r8.f1295
            r12.mo9455((boolean) r10, (int) r9, (com.wpengapp.support.Buffer) r11, (int) r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0067
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f1291     // Catch:{ InterruptedException -> 0x0058 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, com.wpengapp.support.ȁ> r3 = r8.f1281     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0030:
            long r3 = r8.f1291     // Catch:{ all -> 0x0056 }
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0056 }
            int r4 = (int) r3     // Catch:{ all -> 0x0056 }
            com.wpengapp.support.แ r3 = r8.f1295     // Catch:{ all -> 0x0056 }
            int r3 = r3.f3453     // Catch:{ all -> 0x0056 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0056 }
            long r4 = r8.f1291     // Catch:{ all -> 0x0056 }
            long r6 = (long) r3     // Catch:{ all -> 0x0056 }
            long r4 = r4 - r6
            r8.f1291 = r4     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            long r12 = r12 - r6
            com.wpengapp.support.แ r4 = r8.f1295
            if (r10 == 0) goto L_0x0051
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0051
            r5 = 1
            goto L_0x0052
        L_0x0051:
            r5 = 0
        L_0x0052:
            r4.mo9455((boolean) r5, (int) r9, (com.wpengapp.support.Buffer) r11, (int) r3)
            goto L_0x000d
        L_0x0056:
            r9 = move-exception
            goto L_0x0065
        L_0x0058:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0056 }
            r9.interrupt()     // Catch:{ all -> 0x0056 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x0065:
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            throw r9
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0586.mo8232(int, boolean, com.wpengapp.support.উ, long):void");
    }

    /* renamed from: ֏ */
    public void mo8228(int i, long j) {
        try {
            this.f1286.execute(new C0746(this, "OkHttp Window Update %s stream %d", new Object[]{this.f1282, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: ֏ */
    public void mo8236(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f1289;
                this.f1289 = true;
            }
            if (z2) {
                mo8242();
                return;
            }
        }
        try {
            this.f1295.mo9453(z, i, i2);
        } catch (IOException unused) {
            mo8242();
        }
    }

    /* renamed from: ֏ */
    public void mo8234(C1193 r5) {
        synchronized (this.f1295) {
            synchronized (this) {
                if (!this.f1285) {
                    this.f1285 = true;
                    int i = this.f1283;
                    this.f1295.mo9451(i, r5, Util.f729);
                }
            }
        }
    }

    /* renamed from: ֏ */
    public void mo8235(C1193 r5, C1193 r6) {
        Http2Stream[] r0 = null;
        try {
            mo8234(r5);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.f1281.isEmpty()) {
                r0 = (Http2Stream[]) this.f1281.values().toArray(new Http2Stream[this.f1281.size()]);
                this.f1281.clear();
            }
        }
        if (r0 != null) {
            for (Http2Stream r3 : r0) {
                try {
                    r3.mo8121(r6);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.f1295.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.f1294.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.f1286.shutdown();
        this.f1287.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* renamed from: ֏ */
    public void mo8231(int i, List<Header> list) {
        synchronized (this) {
            if (this.f1297.contains(Integer.valueOf(i))) {
                mo8237(i, C1193.PROTOCOL_ERROR);
                return;
            }
            this.f1297.add(Integer.valueOf(i));
            try {
                mo8233((NamedRunnable) new C0910(this, "OkHttp %s Push Request[%s]", new Object[]{this.f1282, Integer.valueOf(i)}, i, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* renamed from: ֏ */
    public void mo8229(int i, BufferedSource r10, int i2, boolean z) {
        Buffer r5 = new Buffer();
        long j = (long) i2;
        r10.mo8496(j);
        r10.mo8055(r5, j);
        if (r5.f2997 == j) {
            mo8233((NamedRunnable) new C0927(this, "OkHttp %s Push Data[%s]", new Object[]{this.f1282, Integer.valueOf(i)}, i, r5, i2, z));
            return;
        }
        throw new IOException(r5.f2997 + " != " + i2);
    }

    /* renamed from: ֏ */
    public void mo8230(int i, C1193 r9) {
        mo8233((NamedRunnable) new C1168(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f1282, Integer.valueOf(i)}, i, r9));
    }

    /* renamed from: ֏ */
    public final synchronized void mo8233(NamedRunnable r2) {
        if (!mo8243()) {
            this.f1287.execute(r2);
        }
    }
}
