package com.wpengapp.support;

import com.wpengapp.support.Headers;
import com.wpengapp.support.Interceptor;
import com.wpengapp.support.Request;
import com.wpengapp.support.Response;
import java.util.Collections;
import java.util.List;

/* renamed from: com.wpengapp.support.ƪ */
public final class BridgeInterceptor implements Interceptor {

    /* renamed from: ֏ */
    public final C1229 f947;

    public BridgeInterceptor(C1229 r1) {
        this.f947 = r1;
    }

    /* renamed from: ֏ */
    public Response mo7909(C1094 r15) {
        boolean z;
        RealInterceptorChain r152 = (RealInterceptorChain) r15;
        Request r0 = r152.f3287;
        Request.C0874 r1 = r0.mo8831();
        RequestBody r2 = r0.f2367;
        if (r2 != null) {
            MediaType r7 = r2.mo8943();
            if (r7 != null) {
                r1.f2372.mo8183("Content-Type", r7.f2310);
            }
            long r72 = r2.mo8941();
            if (r72 != -1) {
                r1.f2372.mo8183("Content-Length", Long.toString(r72));
                r1.f2372.mo8182("Transfer-Encoding");
            } else {
                r1.f2372.mo8183("Transfer-Encoding", "chunked");
                r1.f2372.mo8182("Content-Length");
            }
        }
        if (r0.f2366.mo8178("Host") == null) {
            r1.f2372.mo8183("Host", Util.m935(r0.f2364, false));
        }
        if (r0.f2366.mo8178("Connection") == null) {
            r1.f2372.mo8183("Connection", "Keep-Alive");
        }
        if (r0.f2366.mo8178("Accept-Encoding") == null && r0.f2366.mo8178("Range") == null) {
            r1.f2372.mo8183("Accept-Encoding", "gzip");
            z = true;
        } else {
            z = false;
        }
        List<Cookie> r73 = ((CookieJar) this.f947).mo8209(r0.f2364);
        if (!r73.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = r73.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                Cookie r12 = r73.get(i);
                sb.append(r12.f1321);
                sb.append('=');
                sb.append(r12.f1322);
            }
            r1.f2372.mo8183("Cookie", sb.toString());
        }
        if (r0.f2366.mo8178("User-Agent") == null) {
            r1.f2372.mo8183("User-Agent", "okhttp/3.12.6");
        }
        Response r153 = r152.mo9348(r1.mo8835(), r152.f3283, r152.f3284, r152.f3285);
        HttpHeaders.m1356(this.f947, r0.f2364, r153.f1354);
        Response.C0600 r13 = new Response.C0600(r153);
        r13.f1361 = r0;
        if (z) {
            String r02 = r153.f1354.mo8178("Content-Encoding");
            if (r02 == null) {
                r02 = null;
            }
            if ("gzip".equalsIgnoreCase(r02) && HttpHeaders.m1358(r153)) {
                GzipSource r03 = new GzipSource(r153.f1355.mo7908());
                Headers.C0568 r8 = r153.f1354.mo8174();
                r8.mo8182("Content-Encoding");
                r8.mo8182("Content-Length");
                List<String> list = r8.f1213;
                Headers.C0568 r6 = new Headers.C0568();
                Collections.addAll(r6.f1213, (String[]) list.toArray(new String[list.size()]));
                r13.f1366 = r6;
                String r154 = r153.f1354.mo8178("Content-Type");
                if (r154 == null) {
                    r154 = null;
                }
                r13.f1367 = new RealResponseBody(r154, -1, C0745.m1951((Source) r03));
            }
        }
        return r13.mo8279();
    }
}
