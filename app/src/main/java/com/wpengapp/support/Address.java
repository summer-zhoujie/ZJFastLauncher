package com.wpengapp.support;

import com.wpengapp.support.HttpUrl;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.wpengapp.support.Մ */
public final class Address {

    /* renamed from: ֏ */
    public final HttpUrl f2018;

    /* renamed from: ؠ */
    public final C1159 f2019;

    /* renamed from: ހ */
    public final SocketFactory f2020;

    /* renamed from: ށ */
    public final C1173 f2021;

    /* renamed from: ނ */
    public final List<Protocol> f2022;

    /* renamed from: ރ */
    public final List<ConnectionSpec> f2023;

    /* renamed from: ބ */
    public final ProxySelector f2024;

    /* renamed from: ޅ */
    public final Proxy f2025;

    /* renamed from: ކ */
    public final SSLSocketFactory f2026;

    /* renamed from: އ */
    public final HostnameVerifier f2027;

    /* renamed from: ވ */
    public final CertificatePinner f2028;

    public Address(String str, int i, C1159 r16, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner r20, C1173 r21, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        String str2 = str;
        int i2 = i;
        C1159 r3 = r16;
        SocketFactory socketFactory2 = socketFactory;
        SSLSocketFactory sSLSocketFactory2 = sSLSocketFactory;
        C1173 r6 = r21;
        ProxySelector proxySelector2 = proxySelector;
        HttpUrl.C1165 r8 = new HttpUrl.C1165();
        String str3 = sSLSocketFactory2 != null ? "https" : "http";
        if (str3.equalsIgnoreCase("http")) {
            r8.f3315 = "http";
        } else if (str3.equalsIgnoreCase("https")) {
            r8.f3315 = "https";
        } else {
            throw new IllegalArgumentException(outline.m2556("unexpected scheme: ", str3));
        }
        if (str2 != null) {
            String r9 = HttpUrl.C1165.m3134(str, 0, str.length());
            if (r9 != null) {
                r8.f3318 = r9;
                if (i2 <= 0 || i2 > 65535) {
                    throw new IllegalArgumentException(outline.m2543("unexpected port: ", i));
                }
                r8.f3319 = i2;
                this.f2018 = r8.mo9376();
                if (r3 != null) {
                    this.f2019 = r3;
                    if (socketFactory2 != null) {
                        this.f2020 = socketFactory2;
                        if (r6 != null) {
                            this.f2021 = r6;
                            if (list != null) {
                                this.f2022 = Util.m940(list);
                                if (list2 != null) {
                                    this.f2023 = Util.m940(list2);
                                    if (proxySelector2 != null) {
                                        this.f2024 = proxySelector2;
                                        this.f2025 = proxy;
                                        this.f2026 = sSLSocketFactory2;
                                        this.f2027 = hostnameVerifier;
                                        this.f2028 = r20;
                                        return;
                                    }
                                    throw new NullPointerException("proxySelector == null");
                                }
                                throw new NullPointerException("connectionSpecs == null");
                            }
                            throw new NullPointerException("protocols == null");
                        }
                        throw new NullPointerException("proxyAuthenticator == null");
                    }
                    throw new NullPointerException("socketFactory == null");
                }
                throw new NullPointerException("dns == null");
            }
            throw new IllegalArgumentException(outline.m2556("unexpected host: ", str));
        }
        throw new NullPointerException("host == null");
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address r3 = (Address) obj;
            return this.f2018.equals(r3.f2018) && mo8643(r3);
        }
    }

    public int hashCode() {
        int hashCode = this.f2019.hashCode();
        int hashCode2 = (this.f2024.hashCode() + ((this.f2023.hashCode() + ((this.f2022.hashCode() + ((this.f2021.hashCode() + ((hashCode + ((527 + this.f2018.f3314.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        Proxy proxy = this.f2025;
        int i = 0;
        int hashCode3 = (hashCode2 + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f2026;
        int hashCode4 = (hashCode3 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f2027;
        int hashCode5 = (hashCode4 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner r1 = this.f2028;
        if (r1 != null) {
            CertificateChainCleaner r3 = r1.f2538;
            if (r3 != null) {
                i = r3.hashCode();
            }
            i = (i * 31) + r1.f2537.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("Address{");
        r0.append(this.f2018.f3310);
        r0.append(":");
        r0.append(this.f2018.f3311);
        if (this.f2025 != null) {
            r0.append(", proxy=");
            r0.append(this.f2025);
        } else {
            r0.append(", proxySelector=");
            r0.append(this.f2024);
        }
        r0.append("}");
        return r0.toString();
    }

    /* renamed from: ֏ */
    public CertificatePinner mo8642() {
        return this.f2028;
    }

    /* renamed from: ؠ */
    public HostnameVerifier mo8644() {
        return this.f2027;
    }

    /* renamed from: ֏ */
    public boolean mo8643(Address r3) {
        return this.f2019.equals(r3.f2019) && this.f2021.equals(r3.f2021) && this.f2022.equals(r3.f2022) && this.f2023.equals(r3.f2023) && this.f2024.equals(r3.f2024) && Util.m950((Object) this.f2025, (Object) r3.f2025) && Util.m950((Object) this.f2026, (Object) r3.f2026) && Util.m950((Object) this.f2027, (Object) r3.f2027) && Util.m950((Object) this.f2028, (Object) r3.f2028) && this.f2018.f3311 == r3.f2018.f3311;
    }
}
