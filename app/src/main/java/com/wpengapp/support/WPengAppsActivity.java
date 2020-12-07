package com.wpengapp.support;

import android.view.View;
import com.wpengapp.support.activity.WPengAppsActivity;
import com.wpengapp.support.model.App;

/* renamed from: com.wpengapp.support.ũ */
class WPengAppsActivity implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ App f877;

    /* renamed from: ؠ */
    public final /* synthetic */ WPengAppsActivity.C0451 f878;

    public WPengAppsActivity(WPengAppsActivity.C0451 r1, App app) {
        this.f878 = r1;
        this.f877 = app;
    }

    public void onClick(View view) {
        SystemUtils.m3515(this.f878.f643, this.f877.indexUrl);
    }
}
