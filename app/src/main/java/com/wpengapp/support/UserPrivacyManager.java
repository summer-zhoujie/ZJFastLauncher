package com.wpengapp.support;

import android.view.View;

/* renamed from: com.wpengapp.support.Ў */
class UserPrivacyManager implements OnDialogClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ OnDialogClickListener f1786;

    public UserPrivacyManager(OnDialogClickListener r1) {
        this.f1786 = r1;
    }

    public boolean onClick(View view) {
        CommonSP.m1229().putLong("priagree", System.currentTimeMillis()).commit();
        OnDialogClickListener r0 = this.f1786;
        if (r0 == null) {
            return false;
        }
        r0.onClick(view);
        return false;
    }
}
