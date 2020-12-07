package com.wpengapp.support;

import android.webkit.DownloadListener;

/* renamed from: com.wpengapp.support.Ƨ */
class CommonWebActivity implements DownloadListener {
    public CommonWebActivity(com.wpengapp.support.activity.CommonWebActivity commonWebActivity) {
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        "onDownloadStart " + str;
        SystemUtils.m3527(str);
    }
}
