package com.wpengapp.support;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* renamed from: com.wpengapp.support.ȁ */
public final class Http2Stream {

    /* renamed from: ֏ */
    public long f1004 = 0;

    /* renamed from: ؠ */
    public long f1005;

    /* renamed from: ހ */
    public final int f1006;

    /* renamed from: ށ */
    public final C0586 f1007;

    /* renamed from: ނ */
    public final Deque<Headers> f1008 = new ArrayDeque();

    /* renamed from: ރ */
    public boolean f1009;

    /* renamed from: ބ */
    public final C0533 f1010;

    /* renamed from: ޅ */
    public final C0532 f1011;

    /* renamed from: ކ */
    public final C0534 f1012 = new C0534();

    /* renamed from: އ */
    public final C0534 f1013 = new C0534();

    /* renamed from: ވ */
    public C1193 f1014 = null;

    /* renamed from: com.wpengapp.support.ȁ$ހ */
    /* compiled from: Http2Stream */
    class C0534 extends AsyncTimeout {
        public C0534() {
        }

        /* renamed from: ֏ */
        public IOException mo8136(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: ކ */
        public void mo7905() {
            Http2Stream.this.mo8126(C1193.CANCEL);
        }

        /* renamed from: އ */
        public void mo8137() {
            if (mo8140()) {
                throw new SocketTimeoutException("timeout");
            }
        }
    }

