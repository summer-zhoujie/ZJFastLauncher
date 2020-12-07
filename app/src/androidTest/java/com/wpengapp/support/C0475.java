package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;
import com.wpengapp.lightstart.activity.CustomGuideActivity;

/* renamed from: com.wpengapp.support.Ľ */
/* compiled from: lambda */
public final /* synthetic */ class C0475 implements Runnable {

    /* renamed from: ֏ */
    private final /* synthetic */ Context f806;

    public /* synthetic */ C0475(Context context) {
        this.f806 = context;
    }

    public final void run() {
        SystemUtils.m3510(this.f806, new Intent(this.f806, CustomGuideActivity.class));
    }
}
