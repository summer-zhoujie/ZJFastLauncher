package com.wpengapp.support;

import android.content.ComponentName;
import android.view.View;
import com.wpengapp.lightstart.activity.MoreSettingsActivity;

/* renamed from: com.wpengapp.support.ཙ */
/* compiled from: lambda */
public final /* synthetic */ class C1261 implements OnDialogClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ MoreSettingsActivity f3559;

    /* renamed from: ؠ */
    private final /* synthetic */ boolean f3560;

    /* renamed from: ހ */
    private final /* synthetic */ ComponentName f3561;

    public /* synthetic */ C1261(MoreSettingsActivity moreSettingsActivity, boolean z, ComponentName componentName) {
        this.f3559 = moreSettingsActivity;
        this.f3560 = z;
        this.f3561 = componentName;
    }

    public final boolean onClick(View view) {
        return this.f3559.mo7643(this.f3560, this.f3561, view);
    }
}
