package com.wpengapp.support;

import android.content.Context;
import android.view.View;
import com.wpengapp.baseui.AppWrapper;
import com.wpengapp.lightstart.activity.AppReportActivity;

/* renamed from: com.wpengapp.support.ݬ */
/* compiled from: AppReportActivity */
class C0938 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ AppWrapper f2545;

    /* renamed from: ؠ */
    public final /* synthetic */ AppReportActivity.C0436 f2546;

    public C0938(AppReportActivity.C0436 r1, AppWrapper appWrapper) {
        this.f2546 = r1;
        this.f2545 = appWrapper;
    }

    public void onClick(View view) {
        AppReportActivity appReportActivity = AppReportActivity.this;
        AppWrapper appWrapper = this.f2545;
        String str = appWrapper.packageName;
        CharSequence charSequence = appWrapper.name;
        AppReportActivity.m353((Context) appReportActivity, str);
    }
}
