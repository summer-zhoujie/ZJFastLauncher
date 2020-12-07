package com.wpengapp.support;

import android.content.Context;
import android.media.projection.MediaProjection;

/* renamed from: com.wpengapp.support.Գ */
/* compiled from: CustomManager */
class C0769 implements RetCallback<MediaProjection> {

    /* renamed from: ֏ */
    public final /* synthetic */ Context f1987;

    public C0769(Context context) {
        this.f1987 = context;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        "requestMediaProjection success " + ((MediaProjection) obj);
        boolean unused = C1032.f2963 = false;
        if (SpHandler.f1756.mo8104().booleanValue()) {
            AppUtils.m1147((Runnable) new C0475(this.f1987), 100);
        }
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        "requestMediaProjection error " + str;
        C1032.f2963 = true;
        if (SpHandler.f1756.mo8104().booleanValue()) {
            AppUtils.m1147((Runnable) new C1029(this.f1987), 100);
        }
    }
}
