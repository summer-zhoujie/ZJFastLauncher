package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.adaptor.NotifyRecordAdaptor;

/* renamed from: com.wpengapp.support.Ȳ */
/* compiled from: lambda */
public final /* synthetic */ class C0547 implements View.OnClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ PopupDialog f1099;

    /* renamed from: ؠ */
    private final /* synthetic */ NotifyRecord f1100;

    public /* synthetic */ C0547(PopupDialog r1, NotifyRecord r2) {
        this.f1099 = r1;
        this.f1100 = r2;
    }

    public final void onClick(View view) {
        NotifyRecordAdaptor.m604(this.f1099, this.f1100, view);
    }
}
