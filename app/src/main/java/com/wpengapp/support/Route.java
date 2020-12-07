package com.wpengapp.support;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.wpengapp.support.Ʈ */
public final class Route {

    /* renamed from: ֏ */
    public final Address f952;

    /* renamed from: ؠ */
    public final Proxy f953;

    /* renamed from: ހ */
    public final InetSocketAddress f954;

    public Route(Address r1, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (r1 == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f952 = r1;
            this.f953 = proxy;
            this.f954 = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route r3 = (Route) obj;
            return r3.f952.equals(this.f952) && r3.f953.equals(this.f953) && r3.f954.equals(this.f954);
        }
    }

    public int hashCode() {
        Address r0 = this.f952;
        int hashCode = r0.f2019.hashCode();
        int hashCode2 = (r0.f2024.hashCode() + ((r0.f2023.hashCode() + ((r0.f2022.hashCode() + ((r0.f2021.hashCode() + ((hashCode + ((r0.f2018.f3314.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        Proxy proxy = r0.f2025;
        int i = 0;
        int hashCode3 = (hashCode2 + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = r0.f2026;
        int hashCode4 = (hashCode3 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = r0.f2027;
        int hashCode5 = (hashCode4 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner r02 = r0.f2028;
        if (r02 != null) {
            CertificateChainCleaner r1 = r02.f2538;
            if (r1 != null) {
                i = r1.hashCode();
            }
            i = (i * 31) + r02.f2537.hashCode();
        }
        return this.f954.hashCode() + ((this.f953.hashCode() + ((527 + hashCode5 + i) * 31)) * 31);
    }

    public String toString() {
        return outline.m2546(outline.m2549("Route{"), (Object) this.f954, "}");
    }

    /* renamed from: ֏ */
    public boolean mo8078() {
        return this.f952.f2026 != null && this.f953.type() == Proxy.Type.HTTP;
    }
}
