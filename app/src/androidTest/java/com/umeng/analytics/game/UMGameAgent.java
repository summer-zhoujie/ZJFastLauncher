package com.umeng.analytics.game;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialConstants;
import com.umeng.analytics.social.UMSocialService;
import com.wpengapp.support.MLog;

public class UMGameAgent extends MobclickAgent {

    /* renamed from: a */
    public static final String f150a = "Input string is null or empty";

    /* renamed from: b */
    public static final String f151b = "Input string must be less than 64 chars";

    /* renamed from: c */
    public static final String f152c = "Input value type is negative";

    /* renamed from: d */
    public static final String f153d = "The int value for 'Pay Channels' ranges between 1 ~ 99 ";

    /* renamed from: e */
    public static final InternalGameAgent f154e = new InternalGameAgent();

    /* renamed from: f */
    public static Context f155f;

    /* renamed from: a */
    public static boolean m123a(String str) {
        if (str != null && str.trim().length() > 0) {
            return false;
        }
        return true;
    }

    public static void bonus(double d, int i) {
        if (d < 0.0d) {
            MLog.m1776(f152c);
        } else if (i <= 0 || i >= 100) {
            MLog.m1776(f153d);
        } else {
            f154e.mo7324a(d, i);
        }
    }

    public static void buy(String str, int i, double d) {
        if (m123a(str)) {
            MLog.m1776(f150a);
        } else if (i < 0 || d < 0.0d) {
            MLog.m1776(f152c);
        } else {
            f154e.mo7329a(str, i, d);
        }
    }

    public static void exchange(double d, String str, double d2, int i, String str2) {
        if (d < 0.0d || d2 < 0.0d) {
            MLog.m1776(f152c);
        } else if (i <= 0 || i >= 100) {
            MLog.m1776(f153d);
        } else {
            f154e.mo7325a(d, str, d2, i, str2);
        }
    }

    public static void failLevel(String str) {
        if (m123a(str)) {
            MLog.m1776(f150a);
        } else if (str.length() > 64) {
            MLog.m1776(f151b);
        } else {
            f154e.mo7335d(str);
        }
    }

    public static void finishLevel(String str) {
        if (m123a(str)) {
            MLog.m1776(f150a);
        } else if (str.length() > 64) {
            MLog.m1776(f151b);
        } else {
            f154e.mo7334c(str);
        }
    }

    public static void init(Context context) {
        f154e.mo7327a(context);
        f155f = context.getApplicationContext();
    }

    public static void onEvent(String str, String str2) {
        MobclickAgent.onEvent(f155f, str, str2);
    }

    public static void onSocialEvent(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            MLog.m1776("context is null in onShareEvent");
            return;
        }
        UMSocialConstants.f246e = "4";
        UMSocialService.m196a(context, (UMSocialService.C0418b) null, str, uMPlatformDataArr);
    }

    public static void pay(double d, double d2, int i) {
        if (i <= 0 || i >= 100) {
            MLog.m1776(f153d);
        } else if (d < 0.0d || d2 < 0.0d) {
            MLog.m1776(f152c);
        } else {
            f154e.mo7323a(d, d2, i);
        }
    }

    public static void setPlayerLevel(int i) {
        f154e.mo7328a(String.valueOf(i));
    }

    public static void setTraceSleepTime(boolean z) {
        f154e.mo7331a(z);
    }

    public static void startLevel(String str) {
        if (m123a(str)) {
            MLog.m1776(f150a);
        } else if (str.length() > 64) {
            MLog.m1776(f151b);
        } else {
            f154e.mo7332b(str);
        }
    }

    public static void use(String str, int i, double d) {
        if (m123a(str)) {
            MLog.m1776(f150a);
        } else if (i < 0 || d < 0.0d) {
            MLog.m1776(f152c);
        } else {
            f154e.mo7333b(str, i, d);
        }
    }

    public static void bonus(String str, int i, double d, int i2) {
        if (m123a(str)) {
            MLog.m1776(f150a);
        } else if (i < 0 || d < 0.0d) {
            MLog.m1776(f152c);
        } else if (i2 <= 0 || i2 >= 100) {
            MLog.m1776(f153d);
        } else {
            f154e.mo7330a(str, i, d, i2);
        }
    }

    public static void onSocialEvent(Context context, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            MLog.m1776("context is null in onShareEvent");
            return;
        }
        UMSocialConstants.f246e = "4";
        UMSocialService.m196a(context, (UMSocialService.C0418b) null, (String) null, uMPlatformDataArr);
    }

    public static void pay(double d, String str, int i, double d2, int i2) {
        if (i2 <= 0 || i2 >= 100) {
            MLog.m1776(f153d);
        } else if (d < 0.0d || i < 0 || d2 < 0.0d) {
            MLog.m1776(f152c);
        } else if (m123a(str)) {
            MLog.m1776(f150a);
        } else {
            f154e.mo7326a(d, str, i, d2, i2);
        }
    }
}
