package com.wpengapp.support;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* renamed from: com.wpengapp.support.ק */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final long serialVersionUID = 1;

    /* renamed from: ֏ */
    public static final char[] f2162 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: ؠ */
    public static final ByteString f2163 = m2187(new byte[0]);

    /* renamed from: ހ */
    public final byte[] f2164;

    /* renamed from: ށ */
    public transient int f2165;

    /* renamed from: ނ */
    public transient String f2166;

    public ByteString(byte[] bArr) {
        this.f2164 = bArr;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            byte[] bArr = new byte[readInt];
            int i = 0;
            while (i < readInt) {
                int read = objectInputStream.read(bArr, i, readInt - i);
                if (read != -1) {
                    i += read;
                } else {
                    throw new EOFException();
                }
            }
            ByteString r6 = new ByteString(bArr);
            try {
                Field declaredField = ByteString.class.getDeclaredField("ހ");
                declaredField.setAccessible(true);
                declaredField.set(this, r6.f2164);
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        } else {
            throw new IllegalArgumentException(outline.m2543("byteCount < 0: ", readInt));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.f2164.length);
        objectOutputStream.write(this.f2164);
    }

    /* renamed from: ֏ */
    public static ByteString m2187(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: ހ */
    public static ByteString m2188(String str) {
        if (str != null) {
            ByteString r0 = new ByteString(str.getBytes(C0751.f1936));
            r0.f2166 = str;
            return r0;
        }
        throw new IllegalArgumentException("s == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString r6 = (ByteString) obj;
            int r1 = r6.mo8002();
            byte[] bArr = this.f2164;
            if (r1 != bArr.length || !r6.mo7997(0, bArr, 0, bArr.length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f2165;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f2164);
        this.f2165 = hashCode;
        return hashCode;
    }

    public String toString() {
        if (this.f2164.length == 0) {
            return "[size=0]";
        }
        String r0 = mo8005();
        int length = r0.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = r0.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = r0.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        if (i != -1) {
            String replace = r0.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (i >= r0.length()) {
                return outline.m2545("[text=", replace, "]");
            }
            StringBuilder r02 = outline.m2549("[size=");
            r02.append(this.f2164.length);
            r02.append(" text=");
            r02.append(replace);
            r02.append("…]");
            return r02.toString();
        } else if (this.f2164.length <= 64) {
            StringBuilder r03 = outline.m2549("[hex=");
            r03.append(mo7999());
            r03.append("]");
            return r03.toString();
        } else {
            StringBuilder r04 = outline.m2549("[size=");
            r04.append(this.f2164.length);
            r04.append(" hex=");
            r04.append(mo7993(0, 64).mo7999());
            r04.append("…]");
            return r04.toString();
        }
    }

    /* renamed from: ؠ */
    public final ByteString mo8723(String str) {
        try {
            return m2187(MessageDigest.getInstance(str).digest(this.f2164));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: ށ */
    public ByteString mo8001() {
        return mo8723("SHA-256");
    }

    /* renamed from: ނ */
    public int mo8002() {
        return this.f2164.length;
    }

    /* renamed from: ރ */
    public ByteString mo8003() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f2164;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
        }
    }

    /* renamed from: ބ */
    public byte[] mo8004() {
        return (byte[]) this.f2164.clone();
    }

    /* renamed from: ޅ */
    public String mo8005() {
        String str = this.f2166;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f2164, C0751.f1936);
        this.f2166 = str2;
        return str2;
    }

    /* renamed from: ֏ */
    public String mo7994() {
        byte[] bArr = this.f2164;
        byte[] bArr2 = Base64.f3473;
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
            int i6 = i4 + 1;
            int i7 = i2 + 2;
            bArr3[i4] = bArr2[((bArr[i5] & 15) << 2) | ((bArr[i7] & 255) >> 6)];
            i = i6 + 1;
            bArr3[i6] = bArr2[bArr[i7] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i8 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i9] = 61;
            bArr3[i9 + 1] = 61;
        } else if (length2 == 2) {
            int i10 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i11 = i10 + 1;
            int i12 = length + 1;
            bArr3[i10] = bArr2[((bArr[i12] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i11] = bArr2[(bArr[i12] & 15) << 2];
            bArr3[i11 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: ؠ */
    public String mo7999() {
        byte[] bArr = this.f2164;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f2162;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: ހ */
    public ByteString mo8000() {
        return mo8723("SHA-1");
    }

    /* renamed from: ؠ */
    public final boolean mo8724(ByteString r3) {
        return mo7996(0, r3, 0, r3.mo8002());
    }

    /* renamed from: ֏ */
    public static ByteString m2186(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (m2185(str.charAt(i2 + 1)) + (m2185(str.charAt(i2)) << 4));
            }
            return m2187(bArr);
        } else {
            throw new IllegalArgumentException(outline.m2556("Unexpected hex string: ", str));
        }
    }

    /* renamed from: ֏ */
    public static int m2185(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: ֏ */
    public ByteString mo7993(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f2164;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.f2164, i, bArr2, 0, i3);
                    return new ByteString(bArr2);
                }
            } else {
                StringBuilder r5 = outline.m2549("endIndex > length(");
                r5.append(this.f2164.length);
                r5.append(")");
                throw new IllegalArgumentException(r5.toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    /* renamed from: ֏ */
    public byte mo7992(int i) {
        return this.f2164[i];
    }

    /* renamed from: ֏ */
    public void mo7995(Buffer r4) {
        byte[] bArr = this.f2164;
        r4.mo9198(bArr, 0, bArr.length);
    }

    /* renamed from: ֏ */
    public boolean mo7996(int i, ByteString r3, int i2, int i3) {
        return r3.mo7997(i2, this.f2164, i, i3);
    }

    /* renamed from: ֏ */
    public boolean mo7997(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f2164;
            return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C0751.m1968(bArr2, i, bArr, i2, i3);
        }
    }

    /* renamed from: ֏ */
    public int compareTo(ByteString r10) {
        int r0 = mo8002();
        int r1 = r10.mo8002();
        int min = Math.min(r0, r1);
        int i = 0;
        while (i < min) {
            byte r7 = mo7992(i) & 255;
            byte r8 = r10.mo7992(i) & 255;
            if (r7 == r8) {
                i++;
            } else if (r7 < r8) {
                return -1;
            } else {
                return 1;
            }
        }
        if (r0 == r1) {
            return 0;
        }
        if (r0 < r1) {
            return -1;
        }
        return 1;
    }
}
