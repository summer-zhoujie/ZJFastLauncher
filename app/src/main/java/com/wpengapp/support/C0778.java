package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.adaptor.NotifyRecordAdaptor;

/* renamed from: com.wpengapp.support.Լ */
/* compiled from: lambda */
public final /* synthetic */ class C0778 implements View.OnClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ PopupDialog f1997;

    /* renamed from: ؠ */
    private final /* synthetic */ NotifyRecord f1998;

    public /* synthetic */ C0778(PopupDialog r1, NotifyRecord r2) {
        this.f1997 = r1;
        this.f1998 = r2;
    }

    public final void onClick(View view) {
        NotifyRecordAdaptor.m606(this.f1997, this.f1998, view);
    }
}
