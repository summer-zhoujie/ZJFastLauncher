package com.wpengapp.support;

import android.animation.Animator;
import com.wpengapp.lightstart.service.AccService;

/* renamed from: com.wpengapp.support.ဗ */
/* compiled from: AccService */
class C1289 implements Animator.AnimatorListener {

    /* renamed from: ֏ */
    public final /* synthetic */ AccService f3624;

    public C1289(AccService accService) {
        this.f3624 = accService;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f3624.f507.mo9027();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
