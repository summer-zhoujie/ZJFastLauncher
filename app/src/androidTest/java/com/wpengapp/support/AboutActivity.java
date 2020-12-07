package com.wpengapp.support;

import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.support.model.App;

/* renamed from: com.wpengapp.support.ƅ */
public class AboutActivity implements RetCallback<App.AppVersion> {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.support.activity.AboutActivity f909;

    public AboutActivity(com.wpengapp.support.activity.AboutActivity aboutActivity) {
        this.f909 = aboutActivity;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        if (((App.AppVersion) obj) != null) {
            ((ItemView) this.f909.findViewById(R$id.item_check_update)).setEnterIcon(R$drawable.pw_icon_new);
        }
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
    }
}
