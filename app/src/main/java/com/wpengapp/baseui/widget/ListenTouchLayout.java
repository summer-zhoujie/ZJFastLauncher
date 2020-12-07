package com.wpengapp.baseui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class ListenTouchLayout extends FrameLayout {

    /* renamed from: com.wpengapp.baseui.widget.ListenTouchLayout$֏ */
    public interface C0426 {
    }

    public ListenTouchLayout(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setTouchInterceptor(C0426 r1) {
    }

    public ListenTouchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListenTouchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public ListenTouchLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
