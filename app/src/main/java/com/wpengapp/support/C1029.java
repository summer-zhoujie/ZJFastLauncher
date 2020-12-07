package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;
import com.wpengapp.lightstart.activity.CustomGuideActivity;

/* renamed from: com.wpengapp.support.म */
/* compiled from: lambda */
public final /* synthetic */ class C1029 implements Runnable {

    /* renamed from: ֏ */
    private final /* synthetic */ Context f2949;

    public /* synthetic */ C1029(Context context) {
        this.f2949 = context;
    }

    public final void run() {
        SystemUtils.m3510(this.f2949, new Intent(this.f2949, CustomGuideActivity.class));
    }
}
