package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.adaptor.NotifyRecordAdaptor;

/* renamed from: com.wpengapp.support.Ĵ */
/* compiled from: lambda */
public final /* synthetic */ class C0468 implements View.OnClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ PopupDialog f799;

    /* renamed from: ؠ */
    private final /* synthetic */ NotifyRecord f800;

    public /* synthetic */ C0468(PopupDialog r1, NotifyRecord r2) {
        this.f799 = r1;
        this.f800 = r2;
    }

    public final void onClick(View view) {
        NotifyRecordAdaptor.m607(this.f799, this.f800, view);
    }
}
