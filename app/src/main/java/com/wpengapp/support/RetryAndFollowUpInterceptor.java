package com.wpengapp.support;

import android.support.p000v4.widget.SwipeRefreshLayout;
import android.support.p003v7.widget.ActivityChooserView;
import com.wpengapp.support.HttpUrl;
import com.wpengapp.support.Interceptor;
import com.wpengapp.support.Request;
import com.wpengapp.support.Response;
import com.wpengapp.support.RouteSelector;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.wpengapp.support.ସ */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: ֏ */
    public final C0844 f3247;

    /* renamed from: ؠ */
    public volatile StreamAllocation f3248;

    /* renamed from: ހ */
    public Object f3249;

    /* renamed from: ށ */
    public volatile boolean f3250;

    public RetryAndFollowUpInterceptor(C0844 r1, boolean z) {
        this.f3247 = r1;
    }

    /* renamed from: ֏ */
    public final boolean mo9333(Response r3, HttpUrl r4) {
        HttpUrl r32 = r3.f1349.f2364;
        return r32.f3310.equals(r4.f3310) && r32.f3311 == r4.f3311 && r32.f3307.equals(r4.f3307);
    }

    /* renamed from: ֏ */
    public final Request mo9332(Response r7, Route r8) {
        if (r7 != null) {
            int i = r7.f1351;
            Request r1 = r7.f1349;
            String str = r1.f2365;
            RequestBody r5 = null;
            if (i == 307 || i == 308) {
                if (!str.equals("GET") && !str.equals("HEAD")) {
                    return null;
                }
            } else if (i == 401) {
                ((Authenticator) this.f3247.f2248).mo7940(r8, r7);
                return null;
            } else if (i == 503) {
                Response r82 = r7.f1358;
                if ((r82 == null || r82.f1351 != 503) && mo9330(r7, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) == 0) {
                    return r7.f1349;
                }
                return null;
            } else if (i != 407) {
                if (i != 408) {
                    switch (i) {
                        case SwipeRefreshLayout.ALPHA_ANIMATION_DURATION:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                } else if (!this.f3247.f2253) {
                    return null;
                } else {
                    RequestBody r0 = r1.f2367;
                    Response r02 = r7.f1358;
                    if ((r02 == null || r02.f1351 != 408) && mo9330(r7, 0) <= 0) {
                        return r7.f1349;
                    }
                    return null;
                }
            } else if (r8.f953.type() == Proxy.Type.HTTP) {
                ((Authenticator) this.f3247.f2247).mo7940(r8, r7);
                return null;
            } else {
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (!this.f3247.f2252) {
                return null;
            }
            String r83 = r7.f1354.mo8178("Location");
            if (r83 == null) {
                r83 = null;
            }
            if (r83 == null) {
                return null;
            }
            HttpUrl.C1165 r84 = r7.f1349.f2364.mo9368(r83);
            HttpUrl r85 = r84 != null ? r84.mo9376() : null;
            if (r85 == null) {
                return null;
            }
            if (!r85.f3307.equals(r7.f1349.f2364.f3307) && !this.f3247.f2251) {
                return null;
            }
            Request.C0874 r03 = r7.f1349.mo8831();
            if (Utils.m1895(str)) {
                boolean equals = str.equals("PROPFIND");
                if (!str.equals("PROPFIND")) {
                    r03.mo8834("GET", (RequestBody) null);
                } else {
                    if (equals) {
                        r5 = r7.f1349.f2367;
                    }
                    r03.mo8834(str, r5);
                }
                if (!equals) {
                    r03.f2372.mo8182("Transfer-Encoding");
                    r03.f2372.mo8182("Content-Length");
                    r03.f2372.mo8182("Content-Type");
                }
            }
            if (!mo9333(r7, r85)) {
                r03.f2372.mo8182("Authorization");
            }
            r03.mo8832(r85);
            return r03.mo8835();
        }
        throw new IllegalStateException();
    }

    /* renamed from: ֏ */
    public Response mo7909(C1094 r15) {
        RealInterceptorChain r152 = (RealInterceptorChain) r15;
        Request r0 = r152.f3287;
        Call r7 = r152.f3288;
        C1318 r8 = r152.f3289;
        StreamAllocation r1 = new StreamAllocation(this.f3247.f2249, mo9331(r0.f2364), r7, r8, this.f3249);
        this.f3248 = r1;
        Response r12 = null;
        int i = 0;
        while (!this.f3250) {
            try {
                Response r02 = r152.mo9348(r0, r1, (HttpCodec) null, (RealConnection) null);
                if (r12 != null) {
                    Response.C0600 r03 = r02.mo8276();
                    Response.C0600 r3 = new Response.C0600(r12);
                    r3.f1367 = null;
                    Response r13 = r3.mo8279();
                    if (r13.f1355 == null) {
                        r03.f1370 = r13;
                        r02 = r03.mo8279();
                    } else {
                        throw new IllegalArgumentException("priorResponse.body != null");
                    }
                }
                try {
                    Request r122 = mo9332(r02, r1.f2497);
                    if (r122 == null) {
                        r1.mo8929();
                        return r02;
                    }
                    Util.m946((Closeable) r02.f1355);
                    int i2 = i + 1;
                    if (i2 <= 20) {
                        RequestBody r14 = r122.f2367;
                        if (!mo9333(r02, r122.f2364)) {
                            r1.mo8929();
                            r1 = new StreamAllocation(this.f3247.f2249, mo9331(r122.f2364), r7, r8, this.f3249);
                            this.f3248 = r1;
                        } else if (r1.mo8926() != null) {
                            throw new IllegalStateException(outline.m2544("Closing the body of ", (Object) r02, " didn't close its backing stream. Bad interceptor?"));
                        }
                        r12 = r02;
                        r0 = r122;
                        i = i2;
                    } else {
                        r1.mo8929();
                        throw new ProtocolException(outline.m2543("Too many follow-up requests: ", i2));
                    }
                } catch (IOException e) {
                    r1.mo8929();
                    throw e;
                }
            } catch (RouteException e2) {
                if (!mo9334(e2.f1097, r1, false, r0)) {
                    throw e2.f1096;
                }
            } catch (IOException e3) {
                if (!mo9334(e3, r1, !(e3 instanceof ConnectionShutdownException), r0)) {
                    throw e3;
                }
            } catch (Throwable th) {
                r1.mo8924((IOException) null);
                r1.mo8929();
                throw th;
            }
        }
        r1.mo8929();
        throw new IOException("Canceled");
    }

    /* renamed from: ֏ */
    public final int mo9330(Response r2, int i) {
        String r22 = r2.f1354.mo8178("Retry-After");
        if (r22 == null) {
            r22 = null;
        }
        if (r22 == null) {
            return i;
        }
        return r22.matches("\\d+") ? Integer.valueOf(r22).intValue() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    /* renamed from: ֏ */
    public final boolean mo9334(IOException iOException, StreamAllocation r4, boolean z, Request r6) {
        RouteSelector.C0580 r3;
        r4.mo8924(iOException);
        if (!this.f3247.f2253) {
            return false;
        }
        if (z) {
            RequestBody r62 = r6.f2367;
            if (iOException instanceof FileNotFoundException) {
                return false;
            }
        }
        if (!(!(iOException instanceof ProtocolException) && (!(iOException instanceof InterruptedIOException) ? (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) : (iOException instanceof SocketTimeoutException) && !z))) {
            return false;
        }
        return r4.f2497 != null || (((r3 = r4.f2496) != null && r3.mo8215()) || r4.f2502.mo8212());
    }

    /* renamed from: ֏ */
    public final Address mo9331(HttpUrl r19) {
        CertificatePinner r12;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        HttpUrl r1 = r19;
        if (r1.f3307.equals("https")) {
            C0844 r2 = this.f3247;
            SSLSocketFactory sSLSocketFactory2 = r2.f2243;
            HostnameVerifier hostnameVerifier2 = r2.f2245;
            r12 = r2.f2246;
            sSLSocketFactory = sSLSocketFactory2;
            hostnameVerifier = hostnameVerifier2;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            r12 = null;
        }
        String str = r1.f3310;
        int i = r1.f3311;
        C0844 r13 = this.f3247;
        return new Address(str, i, r13.f2250, r13.f2242, sSLSocketFactory, hostnameVerifier, r12, r13.f2247, r13.f2234, r13.f2235, r13.f2236, r13.f2240);
    }
}
