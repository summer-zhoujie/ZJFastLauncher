package com.wpengapp.support;

import java.io.File;

/* renamed from: com.wpengapp.support.ʰ */
public class ImageLoaderEngine implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C1336 f1381;

    /* renamed from: ؠ */
    public final /* synthetic */ C0607 f1382;

    public ImageLoaderEngine(C0607 r1, C1336 r2) {
        this.f1382 = r1;
        this.f1381 = r2;
    }

    public void run() {
        File r0 = this.f1382.f1392.f1424.mo8305(this.f1381.f3819);
        boolean z = r0 != null && r0.exists();
        this.f1382.mo8301();
        if (z) {
            this.f1382.f1394.execute(this.f1381);
        } else {
            this.f1382.f1393.execute(this.f1381);
        }
    }
}
