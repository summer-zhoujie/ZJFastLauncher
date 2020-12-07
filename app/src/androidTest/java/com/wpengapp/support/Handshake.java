package com.wpengapp.support;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* renamed from: com.wpengapp.support.ǎ */
public final class Handshake {

    /* renamed from: ֏ */
    public final TlsVersion f977;

    /* renamed from: ؠ */
    public final CipherSuite f978;

    /* renamed from: ހ */
    public final List<Certificate> f979;

    /* renamed from: ށ */
    public final List<Certificate> f980;

    public Handshake(TlsVersion r1, CipherSuite r2, List<Certificate> list, List<Certificate> list2) {
        this.f977 = r1;
        this.f978 = r2;
        this.f979 = list;
        this.f980 = list2;
    }

    /* renamed from: ֏ */
    public static Handshake m1244(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            CipherSuite r0 = CipherSuite.m2475(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                TlsVersion r1 = TlsVersion.m1365(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = Util.m941((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = Util.m941((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new Handshake(r1, r0, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake r4 = (Handshake) obj;
        if (!this.f977.equals(r4.f977) || !this.f978.equals(r4.f978) || !this.f979.equals(r4.f979) || !this.f980.equals(r4.f980)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.f978.hashCode();
        int hashCode2 = this.f979.hashCode();
        return this.f980.hashCode() + ((hashCode2 + ((hashCode + ((this.f977.hashCode() + 527) * 31)) * 31)) * 31);
    }
}
