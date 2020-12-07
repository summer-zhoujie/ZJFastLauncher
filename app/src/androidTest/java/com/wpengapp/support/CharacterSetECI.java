package com.wpengapp.support;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.ࢦ */
public enum CharacterSetECI {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{"ISO-8859-1"}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_6((String) 8, (int) new String[]{"ISO-8859-6"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_8((String) 10, (int) new String[]{"ISO-8859-8"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_10((String) 12, (int) new String[]{"ISO-8859-10"}),
    ISO8859_11((String) 13, (int) new String[]{"ISO-8859-11"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_14((String) 16, (int) new String[]{"ISO-8859-14"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{"UTF-16BE", "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{"UTF-8"}),
    ASCII((String) new int[]{27, 170}, (int) new String[]{"US-ASCII"}),
    Big5(28),
    GB18030((String) 29, (int) new String[]{"GB2312", "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    

    /* renamed from: ޙ */
    public static final Map<Integer, CharacterSetECI> f2861 = null;

    /* renamed from: ޚ */
    public static final Map<String, CharacterSetECI> f2862 = null;

    /* renamed from: ޜ */
    public final int[] f2864;

    /* renamed from: ޝ */
    public final String[] f2865;

    static {
        f2861 = new HashMap();
        f2862 = new HashMap();
        for (CharacterSetECI r4 : values()) {
            for (int valueOf : r4.f2864) {
                f2861.put(Integer.valueOf(valueOf), r4);
            }
            f2862.put(r4.name(), r4);
            for (String put : r4.f2865) {
                f2862.put(put, r4);
            }
        }
    }

    /* access modifiers changed from: public */
    CharacterSetECI(int i) {
        this.f2864 = new int[]{i};
        this.f2865 = new String[0];
    }

    /* access modifiers changed from: public */
    CharacterSetECI(int i, String... strArr) {
        this.f2864 = new int[]{i};
        this.f2865 = strArr;
    }

    /* access modifiers changed from: public */
    CharacterSetECI(int[] iArr, String... strArr) {
        this.f2864 = iArr;
        this.f2865 = strArr;
    }
}
