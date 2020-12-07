package com.wpengapp.http;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.social.UMSocialConstants;
import com.wpengapp.support.ApiConstant;
import com.wpengapp.support.C0520;
import com.wpengapp.support.DateUtils;
import com.wpengapp.support.Utils;
import com.wpengapp.support.WPengServer;
import com.wpengapp.support.outline;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import org.json.JSONObject;

public final class RequestHelper {
    static {
        System.loadLibrary("reqen");
    }

    public static native String getAppSign(Context context);

    public static native String getPubKey(Context context, int i);

    public static native String getSignature(Context context, int i, String str);

    /* renamed from: ֏ */
    public static Map<String, String> m335() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", WPengServer.f839);
        hashMap.put("app_vs", String.valueOf(WPengServer.f838));
        hashMap.put(UMSocialConstants.f249h, "ANDROID");
        hashMap.put("platform_vs", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_id", WPengServer.f840);
        hashMap.put("app_uid", WPengServer.f841);
        hashMap.put("app_channel", WPengServer.f842);
        hashMap.put("clv", String.valueOf(4));
        hashMap.put("req_ctime", DateUtils.m2699(new Date(), "yyyy-MM-dd HH:mm:ssZ"));
        hashMap.put("build_num", WPengServer.f844);
        WPengServer.C0484 r1 = WPengServer.f850;
        if (r1 != null) {
            hashMap.putAll(((C0520) r1).mo8085());
        }
        return hashMap;
    }

    /* renamed from: ؠ */
    public static String m339(String str, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (ApiConstant.m2594(str)) {
            map.putAll(m335());
            m336(str, map);
        }
        if (map.isEmpty()) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("?");
        if (lastIndexOf == -1) {
            str = str + '?';
        } else if (lastIndexOf != str.length() - 1) {
            str = str + '&';
        }
        StringBuilder r7 = outline.m2549(str);
        StringBuilder sb = new StringBuilder();
        try {
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            int size = entrySet.size();
            int i = 0;
            for (Map.Entry next : entrySet) {
                if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                    if (!TextUtils.isEmpty((CharSequence) next.getValue())) {
                        sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                        sb.append('=');
                        sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                        i++;
                        if (i < size) {
                            sb.append('&');
                        }
                    }
                }
            }
            r7.append(sb.toString());
            return r7.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(outline.m2556("Encoding not supported: ", "UTF-8"), e);
        }
    }

    /* renamed from: ֏ */
    public static void m336(String str, Map<String, String> map) {
        String str2;
        map.put("req_stime", String.valueOf(WPengServer.m1070()));
        map.remove("req_sign");
        String trim = str.replace("/", BidiFormatter.EMPTY_STRING).replace("\\", BidiFormatter.EMPTY_STRING).replace(":", BidiFormatter.EMPTY_STRING).trim();
        if (map.size() == 0) {
            Application application = WPengServer.f837;
            str2 = getSignature(application, 1, WPengServer.f845 + trim + "~$%#@$%aerv");
        } else {
            ArrayList<String> arrayList = new ArrayList<>(map.keySet());
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder(WPengServer.f845);
            sb.append(trim);
            for (String str3 : arrayList) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = map.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        sb.append(str3);
                        sb.append(str4);
                    }
                }
            }
            sb.append("~$%#@$%aerv");
            str2 = getSignature(WPengServer.f837, 1, sb.toString());
        }
        map.put("req_sign", str2);
    }

    /* renamed from: ؠ */
    public static String m338(String str) {
        byte[] bArr;
        byte[] bytes = str.getBytes("UTF-8");
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(m332(1), 0)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePublic);
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 117) {
                    bArr = instance.doFinal(bytes, i, 117);
                } else {
                    bArr = instance.doFinal(bytes, i, i3);
                }
                byteArrayOutputStream.write(bArr, 0, bArr.length);
                i2++;
                i = i2 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    /* renamed from: ֏ */
    public static void m337(Map<String, String> map) {
        map.put("res_en", "1");
    }

    /* renamed from: ֏ */
    public static String m333(String str) {
        return new String(Utils.m1898(Base64.decode(str, 0), m332(1)), "UTF-8");
    }

    /* renamed from: ֏ */
    public static String m334(JSONObject jSONObject) {
        String str = null;
        if (!jSONObject.has(UMSocialConstants.f255n)) {
            return null;
        }
        String optString = jSONObject.optString(UMSocialConstants.f255n, BidiFormatter.EMPTY_STRING);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (jSONObject.has("encrypt")) {
            str = jSONObject.optString("encrypt", BidiFormatter.EMPTY_STRING);
        }
        return !TextUtils.isEmpty(str) ? Utils.m1868(optString, m333(str)) : optString;
    }

    /* renamed from: ֏ */
    public static String m332(int i) {
        return getPubKey(WPengServer.f837, i) + "/95MqyzuZo0keG9LEqeM7oRVonfkUmvgribN2uOigFnmyyxbVQ7J+psBSUU+W4gtg0D3zMbLkZttprjDyJGOLQIDAQAB";
    }
}
