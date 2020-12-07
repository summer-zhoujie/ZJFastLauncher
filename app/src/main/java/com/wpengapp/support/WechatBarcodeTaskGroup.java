package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ь */
public class WechatBarcodeTaskGroup extends AccTaskGroup {
    public WechatBarcodeTaskGroup() {
        mo8201((AccTask) new LaunchMainTask());
        mo8201((AccTask) new WechatClickMainAddTask());
        mo8201((AccTask) new WechatClickMainBarcodeTask());
    }
}
