package com.umeng.analytics;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.app.NotificationCompatJellybean;
import android.support.p000v4.text.BidiFormatter;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class MobclickAgentJSInterface {

    /* renamed from: a */
    public Context f73a;

    /* renamed from: com.umeng.analytics.MobclickAgentJSInterface$a */
    final class C0378a extends WebChromeClient {

        /* renamed from: a */
        public WebChromeClient f74a = null;

        /* renamed from: c */
        public final String f76c = "ekv";

        /* renamed from: d */
        public final String f77d = NotificationCompat.CATEGORY_EVENT;

        public C0378a(WebChromeClient webChromeClient) {
            if (webChromeClient == null) {
                this.f74a = new WebChromeClient();
            } else {
                this.f74a = webChromeClient;
            }
        }

        public void onCloseWindow(WebView webView) {
            this.f74a.onCloseWindow(webView);
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            return this.f74a.onCreateWindow(webView, z, z2, message);
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return this.f74a.onJsAlert(webView, str, str2, jsResult);
        }

        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            return this.f74a.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            return this.f74a.onJsConfirm(webView, str, str2, jsResult);
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("ekv".equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    HashMap hashMap = new HashMap();
                    String str4 = (String) jSONObject.remove("id");
                    int intValue = jSONObject.isNull("duration") ? 0 : ((Integer) jSONObject.remove("duration")).intValue();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.getString(next));
                    }
                    MobclickAgent.f70b.mo7286a(MobclickAgentJSInterface.this.f73a, str4, (Map<String, Object>) hashMap, (long) intValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (!NotificationCompat.CATEGORY_EVENT.equals(str2)) {
                return this.f74a.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    String optString = jSONObject2.optString(NotificationCompatJellybean.KEY_LABEL);
                    if (BidiFormatter.EMPTY_STRING.equals(optString)) {
                        optString = null;
                    }
                    MobclickAgent.f70b.mo7284a(MobclickAgentJSInterface.this.f73a, jSONObject2.getString("tag"), optString, (long) jSONObject2.optInt("duration"), 1);
                } catch (Exception unused) {
                }
            }
            jsPromptResult.confirm();
            return true;
        }

        public void onProgressChanged(WebView webView, int i) {
            this.f74a.onProgressChanged(webView, i);
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            this.f74a.onReceivedIcon(webView, bitmap);
        }

        public void onReceivedTitle(WebView webView, String str) {
            this.f74a.onReceivedTitle(webView, str);
        }

        public void onRequestFocus(WebView webView) {
            this.f74a.onRequestFocus(webView);
        }
    }

    public MobclickAgentJSInterface(Context context, WebView webView) {
        this.f73a = context;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new C0378a((WebChromeClient) null));
    }

    public MobclickAgentJSInterface(Context context, WebView webView, WebChromeClient webChromeClient) {
        this.f73a = context;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new C0378a(webChromeClient));
    }
}
