package com.wpengapp.support;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.wpengapp.support.ǩ */
public class MCPTool {

    /* renamed from: ֏ */
    public static final byte[] f997 = {1, 3, 1, 4, 5, 2, 0, 1};

    /* renamed from: ֏ */
    public static String m1261(Context context, String str, String str2) {
        String str3;
        try {
            str3 = new String(m1263(new File(context.getPackageCodePath()), str), "UTF-8");
        } catch (Exception unused) {
            str3 = null;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    /* renamed from: ֏ */
    public static byte[] m1263(File file, String str) {
        String str2;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bytes = "MCPT".getBytes("UTF-8");
        byte[] bArr = new byte[bytes.length];
        long length = randomAccessFile.length() - ((long) bytes.length);
        randomAccessFile.seek(length);
        randomAccessFile.readFully(bArr);
        boolean equals = Arrays.equals(bArr, bytes);
        byte[] bArr2 = null;
        if (equals) {
            byte[] bArr3 = new byte[2];
            long length2 = length - ((long) bArr3.length);
            randomAccessFile.seek(length2);
            randomAccessFile.readFully(bArr3);
            int r1 = m1262(bArr3, 0);
            length = length2 - ((long) r1);
            byte[] bArr4 = new byte[r1];
            randomAccessFile.seek(length);
            randomAccessFile.readFully(bArr4);
            str2 = new String(bArr4, "UTF-8");
        } else {
            str2 = null;
        }
        boolean z = true;
        Object[] objArr = {Long.valueOf(length), str2};
        long longValue = ((Long) objArr[0]).longValue();
        if ("1.1".equals((String) objArr[1])) {
            byte[] bArr5 = new byte[1];
            long length3 = longValue - ((long) bArr5.length);
            randomAccessFile.seek(length3);
            randomAccessFile.readFully(bArr5);
            if (bArr5[0] != 1) {
                z = false;
            }
            byte[] bArr6 = new byte[2];
            long length4 = length3 - ((long) bArr6.length);
            randomAccessFile.seek(length4);
            randomAccessFile.readFully(bArr6);
            int r12 = m1262(bArr6, 0);
            bArr2 = new byte[r12];
            randomAccessFile.seek(length4 - ((long) r12));
            randomAccessFile.readFully(bArr2);
            if (z && str != null && str.length() > 0) {
                SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8")));
                Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
                instance.init(2, generateSecret, new IvParameterSpec(f997));
                bArr2 = instance.doFinal(bArr2);
            }
        }
        try {
            randomAccessFile.close();
        } catch (IOException unused) {
        }
        return bArr2;
    }

    /* renamed from: ֏ */
    public static short m1262(byte[] bArr, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(bArr[i]);
        allocate.put(bArr[i + 1]);
        return allocate.getShort(0);
    }
}
