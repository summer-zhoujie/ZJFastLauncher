package com.wpengapp.support;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.wpengapp.support.ɵ */
public final class RouteSelector {

    /* renamed from: ֏ */
    public final Address f1251;

    /* renamed from: ؠ */
    public final RouteDatabase f1252;

    /* renamed from: ހ */
    public final Call f1253;

    /* renamed from: ށ */
    public final C1318 f1254;

    /* renamed from: ނ */
    public List<Proxy> f1255 = Collections.emptyList();

    /* renamed from: ރ */
    public int f1256;

    /* renamed from: ބ */
    public List<InetSocketAddress> f1257 = Collections.emptyList();

    /* renamed from: ޅ */
    public final List<Route> f1258 = new ArrayList();

    /* renamed from: com.wpengapp.support.ɵ$֏ */
    /* compiled from: RouteSelector */
    public static final class C0580 {

        /* renamed from: ֏ */
        public final List<Route> f1259;

        /* renamed from: ؠ */
        public int f1260 = 0;

        public C0580(List<Route> list) {
            this.f1259 = list;
        }

        /* renamed from: ֏ */
        public List<Route> mo8214() {
            return new ArrayList(this.f1259);
        }

        /* renamed from: ؠ */
        public boolean mo8215() {
            return this.f1260 < this.f1259.size();
        }
    }

    public RouteSelector(Address r2, RouteDatabase r3, Call r4, C1318 r5) {
        List<Proxy> list;
        this.f1251 = r2;
        this.f1252 = r3;
        this.f1253 = r4;
        this.f1254 = r5;
        HttpUrl r32 = r2.f2018;
        Proxy proxy = r2.f2025;
        if (proxy != null) {
            this.f1255 = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f1251.f2024.select(r32.mo9372());
            if (select == null || select.isEmpty()) {
                list = Util.m941((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = Util.m940(select);
            }
            this.f1255 = list;
        }
        this.f1256 = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.f1251;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8211(Route r4, java.io.IOException r5) {
        /*
            r3 = this;
            java.net.Proxy r0 = r4.f953
            java.net.Proxy$Type r0 = r0.type()
            java.net.Proxy$Type r1 = java.net.Proxy.Type.DIRECT
            if (r0 == r1) goto L_0x001f
            com.wpengapp.support.Մ r0 = r3.f1251
            java.net.ProxySelector r1 = r0.f2024
            if (r1 == 0) goto L_0x001f
            com.wpengapp.support.ರ r0 = r0.f2018
            java.net.URI r0 = r0.mo9372()
            java.net.Proxy r2 = r4.f953
            java.net.SocketAddress r2 = r2.address()
            r1.connectFailed(r0, r2, r5)
        L_0x001f:
            com.wpengapp.support.ࡄ r5 = r3.f1252
            r5.mo9054(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.RouteSelector.mo8211(com.wpengapp.support.Ʈ, java.io.IOException):void");
    }

    /* renamed from: ؠ */
    public final boolean mo8213() {
        return this.f1256 < this.f1255.size();
    }

    /* renamed from: ֏ */
    public boolean mo8212() {
        return mo8213() || !this.f1258.isEmpty();
    }
}
