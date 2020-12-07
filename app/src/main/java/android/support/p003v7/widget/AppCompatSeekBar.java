package android.support.p003v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: android.support.v7.widget.AppCompatSeekBar */
public class AppCompatSeekBar extends SeekBar {
    public final AppCompatSeekBarHelper mAppCompatSeekBarHelper;

    public AppCompatSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mAppCompatSeekBarHelper.drawableStateChanged();
    }

    @RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.mAppCompatSeekBarHelper.jumpDrawablesToCurrentState();
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mAppCompatSeekBarHelper.drawTickMarks(canvas);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSeekBar(Context r2, AttributeSet r3) {
        /*
            r1 = this;
            int r0 = android.support.p003v7.appcompat.C0176R.attr.seekBarStyle
            r1.<init>(r2, r3, r0)
            android.support.v7.widget.AppCompatSeekBarHelper r2 = new android.support.v7.widget.AppCompatSeekBarHelper
            r2.<init>(r1)
            r1.mAppCompatSeekBarHelper = r2
            android.support.v7.widget.AppCompatSeekBarHelper r2 = r1.mAppCompatSeekBarHelper
            r2.loadFromAttributes(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.AppCompatSeekBar.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAppCompatSeekBarHelper = new AppCompatSeekBarHelper(this);
        this.mAppCompatSeekBarHelper.loadFromAttributes(attributeSet, i);
    }
}
