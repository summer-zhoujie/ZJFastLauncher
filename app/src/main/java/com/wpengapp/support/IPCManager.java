package com.wpengapp.support;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.support.p003v7.widget.TooltipCompatHandler;
import android.text.TextUtils;
import com.wpengapp.ipc.IPCReceiver;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.wpengapp.support.τ */
public class IPCManager {

    /* renamed from: ֏ */
    public static final Object f1696 = new Object();

    /* renamed from: ؠ */
    public static Application f1697;

    /* renamed from: ހ */
    public static AtomicInteger f1698;

    /* renamed from: ށ */
    public static ConcurrentHashMap<Integer, C0655> f1699;

    /* renamed from: ނ */
    public static HandlerThread f1700;

    /* renamed from: ރ */
    public static Handler f1701;

    /* renamed from: ބ */
    public static HandlerThread f1702;

    /* renamed from: ޅ */
    public static Handler f1703;

    /* renamed from: com.wpengapp.support.τ$֏ */
    /* compiled from: IPCManager */
    private static class C0655 extends IPCCallback {

        /* renamed from: ؠ */
        public IPCCallback f1704;

        /* renamed from: ހ */
        public Runnable f1705;

        /* renamed from: ށ */
        public AtomicBoolean f1706 = new AtomicBoolean(false);

        public C0655(int i, IPCCallback r3) {
            super(r3.f1343);
            this.f1704 = r3;
            this.f1705 = new C0900(this, i);
        }

        /* renamed from: ֏ */
        public void mo7910(Bundle bundle, boolean z) {
            Handler handler;
            if (this.f1706.compareAndSet(false, true) && (handler = IPCManager.f1701) != null && !handler.post(new C0971(this, bundle, z))) {
                try {
                    this.f1704.mo7910(bundle, z);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }

    static {
        Process.myPid();
    }

    /* renamed from: ֏ */
    public static void m1686(Application application) {
        synchronized (f1696) {
            if (f1700 != null) {
                m1685();
            }
            try {
                f1697 = application;
                f1699 = new ConcurrentHashMap<>();
                f1698 = new AtomicInteger(0);
                f1700 = new HandlerThread("IPCManager");
                f1700.start();
                f1701 = new Handler(f1700.getLooper());
                f1702 = new HandlerThread("IPCManager_Receiver");
                f1702.start();
                f1703 = new Handler(f1702.getLooper());
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: ֏ */
    public static void m1685() {
        synchronized (f1696) {
            try {
                if (f1700 == null) {
                    f1697 = null;
                    f1701 = null;
                    f1700 = null;
                    f1703 = null;
                    f1702 = null;
                    f1699 = null;
                    f1698 = null;
                    return;
                }
                f1703.removeCallbacksAndMessages((Object) null);
                f1702.quit();
                f1701.removeCallbacksAndMessages((Object) null);
                f1700.quit();
                for (C0655 next : f1699.values()) {
                    if (next != null) {
                        try {
                            next.mo7910((Bundle) null, true);
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                }
                f1699.clear();
                f1697 = null;
                f1701 = null;
                f1700 = null;
                f1703 = null;
                f1702 = null;
                f1699 = null;
                f1698 = null;
            } catch (Exception e2) {
                try {
                    e2.getMessage();
                    f1697 = null;
                    f1701 = null;
                    f1700 = null;
                    f1703 = null;
                    f1702 = null;
                    f1699 = null;
                } catch (Throwable th) {
                    f1697 = null;
                    f1701 = null;
                    f1700 = null;
                    f1703 = null;
                    f1702 = null;
                    f1699 = null;
                    f1698 = null;
                    throw th;
                }
            }
        }
    }

    /* renamed from: ֏ */
    public static void m1687(IPCReceiver iPCReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(iPCReceiver.f406);
        f1697.registerReceiver(iPCReceiver, intentFilter, (String) null, f1703);
    }

    /* renamed from: ֏ */
    public static void m1690(String str, String str2, int i, Bundle bundle, IPCCallback r9) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            int incrementAndGet = f1698.incrementAndGet();
            if (r9 != null) {
                C0655 r1 = new C0655(incrementAndGet, r9);
                f1699.put(Integer.valueOf(incrementAndGet), r1);
                f1701.postDelayed(r1.f1705, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_SHORT_MS);
            }
            Intent intent = new Intent(str);
            intent.setPackage(str2);
            intent.putExtra(".OO0O0O00.EXTRA_WHAT", i);
            intent.putExtra(".OO0O0O00.EXTRA_PARAMS", bundle);
            intent.putExtra(".OO0O0O00.EXTRA_SENDER_PKG", f1697.getPackageName());
            intent.putExtra(".OO0O0O00.EXTRA_MSG_ID", incrementAndGet);
            if (r9 == null) {
                str3 = null;
            } else {
                str3 = r9.f1343;
            }
            intent.putExtra(".OO0O0O00.EXTRA_SENDER_ACTION", str3);
            intent.putExtra(".OO0O0O00.EXTRA_NEED_CALLBACK", r9 != null);
            f1697.sendBroadcast(intent);
            return;
        }
        throw new RuntimeException("targetAction must nonnull");
    }

    /* renamed from: ֏ */
    public static void m1688(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str2)) {
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            intent.putExtra(".OO0O0O00.EXTRA_OK_MSG", true);
            intent.putExtra(".OO0O0O00.EXTRA_MSG_ID", i);
            f1697.sendBroadcast(intent);
        }
    }

    /* renamed from: ֏ */
    public static void m1689(String str, String str2, int i, Bundle bundle) {
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        intent.putExtra(".OO0O0O00.EXTRA_CALLBACK_MSG", true);
        intent.putExtra(".OO0O0O00.EXTRA_MSG_ID", i);
        intent.putExtra(".OO0O0O00.EXTRA_PARAMS", bundle);
        f1697.sendBroadcast(intent);
    }
}
