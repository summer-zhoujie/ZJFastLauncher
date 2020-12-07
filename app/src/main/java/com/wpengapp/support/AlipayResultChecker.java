package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONObject;

/* renamed from: com.wpengapp.support.ע */
public class AlipayResultChecker {

    /* renamed from: ֏ */
    public String f2154;

    /* renamed from: ؠ */
    public String f2155;

    public AlipayResultChecker(String str, String str2, String str3) {
        this.f2154 = str;
        this.f2155 = str3;
    }

    /* renamed from: ֏ */
    public int mo8717() {
        try {
            String string = m2182(this.f2154, ";").getString("result");
            String substring = string.substring(1, string.length() - 1);
            int indexOf = substring.indexOf("&sign_type=");
            if (indexOf > 0) {
                String substring2 = substring.substring(0, indexOf);
                JSONObject r3 = m2182(substring, "&");
                String replace = r3.getString("sign_type").replace("\"", BidiFormatter.EMPTY_STRING);
                String replace2 = r3.getString("sign").replace("\"", BidiFormatter.EMPTY_STRING);
                if (replace.equalsIgnoreCase("RSA") && !m2183(substring2, replace2, this.f2155)) {
                    return 1;
                }
            }
            return 2;
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    /* renamed from: ֏ */
    public static boolean m2183(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str3, 0)));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initVerify(generatePublic);
            instance.update(str.getBytes("UTF-8"));
            return instance.verify(Base64.decode(str2, 0));
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: ֏ */
    public static JSONObject m2182(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String[] split = str.split(str2);
            for (int i = 0; i < split.length; i++) {
                String[] split2 = split[i].split("=");
                jSONObject.put(split2[0], split[i].substring(split2[0].length() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
