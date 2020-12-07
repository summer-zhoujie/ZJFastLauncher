package com.wpengapp.support;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.wpengapp.support.ҝ */
public class OptionalMethod<T> {

    /* renamed from: ֏ */
    public final Class<?> f1891;

    /* renamed from: ؠ */
    public final String f1892;

    /* renamed from: ހ */
    public final Class[] f1893;

    public OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.f1891 = cls;
        this.f1892 = str;
        this.f1893 = clsArr;
    }

    /* renamed from: ֏ */
    public boolean mo8548(T t) {
        return mo8547(t.getClass()) != null;
    }

    /* renamed from: ؠ */
    public Object mo8549(T t, Object... objArr) {
        try {
            Method r0 = mo8547(t.getClass());
            if (r0 == null) {
                return null;
            }
            try {
                return r0.invoke(t, objArr);
            } catch (IllegalAccessException unused) {
                return null;
            }
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: ހ */
    public Object mo8550(T t, Object... objArr) {
        try {
            return mo8546(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: ֏ */
    public Object mo8546(T t, Object... objArr) {
        Method r0 = mo8547(t.getClass());
        if (r0 != null) {
            try {
                return r0.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError(outline.m2554("Unexpectedly could not call: ", (Object) r0));
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            StringBuilder r02 = outline.m2549("Method ");
            r02.append(this.f1892);
            r02.append(" not supported for object ");
            r02.append(t);
            throw new AssertionError(r02.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if ((r4.getModifiers() & 1) == 0) goto L_0x0013;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.reflect.Method mo8547(java.lang.Class<?> r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.f1892
            r1 = 0
            if (r0 == 0) goto L_0x0026
            java.lang.Class[] r2 = r3.f1893
            java.lang.reflect.Method r4 = r4.getMethod(r0, r2)     // Catch:{ NoSuchMethodException -> 0x0013 }
            int r0 = r4.getModifiers()     // Catch:{ NoSuchMethodException -> 0x0014 }
            r0 = r0 & 1
            if (r0 != 0) goto L_0x0014
        L_0x0013:
            r4 = r1
        L_0x0014:
            if (r4 == 0) goto L_0x0025
            java.lang.Class<?> r0 = r3.f1891
            if (r0 == 0) goto L_0x0025
            java.lang.Class r2 = r4.getReturnType()
            boolean r0 = r0.isAssignableFrom(r2)
            if (r0 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r1 = r4
        L_0x0026:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.OptionalMethod.mo8547(java.lang.Class):java.lang.reflect.Method");
    }
}
