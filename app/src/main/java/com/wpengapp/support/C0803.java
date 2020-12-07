package com.wpengapp.support;

import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.wpengapp.support.ճ */
/* compiled from: ScreencapHelper */
class C0803 implements ImageReader.OnImageAvailableListener {

    /* renamed from: ֏ */
    public final /* synthetic */ ImageReader f2080;

    /* renamed from: ؠ */
    public final /* synthetic */ RetCallback f2081;

    /* renamed from: ހ */
    public final /* synthetic */ int f2082;

    /* renamed from: ށ */
    public final /* synthetic */ AtomicReference f2083;

    public C0803(ImageReader imageReader, RetCallback r2, int i, AtomicReference atomicReference) {
        this.f2080 = imageReader;
        this.f2081 = r2;
        this.f2082 = i;
        this.f2083 = atomicReference;
    }

    public void onImageAvailable(ImageReader imageReader) {
        try {
            Image acquireLatestImage = this.f2080.acquireLatestImage();
            if (acquireLatestImage != null) {
                try {
                    this.f2081.mo7931(ScreencapHelper.m729(acquireLatestImage));
                    this.f2080.close();
                    ObjectCache.m1663(this.f2082);
                    if (this.f2083.get() == null) {
                        return;
                    }
                } catch (Throwable th) {
                    this.f2080.close();
                    ObjectCache.m1663(this.f2082);
                    if (this.f2083.get() != null) {
                        ((VirtualDisplay) this.f2083.get()).release();
                    }
                    throw th;
                }
                ((VirtualDisplay) this.f2083.get()).release();
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }
}
