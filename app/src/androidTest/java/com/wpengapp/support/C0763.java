package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.wpengapp.support.ԍ */
/* compiled from: ShareHelper */
class C0763 extends C0969 {
    public C0763(Context context) {
        super(context);
    }

    /* renamed from: ֏ */
    public Intent mo8616(String str, String str2, boolean z) {
        if (!"com.tencent.mm".equals(str) || !"com.tencent.mm.ui.tools.ShareToTimeLineUI".equals(str2) || !z) {
            return C0771.m2063(str, str2, Utils.m1864(R$string.pw_share_app_text, SystemUtils.m3519(AppUtils.m1163()), C1279.m3442(), C1279.m3400()));
        }
        return C0771.m2062(Utils.m1864(R$string.pw_share_app_text_timeline, SystemUtils.m3519(AppUtils.m1163()), C1279.m3442()), QRCodeEncoder.m3204(C1279.m3400(), 320));
    }
}
