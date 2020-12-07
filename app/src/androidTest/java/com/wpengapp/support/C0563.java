package com.wpengapp.support;

import com.umeng.analytics.AnalyticsConstants;

/* renamed from: com.wpengapp.support.ȶ */
/* compiled from: UMCCAggregatedManager */
public class C0563 extends Callback {

    /* renamed from: a */
    public final /* synthetic */ C1315 f1196a;

    public C0563(C1315 r1) {
        this.f1196a = r1;
    }

    /* renamed from: a */
    public void mo7310a(Object obj, boolean z) {
        if (obj instanceof UMCCAggregatedListObject) {
            this.f1196a.f3759 = (UMCCAggregatedListObject) obj;
        } else if (obj instanceof Boolean) {
            C1315 r9 = this.f1196a;
            UMCCSystemBufferManager r10 = r9.f3761;
            C1333 r0 = new C1333(r9);
            if (r10.f3665.containsKey(AnalyticsConstants.f115r)) {
                UMCCSystemBuffer r92 = r10.f3665.get(AnalyticsConstants.f115r);
                r92.f3304++;
                r10.f3665.put(AnalyticsConstants.f115r, r92);
            } else {
                r10.f3665.put(AnalyticsConstants.f115r, new UMCCSystemBuffer(AnalyticsConstants.f115r, System.currentTimeMillis(), 1));
            }
            r0.mo7310a(r10, false);
        }
    }
}
