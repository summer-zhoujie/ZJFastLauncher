package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ष */
/* compiled from: BaseApplication */
class C1036 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ BaseApplication f2970;

    public C1036(BaseApplication baseApplication) {
        this.f2970 = baseApplication;
    }

    public void run() {
        synchronized ("BaseApplication") {
            boolean unused = this.f2970.f565 = true;
            "BaseApplication".notifyAll();
        }
        this.f2970.mo7791("App.onCreate End");
    }
}
