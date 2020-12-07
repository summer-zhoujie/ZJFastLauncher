package com.wpengapp.support;

import android.text.TextUtils;

/* renamed from: com.wpengapp.support.ਤ */
/* compiled from: UMCCAggregatedRestrictionManager */
public class C1086 {

    /* renamed from: com.wpengapp.support.ਤ$֏ */
    /* compiled from: UMCCAggregatedRestrictionManager */
    private static class C1087 {

        /* renamed from: ֏ */
        public static final C1086 f3084 = new C1086((UMCCAggregatedRestrictionManager) null);
    }

    public /* synthetic */ C1086(UMCCAggregatedRestrictionManager r1) {
    }

    /* renamed from: ֏ */
    public int mo9261() {
        return 8;
    }

    /* renamed from: ֏ */
    public boolean mo9262(String str) {
        if (!TextUtils.isEmpty(str) && str.length() < 16 && mo9263(str, 48)) {
            return true;
        }
        return false;
    }

    /* renamed from: ؠ */
    public int mo9264() {
        return 128;
    }

    /* renamed from: ހ */
    public int mo9265() {
        return 512;
    }

    /* renamed from: ֏ */
    public final boolean mo9263(String str, int i) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) < i) {
                return false;
            }
        }
        return true;
    }
}
