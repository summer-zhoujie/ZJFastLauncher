package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.social.UMSocialConstants;
import com.wpengapp.support.C0812;
import com.wpengapp.support.C1096;
import com.wpengapp.support.C1112;
import com.wpengapp.support.C1174;
import com.wpengapp.support.C1315;
import com.wpengapp.support.Callback;
import com.wpengapp.support.DeviceConfig;
import com.wpengapp.support.IProtocol;
import com.wpengapp.support.MLog;
import com.wpengapp.support.OnAppCrashHandler;
import com.wpengapp.support.SessionTracker;
import com.wpengapp.support.UMEntry;
import com.wpengapp.support.Utils;
import com.wpengapp.support.ViewPageTracker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.umeng.analytics.d */
public class InternalAgent implements OnAppCrashHandler {

    /* renamed from: a */
    public Context f125a = null;

    /* renamed from: b */
    public ISysListener f126b;

    /* renamed from: c */
    public C1096 f127c = new C1096();

    /* renamed from: d */
    public ViewPageTracker f128d = new ViewPageTracker();

    /* renamed from: e */
    public SessionTracker f129e = new SessionTracker();

    /* renamed from: f */
    public C1174 f130f;

    /* renamed from: g */
    public C1112 f131g;

    /* renamed from: h */
    public C1315 f132h = null;

    /* renamed from: i */
    public boolean f133i = false;

    /* renamed from: j */
    public boolean f134j = false;

    public InternalAgent() {
        this.f127c.f3118 = this;
    }

