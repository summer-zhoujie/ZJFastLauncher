package com.wpengapp.support;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: com.wpengapp.support.ݩ */
public final class CertificatePinner {

    /* renamed from: ֏ */
    public static final CertificatePinner f2536 = new CertificatePinner(new LinkedHashSet(new ArrayList()), (CertificateChainCleaner) null);

    /* renamed from: ؠ */
    public final Set<C0935> f2537;

    /* renamed from: ހ */
    public final CertificateChainCleaner f2538;

    /* renamed from: com.wpengapp.support.ݩ$֏ */
    /* compiled from: CertificatePinner */
    static final class C0935 {

        /* renamed from: ֏ */
        public final String f2539;

        /* renamed from: ؠ */
        public final String f2540;

        /* renamed from: ހ */
        public final String f2541;

        /* renamed from: ށ */
        public final ByteString f2542;

        public boolean equals(Object obj) {
            if (obj instanceof C0935) {
                C0935 r3 = (C0935) obj;
                return this.f2539.equals(r3.f2539) && this.f2541.equals(r3.f2541) && this.f2542.equals(r3.f2542);
            }
        }

        public int hashCode() {
            int hashCode = this.f2541.hashCode();
            return this.f2542.hashCode() + ((hashCode + ((this.f2539.hashCode() + 527) * 31)) * 31);
        }

        public String toString() {
            return this.f2541 + this.f2542.mo7994();
        }
    }

    public CertificatePinner(Set<C0935> set, CertificateChainCleaner r2) {
        this.f2537 = set;
        this.f2538 = r2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner r4 = (CertificatePinner) obj;
            if (!Util.m950((Object) this.f2538, (Object) r4.f2538) || !this.f2537.equals(r4.f2537)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        CertificateChainCleaner r0 = this.f2538;
        return this.f2537.hashCode() + ((r0 != null ? r0.hashCode() : 0) * 31);
    }

    /* renamed from: ֏ */
    public void mo8946(String str, List<Certificate> list) {
        int i;
        List emptyList = Collections.emptyList();
        Iterator<C0935> it = this.f2537.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            C0935 next = it.next();
            if (next.f2539.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == next.f2540.length()) {
                    String str2 = next.f2540;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        i = 1;
                    }
                }
            } else {
                i = str.equals(next.f2540);
            }
            if (i != 0) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(next);
            }
        }
        if (!emptyList.isEmpty()) {
            CertificateChainCleaner r1 = this.f2538;
            if (r1 != null) {
                list = r1.mo8445(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = emptyList.size();
                ByteString r6 = null;
                ByteString r8 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    C0935 r9 = (C0935) emptyList.get(i3);
                    if (r9.f2541.equals("sha256/")) {
                        if (r6 == null) {
                            r6 = ByteString.m2187(x509Certificate.getPublicKey().getEncoded()).mo8001();
                        }
                        if (r9.f2542.equals(r6)) {
                            return;
                        }
                    } else if (r9.f2541.equals("sha1/")) {
                        if (r8 == null) {
                            r8 = ByteString.m2187(x509Certificate.getPublicKey().getEncoded()).mo8000();
                        }
                        if (r9.f2542.equals(r8)) {
                            return;
                        }
                    } else {
                        StringBuilder r15 = outline.m2549("unsupported hashAlgorithm: ");
                        r15.append(r9.f2541);
                        throw new AssertionError(r15.toString());
                    }
                }
            }
            StringBuilder r12 = outline.m2550("Certificate pinning failure!", "\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                r12.append("\n    ");
                r12.append(m2461(x509Certificate2));
                r12.append(": ");
                r12.append(x509Certificate2.getSubjectDN().getName());
            }
            r12.append("\n  Pinned certificates for ");
            r12.append(str);
            r12.append(":");
            int size4 = emptyList.size();
            while (i < size4) {
                r12.append("\n    ");
                r12.append((C0935) emptyList.get(i));
                i++;
            }
            throw new SSLPeerUnverifiedException(r12.toString());
        }
    }

    /* renamed from: ֏ */
    public static String m2461(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder r0 = outline.m2549("sha256/");
            r0.append(ByteString.m2187(((X509Certificate) certificate).getPublicKey().getEncoded()).mo8001().mo7994());
            return r0.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
}
