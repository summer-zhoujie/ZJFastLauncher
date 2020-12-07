package com.wpengapp.support;

import com.wpengapp.support.Headers;
import com.wpengapp.support.Interceptor;
import com.wpengapp.support.Response;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ԏ */
public final class Http2Codec implements HttpCodec {

    /* renamed from: ֏ */
    public static final List<String> f1963 = Util.m941((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});

    /* renamed from: ؠ */
    public static final List<String> f1964 = Util.m941((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});

    /* renamed from: ހ */
    public final Interceptor.C1094 f1965;

    /* renamed from: ށ */
    public final StreamAllocation f1966;

    /* renamed from: ނ */
    public final C0586 f1967;

    /* renamed from: ރ */
    public Http2Stream f1968;

    /* renamed from: ބ */
    public final Protocol f1969;

    /* renamed from: com.wpengapp.support.ԏ$֏ */
    /* compiled from: Http2Codec */
    class C0764 extends ForwardingSource {

        /* renamed from: ؠ */
        public boolean f1970 = false;

        /* renamed from: ހ */
        public long f1971 = 0;

        public C0764(Source r2) {
            super(r2);
        }

        public void close() {
            this.f829.close();
            mo8624((IOException) null);
        }

        /* renamed from: ֏ */
        public final void mo8624(IOException iOException) {
            if (!this.f1970) {
                this.f1970 = true;
                Http2Codec r3 = Http2Codec.this;
                r3.f1966.mo8925(false, r3, this.f1971, iOException);
            }
        }

        /* renamed from: ؠ */
        public long mo8055(Buffer r3, long j) {
            try {
                long r32 = this.f829.mo8055(r3, j);
                if (r32 > 0) {
                    this.f1971 += r32;
                }
                return r32;
            } catch (IOException e) {
                mo8624(e);
                throw e;
            }
        }
    }

    public Http2Codec(C0844 r1, Interceptor.C1094 r2, StreamAllocation r3, C0586 r4) {
        Protocol r12;
        this.f1965 = r2;
        this.f1966 = r3;
        this.f1967 = r4;
        if (r1.f2235.contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            r12 = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            r12 = Protocol.HTTP_2;
        }
        this.f1969 = r12;
    }

    public void cancel() {
        Http2Stream r0 = this.f1968;
        if (r0 != null) {
            r0.mo8126(C1193.CANCEL);
        }
    }

    /* renamed from: ֏ */
    public Sink mo8620(Request r1, long j) {
        return this.f1968.mo8125();
    }

    /* renamed from: ؠ */
    public void mo8623() {
        this.f1967.f1295.flush();
    }

    /* renamed from: ֏ */
    public void mo8622(Request r9) {
        if (this.f1968 == null) {
            boolean z = r9.f2367 != null;
            Headers r2 = r9.f2366;
            ArrayList arrayList = new ArrayList(r2.mo8176() + 4);
            arrayList.add(new Header(Header.f2920, r9.f2365));
            arrayList.add(new Header(Header.f2921, Utils.m1867(r9.f2364)));
            String r4 = r9.f2366.mo8178("Host");
            if (r4 != null) {
                arrayList.add(new Header(Header.f2923, r4));
            }
            arrayList.add(new Header(Header.f2922, r9.f2364.f3307));
            int r92 = r2.mo8176();
            for (int i = 0; i < r92; i++) {
                ByteString r5 = ByteString.m2188(r2.mo8175(i).toLowerCase(Locale.US));
                if (!f1963.contains(r5.mo8005())) {
                    arrayList.add(new Header(r5, r2.mo8177(i)));
                }
            }
            this.f1968 = this.f1967.mo8227(0, (List<Header>) arrayList, z);
            this.f1968.f1012.mo9111((long) ((RealInterceptorChain) this.f1965).f3291, TimeUnit.MILLISECONDS);
            this.f1968.f1013.mo9111((long) ((RealInterceptorChain) this.f1965).f3292, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: ֏ */
    public void mo8621() {
        this.f1968.mo8125().close();
    }

    /* renamed from: ֏ */
    public Response.C0600 mo8618(boolean z) {
        Headers r0 = this.f1968.mo8131();
        Protocol r1 = this.f1969;
        Headers.C0568 r2 = new Headers.C0568();
        int r3 = r0.mo8176();
        StatusLine r6 = null;
        for (int i = 0; i < r3; i++) {
            String r7 = r0.mo8175(i);
            String r8 = r0.mo8177(i);
            if (r7.equals(":status")) {
                r6 = StatusLine.m3036("HTTP/1.1 " + r8);
            } else if (!f1964.contains(r7)) {
                Internal.f1914.mo7918(r2, r7, r8);
            }
        }
        if (r6 != null) {
            Response.C0600 r02 = new Response.C0600();
            r02.f1362 = r1;
            r02.f1363 = r6.f3226;
            r02.f1364 = r6.f3227;
            List<String> list = r2.f1213;
            Headers.C0568 r22 = new Headers.C0568();
            Collections.addAll(r22.f1213, (String[]) list.toArray(new String[list.size()]));
            r02.f1366 = r22;
            if (!z || Internal.f1914.mo7912(r02) != 100) {
                return r02;
            }
            return null;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* renamed from: ֏ */
    public C1154 mo8619(Response r5) {
        StreamAllocation r0 = this.f1966;
        r0.f2500.mo9606(r0.f2499);
        String r02 = r5.f1354.mo8178("Content-Type");
        if (r02 == null) {
            r02 = null;
        }
        return new RealResponseBody(r02, HttpHeaders.m1355(r5), C0745.m1951((Source) new C0764(this.f1968.f1010)));
    }
}
