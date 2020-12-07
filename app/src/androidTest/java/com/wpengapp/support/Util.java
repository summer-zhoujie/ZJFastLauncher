package com.wpengapp.support;

import android.support.p003v7.widget.RecyclerView;
import com.wpengapp.support.Headers;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.wpengapp.support.Ă */
public final class Util {

    /* renamed from: ֏ */
    public static final byte[] f729 = new byte[0];

    /* renamed from: ؠ */
    public static final String[] f730 = new String[0];

    /* renamed from: ހ */
    public static final C1154 f731 = C1154.m3095((MediaType) null, f729);

    /* renamed from: ށ */
    public static final ByteString f732 = ByteString.m2186("efbbbf");

    /* renamed from: ނ */
    public static final ByteString f733 = ByteString.m2186("feff");

    /* renamed from: ރ */
    public static final ByteString f734 = ByteString.m2186("fffe");

    /* renamed from: ބ */
    public static final ByteString f735 = ByteString.m2186("0000ffff");

    /* renamed from: ޅ */
    public static final ByteString f736 = ByteString.m2186("ffff0000");

    /* renamed from: ކ */
    public static final Charset f737 = Charset.forName("UTF-8");

    /* renamed from: އ */
    public static final Charset f738 = Charset.forName("UTF-16BE");

    /* renamed from: ވ */
    public static final Charset f739 = Charset.forName("UTF-16LE");

    /* renamed from: މ */
    public static final Charset f740 = Charset.forName("UTF-32BE");

    /* renamed from: ފ */
    public static final Charset f741 = Charset.forName("UTF-32LE");

    /* renamed from: ދ */
    public static final TimeZone f742 = TimeZone.getTimeZone("GMT");

    /* renamed from: ތ */
    public static final Comparator<String> f743 = new C1161();

    /* renamed from: ލ */
    public static final Method f744;

