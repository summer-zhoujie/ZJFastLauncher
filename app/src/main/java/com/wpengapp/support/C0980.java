package com.wpengapp.support;

import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import com.wpengapp.support.SwipeDeleteHelper;

/* renamed from: com.wpengapp.support.ߢ */
/* compiled from: SwipeDeleteHelper */
class C0980 extends ItemTouchHelper.Callback {

    /* renamed from: ֏ */
    public final /* synthetic */ SwipeDeleteHelper.C0668 f2749;

    public C0980(SwipeDeleteHelper.C0668 r1) {
        this.f2749 = r1;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ItemTouchHelper.Callback.makeMovementFlags(0, 48);
    }

    public boolean isLongPressDragEnabled() {
        return false;
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return false;
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        this.f2749.mo8432(viewHolder, viewHolder.getAdapterPosition());
    }
}
