package com.wpengapp.support;

import android.arch.lifecycle.CompositeGeneratedAdaptersObserver;
import android.arch.lifecycle.FullLifecycleObserver;
import android.arch.lifecycle.FullLifecycleObserverAdapter;
import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.ReflectiveGenericLifecycleObserver;
import android.arch.lifecycle.SingleGeneratedAdapterObserver;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.p000v4.text.BidiFormatter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.wpengapp.support.ލ */
public class Lifecycling {

    /* renamed from: ֏ */
    public static Map<Class, Integer> f2621 = new HashMap();

    /* renamed from: ؠ */
    public static Map<Class, List<Constructor<? extends GeneratedAdapter>>> f2622 = new HashMap();

    @NonNull
    /* renamed from: ֏ */
    public static GenericLifecycleObserver m2532(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (m2531(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = f2622.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(m2533((Constructor) list.get(0), obj));
        }
        GeneratedAdapter[] r1 = new GeneratedAdapter[list.size()];
        for (int i = 0; i < list.size(); i++) {
            r1[i] = m2533((Constructor) list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(r1);
    }

    /* renamed from: ؠ */
    public static boolean m2535(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    /* renamed from: ֏ */
    public static GeneratedAdapter m2533(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return (GeneratedAdapter) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: ֏ */
    public static int m2531(Class<?> cls) {
        Constructor<?> constructor;
        boolean z;
        if (f2621.containsKey(cls)) {
            return f2621.get(cls).intValue();
        }
        int i = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            int i2 = 0;
            try {
                Package packageR = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = packageR != null ? packageR.getName() : BidiFormatter.EMPTY_STRING;
                if (!name.isEmpty()) {
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                String r4 = m2534(canonicalName);
                if (!name.isEmpty()) {
                    r4 = name + "." + r4;
                }
                constructor = Class.forName(r4).getDeclaredConstructor(new Class[]{cls});
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            if (constructor != null) {
                f2622.put(cls, Collections.singletonList(constructor));
            } else {
                ClassesInfoCache r3 = ClassesInfoCache.f2599;
                if (!r3.f2601.containsKey(cls)) {
                    Method[] r5 = r3.mo8983(cls);
                    int length = r5.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            r3.f2601.put(cls, false);
                            z = false;
                            break;
                        } else if (((OnLifecycleEvent) r5[i3].getAnnotation(OnLifecycleEvent.class)) != null) {
                            r3.mo8981(cls, r5);
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                } else {
                    z = r3.f2601.get(cls).booleanValue();
                }
                if (!z) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    if (m2535(superclass)) {
                        if (m2531((Class<?>) superclass) != 1) {
                            arrayList = new ArrayList(f2622.get(superclass));
                        }
                    }
                    Class[] interfaces = cls.getInterfaces();
                    int length2 = interfaces.length;
                    while (true) {
                        if (i2 < length2) {
                            Class cls2 = interfaces[i2];
                            if (m2535(cls2)) {
                                if (m2531((Class<?>) cls2) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.addAll(f2622.get(cls2));
                            }
                            i2++;
                        } else if (arrayList != null) {
                            f2622.put(cls, arrayList);
                        }
                    }
                }
            }
            i = 2;
        }
        f2621.put(cls, Integer.valueOf(i));
        return i;
    }

    /* renamed from: ֏ */
    public static String m2534(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
