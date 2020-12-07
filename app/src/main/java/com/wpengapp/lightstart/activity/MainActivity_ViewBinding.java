package com.wpengapp.lightstart.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.activity.MainActivity;
import com.wpengapp.support.C0958;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
    @UiThread
    public MainActivity_ViewBinding(T t, View view) {
        t.mItemAppEnable = (ItemView) C0958.m2538(view, R$id.item_app_enable, "field 'mItemAppEnable'", ItemView.class);
        t.mItemSyncError = C0958.m2537(view, R$id.item_sync_error, "field 'mItemSyncError'");
        t.mItemPluginCenter = (ItemView) C0958.m2538(view, R$id.item_plugin_center, "field 'mItemPluginCenter'", ItemView.class);
        t.mTvSkipCount = (TextView) C0958.m2538(view, R$id.tv_skip_count, "field 'mTvSkipCount'", TextView.class);
        t.mTvGzh = (TextView) C0958.m2538(view, 2131165519, "field 'mTvGzh'", TextView.class);
    }
}
