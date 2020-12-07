package com.wpengapp.support;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.wpengapp.support.licensing.activity.QrPayActivity;

/* renamed from: com.wpengapp.support.и */
/* compiled from: QrPayActivity */
public class C0702 extends WebChromeClient {

    /* renamed from: ֏ */
    public final /* synthetic */ QrPayActivity f1812;

    public C0702(QrPayActivity qrPayActivity) {
        this.f1812 = qrPayActivity;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (i == 100) {
            this.f1812.mo7430();
        } else if (this.f1812.f273 == null || !this.f1812.f273.isShowing()) {
            this.f1812.mo7431(R$string.pw_loading);
        }
    }
}
