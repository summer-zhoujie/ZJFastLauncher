package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.service.AccService;

/* renamed from: com.wpengapp.support.ए */
/* compiled from: AccService */
public class C1005 implements View.OnAttachStateChangeListener {

    /* renamed from: ֏ */
    public final /* synthetic */ AccService f2889;

    public C1005(AccService accService) {
        this.f2889 = accService;
    }

    public void onViewAttachedToWindow(View view) {
        boolean unused = this.f2889.f525 = true;
    }

    public void onViewDetachedFromWindow(View view) {
        boolean unused = this.f2889.f525 = false;
    }
}
