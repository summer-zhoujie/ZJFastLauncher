package com.wpengapp.support;

import android.support.p003v7.widget.TooltipCompatHandler;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.service.AccService;
import com.wpengapp.lightstart.service.AccService24;

/* renamed from: com.wpengapp.support.ഴ */
public class WechatBarcodeAction implements Runnable {
    public void run() {
        if (!CountLimitHelper.m997("wechatbarcode", TooltipCompatHandler.HOVER_HIDE_TIMEOUT_SHORT_MS)) {
            if (SystemUtils.m3524("com.tencent.mm") != null) {
                if (!AccServiceHelper.m2016(AccService.class, AccService24.class)) {
                    C0826.m2172((int) R$string.need_permission, new Object[0]);
                    return;
                }
                C0840.m2250(new WechatBarcodeTaskGroup(), new C1226(this, System.currentTimeMillis()));
                return;
            }
            throw new RuntimeException("has not install wechat");
        }
    }
}
