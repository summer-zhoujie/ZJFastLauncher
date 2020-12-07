package com.wpengapp.support;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: com.wpengapp.support.ˍ */
public abstract class ViewAware implements ImageAware {

    /* renamed from: ֏ */
    public Reference<View> f1534;

    /* renamed from: ؠ */
    public boolean f1535;

    public ViewAware(View view) {
        if (view != null) {
            this.f1534 = new WeakReference(view);
            this.f1535 = true;
            return;
        }
        throw new IllegalArgumentException("view must not be null");
    }

    public int getId() {
        View view = this.f1534.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    /* renamed from: ֏ */
    public boolean mo7954(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f1534.get();
            if (view != null) {
                ImageViewAware r1 = (ImageViewAware) this;
                ((ImageView) view).setImageDrawable(drawable);
                if (!(drawable instanceof AnimationDrawable)) {
                    return true;
                }
                ((AnimationDrawable) drawable).start();
                return true;
            }
        } else {
            L.m2162("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    /* renamed from: ހ */
    public boolean mo7956() {
        return this.f1534.get() == null;
    }

    /* renamed from: ֏ */
    public boolean mo7953(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f1534.get();
            if (view != null) {
                ImageViewAware r1 = (ImageViewAware) this;
                ((ImageView) view).setImageBitmap(bitmap);
                return true;
            }
        } else {
            L.m2162("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }
}
