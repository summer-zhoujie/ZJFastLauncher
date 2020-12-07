package com.wpengapp.lightstart.activity;

import android.support.annotation.UiThread;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import com.wpengapp.lightstart.activity.ToastRecordActivity;
import com.wpengapp.support.C0958;

public class ToastRecordActivity_ViewBinding<T extends ToastRecordActivity> implements Unbinder {
    @UiThread
    public ToastRecordActivity_ViewBinding(T t, View view) {
        t.mList = (RecyclerView) C0958.m2538(view, 2131165405, "field 'mList'", RecyclerView.class);
    }
}
