package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;

/* renamed from: com.wpengapp.support.ϫ */
/* compiled from: FileStorage */
class C0670 extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("ex_pid", -1);
        if (Process.myPid() != intExtra) {
            String stringExtra = intent.getStringExtra("ex_name");
            if (!TextUtils.isEmpty(stringExtra)) {
                "FileStorage[" + stringExtra + "] modified from other process[" + intExtra + "]";
                TaskManager.m2715((Runnable) new C0847(this, stringExtra));
            }
        }
    }
}
