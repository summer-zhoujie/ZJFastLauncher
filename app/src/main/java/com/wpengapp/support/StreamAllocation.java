package com.wpengapp.support;

import com.wpengapp.support.Interceptor;
import com.wpengapp.support.RouteSelector;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: com.wpengapp.support.ܥ */
public final class StreamAllocation {

    /* renamed from: ֏ */
    public final Address f2495;

    /* renamed from: ؠ */
    public RouteSelector.C0580 f2496;

    /* renamed from: ހ */
    public Route f2497;

    /* renamed from: ށ */
    public final C1000 f2498;

    /* renamed from: ނ */
    public final Call f2499;

    /* renamed from: ރ */
    public final C1318 f2500;

    /* renamed from: ބ */
    public final Object f2501;

    /* renamed from: ޅ */
    public final RouteSelector f2502;

    /* renamed from: ކ */
    public int f2503;

    /* renamed from: އ */
    public RealConnection f2504;

    /* renamed from: ވ */
    public boolean f2505;

    /* renamed from: މ */
    public boolean f2506;

    /* renamed from: ފ */
    public boolean f2507;

    /* renamed from: ދ */
    public HttpCodec f2508;

    /* renamed from: com.wpengapp.support.ܥ$֏ */
    /* compiled from: StreamAllocation */
    public static final class C0923 extends WeakReference<StreamAllocation> {

        /* renamed from: ֏ */
        public final Object f2509;

        public C0923(StreamAllocation r1, Object obj) {
            super(r1);
            this.f2509 = obj;
        }
    }

    public StreamAllocation(C1000 r3, Address r4, Call r5, C1318 r6, Object obj) {
        this.f2498 = r3;
        this.f2495 = r4;
        this.f2499 = r5;
        this.f2500 = r6;
        this.f2502 = new RouteSelector(r4, Internal.f1914.mo7914(this.f2498), r5, r6);
        this.f2501 = obj;
    }

    public String toString() {
        RealConnection r0 = mo8927();
        if (r0 == null) {
            return this.f2495.toString();
        }
        StringBuilder r1 = outline.m2549("Connection{");
        r1.append(r0.f2037.f952.f2018.f3310);
        r1.append(":");
        r1.append(r0.f2037.f952.f2018.f3311);
        r1.append(", proxy=");
        r1.append(r0.f2037.f953);
        r1.append(" hostAddress=");
        r1.append(r0.f2037.f954);
        r1.append(" cipherSuite=");
        Handshake r2 = r0.f2040;
        r1.append(r2 != null ? r2.f978 : "none");
        r1.append(" protocol=");
        r1.append(r0.f2041);
        r1.append('}');
        return r1.toString();
    }

