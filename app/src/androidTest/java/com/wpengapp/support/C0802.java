package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.adaptor.ToastRecordAdaptor;

/* renamed from: com.wpengapp.support.ձ */
/* compiled from: lambda */
public final /* synthetic */ class C0802 implements View.OnLongClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ ToastRecordAdaptor.AppItem f2077;

    /* renamed from: ؠ */
    private final /* synthetic */ ToastRecord f2078;

    /* renamed from: ހ */
    private final /* synthetic */ int f2079;

    public /* synthetic */ C0802(ToastRecordAdaptor.AppItem appItem, ToastRecord r2, int i) {
        this.f2077 = appItem;
        this.f2078 = r2;
        this.f2079 = i;
    }

    public final boolean onLongClick(View view) {
        return this.f2077.mo7714(this.f2078, this.f2079, view);
    }
}
