package com.wpengapp.support;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.wpengapp.support.Л */
public class Platform {

    /* renamed from: ֏ */
    public static final Platform f1792;

    /* renamed from: ؠ */
    public static final Logger f1793 = Logger.getLogger(C0844.class.getName());

    static {
        boolean z;
        Platform r0 = AndroidPlatform.m1704();
        if (r0 == null) {
            if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
                z = true;
            } else {
                z = "Conscrypt".equals(Security.getProviders()[0].getName());
            }
            if ((!z || (r0 = ConscryptPlatform.m1329()) == null) && (r0 = Jdk9Platform.m2126()) == null && (r0 = JdkWithJettyBootPlatform.m3503()) == null) {
                r0 = new Platform();
            }
        }
        f1792 = r0;
    }

    /* renamed from: ؠ */
    public static byte[] m1747(List<Protocol> list) {
        Buffer r0 = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol r3 = list.get(i);
            if (r3 != Protocol.HTTP_1_0) {
                r0.writeByte(r3.f756.length());
                r0.mo8111(r3.f756);
            }
        }
        return r0.mo8492();
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    /* renamed from: ֏ */
    public void mo8439(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: ֏ */
    public void mo8469(SSLSocket sSLSocket) {
    }

    /* renamed from: ֏ */
    public void mo8146(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    /* renamed from: ֏ */
    public void mo8147(SSLSocketFactory sSLSocketFactory) {
    }

    /* renamed from: ؠ */
    public String mo8148(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: ؠ */
    public boolean mo8442(String str) {
        return true;
    }

    /* renamed from: ֏ */
    public void mo8437(int i, String str, Throwable th) {
        f1793.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: ֏ */
    public Object mo8436(String str) {
        if (f1793.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: ֏ */
    public void mo8438(String str, Object obj) {
        if (obj == null) {
            str = outline.m2556(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        mo8437(5, str, (Throwable) obj);
    }

    /* renamed from: ֏ */
    public static List<String> m1746(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol r3 = list.get(i);
            if (r3 != Protocol.HTTP_1_0) {
                arrayList.add(r3.f756);
            }
        }
        return arrayList;
    }

    /* renamed from: ؠ */
    public TrustRootIndex mo8441(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    /* renamed from: ֏ */
    public CertificateChainCleaner mo8435(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(mo8441(x509TrustManager));
    }

    /* renamed from: ֏ */
    public SSLContext mo8145() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }
}
