package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.wpengapp.support.Ʌ */
public final class Headers {

    /* renamed from: ֏ */
    public final String[] f1212;

    public Headers(C0568 r2) {
        List<String> list = r2.f1213;
        this.f1212 = (String[]) list.toArray(new String[list.size()]);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).f1212, this.f1212);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f1212);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int r1 = mo8176();
        for (int i = 0; i < r1; i++) {
            sb.append(mo8175(i));
            sb.append(": ");
            sb.append(mo8177(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: ֏ */
    public String mo8175(int i) {
        return this.f1212[i * 2];
    }

    /* renamed from: ؠ */
    public String mo8178(String str) {
        String[] strArr = this.f1212;
        int length = strArr.length;
        do {
            length -= 2;
            if (length < 0) {
                return null;
            }
        } while (!str.equalsIgnoreCase(strArr[length]));
        return strArr[length + 1];
    }

    /* renamed from: ֏ */
    public C0568 mo8174() {
        C0568 r0 = new C0568();
        Collections.addAll(r0.f1213, this.f1212);
        return r0;
    }

    /* renamed from: com.wpengapp.support.Ʌ$֏ */
    /* compiled from: Headers */
    public static final class C0568 {

        /* renamed from: ֏ */
        public final List<String> f1213 = new ArrayList(20);

        /* renamed from: ֏ */
        public C0568 mo8179(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                mo8180(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            } else if (str.startsWith(":")) {
                String substring = str.substring(1);
                this.f1213.add(BidiFormatter.EMPTY_STRING);
                this.f1213.add(substring.trim());
                return this;
            } else {
                this.f1213.add(BidiFormatter.EMPTY_STRING);
                this.f1213.add(str.trim());
                return this;
            }
        }

        /* renamed from: ؠ */
        public C0568 mo8182(String str) {
            int i = 0;
            while (i < this.f1213.size()) {
                if (str.equalsIgnoreCase(this.f1213.get(i))) {
                    this.f1213.remove(i);
                    this.f1213.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: ؠ */
        public C0568 mo8183(String str, String str2) {
            Headers.m1367(str);
            Headers.m1368(str2, str);
            mo8182(str);
            this.f1213.add(str);
            this.f1213.add(str2.trim());
            return this;
        }

        /* renamed from: ֏ */
        public C0568 mo8180(String str, String str2) {
            this.f1213.add(str);
            this.f1213.add(str2.trim());
            return this;
        }

        /* renamed from: ֏ */
        public Headers mo8181() {
            return new Headers(this);
        }
    }

    /* renamed from: ֏ */
    public static void m1367(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (!str.isEmpty()) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(Util.m937("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    /* renamed from: ؠ */
    public int mo8176() {
        return this.f1212.length / 2;
    }

    /* renamed from: ؠ */
    public String mo8177(int i) {
        return this.f1212[(i * 2) + 1];
    }

    /* renamed from: ֏ */
    public static void m1368(String str, String str2) {
        if (str != null) {
            int length = str.length();
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    i++;
                } else {
                    throw new IllegalArgumentException(Util.m937("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException(outline.m2545("value for name ", str2, " == null"));
    }
}
