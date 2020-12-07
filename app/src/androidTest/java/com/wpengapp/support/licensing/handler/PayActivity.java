package com.wpengapp.support.licensing.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.wpengapp.baseui.BaseActivity;
import com.wpengapp.support.C0678;
import com.wpengapp.support.C0786;
import com.wpengapp.support.GsonUtil;
import com.wpengapp.support.UserInfo;

public class PayActivity extends BaseActivity {

    /* renamed from: ފ */
    public boolean f700 = true;

    public void onResume() {
        super.onResume();
        if (!this.f700) {
            Intent intent = new Intent("PayActivity.ACTION_CALLBACK");
            intent.putExtra("pay_resume", true);
            C0786.m2105((Context) this, intent, true);
            finish();
            return;
        }
        this.f700 = false;
        try {
            C0678.m1725((Activity) this, 1, (UserInfo) GsonUtil.m2740(getIntent().getStringExtra("pay_order"), UserInfo.class), (C0678.C0680) new PayActivity(this));
        } catch (Exception e) {
            e.getMessage();
            Intent intent2 = new Intent("PayActivity.ACTION_CALLBACK");
            intent2.putExtra("pay_success", false);
            C0786.m2105((Context) this, intent2, true);
            finish();
        }
    }
}
