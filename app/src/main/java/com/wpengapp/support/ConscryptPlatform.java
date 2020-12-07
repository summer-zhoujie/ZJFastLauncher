package com.wpengapp.support;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;

/* renamed from: com.wpengapp.support.ȍ */
public class ConscryptPlatform extends Platform {
    /* renamed from: ֏ */
    public void mo8146(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) Platform.m1746(list).toArray(new String[0]));
        }
    }

    /* renamed from: ؠ */
    public String mo8148(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    /* renamed from: ހ */
    public final Provider mo8149() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    /* renamed from: ؠ */
    public static ConscryptPlatform m1329() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            return new ConscryptPlatform();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: ֏ */
    public SSLContext mo8145() {
        try {
            return SSLContext.getInstance("TLSv1.3", mo8149());
        } catch (NoSuchAlgorithmException e) {
            try {
                return SSLContext.getInstance("TLS", mo8149());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
    }

    /* renamed from: ֏ */
    public void mo8147(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
