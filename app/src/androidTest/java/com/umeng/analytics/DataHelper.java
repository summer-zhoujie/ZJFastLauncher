package com.umeng.analytics;

import android.content.Context;
import com.wpengapp.support.C1315;
import com.wpengapp.support.MLog;
import com.wpengapp.support.outline;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.umeng.analytics.b */
public class DataHelper {

    /* renamed from: a */
    public static final byte[] f124a = {10, 1, 11, 5, 4, 15, 7, 9, 23, 3, 1, 6, 8, 12, 13, 91};

    /* renamed from: a */
    public static byte[] m61a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[(length / 2)];
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            bArr[i / 2] = (byte) Integer.valueOf(str.substring(i, i2), 16).intValue();
            i = i2;
        }
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m64b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m60a(Context context, byte[] bArr) {
        long length = (long) bArr.length;
        if (length <= AnalyticsConstants.f119v) {
            return false;
        }
        StoreHelper.m156a(context).mo7351h();
        C1315.f3758 = context;
        C1315.C1317.f3769.mo9583(length, System.currentTimeMillis(), AnalyticsConstants.f116s);
        return true;
    }

    /* renamed from: b */
    public static byte[] m65b(byte[] bArr, byte[] bArr2) {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(f124a));
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    public static String m59a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    /* renamed from: b */
    public static String m63b(String str) {
        return outline.m2545("http://", str, ".umeng.com/app_logs");
    }

    /* renamed from: a */
    public static byte[] m62a(byte[] bArr, byte[] bArr2) {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(f124a));
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    public static int m57a(int i, String str) {
        if (((double) new Random().nextFloat()) < 0.001d) {
            int i2 = 0;
            if (str == null) {
                MLog.m1775("--->", "null signature..");
            }
            try {
                i2 = Integer.parseInt(str.substring(9, 11), 16);
            } catch (Exception unused) {
            }
            return (i2 | 128) * 1000;
        }
        int nextInt = new Random().nextInt(i);
        if (nextInt > 255000 || nextInt < 128000) {
            return nextInt;
        }
        return 127000;
    }

    /* renamed from: a */
    public static String m58a(Throwable th) {
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return stringWriter2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
