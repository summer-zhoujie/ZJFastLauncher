package com.wpengapp.lightstart.activity;

import android.support.annotation.UiThread;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import com.wpengapp.lightstart.activity.NotifyRecordBaseActivity;
import com.wpengapp.support.C0958;

public class NotifyRecordBaseActivity_ViewBinding<T extends NotifyRecordBaseActivity> implements Unbinder {
    @UiThread
    public NotifyRecordBaseActivity_ViewBinding(T t, View view) {
        t.mList = (RecyclerView) C0958.m2538(view, 2131165405, "field 'mList'", RecyclerView.class);
    }
}
