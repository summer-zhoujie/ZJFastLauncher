package com.wpengapp.support;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.os.PowerManager;
import android.support.p000v4.util.ArrayMap;
import android.support.p003v7.widget.TooltipCompatHandler;

/* renamed from: com.wpengapp.support.ĥ */
public class NotificationEventHandler {

    /* renamed from: ֏ */
    public static final ArrayMap<String, String> f785 = new ArrayMap<>();

    static {
        f785.put("com.tencent.mobileqq", "一键验证");
        f785.put("com.tencent.mm", "微信登录确认");
        f785.put("com.tencent.tim", "一键验证");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r3 = (android.app.Notification) r3;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m995(android.view.accessibility.AccessibilityEvent r3) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            android.os.Parcelable r3 = r3.getParcelableData()
            boolean r0 = r3 instanceof android.app.Notification
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            android.app.Notification r3 = (android.app.Notification) r3
            android.os.Bundle r0 = r3.extras
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r1 = "android.appInfo"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x0058 }
            android.content.pm.ApplicationInfo r1 = (android.content.pm.ApplicationInfo) r1     // Catch:{ Exception -> 0x0058 }
            if (r1 != 0) goto L_0x001e
            return
        L_0x001e:
            android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> r2 = f785     // Catch:{ Exception -> 0x0058 }
            java.lang.String r1 = r1.packageName     // Catch:{ Exception -> 0x0058 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0058 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0058 }
            if (r2 == 0) goto L_0x002f
            return
        L_0x002f:
            java.lang.String r2 = "android.text"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ Exception -> 0x0058 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0058 }
            if (r2 == 0) goto L_0x0043
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0058 }
            boolean r2 = r2.contains(r1)     // Catch:{ Exception -> 0x0058 }
            if (r2 != 0) goto L_0x005c
        L_0x0043:
            java.lang.String r2 = "android.title"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x0058 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0058 }
            if (r0 == 0) goto L_0x0057
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0058 }
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x0058 }
            if (r0 != 0) goto L_0x005c
        L_0x0057:
            return
        L_0x0058:
            r0 = move-exception
            r0.getMessage()
        L_0x005c:
            android.app.PendingIntent r3 = r3.contentIntent
            if (r3 == 0) goto L_0x0068
            r3.send()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r3 = move-exception
            r3.getMessage()
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.NotificationEventHandler.m995(android.view.accessibility.AccessibilityEvent):void");
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: ֏ */
    public static void m993() {
        try {
            PowerManager powerManager = (PowerManager) AppUtils.m1153("power");
            if (!powerManager.isScreenOn()) {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(268435466, AppUtils.m1163() + "NEvtHandler");
                newWakeLock.acquire(TooltipCompatHandler.HOVER_HIDE_TIMEOUT_SHORT_MS);
                newWakeLock.release();
            }
            KeyguardManager keyguardManager = (KeyguardManager) AppUtils.m1153("keyguard");
            if (keyguardManager.isKeyguardLocked()) {
                KeyguardManager.KeyguardLock newKeyguardLock = keyguardManager.newKeyguardLock("unLock");
                newKeyguardLock.disableKeyguard();
                AppUtils.m1147((Runnable) new C1072(newKeyguardLock), (long) TooltipCompatHandler.HOVER_HIDE_TIMEOUT_SHORT_MS);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m994(KeyguardManager.KeyguardLock keyguardLock) {
        try {
            keyguardLock.reenableKeyguard();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
