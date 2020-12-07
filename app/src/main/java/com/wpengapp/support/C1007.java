package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.ToastRecordActivity;

/* renamed from: com.wpengapp.support.ग */
/* compiled from: lambda */
public final /* synthetic */ class C1007 implements View.OnClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ ToastRecordActivity f2893;

    /* renamed from: ؠ */
    private final /* synthetic */ PopupDialog f2894;

    /* renamed from: ހ */
    private final /* synthetic */ ToastRecord f2895;

    /* renamed from: ށ */
    private final /* synthetic */ int f2896;

    public /* synthetic */ C1007(ToastRecordActivity toastRecordActivity, PopupDialog r2, ToastRecord r3, int i) {
        this.f2893 = toastRecordActivity;
        this.f2894 = r2;
        this.f2895 = r3;
        this.f2896 = i;
    }

    public final void onClick(View view) {
        this.f2893.mo7675(this.f2894, this.f2895, this.f2896, view);
    }
}
