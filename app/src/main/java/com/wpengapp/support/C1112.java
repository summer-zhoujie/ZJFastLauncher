package com.wpengapp.support;

import android.content.Context;
import com.umeng.analytics.QueuedWork;

/* renamed from: com.wpengapp.support.બ */
/* compiled from: CacheService */
public final class C1112 implements ICacheService {

    /* renamed from: ֏ */
    public static C1112 f3165;

    /* renamed from: ؠ */
    public ICacheService f3166 = new C0878(this.f3167);

    /* renamed from: ހ */
    public Context f3167;

    public C1112(Context context) {
        this.f3167 = context.getApplicationContext();
    }

    /* renamed from: ֏ */
    public static synchronized C1112 m2993(Context context) {
        C1112 r2;
        synchronized (C1112.class) {
            if (f3165 == null && context != null) {
                f3165 = new C1112(context);
            }
            r2 = f3165;
        }
        return r2;
    }

    /* renamed from: a */
    public void mo8609a() {
        QueuedWork.m120b(new C0916(this));
    }

    /* renamed from: b */
    public void mo8610b() {
        QueuedWork.m120b(new C1158(this));
    }

    /* renamed from: ؠ */
    public void mo8613(IProtocol r2) {
        this.f3166.mo8613(r2);
    }

    /* renamed from: ֏ */
    public void mo8612(IProtocol r2) {
        QueuedWork.m120b(new C1334(this, r2));
    }

    /* renamed from: ֏ */
    public void mo8611() {
        QueuedWork.m121c(new CacheService(this));
    }
}
