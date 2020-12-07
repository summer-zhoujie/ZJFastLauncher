package com.wpengapp.support;

import android.view.View;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* renamed from: com.wpengapp.support.৲ */
public class ImageViewAware extends ViewAware {
    public ImageViewAware(ImageView imageView) {
        super(imageView);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r0 = (android.widget.ImageView) r5.f1534.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getHeight() {
        /*
            r5 = this;
            java.lang.ref.Reference<android.view.View> r0 = r5.f1534
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            r1 = 0
            if (r0 == 0) goto L_0x0025
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            boolean r3 = r5.f1535
            if (r3 == 0) goto L_0x001f
            if (r2 == 0) goto L_0x001f
            int r3 = r2.height
            r4 = -2
            if (r3 == r4) goto L_0x001f
            int r0 = r0.getHeight()
            r1 = r0
        L_0x001f:
            if (r1 > 0) goto L_0x0025
            if (r2 == 0) goto L_0x0025
            int r1 = r2.height
        L_0x0025:
            if (r1 > 0) goto L_0x0037
            java.lang.ref.Reference<android.view.View> r0 = r5.f1534
            java.lang.Object r0 = r0.get()
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0037
            java.lang.String r1 = "mMaxHeight"
            int r1 = m2877(r0, r1)
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.ImageViewAware.getHeight():int");
    }

    /* renamed from: ֏ */
    public View mo7952() {
        return (ImageView) this.f1534.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r0 = (android.widget.ImageView) r5.f1534.get();
     */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo7955() {
        /*
            r5 = this;
            java.lang.ref.Reference<android.view.View> r0 = r5.f1534
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            r1 = 0
            if (r0 == 0) goto L_0x0025
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            boolean r3 = r5.f1535
            if (r3 == 0) goto L_0x001f
            if (r2 == 0) goto L_0x001f
            int r3 = r2.width
            r4 = -2
            if (r3 == r4) goto L_0x001f
            int r0 = r0.getWidth()
            r1 = r0
        L_0x001f:
            if (r1 > 0) goto L_0x0025
            if (r2 == 0) goto L_0x0025
            int r1 = r2.width
        L_0x0025:
            if (r1 > 0) goto L_0x0037
            java.lang.ref.Reference<android.view.View> r0 = r5.f1534
            java.lang.Object r0 = r0.get()
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0037
            java.lang.String r1 = "mMaxWidth"
            int r1 = m2877(r0, r1)
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.ImageViewAware.mo7955():int");
    }

    /* renamed from: ށ */
    public ViewScaleType mo7957() {
        ImageView imageView = (ImageView) this.f1534.get();
        if (imageView != null) {
            return ViewScaleType.m2482(imageView);
        }
        return ViewScaleType.CROP;
    }

    /* renamed from: ֏ */
    public static int m2877(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception e) {
            L.m2160(e);
            return 0;
        }
    }
}
