package com.wpengapp.support;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;

/* renamed from: com.wpengapp.support.ࡃ */
public final class SafeToastHooker {

    /* renamed from: ֏ */
    public static Field f2801;

    /* renamed from: ؠ */
    public static Field f2802;

    /* renamed from: com.wpengapp.support.ࡃ$֏ */
    /* compiled from: SafeToastHooker */
    public static class C0996 extends Handler {

        /* renamed from: ֏ */
        public Handler f2803;

        public C0996(Handler handler) {
            this.f2803 = handler;
        }

        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception unused) {
            }
        }

        public void handleMessage(Message message) {
            this.f2803.handleMessage(message);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24 && i < 26) {
            m2639();
        }
    }

    /* renamed from: ֏ */
    public static void m2639() {
        if (f2801 == null) {
            try {
                f2801 = Toast.class.getDeclaredField("mTN");
                f2801.setAccessible(true);
                f2802 = f2801.getType().getDeclaredField("mHandler");
                f2802.setAccessible(true);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    /* renamed from: ؠ */
    public static boolean m2641(Toast toast) {
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return m2642(toast);
    }

    /* renamed from: ހ */
    public static boolean m2642(Toast toast) {
        m2639();
        try {
            Object obj = f2801.get(toast);
            f2802.set(obj, new C0996((Handler) f2802.get(obj)));
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: ֏ */
    public static void m2640(Toast toast) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24 && i < 26) {
            m2642(toast);
        }
    }
}
