package com.wpengapp.support;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.wpengapp.support.ȕ */
public final class BasicTrustRootIndex implements TrustRootIndex {

    /* renamed from: ֏ */
    public final Map<X500Principal, Set<X509Certificate>> f1084 = new LinkedHashMap();

    public BasicTrustRootIndex(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set set = this.f1084.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet(1);
                this.f1084.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BasicTrustRootIndex) || !((BasicTrustRootIndex) obj).f1084.equals(this.f1084)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f1084.hashCode();
    }

    /* renamed from: ֏ */
    public X509Certificate mo8160(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.f1084.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
