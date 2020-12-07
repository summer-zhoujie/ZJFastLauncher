package com.wpengapp.support;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.AnalyticsConstants;
import com.umeng.analytics.StoreHelper;
import com.wpengapp.support.ImprintHandler;

/* renamed from: com.wpengapp.support.Ҍ */
public class ImLatent implements OnImprintChangedListener {

    /* renamed from: ֏ */
    public static ImLatent f1874;

    /* renamed from: ؠ */
    public StoreHelper f1875;

    /* renamed from: ހ */
    public StatTracer f1876;

    /* renamed from: ށ */
    public long f1877 = 1296000000;

    /* renamed from: ނ */
    public int f1878 = 10000;

    /* renamed from: ރ */
    public long f1879 = 0;

    /* renamed from: ބ */
    public Context f1880;

    public ImLatent(Context context, StatTracer r4) {
        this.f1880 = context;
        this.f1875 = StoreHelper.m156a(context);
        this.f1876 = r4;
    }

    /* renamed from: ֏ */
    public static synchronized ImLatent m1835(Context context, StatTracer r3) {
        ImLatent r2;
        synchronized (ImLatent.class) {
            if (f1874 == null) {
                f1874 = new ImLatent(context, r3);
                f1874.mo8091(ImprintHandler.m1668(context).f1682);
            }
            r2 = f1874;
        }
        return r2;
    }

    /* renamed from: ֏ */
    public long mo8533() {
        return this.f1879;
    }

    /* renamed from: ֏ */
    public void mo8091(ImprintHandler.C0654 r7) {
        int i = r7.f1694;
        long j = 1296000000;
        if (i != -1 && i >= 48) {
            j = AnalyticsConstants.f108k * ((long) i);
        }
        this.f1877 = j;
        int i2 = 0;
        int i3 = r7.f1686;
        if (i3 != -1 && i3 >= 0 && i3 <= 1800) {
            i2 = i3 * 1000;
        }
        if (i2 == 0) {
            int i4 = AnalyticsConfig.sLatentWindow;
            if (i4 <= 0 || i4 > 1800000) {
                this.f1878 = 10000;
            } else {
                this.f1878 = i4;
            }
        } else {
            this.f1878 = i2;
        }
    }
}
