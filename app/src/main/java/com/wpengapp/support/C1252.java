package com.wpengapp.support;

import com.wpengapp.lightstart.config.DefaultConfig;

/* renamed from: com.wpengapp.support.ཏ */
/* compiled from: MainActivity */
class C1252 implements RetCallback<DefaultConfig> {

    /* renamed from: ֏ */
    public final /* synthetic */ C1177 f3546;

    public C1252(C1177 r1) {
        this.f3546 = r1;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        DefaultConfig defaultConfig = (DefaultConfig) obj;
        this.f3546.f3358.mItemSyncError.setVisibility(8);
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        this.f3546.f3358.mItemSyncError.setVisibility(0);
    }
}
