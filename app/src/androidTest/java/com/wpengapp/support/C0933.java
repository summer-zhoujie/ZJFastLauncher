package com.wpengapp.support;

import android.view.MotionEvent;
import android.view.View;
import com.wpengapp.support.permission.ServicePermissionActivity;

/* renamed from: com.wpengapp.support.ݞ */
/* compiled from: ServicePermissionActivity */
class C0933 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ int f2530;

    /* renamed from: ؠ */
    public final /* synthetic */ int f2531;

    /* renamed from: ހ */
    public final /* synthetic */ View f2532;

    public C0933(ServicePermissionActivity servicePermissionActivity, int i, int i2, View view) {
        this.f2530 = i;
        this.f2531 = i2;
        this.f2532 = view;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        MotionEvent obtain = MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, (float) this.f2530, (float) this.f2531, 0);
        this.f2532.onTouchEvent(obtain);
        obtain.recycle();
        long currentTimeMillis2 = System.currentTimeMillis();
        MotionEvent obtain2 = MotionEvent.obtain(currentTimeMillis2, currentTimeMillis2, 1, (float) this.f2530, (float) this.f2531, 0);
        this.f2532.onTouchEvent(obtain2);
        obtain2.recycle();
    }
}
