package com.wpengapp.support;

import android.view.View;

/* renamed from: com.wpengapp.support.પ */
/* compiled from: lambda */
public final /* synthetic */ class C1111 implements Runnable {

    /* renamed from: ֏ */
    private final /* synthetic */ View f3164;

    public /* synthetic */ C1111(View view) {
        this.f3164 = view;
    }

    public final void run() {
        this.f3164.setOnTouchListener(new CustomManager(this.f3164));
    }
}
