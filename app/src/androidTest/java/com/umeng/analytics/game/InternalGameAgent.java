package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.p000v4.app.NotificationCompat;
import android.support.p003v7.view.SupportMenuInflater;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConstants;
import com.umeng.analytics.ISysListener;
import com.umeng.analytics.InternalAgent;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.QueuedWork;
import com.umeng.analytics.SafeRunnable;
import com.umeng.analytics.game.GameState;
import com.wpengapp.support.MLog;
import com.wpengapp.support.Utils;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* renamed from: com.umeng.analytics.game.c */
public class InternalGameAgent implements ISysListener {

    /* renamed from: a */
    public InternalAgent f169a = MobclickAgent.f70b;

    /* renamed from: b */
    public GameState f170b = null;

    /* renamed from: c */
    public final int f171c = 100;

    /* renamed from: d */
    public final int f172d = 1;

    /* renamed from: e */
    public final int f173e = 0;

    /* renamed from: f */
    public final int f174f = -1;

    /* renamed from: g */
    public final int f175g = 1;

    /* renamed from: h */
    public final String f176h = "level";

    /* renamed from: i */
    public final String f177i = "pay";

    /* renamed from: j */
    public final String f178j = "buy";

    /* renamed from: k */
    public final String f179k = "use";

    /* renamed from: l */
    public final String f180l = "bonus";

    /* renamed from: m */
    public final String f181m = SupportMenuInflater.XML_ITEM;

    /* renamed from: n */
    public final String f182n = "cash";

    /* renamed from: o */
    public final String f183o = "coin";

    /* renamed from: p */
    public final String f184p = "source";

    /* renamed from: q */
    public final String f185q = "amount";

    /* renamed from: r */
    public final String f186r = "user_level";

    /* renamed from: s */
    public final String f187s = "bonus_source";

    /* renamed from: t */
    public final String f188t = "level";

    /* renamed from: u */
    public final String f189u = NotificationCompat.CATEGORY_STATUS;

    /* renamed from: v */
    public final String f190v = "duration";

    /* renamed from: w */
    public final String f191w = "curtype";

    /* renamed from: x */
    public final String f192x = "orderid";

    /* renamed from: y */
    public final String f193y = "UMGameAgent.init(Context) should be called before any game api";

    /* renamed from: z */
    public Context f194z;

    public InternalGameAgent() {
        GameConfig.f156a = true;
    }

