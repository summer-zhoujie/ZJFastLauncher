package com.wpengapp.support;

import com.wpengapp.support.C1318;
import com.wpengapp.support.Call;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.wpengapp.support.ج */
/* compiled from: OkHttpClient */
public class C0844 implements Cloneable, Call.C1043, WebSocket {

    /* renamed from: ֏ */
    public static final List<Protocol> f2231 = Util.m941((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});

    /* renamed from: ؠ */
    public static final List<ConnectionSpec> f2232 = Util.m941((T[]) new ConnectionSpec[]{ConnectionSpec.f2933, ConnectionSpec.f2934});

    /* renamed from: ހ */
    public final Dispatcher f2233;

    /* renamed from: ށ */
    public final Proxy f2234;

    /* renamed from: ނ */
    public final List<Protocol> f2235;

    /* renamed from: ރ */
    public final List<ConnectionSpec> f2236;

    /* renamed from: ބ */
    public final List<Interceptor> f2237;

    /* renamed from: ޅ */
    public final List<Interceptor> f2238;

    /* renamed from: ކ */
    public final C1318.C1319 f2239;

    /* renamed from: އ */
    public final ProxySelector f2240;

    /* renamed from: ވ */
    public final C1229 f2241;

    /* renamed from: މ */
    public final SocketFactory f2242;

    /* renamed from: ފ */
    public final SSLSocketFactory f2243;

    /* renamed from: ދ */
    public final CertificateChainCleaner f2244;

    /* renamed from: ތ */
    public final HostnameVerifier f2245;

    /* renamed from: ލ */
    public final CertificatePinner f2246;

    /* renamed from: ގ */
    public final C1173 f2247;

    /* renamed from: ޏ */
    public final C1173 f2248;

    /* renamed from: ސ */
    public final C1000 f2249;

    /* renamed from: ޑ */
    public final C1159 f2250;

    /* renamed from: ޒ */
    public final boolean f2251;

    /* renamed from: ޓ */
    public final boolean f2252;

    /* renamed from: ޔ */
    public final boolean f2253;

    /* renamed from: ޕ */
    public final int f2254;

    /* renamed from: ޖ */
    public final int f2255;

    /* renamed from: ޗ */
    public final int f2256;

    /* renamed from: ޘ */
    public final int f2257;

    /* renamed from: ޙ */
    public final int f2258;

    /* renamed from: com.wpengapp.support.ج$֏ */
    /* compiled from: OkHttpClient */
    public static final class C0845 {

        /* renamed from: ֏ */
        public Dispatcher f2259;

        /* renamed from: ؠ */
        public Proxy f2260;

        /* renamed from: ހ */
        public List<Protocol> f2261;

        /* renamed from: ށ */
        public List<ConnectionSpec> f2262;

        /* renamed from: ނ */
        public final List<Interceptor> f2263;

        /* renamed from: ރ */
        public final List<Interceptor> f2264;

        /* renamed from: ބ */
        public C1318.C1319 f2265;

        /* renamed from: ޅ */
        public ProxySelector f2266;

        /* renamed from: ކ */
        public C1229 f2267;

        /* renamed from: އ */
        public Cache f2268;

        /* renamed from: ވ */
        public InternalCache f2269;

        /* renamed from: މ */
        public SocketFactory f2270;

        /* renamed from: ފ */
        public SSLSocketFactory f2271;

        /* renamed from: ދ */
        public CertificateChainCleaner f2272;

        /* renamed from: ތ */
        public HostnameVerifier f2273;

        /* renamed from: ލ */
        public CertificatePinner f2274;

        /* renamed from: ގ */
        public C1173 f2275;

        /* renamed from: ޏ */
        public C1173 f2276;

        /* renamed from: ސ */
        public C1000 f2277;

        /* renamed from: ޑ */
        public C1159 f2278;

        /* renamed from: ޒ */
        public boolean f2279;

        /* renamed from: ޓ */
        public boolean f2280;

        /* renamed from: ޔ */
        public boolean f2281;

        /* renamed from: ޕ */
        public int f2282;

        /* renamed from: ޖ */
        public int f2283;

        /* renamed from: ޗ */
        public int f2284;

        /* renamed from: ޘ */
        public int f2285;

        /* renamed from: ޙ */
        public int f2286;

        public C0845() {
            this.f2263 = new ArrayList();
            this.f2264 = new ArrayList();
            this.f2259 = new Dispatcher();
            this.f2261 = C0844.f2231;
            this.f2262 = C0844.f2232;
            this.f2265 = C1318.m3590(C1318.f3770);
            this.f2266 = ProxySelector.getDefault();
            if (this.f2266 == null) {
                this.f2266 = new NullProxySelector();
            }
            this.f2267 = C1229.f3503;
            this.f2270 = SocketFactory.getDefault();
            this.f2273 = OkHostnameVerifier.f3353;
            this.f2274 = CertificatePinner.f2536;
            C1173 r0 = C1173.f3341;
            this.f2275 = r0;
            this.f2276 = r0;
            this.f2277 = new C1000();
            this.f2278 = C1159.f3298;
            this.f2279 = true;
            this.f2280 = true;
            this.f2281 = true;
            this.f2282 = 0;
            this.f2283 = 10000;
            this.f2284 = 10000;
            this.f2285 = 10000;
            this.f2286 = 0;
        }

