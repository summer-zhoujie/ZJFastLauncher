package com.wpengapp.support;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.wpengapp.support.ӭ */
class CustomManager implements View.OnTouchListener {

    /* renamed from: ֏ */
    public float f1940;

    /* renamed from: ؠ */
    public float f1941;

    /* renamed from: ހ */
    public int f1942 = (((View) this.f1943.getParent()).getHeight() - this.f1943.getHeight());

    /* renamed from: ށ */
    public final /* synthetic */ View f1943;

    public CustomManager(View view) {
        this.f1943 = view;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1940 = motionEvent.getRawY();
            this.f1941 = this.f1943.getY();
        } else if (actionMasked == 2) {
            float rawY = this.f1941 + (motionEvent.getRawY() - this.f1940);
            if (rawY < 0.0f) {
                rawY = 0.0f;
            } else {
                int i = this.f1942;
                if (rawY > ((float) i)) {
                    rawY = (float) i;
                }
            }
            this.f1943.setY(rawY);
        }
        return true;
    }
}
