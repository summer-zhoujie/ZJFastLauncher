package com.wpengapp.support;

import com.wpengapp.lightstart.activity.QuickScanActivity;
import com.wpengapp.lightstart.activity.adaptor.CreateTileAdaptor;

/* renamed from: com.wpengapp.support.ฯ */
/* compiled from: lambda */
public final /* synthetic */ class C1202 implements OnDismissListener {

    /* renamed from: ֏ */
    private final /* synthetic */ CreateTileAdaptor f3446;

    public /* synthetic */ C1202(CreateTileAdaptor createTileAdaptor) {
        this.f3446 = createTileAdaptor;
    }

    public final void onDismiss() {
        QuickScanActivity.m526(this.f3446);
    }
}
