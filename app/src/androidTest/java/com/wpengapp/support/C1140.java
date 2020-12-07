package com.wpengapp.support;

import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.text.BidiFormatter;
import com.wpengapp.support.HttpUrl;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ବ */
/* compiled from: RealCall */
public final class C1140 implements Call {

    /* renamed from: ֏ */
    public final C0844 f3233;

    /* renamed from: ؠ */
    public final RetryAndFollowUpInterceptor f3234;

    /* renamed from: ހ */
    public final AsyncTimeout f3235 = new RealCall(this);

    /* renamed from: ށ */
    public C1318 f3236;

    /* renamed from: ނ */
    public final Request f3237;

    /* renamed from: ރ */
    public final boolean f3238;

    /* renamed from: ބ */
    public boolean f3239;

    public C1140(C0844 r3, Request r4, boolean z) {
        this.f3233 = r3;
        this.f3237 = r4;
        this.f3238 = z;
        this.f3234 = new RetryAndFollowUpInterceptor(r3, z);
        this.f3235.mo9111((long) r3.f2254, TimeUnit.MILLISECONDS);
    }

    public Object clone() {
        return m3040(this.f3233, this.f3237, this.f3238);
    }

    /* renamed from: ؠ */
    public Response mo9322() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f3233.f2237);
        arrayList.add(this.f3234);
        arrayList.add(new BridgeInterceptor(this.f3233.f2241));
        this.f3233.mo8743();
        arrayList.add(new CacheInterceptor());
        arrayList.add(new ConnectInterceptor(this.f3233));
        if (!this.f3238) {
            arrayList.addAll(this.f3233.f2238);
        }
        arrayList.add(new CallServerInterceptor(this.f3238));
        Request r6 = this.f3237;
        C1318 r8 = this.f3236;
        C0844 r0 = this.f3233;
        Response r02 = new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, r6, this, r8, r0.f2255, r0.f2256, r0.f2257).mo9347(this.f3237);
        if (!this.f3234.f3250) {
            return r02;
        }
        Util.m946((Closeable) r02);
        throw new IOException("Canceled");
    }

    /* renamed from: ހ */
    public boolean mo9323() {
        return this.f3234.f3250;
    }

    /* renamed from: ށ */
    public String mo9324() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo9323() ? "canceled " : BidiFormatter.EMPTY_STRING);
        sb.append(this.f3238 ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        HttpUrl.C1165 r1 = this.f3237.f2364.mo9368("/...");
        r1.mo9377(BidiFormatter.EMPTY_STRING);
        r1.f3317 = HttpUrl.m3118(BidiFormatter.EMPTY_STRING, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        sb.append(r1.mo9376().f3314);
        return sb.toString();
    }

    /* renamed from: ֏ */
    public static C1140 m3040(C0844 r1, Request r2, boolean z) {
        C1140 r0 = new C1140(r1, r2, z);
        r0.f3236 = ((EventListener) r1.f2239).f976;
        return r0;
    }

    /* renamed from: ֏ */
    public Response mo9320() {
        synchronized (this) {
            if (!this.f3239) {
                this.f3239 = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f3234.f3249 = Platform.f1792.mo8436("response.body().close()");
        this.f3235.mo8139();
        this.f3236.mo9601(this);
        try {
            this.f3233.f2233.mo8423(this);
            Response r0 = mo9322();
            if (r0 != null) {
                Dispatcher r1 = this.f3233.f2233;
                r1.mo8424(r1.f1722, this);
                return r0;
            }
            throw new IOException("Canceled");
        } catch (IOException e) {
            IOException r02 = mo9321(e);
            this.f3236.mo9595((Call) this, r02);
            throw r02;
        } catch (Throwable th) {
            Dispatcher r12 = this.f3233.f2233;
            r12.mo8424(r12.f1722, this);
            throw th;
        }
    }

    /* renamed from: com.wpengapp.support.ବ$֏ */
    /* compiled from: RealCall */
    final class C1141 extends NamedRunnable {

        /* renamed from: ؠ */
        public final /* synthetic */ C1140 f3240;

        /* renamed from: ֏ */
        public void mo9325(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                this.f3240.f3236.mo9595((Call) this.f3240, (IOException) interruptedIOException);
                C1140 r3 = this.f3240;
                throw null;
            } catch (Throwable th) {
                Dispatcher r0 = this.f3240.f3233.f2233;
                r0.mo8424(r0.f1721, this);
                throw th;
            }
        }

        /* renamed from: ؠ */
        public String mo9326() {
            return this.f3240.f3237.f2364.f3310;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0051 A[Catch:{ IOException -> 0x0048, Throwable -> 0x0019, all -> 0x002a }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007a A[SYNTHETIC, Splitter:B:29:0x007a] */
        /* renamed from: ֏ */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo8071() {
            /*
                r5 = this;
                com.wpengapp.support.ବ r0 = r5.f3240
                com.wpengapp.support.ȃ r0 = r0.f3235
                r0.mo8139()
                r0 = 1
                r1 = 0
                r2 = 0
                com.wpengapp.support.ବ r3 = r5.f3240     // Catch:{ IOException -> 0x0048, Throwable -> 0x0019 }
                r3.mo9322()     // Catch:{ IOException -> 0x0048, Throwable -> 0x0019 }
                com.wpengapp.support.ବ r2 = r5.f3240     // Catch:{ IOException -> 0x0015 }
                throw r1     // Catch:{ Throwable -> 0x0012 }
            L_0x0012:
                r2 = move-exception
                r3 = 1
                goto L_0x001c
            L_0x0015:
                r2 = move-exception
                r0 = r2
                r2 = 1
                goto L_0x0049
            L_0x0019:
                r3 = move-exception
                r2 = r3
                r3 = 0
            L_0x001c:
                com.wpengapp.support.ବ r4 = r5.f3240     // Catch:{ all -> 0x002a }
                com.wpengapp.support.ସ r4 = r4.f3234     // Catch:{ all -> 0x002a }
                r4.f3250 = r0     // Catch:{ all -> 0x002a }
                com.wpengapp.support.ܥ r0 = r4.f3248     // Catch:{ all -> 0x002a }
                if (r0 == 0) goto L_0x002c
                r0.mo8922()     // Catch:{ all -> 0x002a }
                goto L_0x002c
            L_0x002a:
                r0 = move-exception
                goto L_0x0088
            L_0x002c:
                if (r3 != 0) goto L_0x0047
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x002a }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                r3.<init>()     // Catch:{ all -> 0x002a }
                java.lang.String r4 = "canceled due to "
                r3.append(r4)     // Catch:{ all -> 0x002a }
                r3.append(r2)     // Catch:{ all -> 0x002a }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x002a }
                r0.<init>(r2)     // Catch:{ all -> 0x002a }
                com.wpengapp.support.ବ r0 = r5.f3240     // Catch:{ all -> 0x002a }
                throw r1     // Catch:{ all -> 0x002a }
            L_0x0047:
                throw r2     // Catch:{ all -> 0x002a }
            L_0x0048:
                r0 = move-exception
            L_0x0049:
                com.wpengapp.support.ବ r3 = r5.f3240     // Catch:{ all -> 0x002a }
                java.io.IOException r0 = r3.mo9321((java.io.IOException) r0)     // Catch:{ all -> 0x002a }
                if (r2 == 0) goto L_0x007a
                com.wpengapp.support.Л r1 = com.wpengapp.support.Platform.f1792     // Catch:{ all -> 0x002a }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                r3.<init>()     // Catch:{ all -> 0x002a }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x002a }
                com.wpengapp.support.ବ r4 = r5.f3240     // Catch:{ all -> 0x002a }
                java.lang.String r4 = r4.mo9324()     // Catch:{ all -> 0x002a }
                r3.append(r4)     // Catch:{ all -> 0x002a }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002a }
                r1.mo8437((int) r2, (java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x002a }
                com.wpengapp.support.ବ r0 = r5.f3240
                com.wpengapp.support.ج r0 = r0.f3233
                com.wpengapp.support.ϐ r0 = r0.f2233
                java.util.Deque<com.wpengapp.support.ବ$֏> r1 = r0.f1721
                r0.mo8424(r1, r5)
                return
            L_0x007a:
                com.wpengapp.support.ବ r2 = r5.f3240     // Catch:{ all -> 0x002a }
                com.wpengapp.support.Ⴠ r2 = r2.f3236     // Catch:{ all -> 0x002a }
                com.wpengapp.support.ବ r3 = r5.f3240     // Catch:{ all -> 0x002a }
                r2.mo9595((com.wpengapp.support.Call) r3, (java.io.IOException) r0)     // Catch:{ all -> 0x002a }
                com.wpengapp.support.ବ r0 = r5.f3240     // Catch:{ all -> 0x002a }
                throw r1     // Catch:{ all -> 0x002a }
            L_0x0088:
                com.wpengapp.support.ବ r1 = r5.f3240
                com.wpengapp.support.ج r1 = r1.f3233
                com.wpengapp.support.ϐ r1 = r1.f2233
                java.util.Deque<com.wpengapp.support.ବ$֏> r2 = r1.f1721
                r1.mo8424(r2, r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1140.C1141.mo8071():void");
        }
    }

    /* renamed from: ֏ */
    public IOException mo9321(IOException iOException) {
        if (!this.f3235.mo8140()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }
}
