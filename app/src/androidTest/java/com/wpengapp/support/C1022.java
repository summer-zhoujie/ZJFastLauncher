package com.wpengapp.support;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.support.p003v7.widget.ActivityChooserModel;
import android.view.WindowManager;
import android.widget.TextView;
import com.wpengapp.support.permission.ServicePermissionActivity;
import java.util.List;

/* renamed from: com.wpengapp.support.द */
/* compiled from: ForceCloseHelper */
public final class C1022 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Context f2943;

    public C1022(Context context) {
        this.f2943 = context;
    }

    public void run() {
        int i;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) AppUtils.m1153(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
            if (runningTaskInfo.topActivity != null && runningTaskInfo.topActivity.getClassName().equals(ServicePermissionActivity.class.getName())) {
                return;
            }
        }
        FloatWindow r3 = new FloatWindow(this.f2943, new WindowManager.LayoutParams((int) (((float) C0826.m2169().f2152) * 0.85f), -2, Build.VERSION.SDK_INT >= 26 ? 2038 : 2003, 8, -2), R$layout.pw_float_killed_help);
        ((TextView) r3.f2735.findViewById(R$id.title)).setText(this.f2943.getString(R$string.pw_dialog_killed_title, new Object[]{this.f2943.getPackageManager().getApplicationLabel(this.f2943.getApplicationInfo())}));
        r3.f2735.findViewById(R$id.btnClose).setOnClickListener(new C1107(this, r3));
        r3.f2735.findViewById(R$id.bottomBtn).setOnClickListener(new ForceCloseHelper(this, r3));
        if (SystemUtils.m3529()) {
            i = (C0826.m2169().f2153 - r3.f2734.width) / 2;
        } else {
            i = (C0826.m2169().f2152 - r3.f2734.width) / 2;
        }
        r3.mo9028(i, 200);
    }
}