    /* renamed from: e */
    private void m73e(Context context) {
        if (!this.f133i) {
            this.f125a = context.getApplicationContext();
            this.f130f = new C1174(this.f125a);
            this.f131g = C1112.m2993(this.f125a);
            this.f133i = true;
            if (this.f132h == null) {
                C1315.f3758 = this.f125a;
                this.f132h = C1315.C1317.f3769;
            }
            if (!this.f134j) {
                QueuedWork.m120b(new SafeRunnable() {
                    /* renamed from: a */
                    public void mo7309a() {
                        C1315 r0 = InternalAgent.this.f132h;
                        C03911 r1 = new Callback() {
                            /* renamed from: a */
                            public void mo7310a(Object obj, boolean z) {
                                InternalAgent.this.f134j = true;
                            }
                        };
                        if (!r0.f3762) {
                            QueuedWork.m120b(new C0812(r0, r1));
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m75g(Context context) {
        this.f129e.mo8543(context);
        this.f128d.mo8286(context);
        ISysListener cVar = this.f126b;
        if (cVar != null) {
            cVar.mo7276b();
        }
        this.f131g.mo8610b();
    }

    /* renamed from: c */
    public void mo7303c(Context context) {
        try {
            if (!this.f133i) {
                m73e(context);
            }
            this.f131g.mo8609a();
        } catch (Exception e) {
            MLog.m1772((Throwable) e);
        }
    }

    /* renamed from: d */
    public void mo7305d(Context context) {
        try {
            this.f128d.mo8285();
            m75g(context);
            context.getSharedPreferences("umeng_general_config", 0).edit().commit();
            this.f132h.mo9588();
            QueuedWork.m117a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public void mo7308f(boolean z) {
        AnalyticsConfig.sEncrypt = z;
    }

    /* renamed from: f */
    private void m74f(Context context) {
        this.f129e.mo8542(context);
        ISysListener cVar = this.f126b;
        if (cVar != null) {
            cVar.mo7275a();
        }
    }

    /* renamed from: a */
    public void mo7291a(String str) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            try {
                this.f128d.mo8287(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void mo7300b(String str) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            try {
                this.f128d.mo8288(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public void mo7304c(boolean z) {
        AnalyticsConfig.ACTIVITY_DURATION_OPEN = z;
    }

    /* renamed from: a */
    public void mo7290a(ISysListener cVar) {
        this.f126b = cVar;
    }

    /* renamed from: b */
    public void mo7298b(final Context context) {
        if (context == null) {
            MLog.m1776("unexpected null context in onPause");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            this.f128d.mo8288(context.getClass().getName());
        }
        try {
            if (!this.f133i) {
                m73e(context);
            }
            QueuedWork.m118a(new SafeRunnable() {
                /* renamed from: a */
                public void mo7309a() {
                    InternalAgent.this.m75g(context.getApplicationContext());
                    InternalAgent.this.f132h.mo9588();
                }
            });
        } catch (Exception e) {
            MLog.m1777(MLog.f1805, "Exception occurred in Mobclick.onRause(). ", e);
        }
    }

    /* renamed from: a */
    public void mo7281a(Context context, int i) {
        AnalyticsConfig.m33a(context, i);
    }

    /* renamed from: a */
    public void mo7292a(String str, String str2) {
        AnalyticsConfig.mWrapperType = str;
        AnalyticsConfig.mWrapperVersion = str2;
    }

    /* renamed from: d */
    public void mo7306d(boolean z) {
        AnalyticsConstants.f102e = z;
    }

    /* renamed from: a */
    public void mo7280a(final Context context) {
        if (context == null) {
            MLog.m1776("unexpected null context in onResume");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            this.f128d.mo8287(context.getClass().getName());
        }
        try {
            if (!this.f133i) {
                m73e(context);
            }
            QueuedWork.m118a(new SafeRunnable() {
                /* renamed from: a */
                public void mo7309a() {
                    InternalAgent.m69a(InternalAgent.this, context.getApplicationContext());
                }
            });
        } catch (Exception e) {
            MLog.m1777(MLog.f1805, "Exception occurred in Mobclick.onResume(). ", e);
        }
    }

    /* renamed from: b */
    public void mo7301b(final String str, final String str2) {
        try {
            QueuedWork.m118a(new SafeRunnable() {
                /* renamed from: a */
                public void mo7309a() {
                    String[] a = InternalConfig.m115a(InternalAgent.this.f125a);
                    if (a == null || !str.equals(a[0]) || !str2.equals(a[1])) {
                        boolean r0 = InternalAgent.this.mo7277a().mo8544(InternalAgent.this.f125a);
                        C1112.m2993(InternalAgent.this.f125a).mo8611();
                        if (r0) {
                            InternalAgent.this.mo7277a().mo8545(InternalAgent.this.f125a);
                        }
                        InternalConfig.m114a(InternalAgent.this.f125a, str, str2);
                    }
                }
            });
        } catch (Exception e) {
            MLog.m1777(MLog.f1805, " Excepthon  in  onProfileSignIn", e);
        }
    }

    /* renamed from: e */
    public void mo7307e(boolean z) {
        MLog.f1804 = z;
        UMSocialConstants.f263v = z;
    }

    /* renamed from: b */
    public void mo7296b() {
        try {
            QueuedWork.m118a(new SafeRunnable() {
                /* renamed from: a */
                public void mo7309a() {
                    String[] a = InternalConfig.m115a(InternalAgent.this.f125a);
                    if (a != null && !TextUtils.isEmpty(a[0]) && !TextUtils.isEmpty(a[1])) {
                        boolean r0 = InternalAgent.this.mo7277a().mo8544(InternalAgent.this.f125a);
                        C1112.m2993(InternalAgent.this.f125a).mo8611();
                        if (r0) {
                            InternalAgent.this.mo7277a().mo8545(InternalAgent.this.f125a);
                        }
                        InternalConfig.m116b(InternalAgent.this.f125a);
                    }
                }
            });
        } catch (Exception e) {
            MLog.m1777(MLog.f1805, " Excepthon  in  onProfileSignOff", e);
        }
    }

    /* renamed from: a */
    public SessionTracker mo7277a() {
        return this.f129e;
    }

    /* renamed from: b */
    public void mo7302b(boolean z) {
        AnalyticsConfig.ENABLE_MEMORY_BUFFER = z;
    }

    /* renamed from: a */
    public void mo7285a(Context context, String str, HashMap<String, Object> hashMap) {
        try {
            if (!this.f133i) {
                m73e(context);
            }
            this.f130f.mo9392(str, hashMap);
        } catch (Exception e) {
            MLog.m1772((Throwable) e);
        }
    }

    /* renamed from: b */
    public void mo7299b(Context context, String str) {
        if (context != null) {
            this.f125a = context.getApplicationContext();
        }
        AnalyticsConfig.m37b(context, str);
    }

    /* renamed from: b */
    public void mo7297b(long j) {
        AnalyticsConfig.kContinueSessionMillis = j;
    }

    /* renamed from: a */
    public void mo7283a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                MLog.m1776("unexpected null context in reportError");
                return;
            }
            try {
                if (!this.f133i) {
                    m73e(context);
                }
                UMEntry.C0555 r3 = new UMEntry.C0555();
                r3.f1122 = System.currentTimeMillis();
                r3.f1123 = 2;
                r3.f1124 = str;
                this.f131g.mo8612((IProtocol) r3);
            } catch (Exception e) {
                MLog.m1772((Throwable) e);
            }
        }
    }

    /* renamed from: a */
    public void mo7287a(Context context, Throwable th) {
        if (context != null && th != null) {
            try {
                mo7283a(context, DataHelper.m58a(th));
            } catch (Exception e) {
                MLog.m1772((Throwable) e);
            }
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m69a(InternalAgent dVar, Context context) {
        dVar.f129e.mo8542(context);
        ISysListener cVar = dVar.f126b;
        if (cVar != null) {
            cVar.mo7275a();
        }
    }

    /* renamed from: a */
    public void mo7288a(Context context, List<String> list, int i, String str) {
        try {
            if (!this.f133i) {
                m73e(context);
            }
            this.f130f.mo9395(list, i, str);
        } catch (Exception e) {
            MLog.m1772((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo7284a(Context context, String str, String str2, long j, int i) {
        try {
            if (!this.f133i) {
                m73e(context);
            }
            this.f130f.mo9391(str, str2, j, i);
        } catch (Exception e) {
            MLog.m1772((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo7286a(Context context, String str, Map<String, Object> map, long j) {
        try {
            if (!this.f133i) {
                m73e(context);
            }
            this.f130f.mo9393(str, map, j);
        } catch (Exception e) {
            MLog.m1772((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo7293a(Throwable th) {
        try {
            this.f128d.mo8285();
            if (this.f125a != null) {
                if (!(th == null || this.f131g == null)) {
                    UMEntry.C0555 r0 = new UMEntry.C0555();
                    r0.f1122 = System.currentTimeMillis();
                    r0.f1123 = 1;
                    r0.f1124 = DataHelper.m58a(th);
                    this.f131g.mo8612((IProtocol) r0);
                }
                this.f132h.mo9588();
                m75g(this.f125a);
                Utils.m1861(this.f125a).edit().commit();
            }
            QueuedWork.m117a();
        } catch (Exception e) {
            MLog.m1777(MLog.f1805, "Exception in onAppCrash", e);
        }
    }

    /* renamed from: a */
    public void mo7295a(boolean z) {
        AnalyticsConfig.CATCH_EXCEPTION = z;
    }

    /* renamed from: a */
    public void mo7294a(GL10 gl10) {
        String[] r3 = DeviceConfig.m2314(gl10);
        if (r3.length == 2) {
            AnalyticsConfig.GPU_VENDER = r3[0];
            AnalyticsConfig.GPU_RENDERER = r3[1];
        }
    }

    /* renamed from: a */
    public void mo7278a(double d, double d2) {
        if (AnalyticsConfig.f62a == null) {
            AnalyticsConfig.f62a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f62a;
        dArr[0] = d;
        dArr[1] = d2;
    }

    /* renamed from: a */
    public void mo7279a(long j) {
        AnalyticsConfig.sLatentWindow = ((int) j) * 1000;
    }

    /* renamed from: a */
    public void mo7282a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context != null) {
            this.f125a = context.getApplicationContext();
        }
        if (eScenarioType != null) {
            mo7281a(context, eScenarioType.toValue());
        }
    }

    /* renamed from: a */
    public void mo7289a(MobclickAgent.UMAnalyticsConfig uMAnalyticsConfig) {
        Context context = uMAnalyticsConfig.mContext;
        if (context != null) {
            this.f125a = context.getApplicationContext();
        }
        if (!TextUtils.isEmpty(uMAnalyticsConfig.mAppkey)) {
            AnalyticsConfig.m34a(uMAnalyticsConfig.mContext, uMAnalyticsConfig.mAppkey);
            if (!TextUtils.isEmpty(uMAnalyticsConfig.mChannelId)) {
                AnalyticsConfig.f64c = uMAnalyticsConfig.mChannelId;
            }
            AnalyticsConfig.CATCH_EXCEPTION = uMAnalyticsConfig.mIsCrashEnable;
            mo7282a(this.f125a, uMAnalyticsConfig.mType);
            return;
        }
        MLog.m1776("the appkey is null!");
    }
}
