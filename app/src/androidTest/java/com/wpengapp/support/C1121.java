package com.wpengapp.support;

import android.widget.CompoundButton;
import com.wpengapp.baseui.widget.SwitchButton;
import com.wpengapp.lightstart.activity.AutoLoginActivity;

/* renamed from: com.wpengapp.support.ઽ */
/* compiled from: lambda */
public final /* synthetic */ class C1121 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: ֏ */
    private final /* synthetic */ AutoLoginActivity f3186;

    /* renamed from: ؠ */
    private final /* synthetic */ AutoLoginActivity.C0438 f3187;

    /* renamed from: ހ */
    private final /* synthetic */ SwitchButton f3188;

    public /* synthetic */ C1121(AutoLoginActivity autoLoginActivity, AutoLoginActivity.C0438 r2, SwitchButton switchButton) {
        this.f3186 = autoLoginActivity;
        this.f3187 = r2;
        this.f3188 = switchButton;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f3186.mo7603(this.f3187, this.f3188, compoundButton, z);
    }
}
