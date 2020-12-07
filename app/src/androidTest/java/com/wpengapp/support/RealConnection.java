package com.wpengapp.support;

import android.support.p000v4.internal.view.SupportMenu;
import android.support.p003v7.widget.ActivityChooserView;
import android.support.p003v7.widget.RecyclerView;
import com.wpengapp.support.C0586;
import com.wpengapp.support.Interceptor;
import com.wpengapp.support.Request;
import com.wpengapp.support.Response;
import java.io.EOFException;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: com.wpengapp.support.Ռ */
public final class RealConnection extends C0586.C0588 implements Connection {

    /* renamed from: ؠ */
    public final C1000 f2036;

    /* renamed from: ހ */
    public final Route f2037;

    /* renamed from: ށ */
    public Socket f2038;

    /* renamed from: ނ */
    public Socket f2039;

    /* renamed from: ރ */
    public Handshake f2040;

    /* renamed from: ބ */
    public Protocol f2041;

    /* renamed from: ޅ */
    public C0586 f2042;

    /* renamed from: ކ */
    public BufferedSource f2043;

    /* renamed from: އ */
    public BufferedSink f2044;

    /* renamed from: ވ */
    public boolean f2045;

    /* renamed from: މ */
    public int f2046;

    /* renamed from: ފ */
    public int f2047 = 1;

    /* renamed from: ދ */
    public final List<Reference<StreamAllocation>> f2048 = new ArrayList();

    /* renamed from: ތ */
    public long f2049 = RecyclerView.FOREVER_NS;

