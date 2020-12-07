package com.wpengapp.support;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;

/* renamed from: com.wpengapp.support.চ */
/* compiled from: ActivityKiller */
class C1052 implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
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
        AppUtils.m1152(ActivityKiller.f1602);
    }

    public void onActivityStopped(Activity activity) {
        boolean z;
        if (ActivityKiller.f1600 && !AppUtils.m1170()) {
            Activity r3 = AppUtils.m1168();
            Iterator<Activity> it = ActivityKiller.f1598.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Activity next = it.next();
                if (r3 != null && next == r3) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                AppUtils.m1152(ActivityKiller.f1602);
                AppUtils.m1147(ActivityKiller.f1602, 60000);
            }
        }
    }
}
