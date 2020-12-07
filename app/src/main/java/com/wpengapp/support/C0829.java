package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.adaptor.ToastRecordAdaptor;

/* renamed from: com.wpengapp.support.ץ */
/* compiled from: lambda */
public final /* synthetic */ class C0829 implements View.OnClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ ToastRecordAdaptor.AppItem f2158;

    /* renamed from: ؠ */
    private final /* synthetic */ ToastRecord f2159;

    /* renamed from: ހ */
    private final /* synthetic */ int f2160;

    public /* synthetic */ C0829(ToastRecordAdaptor.AppItem appItem, ToastRecord r2, int i) {
        this.f2158 = appItem;
        this.f2159 = r2;
        this.f2160 = i;
    }

    public final void onClick(View view) {
        this.f2158.mo7713(this.f2159, this.f2160, view);
    }
}
