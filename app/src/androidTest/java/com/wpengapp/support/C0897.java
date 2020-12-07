package com.wpengapp.support;

import android.app.ActivityManager;
import android.support.p003v7.widget.ActivityChooserModel;
import java.util.List;

/* renamed from: com.wpengapp.support.ڷ */
/* compiled from: ForegroundAppManager */
class C0897 implements Runnable {
    public void run() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) AppUtils.m1153(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
            String className = runningTaskInfo.topActivity.getClassName();
            if (className != null && !className.equals(ForegroundAppManager.f1240)) {
                String packageName = runningTaskInfo.topActivity.getPackageName();
                ForegroundAppManager.f1240 = className;
                ForegroundAppManager.f1241 = packageName;
                ForegroundAppManager.m1397(packageName, className);
            }
        }
    }
}
