package com.wpengapp.lightstart.activity.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.support.p003v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class AntiImageView extends AppCompatImageView {

    /* renamed from: ֏ */
    public PaintFlagsDrawFilter f499 = new PaintFlagsDrawFilter(0, 3);

    public AntiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onDraw(Canvas canvas) {
        canvas.setDrawFilter(this.f499);
        super.onDraw(canvas);
    }

    public AntiImageView(Context context) {
        super(context, (AttributeSet) null, 0);
    }

    public AntiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }
}
