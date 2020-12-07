package com.wpengapp.support;

import java.text.Collator;
import java.util.Collection;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.wpengapp.support.η */
public final class CollectionUtils {

    /* renamed from: ֏ */
    public static final Comparator<Object> f1665 = Collator.getInstance(Locale.CHINA);

    /* renamed from: ֏ */
    public static boolean m1657(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /* renamed from: ؠ */
    public static boolean m1659(Collection collection) {
        return !m1657(collection);
    }

    /* renamed from: ֏ */
    public static boolean m1658(Map map) {
        return map == null || map.isEmpty();
    }

    /* renamed from: ؠ */
    public static boolean m1660(Map map) {
        return !m1658(map);
    }
}
