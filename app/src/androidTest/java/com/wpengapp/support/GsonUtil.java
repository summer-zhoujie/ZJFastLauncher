package com.wpengapp.support;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

/* renamed from: com.wpengapp.support.र */
public final class GsonUtil {

    /* renamed from: ֏ */
    public static Gson f2951;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        f2951 = gsonBuilder.create();
    }

    /* renamed from: ֏ */
    public static <T> T m2741(String str, Type type) {
        return f2951.fromJson(str, type);
    }

    /* renamed from: ֏ */
    public static <T> T m2740(String str, Class<T> cls) {
        return f2951.fromJson(str, cls);
    }

    /* renamed from: ֏ */
    public static String m2742(Object obj) {
        return f2951.toJson(obj);
    }
}
