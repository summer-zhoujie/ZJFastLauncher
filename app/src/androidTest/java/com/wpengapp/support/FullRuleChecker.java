package com.wpengapp.support;

import android.animation.ValueAnimator;

/* renamed from: com.wpengapp.support.ƈ */
class FullRuleChecker implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: ֏ */
    public final /* synthetic */ C0704 f911;

    public FullRuleChecker(C0704 r1) {
        this.f911 = r1;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f911.f1817.setTranslationY((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