    /* renamed from: d */
    public void mo7335d(String str) {
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
        } else {
            m136a(str, -1);
        }
    }

    /* renamed from: a */
    public void mo7327a(Context context) {
        if (context == null) {
            MLog.m1776("Context is null, can't init GameAgent");
            return;
        }
        this.f194z = context.getApplicationContext();
        this.f169a.mo7290a((ISysListener) this);
        this.f170b = new GameState(this.f194z);
        this.f169a.mo7281a(context, 1);
    }

    /* renamed from: b */
    public void mo7332b(final String str) {
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        this.f170b.f157a = str;
        QueuedWork.m118a(new SafeRunnable() {
            /* renamed from: a */
            public void mo7309a() {
                InternalGameAgent.this.f170b.mo7312a(str);
                HashMap hashMap = new HashMap();
                hashMap.put("level", str);
                hashMap.put(NotificationCompat.CATEGORY_STATUS, 0);
                String str = InternalGameAgent.this.f170b.f158b;
                if (str != null) {
                    hashMap.put("user_level", str);
                }
                InternalGameAgent cVar = InternalGameAgent.this;
                cVar.f169a.mo7285a(cVar.f194z, "level", hashMap);
            }
        });
    }

    /* renamed from: c */
    public void mo7334c(String str) {
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
        } else {
            m136a(str, 1);
        }
    }

    /* renamed from: b */
    public void mo7333b(String str, int i, double d) {
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SupportMenuInflater.XML_ITEM, str);
        hashMap.put("amount", Integer.valueOf(i));
        hashMap.put("coin", Long.valueOf((long) (((double) i) * d * 100.0d)));
        String str2 = this.f170b.f158b;
        if (str2 != null) {
            hashMap.put("user_level", str2);
        }
        String str3 = this.f170b.f157a;
        if (str3 != null) {
            hashMap.put("level", str3);
        }
        this.f169a.mo7285a(this.f194z, "use", hashMap);
    }

    /* renamed from: a */
    public void mo7331a(boolean z) {
        String.format("Trace sleep time : %b", new Object[]{Boolean.valueOf(z)});
        String str = MLog.f1805;
        boolean z2 = MLog.f1804;
        GameConfig.f156a = z;
    }

    /* renamed from: a */
    public void mo7328a(String str) {
        this.f170b.f158b = str;
        SharedPreferences r0 = Utils.m1861(this.f194z);
        if (r0 != null) {
            SharedPreferences.Editor edit = r0.edit();
            edit.putString(AnalyticsConstants.f97A, str);
            edit.commit();
        }
    }

    /* renamed from: a */
    private void m136a(final String str, final int i) {
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
        } else {
            QueuedWork.m118a(new SafeRunnable() {
                /* renamed from: a */
                public void mo7309a() {
                    GameState.C0396a b = InternalGameAgent.this.f170b.mo7314b(str);
                    if (b != null) {
                        long e = b.mo7321e();
                        if (e <= 0) {
                            String str = MLog.f1805;
                            boolean z = MLog.f1804;
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("level", str);
                        hashMap.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i));
                        hashMap.put("duration", Long.valueOf(e));
                        String str2 = InternalGameAgent.this.f170b.f158b;
                        if (str2 != null) {
                            hashMap.put("user_level", str2);
                        }
                        InternalGameAgent cVar = InternalGameAgent.this;
                        cVar.f169a.mo7285a(cVar.f194z, "level", hashMap);
                        return;
                    }
                    MLog.m1773(String.format("finishLevel(or failLevel) called before startLevel", new Object[0]));
                }
            });
        }
    }

    /* renamed from: b */
    public void mo7276b() {
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
        } else if (GameConfig.f156a) {
            this.f170b.mo7313a();
        }
    }

    /* renamed from: a */
    public void mo7323a(double d, double d2, int i) {
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cash", Long.valueOf((long) (d * 100.0d)));
        hashMap.put("coin", Long.valueOf((long) (d2 * 100.0d)));
        hashMap.put("source", Integer.valueOf(i));
        String str = this.f170b.f158b;
        if (str != null) {
            hashMap.put("user_level", str);
        }
        String str2 = this.f170b.f157a;
        if (str2 != null) {
            hashMap.put("level", str2);
        }
        this.f169a.mo7285a(this.f194z, "pay", hashMap);
    }

    /* renamed from: a */
    public void mo7326a(double d, String str, int i, double d2, int i2) {
        mo7323a(d, d2 * ((double) i), i2);
        mo7329a(str, i, d2);
    }

    /* renamed from: a */
    public void mo7329a(String str, int i, double d) {
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SupportMenuInflater.XML_ITEM, str);
        hashMap.put("amount", Integer.valueOf(i));
        hashMap.put("coin", Long.valueOf((long) (((double) i) * d * 100.0d)));
        String str2 = this.f170b.f158b;
        if (str2 != null) {
            hashMap.put("user_level", str2);
        }
        String str3 = this.f170b.f157a;
        if (str3 != null) {
            hashMap.put("level", str3);
        }
        this.f169a.mo7285a(this.f194z, "buy", hashMap);
    }

    /* renamed from: a */
    public void mo7324a(double d, int i) {
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("coin", Long.valueOf((long) (d * 100.0d)));
        hashMap.put("bonus_source", Integer.valueOf(i));
        String str = this.f170b.f158b;
        if (str != null) {
            hashMap.put("user_level", str);
        }
        String str2 = this.f170b.f157a;
        if (str2 != null) {
            hashMap.put("level", str2);
        }
        this.f169a.mo7285a(this.f194z, "bonus", hashMap);
    }

    /* renamed from: a */
    public void mo7330a(String str, int i, double d, int i2) {
        mo7324a(((double) i) * d, i2);
        mo7329a(str, i, d);
    }

    /* renamed from: a */
    public void mo7325a(double d, String str, double d2, int i, String str2) {
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
        } else if (d >= 0.0d && d2 >= 0.0d) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str) && str.length() > 0 && str.length() <= 3) {
                hashMap.put("curtype", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    int length = str2.getBytes("UTF-8").length;
                    if (length > 0 && length <= 1024) {
                        hashMap.put("orderid", str2);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            hashMap.put("cash", Long.valueOf((long) (d * 100.0d)));
            hashMap.put("coin", Long.valueOf((long) (d2 * 100.0d)));
            hashMap.put("source", Integer.valueOf(i));
            String str3 = this.f170b.f158b;
            if (str3 != null) {
                hashMap.put("user_level", str3);
            }
            String str4 = this.f170b.f157a;
            if (str4 != null) {
                hashMap.put("level", str4);
            }
            this.f169a.mo7285a(this.f194z, "pay", hashMap);
        }
    }

    /* renamed from: a */
    public void mo7275a() {
        String str = MLog.f1805;
        boolean z = MLog.f1804;
        if (this.f194z == null) {
            MLog.m1776("UMGameAgent.init(Context) should be called before any game api");
        } else if (GameConfig.f156a) {
            this.f170b.mo7315b();
        }
    }
}
