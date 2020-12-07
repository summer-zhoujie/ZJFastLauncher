package com.wpengapp.support;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.support.UMEntry;
import java.lang.reflect.Method;
import org.json.JSONArray;

/* renamed from: com.wpengapp.support.қ */
public class SessionTracker {

    /* renamed from: ֏ */
    public static String f1889;

    /* renamed from: ؠ */
    public static Context f1890;

    /* renamed from: ބ */
    public static String m1840(Context context) {
        if (f1889 == null) {
            f1889 = context.getSharedPreferences("umeng_general_config", 0).getString("session_id", (String) null);
        }
        return f1889;
    }

    /* renamed from: ֏ */
    public UMEntry.C0561 mo8539(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        String string = sharedPreferences.getString("session_id", (String) null);
        if (string == null) {
            return null;
        }
        long j = 0;
        long j2 = sharedPreferences.getLong("session_start_time", 0);
        long j3 = sharedPreferences.getLong("session_end_time", 0);
        if (j3 != 0) {
            long j4 = j3 - j2;
            if (Math.abs(j4) <= AnalyticsConstants.f107j) {
                j = j4;
            }
        }
        UMEntry.C0561 r15 = new UMEntry.C0561();
        r15.f1187 = string;
        r15.f1188 = j2;
        r15.f1189 = j3;
        r15.f1190 = j;
        double[] dArr = AnalyticsConfig.f62a;
        if (dArr != null) {
            UMEntry.C0557 r9 = r15.f1193;
            r9.f1131 = dArr[0];
            r9.f1132 = dArr[1];
            r9.f1133 = System.currentTimeMillis();
        }
        try {
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", new Class[]{Integer.TYPE});
            Method method2 = cls.getMethod("getUidTxBytes", new Class[]{Integer.TYPE});
            int i = context.getApplicationInfo().uid;
            if (i == -1) {
                return null;
            }
            long longValue = ((Long) method.invoke((Object) null, new Object[]{Integer.valueOf(i)})).longValue();
            long longValue2 = ((Long) method2.invoke((Object) null, new Object[]{Integer.valueOf(i)})).longValue();
            if (longValue > 0) {
                if (longValue2 > 0) {
                    long j5 = sharedPreferences.getLong("uptr", -1);
                    long j6 = sharedPreferences.getLong("dntr", -1);
                    sharedPreferences.edit().putLong("uptr", longValue2).putLong("dntr", longValue).commit();
                    if (j5 > 0) {
                        if (j6 > 0) {
                            long j7 = longValue - j6;
                            long j8 = longValue2 - j5;
                            if (j7 > 0) {
                                if (j8 > 0) {
                                    r15.f1192.f1194 = j7;
                                    r15.f1192.f1195 = j8;
                                }
                            }
                        }
                    }
                }
            }
            String string2 = sharedPreferences.getString("activities", BidiFormatter.EMPTY_STRING);
            if (!TextUtils.isEmpty(string2)) {
                try {
                    String[] split = string2.split(";");
                    for (String jSONArray : split) {
                        JSONArray jSONArray2 = new JSONArray(jSONArray);
                        UMEntry.C0558 r92 = new UMEntry.C0558();
                        r92.f1134 = jSONArray2.getString(0);
                        r92.f1135 = (long) jSONArray2.getInt(1);
                        r15.f1191.add(r92);
                    }
                } catch (Exception e) {
                    MLog.m1772((Throwable) e);
                }
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove("session_start_time");
            edit.remove("session_end_time");
            edit.remove("a_start_time");
            edit.remove("a_end_time");
            edit.putString("activities", BidiFormatter.EMPTY_STRING);
            edit.commit();
            return r15;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ؠ */
    public String mo8541(Context context) {
        String r0 = DeviceConfig.m2324(context);
        String appkey = AnalyticsConfig.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            f1889 = HelperUtils.m2469(currentTimeMillis + appkey + r0);
            return f1889;
        }
        throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
    }

    /* renamed from: ހ */
    public void mo8542(Context context) {
        Context context2 = context;
        f1890 = context2;
        boolean z = false;
        SharedPreferences sharedPreferences = context2.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            int i = sharedPreferences.getInt(AnalyticsConstants.f122y, 0);
            int parseInt = Integer.parseInt(DeviceConfig.m2322(f1890));
            if (i == 0 || parseInt == i) {
                long j = sharedPreferences.getLong("a_start_time", 0);
                long j2 = sharedPreferences.getLong("a_end_time", 0);
                long currentTimeMillis = System.currentTimeMillis();
                if (j != 0 && currentTimeMillis - j < AnalyticsConfig.kContinueSessionMillis) {
                    MLog.m1776("onResume called before onPause");
                } else if (currentTimeMillis - j2 > AnalyticsConfig.kContinueSessionMillis) {
                    z = true;
                }
                if (z) {
                    String r1 = mo8540(context2, sharedPreferences);
                    MLog.m1769("Start new session: " + r1);
                    return;
                }
                String string = sharedPreferences.getString("session_id", (String) null);
                edit.putLong("a_start_time", System.currentTimeMillis());
                edit.putLong("a_end_time", 0);
                edit.commit();
                MLog.m1769("Extend current session: " + string);
                return;
            }
            if (m1840(context) == null) {
                mo8540(context2, sharedPreferences);
            }
            mo8544(f1890);
            C1112.m2993(f1890).mo8611();
            mo8545(f1890);
        }
    }

    /* renamed from: ށ */
    public void mo8543(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            if (sharedPreferences.getLong("a_start_time", 0) != 0 || !AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
                long currentTimeMillis = System.currentTimeMillis();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong("a_start_time", 0);
                edit.putLong("a_end_time", currentTimeMillis);
                edit.putLong("session_end_time", currentTimeMillis);
                edit.commit();
                return;
            }
            MLog.m1776("onPause called before onResume");
        }
    }