    public RealConnection(C1000 r3, Route r4) {
        this.f2036 = r3;
        this.f2037 = r4;
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("Connection{");
        r0.append(this.f2037.f952.f2018.f3310);
        r0.append(":");
        r0.append(this.f2037.f952.f2018.f3311);
        r0.append(", proxy=");
        r0.append(this.f2037.f953);
        r0.append(" hostAddress=");
        r0.append(this.f2037.f954);
        r0.append(" cipherSuite=");
        Handshake r1 = this.f2040;
        r0.append(r1 != null ? r1.f978 : "none");
        r0.append(" protocol=");
        r0.append(this.f2041);
        r0.append('}');
        return r0.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0148, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0148, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0148, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0148, code lost:
        continue;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014c A[EDGE_INSN: B:85:0x014c->B:78:0x014c ?: BREAK  , SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8658(int r17, int r18, int r19, int r20, boolean r21, com.wpengapp.support.Call r22, com.wpengapp.support.C1318 r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            com.wpengapp.support.Č r0 = r7.f2041
            if (r0 != 0) goto L_0x015a
            com.wpengapp.support.Ʈ r0 = r7.f2037
            com.wpengapp.support.Մ r0 = r0.f952
            java.util.List<com.wpengapp.support.थ> r0 = r0.f2023
            com.wpengapp.support.ༀ r10 = new com.wpengapp.support.ༀ
            r10.<init>(r0)
            com.wpengapp.support.Ʈ r1 = r7.f2037
            com.wpengapp.support.Մ r1 = r1.f952
            javax.net.ssl.SSLSocketFactory r2 = r1.f2026
            if (r2 != 0) goto L_0x0056
            com.wpengapp.support.थ r1 = com.wpengapp.support.ConnectionSpec.f2934
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0049
            com.wpengapp.support.Ʈ r0 = r7.f2037
            com.wpengapp.support.Մ r0 = r0.f952
            com.wpengapp.support.ರ r0 = r0.f2018
            java.lang.String r0 = r0.f3310
            com.wpengapp.support.Л r1 = com.wpengapp.support.Platform.f1792
            boolean r1 = r1.mo8442((java.lang.String) r0)
            if (r1 == 0) goto L_0x0036
            goto L_0x0060
        L_0x0036:
            com.wpengapp.support.ȯ r1 = new com.wpengapp.support.ȯ
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.String r3 = "CLEARTEXT communication to "
            java.lang.String r4 = " not permitted by network security policy"
            java.lang.String r0 = com.wpengapp.support.outline.m2545((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r4)
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0049:
            com.wpengapp.support.ȯ r0 = new com.wpengapp.support.ȯ
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0056:
            java.util.List<com.wpengapp.support.Č> r0 = r1.f2022
            com.wpengapp.support.Č r1 = com.wpengapp.support.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x014d
        L_0x0060:
            r11 = 0
            r12 = r11
        L_0x0062:
            com.wpengapp.support.Ʈ r0 = r7.f2037     // Catch:{ IOException -> 0x00d1 }
            boolean r0 = r0.mo8078()     // Catch:{ IOException -> 0x00d1 }
            if (r0 == 0) goto L_0x0083
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.mo8659(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00d1 }
            java.net.Socket r0 = r7.f2038     // Catch:{ IOException -> 0x00d1 }
            if (r0 != 0) goto L_0x007e
            goto L_0x009c
        L_0x007e:
            r13 = r17
            r14 = r18
            goto L_0x008a
        L_0x0083:
            r13 = r17
            r14 = r18
            r7.mo8660((int) r13, (int) r14, (com.wpengapp.support.Call) r8, (com.wpengapp.support.C1318) r9)     // Catch:{ IOException -> 0x00cd }
        L_0x008a:
            r15 = r20
            r7.mo8661((com.wpengapp.support.ConnectionSpecSelector) r10, (int) r15, (com.wpengapp.support.Call) r8, (com.wpengapp.support.C1318) r9)     // Catch:{ IOException -> 0x00cb }
            com.wpengapp.support.Ʈ r0 = r7.f2037     // Catch:{ IOException -> 0x00cb }
            java.net.InetSocketAddress r0 = r0.f954     // Catch:{ IOException -> 0x00cb }
            com.wpengapp.support.Ʈ r1 = r7.f2037     // Catch:{ IOException -> 0x00cb }
            java.net.Proxy r1 = r1.f953     // Catch:{ IOException -> 0x00cb }
            com.wpengapp.support.Č r2 = r7.f2041     // Catch:{ IOException -> 0x00cb }
            r9.mo9599(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00cb }
        L_0x009c:
            com.wpengapp.support.Ʈ r0 = r7.f2037
            boolean r0 = r0.mo8078()
            if (r0 == 0) goto L_0x00b6
            java.net.Socket r0 = r7.f2038
            if (r0 == 0) goto L_0x00a9
            goto L_0x00b6
        L_0x00a9:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            com.wpengapp.support.ȯ r1 = new com.wpengapp.support.ȯ
            r1.<init>(r0)
            throw r1
        L_0x00b6:
            com.wpengapp.support.ʂ r0 = r7.f2042
            if (r0 == 0) goto L_0x00ca
            com.wpengapp.support.ࡖ r1 = r7.f2036
            monitor-enter(r1)
            com.wpengapp.support.ʂ r0 = r7.f2042     // Catch:{ all -> 0x00c7 }
            int r0 = r0.mo8244()     // Catch:{ all -> 0x00c7 }
            r7.f2047 = r0     // Catch:{ all -> 0x00c7 }
            monitor-exit(r1)     // Catch:{ all -> 0x00c7 }
            goto L_0x00ca
        L_0x00c7:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c7 }
            throw r0
        L_0x00ca:
            return
        L_0x00cb:
            r0 = move-exception
            goto L_0x00d7
        L_0x00cd:
            r0 = move-exception
        L_0x00ce:
            r15 = r20
            goto L_0x00d7
        L_0x00d1:
            r0 = move-exception
            r13 = r17
            r14 = r18
            goto L_0x00ce
        L_0x00d7:
            java.net.Socket r1 = r7.f2039
            com.wpengapp.support.Util.m947((java.net.Socket) r1)
            java.net.Socket r1 = r7.f2038
            com.wpengapp.support.Util.m947((java.net.Socket) r1)
            r7.f2039 = r11
            r7.f2038 = r11
            r7.f2043 = r11
            r7.f2044 = r11
            r7.f2040 = r11
            r7.f2041 = r11
            r7.f2042 = r11
            com.wpengapp.support.Ʈ r1 = r7.f2037
            java.net.InetSocketAddress r3 = r1.f954
            java.net.Proxy r4 = r1.f953
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.mo9600(r2, r3, r4, r5, r6)
            r1 = 1
            r2 = 0
            if (r12 != 0) goto L_0x0109
            com.wpengapp.support.ȯ r3 = new com.wpengapp.support.ȯ
            r3.<init>(r0)
            r12 = r3
            goto L_0x0118
        L_0x0109:
            java.io.IOException r3 = r12.f1096
            java.lang.reflect.Method r4 = com.wpengapp.support.Util.f744
            if (r4 == 0) goto L_0x0116
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0116 }
            r5[r2] = r0     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0116 }
            r4.invoke(r3, r5)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0116 }
        L_0x0116:
            r12.f1097 = r0
        L_0x0118:
            if (r21 == 0) goto L_0x014c
            r10.f3525 = r1
            boolean r1 = r10.f3524
            if (r1 != 0) goto L_0x0121
            goto L_0x0148
        L_0x0121:
            boolean r1 = r0 instanceof java.net.ProtocolException
            if (r1 == 0) goto L_0x0126
            goto L_0x0148
        L_0x0126:
            boolean r1 = r0 instanceof java.io.InterruptedIOException
            if (r1 == 0) goto L_0x012b
            goto L_0x0148
        L_0x012b:
            boolean r1 = r0 instanceof javax.net.ssl.SSLHandshakeException
            if (r1 == 0) goto L_0x0138
            java.lang.Throwable r3 = r0.getCause()
            boolean r3 = r3 instanceof java.security.cert.CertificateException
            if (r3 == 0) goto L_0x0138
            goto L_0x0148
        L_0x0138:
            boolean r3 = r0 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r3 == 0) goto L_0x013d
            goto L_0x0148
        L_0x013d:
            if (r1 != 0) goto L_0x0147
            boolean r1 = r0 instanceof javax.net.ssl.SSLProtocolException
            if (r1 != 0) goto L_0x0147
            boolean r0 = r0 instanceof javax.net.ssl.SSLException
            if (r0 == 0) goto L_0x0148
        L_0x0147:
            r2 = 1
        L_0x0148:
            if (r2 == 0) goto L_0x014c
            goto L_0x0062
        L_0x014c:
            throw r12
        L_0x014d:
            com.wpengapp.support.ȯ r0 = new com.wpengapp.support.ȯ
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x015a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.RealConnection.mo8658(int, int, int, int, boolean, com.wpengapp.support.ॾ, com.wpengapp.support.Ⴠ):void");
    }

    /* renamed from: ֏ */
    public final void mo8660(int i, int i2, Call r7, C1318 r8) {
        Socket socket;
        Route r0 = this.f2037;
        Proxy proxy = r0.f953;
        Address r02 = r0.f952;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
            socket = r02.f2020.createSocket();
        } else {
            socket = new Socket(proxy);
        }
        this.f2038 = socket;
        r8.mo9598(r7, this.f2037.f954, proxy);
        this.f2038.setSoTimeout(i2);
        try {
            Platform.f1792.mo8439(this.f2038, this.f2037.f954, i);
            try {
                this.f2043 = C0745.m1951(C0745.m1954(this.f2038));
                this.f2044 = C0745.m1950(C0745.m1952(this.f2038));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder r72 = outline.m2549("Failed to connect to ");
            r72.append(this.f2037.f954);
            ConnectException connectException = new ConnectException(r72.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013e A[Catch:{ all -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0144 A[Catch:{ all -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0147  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo8661(com.wpengapp.support.ConnectionSpecSelector r6, int r7, com.wpengapp.support.Call r8, com.wpengapp.support.C1318 r9) {
        /*
            r5 = this;
            com.wpengapp.support.Ʈ r0 = r5.f2037
            com.wpengapp.support.Մ r0 = r0.f952
            javax.net.ssl.SSLSocketFactory r1 = r0.f2026
            if (r1 != 0) goto L_0x0027
            java.util.List<com.wpengapp.support.Č> r6 = r0.f2022
            com.wpengapp.support.Č r8 = com.wpengapp.support.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r6 = r6.contains(r8)
            if (r6 == 0) goto L_0x001e
            java.net.Socket r6 = r5.f2038
            r5.f2039 = r6
            com.wpengapp.support.Č r6 = com.wpengapp.support.Protocol.H2_PRIOR_KNOWLEDGE
            r5.f2041 = r6
            r5.mo8657((int) r7)
            return
        L_0x001e:
            java.net.Socket r6 = r5.f2038
            r5.f2039 = r6
            com.wpengapp.support.Č r6 = com.wpengapp.support.Protocol.HTTP_1_1
            r5.f2041 = r6
            return
        L_0x0027:
            r9.mo9608(r8)
            com.wpengapp.support.Ʈ r8 = r5.f2037
            com.wpengapp.support.Մ r8 = r8.f952
            javax.net.ssl.SSLSocketFactory r9 = r8.f2026
            r0 = 0
            java.net.Socket r1 = r5.f2038     // Catch:{ AssertionError -> 0x0137 }
            com.wpengapp.support.ರ r2 = r8.f2018     // Catch:{ AssertionError -> 0x0137 }
            java.lang.String r3 = r2.f3310     // Catch:{ AssertionError -> 0x0137 }
            int r2 = r2.f3311     // Catch:{ AssertionError -> 0x0137 }
            r4 = 1
            java.net.Socket r9 = r9.createSocket(r1, r3, r2, r4)     // Catch:{ AssertionError -> 0x0137 }
            javax.net.ssl.SSLSocket r9 = (javax.net.ssl.SSLSocket) r9     // Catch:{ AssertionError -> 0x0137 }
            com.wpengapp.support.थ r6 = r6.mo9489(r9)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            boolean r1 = r6.mo9137()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            if (r1 == 0) goto L_0x0055
            com.wpengapp.support.Л r1 = com.wpengapp.support.Platform.f1792     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.ರ r2 = r8.f2018     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r2 = r2.f3310     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.util.List<com.wpengapp.support.Č> r3 = r8.f2022     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r1.mo8146((javax.net.ssl.SSLSocket) r9, (java.lang.String) r2, (java.util.List<com.wpengapp.support.Protocol>) r3)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
        L_0x0055:
            r9.startHandshake()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            javax.net.ssl.SSLSession r1 = r9.getSession()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.ǎ r2 = com.wpengapp.support.Handshake.m1244(r1)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            javax.net.ssl.HostnameVerifier r3 = r8.mo8644()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.ರ r4 = r8.f2018     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r4 = r4.f3310     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            boolean r1 = r3.verify(r4, r1)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            if (r1 != 0) goto L_0x00de
            java.util.List<java.security.cert.Certificate> r6 = r2.f979     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            boolean r7 = r6.isEmpty()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r0 = "Hostname "
            if (r7 != 0) goto L_0x00c0
            r7 = 0
            java.lang.Object r6 = r6.get(r7)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            javax.net.ssl.SSLPeerUnverifiedException r7 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r1.<init>()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r1.append(r0)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.ರ r8 = r8.f2018     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r8 = r8.f3310     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r1.append(r8)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r8 = " not verified:\n    certificate: "
            r1.append(r8)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r8 = com.wpengapp.support.CertificatePinner.m2461(r6)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r1.append(r8)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r8 = "\n    DN: "
            r1.append(r8)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.security.Principal r8 = r6.getSubjectDN()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r8 = r8.getName()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r1.append(r8)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r8 = "\n    subjectAltNames: "
            r1.append(r8)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.util.List r6 = com.wpengapp.support.OkHostnameVerifier.m3180(r6)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r6 = r1.toString()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r7.<init>(r6)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            throw r7     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
        L_0x00c0:
            javax.net.ssl.SSLPeerUnverifiedException r6 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r7.<init>()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r7.append(r0)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.ರ r8 = r8.f2018     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r8 = r8.f3310     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r7.append(r8)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r8 = " not verified (no certificates)"
            r7.append(r8)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r7 = r7.toString()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r6.<init>(r7)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            throw r6     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
        L_0x00de:
            com.wpengapp.support.ݩ r1 = r8.mo8642()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.ರ r8 = r8.f2018     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r8 = r8.f3310     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.util.List<java.security.cert.Certificate> r3 = r2.f979     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r1.mo8946(r8, r3)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            boolean r6 = r6.mo9137()     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            if (r6 == 0) goto L_0x00f7
            com.wpengapp.support.Л r6 = com.wpengapp.support.Platform.f1792     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.lang.String r0 = r6.mo8148((javax.net.ssl.SSLSocket) r9)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
        L_0x00f7:
            r5.f2039 = r9     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.net.Socket r6 = r5.f2039     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.Ɔ r6 = com.wpengapp.support.C0745.m1954(r6)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.ਟ r6 = com.wpengapp.support.C0745.m1951((com.wpengapp.support.Source) r6)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r5.f2043 = r6     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            java.net.Socket r6 = r5.f2039     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.อ r6 = com.wpengapp.support.C0745.m1952((java.net.Socket) r6)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.ǡ r6 = com.wpengapp.support.C0745.m1950((com.wpengapp.support.Sink) r6)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r5.f2044 = r6     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            r5.f2040 = r2     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            if (r0 == 0) goto L_0x011a
            com.wpengapp.support.Č r6 = com.wpengapp.support.Protocol.m977(r0)     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            goto L_0x011c
        L_0x011a:
            com.wpengapp.support.Č r6 = com.wpengapp.support.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
        L_0x011c:
            r5.f2041 = r6     // Catch:{ AssertionError -> 0x0131, all -> 0x012f }
            com.wpengapp.support.Л r6 = com.wpengapp.support.Platform.f1792
            r6.mo8469((javax.net.ssl.SSLSocket) r9)
            com.wpengapp.support.ǎ r6 = r5.f2040
            com.wpengapp.support.Č r6 = r5.f2041
            com.wpengapp.support.Č r8 = com.wpengapp.support.Protocol.HTTP_2
            if (r6 != r8) goto L_0x012e
            r5.mo8657((int) r7)
        L_0x012e:
            return
        L_0x012f:
            r6 = move-exception
            goto L_0x0145
        L_0x0131:
            r6 = move-exception
            r0 = r9
            goto L_0x0138
        L_0x0134:
            r6 = move-exception
            r9 = r0
            goto L_0x0145
        L_0x0137:
            r6 = move-exception
        L_0x0138:
            boolean r7 = com.wpengapp.support.Util.m949((java.lang.AssertionError) r6)     // Catch:{ all -> 0x0134 }
            if (r7 == 0) goto L_0x0144
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0134 }
            r7.<init>(r6)     // Catch:{ all -> 0x0134 }
            throw r7     // Catch:{ all -> 0x0134 }
        L_0x0144:
            throw r6     // Catch:{ all -> 0x0134 }
        L_0x0145:
            if (r9 == 0) goto L_0x014c
            com.wpengapp.support.Л r7 = com.wpengapp.support.Platform.f1792
            r7.mo8469((javax.net.ssl.SSLSocket) r9)
        L_0x014c:
            com.wpengapp.support.Util.m947((java.net.Socket) r9)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.RealConnection.mo8661(com.wpengapp.support.ༀ, int, com.wpengapp.support.ॾ, com.wpengapp.support.Ⴠ):void");
    }

    /* renamed from: ֏ */
    public final void mo8657(int i) {
        this.f2039.setSoTimeout(0);
        C0586.C0587 r0 = new C0586.C0587(true);
        Socket socket = this.f2039;
        String str = this.f2037.f952.f2018.f3310;
        BufferedSource r4 = this.f2043;
        BufferedSink r5 = this.f2044;
        r0.f1298 = socket;
        r0.f1299 = str;
        r0.f1300 = r4;
        r0.f1301 = r5;
        r0.f1302 = this;
        r0.f1305 = i;
        this.f2042 = new C0586(r0);
        C0586 r7 = this.f2042;
        r7.f1295.mo9459();
        r7.f1295.mo9458(r7.f1292);
        int r02 = r7.f1292.mo9620();
        if (r02 != 65535) {
            r7.f1295.mo9449(0, (long) (r02 - SupportMenu.USER_MASK));
        }
        new Thread(r7.f1296).start();
    }

    /* renamed from: ֏ */
    public final void mo8659(int i, int i2, int i3, Call r14, C1318 r15) {
        Request.C0874 r0 = new Request.C0874();
        r0.mo8832(this.f2037.f952.f2018);
        r0.mo8834("CONNECT", (RequestBody) null);
        r0.f2372.mo8183("Host", Util.m935(this.f2037.f952.f2018, true));
        r0.f2372.mo8183("Proxy-Connection", "Keep-Alive");
        r0.f2372.mo8183("User-Agent", "okhttp/3.12.6");
        Request r02 = r0.mo8835();
        Response.C0600 r2 = new Response.C0600();
        r2.f1361 = r02;
        r2.f1362 = Protocol.HTTP_1_1;
        r2.f1363 = 407;
        r2.f1364 = "Preemptive Authenticate";
        r2.f1367 = Util.f731;
        r2.f1371 = -1;
        r2.f1372 = -1;
        r2.f1366.mo8183("Proxy-Authenticate", "OkHttp-Preemptive");
        Response r22 = r2.mo8279();
        Route r7 = this.f2037;
        ((Authenticator) r7.f952.f2021).mo7940(r7, r22);
        HttpUrl r23 = r02.f2364;
        mo8660(i, i2, r14, r15);
        C1126 r142 = new C1126((C0844) null, (StreamAllocation) null, this.f2043, this.f2044);
        this.f2043.mo7988().mo9111((long) i2, TimeUnit.MILLISECONDS);
        this.f2044.mo7986().mo9111((long) i3, TimeUnit.MILLISECONDS);
        r142.mo9311(r02.f2366, "CONNECT " + Util.m935(r23, true) + " HTTP/1.1");
        r142.f3199.flush();
        int i4 = r142.f3200;
        if (i4 == 1 || i4 == 3) {
            try {
                StatusLine r11 = StatusLine.m3036(r142.mo9313());
                Response.C0600 r13 = new Response.C0600();
                r13.f1362 = r11.f3225;
                r13.f1363 = r11.f3226;
                r13.f1364 = r11.f3227;
                r13.mo8277(r142.mo9314());
                if (r11.f3226 == 100) {
                    r142.f3200 = 3;
                } else {
                    r142.f3200 = 4;
                }
                r13.f1361 = r02;
                Response r112 = r13.mo8279();
                long r12 = HttpHeaders.m1355(r112);
                if (r12 == -1) {
                    r12 = 0;
                }
                Source r122 = r142.mo9310(r12);
                Util.m956(r122, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
                r122.close();
                int i5 = r112.f1351;
                if (i5 != 200) {
                    if (i5 == 407) {
                        Route r123 = this.f2037;
                        ((Authenticator) r123.f952.f2021).mo7940(r123, r112);
                        throw new IOException("Failed to authenticate with proxy");
                    }
                    StringBuilder r132 = outline.m2549("Unexpected response code for CONNECT: ");
                    r132.append(r112.f1351);
                    throw new IOException(r132.toString());
                } else if (!this.f2043.mo8487().mo8493() || !this.f2044.mo8112().mo8493()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
            } catch (EOFException e) {
                StringBuilder r133 = outline.m2549("unexpected end of stream on ");
                r133.append(r142.f3197);
                IOException iOException = new IOException(r133.toString());
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            StringBuilder r124 = outline.m2549("state: ");
            r124.append(r142.f3200);
            throw new IllegalStateException(r124.toString());
        }
    }

    /* renamed from: ֏ */
    public boolean mo8663(Address r5, Route r6) {
        if (this.f2048.size() >= this.f2047 || this.f2045 || !Internal.f1914.mo7920(this.f2037.f952, r5)) {
            return false;
        }
        if (r5.f2018.f3310.equals(this.f2037.f952.f2018.f3310)) {
            return true;
        }
        if (this.f2042 == null || r6 == null || r6.f953.type() != Proxy.Type.DIRECT || this.f2037.f953.type() != Proxy.Type.DIRECT || !this.f2037.f954.equals(r6.f954) || r6.f952.f2027 != OkHostnameVerifier.f3353 || !mo8664(r5.f2018)) {
            return false;
        }
        try {
            r5.f2028.mo8946(r5.f2018.f3310, this.f2040.f979);
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: ֏ */
    public boolean mo8664(HttpUrl r5) {
        int i = r5.f3311;
        HttpUrl r1 = this.f2037.f952.f2018;
        if (i != r1.f3311) {
            return false;
        }
        if (r5.f3310.equals(r1.f3310)) {
            return true;
        }
        Handshake r0 = this.f2040;
        if (r0 == null || !OkHostnameVerifier.f3353.verify(r5.f3310, (X509Certificate) r0.f979.get(0))) {
            return false;
        }
        return true;
    }

    /* renamed from: ֏ */
    public HttpCodec mo8656(C0844 r5, Interceptor.C1094 r6, StreamAllocation r7) {
        C0586 r0 = this.f2042;
        if (r0 != null) {
            return new Http2Codec(r5, r6, r7, r0);
        }
        RealInterceptorChain r62 = (RealInterceptorChain) r6;
        this.f2039.setSoTimeout(r62.f3291);
        this.f2043.mo7988().mo9111((long) r62.f3291, TimeUnit.MILLISECONDS);
        this.f2044.mo7986().mo9111((long) r62.f3292, TimeUnit.MILLISECONDS);
        return new C1126(r5, r7, this.f2043, this.f2044);
    }

    /* renamed from: ֏ */
    public void mo8245(Http2Stream r2) {
        r2.mo8121(C1193.REFUSED_STREAM);
    }

    /* renamed from: ֏ */
    public void mo8246(C0586 r2) {
        synchronized (this.f2036) {
            this.f2047 = r2.mo8244();
        }
    }

    /* renamed from: ֏ */
    public boolean mo8662() {
        return this.f2042 != null;
    }
}
