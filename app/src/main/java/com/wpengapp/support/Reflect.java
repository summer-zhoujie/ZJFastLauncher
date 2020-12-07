package com.wpengapp.support;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* renamed from: com.wpengapp.support.Ⴉ */
public class Reflect {

    /* renamed from: ֏ */
    public final Object cls;

    /* renamed from: ؠ */
    public final boolean f3715 = true;

    /* renamed from: com.wpengapp.support.Ⴉ$֏ */
    /* compiled from: Reflect */
    private static class C1303 {
    }

    /* renamed from: com.wpengapp.support.Ⴉ$ؠ */
    /* compiled from: Reflect */
    public static class C1304 extends Exception {
        public static final long serialVersionUID = -6213149635297151442L;

        public C1304(Throwable th) {
            super(th);
        }
    }

    public Reflect(Class<?> cls) {
        this.cls = cls;
    }

    /* renamed from: ֏ */
    public static Reflect create(Class<?> cls) {
        return new Reflect(cls);
    }

    /* renamed from: ހ */
    public static Reflect forName(String str) {
        try {
            return new Reflect(Class.forName(str));
        } catch (Exception e) {
            throw new C1304(e);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Reflect) && this.cls.equals(((Reflect) obj).cls);
    }

    public int hashCode() {
        return this.cls.hashCode();
    }

    public String toString() {
        return this.cls.toString();
    }

    /* renamed from: ؠ */
    public <T> T getFeild(String str) {
        Class r0;
        Field field;
        try {
            r0 = mo9563();
            try {
                field = r0.getField(str);
            } catch (NoSuchFieldException e) {
                while (true) {
                    field = (Field) m3534(r0.getDeclaredField(str));
                    break;
                }
            }
            return field.get(this.cls);
        } catch (NoSuchFieldException unused) {
            r0 = r0.getSuperclass();
            if (r0 == null) {
                throw new C1304(e);
            }
        } catch (Exception e2) {
            throw new C1304(e2);
        }
    }

    /* renamed from: ֏ */
    public static <T extends AccessibleObject> T m3534(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    public Reflect(Object obj) {
        this.cls = obj;
    }

    /* renamed from: ؠ */
    public static Class<?> m3535(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    /* renamed from: ֏ */
    public Reflect getMethod(String str) {
        return getMethod(str, new Object[0]);
    }

    /* renamed from: ֏ */
    public final Method mo9564(String str, Class<?>[] clsArr) {
        Class r0 = mo9563();
        for (Method method : r0.getMethods()) {
            if (mo9565(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : r0.getDeclaredMethods()) {
                if (mo9565(method2, str, clsArr)) {
                    return method2;
                }
            }
            r0 = r0.getSuperclass();
        } while (r0 != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + mo9563() + ".");
    }

    /* renamed from: ֏ */
    public final boolean mo9565(Method method, String str, Class<?>[] clsArr) {
        boolean z;
        if (method.getName().equals(str)) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                int i = 0;
                while (true) {
                    if (i >= clsArr.length) {
                        z = true;
                        break;
                    } else if (clsArr[i] != C1303.class && !m3535((Class<?>) parameterTypes[i]).isAssignableFrom(m3535(clsArr[i]))) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ֏ */
    public static Reflect m3533(Method method, Object obj, Object... objArr) {
        try {
            m3534(method);
            if (method.getReturnType() != Void.TYPE) {
                return new Reflect(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return new Reflect(obj);
        } catch (Exception e) {
            throw new C1304(e);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1 = r1.getDeclaredMethod(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        r1 = r1.getSuperclass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        if (r1 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        throw new java.lang.NoSuchMethodException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0048, code lost:
        return m3533(mo9564(r4, (java.lang.Class<?>[]) r0), r3.f3714, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0049, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004f, code lost:
        throw new com.wpengapp.support.Reflect.C1304(r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x003e */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Reflect getMethod(String r4, Object... r5) {
        /*
            r3 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0006
            java.lang.Class[] r0 = new java.lang.Class[r0]
            goto L_0x001d
        L_0x0006:
            int r1 = r5.length
            java.lang.Class[] r1 = new java.lang.Class[r1]
        L_0x0009:
            int r2 = r5.length
            if (r0 >= r2) goto L_0x001c
            r2 = r5[r0]
            if (r2 != 0) goto L_0x0013
            java.lang.Class<com.wpengapp.support.Ⴉ$֏> r2 = com.wpengapp.support.Reflect.C1303.class
            goto L_0x0017
        L_0x0013:
            java.lang.Class r2 = r2.getClass()
        L_0x0017:
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0009
        L_0x001c:
            r0 = r1
        L_0x001d:
            java.lang.Class r1 = r3.mo9563()     // Catch:{ NoSuchMethodException -> 0x003e }
            java.lang.reflect.Method r1 = r1.getMethod(r4, r0)     // Catch:{ NoSuchMethodException -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r0)     // Catch:{ NoSuchMethodException -> 0x0031 }
        L_0x002a:
            java.lang.Object r2 = r3.f3714     // Catch:{ NoSuchMethodException -> 0x003e }
            com.wpengapp.support.Ⴉ r4 = m3533((java.lang.reflect.Method) r1, (java.lang.Object) r2, (java.lang.Object[]) r5)     // Catch:{ NoSuchMethodException -> 0x003e }
            return r4
        L_0x0031:
            java.lang.Class r1 = r1.getSuperclass()     // Catch:{ NoSuchMethodException -> 0x003e }
            if (r1 == 0) goto L_0x0038
            goto L_0x0026
        L_0x0038:
            java.lang.NoSuchMethodException r1 = new java.lang.NoSuchMethodException     // Catch:{ NoSuchMethodException -> 0x003e }
            r1.<init>()     // Catch:{ NoSuchMethodException -> 0x003e }
            throw r1     // Catch:{ NoSuchMethodException -> 0x003e }
        L_0x003e:
            java.lang.reflect.Method r4 = r3.mo9564((java.lang.String) r4, (java.lang.Class<?>[]) r0)     // Catch:{ NoSuchMethodException -> 0x0049 }
            java.lang.Object r0 = r3.f3714     // Catch:{ NoSuchMethodException -> 0x0049 }
            com.wpengapp.support.Ⴉ r4 = m3533((java.lang.reflect.Method) r4, (java.lang.Object) r0, (java.lang.Object[]) r5)     // Catch:{ NoSuchMethodException -> 0x0049 }
            return r4
        L_0x0049:
            r4 = move-exception
            com.wpengapp.support.Ⴉ$ؠ r5 = new com.wpengapp.support.Ⴉ$ؠ
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Reflect.mo9562(java.lang.String, java.lang.Object[]):com.wpengapp.support.Ⴉ");
    }

    /* renamed from: ֏ */
    public Class<?> mo9563() {
        if (this.f3715) {
            return (Class) this.cls;
        }
        return this.cls.getClass();
    }
}
