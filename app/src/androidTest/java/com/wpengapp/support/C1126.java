package com.wpengapp.support;

import com.wpengapp.support.Headers;
import com.wpengapp.support.Response;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ଝ */
/* compiled from: Http1Codec */
public final class C1126 implements HttpCodec {

    /* renamed from: ֏ */
    public final C0844 f3196;

    /* renamed from: ؠ */
    public final StreamAllocation f3197;

    /* renamed from: ހ */
    public final BufferedSource f3198;

    /* renamed from: ށ */
    public final BufferedSink f3199;

    /* renamed from: ނ */
    public int f3200 = 0;

    /* renamed from: ރ */
    public long f3201 = 262144;

    /* renamed from: com.wpengapp.support.ଝ$֏ */
    /* compiled from: Http1Codec */
    private abstract class C1127 implements Source {

        /* renamed from: ֏ */
        public final ForwardingTimeout f3202 = new ForwardingTimeout(C1126.this.f3198.mo7988());

        /* renamed from: ؠ */
        public boolean f3203;

        /* renamed from: ހ */
        public long f3204 = 0;

        public /* synthetic */ C1127(Http1Codec r2) {
        }

        /* renamed from: ֏ */
        public final void mo9315(boolean z, IOException iOException) {
            C1126 r0 = C1126.this;
            int i = r0.f3200;
            if (i != 6) {
                if (i == 5) {
                    r0.mo9312(this.f3202);
                    C1126 r5 = C1126.this;
                    r5.f3200 = 6;
                    StreamAllocation r3 = r5.f3197;
                    if (r3 != null) {
                        r3.mo8925(!z, r5, this.f3204, iOException);
                        return;
                    }
                    return;
                }
                StringBuilder r11 = outline.m2549("state: ");
                r11.append(C1126.this.f3200);
                throw new IllegalStateException(r11.toString());
            }
        }

        /* renamed from: ؠ */
        public C1166 mo7988() {
            return this.f3202;
        }

        /* renamed from: ؠ */
        public long mo8055(Buffer r3, long j) {
            try {
                long r32 = C1126.this.f3198.mo8055(r3, j);
                if (r32 > 0) {
                    this.f3204 += r32;
                }
                return r32;
            } catch (IOException e) {
                mo9315(false, e);
                throw e;
            }
        }
    }

    /* renamed from: com.wpengapp.support.ଝ$ؠ */
    /* compiled from: Http1Codec */
    private final class C1128 implements Sink {

        /* renamed from: ֏ */
        public final ForwardingTimeout f3206 = new ForwardingTimeout(C1126.this.f3199.mo7986());

        /* renamed from: ؠ */
        public boolean f3207;

        public C1128() {
        }

        public synchronized void close() {
            if (!this.f3207) {
                this.f3207 = true;
                C1126.this.f3199.mo8111("0\r\n\r\n");
                C1126.this.mo9312(this.f3206);
                C1126.this.f3200 = 3;
            }
        }

        public synchronized void flush() {
            if (!this.f3207) {
                C1126.this.f3199.flush();
            }
        }

        /* renamed from: ֏ */
        public void mo7985(Buffer r4, long j) {
            if (this.f3207) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                C1126.this.f3199.mo8113(j);
                C1126.this.f3199.mo8111("\r\n");
                C1126.this.f3199.mo7985(r4, j);
                C1126.this.f3199.mo8111("\r\n");
            }
        }

