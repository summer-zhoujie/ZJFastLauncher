package com.wpengapp.support;

import android.graphics.Rect;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;

/* renamed from: com.wpengapp.support.ͱ */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: ֏ */
    public int f1590;

    /* renamed from: ؠ */
    public int f1591 = 0;

    public SpacesItemDecoration(int i) {
        this.f1590 = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildLayoutPosition(view) != 0) {
            rect.top = this.f1590;
        } else {
            rect.top = this.f1591;
        }
    }
}
