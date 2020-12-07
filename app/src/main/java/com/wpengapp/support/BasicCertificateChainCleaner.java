package com.wpengapp.support;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: com.wpengapp.support.Ⴒ */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {

    /* renamed from: ֏ */
    public final TrustRootIndex f3737;

    public BasicCertificateChainCleaner(TrustRootIndex r1) {
        this.f3737 = r1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BasicCertificateChainCleaner) || !((BasicCertificateChainCleaner) obj).f3737.equals(this.f3737)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f3737.hashCode();
    }

    /* renamed from: ֏ */
    public List<Certificate> mo8445(List<Certificate> list, String str) {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate r4 = this.f3737.mo8160(x509Certificate);
            if (r4 != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(r4)) {
                    arrayList.add(r4);
                }
                if (mo9573(r4, r4)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (mo9573(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException(outline.m2554("Failed to find a trusted cert that signed ", (Object) x509Certificate));
            }
        }
        throw new SSLPeerUnverifiedException(outline.m2554("Certificate chain too long: ", (Object) arrayList));
    }

    /* renamed from: ֏ */
    public final boolean mo9573(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
