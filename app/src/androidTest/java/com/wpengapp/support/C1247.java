package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.ToastRecordAppActivity;

/* renamed from: com.wpengapp.support.ཊ */
/* compiled from: lambda */
public final /* synthetic */ class C1247 implements View.OnClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ ToastRecordAppActivity f3539;

    /* renamed from: ؠ */
    private final /* synthetic */ PopupDialog f3540;

    /* renamed from: ހ */
    private final /* synthetic */ ToastRecord f3541;

    /* renamed from: ށ */
    private final /* synthetic */ int f3542;

    public /* synthetic */ C1247(ToastRecordAppActivity toastRecordAppActivity, PopupDialog r2, ToastRecord r3, int i) {
        this.f3539 = toastRecordAppActivity;
        this.f3540 = r2;
        this.f3541 = r3;
        this.f3542 = i;
    }

    public final void onClick(View view) {
        this.f3539.mo7689(this.f3540, this.f3541, this.f3542, view);
    }
}
