package com.wpengapp.support;

import android.graphics.Bitmap;

/* renamed from: com.wpengapp.support.ߵ */
public final class DisplayBitmapTask implements Runnable {

    /* renamed from: ֏ */
    public final Bitmap f2767;

    /* renamed from: ؠ */
    public final String f2768;

    /* renamed from: ހ */
    public final ImageAware f2769;

    /* renamed from: ށ */
    public final String f2770;

    /* renamed from: ނ */
    public final SimpleBitmapDisplayer f2771;

    /* renamed from: ރ */
    public final SimpleImageLoadingListener f2772;

    /* renamed from: ބ */
    public final C0607 f2773;

    /* renamed from: ޅ */
    public final LoadedFrom f2774;

    public DisplayBitmapTask(Bitmap bitmap, ImageLoadingInfo r2, C0607 r3, LoadedFrom r4) {
        this.f2767 = bitmap;
        this.f2768 = r2.f1402;
        this.f2769 = r2.f1404;
        this.f2770 = r2.f1403;
        this.f2771 = r2.f1406.f1569;
        this.f2772 = r2.f1407;
        this.f2773 = r3;
        this.f2774 = r4;
    }

    public void run() {
        if (this.f2769.mo7956()) {
            L.m2159("ImageAware was collected by GC. Task is cancelled. [%s]", this.f2770);
            this.f2772.mo7942(this.f2768, this.f2769.mo7952());
            return;
        }
        C0607 r0 = this.f2773;
        ImageAware r3 = this.f2769;
        if (!this.f2770.equals(r0.f1396.get(Integer.valueOf(r3.getId())))) {
            L.m2159("ImageAware is reused for another image. Task is cancelled. [%s]", this.f2770);
            this.f2772.mo7942(this.f2768, this.f2769.mo7952());
            return;
        }
        L.m2159("Display image in ImageAware (loaded from %1$s) [%2$s]", this.f2774, this.f2770);
        this.f2771.mo8821(this.f2767, this.f2769, this.f2774);
        this.f2773.f1396.remove(Integer.valueOf(this.f2769.getId()));
        this.f2772.mo7943(this.f2768, this.f2769.mo7952(), this.f2767);
    }
}
