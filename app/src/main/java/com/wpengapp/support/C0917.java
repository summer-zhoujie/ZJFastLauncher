package com.wpengapp.support;

import android.view.MotionEvent;
import android.view.View;
import com.wpengapp.lightstart.service.AccService;

/* renamed from: com.wpengapp.support.ܕ */
/* compiled from: lambda */
public final /* synthetic */ class C0917 implements View.OnTouchListener {

    /* renamed from: ֏ */
    private final /* synthetic */ AccService f2486;

    public /* synthetic */ C0917(AccService accService) {
        this.f2486 = accService;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f2486.mo7740(view, motionEvent);
    }
}
