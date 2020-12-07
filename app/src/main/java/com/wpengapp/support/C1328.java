package com.wpengapp.support;

import android.content.Context;
import android.view.View;
import com.wpengapp.support.activity.AboutActivity;

/* renamed from: com.wpengapp.support.ს */
/* compiled from: ShareHelper */
class C1328 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ AlertDialog f3797;

    /* renamed from: ؠ */
    public final /* synthetic */ Context f3798;

    public C1328(AlertDialog r1, Context context) {
        this.f3797 = r1;
        this.f3798 = context;
    }

    public void onClick(View view) {
        this.f3797.dismiss();
        Context context = this.f3798;
        String r0 = C0771.m2077();
        if ("*".equals(r0)) {
            r0 = null;
        }
        if (!SystemUtils.m3516(context, context.getPackageName(), r0)) {
            C0826.m2179(R$string.pw_grade_have_no, new Object[0]);
        }
        C0771.f1989.mo8105(AppUtils.m1159());
        C0771.f1990.mo8105(Long.valueOf(System.currentTimeMillis()));
        AboutActivity.C0450 r3 = AboutActivity.f616;
        if (r3 != null) {
            r3.mo7821();
        }
    }
}
