package com.wpengapp.support;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;

/* renamed from: com.wpengapp.support.ྋ */
public class NonViewAware implements ImageAware {

    /* renamed from: ֏ */
    public final String f3598;

    /* renamed from: ؠ */
    public final ImageSize f3599;

    /* renamed from: ހ */
    public final ViewScaleType f3600;

    public NonViewAware(String str, ImageSize r2, ViewScaleType r3) {
        if (r2 == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        } else if (r3 != null) {
            this.f3598 = str;
            this.f3599 = r2;
            this.f3600 = r3;
        } else {
            throw new IllegalArgumentException("scaleType must not be null");
        }
    }

    public int getHeight() {
        return this.f3599.f2222;
    }

    public int getId() {
        return TextUtils.isEmpty(this.f3598) ? super.hashCode() : this.f3598.hashCode();
    }

    /* renamed from: ֏ */
    public View mo7952() {
        return null;
    }

    /* renamed from: ֏ */
    public boolean mo7953(Bitmap bitmap) {
        return true;
    }

    /* renamed from: ֏ */
    public boolean mo7954(Drawable drawable) {
        return true;
    }

    /* renamed from: ؠ */
    public int mo7955() {
        return this.f3599.f2221;
    }

    /* renamed from: ހ */
    public boolean mo7956() {
        return false;
    }

    /* renamed from: ށ */
    public ViewScaleType mo7957() {
        return this.f3600;
    }
}
