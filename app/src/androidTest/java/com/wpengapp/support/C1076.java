package com.wpengapp.support;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* renamed from: com.wpengapp.support.ঢ় */
/* compiled from: SafeHandlerThread */
public class C1076 extends HandlerThread {

    /* renamed from: ֏ */
    public boolean f3053;

    public C1076(String str) {
        super(str);
    }

    public Looper getLooper() {
        Looper looper = super.getLooper();
        if (!this.f3053) {
            this.f3053 = true;
            new Handler(getLooper()).post(new SafeHandlerThread(this));
        }
        return looper;
    }

    public C1076(String str, int i) {
        super(str, i);
    }

    /* renamed from: ֏ */
    public final void mo9251(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("SafeHandlerThread", "catch");
        C0975.m2601(this, exc, true, hashMap);
    }
}
