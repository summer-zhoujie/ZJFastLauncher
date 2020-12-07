package com.wpengapp.support;

import android.text.TextUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.wpengapp.support.ۮ */
public abstract class HttpGsonRequest<T> extends C0849<T> {
    public HttpGsonRequest(String str) {
        super(str);
    }

    /* renamed from: ֏ */
    public T mo8206(String str) {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (TextUtils.isEmpty(this.f2295)) {
            return GsonUtil.m2741(str, type);
        }
        String optString = new JSONObject(str).optString(this.f2295);
        if (!TextUtils.isEmpty(optString)) {
            return GsonUtil.m2741(optString, type);
        }
        return null;
    }

    public HttpGsonRequest(String str, String str2, Map<String, String> map, String str3) {
        super(str, str2, map, str3);
    }

    public HttpGsonRequest(String str, Map<String, String> map) {
        super("GET", str, map, (String) null);
    }

    public HttpGsonRequest(String str, Map<String, String> map, String str2) {
        super("GET", str, map, str2);
    }
}
