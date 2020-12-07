package com.wpengapp.support;

import com.umeng.analytics.SafeRunnable;
import java.util.List;

/* renamed from: com.wpengapp.support.տ */
/* compiled from: UMCCAggregatedManager */
public class C0812 extends SafeRunnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Callback f2097;

    /* renamed from: ؠ */
    public final /* synthetic */ C1315 f2098;

    public C0812(C1315 r1, Callback r2) {
        this.f2098 = r1;
        this.f2097 = r2;
    }

    /* renamed from: a */
    public void mo7309a() {
        try {
            this.f2098.f3760.mo8031(new C1037(this));
            this.f2098.mo9586();
            C1315 r0 = this.f2098;
            List<String> r1 = r0.f3760.mo8036();
            if (r1 != null) {
                r0.f3765 = r1;
            }
            this.f2097.mo7310a("success", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
