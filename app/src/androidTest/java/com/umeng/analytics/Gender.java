package com.umeng.analytics;

import java.util.Locale;

public enum Gender {
    Male(1) {
        public String toString() {
            return String.format(Locale.US, "Male:%d", new Object[]{Integer.valueOf(this.value)});
        }
    },
    Female(2) {
        public String toString() {
            return String.format(Locale.US, "Female:%d", new Object[]{Integer.valueOf(this.value)});
        }
    },
    Unknown(0) {
        public String toString() {
            return String.format(Locale.US, "Unknown:%d", new Object[]{Integer.valueOf(this.value)});
        }
    };
    
    public int value;

    /* renamed from: com.umeng.analytics.Gender$4 */
    static /* synthetic */ class C03774 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f68a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.umeng.analytics.Gender[] r0 = com.umeng.analytics.Gender.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f68a = r0
                int[] r0 = f68a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.umeng.analytics.Gender r1 = com.umeng.analytics.Gender.Male     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f68a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.umeng.analytics.Gender r1 = com.umeng.analytics.Gender.Female     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f68a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.umeng.analytics.Gender r1 = com.umeng.analytics.Gender.Unknown     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.Gender.C03774.<clinit>():void");
        }
    }

    /* access modifiers changed from: public */
    Gender(int i) {
        this.value = i;
    }

    public static Gender getGender(int i) {
        if (i == 1) {
            return Male;
        }
        if (i != 2) {
            return Unknown;
        }
        return Female;
    }

    public static com.wpengapp.support.Gender transGender(Gender gender) {
        int i = C03774.f68a[gender.ordinal()];
        if (i == 1) {
            return com.wpengapp.support.Gender.MALE;
        }
        if (i != 2) {
            return com.wpengapp.support.Gender.UNKNOWN;
        }
        return com.wpengapp.support.Gender.FEMALE;
    }

    public int value() {
        return this.value;
    }
}
