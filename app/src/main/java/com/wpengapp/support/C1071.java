package com.wpengapp.support;

import android.view.ViewTreeObserver;
import com.wpengapp.support.licensing.activity.InputContactActivity;

/* renamed from: com.wpengapp.support.স */
/* compiled from: InputContactActivity */
class C1071 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: ֏ */
    public final /* synthetic */ InputContactActivity f3046;

    public C1071(InputContactActivity inputContactActivity) {
        this.f3046 = inputContactActivity;
    }

    public void onGlobalLayout() {
        this.f3046.f678.post(new C0846(this));
    }
}
