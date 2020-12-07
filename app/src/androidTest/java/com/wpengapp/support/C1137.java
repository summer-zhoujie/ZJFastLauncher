package com.wpengapp.support;

import android.app.Activity;
import com.wpengapp.support.C0678;
import com.wpengapp.support.licensing.activity.InputContactActivity;

/* renamed from: com.wpengapp.support.ଧ */
/* compiled from: PayManager */
class C1137 implements InputContactActivity.C0453 {

    /* renamed from: ֏ */
    public final /* synthetic */ C0678.C0680 f3228;

    /* renamed from: ؠ */
    public final /* synthetic */ UserInfo f3229;

    /* renamed from: ހ */
    public final /* synthetic */ Activity f3230;

    /* renamed from: ށ */
    public final /* synthetic */ int f3231;

    public C1137(C0678.C0680 r1, UserInfo r2, Activity activity, int i) {
        this.f3228 = r1;
        this.f3229 = r2;
        this.f3230 = activity;
        this.f3231 = i;
    }

    /* renamed from: ֏ */
    public void mo7857(String str, boolean z, InputContactActivity inputContactActivity) {
        "pay, get contact " + str;
        if (!NetworkUtils.m1800()) {
            this.f3228.mo8029(this.f3229, false, this.f3230.getString(R$string.wpengpay_error_network));
            return;
        }
        int i = this.f3231;
        if (i == 6 || i == 7) {
            C0678.m1729(inputContactActivity, this.f3230, this.f3231, this.f3229, str, z, this.f3228);
            return;
        }
        C0678.m1730(inputContactActivity, this.f3230, this.f3229, str, z, this.f3228);
    }
}
