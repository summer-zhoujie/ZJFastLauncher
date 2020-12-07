package com.wpengapp.support;

import android.graphics.BitmapFactory;
import java.io.InputStream;

/* renamed from: com.wpengapp.support.ٲ */
public class BaseImageDecoder implements ImageDecoder {

    /* renamed from: ֏ */
    public final boolean f2343;

    /* renamed from: com.wpengapp.support.ٲ$ؠ */
    /* compiled from: BaseImageDecoder */
    protected static class C0865 {

        /* renamed from: ֏ */
        public final ImageSize f2346;

        /* renamed from: ؠ */
        public final C0864 f2347;

        public C0865(ImageSize r1, C0864 r2) {
            this.f2346 = r1;
            this.f2347 = r2;
        }
    }

    public BaseImageDecoder(boolean z) {
        this.f2343 = z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|(2:7|8)|9|10|11|12|13|(2:15|16)|(2:19|51)(6:20|(4:24|(1:26)(1:27)|28|(2:30|(1:32)))|(2:34|(1:36))|(2:38|(1:40))|41|(2:43|50)(1:52))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0023 */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap mo8814(com.wpengapp.support.ImageDecodingInfo r14) {
        /*
            r13 = this;
            java.io.InputStream r0 = r13.mo8817(r14)
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x0015
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r14 = r14.f1525
            r0[r2] = r14
            java.lang.String r14 = "No stream for image [%s]"
            com.wpengapp.support.L.m2161(r14, r0)
            return r3
        L_0x0015:
            com.wpengapp.support.ٲ$ؠ r4 = r13.mo8816((java.io.InputStream) r0, (com.wpengapp.support.ImageDecodingInfo) r14)     // Catch:{ all -> 0x00fb }
            boolean r5 = r0.markSupported()     // Catch:{ all -> 0x00fb }
            if (r5 == 0) goto L_0x0023
            r0.reset()     // Catch:{ IOException -> 0x0023 }
            goto L_0x002a
        L_0x0023:
            r0.close()     // Catch:{ Exception -> 0x0026 }
        L_0x0026:
            java.io.InputStream r0 = r13.mo8817(r14)     // Catch:{ all -> 0x00fb }
        L_0x002a:
            com.wpengapp.support.ا r5 = r4.f2346     // Catch:{ all -> 0x00fb }
            android.graphics.BitmapFactory$Options r5 = r13.mo8815((com.wpengapp.support.ImageSize) r5, (com.wpengapp.support.ImageDecodingInfo) r14)     // Catch:{ all -> 0x00fb }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r0, r3, r5)     // Catch:{ all -> 0x00fb }
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ Exception -> 0x003a }
            goto L_0x003b
        L_0x003a:
        L_0x003b:
            if (r3 != 0) goto L_0x004b
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r14 = r14.f1525
            r0[r2] = r14
            java.lang.String r14 = "Image can't be decoded [%s]"
            com.wpengapp.support.L.m2161(r14, r0)
            r14 = r3
            goto L_0x00fa
        L_0x004b:
            com.wpengapp.support.ٲ$֏ r0 = r4.f2347
            int r4 = r0.f2344
            boolean r0 = r0.f2345
            android.graphics.Matrix r11 = new android.graphics.Matrix
            r11.<init>()
            com.wpengapp.support.ˏ r5 = r14.f1528
            com.wpengapp.support.ˏ r6 = com.wpengapp.support.ImageScaleType.EXACTLY
            r7 = 2
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r5 == r6) goto L_0x0063
            com.wpengapp.support.ˏ r6 = com.wpengapp.support.ImageScaleType.EXACTLY_STRETCHED
            if (r5 != r6) goto L_0x00b4
        L_0x0063:
            com.wpengapp.support.ا r6 = new com.wpengapp.support.ا
            int r9 = r3.getWidth()
            int r10 = r3.getHeight()
            r6.<init>(r9, r10, r4)
            com.wpengapp.support.ا r9 = r14.f1527
            com.wpengapp.support.ݳ r10 = r14.f1529
            com.wpengapp.support.ˏ r12 = com.wpengapp.support.ImageScaleType.EXACTLY_STRETCHED
            if (r5 != r12) goto L_0x007a
            r5 = 1
            goto L_0x007b
        L_0x007a:
            r5 = 0
        L_0x007b:
            float r5 = com.wpengapp.support.ImageSizeUtils.m1641(r6, r9, r10, r5)
            int r9 = java.lang.Float.compare(r5, r8)
            if (r9 == 0) goto L_0x00b4
            r11.setScale(r5, r5)
            boolean r9 = r13.f2343
            if (r9 == 0) goto L_0x00b4
            r9 = 4
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r9[r2] = r6
            com.wpengapp.support.ا r10 = new com.wpengapp.support.ا
            int r12 = r6.f2221
            float r12 = (float) r12
            float r12 = r12 * r5
            int r12 = (int) r12
            int r6 = r6.f2222
            float r6 = (float) r6
            float r6 = r6 * r5
            int r6 = (int) r6
            r10.<init>(r12, r6)
            r9[r1] = r10
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r9[r7] = r5
            r5 = 3
            java.lang.String r6 = r14.f1525
            r9[r5] = r6
            java.lang.String r5 = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]"
            com.wpengapp.support.L.m2159(r5, r9)
        L_0x00b4:
            if (r0 == 0) goto L_0x00ca
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11.postScale(r0, r8)
            boolean r0 = r13.f2343
            if (r0 == 0) goto L_0x00ca
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r5 = r14.f1525
            r0[r2] = r5
            java.lang.String r5 = "Flip image horizontally [%s]"
            com.wpengapp.support.L.m2159(r5, r0)
        L_0x00ca:
            if (r4 == 0) goto L_0x00e5
            float r0 = (float) r4
            r11.postRotate(r0)
            boolean r0 = r13.f2343
            if (r0 == 0) goto L_0x00e5
            java.lang.Object[] r0 = new java.lang.Object[r7]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0[r2] = r4
            java.lang.String r14 = r14.f1525
            r0[r1] = r14
            java.lang.String r14 = "Rotate image on %1$d° [%2$s]"
            com.wpengapp.support.L.m2159(r14, r0)
        L_0x00e5:
            r7 = 0
            r8 = 0
            int r9 = r3.getWidth()
            int r10 = r3.getHeight()
            r12 = 1
            r6 = r3
            android.graphics.Bitmap r14 = android.graphics.Bitmap.createBitmap(r6, r7, r8, r9, r10, r11, r12)
            if (r14 == r3) goto L_0x00fa
            r3.recycle()
        L_0x00fa:
            return r14
        L_0x00fb:
            r14 = move-exception
            if (r0 == 0) goto L_0x0101
            r0.close()     // Catch:{ Exception -> 0x0101 }
        L_0x0101:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.BaseImageDecoder.mo8814(com.wpengapp.support.ˌ):android.graphics.Bitmap");
    }

    /* renamed from: ؠ */
    public InputStream mo8817(ImageDecodingInfo r3) {
        return r3.f1530.mo8094(r3.f1526, r3.f1531);
    }

    /* renamed from: com.wpengapp.support.ٲ$֏ */
    /* compiled from: BaseImageDecoder */
    protected static class C0864 {

        /* renamed from: ֏ */
        public final int f2344;

        /* renamed from: ؠ */
        public final boolean f2345;

        public C0864() {
            this.f2344 = 0;
            this.f2345 = false;
        }

        public C0864(int i, boolean z) {
            this.f2344 = i;
            this.f2345 = z;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r2 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        r2 = 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        r2 = 180;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0865 mo8816(InputStream r5, com.wpengapp.support.ImageDecodingInfo r6) {
        /*
            r4 = this;
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            r2 = 0
            android.graphics.BitmapFactory.decodeStream(r5, r2, r0)
            java.lang.String r5 = r6.f1526
            boolean r6 = r6.f1532
            if (r6 == 0) goto L_0x005c
            java.lang.String r6 = r0.outMimeType
            java.lang.String r2 = "image/jpeg"
            boolean r6 = r2.equalsIgnoreCase(r6)
            r2 = 0
            if (r6 == 0) goto L_0x0027
            com.wpengapp.support.ۦ$֏ r6 = com.wpengapp.support.ImageDownloader.C0912.m2393(r5)
            com.wpengapp.support.ۦ$֏ r3 = com.wpengapp.support.ImageDownloader.C0912.FILE
            if (r6 != r3) goto L_0x0027
            r6 = 1
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            if (r6 == 0) goto L_0x005c
            android.media.ExifInterface r6 = new android.media.ExifInterface     // Catch:{ IOException -> 0x004c }
            com.wpengapp.support.ۦ$֏ r3 = com.wpengapp.support.ImageDownloader.C0912.FILE     // Catch:{ IOException -> 0x004c }
            java.lang.String r3 = r3.mo8892(r5)     // Catch:{ IOException -> 0x004c }
            r6.<init>(r3)     // Catch:{ IOException -> 0x004c }
            java.lang.String r3 = "Orientation"
            int r5 = r6.getAttributeInt(r3, r1)     // Catch:{ IOException -> 0x004c }
            switch(r5) {
                case 1: goto L_0x0055;
                case 2: goto L_0x0056;
                case 3: goto L_0x0048;
                case 4: goto L_0x0049;
                case 5: goto L_0x0045;
                case 6: goto L_0x0041;
                case 7: goto L_0x0042;
                case 8: goto L_0x003f;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x0055
        L_0x003f:
            r1 = 0
            goto L_0x0045
        L_0x0041:
            r1 = 0
        L_0x0042:
            r2 = 90
            goto L_0x0056
        L_0x0045:
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x0056
        L_0x0048:
            r1 = 0
        L_0x0049:
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x0056
        L_0x004c:
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r2] = r5
            java.lang.String r5 = "Can't read EXIF tags from file [%s]"
            com.wpengapp.support.L.m2162(r5, r6)
        L_0x0055:
            r1 = 0
        L_0x0056:
            com.wpengapp.support.ٲ$֏ r5 = new com.wpengapp.support.ٲ$֏
            r5.<init>(r2, r1)
            goto L_0x0061
        L_0x005c:
            com.wpengapp.support.ٲ$֏ r5 = new com.wpengapp.support.ٲ$֏
            r5.<init>()
        L_0x0061:
            com.wpengapp.support.ٲ$ؠ r6 = new com.wpengapp.support.ٲ$ؠ
            com.wpengapp.support.ا r1 = new com.wpengapp.support.ا
            int r2 = r0.outWidth
            int r0 = r0.outHeight
            int r3 = r5.f2344
            r1.<init>(r2, r0, r3)
            r6.<init>(r1, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.BaseImageDecoder.mo8816(java.io.InputStream, com.wpengapp.support.ˌ):com.wpengapp.support.ٲ$ؠ");
    }

    /* renamed from: ֏ */
    public BitmapFactory.Options mo8815(ImageSize r6, ImageDecodingInfo r7) {
        int i;
        ImageScaleType r0 = r7.f1528;
        if (r0 == ImageScaleType.NONE) {
            i = 1;
        } else if (r0 == ImageScaleType.NONE_SAFE) {
            i = ImageSizeUtils.m1638(r6);
        } else {
            i = ImageSizeUtils.m1639(r6, r7.f1527, r7.f1529, r0 == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (i > 1 && this.f2343) {
            L.m2159("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", r6, r6.mo8739(i), Integer.valueOf(i), r7.f1525);
        }
        BitmapFactory.Options options = r7.f1533;
        options.inSampleSize = i;
        return options;
    }
}
