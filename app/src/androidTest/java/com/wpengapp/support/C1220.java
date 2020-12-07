package com.wpengapp.support;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.wpengapp.support.ປ */
/* compiled from: FullRuleChecker */
public final class C1220 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: ֏ */
    public final /* synthetic */ View f3479;

    public C1220(View view) {
        this.f3479 = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3479.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