    /* renamed from: ֏ */
    public HttpCodec mo8920(C0844 r9, Interceptor.C1094 r10, boolean z) {
        RealInterceptorChain r0 = (RealInterceptorChain) r10;
        try {
            HttpCodec r92 = mo8919(((RealInterceptorChain) r10).f3290, r0.f3291, r0.f3292, r9.f2258, r9.f2253, z).mo8656(r9, r10, this);
            synchronized (this.f2498) {
                this.f2508 = r92;
            }
            return r92;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* renamed from: ؠ */
    public HttpCodec mo8926() {
        HttpCodec r1;
        synchronized (this.f2498) {
            r1 = this.f2508;
        }
        return r1;
    }

    /* renamed from: ހ */
    public synchronized RealConnection mo8927() {
        return this.f2504;
    }

    /* renamed from: ށ */
    public void mo8928() {
        RealConnection r1;
        Socket r2;
        synchronized (this.f2498) {
            r1 = this.f2504;
            r2 = mo8921(true, false, false);
            if (this.f2504 != null) {
                r1 = null;
            }
        }
        Util.m947(r2);
        if (r1 != null) {
            this.f2500.mo9603(this.f2499, (Connection) r1);
        }
    }

    /* renamed from: ނ */
    public void mo8929() {
        RealConnection r1;
        Socket r2;
        synchronized (this.f2498) {
            r1 = this.f2504;
            r2 = mo8921(false, true, false);
            if (this.f2504 != null) {
                r1 = null;
            }
        }
        Util.m947(r2);
        if (r1 != null) {
            Internal.f1914.mo7915(this.f2499, (IOException) null);
            this.f2500.mo9603(this.f2499, (Connection) r1);
            this.f2500.mo9590(this.f2499);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0.f2039.isInputShutdown() != false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r0.f2039.isOutputShutdown() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        r1 = r0.f2042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r1 == null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r2 = !r1.mo8243();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r12 == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1 = r0.f2039.getSoTimeout();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.f2039.setSoTimeout(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r0.f2043.mo8493() == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.f2039.setSoTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004f, code lost:
        r0.f2039.setSoTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        r0.f2039.setSoTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r0.f2039.isClosed() != false) goto L_0x005d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005f A[LOOP:0: B:0:0x0000->B:33:0x005f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0063 A[SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final RealConnection mo8919(int r7, int r8, int r9, int r10, boolean r11, boolean r12) {
        /*
            r6 = this;
        L_0x0000:
            com.wpengapp.support.Ռ r0 = r6.mo8918(r7, r8, r9, r10, r11)
            com.wpengapp.support.ࡖ r1 = r6.f2498
            monitor-enter(r1)
            int r2 = r0.f2046     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0064 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0064 }
            java.net.Socket r1 = r0.f2039
            boolean r1 = r1.isClosed()
            r2 = 0
            if (r1 != 0) goto L_0x005d
            java.net.Socket r1 = r0.f2039
            boolean r1 = r1.isInputShutdown()
            if (r1 != 0) goto L_0x005d
            java.net.Socket r1 = r0.f2039
            boolean r1 = r1.isOutputShutdown()
            if (r1 == 0) goto L_0x0028
            goto L_0x005d
        L_0x0028:
            com.wpengapp.support.ʂ r1 = r0.f2042
            r3 = 1
            if (r1 == 0) goto L_0x0034
            boolean r1 = r1.mo8243()
            r2 = r1 ^ 1
            goto L_0x005d
        L_0x0034:
            if (r12 == 0) goto L_0x005c
            java.net.Socket r1 = r0.f2039     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            int r1 = r1.getSoTimeout()     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            java.net.Socket r4 = r0.f2039     // Catch:{ all -> 0x0055 }
            r4.setSoTimeout(r3)     // Catch:{ all -> 0x0055 }
            com.wpengapp.support.ਟ r4 = r0.f2043     // Catch:{ all -> 0x0055 }
            boolean r4 = r4.mo8493()     // Catch:{ all -> 0x0055 }
            if (r4 == 0) goto L_0x004f
            java.net.Socket r4 = r0.f2039     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            r4.setSoTimeout(r1)     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            goto L_0x005d
        L_0x004f:
            java.net.Socket r4 = r0.f2039     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            r4.setSoTimeout(r1)     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            goto L_0x005c
        L_0x0055:
            r4 = move-exception
            java.net.Socket r5 = r0.f2039     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            r5.setSoTimeout(r1)     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            throw r4     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
        L_0x005c:
            r2 = 1
        L_0x005d:
            if (r2 != 0) goto L_0x0063
            r6.mo8928()
            goto L_0x0000
        L_0x0063:
            return r0
        L_0x0064:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0064 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.StreamAllocation.mo8919(int, int, int, int, boolean, boolean):com.wpengapp.support.Ռ");
    }

    /* renamed from: ֏ */
    public final RealConnection mo8918(int i, int i2, int i3, int i4, boolean z) {
        Route r4;
        Socket r3;
        RealConnection r7;
        RealConnection r0;
        boolean z2;
        boolean z3;
        RealConnection r32;
        Socket socket;
        RouteSelector.C0580 r2;
        String str;
        int i5;
        synchronized (this.f2498) {
            if (this.f2506) {
                throw new IllegalStateException("released");
            } else if (this.f2508 != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.f2507) {
                RealConnection r02 = this.f2504;
                RealConnection r33 = this.f2504;
                r4 = null;
                r3 = (r33 == null || !r33.f2045) ? null : mo8921(false, false, true);
                if (this.f2504 != null) {
                    r0 = this.f2504;
                    r7 = null;
                } else {
                    r7 = r02;
                    r0 = null;
                }
                if (!this.f2505) {
                    r7 = null;
                }
                if (r0 == null) {
                    Internal.f1914.mo7913(this.f2498, this.f2495, this, (Route) null);
                    if (this.f2504 != null) {
                        r0 = this.f2504;
                        z2 = true;
                    } else {
                        r4 = this.f2497;
                    }
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        Util.m947(r3);
        if (r7 != null) {
            this.f2500.mo9603(this.f2499, (Connection) r7);
        }
        if (z2) {
            this.f2500.mo9594(this.f2499, (Connection) r0);
        }
        if (r0 != null) {
            this.f2497 = this.f2504.f2037;
            return r0;
        }
        if (r4 != null || ((r2 = this.f2496) != null && r2.mo8215())) {
            z3 = false;
        } else {
            RouteSelector r22 = this.f2502;
            if (r22.mo8212()) {
                ArrayList arrayList = new ArrayList();
                while (r22.mo8213()) {
                    if (r22.mo8213()) {
                        List<Proxy> list = r22.f1255;
                        int i6 = r22.f1256;
                        r22.f1256 = i6 + 1;
                        Proxy proxy = list.get(i6);
                        r22.f1257 = new ArrayList();
                        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                            HttpUrl r10 = r22.f1251.f2018;
                            str = r10.f3310;
                            i5 = r10.f3311;
                        } else {
                            SocketAddress address = proxy.address();
                            if (address instanceof InetSocketAddress) {
                                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                                InetAddress address2 = inetSocketAddress.getAddress();
                                if (address2 == null) {
                                    str = inetSocketAddress.getHostName();
                                } else {
                                    str = address2.getHostAddress();
                                }
                                i5 = inetSocketAddress.getPort();
                            } else {
                                StringBuilder r23 = outline.m2549("Proxy.address() is not an InetSocketAddress: ");
                                r23.append(address.getClass());
                                throw new IllegalArgumentException(r23.toString());
                            }
                        }
                        if (i5 >= 1 && i5 <= 65535) {
                            if (proxy.type() == Proxy.Type.SOCKS) {
                                r22.f1257.add(InetSocketAddress.createUnresolved(str, i5));
                            } else {
                                r22.f1254.mo9596(r22.f1253, str);
                                List<InetAddress> r9 = ((Dns) r22.f1251.f2019).mo8427(str);
                                if (!r9.isEmpty()) {
                                    r22.f1254.mo9597(r22.f1253, str, r9);
                                    int size = r9.size();
                                    for (int i7 = 0; i7 < size; i7++) {
                                        r22.f1257.add(new InetSocketAddress(r9.get(i7), i5));
                                    }
                                } else {
                                    throw new UnknownHostException(r22.f1251.f2019 + " returned no addresses for " + str);
                                }
                            }
                            int size2 = r22.f1257.size();
                            for (int i8 = 0; i8 < size2; i8++) {
                                Route r11 = new Route(r22.f1251, proxy, r22.f1257.get(i8));
                                if (r22.f1252.mo9055(r11)) {
                                    r22.f1258.add(r11);
                                } else {
                                    arrayList.add(r11);
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                break;
                            }
                        } else {
                            throw new SocketException("No route to " + str + ":" + i5 + "; port is out of range");
                        }
                    } else {
                        StringBuilder r34 = outline.m2549("No route to ");
                        r34.append(r22.f1251.f2018.f3310);
                        r34.append("; exhausted proxy configurations: ");
                        r34.append(r22.f1255);
                        throw new SocketException(r34.toString());
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.addAll(r22.f1258);
                    r22.f1258.clear();
                }
                this.f2496 = new RouteSelector.C0580(arrayList);
                z3 = true;
            } else {
                throw new NoSuchElementException();
            }
        }
        synchronized (this.f2498) {
            if (!this.f2507) {
                if (z3) {
                    List<Route> r24 = this.f2496.mo8214();
                    int size3 = r24.size();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= size3) {
                            break;
                        }
                        Route r102 = r24.get(i9);
                        Internal.f1914.mo7913(this.f2498, this.f2495, this, r102);
                        if (this.f2504 != null) {
                            r0 = this.f2504;
                            this.f2497 = r102;
                            z2 = true;
                            break;
                        }
                        i9++;
                    }
                }
                if (!z2) {
                    if (r4 == null) {
                        RouteSelector.C0580 r03 = this.f2496;
                        if (r03.mo8215()) {
                            List<Route> list2 = r03.f1259;
                            int i10 = r03.f1260;
                            r03.f1260 = i10 + 1;
                            r4 = list2.get(i10);
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                    this.f2497 = r4;
                    this.f2503 = 0;
                    r0 = new RealConnection(this.f2498, r4);
                    mo8923(r0, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.f2500.mo9594(this.f2499, (Connection) r0);
            return r0;
        }
        r0.mo8658(i, i2, i3, i4, z, this.f2499, this.f2500);
        Internal.f1914.mo7914(this.f2498).mo9053(r0.f2037);
        synchronized (this.f2498) {
            this.f2505 = true;
            Internal.f1914.mo7922(this.f2498, r0);
            if (r0.mo8662()) {
                socket = Internal.f1914.mo7916(this.f2498, this.f2495, this);
                r32 = this.f2504;
            } else {
                r32 = r0;
                socket = null;
            }
        }
        Util.m947(socket);
        this.f2500.mo9594(this.f2499, (Connection) r32);
        return r32;
    }

    /* renamed from: ֏ */
    public void mo8925(boolean z, HttpCodec r4, long j, IOException iOException) {
        RealConnection r6;
        Socket r3;
        boolean z2;
        this.f2500.mo9602(this.f2499, j);
        synchronized (this.f2498) {
            if (r4 != null) {
                if (r4 == this.f2508) {
                    if (!z) {
                        this.f2504.f2046++;
                    }
                    r6 = this.f2504;
                    r3 = mo8921(z, false, true);
                    if (this.f2504 != null) {
                        r6 = null;
                    }
                    z2 = this.f2506;
                }
            }
            throw new IllegalStateException("expected " + this.f2508 + " but was " + r4);
        }
        Util.m947(r3);
        if (r6 != null) {
            this.f2500.mo9603(this.f2499, (Connection) r6);
        }
        if (iOException != null) {
            this.f2500.mo9595(this.f2499, Internal.f1914.mo7915(this.f2499, iOException));
        } else if (z2) {
            Internal.f1914.mo7915(this.f2499, (IOException) null);
            this.f2500.mo9590(this.f2499);
        }
    }

    /* renamed from: ֏ */
    public final Socket mo8921(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.f2508 = null;
        }
        if (z2) {
            this.f2506 = true;
        }
        RealConnection r4 = this.f2504;
        if (r4 != null) {
            if (z) {
                r4.f2045 = true;
            }
            if (this.f2508 == null && (this.f2506 || this.f2504.f2045)) {
                RealConnection r3 = this.f2504;
                int size = r3.f2048.size();
                for (int i = 0; i < size; i++) {
                    if (r3.f2048.get(i).get() == this) {
                        r3.f2048.remove(i);
                        if (this.f2504.f2048.isEmpty()) {
                            this.f2504.f2049 = System.nanoTime();
                            if (Internal.f1914.mo7921(this.f2498, this.f2504)) {
                                socket = this.f2504.f2039;
                                this.f2504 = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.f2504 = null;
                        return socket;
                    }
                }
                throw new IllegalStateException();
            }
        }
        return null;
    }

    /* renamed from: ֏ */
    public void mo8922() {
        HttpCodec r1;
        RealConnection r2;
        synchronized (this.f2498) {
            this.f2507 = true;
            r1 = this.f2508;
            r2 = this.f2504;
        }
        if (r1 != null) {
            r1.cancel();
        } else if (r2 != null) {
            Util.m947(r2.f2038);
        }
    }

    /* renamed from: ֏ */
    public void mo8924(IOException iOException) {
        boolean z;
        RealConnection r1;
        Socket r7;
        synchronized (this.f2498) {
            if (iOException instanceof StreamResetException) {
                C1193 r72 = ((StreamResetException) iOException).f1865;
                if (r72 == C1193.REFUSED_STREAM) {
                    this.f2503++;
                    if (this.f2503 > 1) {
                        this.f2497 = null;
                    }
                    z = false;
                    r1 = this.f2504;
                    r7 = mo8921(z, false, true);
                    if (this.f2504 != null || !this.f2505) {
                        r1 = null;
                    }
                } else {
                    if (r72 != C1193.CANCEL) {
                        this.f2497 = null;
                    }
                    z = false;
                    r1 = this.f2504;
                    r7 = mo8921(z, false, true);
                    r1 = null;
                }
            } else {
                if (this.f2504 != null && (!this.f2504.mo8662() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.f2504.f2046 == 0) {
                        if (!(this.f2497 == null || iOException == null)) {
                            this.f2502.mo8211(this.f2497, iOException);
                        }
                        this.f2497 = null;
                    }
                }
                z = false;
                r1 = this.f2504;
                r7 = mo8921(z, false, true);
                r1 = null;
            }
            z = true;
            r1 = this.f2504;
            r7 = mo8921(z, false, true);
            r1 = null;
        }
        Util.m947(r7);
        if (r1 != null) {
            this.f2500.mo9603(this.f2499, (Connection) r1);
        }
    }

    /* renamed from: ֏ */
    public void mo8923(RealConnection r2, boolean z) {
        if (this.f2504 == null) {
            this.f2504 = r2;
            this.f2505 = z;
            r2.f2048.add(new C0923(this, this.f2501));
            return;
        }
        throw new IllegalStateException();
    }
}
