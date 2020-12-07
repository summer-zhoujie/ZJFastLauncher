package com.wpengapp.support.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.NotificationCompatJellybean;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ProgressBar;
import com.wpengapp.baseui.widget.BaseWebView;
import com.wpengapp.support.ActivityKiller;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0826;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$menu;
import com.wpengapp.support.R$string;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.outline;

public class CommonWebActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public BaseWebView f624;

    /* renamed from: ؠ */
    public ProgressBar f625;

    /* renamed from: ހ */
    public String f626;

    /* renamed from: ށ */
    public String f627;

    /* renamed from: ނ */
    public String f628;

    /* renamed from: ރ */
    public Boolean f629;

    /* renamed from: ބ */
    public int f630 = 0;

    /* renamed from: ޅ */
    public int f631 = 0;

    /* renamed from: ކ */
    public Runnable f632 = new C0631(this);

    /* renamed from: ނ */
    public static /* synthetic */ int m788(CommonWebActivity commonWebActivity) {
        int i = commonWebActivity.f630;
        commonWebActivity.f630 = i + 1;
        return i;
    }

    public void onBackPressed() {
        if (this.f624.canGoBack()) {
            this.f624.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f626 = getIntent().getStringExtra("url");
        this.f627 = getIntent().getStringExtra("defaultUrl");
        this.f628 = getIntent().getStringExtra(NotificationCompatJellybean.KEY_TITLE);
        if (!TextUtils.isEmpty(this.f628)) {
            setTitle(this.f628);
        }
        if (getIntent().getBooleanExtra("disableAutoKill", false)) {
            ActivityKiller.f1598.put(this, this);
        }
        try {
            setContentView(R$layout.pw_activity_base_web);
            this.f624 = (BaseWebView) findViewById(R$id.webview);
            this.f625 = (ProgressBar) findViewById(R$id.progress);
            this.f624.setWebChromeClient(new C1042(this));
            this.f624.setWebViewClient(new C0684(this));
            this.f624.setDownloadListener(new CommonWebActivity(this));
            mo7823(this.f626);
        } catch (Exception e) {
            e.getMessage();
            finish();
            C0826.m2179(R$string.pw_webview_error, new Object[0]);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        BaseWebView baseWebView = this.f624;
        if (baseWebView != null) {
            ViewParent parent = baseWebView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f624);
            }
            this.f624.destroy();
            this.f624 = null;
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R$id.action_refresh) {
            this.f624.reload();
            return false;
        } else if (menuItem.getItemId() == R$id.action_browser) {
            if (TextUtils.isEmpty(this.f626) || !this.f626.startsWith("http")) {
                return false;
            }
            SystemUtils.m3515((Context) this, this.f624.getOriginalUrl());
            return false;
        } else if (menuItem.getItemId() != R$id.action_close) {
            return false;
        } else {
            finish();
            return false;
        }
    }

    /* renamed from: ؠ */
    public void mo7823(String str) {
        outline.m2555("loadUrl ", str);
        if (this.f624 != null && !TextUtils.isEmpty(str)) {
            this.f626 = str;
            this.f624.loadUrl(str);
        }
    }

    /* renamed from: ހ */
    public void mo7824(boolean z) {
        this.f625.setVisibility(z ? 0 : 8);
        this.f631 = 0;
        this.f630 = 0;
        this.f625.setProgress(0);
    }

    /* renamed from: ށ */
    public void mo7825(int i) {
        if (this.f630 < i) {
            if (this.f625.getVisibility() == 8) {
                this.f625.setVisibility(0);
            }
            this.f631 = i;
            AppUtils.m1152(this.f632);
            AppUtils.m1146(this.f632);
        }
    }

    /* renamed from: ބ */
    public int mo7437() {
        return R$menu.activity_base_web;
    }

    /* renamed from: ֏ */
    public static void m783(Context context, String str, String str2) {
        m784(context, str, str2, false, (String) null);
    }

    /* renamed from: ֏ */
    public static void m784(Context context, String str, String str2, boolean z, String str3) {
        Intent intent = new Intent(context, CommonWebActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(NotificationCompatJellybean.KEY_TITLE, str2);
        intent.putExtra("disableAutoKill", z);
        intent.putExtra("defaultUrl", str3);
        SystemUtils.m3510(context, intent);
    }
}
