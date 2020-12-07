package com.wpengapp.lightstart.activity;

import android.support.annotation.UiThread;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import com.wpengapp.lightstart.activity.ToastRecordAppActivity;
import com.wpengapp.support.C0958;

public class ToastRecordAppActivity_ViewBinding<T extends ToastRecordAppActivity> implements Unbinder {
    @UiThread
    public ToastRecordAppActivity_ViewBinding(T t, View view) {
        t.mList = (RecyclerView) C0958.m2538(view, 2131165405, "field 'mList'", RecyclerView.class);
    }
}
