package com.wpengapp.support;

import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.http.RequestHelper;
import com.wpengapp.support.model.App;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.wpengapp.support.ম */
/* compiled from: ConfigManager */
public class C1063 {

    /* renamed from: ֏ */
    public static final String[] f3036 = {"special_marked_apps", "special_full_intro", "special_app_store", "special_app_privacy_time", "sp_apppt", "sp_fullpy", "sp_fullpycd", "qqgroup", "qq_group_keys", "qq", "wechat", NotificationCompat.CATEGORY_EMAIL, "reward_qr", "app_copyright", "gzh", "enable_full", "enable_ap", "bg_update_time", "server_stat_table_policy", "enable_user_upgrade", "cfg_time"};

    /* renamed from: ؠ */
    public static String[] f3037;

    /* renamed from: ހ */
    public static final WeakHashMap<C1065, Object> f3038 = new WeakHashMap<>();

    /* renamed from: ށ */
    public static final C1323<String> f3039 = C1323.m3614("server_configs", (Type) null, (String) null);

    /* renamed from: ނ */
    public static final Map<String, String> f3040 = new HashMap();

    /* renamed from: ރ */
    public static boolean f3041;

    /* renamed from: ބ */
    public static OnFileChangeListener f3042 = new C0836();

    /* renamed from: com.wpengapp.support.ম$֏ */
    /* compiled from: ConfigManager */
    public interface C1064 {
        /* renamed from: ֏ */
        void mo9128();

        /* renamed from: ֏ */
        void mo9129(Map<String, String> map, boolean z);
    }

    /* renamed from: com.wpengapp.support.ম$ؠ */
    /* compiled from: ConfigManager */
    public interface C1065 {
        /* renamed from: ֏ */
        void mo8041();
    }

    /* renamed from: ֏ */
    public static String m2859(String str, String str2) {
        if (!f3041) {
            f3041 = true;
            m2860();
            f3039.mo9610(f3042);
            if (C1146.m3072()) {
                long r0 = WPengServer.m1070();
                long j = AnalyticsConstants.f107j;
                long r02 = (AnalyticsConstants.f107j - r0) + Utils.m1859(m2859("cfg_time", (String) null), 0);
                if (r02 <= 0) {
                    j = ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS;
                } else if (r02 <= AnalyticsConstants.f107j) {
                    j = r02;
                }
                AppUtils.m1147((Runnable) new C1171(), j);
            }
        }
        String str3 = f3040.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    /* renamed from: ؠ */
    public static void m2864() {
        String r0 = m2859("special_marked_apps", BidiFormatter.EMPTY_STRING);
        if (!TextUtils.isEmpty(r0)) {
            try {
                List<App> list = (List) GsonUtil.m2741(new JSONObject(r0).getString("apps"), new C1062().getType());
                if (list == null) {
                    return;
                }
                if (!list.isEmpty()) {
                    HashSet hashSet = new HashSet();
                    for (App appMark : list) {
                        hashSet.add(appMark.getAppMark());
                    }
                    RemoteSP.m1206("read_apps", (Object) hashSet, false);
                }
            } catch (JSONException e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: ֏ */
    public static void m2863(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        f3037 = strArr;
    }

    /* renamed from: ֏ */
    public static void m2861(C1064 r5, String... strArr) {
        String[] strArr2 = new String[(strArr.length + f3036.length + f3037.length)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        String[] strArr3 = f3036;
        System.arraycopy(strArr3, 0, strArr2, strArr.length, strArr3.length);
        String[] strArr4 = f3037;
        System.arraycopy(strArr4, 0, strArr2, strArr.length + f3036.length, strArr4.length);
        HashMap hashMap = new HashMap();
        hashMap.put("names", TextUtils.join(",", strArr2));
        RequestHelper.m337((Map<String, String>) hashMap);
        new C0480(ApiConstant.f2710, hashMap, "configs", r5).mo8757(false);
    }

    /* renamed from: ֏ */
    public static Map<String, String> m2860() {
        String r0 = f3039.mo9612();
        f3039.mo9609();
        if (TextUtils.isEmpty(r0)) {
            f3040.clear();
            if (f3038.size() > 0) {
                TaskManager.m2715((Runnable) new ConfigManager());
            }
            return null;
        }
        try {
            String r02 = RequestHelper.m334(new JSONObject(r0));
            if (!TextUtils.isEmpty(r02)) {
                Map<String, String> map = (Map) GsonUtil.m2741(new JSONObject(r02).getString("configs"), new C1215().getType());
                f3040.clear();
                f3040.putAll(map);
                if (f3038.size() > 0) {
                    TaskManager.m2715((Runnable) new ConfigManager());
                }
                return map;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2862(Map map) {
        long r2 = Utils.m1859((String) map.get("special_app_privacy_time"), 0);
        if (r2 > 0 && r2 != CommonSP.m1228("prinew", 0)) {
            CommonSP.m1229().putLong("prinew", r2).commit();
        }
    }
}
