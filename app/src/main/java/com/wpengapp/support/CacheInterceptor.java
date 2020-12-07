package com.wpengapp.support;

import com.wpengapp.support.Headers;
import com.wpengapp.support.Interceptor;
import com.wpengapp.support.Response;
import java.io.Closeable;
import java.util.Collections;
import java.util.List;

/* renamed from: com.wpengapp.support.ă */
public final class CacheInterceptor implements Interceptor {
    /* renamed from: ؠ */
    public static boolean m963(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    /* renamed from: ֏ */
    public Response mo7909(C1094 r14) {
        System.currentTimeMillis();
        RealInterceptorChain r0 = (RealInterceptorChain) r14;
        Request r1 = r0.f3287;
        CacheStrategy r2 = new CacheStrategy(r1, (Response) null);
        if (r2.f3223 != null && r1.mo8829().f3148) {
            r2 = new CacheStrategy((Request) null, (Response) null);
        }
        Request r12 = r2.f3223;
        Response r22 = r2.f3224;
        if (r12 == null && r22 == null) {
            Response.C0600 r142 = new Response.C0600();
            r142.f1361 = r0.f3287;
            r142.f1362 = Protocol.HTTP_1_1;
            r142.f1363 = 504;
            r142.f1364 = "Unsatisfiable Request (only-if-cached)";
            r142.f1367 = Util.f731;
            r142.f1371 = -1;
            r142.f1372 = System.currentTimeMillis();
            return r142.mo8279();
        } else if (r12 == null) {
            Response.C0600 r143 = r22.mo8276();
            r143.mo8278(m961(r22));
            return r143.mo8279();
        } else {
            RealInterceptorChain r144 = (RealInterceptorChain) r14;
            Response r145 = r144.mo9348(r12, r144.f3283, r144.f3284, r144.f3285);
            if (r22 != null) {
                if (r145.f1351 == 304) {
                    Response.C0600 r13 = new Response.C0600(r22);
                    Headers r4 = r22.f1354;
                    Headers r5 = r145.f1354;
                    Headers.C0568 r6 = new Headers.C0568();
                    int r7 = r4.mo8176();
                    for (int i = 0; i < r7; i++) {
                        String r10 = r4.mo8175(i);
                        String r11 = r4.mo8177(i);
                        if ((!"Warning".equalsIgnoreCase(r10) || !r11.startsWith("1")) && (m962(r10) || !m963(r10) || r5.mo8178(r10) == null)) {
                            Internal.f1914.mo7918(r6, r10, r11);
                        }
                    }
                    int r42 = r5.mo8176();
                    for (int i2 = 0; i2 < r42; i2++) {
                        String r72 = r5.mo8175(i2);
                        if (!m962(r72) && m963(r72)) {
                            Internal.f1914.mo7918(r6, r72, r5.mo8177(i2));
                        }
                    }
                    List<String> list = r6.f1213;
                    Headers.C0568 r52 = new Headers.C0568();
                    Collections.addAll(r52.f1213, (String[]) list.toArray(new String[list.size()]));
                    r13.f1366 = r52;
                    r13.f1371 = r145.f1359;
                    r13.f1372 = r145.f1360;
                    r13.mo8278(m961(r22));
                    Response r23 = m961(r145);
                    if (r23 != null) {
                        r13.mo8280("networkResponse", r23);
                    }
                    r13.f1368 = r23;
                    r13.mo8279();
                    Util.m946((Closeable) r145.f1355.mo7908());
                    throw null;
                }
                Util.m946((Closeable) r22.f1355);
            }
            Response.C0600 r15 = r145.mo8276();
            r15.mo8278(m961(r22));
            Response r146 = m961(r145);
            if (r146 != null) {
                r15.mo8280("networkResponse", r146);
            }
            r15.f1368 = r146;
            return r15.mo8279();
        }
    }

    /* renamed from: ֏ */
    public static Response m961(Response r1) {
        if (r1 == null || r1.f1355 == null) {
            return r1;
        }
        Response.C0600 r0 = new Response.C0600(r1);
        r0.f1367 = null;
        return r0.mo8279();
    }

    /* renamed from: ֏ */
    public static boolean m962(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
