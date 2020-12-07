package com.umeng.analytics.social;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.p000v4.text.BidiFormatter;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.social.UMPlatformData;
import com.wpengapp.support.outline;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.social.f */
public abstract class UMUtils {

    /* renamed from: a */
    public static Map<String, String> f264a;

    /* renamed from: a */
    public static String[] m226a(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        if (uMPlatformDataArr == null || uMPlatformDataArr.length == 0) {
            throw new UMException("platform data is null");
        }
        String appkey = AnalyticsConfig.getAppkey(context);
        if (!TextUtils.isEmpty(appkey)) {
            ArrayList arrayList = new ArrayList();
            String r0 = outline.m2545(UMSocialConstants.f243b, appkey, "/");
            Map<String, String> map = f264a;
            if (map == null || map.isEmpty()) {
                f264a = m228b(context);
            }
            Map<String, String> map2 = f264a;
            if (map2 != null && !map2.isEmpty()) {
                for (Map.Entry next : f264a.entrySet()) {
                    arrayList.add(((String) next.getKey()) + "=" + ((String) next.getValue()));
                }
            }
            StringBuilder r6 = outline.m2549("date=");
            r6.append(String.valueOf(System.currentTimeMillis()));
            arrayList.add(r6.toString());
            arrayList.add("channel=" + UMSocialConstants.f246e);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add("topic=" + str);
            }
            arrayList.addAll(m223a(uMPlatformDataArr));
            String b = m227b(uMPlatformDataArr);
            if (b == null) {
                b = "null";
            }
            StringBuilder r7 = outline.m2550(r0, "?");
            r7.append(m222a((List<String>) arrayList));
            String sb = r7.toString();
            while (sb.contains("%2C+")) {
                sb = sb.replace("%2C+", "&");
            }
            while (sb.contains("%3D")) {
                sb = sb.replace("%3D", "=");
            }
            while (sb.contains("%5B")) {
                sb = sb.replace("%5B", BidiFormatter.EMPTY_STRING);
            }
            while (sb.contains("%5D")) {
                sb = sb.replace("%5D", BidiFormatter.EMPTY_STRING);
            }
            outline.m2555("URL:", sb);
            boolean z = UMSocialConstants.f263v;
            outline.m2555("BODY:", b);
            boolean z2 = UMSocialConstants.f263v;
            return new String[]{sb, b};
        }
        throw new UMException("can`t get appkey.");
    }

    /* renamed from: b */
    public static String m227b(UMPlatformData... uMPlatformDataArr) {
        JSONObject jSONObject = new JSONObject();
        for (UMPlatformData uMPlatformData : uMPlatformDataArr) {
            UMPlatformData.GENDER gender = uMPlatformData.getGender();
            String name = uMPlatformData.getName();
            if (gender == null) {
                try {
                    if (TextUtils.isEmpty(name)) {
                    }
                } catch (Exception e) {
                    throw new UMException("build body exception", (Throwable) e);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(UMSocialConstants.f256o, gender == null ? BidiFormatter.EMPTY_STRING : String.valueOf(gender.value));
            if (name == null) {
                name = BidiFormatter.EMPTY_STRING;
            }
            jSONObject2.put("name", name);
            jSONObject.put(uMPlatformData.getMeida().toString(), jSONObject2);
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }

    /* renamed from: c */
    public static String m229c(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (m225a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            boolean z = UMSocialConstants.f263v;
            return BidiFormatter.EMPTY_STRING;
        } catch (Exception e) {
            StringBuilder r0 = outline.m2549("Could not get mac address.");
            r0.append(e.toString());
            r0.toString();
            boolean z2 = UMSocialConstants.f263v;
            return BidiFormatter.EMPTY_STRING;
        }
    }

    /* renamed from: b */
    public static Map<String, String> m228b(Context context) {
        HashMap hashMap = new HashMap();
        Map<String, String> a = m224a(context);
        if (!a.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : a.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) next.getValue())) {
                    sb2.append((String) next.getKey());
                    sb2.append(",");
                    sb.append((String) next.getValue());
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                hashMap.put(UMSocialConstants.f247f, sb.toString());
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
                hashMap.put(UMSocialConstants.f248g, sb2.toString());
            }
            return hashMap;
        }
        throw new UMException("can`t get device id.");
    }

    /* renamed from: a */
    public static String m222a(List<String> list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(URLEncoder.encode(list.toString()).getBytes());
            return byteArrayOutputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static List<String> m223a(UMPlatformData... uMPlatformDataArr) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (UMPlatformData uMPlatformData : uMPlatformDataArr) {
            sb.append(uMPlatformData.getMeida().toString());
            sb.append(',');
            sb2.append(uMPlatformData.getUsid());
            sb2.append(',');
            sb3.append(uMPlatformData.getWeiboId());
            sb3.append(',');
        }
        if (uMPlatformDataArr.length > 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb2.deleteCharAt(sb2.length() - 1);
            sb3.deleteCharAt(sb3.length() - 1);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder r3 = outline.m2549("platform=");
        r3.append(sb.toString());
        arrayList.add(r3.toString());
        arrayList.add("usid=" + sb2.toString());
        if (sb3.length() > 0) {
            StringBuilder r0 = outline.m2549("weiboid=");
            r0.append(sb3.toString());
            arrayList.add(r0.toString());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map<String, String> m224a(Context context) {
        HashMap hashMap = new HashMap();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            boolean z = UMSocialConstants.f263v;
        }
        String str = null;
        try {
            if (m225a(context, "android.permission.READ_PHONE_STATE")) {
                str = telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
            UMLog.m211e("MobclickAgent", "No IMEI.", e);
        }
        String c = m229c(context);
        String string = Settings.Secure.getString(context.getContentResolver(), UMSocialConstants.f260s);
        if (!TextUtils.isEmpty(c)) {
            hashMap.put(UMSocialConstants.f259r, c);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(UMSocialConstants.f258q, str);
        }
        if (!TextUtils.isEmpty(string)) {
            hashMap.put(UMSocialConstants.f260s, string);
        }
        return hashMap;
    }

    /* renamed from: a */
    public static boolean m225a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
