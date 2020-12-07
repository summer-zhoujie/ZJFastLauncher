package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialConstants;
import com.umeng.analytics.social.UMSocialService;
import com.wpengapp.support.MLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

public class MobclickAgent {

    /* renamed from: a */
    public static final String f69a = "input map is null";

    /* renamed from: b */
    public static final InternalAgent f70b = new InternalAgent();

    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1),
        E_UM_ANALYTICS_OEM(224),
        E_UM_GAME_OEM(225);
        

        /* renamed from: a */
        public int f72a;

        /* access modifiers changed from: public */
        EScenarioType(int i) {
            this.f72a = i;
        }

        public int toValue() {
            return this.f72a;
        }
    }

    public static void enableEncrypt(boolean z) {
        f70b.mo7308f(z);
    }

    public static InternalAgent getAgent() {
        return f70b;
    }

    public static void onEvent(Context context, List<String> list, int i, String str) {
        f70b.mo7288a(context, list, i, str);
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        hashMap.put("__ct__", Integer.valueOf(i));
        f70b.mo7286a(context, str, (Map<String, Object>) hashMap, -1);
    }

    public static void onKillProcess(Context context) {
        f70b.mo7305d(context);
    }

    public static void onPageEnd(String str) {
        if (!TextUtils.isEmpty(str)) {
            f70b.mo7300b(str);
        } else {
            MLog.m1776("pageName is null or empty");
        }
    }

    public static void onPageStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            f70b.mo7291a(str);
        } else {
            MLog.m1776("pageName is null or empty");
        }
    }

    public static void onPause(Context context) {
        f70b.mo7298b(context);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignOff() {
        f70b.mo7296b();
    }

    public static void onResume(Context context) {
        if (context == null) {
            MLog.m1776("unexpected null context in onResume");
        } else {
            f70b.mo7280a(context);
        }
    }

    public static void onSocialEvent(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            MLog.m1776("context is null in onShareEvent");
            return;
        }
        UMSocialConstants.f246e = "3";
        UMSocialService.m196a(context, (UMSocialService.C0418b) null, str, uMPlatformDataArr);
    }

    public static void openActivityDurationTrack(boolean z) {
        f70b.mo7304c(z);
    }

    public static void reportError(Context context, String str) {
        f70b.mo7283a(context, str);
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        f70b.mo7295a(z);
    }

    public static void setCheckDevice(boolean z) {
        f70b.mo7306d(z);
    }

    public static void setDebugMode(boolean z) {
        f70b.mo7307e(z);
    }

    public static void setEnableEventBuffer(boolean z) {
        f70b.mo7302b(z);
    }

    public static void setLatencyWindow(long j) {
        f70b.mo7279a(j);
    }

    public static void setLocation(double d, double d2) {
        f70b.mo7278a(d, d2);
    }

    public static void setOpenGLContext(GL10 gl10) {
        f70b.mo7294a(gl10);
    }

    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
        f70b.mo7282a(context, eScenarioType);
    }

    public static void setSecret(Context context, String str) {
        f70b.mo7299b(context, str);
    }

    public static void setSessionContinueMillis(long j) {
        f70b.mo7297b(j);
    }

    public static void setWrapper(String str, String str2) {
        f70b.mo7292a(str, str2);
    }

    public static void startWithConfigure(UMAnalyticsConfig uMAnalyticsConfig) {
        if (uMAnalyticsConfig != null) {
            f70b.mo7289a(uMAnalyticsConfig);
        }
    }

    public static void onEvent(Context context, String str) {
        f70b.mo7284a(context, str, (String) null, -1, 1);
    }

    public static void onProfileSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            MLog.m1773("uid is null");
        } else if (str2.length() > 64) {
            MLog.m1773("uid is Illegal(length bigger then  legitimate length).");
        } else if (TextUtils.isEmpty(str)) {
            f70b.mo7301b("_adhoc", str2);
        } else if (str.length() > 32) {
            MLog.m1773("provider is Illegal(length bigger then  legitimate length).");
        } else {
            f70b.mo7301b(str, str2);
        }
    }

    public static void reportError(Context context, Throwable th) {
        f70b.mo7287a(context, th);
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            MLog.m1769("label is null or empty");
        } else {
            f70b.mo7284a(context, str, str2, -1, 1);
        }
    }

    public static void onSocialEvent(Context context, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            MLog.m1776("context is null in onShareEvent");
            return;
        }
        UMSocialConstants.f246e = "3";
        UMSocialService.m196a(context, (UMSocialService.C0418b) null, (String) null, uMPlatformDataArr);
    }

    public static class UMAnalyticsConfig {
        public String mAppkey;
        public String mChannelId;
        public Context mContext;
        public boolean mIsCrashEnable;
        public EScenarioType mType;

        public UMAnalyticsConfig() {
            this.mAppkey = null;
            this.mChannelId = null;
            this.mIsCrashEnable = true;
            this.mType = EScenarioType.E_UM_NORMAL;
            this.mContext = null;
        }

        public UMAnalyticsConfig(Context context, String str, String str2) {
            this(context, str, str2, (EScenarioType) null, true);
        }

        public UMAnalyticsConfig(Context context, String str, String str2, EScenarioType eScenarioType) {
            this(context, str, str2, eScenarioType, true);
        }

        public UMAnalyticsConfig(Context context, String str, String str2, EScenarioType eScenarioType, boolean z) {
            this.mAppkey = null;
            this.mChannelId = null;
            this.mIsCrashEnable = true;
            this.mType = EScenarioType.E_UM_NORMAL;
            this.mContext = null;
            this.mContext = context;
            this.mAppkey = str;
            this.mChannelId = str2;
            this.mIsCrashEnable = z;
            if (eScenarioType != null) {
                this.mType = eScenarioType;
                return;
            }
            int verticalType = AnalyticsConfig.getVerticalType(context);
            if (verticalType == 0) {
                this.mType = EScenarioType.E_UM_NORMAL;
            } else if (verticalType == 1) {
                this.mType = EScenarioType.E_UM_GAME;
            } else if (verticalType == 224) {
                this.mType = EScenarioType.E_UM_ANALYTICS_OEM;
            } else if (verticalType == 225) {
                this.mType = EScenarioType.E_UM_GAME_OEM;
            }
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            MLog.m1776(f69a);
            return;
        }
        f70b.mo7286a(context, str, (Map<String, Object>) new HashMap(map), -1);
    }
}
