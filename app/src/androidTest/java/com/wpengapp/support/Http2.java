package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import java.io.IOException;

/* renamed from: com.wpengapp.support.Н */
public final class Http2 {

    /* renamed from: ֏ */
    public static final ByteString f1794 = ByteString.m2188("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: ؠ */
    public static final String[] f1795 = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: ހ */
    public static final String[] f1796 = new String[64];

    /* renamed from: ށ */
    public static final String[] f1797 = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f1797;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = Util.m937("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f1796;
        strArr2[0] = BidiFormatter.EMPTY_STRING;
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 : iArr) {
            f1796[i3 | 8] = outline.m2548(new StringBuilder(), f1796[i3], "|PADDED");
        }
        String[] strArr3 = f1796;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        for (int i4 : new int[]{4, 32, 36}) {
            for (int i5 : iArr) {
                int i6 = i5 | i4;
                f1796[i6] = f1796[i5] + '|' + f1796[i4];
                StringBuilder sb = new StringBuilder();
                sb.append(f1796[i5]);
                sb.append('|');
                f1796[i6 | 8] = outline.m2548(sb, f1796[i4], "|PADDED");
            }
        }
        while (true) {
            String[] strArr4 = f1796;
            if (i < strArr4.length) {
                if (strArr4[i] == null) {
                    strArr4[i] = f1797[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: ֏ */
    public static IllegalArgumentException m1760(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.m937(str, objArr));
    }

    /* renamed from: ؠ */
    public static IOException m1762(String str, Object... objArr) {
        throw new IOException(Util.m937(str, objArr));
    }

    /* renamed from: ֏ */
    public static String m1761(boolean z, int i, int i2, byte b, byte b2) {
        String str;
        String[] strArr = f1795;
        String r0 = b < strArr.length ? strArr[b] : Util.m937("0x%02x", Byte.valueOf(b));
        if (b2 == 0) {
            str = BidiFormatter.EMPTY_STRING;
        } else {
            if (!(b == 2 || b == 3)) {
                if (b == 4 || b == 6) {
                    str = b2 == 1 ? "ACK" : f1797[b2];
                } else if (!(b == 7 || b == 8)) {
                    String[] strArr2 = f1796;
                    String str2 = b2 < strArr2.length ? strArr2[b2] : f1797[b2];
                    str = (b != 5 || (b2 & 4) == 0) ? (b != 0 || (b2 & 32) == 0) ? str2 : str2.replace("PRIORITY", "COMPRESSED") : str2.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            str = f1797[b2];
        }
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = r0;
        objArr[4] = str;
        return Util.m937("%s 0x%08x %5d %-13s %s", objArr);
    }
}
