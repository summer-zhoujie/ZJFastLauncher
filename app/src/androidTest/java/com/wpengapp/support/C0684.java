package com.wpengapp.support;

import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.wpengapp.support.activity.CommonWebActivity;

/* renamed from: com.wpengapp.support.Ѕ */
/* compiled from: CommonWebActivity */
class C0684 extends WebViewClient {

    /* renamed from: ֏ */
    public final /* synthetic */ CommonWebActivity f1778;

    public C0684(CommonWebActivity commonWebActivity) {
        this.f1778 = commonWebActivity;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (TextUtils.isEmpty(this.f1778.f628)) {
            this.f1778.mo7427((CharSequence) webView.getTitle());
        }
        if (Boolean.TRUE.equals(this.f1778.f629) && str.equals(this.f1778.f627)) {
            Boolean unused = this.f1778.f629 = null;
            webView.clearHistory();
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.f1778.f627) && !this.f1778.f627.equals(str2)) {
            Boolean unused = this.f1778.f629 = true;
            CommonWebActivity commonWebActivity = this.f1778;
            commonWebActivity.mo7823(commonWebActivity.f627);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        outline.m2555("shouldOverrideUrlLoading ", str);
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }
}
