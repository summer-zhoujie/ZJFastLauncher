package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.ActivityChooserView;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ઢ */
public final class CacheControl {

    /* renamed from: ֏ */
    public final boolean f3139;

    /* renamed from: ؠ */
    public final boolean f3140;

    /* renamed from: ހ */
    public final int f3141;

    /* renamed from: ށ */
    public final int f3142;

    /* renamed from: ނ */
    public final boolean f3143;

    /* renamed from: ރ */
    public final boolean f3144;

    /* renamed from: ބ */
    public final boolean f3145;

    /* renamed from: ޅ */
    public final int f3146;

    /* renamed from: ކ */
    public final int f3147;

    /* renamed from: އ */
    public final boolean f3148;

    /* renamed from: ވ */
    public final boolean f3149;

    /* renamed from: މ */
    public final boolean f3150;

    /* renamed from: ފ */
    public String f3151;

    /* renamed from: com.wpengapp.support.ઢ$֏ */
    /* compiled from: CacheControl */
    public static final class C1106 {

        /* renamed from: ֏ */
        public boolean f3152;

        /* renamed from: ؠ */
        public boolean f3153;

        /* renamed from: ހ */
        public int f3154 = -1;

        /* renamed from: ށ */
        public int f3155 = -1;

        /* renamed from: ނ */
        public int f3156 = -1;

        /* renamed from: ރ */
        public boolean f3157;

        /* renamed from: ބ */
        public boolean f3158;

        /* renamed from: ޅ */
        public boolean f3159;
    }

    static {
        C1106 r0 = new C1106();
        r0.f3152 = true;
        new CacheControl(r0);
        C1106 r02 = new C1106();
        r02.f3157 = true;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        long seconds = timeUnit.toSeconds((long) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        if (seconds <= 2147483647L) {
            i = (int) seconds;
        }
        r02.f3155 = i;
        new CacheControl(r02);
    }

    public CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f3139 = z;
        this.f3140 = z2;
        this.f3141 = i;
        this.f3142 = i2;
        this.f3143 = z3;
        this.f3144 = z4;
        this.f3145 = z5;
        this.f3146 = i3;
        this.f3147 = i4;
        this.f3148 = z6;
        this.f3149 = z7;
        this.f3150 = z8;
        this.f3151 = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static CacheControl m2987(Headers r22) {
        /*
            r0 = r22
            int r1 = r22.mo8176()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x0146
            java.lang.String r2 = r0.mo8175((int) r6)
            java.lang.String r4 = r0.mo8177((int) r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0031
            if (r8 == 0) goto L_0x002f
            goto L_0x0039
        L_0x002f:
            r8 = r4
            goto L_0x003a
        L_0x0031:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x013f
        L_0x0039:
            r7 = 0
        L_0x003a:
            r2 = 0
        L_0x003b:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x013f
            java.lang.String r3 = "=,;"
            int r3 = com.wpengapp.support.HttpHeaders.m1354((java.lang.String) r4, (int) r2, (java.lang.String) r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0099
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x0099
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0066
            goto L_0x0099
        L_0x0066:
            int r3 = r3 + 1
            int r0 = com.wpengapp.support.HttpHeaders.m1357(r4, r3)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x0089
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x0089
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = com.wpengapp.support.HttpHeaders.m1354((java.lang.String) r4, (int) r0, (java.lang.String) r3)
            java.lang.String r0 = r4.substring(r0, r3)
            r5 = 1
            int r3 = r3 + r5
            goto L_0x009d
        L_0x0089:
            r5 = 1
            java.lang.String r3 = ",;"
            int r3 = com.wpengapp.support.HttpHeaders.m1354((java.lang.String) r4, (int) r0, (java.lang.String) r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009d
        L_0x0099:
            r5 = 1
            int r3 = r3 + 1
            r0 = 0
        L_0x009d:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00a9
            r5 = -1
            r9 = 1
            goto L_0x013a
        L_0x00a9:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b5
            r5 = -1
            r10 = 1
            goto L_0x013a
        L_0x00b5:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c5
            r5 = -1
            int r0 = com.wpengapp.support.HttpHeaders.m1353(r0, r5)
            r11 = r0
            goto L_0x013a
        L_0x00c5:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d5
            r5 = -1
            int r0 = com.wpengapp.support.HttpHeaders.m1353(r0, r5)
            r12 = r0
            goto L_0x013a
        L_0x00d5:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e0
            r5 = -1
            r13 = 1
            goto L_0x013a
        L_0x00e0:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00eb
            r5 = -1
            r14 = 1
            goto L_0x013a
        L_0x00eb:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f6
            r5 = -1
            r15 = 1
            goto L_0x013a
        L_0x00f6:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0109
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r0 = com.wpengapp.support.HttpHeaders.m1353(r0, r2)
            r16 = r0
            r5 = -1
            goto L_0x013a
        L_0x0109:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0119
            r5 = -1
            int r0 = com.wpengapp.support.HttpHeaders.m1353(r0, r5)
            r17 = r0
            goto L_0x013a
        L_0x0119:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0125
            r18 = 1
            goto L_0x013a
        L_0x0125:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0130
            r19 = 1
            goto L_0x013a
        L_0x0130:
            java.lang.String r0 = "immutable"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x013a
            r20 = 1
        L_0x013a:
            r0 = r22
            r2 = r3
            goto L_0x003b
        L_0x013f:
            r5 = -1
            int r6 = r6 + 1
            r0 = r22
            goto L_0x001a
        L_0x0146:
            if (r7 != 0) goto L_0x014b
            r21 = 0
            goto L_0x014d
        L_0x014b:
            r21 = r8
        L_0x014d:
            com.wpengapp.support.ઢ r0 = new com.wpengapp.support.ઢ
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.CacheControl.m2987(com.wpengapp.support.Ʌ):com.wpengapp.support.ઢ");
    }

    public String toString() {
        String str = this.f3151;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f3139) {
                sb.append("no-cache, ");
            }
            if (this.f3140) {
                sb.append("no-store, ");
            }
            if (this.f3141 != -1) {
                sb.append("max-age=");
                sb.append(this.f3141);
                sb.append(", ");
            }
            if (this.f3142 != -1) {
                sb.append("s-maxage=");
                sb.append(this.f3142);
                sb.append(", ");
            }
            if (this.f3143) {
                sb.append("private, ");
            }
            if (this.f3144) {
                sb.append("public, ");
            }
            if (this.f3145) {
                sb.append("must-revalidate, ");
            }
            if (this.f3146 != -1) {
                sb.append("max-stale=");
                sb.append(this.f3146);
                sb.append(", ");
            }
            if (this.f3147 != -1) {
                sb.append("min-fresh=");
                sb.append(this.f3147);
                sb.append(", ");
            }
            if (this.f3148) {
                sb.append("only-if-cached, ");
            }
            if (this.f3149) {
                sb.append("no-transform, ");
            }
            if (this.f3150) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                str = BidiFormatter.EMPTY_STRING;
            } else {
                sb.delete(sb.length() - 2, sb.length());
                str = sb.toString();
            }
            this.f3151 = str;
        }
        return str;
    }

    public CacheControl(C1106 r2) {
        this.f3139 = r2.f3152;
        this.f3140 = r2.f3153;
        this.f3141 = r2.f3154;
        this.f3142 = -1;
        this.f3143 = false;
        this.f3144 = false;
        this.f3145 = false;
        this.f3146 = r2.f3155;
        this.f3147 = r2.f3156;
        this.f3148 = r2.f3157;
        this.f3149 = r2.f3158;
        this.f3150 = r2.f3159;
    }
}
