package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* renamed from: com.wpengapp.support.բ */
public final class Jdk9Platform extends Platform {

    /* renamed from: ހ */
    public final Method f2060;

    /* renamed from: ށ */
    public final Method f2061;

    public Jdk9Platform(Method method, Method method2) {
        this.f2060 = method;
        this.f2061 = method2;
    }

    /* renamed from: ֏ */
    public void mo8146(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> r7 = Platform.m1746(list);
            this.f2060.invoke(sSLParameters, new Object[]{r7.toArray(new String[r7.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.m934("unable to set ssl parameters", (Exception) e);
        }
    }

    /* renamed from: ؠ */
    public String mo8148(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f2061.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals(BidiFormatter.EMPTY_STRING)) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.m934("unable to get selected protocols", (Exception) e);
        }
    }

    /* renamed from: ؠ */
    public static Jdk9Platform m2126() {
        try {
            return new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
