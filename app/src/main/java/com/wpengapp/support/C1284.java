package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.adaptor.NotifyRecordAdaptor;

/* renamed from: com.wpengapp.support.ဎ */
/* compiled from: lambda */
public final /* synthetic */ class C1284 implements View.OnLongClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ NotifyRecordAdaptor.Item f3611;

    /* renamed from: ؠ */
    private final /* synthetic */ NotifyRecord f3612;

    /* renamed from: ހ */
    private final /* synthetic */ int f3613;

    public /* synthetic */ C1284(NotifyRecordAdaptor.Item item, NotifyRecord r2, int i) {
        this.f3611 = item;
        this.f3612 = r2;
        this.f3613 = i;
    }

    public final boolean onLongClick(View view) {
        return this.f3611.mo7712(this.f3612, this.f3613, view);
    }
}
