package com.wpengapp.support;

import android.view.View;

/* renamed from: com.wpengapp.support.ߏ */
/* compiled from: FullRuleChecker */
public final class C0967 implements View.OnAttachStateChangeListener {

    /* renamed from: ֏ */
    public final /* synthetic */ Runnable f2689;

    /* renamed from: ؠ */
    public final /* synthetic */ Runnable f2690;

    public C0967(Runnable runnable, Runnable runnable2) {
        this.f2689 = runnable;
        this.f2690 = runnable2;
    }

    public void onViewAttachedToWindow(View view) {
        this.f2689.run();
    }

    public void onViewDetachedFromWindow(View view) {
        this.f2690.run();
    }
}
