package com.wpengapp.support;

import android.widget.CompoundButton;
import com.wpengapp.lightstart.activity.adaptor.CustomPageAdaptor;

/* renamed from: com.wpengapp.support.ŗ */
/* compiled from: lambda */
public final /* synthetic */ class C0483 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: ֏ */
    private final /* synthetic */ CustomPageAdaptor.AppItem f834;

    /* renamed from: ؠ */
    private final /* synthetic */ CustomPageAdaptor.C0440 f835;

    public /* synthetic */ C0483(CustomPageAdaptor.AppItem appItem, CustomPageAdaptor.C0440 r2) {
        this.f834 = appItem;
        this.f835 = r2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f834.mo7709(this.f835, compoundButton, z);
    }
}
