package android.support.p003v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* renamed from: android.support.v7.widget.AppCompatRatingBar */
public class AppCompatRatingBar extends RatingBar {
    public final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    public AppCompatRatingBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap sampleTime = this.mAppCompatProgressBarHelper.getSampleTime();
        if (sampleTime != null) {
            setMeasuredDimension(View.resolveSizeAndState(sampleTime.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatRatingBar(Context r2, AttributeSet r3) {
        /*
            r1 = this;
            int r0 = android.support.p003v7.appcompat.C0176R.attr.ratingBarStyle
            r1.<init>(r2, r3, r0)
            android.support.v7.widget.AppCompatProgressBarHelper r2 = new android.support.v7.widget.AppCompatProgressBarHelper
            r2.<init>(r1)
            r1.mAppCompatProgressBarHelper = r2
            android.support.v7.widget.AppCompatProgressBarHelper r2 = r1.mAppCompatProgressBarHelper
            r2.loadFromAttributes(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.AppCompatRatingBar.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAppCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
        this.mAppCompatProgressBarHelper.loadFromAttributes(attributeSet, i);
    }
}
