package com.wpengapp.support;

import com.wpengapp.support.Headers;
import com.wpengapp.support.Response;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

/* renamed from: com.wpengapp.support.Һ */
public abstract class Internal {

    /* renamed from: ֏ */
    public static Internal f1914;

    /* renamed from: ֏ */
    public abstract int mo7912(Response.C0600 r1);

    /* renamed from: ֏ */
    public abstract RealConnection mo7913(C1000 r1, Address r2, StreamAllocation r3, Route r4);

    /* renamed from: ֏ */
    public abstract RouteDatabase mo7914(C1000 r1);

    /* renamed from: ֏ */
    public abstract IOException mo7915(Call r1, IOException iOException);

    /* renamed from: ֏ */
    public abstract Socket mo7916(C1000 r1, Address r2, StreamAllocation r3);

    /* renamed from: ֏ */
    public abstract void mo7917(Headers.C0568 r1, String str);

    /* renamed from: ֏ */
    public abstract void mo7918(Headers.C0568 r1, String str, String str2);

    /* renamed from: ֏ */
    public abstract void mo7919(ConnectionSpec r1, SSLSocket sSLSocket, boolean z);

    /* renamed from: ֏ */
    public abstract boolean mo7920(Address r1, Address r2);

    /* renamed from: ֏ */
    public abstract boolean mo7921(C1000 r1, RealConnection r2);

    /* renamed from: ؠ */
    public abstract void mo7922(C1000 r1, RealConnection r2);
}
