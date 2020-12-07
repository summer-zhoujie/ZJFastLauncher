package com.wpengapp.support;

import android.graphics.drawable.Drawable;
import com.wpengapp.lightstart.service.AccService;

/* renamed from: com.wpengapp.support.к */
/* compiled from: lambda */
public final /* synthetic */ class C0703 implements Runnable {

    /* renamed from: ֏ */
    private final /* synthetic */ AccService f1814;

    /* renamed from: ؠ */
    private final /* synthetic */ String f1815;

    /* renamed from: ހ */
    private final /* synthetic */ Drawable f1816;

    public /* synthetic */ C0703(AccService accService, String str, Drawable drawable) {
        this.f1814 = accService;
        this.f1815 = str;
        this.f1816 = drawable;
    }

    public final void run() {
        this.f1814.mo7732(this.f1815, this.f1816);
    }
}
