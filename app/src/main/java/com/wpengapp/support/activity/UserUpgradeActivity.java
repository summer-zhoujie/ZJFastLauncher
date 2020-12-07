package com.wpengapp.support.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import com.wpengapp.support.C0678;
import com.wpengapp.support.C1114;
import com.wpengapp.support.NetworkUtils;
import com.wpengapp.support.QueryCallback;
import com.wpengapp.support.R$drawable;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.UserInfo;

public class UserUpgradeActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public C1114 f640;

    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.tv_alipay) {
            mo7835(7);
        } else if (id == R$id.tv_wechat) {
            mo7835(6);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.pw_activity_upgrade_change_device);
        mo7434().setBackgroundColor(0);
        findViewById(R$id.toolbarLine).setVisibility(4);
        this.f640 = new C1114(this);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: ށ */
    public final void mo7835(int i) {
        UserInfo r0 = this.f640.f3172;
        if (r0 != null && !r0.f2127 && System.currentTimeMillis() - r0.f2117 <= 300000) {
            mo7834(i, r0);
        } else if (!NetworkUtils.m1800()) {
            mo7424(R$string.pw_network_error);
        } else {
            this.f640.mo9299(false, true, false, (QueryCallback) new UserUpgradeActivity(this, i));
        }
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, R$drawable.baseui_icon_toolbar_back_dark);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return null;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ֏ */
    public final void mo7834(int i, UserInfo r5) {
        boolean r0 = r5.mo8706(i);
        if (!r0 && i == 7 && r5.mo8706(1)) {
            i = 1;
            r0 = true;
        }
        if (!r0) {
            mo7413(R$string.wpengpay_no_support_paytype);
            return;
        }
        C1102 r52 = new C1102(this);
        if (i == 1) {
            C0678.m1726((Activity) this, (C0678.C0680) r52);
        } else if (i == 6 || i == 7) {
            C0678.m1724((Activity) this, i, (C0678.C0680) r52);
        }
    }
}
