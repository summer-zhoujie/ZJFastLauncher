package com.wpengapp.support;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.wpengapp.support.ʼ */
public class Md5FileNameGenerator implements FileNameGenerator {
    /* renamed from: ֏ */
    public String mo8303(String str) {
        byte[] bArr;
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            bArr = instance.digest();
        } catch (NoSuchAlgorithmException e) {
            L.m2160(e);
            bArr = null;
        }
        return new BigInteger(bArr).abs().toString(36);
    }
}
