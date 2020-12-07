package com.wpengapp.lightstart.activity;

import android.support.annotation.UiThread;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import com.wpengapp.lightstart.activity.CustomActivity;
import com.wpengapp.support.C0958;

public class CustomActivity_ViewBinding<T extends CustomActivity> implements Unbinder {
    @UiThread
    public CustomActivity_ViewBinding(T t, View view) {
        t.mRecyclerView = (RecyclerView) C0958.m2538(view, 2131165405, "field 'mRecyclerView'", RecyclerView.class);
    }
}
