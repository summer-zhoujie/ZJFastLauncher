package com.wpengapp.support.activity;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import com.wpengapp.baseui.BaseActivity;

public class WPengBaseActivity extends BaseActivity {
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(getClass().getSimpleName());
        MobclickAgent.f70b.mo7298b((Context) this);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(getClass().getSimpleName());
        MobclickAgent.onResume(this);
    }
}
