package com.wpengapp.support;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.wpengapp.support.ɪ */
public abstract class HttpSimpleRequest extends C0849<String> {
    public HttpSimpleRequest(String str) {
        super(str);
    }

    /* renamed from: ֏ */
    public Object mo8206(String str) {
        return !TextUtils.isEmpty(this.f2295) ? new JSONObject(str).optString(this.f2295, str) : str;
    }

    public HttpSimpleRequest(String str, String str2, Map<String, String> map, String str3) {
        super(str, str2, map, str3);
    }

    public HttpSimpleRequest(String str, Map<String, String> map, String str2) {
        super("GET", str, map, str2);
    }
}
