package com.wpengapp.support;

import android.support.p003v7.widget.RecyclerView;

/* renamed from: com.wpengapp.support.ɬ */
class ToastRecordActivity extends RecyclerView.OnScrollListener {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.lightstart.activity.ToastRecordActivity f1249;

    public ToastRecordActivity(com.wpengapp.lightstart.activity.ToastRecordActivity toastRecordActivity) {
        this.f1249 = toastRecordActivity;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0 && !recyclerView.canScrollVertically(1) && !SpHandler.f1761.mo8104().booleanValue()) {
            this.f1249.mo7685();
        }
    }
}
