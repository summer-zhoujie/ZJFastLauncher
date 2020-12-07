package com.wpengapp.support;

import android.support.p003v7.widget.RecyclerView;

/* renamed from: com.wpengapp.support.ન */
class NotifyRecordBaseActivity extends RecyclerView.OnScrollListener {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.lightstart.activity.NotifyRecordBaseActivity f3163;

    public NotifyRecordBaseActivity(com.wpengapp.lightstart.activity.NotifyRecordBaseActivity notifyRecordBaseActivity) {
        this.f3163 = notifyRecordBaseActivity;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0 && !recyclerView.canScrollVertically(1)) {
            this.f3163.mo7663();
        }
    }
}
