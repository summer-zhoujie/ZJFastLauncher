package com.wpengapp.support;

import com.wpengapp.support.ConnectionSpec;
import com.wpengapp.support.Headers;
import com.wpengapp.support.Response;
import java.io.IOException;
import java.net.Socket;
import java.util.Comparator;
import javax.net.ssl.SSLSocket;

/* renamed from: com.wpengapp.support.Ĉ */
class OkHttpClient extends Internal {
    /* renamed from: ֏ */
    public RealConnection mo7913(C1000 r3, Address r4, StreamAllocation r5, Route r6) {
        for (RealConnection next : r3.f2816) {
            if (next.mo8663(r4, r6)) {
                r5.mo8923(next, true);
                return next;
            }
        }
        return null;
    }

    /* renamed from: ؠ */
    public void mo7922(C1000 r3, RealConnection r4) {
        if (!r3.f2818) {
            r3.f2818 = true;
            C1000.f2812.execute(r3.f2815);
        }
        r3.f2816.add(r4);
    }

    /* renamed from: ֏ */
    public void mo7917(Headers.C0568 r1, String str) {
        r1.mo8179(str);
    }

    /* renamed from: ֏ */
    public Socket mo7916(C1000 r3, Address r4, StreamAllocation r5) {
        for (RealConnection next : r3.f2816) {
            if (next.mo8663(r4, (Route) null) && next.mo8662() && next != r5.mo8927()) {
                if (r5.f2508 == null && r5.f2504.f2048.size() == 1) {
                    Socket r1 = r5.mo8921(true, false, false);
                    r5.f2504 = next;
                    next.f2048.add(r5.f2504.f2048.get(0));
                    return r1;
                }
                throw new IllegalStateException();
            }
        }
        return null;
    }

    /* renamed from: ֏ */
    public boolean mo7921(C1000 r1, RealConnection r2) {
        return r1.mo9064(r2);
    }

    /* renamed from: ֏ */
    public boolean mo7920(Address r1, Address r2) {
        return r1.mo8643(r2);
    }

    /* renamed from: ֏ */
    public void mo7919(ConnectionSpec r6, SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (r6.f2937 != null) {
            strArr = Util.m951((Comparator<? super String>) CipherSuite.f2547, sSLSocket.getEnabledCipherSuites(), r6.f2937);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (r6.f2938 != null) {
            strArr2 = Util.m951((Comparator<? super String>) Util.f743, sSLSocket.getEnabledProtocols(), r6.f2938);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int r3 = Util.m933(CipherSuite.f2547, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && r3 != -1) {
            strArr = Util.m952(strArr, supportedCipherSuites[r3]);
        }
        ConnectionSpec.C1021 r8 = new ConnectionSpec.C1021(r6);
        r8.mo9142(strArr);
        r8.mo9144(strArr2);
        ConnectionSpec r62 = r8.mo9143();
        String[] strArr3 = r62.f2938;
        if (strArr3 != null) {
            sSLSocket.setEnabledProtocols(strArr3);
        }
        String[] strArr4 = r62.f2937;
        if (strArr4 != null) {
            sSLSocket.setEnabledCipherSuites(strArr4);
        }
    }

    /* renamed from: ֏ */
    public RouteDatabase mo7914(C1000 r1) {
        return r1.f2817;
    }

    /* renamed from: ֏ */
    public int mo7912(Response.C0600 r1) {
        return r1.f1363;
    }

    /* renamed from: ֏ */
    public IOException mo7915(Call r1, IOException iOException) {
        return ((C1140) r1).mo9321(iOException);
    }

    /* renamed from: ֏ */
    public void mo7918(Headers.C0568 r2, String str, String str2) {
        r2.f1213.add(str);
        r2.f1213.add(str2.trim());
    }
}
