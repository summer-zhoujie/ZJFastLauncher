package com.wpengapp.support;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.wpengapp.support.л */
/* compiled from: FullRuleChecker */
public final class C0704 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ View f1817;

    public C0704(View view) {
        this.f1817 = view;
    }

    public void run() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{-this.f1817.getHeight(), 0});
        ofInt.addUpdateListener(new FullRuleChecker(this));
        ofInt.setDuration(300);
        ofInt.start();
    }
}
