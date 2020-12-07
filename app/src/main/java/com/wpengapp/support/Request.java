package com.wpengapp.support;

import com.wpengapp.support.Headers;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.ټ */
public final class Request {

    /* renamed from: ֏ */
    public final HttpUrl f2364;

    /* renamed from: ؠ */
    public final String f2365;

    /* renamed from: ހ */
    public final Headers f2366;

    /* renamed from: ށ */
    public final RequestBody f2367;

    /* renamed from: ނ */
    public final Map<Class<?>, Object> f2368;

    /* renamed from: ރ */
    public volatile CacheControl f2369;

    public Request(C0874 r2) {
        this.f2364 = r2.f2370;
        this.f2365 = r2.f2371;
        this.f2366 = r2.f2372.mo8181();
        this.f2367 = r2.f2373;
        this.f2368 = Util.m942(r2.f2374);
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("Request{method=");
        r0.append(this.f2365);
        r0.append(", url=");
        r0.append(this.f2364);
        r0.append(", tags=");
        r0.append(this.f2368);
        r0.append('}');
        return r0.toString();
    }

    /* renamed from: ֏ */
    public CacheControl mo8829() {
        CacheControl r0 = this.f2369;
        if (r0 != null) {
            return r0;
        }
        CacheControl r02 = CacheControl.m2987(this.f2366);
        this.f2369 = r02;
        return r02;
    }

    /* renamed from: ؠ */
    public boolean mo8830() {
        return this.f2364.f3307.equals("https");
    }

    /* renamed from: ހ */
    public C0874 mo8831() {
        return new C0874(this);
    }

    /* renamed from: com.wpengapp.support.ټ$֏ */
    /* compiled from: Request */
    public static class C0874 {

        /* renamed from: ֏ */
        public HttpUrl f2370;

        /* renamed from: ؠ */
        public String f2371;

        /* renamed from: ހ */
        public Headers.C0568 f2372;

        /* renamed from: ށ */
        public RequestBody f2373;

        /* renamed from: ނ */
        public Map<Class<?>, Object> f2374;

        public C0874() {
            this.f2374 = Collections.emptyMap();
            this.f2371 = "GET";
            this.f2372 = new Headers.C0568();
        }

        /* renamed from: ֏ */
        public C0874 mo8832(HttpUrl r2) {
            if (r2 != null) {
                this.f2370 = r2;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: ֏ */
        public C0874 mo8833(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    StringBuilder r0 = outline.m2549("http:");
                    r0.append(str.substring(3));
                    str = r0.toString();
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    StringBuilder r02 = outline.m2549("https:");
                    r02.append(str.substring(4));
                    str = r02.toString();
                }
                mo8832(HttpUrl.m3123(str));
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public C0874(Request r3) {
            Map<Class<?>, Object> map;
            this.f2374 = Collections.emptyMap();
            this.f2370 = r3.f2364;
            this.f2371 = r3.f2365;
            this.f2373 = r3.f2367;
            if (r3.f2368.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = new LinkedHashMap<>(r3.f2368);
            }
            this.f2374 = map;
            this.f2372 = r3.f2366.mo8174();
        }

        /* renamed from: ֏ */
        public C0874 mo8834(String str, RequestBody r4) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (r4 == null || Utils.m1895(str)) {
                if (r4 == null) {
                    if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
                        throw new IllegalArgumentException(outline.m2545("method ", str, " must have a request body."));
                    }
                }
                this.f2371 = str;
                this.f2373 = r4;
                return this;
            } else {
                throw new IllegalArgumentException(outline.m2545("method ", str, " must not have a request body."));
            }
        }

        /* renamed from: ֏ */
        public Request mo8835() {
            if (this.f2370 != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
