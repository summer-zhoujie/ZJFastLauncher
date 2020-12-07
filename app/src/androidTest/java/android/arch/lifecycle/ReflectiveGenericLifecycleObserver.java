package android.arch.lifecycle;

import com.wpengapp.support.ClassesInfoCache;
import com.wpengapp.support.Lifecycle;
import com.wpengapp.support.LifecycleOwner;

public class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {

    /* renamed from: ֏ */
    public final Object f8;

    /* renamed from: ؠ */
    public final ClassesInfoCache.C0953 f9 = ClassesInfoCache.f2599.mo8984(this.f8.getClass());

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f8 = obj;
    }

    /* renamed from: ֏ */
    public void mo1(LifecycleOwner r4, Lifecycle.C0955 r5) {
        ClassesInfoCache.C0953 r0 = this.f9;
        Object obj = this.f8;
        ClassesInfoCache.C0953.m2519(r0.f2602.get(r5), r4, r5, obj);
        ClassesInfoCache.C0953.m2519(r0.f2602.get(Lifecycle.C0955.ON_ANY), r4, r5, obj);
    }
}
