package com.wpengapp.support;

import android.os.Handler;
import com.wpengapp.lightstart.config.DefaultConfig;

/* renamed from: com.wpengapp.support.भ */
/* compiled from: AccService */
class C1028 implements RetCallback<DefaultConfig> {

    /* renamed from: ֏ */
    public final /* synthetic */ C0929 f2948;

    public C1028(C0929 r1) {
        this.f2948 = r1;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        DefaultConfig defaultConfig = (DefaultConfig) obj;
        C0929 r5 = this.f2948;
        r5.f2523 = r5.f2525.f604;
        Handler r52 = this.f2948.f2525.f503;
        C0929 r0 = this.f2948;
        r52.postDelayed(r0.f2522, r0.f2524);
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        Handler r5 = this.f2948.f2525.f503;
        C0929 r0 = this.f2948;
        r5.postDelayed(r0.f2522, r0.f2523);
        C0929 r52 = this.f2948;
        r52.f2523 = r52.f2525.f604 + r52.f2523;
    }
}
