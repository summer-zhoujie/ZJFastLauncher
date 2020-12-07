package com.wpengapp.support;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Process;
import com.wpengapp.support.activity.LauncherActivity;
import com.wpengapp.support.permission.RequestPermissionHelper;

/* renamed from: com.wpengapp.support.Ց */
/* compiled from: BaseApplication */
class C0790 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: ֏ */
    public final /* synthetic */ BaseApplication f2055;

    public C0790(BaseApplication baseApplication) {
        this.f2055 = baseApplication;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f2055.f564 && activity.getClass() != LauncherActivity.class && activity.getClass() != RequestPermissionHelper.class) {
            StringBuilder r3 = outline.m2549("Exit App [Permission Denied] ");
            r3.append(activity.getClass().getName());
            r3.toString();
            activity.finish();
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
