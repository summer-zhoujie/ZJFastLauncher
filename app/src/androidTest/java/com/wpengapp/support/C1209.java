package com.wpengapp.support;

import com.wpengapp.support.activity.AboutActivity;

/* renamed from: com.wpengapp.support.ກ */
/* compiled from: AboutActivity */
class C1209 implements QueryCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ boolean f3466;

    /* renamed from: ؠ */
    public final /* synthetic */ AboutActivity f3467;

    public C1209(AboutActivity aboutActivity, boolean z) {
        this.f3467 = aboutActivity;
        this.f3466 = z;
    }

    /* renamed from: ֏ */
    public void mo8024(C1114 r1, boolean z, boolean z2, int i) {
        if (!z || r1.f3172 == null) {
            String string = this.f3467.getString(R$string.wpengpay_pay_info_load_fail2);
            this.f3467.f617.setDes((CharSequence) string);
            this.f3467.f618.setText(string);
            this.f3467.f619.setVisibility(8);
            this.f3467.f620.setVisibility(8);
            if (!this.f3466) {
                r1.mo9297((OnDialogClickListener) null, (OnDialogClickListener) new C1069(this));
            }
        } else {
            this.f3467.mo7817(r1.f3172);
        }
        if (r1.f3172 != null) {
            UserInfo unused = this.f3467.f622 = r1.f3172;
        }
    }
}
