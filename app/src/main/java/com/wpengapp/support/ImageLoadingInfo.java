package com.wpengapp.support;

import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.wpengapp.support.ʸ */
public final class ImageLoadingInfo {

    /* renamed from: ֏ */
    public final String f1402;

    /* renamed from: ؠ */
    public final String f1403;

    /* renamed from: ހ */
    public final ImageAware f1404;

    /* renamed from: ށ */
    public final ImageSize f1405;

    /* renamed from: ނ */
    public final C0621 f1406;

    /* renamed from: ރ */
    public final SimpleImageLoadingListener f1407;

    /* renamed from: ބ */
    public final ImageLoadingProgressListener f1408;

    /* renamed from: ޅ */
    public final ReentrantLock f1409;

    public ImageLoadingInfo(String str, ImageAware r2, ImageSize r3, String str2, C0621 r5, SimpleImageLoadingListener r6, ReentrantLock reentrantLock) {
        this.f1402 = str;
        this.f1404 = r2;
        this.f1405 = r3;
        this.f1406 = r5;
        this.f1407 = r6;
        this.f1409 = reentrantLock;
        this.f1403 = str2;
    }
}
