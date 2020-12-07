package com.wpengapp.lightstart.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import com.wpengapp.baseui.widget.SwitchButton;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.activity.PluginCenterActivity;
import com.wpengapp.support.C0958;

public class PluginCenterActivity_ViewBinding<T extends PluginCenterActivity> implements Unbinder {
    @UiThread
    public PluginCenterActivity_ViewBinding(T t, View view) {
        t.mItemMiuiModel = (FrameLayout) C0958.m2538(view, R$id.item_miui_model, "field 'mItemMiuiModel'", FrameLayout.class);
        t.mSwMiuiModel = (SwitchButton) C0958.m2538(view, R$id.sw_miui_model, "field 'mSwMiuiModel'", SwitchButton.class);
    }
}
