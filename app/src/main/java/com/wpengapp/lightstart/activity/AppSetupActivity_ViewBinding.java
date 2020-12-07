package com.wpengapp.lightstart.activity;

import android.support.annotation.UiThread;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import com.wpengapp.lightstart.activity.AppSetupActivity;
import com.wpengapp.support.C0958;

public class AppSetupActivity_ViewBinding<T extends AppSetupActivity> implements Unbinder {
    @UiThread
    public AppSetupActivity_ViewBinding(T t, View view) {
        t.mRecyclerView = (RecyclerView) C0958.m2538(view, 2131165405, "field 'mRecyclerView'", RecyclerView.class);
    }
}
