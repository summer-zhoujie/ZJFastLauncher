package com.wpengapp.support;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.wpengapp.support.licensing.activity.QrPayActivity;

/* renamed from: com.wpengapp.support.ཛྷ */
/* compiled from: QrPayActivity */
public class C1264 extends WebViewClient {

    /* renamed from: ֏ */
    public final /* synthetic */ QrPayActivity f3564;

    public C1264(QrPayActivity qrPayActivity) {
        this.f3564 = qrPayActivity;
    }

    public void onLoadResource(WebView webView, String str) {
        outline.m2555("onLoadResource ", str);
        super.onLoadResource(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        outline.m2555("onPageFinished ", str);
        super.onPageFinished(webView, str);
        this.f3564.mo7430();
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23) {
            StringBuilder r1 = outline.m2549("onReceivedError ");
            r1.append(webResourceError.getDescription());
            r1.toString();
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        int i = Build.VERSION.SDK_INT;
        StringBuilder r1 = outline.m2549("onReceivedHttpError ");
        r1.append(webResourceResponse.getReasonPhrase());
        r1.toString();
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        StringBuilder r1 = outline.m2549("onReceivedSslError ");
        r1.append(sslError.toString());
        r1.toString();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String scheme = Uri.parse(str).getScheme();
        "Show Page: " + scheme + " - " + str;
        if ("intent".equals(scheme)) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent((ComponentName) null);
                int i = Build.VERSION.SDK_INT;
                parseUri.setSelector((Intent) null);
                this.f3564.startActivity(parseUri);
                this.f3564.mo7859();
            } catch (Exception e) {
                e.getMessage();
            }
        } else if ("tel".equals(scheme)) {
            return true;
        } else {
            if ("http".equals(scheme) || "https".equals(scheme)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                this.f3564.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                this.f3564.mo7859();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return true;
    }
}
