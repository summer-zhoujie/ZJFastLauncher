package com.wpengapp.support;

import java.util.Comparator;

/* renamed from: com.wpengapp.support.ӏ */
public final class MemoryCacheUtils implements Comparator<String> {
    public int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
    }
}
