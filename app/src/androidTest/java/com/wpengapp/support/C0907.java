package com.wpengapp.support;

import android.media.projection.MediaProjection;

/* renamed from: com.wpengapp.support.ۊ */
/* compiled from: ScreencapHelper */
class C0907 implements RetCallback<MediaProjection> {

    /* renamed from: ֏ */
    public final /* synthetic */ RetCallback f2438;

    public C0907(RetCallback r1) {
        this.f2438 = r1;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        MediaProjection mediaProjection = (MediaProjection) obj;
        ScreencapHelper.f579 = mediaProjection;
        this.f2438.mo7931(mediaProjection);
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        this.f2438.mo7932(str);
    }
}
