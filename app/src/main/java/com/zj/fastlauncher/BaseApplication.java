package com.zj.fastlauncher;

import android.app.Application;

import com.zj.tools.mylibrary.ZJLog;
import com.zj.tools.mylibrary.ZJToast;

public class BaseApplication extends Application {
    private static Application app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        ZJToast.init(this);
        ZJLog.init(true,"FastLauncher");
    }

    public static Application getApp() {
        return app;
    }
}
