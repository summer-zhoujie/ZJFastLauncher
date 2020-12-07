package com.wpengapp.support;

import android.text.TextUtils;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.MainActivity;
import com.wpengapp.lightstart.config.DefaultConfig;

/* renamed from: com.wpengapp.support.ง */
/* compiled from: MainActivity */
public class C1177 implements RetCallback<DefaultConfig> {

    /* renamed from: ֏ */
    public final /* synthetic */ boolean f3357;

    /* renamed from: ؠ */
    public final /* synthetic */ MainActivity f3358;

    public C1177(MainActivity mainActivity, boolean z) {
        this.f3358 = mainActivity;
        this.f3357 = z;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        DefaultConfig defaultConfig = (DefaultConfig) obj;
        this.f3358.mItemSyncError.setVisibility(8);
        if (this.f3357) {
            this.f3358.mo7424((int) R$string.cfg_sync_success);
        }
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        if (this.f3357) {
            this.f3358.mItemSyncError.setVisibility(0);
            if (TextUtils.isEmpty(str)) {
                this.f3358.mo7424((int) R$string.cfg_sync_error2);
            } else {
                this.f3358.mo7433((CharSequence) str);
            }
        } else if (C1149.m3093()) {
            C1149.m3077((RetCallback<DefaultConfig>) new C1252(this));
        }
    }
}
