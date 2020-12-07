package com.google.gson.internal.bind.util;

import com.wpengapp.support.outline;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    public static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    public static final String UTC_ID = "UTC";

    public static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    public static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d6 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ba A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01c2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Date parse(String r17, java.text.ParsePosition r18) {
        /*
            r1 = r17
            r2 = r18
            java.lang.String r3 = "'"
            int r0 = r18.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            int r4 = r0 + 4
            int r0 = parseInt(r1, r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r5 = 45
            boolean r6 = checkOffset(r1, r4, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r6 == 0) goto L_0x001a
            int r4 = r4 + 1
        L_0x001a:
            int r6 = r4 + 2
            int r4 = parseInt(r1, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            boolean r7 = checkOffset(r1, r6, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r7 == 0) goto L_0x0028
            int r6 = r6 + 1
        L_0x0028:
            int r7 = r6 + 2
            int r6 = parseInt(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r8 = 84
            boolean r8 = checkOffset(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r9 = 1
            if (r8 != 0) goto L_0x004b
            int r10 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r10 > r7) goto L_0x004b
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            int r4 = r4 - r9
            r5.<init>(r0, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r2.setIndex(r7)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.util.Date r0 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            return r0
        L_0x004b:
            r10 = 43
            r11 = 90
            r12 = 2
            if (r8 == 0) goto L_0x00c3
            int r7 = r7 + 1
            int r8 = r7 + 2
            int r7 = parseInt(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r13 = 58
            boolean r14 = checkOffset(r1, r8, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r14 == 0) goto L_0x0064
            int r8 = r8 + 1
        L_0x0064:
            int r14 = r8 + 2
            int r8 = parseInt(r1, r8, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            boolean r13 = checkOffset(r1, r14, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r13 == 0) goto L_0x0072
            int r14 = r14 + 1
        L_0x0072:
            int r13 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r13 <= r14) goto L_0x00c0
            char r13 = r1.charAt(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r13 == r11) goto L_0x00c0
            if (r13 == r10) goto L_0x00c0
            if (r13 == r5) goto L_0x00c0
            int r5 = r14 + 2
            int r13 = parseInt(r1, r14, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r14 = 59
            if (r13 <= r14) goto L_0x0092
            r14 = 63
            if (r13 >= r14) goto L_0x0092
            r13 = 59
        L_0x0092:
            r14 = 46
            boolean r14 = checkOffset(r1, r5, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r14 == 0) goto L_0x00ba
            int r5 = r5 + 1
            int r14 = r5 + 1
            int r14 = indexOfNonDigit(r1, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            int r15 = r5 + 3
            int r15 = java.lang.Math.min(r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            int r16 = parseInt(r1, r5, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            int r15 = r15 - r5
            if (r15 == r9) goto L_0x00b5
            if (r15 == r12) goto L_0x00b2
            goto L_0x00b7
        L_0x00b2:
            int r16 = r16 * 10
            goto L_0x00b7
        L_0x00b5:
            int r16 = r16 * 100
        L_0x00b7:
            r12 = r8
            r5 = r14
            goto L_0x00cd
        L_0x00ba:
            r16 = 0
            r12 = r8
            r8 = r7
            r7 = 0
            goto L_0x00d0
        L_0x00c0:
            r5 = 0
            r5 = r14
            goto L_0x00c9
        L_0x00c3:
            r5 = 0
            r8 = 0
            r12 = 0
            r5 = r7
            r7 = 0
            r8 = 0
        L_0x00c9:
            r16 = 0
            r13 = 0
            r12 = r8
        L_0x00cd:
            r8 = r7
            r7 = r16
        L_0x00d0:
            int r14 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r14 <= r5) goto L_0x01ba
            char r14 = r1.charAt(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r15 = 5
            if (r14 != r11) goto L_0x00e2
            java.util.TimeZone r10 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            int r5 = r5 + r9
            goto L_0x0188
        L_0x00e2:
            if (r14 == r10) goto L_0x0103
            r9 = 45
            if (r14 != r9) goto L_0x00e9
            goto L_0x0103
        L_0x00e9:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r4.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r5 = "Invalid time zone indicator '"
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r4.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r4.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
        L_0x0103:
            java.lang.String r9 = r1.substring(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            int r10 = r9.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r10 < r15) goto L_0x010e
            goto L_0x011f
        L_0x010e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r10.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r10.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r9 = "00"
            r10.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r9 = r10.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
        L_0x011f:
            int r10 = r9.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            int r5 = r5 + r10
            java.lang.String r10 = "+0000"
            boolean r10 = r10.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r10 != 0) goto L_0x0186
            java.lang.String r10 = "+00:00"
            boolean r10 = r10.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r10 == 0) goto L_0x0135
            goto L_0x0186
        L_0x0135:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r10.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r11 = "GMT"
            r10.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r10.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r9 = r10.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.util.TimeZone r10 = java.util.TimeZone.getTimeZone(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r11 = r10.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            boolean r14 = r11.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r14 != 0) goto L_0x0188
            java.lang.String r14 = ":"
            java.lang.String r15 = ""
            java.lang.String r11 = r11.replace(r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            boolean r11 = r11.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            if (r11 == 0) goto L_0x0163
            goto L_0x0188
        L_0x0163:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r4.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r5 = "Mismatching time zone indicator: "
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r4.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r5 = " given, resolves to "
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r5 = r10.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
        L_0x0186:
            java.util.TimeZone r10 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
        L_0x0188:
            java.util.GregorianCalendar r9 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r9.<init>(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r10 = 0
            r9.setLenient(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r10 = 1
            r9.set(r10, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            int r4 = r4 - r10
            r0 = 2
            r9.set(r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r0 = 5
            r9.set(r0, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r0 = 11
            r9.set(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r0 = 12
            r9.set(r0, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r0 = 13
            r9.set(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r0 = 14
            r9.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            r2.setIndex(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.util.Date r0 = r9.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            return r0
        L_0x01ba:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            java.lang.String r4 = "No time zone indicator"
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01c6, NumberFormatException -> 0x01c4, IllegalArgumentException -> 0x01c2 }
        L_0x01c2:
            r0 = move-exception
            goto L_0x01c7
        L_0x01c4:
            r0 = move-exception
            goto L_0x01c7
        L_0x01c6:
            r0 = move-exception
        L_0x01c7:
            if (r1 != 0) goto L_0x01cb
            r1 = 0
            goto L_0x01df
        L_0x01cb:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 34
            r4.append(r5)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r4.toString()
        L_0x01df:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01eb
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0205
        L_0x01eb:
            java.lang.String r3 = "("
            java.lang.StringBuilder r3 = com.wpengapp.support.outline.m2549(r3)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x0205:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to parse date ["
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = "]: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r18.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int parseInt(String str, int i, int i2) {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                StringBuilder r0 = outline.m2549("Invalid number: ");
                r0.append(str.substring(i, i2));
                throw new NumberFormatException(r0.toString());
            }
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                StringBuilder r02 = outline.m2549("Invalid number: ");
                r02.append(str.substring(i, i2));
                throw new NumberFormatException(r02.toString());
            }
        }
        return -i3;
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        char c = '-';
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}
