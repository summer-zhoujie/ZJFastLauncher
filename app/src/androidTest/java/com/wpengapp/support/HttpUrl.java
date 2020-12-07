package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.wpengapp.support.ರ */
public final class HttpUrl {

    /* renamed from: ֏ */
    public static final char[] f3306 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: ؠ */
    public final String f3307;

    /* renamed from: ހ */
    public final String f3308;

    /* renamed from: ށ */
    public final String f3309;

    /* renamed from: ނ */
    public final String f3310;

    /* renamed from: ރ */
    public final int f3311;

    /* renamed from: ބ */
    public final List<String> f3312;

    /* renamed from: ޅ */
    public final String f3313;

    /* renamed from: ކ */
    public final String f3314;

    public HttpUrl(C1165 r5) {
        this.f3307 = r5.f3315;
        this.f3308 = m3120(r5.f3316, false);
        this.f3309 = m3120(r5.f3317, false);
        this.f3310 = r5.f3318;
        int i = r5.f3319;
        this.f3311 = i == -1 ? m3115(r5.f3315) : i;
        mo9366(r5.f3320, false);
        List<String> list = r5.f3321;
        String str = null;
        this.f3312 = list != null ? mo9366(list, true) : null;
        String str2 = r5.f3322;
        this.f3313 = str2 != null ? m3117(str2, 0, str2.length(), false) : str;
        this.f3314 = r5.toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f3314.equals(this.f3314);
    }

    public int hashCode() {
        return this.f3314.hashCode();
    }

    public String toString() {
        return this.f3314;
    }

    /* renamed from: ֏ */
    public String mo9365() {
        if (this.f3309.isEmpty()) {
            return BidiFormatter.EMPTY_STRING;
        }
        int indexOf = this.f3314.indexOf(64);
        return this.f3314.substring(this.f3314.indexOf(58, this.f3307.length() + 3) + 1, indexOf);
    }

    /* renamed from: ؠ */
    public String mo9367() {
        int indexOf = this.f3314.indexOf(47, this.f3307.length() + 3);
        String str = this.f3314;
        return this.f3314.substring(indexOf, Util.m931(str, indexOf, str.length(), "?#"));
    }

    /* renamed from: ހ */
    public List<String> mo9369() {
        int indexOf = this.f3314.indexOf(47, this.f3307.length() + 3);
        String str = this.f3314;
        int r1 = Util.m931(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < r1) {
            int i = indexOf + 1;
            int r4 = Util.m930(this.f3314, i, r1, '/');
            arrayList.add(this.f3314.substring(i, r4));
            indexOf = r4;
        }
        return arrayList;
    }

    /* renamed from: ށ */
    public String mo9370() {
        if (this.f3312 == null) {
            return null;
        }
        int indexOf = this.f3314.indexOf(63) + 1;
        String str = this.f3314;
        return this.f3314.substring(indexOf, Util.m930(str, indexOf, str.length(), '#'));
    }

    /* renamed from: ނ */
    public String mo9371() {
        if (this.f3308.isEmpty()) {
            return BidiFormatter.EMPTY_STRING;
        }
        int length = this.f3307.length() + 3;
        String str = this.f3314;
        return this.f3314.substring(length, Util.m931(str, length, str.length(), ":@"));
    }

