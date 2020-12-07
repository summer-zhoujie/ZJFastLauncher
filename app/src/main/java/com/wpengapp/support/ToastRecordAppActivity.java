package com.wpengapp.support;

import android.support.p003v7.widget.RecyclerView;

/* renamed from: com.wpengapp.support.Բ */
class ToastRecordAppActivity extends RecyclerView.OnScrollListener {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.lightstart.activity.ToastRecordAppActivity f1986;

    public ToastRecordAppActivity(com.wpengapp.lightstart.activity.ToastRecordAppActivity toastRecordAppActivity) {
        this.f1986 = toastRecordAppActivity;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0 && !recyclerView.canScrollVertically(1)) {
            this.f1986.mo7694();
        }
    }
}