        /* renamed from: ؠ */
        public C1166 mo7986() {
            return this.f3206;
        }
    }

    /* renamed from: com.wpengapp.support.ଝ$ހ */
    /* compiled from: Http1Codec */
    private class C1129 extends C1127 {

        /* renamed from: ނ */
        public final HttpUrl f3209;

        /* renamed from: ރ */
        public long f3210 = -1;

        /* renamed from: ބ */
        public boolean f3211 = true;

        public C1129(HttpUrl r4) {
            super((Http1Codec) null);
            this.f3209 = r4;
        }

        public void close() {
            if (!this.f3203) {
                if (this.f3211 && !Util.m948((Source) this, 100, TimeUnit.MILLISECONDS)) {
                    mo9315(false, (IOException) null);
                }
                this.f3203 = true;
            }
        }

        /* renamed from: ؠ */
        public long mo8055(Buffer r10, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f3203) {
                throw new IllegalStateException("closed");
            } else if (!this.f3211) {
                return -1;
            } else {
                long j2 = this.f3210;
                if (j2 == 0 || j2 == -1) {
                    if (this.f3210 != -1) {
                        C1126.this.f3198.mo8495();
                    }
                    try {
                        this.f3210 = C1126.this.f3198.mo8499();
                        String trim = C1126.this.f3198.mo8495().trim();
                        if (this.f3210 < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f3210 + trim + "\"");
                        }
                        if (this.f3210 == 0) {
                            this.f3211 = false;
                            HttpHeaders.m1356(C1126.this.f3196.mo8742(), this.f3209, C1126.this.mo9314());
                            mo9315(true, (IOException) null);
                        }
                        if (!this.f3211) {
                            return -1;
                        }
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long r102 = super.mo8055(r10, Math.min(j, this.f3210));
                if (r102 != -1) {
                    this.f3210 -= r102;
                    return r102;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo9315(false, protocolException);
                throw protocolException;
            }
        }
    }

    /* renamed from: com.wpengapp.support.ଝ$ށ */
    /* compiled from: Http1Codec */
    private final class C1130 implements Sink {

        /* renamed from: ֏ */
        public final ForwardingTimeout f3213 = new ForwardingTimeout(C1126.this.f3199.mo7986());

        /* renamed from: ؠ */
        public boolean f3214;

        /* renamed from: ހ */
        public long f3215;

        public C1130(long j) {
            this.f3215 = j;
        }

        public void close() {
            if (!this.f3214) {
                this.f3214 = true;
                if (this.f3215 <= 0) {
                    C1126.this.mo9312(this.f3213);
                    C1126.this.f3200 = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() {
            if (!this.f3214) {
                C1126.this.f3199.flush();
            }
        }

        /* renamed from: ֏ */
        public void mo7985(Buffer r8, long j) {
            if (!this.f3214) {
                Util.m945(r8.f2997, 0, j);
                if (j <= this.f3215) {
                    C1126.this.f3199.mo7985(r8, j);
                    this.f3215 -= j;
                    return;
                }
                StringBuilder r0 = outline.m2549("expected ");
                r0.append(this.f3215);
                r0.append(" bytes but received ");
                r0.append(j);
                throw new ProtocolException(r0.toString());
            }
            throw new IllegalStateException("closed");
        }

        /* renamed from: ؠ */
        public C1166 mo7986() {
            return this.f3213;
        }
    }

    /* renamed from: com.wpengapp.support.ଝ$ނ */
    /* compiled from: Http1Codec */
    private class C1131 extends C1127 {

        /* renamed from: ނ */
        public long f3217;

        public C1131(C1126 r4, long j) {
            super((Http1Codec) null);
            this.f3217 = j;
            if (this.f3217 == 0) {
                mo9315(true, (IOException) null);
            }
        }

        public void close() {
            if (!this.f3203) {
                if (this.f3217 != 0 && !Util.m948((Source) this, 100, TimeUnit.MILLISECONDS)) {
                    mo9315(false, (IOException) null);
                }
                this.f3203 = true;
            }
        }

        /* renamed from: ؠ */
        public long mo8055(Buffer r8, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (!this.f3203) {
                long j2 = this.f3217;
                if (j2 == 0) {
                    return -1;
                }
                long r82 = super.mo8055(r8, Math.min(j2, j));
                if (r82 != -1) {
                    this.f3217 -= r82;
                    if (this.f3217 == 0) {
                        mo9315(true, (IOException) null);
                    }
                    return r82;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo9315(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    /* renamed from: com.wpengapp.support.ଝ$ރ */
    /* compiled from: Http1Codec */
    private class C1132 extends C1127 {

        /* renamed from: ނ */
        public boolean f3218;

        public C1132(C1126 r2) {
            super((Http1Codec) null);
        }

        public void close() {
            if (!this.f3203) {
                if (!this.f3218) {
                    mo9315(false, (IOException) null);
                }
                this.f3203 = true;
            }
        }

        /* renamed from: ؠ */
        public long mo8055(Buffer r4, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f3203) {
                throw new IllegalStateException("closed");
            } else if (this.f3218) {
                return -1;
            } else {
                long r42 = super.mo8055(r4, j);
                if (r42 != -1) {
                    return r42;
                }
                this.f3218 = true;
                mo9315(true, (IOException) null);
                return -1;
            }
        }
    }

    public C1126(C0844 r3, StreamAllocation r4, BufferedSource r5, BufferedSink r6) {
        this.f3196 = r3;
        this.f3197 = r4;
        this.f3198 = r5;
        this.f3199 = r6;
    }

    public void cancel() {
        RealConnection r0 = this.f3197.mo8927();
        if (r0 != null) {
            Util.m947(r0.f2038);
        }
    }

    /* renamed from: ֏ */
    public void mo9312(ForwardingTimeout r3) {
        C1166 r0 = r3.f3011;
        C1166 r1 = C1166.f3323;
        if (r1 != null) {
            r3.f3011 = r1;
            r0.mo9210();
            r0.mo9211();
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: ؠ */
    public void mo8623() {
        this.f3199.flush();
    }

    /* renamed from: ހ */
    public final String mo9313() {
        String r0 = this.f3198.mo8490(this.f3201);
        this.f3201 -= (long) r0.length();
        return r0;
    }

    /* renamed from: ށ */
    public Headers mo9314() {
        Headers.C0568 r0 = new Headers.C0568();
        while (true) {
            String r1 = mo9313();
            if (r1.length() == 0) {
                return new Headers(r0);
            }
            Internal.f1914.mo7917(r0, r1);
        }
    }

    /* renamed from: ֏ */
    public Sink mo8620(Request r6, long j) {
        if ("chunked".equalsIgnoreCase(r6.f2366.mo8178("Transfer-Encoding"))) {
            if (this.f3200 == 1) {
                this.f3200 = 2;
                return new C1128();
            }
            StringBuilder r7 = outline.m2549("state: ");
            r7.append(this.f3200);
            throw new IllegalStateException(r7.toString());
        } else if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.f3200 == 1) {
            this.f3200 = 2;
            return new C1130(j);
        } else {
            StringBuilder r72 = outline.m2549("state: ");
            r72.append(this.f3200);
            throw new IllegalStateException(r72.toString());
        }
    }

    /* renamed from: ֏ */
    public void mo8622(Request r4) {
        Proxy.Type type = this.f3197.mo8927().f2037.f953.type();
        StringBuilder sb = new StringBuilder();
        sb.append(r4.f2365);
        sb.append(' ');
        if (!r4.mo8830() && type == Proxy.Type.HTTP) {
            sb.append(r4.f2364);
        } else {
            sb.append(Utils.m1867(r4.f2364));
        }
        sb.append(" HTTP/1.1");
        mo9311(r4.f2366, sb.toString());
    }

    /* renamed from: ֏ */
    public C1154 mo8619(Response r10) {
        StreamAllocation r0 = this.f3197;
        r0.f2500.mo9606(r0.f2499);
        String r02 = r10.f1354.mo8178("Content-Type");
        String str = null;
        if (r02 == null) {
            r02 = null;
        }
        if (!HttpHeaders.m1358(r10)) {
            return new RealResponseBody(r02, 0, C0745.m1951(mo9310(0)));
        }
        String r2 = r10.f1354.mo8178("Transfer-Encoding");
        if (r2 != null) {
            str = r2;
        }
        if ("chunked".equalsIgnoreCase(str)) {
            HttpUrl r102 = r10.f1349.f2364;
            if (this.f3200 == 4) {
                this.f3200 = 5;
                return new RealResponseBody(r02, -1, C0745.m1951((Source) new C1129(r102)));
            }
            StringBuilder r03 = outline.m2549("state: ");
            r03.append(this.f3200);
            throw new IllegalStateException(r03.toString());
        }
        long r7 = HttpHeaders.m1355(r10);
        if (r7 != -1) {
            return new RealResponseBody(r02, r7, C0745.m1951(mo9310(r7)));
        }
        if (this.f3200 == 4) {
            StreamAllocation r1 = this.f3197;
            if (r1 != null) {
                this.f3200 = 5;
                r1.mo8928();
                return new RealResponseBody(r02, -1, C0745.m1951((Source) new C1132(this)));
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        StringBuilder r04 = outline.m2549("state: ");
        r04.append(this.f3200);
        throw new IllegalStateException(r04.toString());
    }

    /* renamed from: ֏ */
    public void mo8621() {
        this.f3199.flush();
    }

    /* renamed from: ֏ */
    public void mo9311(Headers r5, String str) {
        if (this.f3200 == 0) {
            this.f3199.mo8111(str).mo8111("\r\n");
            int r1 = r5.mo8176();
            for (int i = 0; i < r1; i++) {
                this.f3199.mo8111(r5.mo8175(i)).mo8111(": ").mo8111(r5.mo8177(i)).mo8111("\r\n");
            }
            this.f3199.mo8111("\r\n");
            this.f3200 = 1;
            return;
        }
        StringBuilder r6 = outline.m2549("state: ");
        r6.append(this.f3200);
        throw new IllegalStateException(r6.toString());
    }

    /* renamed from: ֏ */
    public Response.C0600 mo8618(boolean z) {
        int i = this.f3200;
        if (i == 1 || i == 3) {
            try {
                StatusLine r0 = StatusLine.m3036(mo9313());
                Response.C0600 r2 = new Response.C0600();
                r2.f1362 = r0.f3225;
                r2.f1363 = r0.f3226;
                r2.f1364 = r0.f3227;
                r2.mo8277(mo9314());
                if (z && r0.f3226 == 100) {
                    return null;
                }
                if (r0.f3226 == 100) {
                    this.f3200 = 3;
                    return r2;
                }
                this.f3200 = 4;
                return r2;
            } catch (EOFException e) {
                StringBuilder r1 = outline.m2549("unexpected end of stream on ");
                r1.append(this.f3197);
                IOException iOException = new IOException(r1.toString());
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            StringBuilder r02 = outline.m2549("state: ");
            r02.append(this.f3200);
            throw new IllegalStateException(r02.toString());
        }
    }

    /* renamed from: ֏ */
    public Source mo9310(long j) {
        if (this.f3200 == 4) {
            this.f3200 = 5;
            return new C1131(this, j);
        }
        StringBuilder r4 = outline.m2549("state: ");
        r4.append(this.f3200);
        throw new IllegalStateException(r4.toString());
    }
}
