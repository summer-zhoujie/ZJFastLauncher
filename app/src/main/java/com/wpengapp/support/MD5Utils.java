package com.wpengapp.support;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.wpengapp.support.ș */
public class MD5Utils {

    /* renamed from: ֏ */
    public static char[] f1086 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[SYNTHETIC, Splitter:B:20:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0035 A[SYNTHETIC, Splitter:B:28:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x003c A[SYNTHETIC, Splitter:B:36:0x003c] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m1341(java.io.File r5) {
        /*
            r0 = 0
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x003f }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0039, IOException -> 0x0032, all -> 0x002a }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0039, IOException -> 0x0032, all -> 0x002a }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0033, all -> 0x0028 }
        L_0x0010:
            int r3 = r2.read(r5)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0033, all -> 0x0028 }
            r4 = -1
            if (r3 == r4) goto L_0x001c
            r4 = 0
            r1.update(r5, r4, r3)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0033, all -> 0x0028 }
            goto L_0x0010
        L_0x001c:
            byte[] r5 = r1.digest()     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0033, all -> 0x0028 }
            java.lang.String r5 = m1343((byte[]) r5)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0033, all -> 0x0028 }
            r2.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            return r5
        L_0x0028:
            r5 = move-exception
            goto L_0x002c
        L_0x002a:
            r5 = move-exception
            r2 = r0
        L_0x002c:
            if (r2 == 0) goto L_0x0031
            r2.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            throw r5
        L_0x0032:
            r2 = r0
        L_0x0033:
            if (r2 == 0) goto L_0x0038
            r2.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            return r0
        L_0x0039:
            r2 = r0
        L_0x003a:
            if (r2 == 0) goto L_0x003f
            r2.close()     // Catch:{  }
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.MD5Utils.m1341(java.io.File):java.lang.String");
    }

    /* renamed from: ֏ */
    public static String m1342(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            return m1343(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: ֏ */
    public static String m1343(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i = length + 0;
        for (int i2 = 0; i2 < i; i2++) {
            byte b = bArr[i2];
            char[] cArr = f1086;
            char c = cArr[(b & 240) >> 4];
            char c2 = cArr[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
