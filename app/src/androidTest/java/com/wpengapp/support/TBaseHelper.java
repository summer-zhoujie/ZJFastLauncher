package com.wpengapp.support;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* renamed from: com.wpengapp.support.Έ */
public final class TBaseHelper {

    /* renamed from: ֏ */
    public static final Comparator f1605 = new C0630((C0739) null);

    /* renamed from: com.wpengapp.support.Έ$֏ */
    /* compiled from: TBaseHelper */
    private static class C0630 implements Comparator {
        public /* synthetic */ C0630(C0739 r1) {
        }

        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            if (obj instanceof List) {
                return TBaseHelper.m1610((List) obj, (List) obj2);
            }
            if (obj instanceof Set) {
                return TBaseHelper.m1612((Set) obj, (Set) obj2);
            }
            if (obj instanceof Map) {
                return TBaseHelper.m1611((Map) obj, (Map) obj2);
            }
            if (obj instanceof byte[]) {
                return TBaseHelper.m1613((byte[]) obj, (byte[]) obj2);
            }
            return TBaseHelper.m1609((Comparable) obj, (Comparable) obj2);
        }
    }

    /* renamed from: ֏ */
    public static int m1608(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i2 < i ? 1 : 0;
    }

    /* renamed from: ֏ */
    public static int m1613(byte[] bArr, byte[] bArr2) {
        int r0 = m1608(bArr.length, bArr2.length);
        if (r0 != 0) {
            return r0;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            int i2 = b < b2 ? -1 : b2 < b ? 1 : 0;
            if (i2 != 0) {
                return i2;
            }
        }
        return 0;
    }

    /* renamed from: ֏ */
    public static int m1609(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* renamed from: ֏ */
    public static int m1610(List list, List list2) {
        int r0 = m1608(list.size(), list2.size());
        if (r0 != 0) {
            return r0;
        }
        for (int i = 0; i < list.size(); i++) {
            int compare = f1605.compare(list.get(i), list2.get(i));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: ֏ */
    public static int m1612(Set set, Set set2) {
        int r0 = m1608(set.size(), set2.size());
        if (r0 != 0) {
            return r0;
        }
        TreeSet treeSet = new TreeSet(f1605);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(f1605);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f1605.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: ֏ */
    public static int m1611(Map map, Map map2) {
        int r0 = m1608(map.size(), map2.size());
        if (r0 != 0) {
            return r0;
        }
        TreeMap treeMap = new TreeMap(f1605);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(f1605);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int compare = f1605.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = f1605.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    /* renamed from: ֏ */
    public static void m1614(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int position = byteBuffer.position() + arrayOffset;
        int limit = byteBuffer.limit() + arrayOffset;
        int i = limit - position > 128 ? position + 128 : limit;
        for (int i2 = position; i2 < i; i2++) {
            if (i2 > position) {
                sb.append(" ");
            }
            sb.append(Integer.toHexString((array[i2] | 256) & 511).toUpperCase().substring(1));
        }
        if (limit != i) {
            sb.append("...");
        }
    }
}
