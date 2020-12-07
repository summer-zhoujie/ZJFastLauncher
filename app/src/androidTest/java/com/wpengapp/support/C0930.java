package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.ToastRecordActivity;

/* renamed from: com.wpengapp.support.ݚ */
/* compiled from: lambda */
public final /* synthetic */ class C0930 implements View.OnClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ PopupDialog f2526;

    /* renamed from: ؠ */
    private final /* synthetic */ ToastRecord f2527;

    public /* synthetic */ C0930(PopupDialog r1, ToastRecord r2) {
        this.f2526 = r1;
        this.f2527 = r2;
    }

    public final void onClick(View view) {
        ToastRecordActivity.m534(this.f2526, this.f2527, view);
    }
}