    public Http2Stream(int i, C0586 r4, boolean z, boolean z2, Headers r7) {
        if (r4 != null) {
            this.f1006 = i;
            this.f1007 = r4;
            this.f1005 = (long) r4.f1293.mo9620();
            this.f1010 = new C0533((long) r4.f1292.mo9620());
            this.f1011 = new C0532();
            this.f1010.f1023 = z2;
            this.f1011.f1017 = z;
            if (r7 != null) {
                this.f1008.add(r7);
            }
            if (mo8128() && r7 != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!mo8128() && r7 == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    /* renamed from: ֏ */
    public void mo8121(C1193 r3) {
        if (mo8124(r3)) {
            C0586 r0 = this.f1007;
            r0.f1295.mo9450(this.f1006, r3);
        }
    }

    /* renamed from: ؠ */
    public final boolean mo8124(C1193 r3) {
        synchronized (this) {
            if (this.f1014 != null) {
                return false;
            }
            if (this.f1010.f1023 && this.f1011.f1017) {
                return false;
            }
            this.f1014 = r3;
            notifyAll();
            this.f1007.mo8240(this.f1006);
            return true;
        }
    }

    /* renamed from: ހ */
    public Sink mo8125() {
        synchronized (this) {
            if (!this.f1009) {
                if (!mo8128()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f1011;
    }

    /* renamed from: ށ */
    public boolean mo8128() {
        if (this.f1007.f1279 == ((this.f1006 & 1) == 1)) {
            return true;
        }
        return false;
    }

    /* renamed from: ނ */
    public synchronized boolean mo8129() {
        if (this.f1014 != null) {
            return false;
        }
        if ((this.f1010.f1023 || this.f1010.f1022) && ((this.f1011.f1017 || this.f1011.f1016) && this.f1009)) {
            return false;
        }
        return true;
    }

    /* renamed from: ރ */
    public void mo8130() {
        boolean r0;
        synchronized (this) {
            this.f1010.f1023 = true;
            r0 = mo8129();
            notifyAll();
        }
        if (!r0) {
            this.f1007.mo8240(this.f1006);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r2.f1012.mo8137();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: ބ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized Headers mo8131() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.wpengapp.support.ȁ$ހ r0 = r2.f1012     // Catch:{ all -> 0x003c }
            r0.mo8139()     // Catch:{ all -> 0x003c }
        L_0x0006:
            java.util.Deque<com.wpengapp.support.Ʌ> r0 = r2.f1008     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0016
            com.wpengapp.support.ภ r0 = r2.f1014     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0016
            r2.mo8132()     // Catch:{ all -> 0x0035 }
            goto L_0x0006
        L_0x0016:
            com.wpengapp.support.ȁ$ހ r0 = r2.f1012     // Catch:{ all -> 0x003c }
            r0.mo8137()     // Catch:{ all -> 0x003c }
            java.util.Deque<com.wpengapp.support.Ʌ> r0 = r2.f1008     // Catch:{ all -> 0x003c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x002d
            java.util.Deque<com.wpengapp.support.Ʌ> r0 = r2.f1008     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x003c }
            com.wpengapp.support.Ʌ r0 = (com.wpengapp.support.Headers) r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)
            return r0
        L_0x002d:
            com.wpengapp.support.Ѱ r0 = new com.wpengapp.support.Ѱ     // Catch:{ all -> 0x003c }
            com.wpengapp.support.ภ r1 = r2.f1014     // Catch:{ all -> 0x003c }
            r0.<init>(r1)     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x0035:
            r0 = move-exception
            com.wpengapp.support.ȁ$ހ r1 = r2.f1012     // Catch:{ all -> 0x003c }
            r1.mo8137()     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Http2Stream.mo8131():com.wpengapp.support.Ʌ");
    }

    /* renamed from: ޅ */
    public void mo8132() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* renamed from: ށ */
    public synchronized void mo8127(C1193 r2) {
        if (this.f1014 == null) {
            this.f1014 = r2;
            notifyAll();
        }
    }

    /* renamed from: com.wpengapp.support.ȁ$֏ */
    /* compiled from: Http2Stream */
    final class C0532 implements Sink {

        /* renamed from: ֏ */
        public final Buffer f1015 = new Buffer();

        /* renamed from: ؠ */
        public boolean f1016;

        /* renamed from: ހ */
        public boolean f1017;

        public C0532() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            if (r13.f1015.f2997 <= 0) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            if (r13.f1015.f2997 <= 0) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            mo8133(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            r0.f1007.mo8232(r0.f1006, true, (com.wpengapp.support.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
            r1 = r13.f1018;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r13.f1016 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
            r13.f1018.f1007.f1295.flush();
            r13.f1018.mo8120();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
            r0 = r13.f1018;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r0.f1011.f1017 != false) goto L_0x0034;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r13 = this;
                com.wpengapp.support.ȁ r0 = com.wpengapp.support.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r13.f1016     // Catch:{ all -> 0x004c }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x004c }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x004c }
                com.wpengapp.support.ȁ r0 = com.wpengapp.support.Http2Stream.this
                com.wpengapp.support.ȁ$֏ r1 = r0.f1011
                boolean r1 = r1.f1017
                r2 = 1
                if (r1 != 0) goto L_0x0034
                com.wpengapp.support.উ r1 = r13.f1015
                long r3 = r1.f2997
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 <= 0) goto L_0x0029
            L_0x001d:
                com.wpengapp.support.উ r0 = r13.f1015
                long r0 = r0.f2997
                int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r3 <= 0) goto L_0x0034
                r13.mo8133(r2)
                goto L_0x001d
            L_0x0029:
                com.wpengapp.support.ʂ r7 = r0.f1007
                int r8 = r0.f1006
                r9 = 1
                r10 = 0
                r11 = 0
                r7.mo8232((int) r8, (boolean) r9, (com.wpengapp.support.Buffer) r10, (long) r11)
            L_0x0034:
                com.wpengapp.support.ȁ r1 = com.wpengapp.support.Http2Stream.this
                monitor-enter(r1)
                r13.f1016 = r2     // Catch:{ all -> 0x0049 }
                monitor-exit(r1)     // Catch:{ all -> 0x0049 }
                com.wpengapp.support.ȁ r0 = com.wpengapp.support.Http2Stream.this
                com.wpengapp.support.ʂ r0 = r0.f1007
                com.wpengapp.support.แ r0 = r0.f1295
                r0.flush()
                com.wpengapp.support.ȁ r0 = com.wpengapp.support.Http2Stream.this
                r0.mo8120()
                return
            L_0x0049:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0049 }
                throw r0
            L_0x004c:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004c }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Http2Stream.C0532.close():void");
        }

        public void flush() {
            synchronized (Http2Stream.this) {
                Http2Stream.this.mo8123();
            }
            while (this.f1015.f2997 > 0) {
                mo8133(false);
                Http2Stream.this.f1007.f1295.flush();
            }
        }

        /* renamed from: ֏ */
        public void mo7985(Buffer r3, long j) {
            this.f1015.mo7985(r3, j);
            while (this.f1015.f2997 >= 16384) {
                mo8133(false);
            }
        }

        /* renamed from: ؠ */
        public C1166 mo7986() {
            return Http2Stream.this.f1013;
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: ֏ */
        public final void mo8133(boolean z) {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.f1013.mo8139();
                while (Http2Stream.this.f1005 <= 0 && !this.f1017 && !this.f1016 && Http2Stream.this.f1014 == null) {
                    try {
                        Http2Stream.this.mo8132();
                    } catch (Throwable th) {
                        Http2Stream.this.f1013.mo8137();
                        throw th;
                    }
                }
                Http2Stream.this.f1013.mo8137();
                Http2Stream.this.mo8123();
                min = Math.min(Http2Stream.this.f1005, this.f1015.f2997);
                Http2Stream.this.f1005 -= min;
            }
            Http2Stream.this.f1013.mo8139();
            try {
                Http2Stream.this.f1007.mo8232(Http2Stream.this.f1006, z && min == this.f1015.f2997, this.f1015, min);
            } finally {
                Http2Stream.this.f1013.mo8137();
            }
        }
    }

    /* renamed from: ֏ */
    public void mo8122(List<Header> list) {
        boolean r2;
        synchronized (this) {
            this.f1009 = true;
            this.f1008.add(Util.m955(list));
            r2 = mo8129();
            notifyAll();
        }
        if (!r2) {
            this.f1007.mo8240(this.f1006);
        }
    }

    /* renamed from: ހ */
    public void mo8126(C1193 r3) {
        if (mo8124(r3)) {
            this.f1007.mo8237(this.f1006, r3);
        }
    }

    /* renamed from: ؠ */
    public void mo8123() {
        C0532 r0 = this.f1011;
        if (r0.f1016) {
            throw new IOException("stream closed");
        } else if (!r0.f1017) {
            C1193 r02 = this.f1014;
            if (r02 != null) {
                throw new StreamResetException(r02);
            }
        } else {
            throw new IOException("stream finished");
        }
    }

    /* renamed from: ֏ */
    public void mo8120() {
        boolean z;
        boolean r1;
        synchronized (this) {
            z = !this.f1010.f1023 && this.f1010.f1022 && (this.f1011.f1017 || this.f1011.f1016);
            r1 = mo8129();
        }
        if (z) {
            mo8121(C1193.CANCEL);
        } else if (!r1) {
            this.f1007.mo8240(this.f1006);
        }
    }

    /* renamed from: com.wpengapp.support.ȁ$ؠ */
    /* compiled from: Http2Stream */
    private final class C0533 implements Source {

        /* renamed from: ֏ */
        public final Buffer f1019 = new Buffer();

        /* renamed from: ؠ */
        public final Buffer f1020 = new Buffer();

        /* renamed from: ހ */
        public final long f1021;

        /* renamed from: ށ */
        public boolean f1022;

        /* renamed from: ނ */
        public boolean f1023;

        public C0533(long j) {
            this.f1021 = j;
        }

        public void close() {
            long j;
            synchronized (Http2Stream.this) {
                this.f1022 = true;
                j = this.f1020.f2997;
                this.f1020.mo9201();
                if (!Http2Stream.this.f1008.isEmpty()) {
                    Http2Stream r3 = Http2Stream.this;
                }
                Http2Stream.this.notifyAll();
            }
            if (j > 0) {
                mo8135(j);
            }
            Http2Stream.this.mo8120();
        }

        /* renamed from: ֏ */
        public void mo8134(BufferedSource r12, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.f1023;
                    z2 = true;
                    z3 = this.f1020.f2997 + j > this.f1021;
                }
                if (z3) {
                    r12.skip(j);
                    Http2Stream.this.mo8126(C1193.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    r12.skip(j);
                    return;
                } else {
                    long r2 = r12.mo8055(this.f1019, j);
                    if (r2 != -1) {
                        j -= r2;
                        synchronized (Http2Stream.this) {
                            if (this.f1022) {
                                j2 = this.f1019.f2997;
                                this.f1019.mo9201();
                            } else {
                                if (this.f1020.f2997 != 0) {
                                    z2 = false;
                                }
                                this.f1020.mo9191((Source) this.f1019);
                                if (z2) {
                                    Http2Stream.this.notifyAll();
                                }
                                j2 = 0;
                            }
                        }
                        if (j2 > 0) {
                            mo8135(j2);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        /* renamed from: ؠ */
        public long mo8055(Buffer r11, long j) {
            C1193 r2;
            long r112;
            if (j >= 0) {
                while (true) {
                    r2 = null;
                    synchronized (Http2Stream.this) {
                        Http2Stream.this.f1012.mo8139();
                        try {
                            if (Http2Stream.this.f1014 != null) {
                                r2 = Http2Stream.this.f1014;
                            }
                            if (!this.f1022) {
                                if (!Http2Stream.this.f1008.isEmpty()) {
                                    Http2Stream r4 = Http2Stream.this;
                                }
                                if (this.f1020.f2997 > 0) {
                                    r112 = this.f1020.mo8055(r11, Math.min(j, this.f1020.f2997));
                                    Http2Stream.this.f1004 += r112;
                                    if (r2 == null && Http2Stream.this.f1004 >= ((long) (Http2Stream.this.f1007.f1292.mo9620() / 2))) {
                                        Http2Stream.this.f1007.mo8228(Http2Stream.this.f1006, Http2Stream.this.f1004);
                                        Http2Stream.this.f1004 = 0;
                                    }
                                } else if (this.f1023 || r2 != null) {
                                    r112 = -1;
                                } else {
                                    Http2Stream.this.mo8132();
                                }
                            } else {
                                throw new IOException("stream closed");
                            }
                        } finally {
                            Http2Stream.this.f1012.mo8137();
                        }
                    }
                }
                r112 = -1;
                Http2Stream.this.f1012.mo8137();
                if (r112 != -1) {
                    mo8135(r112);
                    return r112;
                } else if (r2 == null) {
                    return -1;
                } else {
                    throw new StreamResetException(r2);
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
        }

        /* renamed from: ހ */
        public final void mo8135(long j) {
            Http2Stream.this.f1007.mo8241(j);
        }

        /* renamed from: ؠ */
        public C1166 mo7988() {
            return Http2Stream.this.f1012;
        }
    }
}
