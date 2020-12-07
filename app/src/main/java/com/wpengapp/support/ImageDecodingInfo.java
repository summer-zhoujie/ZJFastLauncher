package com.wpengapp.support;

import android.graphics.BitmapFactory;
import android.os.Build;

/* renamed from: com.wpengapp.support.ˌ */
public class ImageDecodingInfo {

    /* renamed from: ֏ */
    public final String f1525;

    /* renamed from: ؠ */
    public final String f1526;

    /* renamed from: ހ */
    public final ImageSize f1527;

    /* renamed from: ށ */
    public final ImageScaleType f1528;

    /* renamed from: ނ */
    public final ViewScaleType f1529;

    /* renamed from: ރ */
    public final ImageDownloader f1530;

    /* renamed from: ބ */
    public final Object f1531;

    /* renamed from: ޅ */
    public final boolean f1532;

    /* renamed from: ކ */
    public final BitmapFactory.Options f1533 = new BitmapFactory.Options();

    public ImageDecodingInfo(String str, String str2, String str3, ImageSize r4, ViewScaleType r5, ImageDownloader r6, C0621 r7) {
        this.f1525 = str;
        this.f1526 = str2;
        this.f1527 = r4;
        this.f1528 = r7.f1564;
        this.f1529 = r5;
        this.f1530 = r6;
        this.f1531 = r7.f1568;
        this.f1532 = r7.f1567;
        BitmapFactory.Options options = r7.f1565;
        BitmapFactory.Options options2 = this.f1533;
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        int i = Build.VERSION.SDK_INT;
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }
}
