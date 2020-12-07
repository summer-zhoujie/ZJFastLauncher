package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.p000v4.app.NotificationCompat;
import com.umeng.analytics.social.UMSocialConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.wpengapp.support.Ƒ */
public class RemoteSP {

    /* renamed from: ֏ */
    public static final SP<Long> f915 = new LongSP("INSTALL_TIME", -1L);

    /* renamed from: ؠ */
    public static SharedPreferences f916;

    /* renamed from: ހ */
    public static final Map<String, Object> f917 = new ConcurrentHashMap();

    /* renamed from: ށ */
    public static Context f918;

    /* renamed from: ނ */
    public static int f919;

    /* renamed from: ރ */
    public static final WeakHashMap<C0507, Object> f920 = new WeakHashMap<>();

    /* renamed from: ބ */
    public static C0509 f921;

    /* renamed from: ޅ */
    public static C0508 f922;

    /* renamed from: ކ */
    public static C0506 f923;

    /* renamed from: އ */
    public static String f924;

    /* renamed from: ވ */
    public static final BroadcastReceiver f925 = new C1136();

    /* renamed from: com.wpengapp.support.Ƒ$֏ */
    /* compiled from: RemoteSP */
    private static class C0506 extends RemoteMethod {
        public C0506() {
            super("getAllSp");
        }

        /* renamed from: ؠ */
        public Bundle mo7979(@Nullable Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(UMSocialConstants.f255n, (Serializable) RemoteSP.f916.getAll());
            return bundle2;
        }
    }

    /* renamed from: com.wpengapp.support.Ƒ$ؠ */
    /* compiled from: RemoteSP */
    public interface C0507 {
    }

    /* renamed from: com.wpengapp.support.Ƒ$ހ */
    /* compiled from: RemoteSP */
    private static class C0508 extends RemoteMethod {
        public C0508() {
            super("putAllSp");
        }

        /* renamed from: ֏ */
        public void mo8063(Map<String, ?> map) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(UMSocialConstants.f255n, (Serializable) map);
            C1146.m3071(this.f1927, bundle, (RemoteCallback) null);
        }

