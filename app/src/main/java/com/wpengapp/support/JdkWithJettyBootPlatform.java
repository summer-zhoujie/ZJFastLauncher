package com.wpengapp.support;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.wpengapp.support.Ⴂ */
public class JdkWithJettyBootPlatform extends Platform {

    /* renamed from: ހ */
    public final Method f3702;

    /* renamed from: ށ */
    public final Method f3703;

    /* renamed from: ނ */
    public final Method f3704;

    /* renamed from: ރ */
    public final Class<?> f3705;

    /* renamed from: ބ */
    public final Class<?> f3706;

    /* renamed from: com.wpengapp.support.Ⴂ$֏ */
    /* compiled from: JdkWithJettyBootPlatform */
    private static class C1300 implements InvocationHandler {

        /* renamed from: ֏ */
        public final List<String> f3707;

        /* renamed from: ؠ */
        public boolean f3708;

        /* renamed from: ހ */
        public String f3709;

        public C1300(List<String> list) {
            this.f3707 = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.f730;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f3708 = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f3707;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f3707.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f3709 = str;
                            return str;
                        }
                    }
                    String str2 = this.f3707.get(0);
                    this.f3709 = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f3709 = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    public JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f3702 = method;
        this.f3703 = method2;
        this.f3704 = method3;
        this.f3705 = cls;
        this.f3706 = cls2;
    }

    /* renamed from: ֏ */
    public void mo8146(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List<String> r7 = Platform.m1746(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f3705, this.f3706}, new C1300(r7));
            this.f3702.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.m934("unable to set alpn", (Exception) e);
        }
    }

    /* renamed from: ؠ */
    public String mo8148(SSLSocket sSLSocket) {
        try {
            C1300 r0 = (C1300) Proxy.getInvocationHandler(this.f3703.invoke((Object) null, new Object[]{sSLSocket}));
            if (!r0.f3708 && r0.f3709 == null) {
                Platform.f1792.mo8437(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (r0.f3708) {
                return null;
            } else {
                return r0.f3709;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.m934("unable to get selected protocol", (Exception) e);
        }
    }

    /* renamed from: ֏ */
    public void mo8469(SSLSocket sSLSocket) {
        try {
            this.f3704.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.m934("unable to remove alpn", (Exception) e);
        }
    }

    /* renamed from: ؠ */
    public static Platform m3503() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new JdkWithJettyBootPlatform(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
