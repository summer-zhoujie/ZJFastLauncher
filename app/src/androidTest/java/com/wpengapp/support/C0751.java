package com.wpengapp.support;

import java.nio.charset.Charset;

/* renamed from: com.wpengapp.support.ӥ */
/* compiled from: Util */
public final class C0751 {

    /* renamed from: ֏ */
    public static final Charset f1936 = Charset.forName("UTF-8");

    /* renamed from: ֏ */
    public static int m1964(int i) {
        return ((i & 255) << 24) | ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    /* renamed from: ֏ */
    public static short m1965(short s) {
        short s2 = s & 65535;
        return (short) (((s2 & 255) << 8) | ((65280 & s2) >>> 8));
    }

    /* renamed from: ֏ */
    public static void m1966(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    /* renamed from: ֏ */
    public static void m1967(Throwable th) {
        throw th;
    }

    /* renamed from: ֏ */
    public static boolean m1968(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
