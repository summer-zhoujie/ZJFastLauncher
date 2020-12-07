package com.wpengapp.support;

import java.util.Comparator;

/* renamed from: com.wpengapp.support.ঘ */
/* compiled from: CipherSuite */
class C1051 implements Comparator<String> {
    public int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        int min = Math.min(str.length(), str2.length());
        int i = 4;
        while (true) {
            if (i < min) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt == charAt2) {
                    i++;
                } else if (charAt < charAt2) {
                    return -1;
                }
            } else {
                int length = str.length();
                int length2 = str2.length();
                if (length == length2) {
                    return 0;
                }
                if (length < length2) {
                    return -1;
                }
            }
        }
        return 1;
    }
}