    /* renamed from: ނ */
    public boolean mo8544(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences == null || sharedPreferences.getString("session_id", (String) null) == null) {
            return false;
        }
        long j = sharedPreferences.getLong("a_start_time", 0);
        long j2 = sharedPreferences.getLong("a_end_time", 0);
        if (j > 0 && j2 == 0) {
            z = true;
            mo8543(context);
        }
        C1112 r1 = C1112.m2993(context);
        UMEntry.C0561 r9 = mo8539(context);
        if (r9 != null) {
            r1.f3166.mo8613(r9);
        }
        return z;
    }

    /* renamed from: ރ */
    public void mo8545(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            String r1 = mo8541(context);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("session_id", r1);
            edit.putLong("session_start_time", System.currentTimeMillis());
            edit.putLong("session_end_time", 0);
            edit.putLong("a_start_time", System.currentTimeMillis());
            edit.putLong("a_end_time", 0);
            edit.putInt(AnalyticsConstants.f122y, Integer.parseInt(DeviceConfig.m2322(context)));
            edit.putString(AnalyticsConstants.f123z, DeviceConfig.m2323(context));
            edit.commit();
            MLog.m1769("Restart session: " + r1);
        }
    }

    /* renamed from: ֏ */
    public final String mo8540(Context context, SharedPreferences sharedPreferences) {
        C1112 r0 = C1112.m2993(context);
        String r1 = mo8541(context);
        UMEntry.C0561 r2 = mo8539(context);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("session_id", r1);
        edit.putLong("session_start_time", System.currentTimeMillis());
        edit.putLong("session_end_time", 0);
        edit.putLong("a_start_time", System.currentTimeMillis());
        edit.putLong("a_end_time", 0);
        edit.putInt(AnalyticsConstants.f122y, Integer.parseInt(DeviceConfig.m2322(context)));
        edit.putString(AnalyticsConstants.f123z, DeviceConfig.m2323(context));
        edit.commit();
        if (r2 != null) {
            r0.mo8612((IProtocol) r2);
        } else {
            r0.mo8612((IProtocol) null);
        }
        return r1;
    }
}
