package com.wpengapp.support;

import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.helper.ItemTouchHelper;

/* renamed from: com.wpengapp.support.Ϩ */
public class SwipeDeleteHelper extends ItemTouchHelper {

    /* renamed from: com.wpengapp.support.Ϩ$֏ */
    /* compiled from: SwipeDeleteHelper */
    public interface C0668 {
        /* renamed from: ֏ */
        void mo8432(RecyclerView.ViewHolder viewHolder, int i);
    }

    public SwipeDeleteHelper(C0668 r2) {
        super(new C0980(r2));
    }
}
