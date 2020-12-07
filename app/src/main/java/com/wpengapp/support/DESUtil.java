package com.wpengapp.support;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.wpengapp.support.ƙ */
public class DESUtil {

    /* renamed from: ֏ */
    public static byte[] f931 = {1, 2, 3, 4, 5, 6, 7, 8};

    /* renamed from: ؠ */
    public Key f932;

    public DESUtil(String str) {
        try {
            this.f932 = new SecretKeySpec(str.getBytes(), "DES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ֏ */
    public final byte[] mo8066(byte[] bArr) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f931);
        try {
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, this.f932, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: ؠ */
    public final byte[] mo8067(byte[] bArr) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f931);
        try {
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, this.f932, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
