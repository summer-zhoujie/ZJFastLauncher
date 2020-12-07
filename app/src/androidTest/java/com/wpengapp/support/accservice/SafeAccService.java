package com.wpengapp.support.accservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.support.p000v4.app.NotificationCompat;
import android.view.accessibility.AccessibilityEvent;
import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0719;
import com.wpengapp.support.C1076;
import com.wpengapp.support.StatisticsManager;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.outline;
import java.util.HashMap;

public abstract class SafeAccService extends BaseAccessibilityService {

    /* renamed from: ނ */
    public long f604;

    /* renamed from: ރ */
    public HandlerThread f605;

    /* renamed from: ބ */
    public volatile Handler f606;

    /* renamed from: ޅ */
    public boolean f607 = true;

    /* renamed from: ކ */
    public volatile long f608;

    /* renamed from: އ */
    public volatile int f609;

    /* renamed from: ވ */
    public int f610;

    /* renamed from: މ */
    public C0449 f611;

    /* renamed from: ފ */
    public volatile boolean f612;

    /* renamed from: ދ */
    public volatile long f613;

    /* renamed from: ތ */
    public final Runnable f614;

    /* renamed from: com.wpengapp.support.accservice.SafeAccService$֏ */
    private class C0449 extends BroadcastReceiver {
        public /* synthetic */ C0449(SafeAccService r2) {
        }

        public void onReceive(Context context, Intent intent) {
            boolean unused = SafeAccService.this.f612 = !"android.intent.action.SCREEN_OFF".equals(intent.getAction());
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                long unused2 = SafeAccService.this.f613 = SystemClock.elapsedRealtime();
            }
        }
    }

    public SafeAccService() {
        SystemClock.elapsedRealtime();
        this.f614 = new C1308(this);
    }

    /* renamed from: ނ */
    public static /* synthetic */ void m754(SafeAccService safeAccService) {
        safeAccService.f608 = 0;
        HandlerThread handlerThread = safeAccService.f605;
        String eventTypeToString = safeAccService.f609 == 0 ? "0" : AccessibilityEvent.eventTypeToString(safeAccService.f609);
        HashMap hashMap = new HashMap();
        hashMap.put("app", safeAccService.getPackageName());
        hashMap.put("ver", String.valueOf(AppUtils.m1158()));
        hashMap.put("device", C0719.m1816());
        hashMap.put("evt", eventTypeToString);
        if (safeAccService.f605 != null) {
            String r1 = AppUtils.m1142((Thread) handlerThread);
            if (r1.length() > 200) {
                hashMap.put("stack", r1.substring(0, 200) + "...");
            } else {
                hashMap.put("stack", r1);
            }
        }
        StatisticsManager.m733(NotificationCompat.CATEGORY_ERROR, "acc_restart", hashMap);
        safeAccService.mo7813();
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public final void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Handler handler = this.f606;
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 604;
        obtainMessage.obj = AccessibilityEvent.obtain(accessibilityEvent);
        handler.sendMessage(obtainMessage);
    }

    public void onCreate() {
        super.onCreate();
        this.f604 = AnalyticsConstants.f108k;
        this.f612 = SystemUtils.m3531();
        this.f611 = new C0449((SafeAccService) null);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.f611, intentFilter);
        mo7813();
        new Thread(this.f614).start();
    }

    public void onDestroy() {
        this.f607 = false;
        super.onDestroy();
        unregisterReceiver(this.f611);
        HandlerThread handlerThread = this.f605;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    /* renamed from: ֏ */
    public abstract void mo7724(AccessibilityEvent accessibilityEvent);

    /* renamed from: ؠ */
    public final void mo7814(AccessibilityEvent accessibilityEvent) {
        this.f608 = SystemClock.elapsedRealtime();
        this.f609 = accessibilityEvent.getEventType();
        try {
            super.onAccessibilityEvent(accessibilityEvent);
            mo7724(accessibilityEvent);
        } finally {
            this.f608 = 0;
            this.f609 = 0;
            try {
                accessibilityEvent.recycle();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: ֏ */
    public final void mo7813() {
        StringBuilder r1 = outline.m2549("SafeAccService-");
        r1.append(this.f610);
        this.f605 = new C1076(r1.toString(), 10);
        this.f610++;
        this.f605.start();
        this.f606 = new SafeAccService(this, this.f605.getLooper());
    }
}
