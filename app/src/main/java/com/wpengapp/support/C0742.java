package com.wpengapp.support;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.wpengapp.support.һ */
/* compiled from: lambda */
public final /* synthetic */ class C0742 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: ֏ */
    private final /* synthetic */ View f1915;

    public /* synthetic */ C0742(View view) {
        this.f1915 = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1915.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
