package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Ӡ */
public class SyncPayStatus {

    /* renamed from: ֏ */
    public static volatile Boolean f1934;

    /* renamed from: ؠ */
    public static OnUserInfoChangedListener f1935 = new C0820();

    /* renamed from: ֏ */
    public static boolean m1962() {
        m1963();
        return f1934.booleanValue();
    }

    /* renamed from: ؠ */
    public static void m1963() {
        if (f1934 == null) {
            synchronized (SyncPayStatus.class) {
                if (f1934 == null) {
                    f1934 = Boolean.valueOf(C0536.m1313(C0536.m1309()));
                    C0536.f1035.put(f1935, OnUserInfoChangedListener.class);
                }
            }
        }
    }
}
