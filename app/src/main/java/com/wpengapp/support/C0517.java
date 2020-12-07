package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.ToastRecordAppActivity;

/* renamed from: com.wpengapp.support.Ƭ */
/* compiled from: lambda */
public final /* synthetic */ class C0517 implements View.OnClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ PopupDialog f949;

    /* renamed from: ؠ */
    private final /* synthetic */ ToastRecord f950;

    public /* synthetic */ C0517(PopupDialog r1, ToastRecord r2) {
        this.f949 = r1;
        this.f950 = r2;
    }

    public final void onClick(View view) {
        ToastRecordAppActivity.m556(this.f949, this.f950, view);
    }
}
