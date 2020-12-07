package com.wpengapp.support;

import android.widget.ImageView;

/* renamed from: com.wpengapp.support.ݳ */
public enum ViewScaleType {
    FIT_INSIDE,
    CROP;

    /* renamed from: ֏ */
    public static ViewScaleType m2482(ImageView imageView) {
        int i = C0940.f2571[imageView.getScaleType().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            return FIT_INSIDE;
        }
        return CROP;
    }
}