    /* renamed from: ރ */
    public URI mo9372() {
        String str;
        C1165 r0 = new C1165();
        r0.f3315 = this.f3307;
        r0.f3316 = mo9371();
        r0.f3317 = mo9365();
        r0.f3318 = this.f3310;
        r0.f3319 = this.f3311 != m3115(this.f3307) ? this.f3311 : -1;
        r0.f3320.clear();
        r0.f3320.addAll(mo9369());
        r0.mo9375(mo9370());
        if (this.f3313 == null) {
            str = null;
        } else {
            str = this.f3314.substring(this.f3314.indexOf(35) + 1);
        }
        r0.f3322 = str;
        int size = r0.f3320.size();
        for (int i = 0; i < size; i++) {
            r0.f3320.set(i, m3118(r0.f3320.get(i), "[]", true, true, false, true));
        }
        List<String> list = r0.f3321;
        if (list != null) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str2 = r0.f3321.get(i2);
                if (str2 != null) {
                    r0.f3321.set(i2, m3118(str2, "\\^`{|}", true, true, true, true));
                }
            }
        }
        String str3 = r0.f3322;
        if (str3 != null) {
            r0.f3322 = m3118(str3, " \"#<>\\^`{|}", true, true, false, false);
        }
        String r02 = r0.toString();
        try {
            return new URI(r02);
        } catch (URISyntaxException e) {
            try {
                return URI.create(r02.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", BidiFormatter.EMPTY_STRING));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: com.wpengapp.support.ರ$֏ */
    /* compiled from: HttpUrl */
    public static final class C1165 {

        /* renamed from: ֏ */
        public String f3315;

        /* renamed from: ؠ */
        public String f3316 = BidiFormatter.EMPTY_STRING;

        /* renamed from: ހ */
        public String f3317 = BidiFormatter.EMPTY_STRING;

        /* renamed from: ށ */
        public String f3318;

        /* renamed from: ނ */
        public int f3319 = -1;

        /* renamed from: ރ */
        public final List<String> f3320 = new ArrayList();

        /* renamed from: ބ */
        public List<String> f3321;

        /* renamed from: ޅ */
        public String f3322;

        public C1165() {
            this.f3320.add(BidiFormatter.EMPTY_STRING);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f3315;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f3316.isEmpty() || !this.f3317.isEmpty()) {
                sb.append(this.f3316);
                if (!this.f3317.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f3317);
                }
                sb.append('@');
            }
            String str2 = this.f3318;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f3318);
                    sb.append(']');
                } else {
                    sb.append(this.f3318);
                }
            }
            if (!(this.f3319 == -1 && this.f3315 == null)) {
                int i = this.f3319;
                if (i == -1) {
                    i = HttpUrl.m3115(this.f3315);
                }
                String str3 = this.f3315;
                if (str3 == null || i != HttpUrl.m3115(str3)) {
                    sb.append(':');
                    sb.append(i);
                }
            }
            HttpUrl.m3124(sb, this.f3320);
            if (this.f3321 != null) {
                sb.append('?');
                HttpUrl.m3121(sb, this.f3321);
            }
            if (this.f3322 != null) {
                sb.append('#');
                sb.append(this.f3322);
            }
            return sb.toString();
        }

        /* renamed from: ֏ */
        public C1165 mo9375(String str) {
            this.f3321 = str != null ? HttpUrl.m3125(HttpUrl.m3118(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        /* renamed from: ؠ */
        public C1165 mo9377(String str) {
            if (str != null) {
                this.f3316 = HttpUrl.m3118(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        /* renamed from: ֏ */
        public HttpUrl mo9376() {
            if (this.f3315 == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f3318 != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:104:0x020b, code lost:
            if (r1 <= 65535) goto L_0x0213;
         */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x0235  */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x0255  */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x025b  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x0296  */
        /* JADX WARNING: Removed duplicated region for block: B:166:0x0364  */
        /* JADX WARNING: Removed duplicated region for block: B:167:0x0383  */
        /* JADX WARNING: Removed duplicated region for block: B:171:0x038d  */
        /* JADX WARNING: Removed duplicated region for block: B:172:0x039f  */
        /* JADX WARNING: Removed duplicated region for block: B:173:0x03a1  */
        /* JADX WARNING: Removed duplicated region for block: B:197:0x01df A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:202:0x0356 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0120  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0125  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01c1  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x01e6  */
        /* renamed from: ֏ */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C1165 mo9374(HttpUrl r24, String r25) {
            /*
                r23 = this;
                r0 = r23
                r1 = r24
                r10 = r25
                int r2 = r25.length()
                r8 = 0
                int r9 = com.wpengapp.support.Util.m954((java.lang.String) r10, (int) r8, (int) r2)
                int r2 = r25.length()
                int r11 = com.wpengapp.support.Util.m958(r10, r9, r2)
                int r2 = r11 - r9
                r12 = 2
                r13 = 58
                r14 = -1
                if (r2 >= r12) goto L_0x0020
                goto L_0x0062
            L_0x0020:
                char r2 = r10.charAt(r9)
                r3 = 90
                r4 = 122(0x7a, float:1.71E-43)
                r5 = 65
                r6 = 97
                if (r2 < r6) goto L_0x0030
                if (r2 <= r4) goto L_0x0035
            L_0x0030:
                if (r2 < r5) goto L_0x0062
                if (r2 <= r3) goto L_0x0035
                goto L_0x0062
            L_0x0035:
                r2 = r9
            L_0x0036:
                int r2 = r2 + 1
                if (r2 >= r11) goto L_0x0062
                char r7 = r10.charAt(r2)
                if (r7 < r6) goto L_0x0042
                if (r7 <= r4) goto L_0x005f
            L_0x0042:
                if (r7 < r5) goto L_0x0046
                if (r7 <= r3) goto L_0x005f
            L_0x0046:
                r3 = 48
                if (r7 < r3) goto L_0x004e
                r3 = 57
                if (r7 <= r3) goto L_0x005f
            L_0x004e:
                r3 = 43
                if (r7 == r3) goto L_0x005f
                r3 = 45
                if (r7 == r3) goto L_0x005f
                r3 = 46
                if (r7 != r3) goto L_0x005b
                goto L_0x005f
            L_0x005b:
                if (r7 != r13) goto L_0x0062
                r15 = r2
                goto L_0x0064
            L_0x005f:
                r3 = 90
                goto L_0x0036
            L_0x0062:
                r2 = -1
                r15 = -1
            L_0x0064:
                if (r15 == r14) goto L_0x00ac
                r3 = 1
                r6 = 0
                r7 = 6
                java.lang.String r5 = "https:"
                r2 = r25
                r4 = r9
                boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r2 == 0) goto L_0x007b
                java.lang.String r2 = "https"
                r0.f3315 = r2
                int r9 = r9 + 6
                goto L_0x00b2
            L_0x007b:
                r3 = 1
                r6 = 0
                r7 = 5
                java.lang.String r5 = "http:"
                r2 = r25
                r4 = r9
                boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r2 == 0) goto L_0x0090
                java.lang.String r2 = "http"
                r0.f3315 = r2
                int r9 = r9 + 5
                goto L_0x00b2
            L_0x0090:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Expected URL scheme 'http' or 'https' but was '"
                java.lang.StringBuilder r2 = com.wpengapp.support.outline.m2549(r2)
                java.lang.String r3 = r10.substring(r8, r15)
                r2.append(r3)
                java.lang.String r3 = "'"
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x00ac:
                if (r1 == 0) goto L_0x03bb
                java.lang.String r2 = r1.f3307
                r0.f3315 = r2
            L_0x00b2:
                r2 = 0
                r2 = r9
                r3 = 0
            L_0x00b5:
                r4 = 47
                r5 = 92
                if (r2 >= r11) goto L_0x00c8
                char r6 = r10.charAt(r2)
                if (r6 == r5) goto L_0x00c3
                if (r6 != r4) goto L_0x00c8
            L_0x00c3:
                int r3 = r3 + 1
                int r2 = r2 + 1
                goto L_0x00b5
            L_0x00c8:
                r2 = 63
                r6 = 35
                if (r3 >= r12) goto L_0x0111
                if (r1 == 0) goto L_0x0111
                java.lang.String r7 = r1.f3307
                java.lang.String r8 = r0.f3315
                boolean r7 = r7.equals(r8)
                if (r7 != 0) goto L_0x00db
                goto L_0x0111
            L_0x00db:
                java.lang.String r2 = r24.mo9371()
                r0.f3316 = r2
                java.lang.String r2 = r24.mo9365()
                r0.f3317 = r2
                java.lang.String r2 = r1.f3310
                r0.f3318 = r2
                int r2 = r1.f3311
                r0.f3319 = r2
                java.util.List<java.lang.String> r2 = r0.f3320
                r2.clear()
                java.util.List<java.lang.String> r2 = r0.f3320
                java.util.List r3 = r24.mo9369()
                r2.addAll(r3)
                if (r9 == r11) goto L_0x0105
                char r2 = r10.charAt(r9)
                if (r2 != r6) goto L_0x010c
            L_0x0105:
                java.lang.String r1 = r24.mo9370()
                r0.mo9375(r1)
            L_0x010c:
                r13 = r9
                r17 = r11
                goto L_0x024b
            L_0x0111:
                int r9 = r9 + r3
                r1 = 0
                r3 = 0
                r12 = r9
                r15 = 0
                r16 = 0
            L_0x0118:
                java.lang.String r1 = "@/\\?#"
                int r9 = com.wpengapp.support.Util.m931((java.lang.String) r10, (int) r12, (int) r11, (java.lang.String) r1)
                if (r9 == r11) goto L_0x0125
                char r1 = r10.charAt(r9)
                goto L_0x0126
            L_0x0125:
                r1 = -1
            L_0x0126:
                if (r1 == r14) goto L_0x01bd
                if (r1 == r6) goto L_0x01bd
                if (r1 == r4) goto L_0x01bd
                if (r1 == r5) goto L_0x01bd
                if (r1 == r2) goto L_0x01bd
                r2 = 64
                if (r1 == r2) goto L_0x0136
                goto L_0x01b0
            L_0x0136:
                java.lang.String r14 = "%40"
                if (r15 != 0) goto L_0x0186
                int r8 = com.wpengapp.support.Util.m930((java.lang.String) r10, (int) r12, (int) r9, (char) r13)
                r5 = 1
                r6 = 0
                r7 = 0
                r17 = 1
                r18 = 0
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r1 = r25
                r2 = r12
                r3 = r8
                r12 = r8
                r8 = r17
                r13 = r9
                r9 = r18
                java.lang.String r1 = com.wpengapp.support.HttpUrl.m3116(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                if (r16 == 0) goto L_0x016b
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = r0.f3316
                r2.append(r3)
                r2.append(r14)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
            L_0x016b:
                r0.f3316 = r1
                if (r12 == r13) goto L_0x0183
                int r2 = r12 + 1
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 1
                r9 = 0
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r1 = r25
                r3 = r13
                java.lang.String r1 = com.wpengapp.support.HttpUrl.m3116(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r0.f3317 = r1
                r1 = 1
                r15 = 1
            L_0x0183:
                r16 = 1
                goto L_0x01ae
            L_0x0186:
                r13 = r9
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r1 = r0.f3317
                r9.append(r1)
                r9.append(r14)
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 1
                r14 = 0
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r1 = r25
                r2 = r12
                r3 = r13
                r12 = r9
                r9 = r14
                java.lang.String r1 = com.wpengapp.support.HttpUrl.m3116(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r12.append(r1)
                java.lang.String r1 = r12.toString()
                r0.f3317 = r1
            L_0x01ae:
                int r12 = r13 + 1
            L_0x01b0:
                r6 = 35
                r2 = 63
                r5 = 92
                r14 = -1
                r4 = 47
                r13 = 58
                goto L_0x0118
            L_0x01bd:
                r13 = r9
                r9 = r12
            L_0x01bf:
                if (r9 >= r13) goto L_0x01df
                char r1 = r10.charAt(r9)
                r2 = 58
                if (r1 == r2) goto L_0x01dd
                r3 = 91
                if (r1 == r3) goto L_0x01cf
                r1 = 1
                goto L_0x01db
            L_0x01cf:
                r1 = 1
            L_0x01d0:
                int r9 = r9 + r1
                if (r9 >= r13) goto L_0x01db
                char r3 = r10.charAt(r9)
                r4 = 93
                if (r3 != r4) goto L_0x01d0
            L_0x01db:
                int r9 = r9 + r1
                goto L_0x01bf
            L_0x01dd:
                r14 = r9
                goto L_0x01e0
            L_0x01df:
                r14 = r13
            L_0x01e0:
                int r15 = r14 + 1
                r9 = 34
                if (r15 >= r13) goto L_0x0235
                java.lang.String r1 = m3134(r10, r12, r14)
                r0.f3318 = r1
                java.lang.String r4 = ""
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 1
                r16 = 0
                r1 = r25
                r2 = r15
                r3 = r13
                r17 = r11
                r11 = 34
                r9 = r16
                java.lang.String r1 = com.wpengapp.support.HttpUrl.m3116(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ NumberFormatException -> 0x0212 }
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0212 }
                if (r1 <= 0) goto L_0x0212
                r2 = 65535(0xffff, float:9.1834E-41)
                if (r1 > r2) goto L_0x0212
                goto L_0x0213
            L_0x020e:
                r17 = r11
                r11 = 34
            L_0x0212:
                r1 = -1
            L_0x0213:
                r0.f3319 = r1
                int r1 = r0.f3319
                r2 = -1
                if (r1 == r2) goto L_0x021b
                goto L_0x0247
            L_0x021b:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Invalid URL port: \""
                java.lang.StringBuilder r2 = com.wpengapp.support.outline.m2549(r2)
                java.lang.String r3 = r10.substring(r15, r13)
                r2.append(r3)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0235:
                r17 = r11
                r11 = 34
                java.lang.String r1 = m3134(r10, r12, r14)
                r0.f3318 = r1
                java.lang.String r1 = r0.f3315
                int r1 = com.wpengapp.support.HttpUrl.m3115(r1)
                r0.f3319 = r1
            L_0x0247:
                java.lang.String r1 = r0.f3318
                if (r1 == 0) goto L_0x03a1
            L_0x024b:
                java.lang.String r1 = "?#"
                r2 = r17
                int r1 = com.wpengapp.support.Util.m931((java.lang.String) r10, (int) r13, (int) r2, (java.lang.String) r1)
                if (r13 != r1) goto L_0x025b
                r5 = r0
                r4 = r2
                r2 = r10
                r6 = r2
                goto L_0x035a
            L_0x025b:
                char r3 = r10.charAt(r13)
                java.lang.String r4 = ""
                r5 = 47
                if (r3 == r5) goto L_0x027f
                r5 = 92
                if (r3 != r5) goto L_0x026a
                goto L_0x027f
            L_0x026a:
                java.util.List<java.lang.String> r3 = r0.f3320
                int r5 = r3.size()
                int r5 = r5 + -1
                r3.set(r5, r4)
                r8 = r0
                r7 = r2
                r9 = r4
                r5 = r10
                r6 = r5
                r15 = r13
                r2 = r1
                r4 = r2
                r1 = r8
                goto L_0x0294
            L_0x027f:
                r3 = 1
                java.util.List<java.lang.String> r5 = r0.f3320
                r5.clear()
                java.util.List<java.lang.String> r5 = r0.f3320
                r5.add(r4)
                r8 = r0
                r7 = r2
                r9 = r4
                r5 = r10
                r6 = r5
                r2 = r1
                r4 = r2
                r1 = r8
            L_0x0292:
                int r13 = r13 + r3
                r15 = r13
            L_0x0294:
                if (r15 >= r4) goto L_0x0356
                java.lang.String r3 = "/\\"
                int r3 = com.wpengapp.support.Util.m931((java.lang.String) r5, (int) r15, (int) r4, (java.lang.String) r3)
                if (r3 >= r4) goto L_0x02a0
                r11 = 1
                goto L_0x02a1
            L_0x02a0:
                r11 = 0
            L_0x02a1:
                r18 = 1
                r19 = 0
                r20 = 0
                r21 = 1
                r22 = 0
                java.lang.String r17 = " \"<>^`{}|/\\?#"
                r14 = r5
                r16 = r3
                java.lang.String r12 = com.wpengapp.support.HttpUrl.m3116(r14, r15, r16, r17, r18, r19, r20, r21, r22)
                java.lang.String r13 = "."
                boolean r13 = r12.equals(r13)
                if (r13 != 0) goto L_0x02c7
                java.lang.String r13 = "%2e"
                boolean r13 = r12.equalsIgnoreCase(r13)
                if (r13 == 0) goto L_0x02c5
                goto L_0x02c7
            L_0x02c5:
                r13 = 0
                goto L_0x02c8
            L_0x02c7:
                r13 = 1
            L_0x02c8:
                if (r13 == 0) goto L_0x02cc
                goto L_0x034c
            L_0x02cc:
                java.lang.String r13 = ".."
                boolean r13 = r12.equals(r13)
                if (r13 != 0) goto L_0x02ef
                java.lang.String r13 = "%2e."
                boolean r13 = r12.equalsIgnoreCase(r13)
                if (r13 != 0) goto L_0x02ef
                java.lang.String r13 = ".%2e"
                boolean r13 = r12.equalsIgnoreCase(r13)
                if (r13 != 0) goto L_0x02ef
                java.lang.String r13 = "%2e%2e"
                boolean r13 = r12.equalsIgnoreCase(r13)
                if (r13 == 0) goto L_0x02ed
                goto L_0x02ef
            L_0x02ed:
                r13 = 0
                goto L_0x02f0
            L_0x02ef:
                r13 = 1
            L_0x02f0:
                if (r13 == 0) goto L_0x0320
                java.util.List<java.lang.String> r12 = r8.f3320
                int r13 = r12.size()
                int r13 = r13 + -1
                java.lang.Object r12 = r12.remove(r13)
                java.lang.String r12 = (java.lang.String) r12
                boolean r12 = r12.isEmpty()
                if (r12 == 0) goto L_0x031a
                java.util.List<java.lang.String> r12 = r8.f3320
                boolean r12 = r12.isEmpty()
                if (r12 != 0) goto L_0x031a
                java.util.List<java.lang.String> r12 = r8.f3320
                int r13 = r12.size()
                int r13 = r13 + -1
                r12.set(r13, r9)
                goto L_0x034c
            L_0x031a:
                java.util.List<java.lang.String> r12 = r8.f3320
                r12.add(r9)
                goto L_0x034c
            L_0x0320:
                java.util.List<java.lang.String> r13 = r8.f3320
                int r14 = r13.size()
                int r14 = r14 + -1
                java.lang.Object r13 = r13.get(r14)
                java.lang.String r13 = (java.lang.String) r13
                boolean r13 = r13.isEmpty()
                if (r13 == 0) goto L_0x0340
                java.util.List<java.lang.String> r13 = r8.f3320
                int r14 = r13.size()
                int r14 = r14 + -1
                r13.set(r14, r12)
                goto L_0x0345
            L_0x0340:
                java.util.List<java.lang.String> r13 = r8.f3320
                r13.add(r12)
            L_0x0345:
                if (r11 == 0) goto L_0x034c
                java.util.List<java.lang.String> r12 = r8.f3320
                r12.add(r9)
            L_0x034c:
                if (r11 == 0) goto L_0x0353
                r11 = 1
                r13 = r3
                r3 = 1
                goto L_0x0292
            L_0x0353:
                r15 = r3
                goto L_0x0294
            L_0x0356:
                r5 = r1
                r1 = r2
                r4 = r7
                r2 = r10
            L_0x035a:
                if (r1 >= r4) goto L_0x0383
                char r3 = r6.charAt(r1)
                r7 = 63
                if (r3 != r7) goto L_0x0383
                r3 = 35
                int r16 = com.wpengapp.support.Util.m930((java.lang.String) r6, (int) r1, (int) r4, (char) r3)
                int r8 = r1 + 1
                r11 = 1
                r12 = 0
                r13 = 1
                r14 = 1
                r15 = 0
                java.lang.String r10 = " \"'<>#"
                r7 = r2
                r9 = r16
                java.lang.String r1 = com.wpengapp.support.HttpUrl.m3116(r7, r8, r9, r10, r11, r12, r13, r14, r15)
                java.util.List r1 = com.wpengapp.support.HttpUrl.m3125(r1)
                r5.f3321 = r1
                r1 = r16
                goto L_0x0385
            L_0x0383:
                r3 = 35
            L_0x0385:
                if (r1 >= r4) goto L_0x039f
                char r6 = r6.charAt(r1)
                if (r6 != r3) goto L_0x039f
                int r3 = r1 + 1
                r6 = 1
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                java.lang.String r1 = ""
                r11 = r5
                r5 = r1
                java.lang.String r1 = com.wpengapp.support.HttpUrl.m3116(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                r11.f3322 = r1
                goto L_0x03a0
            L_0x039f:
                r11 = r5
            L_0x03a0:
                return r11
            L_0x03a1:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Invalid URL host: \""
                java.lang.StringBuilder r2 = com.wpengapp.support.outline.m2549(r2)
                java.lang.String r3 = r10.substring(r12, r14)
                r2.append(r3)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x03bb:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Expected URL scheme 'http' or 'https' but no colon was found"
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.HttpUrl.C1165.mo9374(com.wpengapp.support.ರ, java.lang.String):com.wpengapp.support.ರ$֏");
        }

        /* renamed from: ֏ */
        public static String m3134(String str, int i, int i2) {
            return Util.m936(HttpUrl.m3117(str, i, i2, false));
        }
    }

    /* renamed from: ؠ */
    public static void m3124(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    /* renamed from: ֏ */
    public static int m3115(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: ށ */
    public static List<String> m3125(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: ހ */
    public C1165 mo9368(String str) {
        try {
            C1165 r0 = new C1165();
            r0.mo9374(this, str);
            return r0;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: ֏ */
    public static void m3121(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: ؠ */
    public static HttpUrl m3123(String str) {
        C1165 r0 = new C1165();
        r0.mo9374((HttpUrl) null, str);
        return r0.mo9376();
    }

    /* renamed from: ֏ */
    public static String m3120(String str, boolean z) {
        return m3117(str, 0, str.length(), z);
    }

    /* renamed from: ֏ */
    public final List<String> mo9366(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? m3117(str, 0, str.length(), z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: ֏ */
    public static String m3117(String str, int i, int i2, boolean z) {
        int i3;
        int i4 = i;
        while (i4 < i2) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer r1 = new Buffer();
                r1.mo9194(str, i, i4);
                while (i4 < i2) {
                    int codePointAt = str.codePointAt(i4);
                    if (codePointAt == 37 && (i3 = i4 + 2) < i2) {
                        int r5 = Util.m929(str.charAt(i4 + 1));
                        int r6 = Util.m929(str.charAt(i3));
                        if (!(r5 == -1 || r6 == -1)) {
                            r1.writeByte((r5 << 4) + r6);
                            i4 = i3;
                            i4 += Character.charCount(codePointAt);
                        }
                    } else if (codePointAt == 43 && z) {
                        r1.writeByte(32);
                        i4 += Character.charCount(codePointAt);
                    }
                    r1.mo9197(codePointAt);
                    i4 += Character.charCount(codePointAt);
                }
                return r1.mo9203();
            }
            i4++;
        }
        return str.substring(i, i2);
    }

    /* renamed from: ֏ */
    public static boolean m3122(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != '%' || Util.m929(str.charAt(i + 1)) == -1 || Util.m929(str.charAt(i3)) == -1) {
            return false;
        }
        return true;
    }

    /* renamed from: ֏ */
    public static String m3116(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i3 = i2;
        String str4 = str2;
        Charset charset2 = charset;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str3.codePointAt(i4);
            int i5 = -1;
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str4.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !m3122(str3, i4, i3)))) || (codePointAt == 43 && z3)))) {
                Buffer r5 = new Buffer();
                r5.mo9194(str3, i, i4);
                Buffer r12 = null;
                while (i4 < i3) {
                    int codePointAt2 = str3.codePointAt(i4);
                    if (!z || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                        if (codePointAt2 == 43 && z3) {
                            r5.mo8111(z ? "+" : "%2B");
                        } else if (codePointAt2 < 32 || codePointAt2 == 127 || ((codePointAt2 >= 128 && z4) || str4.indexOf(codePointAt2) != i5 || (codePointAt2 == 37 && (!z || (z2 && !m3122(str3, i4, i3)))))) {
                            if (r12 == null) {
                                r12 = new Buffer();
                            }
                            if (charset2 == null || charset2.equals(Util.f737)) {
                                r12.mo9197(codePointAt2);
                            } else {
                                int charCount = Character.charCount(codePointAt2) + i4;
                                if (i4 < 0) {
                                    throw new IllegalAccessError(outline.m2543("beginIndex < 0: ", i4));
                                } else if (charCount < i4) {
                                    throw new IllegalArgumentException("endIndex < beginIndex: " + charCount + " < " + i4);
                                } else if (charCount > str.length()) {
                                    throw new IllegalArgumentException("endIndex > string.length: " + charCount + " > " + str.length());
                                } else if (charset2.equals(C0751.f1936)) {
                                    r12.mo9194(str3, i4, charCount);
                                } else {
                                    byte[] bytes = str3.substring(i4, charCount).getBytes(charset2);
                                    r12.mo9198(bytes, 0, bytes.length);
                                }
                            }
                            while (!r12.mo8493()) {
                                byte readByte = r12.readByte() & 255;
                                r5.writeByte(37);
                                r5.writeByte((int) f3306[(readByte >> 4) & 15]);
                                r5.writeByte((int) f3306[readByte & 15]);
                            }
                        } else {
                            r5.mo9197(codePointAt2);
                        }
                    }
                    i4 += Character.charCount(codePointAt2);
                    i5 = -1;
                }
                return r5.mo9203();
            }
            i4 += Character.charCount(codePointAt);
        }
        int i6 = i;
        return str.substring(i, i2);
    }

    /* renamed from: ֏ */
    public static String m3119(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return m3116(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    /* renamed from: ֏ */
    public static String m3118(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m3116(str, 0, str.length(), str2, z, z2, z3, z4, (Charset) null);
    }
}
