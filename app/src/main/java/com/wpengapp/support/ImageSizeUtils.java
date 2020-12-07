package com.wpengapp.support;

import android.opengl.GLES10;

/* renamed from: com.wpengapp.support.Ι */
public final class ImageSizeUtils {

    /* renamed from: ֏ */
    public static ImageSize f1633;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        f1633 = new ImageSize(max, max);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005c A[SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m1639(ImageSize r6, ImageSize r7, ViewScaleType r8, boolean r9) {
        /*
            int r0 = r6.f2221
            int r6 = r6.f2222
            int r1 = r7.f2221
            int r7 = r7.f2222
            int r8 = r8.ordinal()
            r2 = 1
            if (r8 == 0) goto L_0x0030
            if (r8 == r2) goto L_0x0013
            r7 = 1
            goto L_0x004a
        L_0x0013:
            if (r9 == 0) goto L_0x0027
            int r8 = r0 / 2
            int r3 = r6 / 2
            r4 = 1
        L_0x001a:
            int r5 = r8 / r4
            if (r5 <= r1) goto L_0x0025
            int r5 = r3 / r4
            if (r5 <= r7) goto L_0x0025
            int r4 = r4 * 2
            goto L_0x001a
        L_0x0025:
            r7 = r4
            goto L_0x004a
        L_0x0027:
            int r8 = r0 / r1
            int r7 = r6 / r7
            int r7 = java.lang.Math.min(r8, r7)
            goto L_0x004a
        L_0x0030:
            if (r9 == 0) goto L_0x0042
            int r8 = r0 / 2
            int r3 = r6 / 2
            r4 = 1
        L_0x0037:
            int r5 = r8 / r4
            if (r5 > r1) goto L_0x003f
            int r5 = r3 / r4
            if (r5 <= r7) goto L_0x0025
        L_0x003f:
            int r4 = r4 * 2
            goto L_0x0037
        L_0x0042:
            int r8 = r0 / r1
            int r7 = r6 / r7
            int r7 = java.lang.Math.max(r8, r7)
        L_0x004a:
            if (r7 >= r2) goto L_0x004d
            r7 = 1
        L_0x004d:
            com.wpengapp.support.ا r8 = f1633
            int r1 = r8.f2221
            int r8 = r8.f2222
        L_0x0053:
            int r2 = r0 / r7
            if (r2 > r1) goto L_0x005d
            int r2 = r6 / r7
            if (r2 <= r8) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            return r7
        L_0x005d:
            if (r9 == 0) goto L_0x0062
            int r7 = r7 * 2
            goto L_0x0053
        L_0x0062:
            int r7 = r7 + 1
            goto L_0x0053
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.ImageSizeUtils.m1639(com.wpengapp.support.ا, com.wpengapp.support.ا, com.wpengapp.support.ݳ, boolean):int");
    }

    /* renamed from: ؠ */
    public static float m1641(ImageSize r7, ImageSize r8, ViewScaleType r9, boolean z) {
        int i = r7.f2221;
        int i2 = r7.f2222;
        int i3 = r8.f2221;
        int i4 = r8.f2222;
        float f = (float) i;
        float f2 = f / ((float) i3);
        float f3 = (float) i2;
        float f4 = f3 / ((float) i4);
        if ((r9 != ViewScaleType.FIT_INSIDE || f2 < f4) && (r9 != ViewScaleType.CROP || f2 >= f4)) {
            i3 = (int) (f / f4);
        } else {
            i4 = (int) (f3 / f2);
        }
        if ((z || i3 >= i || i4 >= i2) && (!z || i3 == i || i4 == i2)) {
            return 1.0f;
        }
        return ((float) i3) / f;
    }

    /* renamed from: ֏ */
    public static int m1638(ImageSize r4) {
        int i = r4.f2221;
        int i2 = r4.f2222;
        ImageSize r1 = f1633;
        return Math.max((int) Math.ceil((double) (((float) i) / ((float) r1.f2221))), (int) Math.ceil((double) (((float) i2) / ((float) r1.f2222))));
    }

    /* renamed from: ֏ */
    public static ImageSize m1640(ImageAware r1, ImageSize r2) {
        int r0 = r1.mo7955();
        if (r0 <= 0) {
            r0 = r2.f2221;
        }
        int height = r1.getHeight();
        if (height <= 0) {
            height = r2.f2222;
        }
        return new ImageSize(r0, height);
    }
}
