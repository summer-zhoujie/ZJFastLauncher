package com.wpengapp.support;

import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.wpengapp.support.ଽ */
public class SSLContextFactory {

    /* renamed from: ֏ */
    public static SSLContextFactory f3251;

    /* renamed from: ֏ */
    public static SSLContextFactory m3060() {
        if (f3251 == null) {
            synchronized (SSLContextFactory.class) {
                if (f3251 == null) {
                    f3251 = new SSLContextFactory();
                }
            }
        }
        return f3251;
    }

    /* renamed from: ؠ */
    public SSLContext mo9335() {
        SSLContext sSLContext;
        try {
            sSLContext = SSLContext.getInstance("TLS");
        } catch (Exception unused) {
            sSLContext = SSLContext.getInstance("LLS");
        }
        sSLContext.init((KeyManager[]) null, new X509TrustManager[]{new SimpleX509TrustManager()}, new SecureRandom());
        return sSLContext;
    }
}
