package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Ƚ */
class UserUpgradeActivity implements QueryCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ int f1198;

    /* renamed from: ؠ */
    public final /* synthetic */ com.wpengapp.support.activity.UserUpgradeActivity f1199;

    public UserUpgradeActivity(com.wpengapp.support.activity.UserUpgradeActivity userUpgradeActivity, int i) {
        this.f1199 = userUpgradeActivity;
        this.f1198 = i;
    }

    /* renamed from: ֏ */
    public void mo8024(C1114 r1, boolean z, boolean z2, int i) {
        if (!z) {
            r1.mo9297((OnDialogClickListener) null, (OnDialogClickListener) new C1134(this));
        } else {
            this.f1199.mo7834(this.f1198, r1.f3172);
        }
    }
}
