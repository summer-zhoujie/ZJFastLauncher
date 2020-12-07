package com.wpengapp.support;

import android.content.Context;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: com.wpengapp.support.ļ */
public class DevHelper {

    /* renamed from: ֏ */
    public static C0473 f805;

    /* renamed from: com.wpengapp.support.ļ$֏ */
    /* compiled from: DevHelper */
    public interface C0473 {
    }

    /* renamed from: com.wpengapp.support.ļ$ؠ */
    /* compiled from: DevHelper */
    private static class C0474 implements C0473 {
        public C0474() {
        }

        /* renamed from: ֏ */
        public void mo7968() {
        }

        /* renamed from: ֏ */
        public void mo7969(Context context) {
        }

        /* renamed from: ֏ */
        public void mo7970(AccessibilityEvent accessibilityEvent) {
        }

        /* renamed from: ؠ */
        public boolean mo7971() {
            return false;
        }

        public /* synthetic */ C0474(C0736 r1) {
        }
    }

    /* renamed from: ֏ */
    public static C0473 m1039() {
        if (f805 == null) {
            synchronized (DevHelper.class) {
                if (f805 == null) {
                    try {
                        f805 = (C0473) Class.forName("com.wpengapp.lightstart.dev.DebugDev").newInstance();
                    } catch (Exception e) {
                        e.getMessage();
                        f805 = new C0474((C0736) null);
                    }
                }
            }
        }
        return f805;
    }
}
