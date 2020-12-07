package com.wpengapp.support;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.wpengapp.support.ࡂ */
/* compiled from: lambda */
public final /* synthetic */ class C0995 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: ֏ */
    private final /* synthetic */ View f2800;

    public /* synthetic */ C0995(View view) {
        this.f2800 = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2800.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
