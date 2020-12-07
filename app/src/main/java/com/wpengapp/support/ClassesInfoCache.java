package com.wpengapp.support;

import android.support.annotation.Nullable;
import com.wpengapp.support.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.ކ */
public class ClassesInfoCache {

    /* renamed from: ֏ */
    public static ClassesInfoCache f2599 = new ClassesInfoCache();

    /* renamed from: ؠ */
    public final Map<Class, C0953> f2600 = new HashMap();

    /* renamed from: ހ */
    public final Map<Class, Boolean> f2601 = new HashMap();

    /* renamed from: com.wpengapp.support.ކ$֏ */
    /* compiled from: ClassesInfoCache */
    static class C0953 {

        /* renamed from: ֏ */
        public final Map<Lifecycle.C0955, List<C0954>> f2602 = new HashMap();

        /* renamed from: ؠ */
        public final Map<C0954, Lifecycle.C0955> f2603;

        public C0953(Map<C0954, Lifecycle.C0955> map) {
            this.f2603 = map;
            for (Map.Entry next : map.entrySet()) {
                Lifecycle.C0955 r1 = (Lifecycle.C0955) next.getValue();
                List list = this.f2602.get(r1);
                if (list == null) {
                    list = new ArrayList();
                    this.f2602.put(r1, list);
                }
                list.add(next.getKey());
            }
        }

        /* renamed from: ֏ */
        public static void m2519(List<C0954> list, LifecycleOwner r3, Lifecycle.C0955 r4, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).mo8987(r3, r4, obj);
                }
            }
        }
    }

    /* renamed from: com.wpengapp.support.ކ$ؠ */
    /* compiled from: ClassesInfoCache */
    static class C0954 {

        /* renamed from: ֏ */
        public final int f2604;

        /* renamed from: ؠ */
        public final Method f2605;

        public C0954(int i, Method method) {
            this.f2604 = i;
            this.f2605 = method;
            this.f2605.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0954.class != obj.getClass()) {
                return false;
            }
            C0954 r5 = (C0954) obj;
            if (this.f2604 != r5.f2604 || !this.f2605.getName().equals(r5.f2605.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f2605.getName().hashCode() + (this.f2604 * 31);
        }

        /* renamed from: ֏ */
        public void mo8987(LifecycleOwner r5, Lifecycle.C0955 r6, Object obj) {
            try {
                int i = this.f2604;
                if (i == 0) {
                    this.f2605.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f2605.invoke(obj, new Object[]{r5});
                } else if (i == 2) {
                    this.f2605.invoke(obj, new Object[]{r5, r6});
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* renamed from: ֏ */
    public final Method[] mo8983(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* renamed from: ؠ */
    public C0953 mo8984(Class cls) {
        C0953 r0 = this.f2600.get(cls);
        if (r0 != null) {
            return r0;
        }
        return mo8981(cls, (Method[]) null);
    }

    /* renamed from: ֏ */
    public final void mo8982(Map<C0954, Lifecycle.C0955> map, C0954 r4, Lifecycle.C0955 r5, Class cls) {
        Lifecycle.C0955 r0 = map.get(r4);
        if (r0 != null && r5 != r0) {
            Method method = r4.f2605;
            StringBuilder r1 = outline.m2549("Method ");
            r1.append(method.getName());
            r1.append(" in ");
            r1.append(cls.getName());
            r1.append(" already declared with different @OnLifecycleEvent value: previous");
            r1.append(" value ");
            r1.append(r0);
            r1.append(", new value ");
            r1.append(r5);
            throw new IllegalArgumentException(r1.toString());
        } else if (r0 == null) {
            map.put(r4, r5);
        }
    }

    /* renamed from: ֏ */
    public final C0953 mo8981(Class cls, @Nullable Method[] methodArr) {
        int i;
        C0953 r0;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (r0 = mo8984(superclass)) == null)) {
            hashMap.putAll(r0.f2603);
        }
        for (Class r5 : cls.getInterfaces()) {
            for (Map.Entry next : mo8984(r5).f2603.entrySet()) {
                mo8982(hashMap, (C0954) next.getKey(), (Lifecycle.C0955) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent r6 = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (r6 != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.C0955 value = r6.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.C0955.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == Lifecycle.C0955.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    mo8982(hashMap, new C0954(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0953 r13 = new C0953(hashMap);
        this.f2600.put(cls, r13);
        this.f2601.put(cls, Boolean.valueOf(z));
        return r13;
    }
}
