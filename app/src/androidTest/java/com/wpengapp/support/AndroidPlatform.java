package com.wpengapp.support;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.wpengapp.support.Ϭ */
public class AndroidPlatform extends Platform {

    /* renamed from: ހ */
    public final OptionalMethod<Socket> f1733;

    /* renamed from: ށ */
    public final OptionalMethod<Socket> f1734;

    /* renamed from: ނ */
    public final OptionalMethod<Socket> f1735;

    /* renamed from: ރ */
    public final OptionalMethod<Socket> f1736;

    /* renamed from: ބ */
    public final C0673 f1737;

    /* renamed from: com.wpengapp.support.Ϭ$֏ */
    /* compiled from: AndroidPlatform */
    static final class C0671 extends CertificateChainCleaner {

        /* renamed from: ֏ */
        public final Object f1738;

        /* renamed from: ؠ */
        public final Method f1739;

        public C0671(Object obj, Method method) {
            this.f1738 = obj;
            this.f1739 = method;
        }

        public boolean equals(Object obj) {
            return obj instanceof C0671;
        }

        public int hashCode() {
            return 0;
        }

        /* renamed from: ֏ */
        public List<Certificate> mo8445(List<Certificate> list, String str) {
            try {
                return (List) this.f1739.invoke(this.f1738, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* renamed from: com.wpengapp.support.Ϭ$ؠ */
    /* compiled from: AndroidPlatform */
    static final class C0672 implements TrustRootIndex {

        /* renamed from: ֏ */
        public final X509TrustManager f1740;

        /* renamed from: ؠ */
        public final Method f1741;

        public C0672(X509TrustManager x509TrustManager, Method method) {
            this.f1741 = method;
            this.f1740 = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0672)) {
                return false;
            }
            C0672 r5 = (C0672) obj;
            if (!this.f1740.equals(r5.f1740) || !this.f1741.equals(r5.f1741)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f1741.hashCode() * 31) + this.f1740.hashCode();
        }

        /* renamed from: ֏ */
        public X509Certificate mo8160(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f1741.invoke(this.f1740, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw Util.m934("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }
    }

    /* renamed from: com.wpengapp.support.Ϭ$ހ */
    /* compiled from: AndroidPlatform */
    static final class C0673 {

        /* renamed from: ֏ */
        public final Method f1742;

        /* renamed from: ؠ */
        public final Method f1743;

        /* renamed from: ހ */
        public final Method f1744;

        public C0673(Method method, Method method2, Method method3) {
            this.f1742 = method;
            this.f1743 = method2;
            this.f1744 = method3;
        }

        /* renamed from: ֏ */
        public boolean mo8448(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f1744.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public AndroidPlatform(Class<?> cls, OptionalMethod<Socket> r8, OptionalMethod<Socket> r9, OptionalMethod<Socket> r10, OptionalMethod<Socket> r11) {
        Method method;
        Method method2;
        Method method3 = null;
        try {
            Class<?> cls2 = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls2.getMethod("get", new Class[0]);
            method2 = cls2.getMethod("open", new Class[]{String.class});
            method = cls2.getMethod("warnIfOpen", new Class[0]);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.f1737 = new C0673(method3, method2, method);
        this.f1733 = r8;
        this.f1734 = r9;
        this.f1735 = r10;
        this.f1736 = r11;
    }

    /* renamed from: ֏ */
    public void mo8439(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (Util.m949(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e3);
                throw iOException2;
            }
            throw e3;
        }
    }

    /* renamed from: ؠ */
    public String mo8148(SSLSocket sSLSocket) {
        byte[] bArr;
        OptionalMethod<Socket> r0 = this.f1735;
        if (r0 == null || !r0.mo8548(sSLSocket) || (bArr = (byte[]) this.f1735.mo8550(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Util.f737);
    }

    /* renamed from: ؠ */
    public boolean mo8442(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return mo8440(str, cls, cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return true;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw Util.m934("unable to determine cleartext support", e);
        }
    }

    /* renamed from: ؠ */
    public static Platform m1704() {
        Class<?> cls;
        boolean z;
        OptionalMethod r7;
        OptionalMethod r6;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls2 = cls;
        OptionalMethod r4 = new OptionalMethod((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        OptionalMethod r5 = new OptionalMethod((Class<?>) null, "setHostname", String.class);
        if (Security.getProvider("GMSCore_OpenSSL") == null) {
            try {
                Class.forName("android.net.Network");
            } catch (ClassNotFoundException unused3) {
                z = false;
            }
        }
        z = true;
        if (z) {
            OptionalMethod r0 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            r7 = new OptionalMethod((Class<?>) null, "setAlpnProtocols", byte[].class);
            r6 = r0;
        } else {
            r6 = null;
            r7 = null;
        }
        return new AndroidPlatform(cls2, r4, r5, r6, r7);
    }

    /* renamed from: ֏ */
    public void mo8146(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f1733.mo8549(sSLSocket, true);
            this.f1734.mo8549(sSLSocket, str);
        }
        OptionalMethod<Socket> r7 = this.f1736;
        if (r7 != null && r7.mo8548(sSLSocket)) {
            this.f1736.mo8550(sSLSocket, Platform.m1747(list));
        }
    }

    /* renamed from: ֏ */
    public void mo8437(int i, String str, Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    /* renamed from: ؠ */
    public TrustRootIndex mo8441(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C0672(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
        }
    }

    /* renamed from: ֏ */
    public Object mo8436(String str) {
        C0673 r0 = this.f1737;
        Method method = r0.f1742;
        if (method != null) {
            try {
                Object invoke = method.invoke((Object) null, new Object[0]);
                r0.f1743.invoke(invoke, new Object[]{str});
                return invoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: ֏ */
    public void mo8438(String str, Object obj) {
        int min;
        if (!this.f1737.mo8448(obj)) {
            int i = 0;
            int length = str.length();
            while (i < length) {
                int indexOf = str.indexOf(10, i);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i + 4000);
                    Log.println(5, "OkHttp", str.substring(i, min));
                    if (min >= indexOf) {
                        break;
                    }
                    i = min;
                }
                i = min + 1;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return ((java.lang.Boolean) r7.getMethod("isCleartextTrafficPermitted", new java.lang.Class[0]).invoke(r8, new java.lang.Object[0])).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001d */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo8440(java.lang.String r6, java.lang.Class<?> r7, java.lang.Object r8) {
        /*
            r5 = this;
            java.lang.String r0 = "isCleartextTrafficPermitted"
            r1 = 0
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r3[r1] = r4     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.reflect.Method r3 = r7.getMethod(r0, r3)     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x001d }
            r4[r1] = r6     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.Object r6 = r3.invoke(r8, r4)     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ NoSuchMethodException -> 0x001d }
            boolean r6 = r6.booleanValue()     // Catch:{ NoSuchMethodException -> 0x001d }
            return r6
        L_0x001d:
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.reflect.Method r6 = r7.getMethod(r0, r6)     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.Object r6 = r6.invoke(r8, r7)     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ NoSuchMethodException -> 0x002f }
            boolean r2 = r6.booleanValue()     // Catch:{ NoSuchMethodException -> 0x002f }
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.AndroidPlatform.mo8440(java.lang.String, java.lang.Class, java.lang.Object):boolean");
    }

    /* renamed from: ֏ */
    public CertificateChainCleaner mo8435(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0671(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return new BasicCertificateChainCleaner(mo8441(x509TrustManager));
        }
    }

    /* renamed from: ֏ */
    public SSLContext mo8145() {
        boolean z = true;
        try {
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 22) {
                z = false;
            }
        } catch (NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }
}
