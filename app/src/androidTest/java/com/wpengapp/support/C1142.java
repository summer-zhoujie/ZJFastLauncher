package com.wpengapp.support;

import android.hardware.display.VirtualDisplay;
import android.media.ImageReader;
import java.lang.ref.WeakReference;

/* renamed from: com.wpengapp.support.ମ */
/* compiled from: ScreencapHelper */
public final class C1142 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ int f3241;

    /* renamed from: ؠ */
    public final /* synthetic */ WeakReference f3242;

    /* renamed from: ހ */
    public final /* synthetic */ WeakReference f3243;

    public C1142(int i, WeakReference weakReference, WeakReference weakReference2) {
        this.f3241 = i;
        this.f3242 = weakReference;
        this.f3243 = weakReference2;
    }

    public void run() {
        ObjectCache.m1663(this.f3241);
        try {
            ImageReader imageReader = (ImageReader) this.f3242.get();
            if (imageReader != null) {
                imageReader.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            VirtualDisplay virtualDisplay = (VirtualDisplay) this.f3243.get();
            if (virtualDisplay != null) {
                virtualDisplay.release();
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }
}