        /* renamed from: ֏ */
        public C0845 mo8745(long j, TimeUnit timeUnit) {
            this.f2283 = Util.m932("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: ؠ */
        public C0845 mo8749(long j, TimeUnit timeUnit) {
            this.f2284 = Util.m932("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: ހ */
        public C0845 mo8750(long j, TimeUnit timeUnit) {
            this.f2285 = Util.m932("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: ֏ */
        public C0845 mo8747(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            } else if (x509TrustManager != null) {
                this.f2271 = sSLSocketFactory;
                this.f2272 = Platform.f1792.mo8435(x509TrustManager);
                return this;
            } else {
                throw new NullPointerException("trustManager == null");
            }
        }

        /* renamed from: ֏ */
        public C0845 mo8746(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.f2273 = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        /* renamed from: ֏ */
        public C0844 mo8748() {
            return new C0844(this);
        }

        public C0845(C0844 r3) {
            this.f2263 = new ArrayList();
            this.f2264 = new ArrayList();
            this.f2259 = r3.f2233;
            this.f2260 = r3.f2234;
            this.f2261 = r3.f2235;
            this.f2262 = r3.f2236;
            this.f2263.addAll(r3.f2237);
            this.f2264.addAll(r3.f2238);
            this.f2265 = r3.f2239;
            this.f2266 = r3.f2240;
            this.f2267 = r3.f2241;
            this.f2270 = r3.f2242;
            this.f2271 = r3.f2243;
            this.f2272 = r3.f2244;
            this.f2273 = r3.f2245;
            this.f2274 = r3.f2246;
            this.f2275 = r3.f2247;
            this.f2276 = r3.f2248;
            this.f2277 = r3.f2249;
            this.f2278 = r3.f2250;
            this.f2279 = r3.f2251;
            this.f2280 = r3.f2252;
            this.f2281 = r3.f2253;
            this.f2282 = r3.f2254;
            this.f2283 = r3.f2255;
            this.f2284 = r3.f2256;
            this.f2285 = r3.f2257;
            this.f2286 = r3.f2258;
        }
    }

    static {
        Internal.f1914 = new OkHttpClient();
    }

    public C0844() {
        this(new C0845());
    }

    /* renamed from: ֏ */
    public Call mo8741(Request r3) {
        C1140 r0 = new C1140(this, r3, false);
        r0.f3236 = ((EventListener) this.f2239).f976;
        return r0;
    }

    /* renamed from: ؠ */
    public void mo8743() {
    }

    /* renamed from: ހ */
    public C0845 mo8744() {
        return new C0845(this);
    }

    public C0844(C0845 r6) {
        boolean z;
        this.f2233 = r6.f2259;
        this.f2234 = r6.f2260;
        this.f2235 = r6.f2261;
        this.f2236 = r6.f2262;
        this.f2237 = Util.m940(r6.f2263);
        this.f2238 = Util.m940(r6.f2264);
        this.f2239 = r6.f2265;
        this.f2240 = r6.f2266;
        this.f2241 = r6.f2267;
        Cache r0 = r6.f2268;
        InternalCache r02 = r6.f2269;
        this.f2242 = r6.f2270;
        Iterator<ConnectionSpec> it = this.f2236.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                ConnectionSpec next = it.next();
                if (z || next.f2935) {
                    z = true;
                }
            }
        }
        if (r6.f2271 != null || !z) {
            this.f2243 = r6.f2271;
            this.f2244 = r6.f2272;
        } else {
            X509TrustManager r03 = Util.m944();
            try {
                SSLContext r3 = Platform.f1792.mo8145();
                r3.init((KeyManager[]) null, new TrustManager[]{r03}, (SecureRandom) null);
                this.f2243 = r3.getSocketFactory();
                this.f2244 = Platform.f1792.mo8435(r03);
            } catch (GeneralSecurityException e) {
                throw Util.m934("No System TLS", (Exception) e);
            }
        }
        SSLSocketFactory sSLSocketFactory = this.f2243;
        if (sSLSocketFactory != null) {
            Platform.f1792.mo8147(sSLSocketFactory);
        }
        this.f2245 = r6.f2273;
        CertificatePinner r04 = r6.f2274;
        CertificateChainCleaner r1 = this.f2244;
        this.f2246 = !Util.m950((Object) r04.f2538, (Object) r1) ? new CertificatePinner(r04.f2537, r1) : r04;
        this.f2247 = r6.f2275;
        this.f2248 = r6.f2276;
        this.f2249 = r6.f2277;
        this.f2250 = r6.f2278;
        this.f2251 = r6.f2279;
        this.f2252 = r6.f2280;
        this.f2253 = r6.f2281;
        this.f2254 = r6.f2282;
        this.f2255 = r6.f2283;
        this.f2256 = r6.f2284;
        this.f2257 = r6.f2285;
        this.f2258 = r6.f2286;
        if (this.f2237.contains((Object) null)) {
            StringBuilder r05 = outline.m2549("Null interceptor: ");
            r05.append(this.f2237);
            throw new IllegalStateException(r05.toString());
        } else if (this.f2238.contains((Object) null)) {
            StringBuilder r06 = outline.m2549("Null network interceptor: ");
            r06.append(this.f2238);
            throw new IllegalStateException(r06.toString());
        }
    }

    /* renamed from: ֏ */
    public C1229 mo8742() {
        return this.f2241;
    }
}
