package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.wpengapp.baseui.BaseActivity;
import java.lang.ref.WeakReference;

/* renamed from: com.wpengapp.support.ୱ */
/* compiled from: AccServiceHelper */
class C1147 extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (AppUtils.getApplication().getPackageName().equals(intent.getPackage())) {
            C0786.m2102(AppUtils.getApplication(), this);
            WeakReference<BaseActivity> weakReference = BaseActivity.f266;
            BaseActivity baseActivity = weakReference == null ? null : (BaseActivity) weakReference.get();
            if (baseActivity != null) {
                Intent intent2 = new Intent(baseActivity.getIntent());
                intent2.addFlags(603979776);
                baseActivity.startActivity(intent2);
            }
        }
    }
}
