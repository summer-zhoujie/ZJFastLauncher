package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import java.lang.ref.WeakReference;

/* renamed from: com.wpengapp.support.Ջ */
/* compiled from: PermissionBroadCast */
public class C0786 {

    /* renamed from: ֏ */
    public static final String f2035 = (AppUtils.m1163() + ".permission");

    /* renamed from: ֏ */
    public static void m2105(Context context, Intent intent, boolean z) {
        if (intent != null) {
            if (z) {
                intent.setPackage(context.getPackageName());
            }
            context.getApplicationContext().sendBroadcast(intent, f2035);
        }
    }

    /* renamed from: ֏ */
    public static void m2103(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        m2104(context, broadcastReceiver, intentFilter, (Handler) null, 0);
    }

    /* renamed from: ֏ */
    public static void m2104(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler, long j) {
        try {
            context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter, f2035, handler);
        } catch (Exception e) {
            e.getMessage();
        }
        if (j > 0) {
            AppUtils.m1147((Runnable) new PermissionBroadCast(new WeakReference(broadcastReceiver)), j);
        }
    }

    /* renamed from: ֏ */
    public static void m2102(Context context, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                context.getApplicationContext().unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
        }
    }
}
