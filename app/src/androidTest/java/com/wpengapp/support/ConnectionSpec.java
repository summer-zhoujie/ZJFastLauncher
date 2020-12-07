package com.wpengapp.support;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.wpengapp.support.थ */
public final class ConnectionSpec {

    /* renamed from: ֏ */
    public static final CipherSuite[] f2931 = {CipherSuite.f2562, CipherSuite.f2563, CipherSuite.f2564, CipherSuite.f2565, CipherSuite.f2566, CipherSuite.f2556, CipherSuite.f2558, CipherSuite.f2557, CipherSuite.f2559, CipherSuite.f2561, CipherSuite.f2560};

    /* renamed from: ؠ */
    public static final CipherSuite[] f2932 = {CipherSuite.f2562, CipherSuite.f2563, CipherSuite.f2564, CipherSuite.f2565, CipherSuite.f2566, CipherSuite.f2556, CipherSuite.f2558, CipherSuite.f2557, CipherSuite.f2559, CipherSuite.f2561, CipherSuite.f2560, CipherSuite.f2554, CipherSuite.f2555, CipherSuite.f2552, CipherSuite.f2553, CipherSuite.f2550, CipherSuite.f2551, CipherSuite.f2549};

    /* renamed from: ހ */
    public static final ConnectionSpec f2933;

    /* renamed from: ށ */
    public static final ConnectionSpec f2934 = new ConnectionSpec(new C1021(false));

    /* renamed from: ނ */
    public final boolean f2935;

    /* renamed from: ރ */
    public final boolean f2936;

    /* renamed from: ބ */
    public final String[] f2937;

    /* renamed from: ޅ */
    public final String[] f2938;

    static {
        C1021 r0 = new C1021(true);
        r0.mo9141(f2931);
        r0.mo9140(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2);
        r0.mo9139(true);
        r0.mo9143();
        C1021 r02 = new C1021(true);
        r02.mo9141(f2932);
        r02.mo9140(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        r02.mo9139(true);
        f2933 = r02.mo9143();
        C1021 r03 = new C1021(true);
        r03.mo9141(f2932);
        r03.mo9140(TlsVersion.TLS_1_0);
        r03.mo9139(true);
        r03.mo9143();
    }

    public ConnectionSpec(C1021 r2) {
        this.f2935 = r2.f2939;
        this.f2937 = r2.f2940;
        this.f2938 = r2.f2941;
        this.f2936 = r2.f2942;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec r5 = (ConnectionSpec) obj;
        boolean z = this.f2935;
        if (z != r5.f2935) {
            return false;
        }
        return !z || (Arrays.equals(this.f2937, r5.f2937) && Arrays.equals(this.f2938, r5.f2938) && this.f2936 == r5.f2936);
    }

    public int hashCode() {
        if (!this.f2935) {
            return 17;
        }
        return ((Arrays.hashCode(this.f2938) + ((Arrays.hashCode(this.f2937) + 527) * 31)) * 31) + (this.f2936 ^ true ? 1 : 0);
    }

    public String toString() {
        String str;
        if (!this.f2935) {
            return "ConnectionSpec()";
        }
        String[] strArr = this.f2937;
        List<TlsVersion> list = null;
        String str2 = "[all enabled]";
        if (strArr != null) {
            str = (strArr != null ? CipherSuite.m2476(strArr) : null).toString();
        } else {
            str = str2;
        }
        String[] strArr2 = this.f2938;
        if (strArr2 != null) {
            if (strArr2 != null) {
                list = TlsVersion.m1366(strArr2);
            }
            str2 = list.toString();
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.f2936 + ")";
    }

    /* renamed from: ֏ */
    public boolean mo9137() {
        return this.f2936;
    }

    /* renamed from: com.wpengapp.support.थ$֏ */
    /* compiled from: ConnectionSpec */
    public static final class C1021 {

        /* renamed from: ֏ */
        public boolean f2939;

        /* renamed from: ؠ */
        public String[] f2940;

        /* renamed from: ހ */
        public String[] f2941;

        /* renamed from: ށ */
        public boolean f2942;

        public C1021(boolean z) {
            this.f2939 = z;
        }

        /* renamed from: ֏ */
        public C1021 mo9141(CipherSuite... r4) {
            if (this.f2939) {
                String[] strArr = new String[r4.length];
                for (int i = 0; i < r4.length; i++) {
                    strArr[i] = r4[i].f2567;
                }
                mo9142(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: ؠ */
        public C1021 mo9144(String... strArr) {
            if (!this.f2939) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f2941 = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public C1021(ConnectionSpec r2) {
            this.f2939 = r2.f2935;
            this.f2940 = r2.f2937;
            this.f2941 = r2.f2938;
            this.f2942 = r2.f2936;
        }

        /* renamed from: ֏ */
        public C1021 mo9142(String... strArr) {
            if (!this.f2939) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f2940 = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        /* renamed from: ֏ */
        public C1021 mo9140(TlsVersion... r4) {
            if (this.f2939) {
                String[] strArr = new String[r4.length];
                for (int i = 0; i < r4.length; i++) {
                    strArr[i] = r4[i].f1208;
                }
                mo9144(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: ֏ */
        public C1021 mo9139(boolean z) {
            if (this.f2939) {
                this.f2942 = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: ֏ */
        public ConnectionSpec mo9143() {
            return new ConnectionSpec(this);
        }
    }

    /* renamed from: ֏ */
    public boolean mo9138(SSLSocket sSLSocket) {
        if (!this.f2935) {
            return false;
        }
        String[] strArr = this.f2938;
        if (strArr != null && !Util.m957(Util.f743, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f2937;
        if (strArr2 == null || Util.m957(CipherSuite.f2547, strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }
}
