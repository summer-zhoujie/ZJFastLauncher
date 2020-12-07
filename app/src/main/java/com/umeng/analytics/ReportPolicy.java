package com.umeng.analytics;

import android.content.Context;
import android.support.p003v7.widget.TooltipCompatHandler;
import com.wpengapp.support.Defcon;
import com.wpengapp.support.DeviceConfig;
import com.wpengapp.support.MemoCache;
import com.wpengapp.support.StatTracer;

public class ReportPolicy {
    public static final int BATCH_AT_LAUNCH = 1;
    public static final int BATCH_BY_INTERVAL = 6;
    public static final int DAILY = 4;
    public static final int REALTIME = 0;
    public static final int SMART_POLICY = 8;
    public static final int WIFIONLY = 5;

    /* renamed from: a */
    public static final int f78a = 2;

    /* renamed from: b */
    public static final int f79b = 3;

    /* renamed from: com.umeng.analytics.ReportPolicy$a */
    public static class C0379a extends C0387i {

        /* renamed from: a */
        public final long f80a = TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS;

        /* renamed from: b */
        public StatTracer f81b;

        public C0379a(StatTracer r3) {
            this.f81b = r3;
        }

        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            return System.currentTimeMillis() - this.f81b.f1225 >= TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$c */
    public static class C0381c extends C0387i {

        /* renamed from: a */
        public long f84a;

        /* renamed from: b */
        public long f85b = 0;

        public C0381c(int i) {
            this.f84a = (long) i;
            this.f85b = System.currentTimeMillis();
        }

        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            return System.currentTimeMillis() - this.f85b >= this.f84a;
        }

        /* renamed from: a */
        public boolean mo7272a() {
            return System.currentTimeMillis() - this.f85b < this.f84a;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$d */
    public static class C0382d extends C0387i {
        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            return z;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$e */
    public static class C0383e extends C0387i {

        /* renamed from: a */
        public static long f86a = 90000;

        /* renamed from: b */
        public static long f87b = 86400000;

        /* renamed from: c */
        public long f88c;

        /* renamed from: d */
        public StatTracer f89d;

        public C0383e(StatTracer r1, long j) {
            this.f89d = r1;
            mo7273a(j);
        }

        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            return System.currentTimeMillis() - this.f89d.f1225 >= this.f88c;
        }

        /* renamed from: b */
        public long mo7274b() {
            return this.f88c;
        }

        /* renamed from: a */
        public void mo7273a(long j) {
            if (j < f86a || j > f87b) {
                this.f88c = f86a;
            } else {
                this.f88c = j;
            }
        }

        /* renamed from: a */
        public static boolean m46a(int i) {
            return ((long) i) >= f86a;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$f */
    public static class C0384f extends C0387i {

        /* renamed from: a */
        public final int f90a;

        /* renamed from: b */
        public MemoCache f91b;

        public C0384f(MemoCache r1, int i) {
            this.f90a = i;
            this.f91b = r1;
        }

        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            return this.f91b.mo8556() > this.f90a;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$g */
    public static class C0385g extends C0387i {

        /* renamed from: a */
        public long f92a = AnalyticsConstants.f107j;

        /* renamed from: b */
        public StatTracer f93b;

        public C0385g(StatTracer r3) {
            this.f93b = r3;
        }

        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            return System.currentTimeMillis() - this.f93b.f1225 >= this.f92a;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$h */
    public static class C0386h extends C0387i {
        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            return true;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$i */
    public static class C0387i {
        /* renamed from: a */
        public boolean mo7272a() {
            return true;
        }

        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            return true;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$j */
    public static class C0388j extends C0387i {

        /* renamed from: a */
        public Context f94a = null;

        public C0388j(Context context) {
            this.f94a = context;
        }

        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            return DeviceConfig.m2328(this.f94a);
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$k */
    public static class C0389k extends C0387i {

        /* renamed from: a */
        public final long f95a = 10800000;

        /* renamed from: b */
        public StatTracer f96b;

        public C0389k(StatTracer r3) {
            this.f96b = r3;
        }

        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            return System.currentTimeMillis() - this.f96b.f1225 >= 10800000;
        }
    }

    /* renamed from: a */
    public static boolean m39a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$b */
    public static class C0380b extends C0387i {

        /* renamed from: a */
        public Defcon f82a;

        /* renamed from: b */
        public StatTracer f83b;

        public C0380b(StatTracer r1, Defcon r2) {
            this.f83b = r1;
            this.f82a = r2;
        }

        /* renamed from: a */
        public boolean mo7271a(boolean z) {
            long currentTimeMillis = System.currentTimeMillis();
            int i = this.f82a.f971;
            if (currentTimeMillis - this.f83b.f1225 >= (i != 1 ? i != 2 ? i != 3 ? 0 : AnalyticsConstants.f107j : 28800000 : 14400000)) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo7272a() {
            return this.f82a.mo8092();
        }
    }
}
