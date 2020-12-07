package com.wpengapp.support;

import android.util.SparseArray;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.wpengapp.support.θ */
public class ObjectCache {

    /* renamed from: ֏ */
    public static SparseArray<Object> f1666 = new SparseArray<>();

    /* renamed from: ؠ */
    public static AtomicInteger f1667 = new AtomicInteger(0);

    /* renamed from: ֏ */
    public static int m1661(Object obj) {
        int incrementAndGet = f1667.incrementAndGet();
        f1666.put(incrementAndGet, obj);
        "cache obj: " + incrementAndGet + ", count: " + f1666.size();
        return incrementAndGet;
    }

    /* renamed from: ؠ */
    public static void m1663(int i) {
        f1666.remove(i);
        "remove obj: " + i + ", count: " + f1666.size();
    }

    /* renamed from: ֏ */
    public static <T> T m1662(int i) {
        try {
            return f1666.get(i);
        } catch (Exception unused) {
            return null;
        }
    }
}
