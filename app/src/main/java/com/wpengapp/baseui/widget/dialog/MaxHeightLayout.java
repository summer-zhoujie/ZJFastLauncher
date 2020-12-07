package com.wpengapp.baseui.widget.dialog;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.p003v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class MaxHeightLayout extends LinearLayout {

    /* renamed from: ֏ */
    public int f404 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public MaxHeightLayout(Context context) {
        super(context);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i2), this.f404), MeasureSpec.getMode(i2)));
    }

    public void setMaxHeight(int i) {
        this.f404 = i;
    }

    public MaxHeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxHeightLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public MaxHeightLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
