package com.wpengapp.support;

import android.view.View;
import android.widget.CheckBox;
import com.wpengapp.support.UpdateHelper;
import com.wpengapp.support.model.App;

/* renamed from: com.wpengapp.support.Ţ */
/* compiled from: UpdateHelper */
public final class C0490 implements OnDialogClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ App.AppVersion f869;

    /* renamed from: ؠ */
    public final /* synthetic */ UpdateHelper.C0447 f870;

    /* renamed from: ހ */
    public final /* synthetic */ CheckBox f871;

    public C0490(App.AppVersion appVersion, UpdateHelper.C0447 r2, CheckBox checkBox) {
        this.f869 = appVersion;
        this.f870 = r2;
        this.f871 = checkBox;
    }

    public boolean onClick(View view) {
        if (this.f869.forceUpdate) {
            UpdateHelper.C0447 r1 = this.f870;
            if (r1 != null) {
                r1.mo7806();
            }
        } else if (this.f871.isChecked()) {
            UpdateHelper.m739(this.f869.versionName);
        }
        UpdateHelper.f594 = false;
        return false;
    }
}
