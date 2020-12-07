package com.wpengapp.support;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: com.wpengapp.support.ŷ */
class SafeAccService extends Handler {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.support.accservice.SafeAccService f891;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeAccService(com.wpengapp.support.accservice.SafeAccService safeAccService, Looper looper) {
        super(looper);
        this.f891 = safeAccService;
    }

    public void handleMessage(Message message) {
        if (message.what == 604) {
            Object obj = message.obj;
            this.f891.mo7814(obj == null ? null : (AccessibilityEvent) obj);
        }
    }
}