        /* renamed from: ؠ */
        public Bundle mo7979(@Nullable Bundle bundle) {
            Map map;
            if (bundle == null || (map = (Map) bundle.getSerializable(UMSocialConstants.f255n)) == null) {
                return null;
            }
            RemoteSP.m1207((Map<String, Object>) map);
            return null;
        }
    }

    /* renamed from: com.wpengapp.support.Ƒ$ށ */
    /* compiled from: RemoteSP */
    private static class C0509 extends RemoteMethod {
        public C0509() {
            super("putSp");
        }

        /* renamed from: ֏ */
        public void mo8064(String str, Serializable serializable, boolean z) {
            Bundle bundle = new Bundle();
            bundle.putString("key", str);
            bundle.putSerializable("value", serializable);
            bundle.putBoolean("commit", z);
            C1146.m3071(this.f1927, bundle, (RemoteCallback) null);
        }

        /* renamed from: ؠ */
        public Bundle mo7979(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("key");
            Serializable serializable = bundle.getSerializable("value");
            if (string == null) {
                return null;
            }
            RemoteSP.m1206(string, (Object) serializable, bundle.getBoolean("commit", false));
            return null;
        }
    }

    /* renamed from: ֏ */
    public static void m1203(Context context) {
        f918 = context.getApplicationContext();
        f924 = f918.getPackageName() + ".ACTION_SP_CHANGED";
        f919 = Process.myPid();
        f921 = new C0509();
        f922 = new C0508();
        f923 = new C0506();
        if (C1146.m3072()) {
            f916 = f918.getSharedPreferences(NotificationCompat.CATEGORY_SERVICE, 0);
            f921.mo8565();
            f922.mo8565();
            f923.mo8565();
        } else {
            Map map = null;
            f916 = null;
            if (C1146.m3074()) {
                Map<String, Object> map2 = f917;
                Bundle bundle = f923.mo8563((Bundle) null).f3116;
                if (bundle != null) {
                    map = (Map) bundle.getSerializable(UMSocialConstants.f255n);
                }
                map2.putAll(map);
            } else {
                f917.putAll(f918.getSharedPreferences(NotificationCompat.CATEGORY_SERVICE, 0).getAll());
            }
            C0786.m2103(f918, f925, new IntentFilter(f924));
        }
        if (f915.mo8104().longValue() == ((Long) f915.f1265).longValue()) {
            f915.mo8105(Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: ؠ */
    public static void m1213(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() == null) {
                arrayList.add(new SPData((String) next.getKey(), (Serializable) null));
            } else {
                arrayList.add(new SPData((String) next.getKey(), (Serializable) next.getValue()));
            }
        }
        Intent intent = new Intent(f924);
        intent.putExtra("sp_data", arrayList);
        intent.putExtra("sender_pid", f919);
        C0786.m2105(f918, intent, true);
    }

    /* renamed from: ހ */
    public static long m1214(SP<Long> r3) {
        return m1201(r3.f1264, ((Long) r3.f1265).longValue());
    }

    /* renamed from: ށ */
    public static String m1215(SP<String> r1) {
        return m1202(r1.f1264, (String) r1.f1265);
    }

    /* renamed from: ؠ */
    public static Object m1212(String str, Object obj) {
        Object obj2 = f917.get(str);
        return obj2 == null ? obj : obj2;
    }

    /* renamed from: ؠ */
    public static int m1211(SP<Integer> r2) {
        String str = r2.f1264;
        int intValue = ((Integer) r2.f1265).intValue();
        if (C1146.m3072()) {
            return f916.getInt(str, intValue);
        }
        return ((Integer) m1212(str, Integer.valueOf(intValue))).intValue();
    }

    /* renamed from: ֏ */
    public static void m1205(String str, Object obj) {
        if (f920.size() > 0) {
            HashSet hashSet = null;
            while (hashSet == null) {
                try {
                    hashSet = new HashSet(f920.keySet());
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            AppUtils.m1155((Runnable) new C0644(hashSet, str, obj));
        }
    }

    /* renamed from: ֏ */
    public static void m1208(Map<String, Object> map, boolean z) {
        SharedPreferences.Editor edit = f916.edit();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value == null) {
                edit.remove(str);
            } else if (value instanceof Integer) {
                edit.putInt(str, ((Integer) value).intValue());
            } else if (value instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) value).booleanValue());
            } else if (value instanceof Float) {
                edit.putFloat(str, ((Float) value).floatValue());
            } else if (value instanceof Long) {
                edit.putLong(str, ((Long) value).longValue());
            } else if (value instanceof String) {
                edit.putString(str, (String) value);
            } else if (value instanceof Set) {
                edit.putStringSet(str, (Set) value);
            } else {
                throw new RuntimeException(outline.m2554("not support type: ", value));
            }
        }
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    /* renamed from: ֏ */
    public static void m1207(Map<String, Object> map) {
        if (C1146.m3072()) {
            m1208(map, false);
            for (Map.Entry next : map.entrySet()) {
                m1205((String) next.getKey(), next.getValue());
            }
            m1213(map);
            return;
        }
        f917.putAll(map);
        for (Map.Entry next2 : map.entrySet()) {
            m1205((String) next2.getKey(), next2.getValue());
        }
        f922.mo8063(map);
    }

    /* renamed from: ֏ */
    public static void m1206(String str, Object obj, boolean z) {
        if (C1146.m3072()) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, obj);
            m1208((Map<String, Object>) hashMap, z);
            m1213((Map<String, Object>) hashMap);
        } else if (obj == null) {
            f917.remove(str);
            f921.mo8064(str, (Serializable) null, z);
        } else {
            f917.put(str, obj);
            f921.mo8064(str, (Serializable) obj, z);
        }
        m1205(str, obj);
    }

    /* renamed from: ֏ */
    public static boolean m1210(String str, boolean z) {
        if (C1146.m3072()) {
            return f916.getBoolean(str, z);
        }
        return ((Boolean) m1212(str, Boolean.valueOf(z))).booleanValue();
    }

    /* renamed from: ֏ */
    public static long m1201(String str, long j) {
        if (C1146.m3072()) {
            return f916.getLong(str, j);
        }
        return ((Long) m1212(str, Long.valueOf(j))).longValue();
    }

    /* renamed from: ֏ */
    public static String m1202(String str, String str2) {
        if (C1146.m3072()) {
            return f916.getString(str, str2);
        }
        return (String) m1212(str, str2);
    }

    /* renamed from: ֏ */
    public static void m1204(SP<?> r0, Object obj, boolean z) {
        m1206(r0.f1264, obj, z);
    }

    /* renamed from: ֏ */
    public static boolean m1209(SP<Boolean> r1) {
        return m1210(r1.f1264, ((Boolean) r1.f1265).booleanValue());
    }
}
