package com.wpengapp.support;

import android.content.Context;
import com.wpengapp.support.C0678;
import com.wpengapp.support.activity.UserUpgradeActivity;

/* renamed from: com.wpengapp.support.ઞ */
/* compiled from: UserUpgradeActivity */
class C1102 implements C0678.C0680 {

    /* renamed from: ֏ */
    public final /* synthetic */ UserUpgradeActivity f3135;

    public C1102(UserUpgradeActivity userUpgradeActivity) {
        this.f3135 = userUpgradeActivity;
    }

    /* renamed from: ֏ */
    public void mo8029(UserInfo r3, boolean z, String str) {
        if (z) {
            UserInfo r4 = this.f3135.f640.f3172;
            if (r4 == null || !r4.f2125) {
                C0826.m2172(R$string.pw_user_upgrade_success2, new Object[0]);
            } else {
                C0826.m2172(R$string.pw_user_upgrade_success, new Object[0]);
            }
            this.f3135.finish();
            return;
        }
        if ((this.f3135.getString(R$string.wpengpay_error_cause) + this.f3135.getString(R$string.wpengpay_error_user_cancel)).equals(str)) {
            C0826.m2179(R$string.wpengpay_error_user_cancel, new Object[0]);
        } else {
            C1114.m2999((Context) this.f3135, str);
        }
    }
}
