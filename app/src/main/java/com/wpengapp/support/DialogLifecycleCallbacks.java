package com.wpengapp.support;

import android.support.annotation.NonNull;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.wpengapp.support.ɩ */
public class DialogLifecycleCallbacks {

    /* renamed from: ֏ */
    public static final Map<DialogLifecycleCallbacks, DialogLifecycleCallbacks> f1247 = new WeakHashMap();

    /* renamed from: ؠ */
    public static void m1408(Object obj) {
        for (DialogLifecycleCallbacks r1 : f1247.keySet()) {
            r1.mo8205(obj);
        }
    }

    /* renamed from: ֏ */
    public void mo8205(@NonNull Object obj) {
    }
}
