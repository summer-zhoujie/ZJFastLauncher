package com.wpengapp.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.ݯ */
public final class CipherSuite {

    /* renamed from: ֏ */
    public static final Comparator<String> f2547 = new C1051();

    /* renamed from: ؠ */
    public static final Map<String, CipherSuite> f2548 = new LinkedHashMap();

    /* renamed from: ހ */
    public static final CipherSuite f2549 = m2477("SSL_RSA_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: ށ */
    public static final CipherSuite f2550 = m2477("TLS_RSA_WITH_AES_128_CBC_SHA");

    /* renamed from: ނ */
    public static final CipherSuite f2551 = m2477("TLS_RSA_WITH_AES_256_CBC_SHA");

    /* renamed from: ރ */
    public static final CipherSuite f2552 = m2477("TLS_RSA_WITH_AES_128_GCM_SHA256");

    /* renamed from: ބ */
    public static final CipherSuite f2553 = m2477("TLS_RSA_WITH_AES_256_GCM_SHA384");

    /* renamed from: ޅ */
    public static final CipherSuite f2554 = m2477("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");

    /* renamed from: ކ */
    public static final CipherSuite f2555 = m2477("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");

    /* renamed from: އ */
    public static final CipherSuite f2556 = m2477("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");

    /* renamed from: ވ */
    public static final CipherSuite f2557 = m2477("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");

    /* renamed from: މ */
    public static final CipherSuite f2558 = m2477("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");

    /* renamed from: ފ */
    public static final CipherSuite f2559 = m2477("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");

    /* renamed from: ދ */
    public static final CipherSuite f2560 = m2477("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");

    /* renamed from: ތ */
    public static final CipherSuite f2561 = m2477("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");

    /* renamed from: ލ */
    public static final CipherSuite f2562 = m2477("TLS_AES_128_GCM_SHA256");

    /* renamed from: ގ */
    public static final CipherSuite f2563 = m2477("TLS_AES_256_GCM_SHA384");

    /* renamed from: ޏ */
    public static final CipherSuite f2564 = m2477("TLS_CHACHA20_POLY1305_SHA256");

    /* renamed from: ސ */
    public static final CipherSuite f2565 = m2477("TLS_AES_128_CCM_SHA256");

    /* renamed from: ޑ */
    public static final CipherSuite f2566 = m2477("TLS_AES_256_CCM_8_SHA256");

    /* renamed from: ޒ */
    public final String f2567;

    static {
        m2477("SSL_RSA_WITH_NULL_MD5");
        m2477("SSL_RSA_WITH_NULL_SHA");
        m2477("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        m2477("SSL_RSA_WITH_RC4_128_MD5");
        m2477("SSL_RSA_WITH_RC4_128_SHA");
        m2477("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        m2477("SSL_RSA_WITH_DES_CBC_SHA");
        m2477("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        m2477("SSL_DHE_DSS_WITH_DES_CBC_SHA");
        m2477("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        m2477("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        m2477("SSL_DHE_RSA_WITH_DES_CBC_SHA");
        m2477("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        m2477("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        m2477("SSL_DH_anon_WITH_RC4_128_MD5");
        m2477("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        m2477("SSL_DH_anon_WITH_DES_CBC_SHA");
        m2477("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        m2477("TLS_KRB5_WITH_DES_CBC_SHA");
        m2477("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        m2477("TLS_KRB5_WITH_RC4_128_SHA");
        m2477("TLS_KRB5_WITH_DES_CBC_MD5");
        m2477("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        m2477("TLS_KRB5_WITH_RC4_128_MD5");
        m2477("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        m2477("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        m2477("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        m2477("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        m2477("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        m2477("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        m2477("TLS_DH_anon_WITH_AES_128_CBC_SHA");
        m2477("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        m2477("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        m2477("TLS_DH_anon_WITH_AES_256_CBC_SHA");
        m2477("TLS_RSA_WITH_NULL_SHA256");
        m2477("TLS_RSA_WITH_AES_128_CBC_SHA256");
        m2477("TLS_RSA_WITH_AES_256_CBC_SHA256");
        m2477("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        m2477("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        m2477("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        m2477("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        m2477("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        m2477("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        m2477("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        m2477("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        m2477("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        m2477("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        m2477("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        m2477("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        m2477("TLS_PSK_WITH_RC4_128_SHA");
        m2477("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        m2477("TLS_PSK_WITH_AES_128_CBC_SHA");
        m2477("TLS_PSK_WITH_AES_256_CBC_SHA");
        m2477("TLS_RSA_WITH_SEED_CBC_SHA");
        m2477("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        m2477("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        m2477("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        m2477("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        m2477("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        m2477("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        m2477("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        m2477("TLS_FALLBACK_SCSV");
        m2477("TLS_ECDH_ECDSA_WITH_NULL_SHA");
        m2477("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        m2477("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        m2477("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        m2477("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        m2477("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        m2477("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        m2477("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        m2477("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        m2477("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        m2477("TLS_ECDH_RSA_WITH_NULL_SHA");
        m2477("TLS_ECDH_RSA_WITH_RC4_128_SHA");
        m2477("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        m2477("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        m2477("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        m2477("TLS_ECDHE_RSA_WITH_NULL_SHA");
        m2477("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        m2477("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        m2477("TLS_ECDH_anon_WITH_NULL_SHA");
        m2477("TLS_ECDH_anon_WITH_RC4_128_SHA");
        m2477("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        m2477("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        m2477("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        m2477("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        m2477("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        m2477("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        m2477("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        m2477("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        m2477("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        m2477("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        m2477("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        m2477("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        m2477("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        m2477("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        m2477("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        m2477("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        m2477("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        m2477("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        m2477("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
    }

    public CipherSuite(String str) {
        if (str != null) {
            this.f2567 = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: ֏ */
    public static synchronized CipherSuite m2475(String str) {
        CipherSuite r1;
        synchronized (CipherSuite.class) {
            r1 = f2548.get(str);
            if (r1 == null) {
                r1 = f2548.get(m2478(str));
                if (r1 == null) {
                    r1 = new CipherSuite(str);
                }
                f2548.put(str, r1);
            }
        }
        return r1;
    }

    /* renamed from: ؠ */
    public static CipherSuite m2477(String str) {
        CipherSuite r0 = new CipherSuite(str);
        f2548.put(str, r0);
        return r0;
    }

    /* renamed from: ހ */
    public static String m2478(String str) {
        if (str.startsWith("TLS_")) {
            StringBuilder r0 = outline.m2549("SSL_");
            r0.append(str.substring(4));
            return r0.toString();
        } else if (!str.startsWith("SSL_")) {
            return str;
        } else {
            StringBuilder r02 = outline.m2549("TLS_");
            r02.append(str.substring(4));
            return r02.toString();
        }
    }

    public String toString() {
        return this.f2567;
    }

    /* renamed from: ֏ */
    public static List<CipherSuite> m2476(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String r3 : strArr) {
            arrayList.add(m2475(r3));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
