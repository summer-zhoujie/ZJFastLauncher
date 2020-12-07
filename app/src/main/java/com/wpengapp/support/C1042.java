package com.wpengapp.support;

import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.wpengapp.support.activity.CommonWebActivity;

/* renamed from: com.wpengapp.support.ॻ */
/* compiled from: CommonWebActivity */
class C1042 extends WebChromeClient {

    /* renamed from: ֏ */
    public final /* synthetic */ CommonWebActivity f2990;

    public C1042(CommonWebActivity commonWebActivity) {
        this.f2990 = commonWebActivity;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.f2990.mo7825(i);
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (TextUtils.isEmpty(this.f2990.f628)) {
            this.f2990.mo7427((CharSequence) str);
        }
    }
}