    /* renamed from: ގ */
    public static final Pattern f745 = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        Method method = null;
        byte[] bArr = f729;
        m945((long) bArr.length, (long) 0, (long) bArr.length);
        Charset.forName("ISO-8859-1");
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
        }
        f744 = method;
    }

    /* renamed from: ֏ */
    public static int m929(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: ֏ */
    public static void m945(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: ؠ */
    public static boolean m956(Source r11, int i, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long r5 = r11.mo7988().mo9213() ? r11.mo7988().mo9212() - nanoTime : Long.MAX_VALUE;
        r11.mo7988().mo9110(Math.min(r5, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            Buffer r12 = new Buffer();
            while (r11.mo8055(r12, 8192) != -1) {
                r12.mo9201();
            }
            if (r5 == RecyclerView.FOREVER_NS) {
                r11.mo7988().mo9210();
            } else {
                r11.mo7988().mo9110(nanoTime + r5);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (r5 == RecyclerView.FOREVER_NS) {
                r11.mo7988().mo9210();
            } else {
                r11.mo7988().mo9110(nanoTime + r5);
            }
            return false;
        } catch (Throwable th) {
            if (r5 == RecyclerView.FOREVER_NS) {
                r11.mo7988().mo9210();
            } else {
                r11.mo7988().mo9110(nanoTime + r5);
            }
            throw th;
        }
    }

    /* renamed from: ހ */
    public static int m958(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: ށ */
    public static String m960(String str, int i, int i2) {
        int r1 = m954(str, i, i2);
        return str.substring(r1, m958(str, r1, i2));
    }

    /* renamed from: ֏ */
    public static boolean m950(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: ހ */
    public static boolean m959(String str) {
        return f745.matcher(str).matches();
    }

    /* renamed from: ֏ */
    public static void m946(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ֏ */
    public static void m947(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m949(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ֏ */
    public static boolean m948(Source r0, int i, TimeUnit timeUnit) {
        try {
            return m956(r0, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: ֏ */
    public static <T> List<T> m940(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: ֏ */
    public static <K, V> Map<K, V> m942(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* renamed from: ֏ */
    public static <T> List<T> m941(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: ֏ */
    public static ThreadFactory m943(String str, boolean z) {
        return new C0733(str, z);
    }

    /* renamed from: ؠ */
    public static boolean m957(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: ֏ */
    public static String[] m951(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: ؠ */
    public static int m954(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: ؠ */
    public static int m953(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: ֏ */
    public static boolean m949(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: ؠ */
    public static Headers m955(List<Header> list) {
        Headers.C0568 r0 = new Headers.C0568();
        for (Header next : list) {
            Internal.f1914.mo7918(r0, next.f2924.mo8005(), next.f2925.mo8005());
        }
        return new Headers(r0);
    }

    /* renamed from: ֏ */
    public static int m933(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: ֏ */
    public static String[] m952(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    /* renamed from: ֏ */
    public static int m931(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: ֏ */
    public static int m930(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: ֏ */
    public static String m936(String str) {
        InetAddress inetAddress;
        int i = -1;
        boolean z = true;
        int i2 = 0;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = m938(str, 0, str.length());
            } else {
                inetAddress = m938(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                int i3 = 0;
                int i4 = 0;
                while (i3 < address.length) {
                    int i5 = i3;
                    while (i5 < 16 && address[i5] == 0 && address[i5 + 1] == 0) {
                        i5 += 2;
                    }
                    int i6 = i5 - i3;
                    if (i6 > i4 && i6 >= 4) {
                        i = i3;
                        i4 = i6;
                    }
                    i3 = i5 + 2;
                }
                Buffer r8 = new Buffer();
                while (i2 < address.length) {
                    if (i2 == i) {
                        r8.writeByte(58);
                        i2 += i4;
                        if (i2 == 16) {
                            r8.writeByte(58);
                        }
                    } else {
                        if (i2 > 0) {
                            r8.writeByte(58);
                        }
                        r8.mo8113((long) (((address[i2] & 255) << 8) | (address[i2 + 1] & 255)));
                        i2 += 2;
                    }
                }
                return r8.mo9203();
            }
            throw new AssertionError(outline.m2545("Invalid IPv6 address: '", str, "'"));
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            int i7 = 0;
            while (true) {
                if (i7 >= lowerCase.length()) {
                    z = false;
                    break;
                }
                char charAt = lowerCase.charAt(i7);
                if (charAt <= 31) {
                    break;
                } else if (charAt >= 127) {
                    break;
                } else if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                    break;
                } else {
                    i7++;
                }
            }
            if (z) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: ֏ */
    public static String m937(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: ֏ */
    public static Charset m939(BufferedSource r3, Charset charset) {
        if (r3.mo8489(0, f732)) {
            r3.skip((long) f732.mo8002());
            return f737;
        } else if (r3.mo8489(0, f733)) {
            r3.skip((long) f733.mo8002());
            return f738;
        } else if (r3.mo8489(0, f734)) {
            r3.skip((long) f734.mo8002());
            return f739;
        } else if (r3.mo8489(0, f735)) {
            r3.skip((long) f735.mo8002());
            return f740;
        } else if (!r3.mo8489(0, f736)) {
            return charset;
        } else {
            r3.skip((long) f736.mo8002());
            return f741;
        }
    }

    /* renamed from: ֏ */
    public static String m935(HttpUrl r4, boolean z) {
        String str;
        if (r4.f3310.contains(":")) {
            str = outline.m2548(outline.m2549("["), r4.f3310, "]");
        } else {
            str = r4.f3310;
        }
        if (!z && r4.f3311 == HttpUrl.m3115(r4.f3307)) {
            return str;
        }
        StringBuilder r5 = outline.m2550(str, ":");
        r5.append(r4.f3311);
        return r5.toString();
    }

    /* renamed from: ֏ */
    public static int m932(String str, long j, TimeUnit timeUnit) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(outline.m2556(str, " < 0"));
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(outline.m2556(str, " too large."));
            } else if (millis != 0 || i <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(outline.m2556(str, " too small."));
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    /* renamed from: ֏ */
    public static AssertionError m934(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0097, code lost:
        r4 = 0;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static InetAddress m938(String r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r18
            r2 = 16
            byte[] r2 = new byte[r2]
            r3 = -1
            r4 = 0
            r5 = r17
            r6 = 0
            r7 = -1
            r8 = -1
        L_0x000f:
            r9 = 0
            if (r5 >= r1) goto L_0x00d3
            int r10 = r2.length
            if (r6 != r10) goto L_0x0016
            return r9
        L_0x0016:
            int r10 = r5 + 2
            r11 = 255(0xff, float:3.57E-43)
            r12 = 4
            if (r10 > r1) goto L_0x0034
            r13 = 2
            java.lang.String r14 = "::"
            boolean r13 = r0.regionMatches(r5, r14, r4, r13)
            if (r13 == 0) goto L_0x0034
            if (r7 == r3) goto L_0x0029
            return r9
        L_0x0029:
            int r6 = r6 + 2
            if (r10 != r1) goto L_0x0030
            r7 = r6
            goto L_0x00d3
        L_0x0030:
            r7 = r6
            r8 = r10
            goto L_0x00a2
        L_0x0034:
            if (r6 == 0) goto L_0x00a1
            r10 = 1
            java.lang.String r13 = ":"
            boolean r13 = r0.regionMatches(r5, r13, r4, r10)
            if (r13 == 0) goto L_0x0043
            int r5 = r5 + 1
            goto L_0x00a1
        L_0x0043:
            java.lang.String r13 = "."
            boolean r5 = r0.regionMatches(r5, r13, r4, r10)
            if (r5 == 0) goto L_0x00a0
            int r5 = r6 + -2
            r13 = r5
        L_0x004e:
            if (r8 >= r1) goto L_0x0094
            int r14 = r2.length
            if (r13 != r14) goto L_0x0054
            goto L_0x009a
        L_0x0054:
            if (r13 == r5) goto L_0x0061
            char r14 = r0.charAt(r8)
            r15 = 46
            if (r14 == r15) goto L_0x005f
            goto L_0x009a
        L_0x005f:
            int r8 = r8 + 1
        L_0x0061:
            r14 = r8
            r15 = 0
        L_0x0063:
            if (r14 >= r1) goto L_0x0084
            char r10 = r0.charAt(r14)
            r4 = 48
            if (r10 < r4) goto L_0x0084
            r3 = 57
            if (r10 <= r3) goto L_0x0072
            goto L_0x0084
        L_0x0072:
            if (r15 != 0) goto L_0x0077
            if (r8 == r14) goto L_0x0077
            goto L_0x0097
        L_0x0077:
            int r15 = r15 * 10
            int r15 = r15 + r10
            int r15 = r15 - r4
            if (r15 <= r11) goto L_0x007e
            goto L_0x0097
        L_0x007e:
            int r14 = r14 + 1
            r3 = -1
            r4 = 0
            r10 = 1
            goto L_0x0063
        L_0x0084:
            int r3 = r14 - r8
            if (r3 != 0) goto L_0x0089
            goto L_0x0097
        L_0x0089:
            int r3 = r13 + 1
            byte r4 = (byte) r15
            r2[r13] = r4
            r13 = r3
            r8 = r14
            r3 = -1
            r4 = 0
            r10 = 1
            goto L_0x004e
        L_0x0094:
            int r5 = r5 + r12
            if (r13 == r5) goto L_0x0099
        L_0x0097:
            r4 = 0
            goto L_0x009a
        L_0x0099:
            r4 = 1
        L_0x009a:
            if (r4 != 0) goto L_0x009d
            return r9
        L_0x009d:
            int r6 = r6 + 2
            goto L_0x00d3
        L_0x00a0:
            return r9
        L_0x00a1:
            r8 = r5
        L_0x00a2:
            r5 = r8
            r3 = 0
        L_0x00a4:
            if (r5 >= r1) goto L_0x00b8
            char r4 = r0.charAt(r5)
            int r4 = m929((char) r4)
            r10 = -1
            if (r4 != r10) goto L_0x00b2
            goto L_0x00b8
        L_0x00b2:
            int r3 = r3 << 4
            int r3 = r3 + r4
            int r5 = r5 + 1
            goto L_0x00a4
        L_0x00b8:
            int r4 = r5 - r8
            if (r4 == 0) goto L_0x00d2
            if (r4 <= r12) goto L_0x00bf
            goto L_0x00d2
        L_0x00bf:
            int r4 = r6 + 1
            int r9 = r3 >>> 8
            r9 = r9 & r11
            byte r9 = (byte) r9
            r2[r6] = r9
            int r6 = r4 + 1
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            r2[r4] = r3
            r3 = -1
            r4 = 0
            goto L_0x000f
        L_0x00d2:
            return r9
        L_0x00d3:
            int r0 = r2.length
            if (r6 == r0) goto L_0x00e8
            r0 = -1
            if (r7 != r0) goto L_0x00da
            return r9
        L_0x00da:
            int r0 = r2.length
            int r1 = r6 - r7
            int r0 = r0 - r1
            java.lang.System.arraycopy(r2, r7, r2, r0, r1)
            int r0 = r2.length
            int r0 = r0 - r6
            int r0 = r0 + r7
            r1 = 0
            java.util.Arrays.fill(r2, r7, r0, r1)
        L_0x00e8:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r2)     // Catch:{ UnknownHostException -> 0x00ed }
            return r0
        L_0x00ed:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Util.m938(java.lang.String, int, int):java.net.InetAddress");
    }

    /* renamed from: ֏ */
    public static X509TrustManager m944() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw m934("No System TLS", (Exception) e);
        }
    }
}
