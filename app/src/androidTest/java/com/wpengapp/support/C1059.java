package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.adaptor.ToastRecordAppAdaptor;

/* renamed from: com.wpengapp.support.দ */
/* compiled from: lambda */
public final /* synthetic */ class C1059 implements View.OnLongClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ ToastRecordAppAdaptor.AppItem f3025;

    /* renamed from: ؠ */
    private final /* synthetic */ ToastRecord f3026;

    /* renamed from: ހ */
    private final /* synthetic */ int f3027;

    public /* synthetic */ C1059(ToastRecordAppAdaptor.AppItem appItem, ToastRecord r2, int i) {
        this.f3025 = appItem;
        this.f3026 = r2;
        this.f3027 = i;
    }

    public final boolean onLongClick(View view) {
        return this.f3025.mo7715(this.f3026, this.f3027, view);
    }
}
