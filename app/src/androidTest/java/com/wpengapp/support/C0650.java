package com.wpengapp.support;

import android.content.Context;
import android.view.View;
import com.wpengapp.support.activity.WPengVersionActivity;

/* renamed from: com.wpengapp.support.λ */
/* compiled from: FullRuleChecker */
public final class C0650 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ Context f1670;

    /* renamed from: ؠ */
    public final /* synthetic */ FloatWindow f1671;

    /* renamed from: ހ */
    public final /* synthetic */ View f1672;

    public C0650(Context context, FloatWindow r2, View view) {
        this.f1670 = context;
        this.f1671 = r2;
        this.f1672 = view;
    }

    public void onClick(View view) {
        WPengVersionActivity.m821(this.f1670);
        C1079.m2881(this.f1671, this.f1672);
    }
}
