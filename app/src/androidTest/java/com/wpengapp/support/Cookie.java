package com.wpengapp.support;

import android.support.p003v7.widget.RecyclerView;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.wpengapp.support.ʄ */
public final class Cookie {

    /* renamed from: ֏ */
    public static final Pattern f1317 = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: ؠ */
    public static final Pattern f1318 = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: ހ */
    public static final Pattern f1319 = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: ށ */
    public static final Pattern f1320 = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: ނ */
    public final String f1321;

    /* renamed from: ރ */
    public final String f1322;

    /* renamed from: ބ */
    public final long f1323;

    /* renamed from: ޅ */
    public final String f1324;

    /* renamed from: ކ */
    public final String f1325;

    /* renamed from: އ */
    public final boolean f1326;

    /* renamed from: ވ */
    public final boolean f1327;

    /* renamed from: މ */
    public final boolean f1328;

    /* renamed from: ފ */
    public final boolean f1329;

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f1321 = str;
        this.f1322 = str2;
        this.f1323 = j;
        this.f1324 = str3;
        this.f1325 = str4;
        this.f1326 = z;
        this.f1327 = z2;
        this.f1329 = z3;
        this.f1328 = z4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01ad, code lost:
        if (r2 == false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d6, code lost:
        if (r19 <= 0) goto L_0x00eb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0204 A[SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<Cookie> m1467(com.wpengapp.support.HttpUrl r33, com.wpengapp.support.Headers r34) {
        /*
            r0 = r34
            int r1 = r34.mo8176()
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0009:
            if (r4 >= r1) goto L_0x0029
            java.lang.String r6 = r0.mo8175((int) r4)
            java.lang.String r7 = "Set-Cookie"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0026
            if (r5 != 0) goto L_0x001f
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 2
            r5.<init>(r6)
        L_0x001f:
            java.lang.String r6 = r0.mo8177((int) r4)
            r5.add(r6)
        L_0x0026:
            int r4 = r4 + 1
            goto L_0x0009
        L_0x0029:
            if (r5 == 0) goto L_0x0030
            java.util.List r0 = java.util.Collections.unmodifiableList(r5)
            goto L_0x0034
        L_0x0030:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x0034:
            r1 = r0
            int r4 = r1.size()
            r5 = 0
            r6 = 0
        L_0x003b:
            if (r5 >= r4) goto L_0x0208
            java.lang.Object r0 = r1.get(r5)
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            long r8 = java.lang.System.currentTimeMillis()
            int r10 = r7.length()
            r11 = 59
            int r0 = com.wpengapp.support.Util.m930((java.lang.String) r7, (int) r3, (int) r10, (char) r11)
            r12 = 61
            int r13 = com.wpengapp.support.Util.m930((java.lang.String) r7, (int) r3, (int) r0, (char) r12)
            if (r13 != r0) goto L_0x005e
        L_0x005a:
            r7 = r33
            goto L_0x01f6
        L_0x005e:
            java.lang.String r15 = com.wpengapp.support.Util.m960(r7, r3, r13)
            boolean r14 = r15.isEmpty()
            if (r14 != 0) goto L_0x005a
            int r14 = com.wpengapp.support.Util.m953((java.lang.String) r15)
            r2 = -1
            if (r14 == r2) goto L_0x0070
            goto L_0x005a
        L_0x0070:
            int r13 = r13 + 1
            java.lang.String r16 = com.wpengapp.support.Util.m960(r7, r13, r0)
            int r13 = com.wpengapp.support.Util.m953((java.lang.String) r16)
            if (r13 == r2) goto L_0x007d
            goto L_0x005a
        L_0x007d:
            int r0 = r0 + 1
            r17 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r2 = 1
            r21 = r17
            r19 = -1
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 1
            r28 = 0
        L_0x0095:
            r29 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r31 = -9223372036854775808
            if (r0 >= r10) goto L_0x014b
            int r13 = com.wpengapp.support.Util.m930((java.lang.String) r7, (int) r0, (int) r10, (char) r11)
            int r14 = com.wpengapp.support.Util.m930((java.lang.String) r7, (int) r0, (int) r13, (char) r12)
            java.lang.String r0 = com.wpengapp.support.Util.m960(r7, r0, r14)
            if (r14 >= r13) goto L_0x00b3
            int r14 = r14 + 1
            java.lang.String r14 = com.wpengapp.support.Util.m960(r7, r14, r13)
            goto L_0x00b5
        L_0x00b3:
            java.lang.String r14 = ""
        L_0x00b5:
            java.lang.String r11 = "expires"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x00c6
            int r0 = r14.length()     // Catch:{ IllegalArgumentException -> 0x0145 }
            long r21 = m1466(r14, r3, r0)     // Catch:{ IllegalArgumentException -> 0x0145 }
            goto L_0x00f0
        L_0x00c6:
            java.lang.String r11 = "max-age"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x00f4
            long r19 = java.lang.Long.parseLong(r14)     // Catch:{ NumberFormatException -> 0x00d9 }
            r28 = 0
            int r0 = (r19 > r28 ? 1 : (r19 == r28 ? 0 : -1))
            if (r0 > 0) goto L_0x00f0
            goto L_0x00eb
        L_0x00d9:
            r0 = move-exception
            r11 = r0
            java.lang.String r0 = "-?\\d+"
            boolean r0 = r14.matches(r0)     // Catch:{  }
            if (r0 == 0) goto L_0x00f3
            java.lang.String r0 = "-"
            boolean r0 = r14.startsWith(r0)     // Catch:{  }
            if (r0 == 0) goto L_0x00ee
        L_0x00eb:
            r19 = r31
            goto L_0x00f0
        L_0x00ee:
            r19 = r29
        L_0x00f0:
            r28 = 1
            goto L_0x0145
        L_0x00f3:
            throw r11     // Catch:{  }
        L_0x00f4:
            java.lang.String r11 = "domain"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x0125
            java.lang.String r0 = "."
            boolean r11 = r14.endsWith(r0)     // Catch:{ IllegalArgumentException -> 0x0145 }
            if (r11 != 0) goto L_0x011f
            boolean r0 = r14.startsWith(r0)     // Catch:{ IllegalArgumentException -> 0x0145 }
            if (r0 == 0) goto L_0x010e
            java.lang.String r14 = r14.substring(r2)     // Catch:{ IllegalArgumentException -> 0x0145 }
        L_0x010e:
            java.lang.String r0 = com.wpengapp.support.Util.m936((java.lang.String) r14)     // Catch:{ IllegalArgumentException -> 0x0145 }
            if (r0 == 0) goto L_0x0119
            r25 = r0
            r27 = 0
            goto L_0x0145
        L_0x0119:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0145 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x0145 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0145 }
        L_0x011f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0145 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x0145 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0145 }
        L_0x0125:
            java.lang.String r11 = "path"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x0130
            r26 = r14
            goto L_0x0145
        L_0x0130:
            java.lang.String r11 = "secure"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x013b
            r23 = 1
            goto L_0x0145
        L_0x013b:
            java.lang.String r11 = "httponly"
            boolean r0 = r0.equalsIgnoreCase(r11)
            if (r0 == 0) goto L_0x0145
            r24 = 1
        L_0x0145:
            int r0 = r13 + 1
            r11 = 59
            goto L_0x0095
        L_0x014b:
            int r0 = (r19 > r31 ? 1 : (r19 == r31 ? 0 : -1))
            if (r0 != 0) goto L_0x0154
            r7 = r33
            r17 = r31
            goto L_0x017e
        L_0x0154:
            r10 = -1
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x017a
            r10 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x0167
            r10 = 1000(0x3e8, double:4.94E-321)
            long r29 = r19 * r10
        L_0x0167:
            long r29 = r8 + r29
            int r0 = (r29 > r8 ? 1 : (r29 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0177
            int r0 = (r29 > r17 ? 1 : (r29 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x0172
            goto L_0x0177
        L_0x0172:
            r7 = r33
            r17 = r29
            goto L_0x017e
        L_0x0177:
            r7 = r33
            goto L_0x017e
        L_0x017a:
            r7 = r33
            r17 = r21
        L_0x017e:
            java.lang.String r0 = r7.f3310
            r8 = r25
            if (r8 != 0) goto L_0x0186
            r8 = r0
            goto L_0x01b0
        L_0x0186:
            boolean r9 = r0.equals(r8)
            if (r9 == 0) goto L_0x018d
            goto L_0x01ad
        L_0x018d:
            boolean r9 = r0.endsWith(r8)
            if (r9 == 0) goto L_0x01ac
            int r9 = r0.length()
            int r10 = r8.length()
            int r9 = r9 - r10
            int r9 = r9 - r2
            char r9 = r0.charAt(r9)
            r10 = 46
            if (r9 != r10) goto L_0x01ac
            boolean r9 = com.wpengapp.support.Util.m959(r0)
            if (r9 != 0) goto L_0x01ac
            goto L_0x01ad
        L_0x01ac:
            r2 = 0
        L_0x01ad:
            if (r2 != 0) goto L_0x01b0
            goto L_0x01f6
        L_0x01b0:
            int r0 = r0.length()
            int r2 = r8.length()
            if (r0 == r2) goto L_0x01c3
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.f3849
            java.lang.String r0 = r0.mo9652((java.lang.String) r8)
            if (r0 != 0) goto L_0x01c3
            goto L_0x01f6
        L_0x01c3:
            java.lang.String r0 = "/"
            r2 = r26
            if (r2 == 0) goto L_0x01d3
            boolean r9 = r2.startsWith(r0)
            if (r9 != 0) goto L_0x01d0
            goto L_0x01d3
        L_0x01d0:
            r20 = r2
            goto L_0x01e5
        L_0x01d3:
            java.lang.String r2 = r33.mo9367()
            r9 = 47
            int r9 = r2.lastIndexOf(r9)
            if (r9 == 0) goto L_0x01e3
            java.lang.String r0 = r2.substring(r3, r9)
        L_0x01e3:
            r20 = r0
        L_0x01e5:
            com.wpengapp.support.ʄ r0 = new com.wpengapp.support.ʄ
            r14 = r0
            r19 = r8
            r21 = r23
            r22 = r24
            r23 = r27
            r24 = r28
            r14.<init>(r15, r16, r17, r19, r20, r21, r22, r23, r24)
            goto L_0x01f7
        L_0x01f6:
            r0 = 0
        L_0x01f7:
            if (r0 != 0) goto L_0x01fa
            goto L_0x0204
        L_0x01fa:
            if (r6 != 0) goto L_0x0201
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0201:
            r6.add(r0)
        L_0x0204:
            int r5 = r5 + 1
            goto L_0x003b
        L_0x0208:
            if (r6 == 0) goto L_0x020f
            java.util.List r0 = java.util.Collections.unmodifiableList(r6)
            goto L_0x0213
        L_0x020f:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x0213:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Cookie.m1467(com.wpengapp.support.ರ, com.wpengapp.support.Ʌ):java.util.List");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie r7 = (Cookie) obj;
        if (r7.f1321.equals(this.f1321) && r7.f1322.equals(this.f1322) && r7.f1324.equals(this.f1324) && r7.f1325.equals(this.f1325) && r7.f1323 == this.f1323 && r7.f1326 == this.f1326 && r7.f1327 == this.f1327 && r7.f1328 == this.f1328 && r7.f1329 == this.f1329) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f1322.hashCode();
        int hashCode2 = this.f1324.hashCode();
        int hashCode3 = this.f1325.hashCode();
        long j = this.f1323;
        return ((((((((((hashCode3 + ((hashCode2 + ((hashCode + ((this.f1321.hashCode() + 527) * 31)) * 31)) * 31)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.f1326 ^ true ? 1 : 0)) * 31) + (this.f1327 ^ true ? 1 : 0)) * 31) + (this.f1328 ^ true ? 1 : 0)) * 31) + (this.f1329 ^ true ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1321);
        sb.append('=');
        sb.append(this.f1322);
        if (this.f1328) {
            if (this.f1323 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(C0943.f2575.get().format(new Date(this.f1323)));
            }
        }
        if (!this.f1329) {
            sb.append("; domain=");
            sb.append(this.f1324);
        }
        sb.append("; path=");
        sb.append(this.f1325);
        if (this.f1326) {
            sb.append("; secure");
        }
        if (this.f1327) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    /* renamed from: ֏ */
    public static long m1466(String str, int i, int i2) {
        int r13 = m1465(str, i, i2, false);
        Matcher matcher = f1320.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (r13 < i2) {
            int r11 = m1465(str, r13 + 1, i2, true);
            matcher.region(r13, r11);
            if (i4 == -1 && matcher.usePattern(f1320).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
                i7 = parseInt2;
                i4 = parseInt;
            } else if (i5 == -1 && matcher.usePattern(f1319).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(f1318).matches()) {
                i6 = f1318.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(f1317).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
            }
            r13 = m1465(str, r11 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += RecyclerView.MAX_SCROLL_DURATION;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.f742);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    /* renamed from: ֏ */
    public static int m1465(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }
}
