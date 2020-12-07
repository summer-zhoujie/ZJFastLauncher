package com.wpengapp.support;

import android.app.Dialog;
import com.wpengapp.support.C0771;

/* renamed from: com.wpengapp.support.প */
/* compiled from: ShareHelper */
public final class C1061 implements C0771.C0772 {

    /* renamed from: ֏ */
    public final /* synthetic */ Dialog f3034;

    /* renamed from: ؠ */
    public final /* synthetic */ C0771.C0772 f3035;

    public C1061(Dialog dialog, C0771.C0772 r2) {
        this.f3034 = dialog;
        this.f3035 = r2;
    }

    /* renamed from: ֏ */
    public void mo8216(String str, String str2) {
        this.f3034.dismiss();
        C0771.C0772 r0 = this.f3035;
        if (r0 != null) {
            r0.mo8216(str, str2);
        }
    }
}
