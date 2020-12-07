package com.wpengapp.support;

import android.widget.CompoundButton;
import com.wpengapp.lightstart.activity.adaptor.CreateTileAdaptor;

/* renamed from: com.wpengapp.support.ऩ */
/* compiled from: lambda */
public final /* synthetic */ class C1025 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: ֏ */
    private final /* synthetic */ CreateTileAdaptor.Item f2945;

    /* renamed from: ؠ */
    private final /* synthetic */ AppShortcut f2946;

    public /* synthetic */ C1025(CreateTileAdaptor.Item item, AppShortcut r2) {
        this.f2945 = item;
        this.f2946 = r2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f2945.mo7705(this.f2946, compoundButton, z);
    }
}
