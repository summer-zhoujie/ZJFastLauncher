package com.wpengapp.support;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.wpengapp.ipc.IPCReceiver;

/* renamed from: com.wpengapp.support.ߥ */
/* compiled from: Remote */
public class C0983 {

    /* renamed from: ֏ */
    public static volatile MainServiceProxy f2753;

    /* renamed from: ؠ */
    public static String f2754;

    /* renamed from: ހ */
    public static Runnable f2755;

    /* renamed from: ށ */
    public static Handler f2756;

    /* renamed from: ނ */
    public static String f2757;

    /* renamed from: ֏ */
    public static void m2613(Application application, String str, Runnable runnable) {
        f2757 = str;
        f2755 = runnable;
        IPCManager.m1686(application);
        f2754 = application.getPackageName() + ".xpsdk" + Process.myPid();
        IPCManager.m1687((IPCReceiver) new C0963(f2754));
        HandlerThread handlerThread = new HandlerThread("WXPS/SDK");
        handlerThread.start();
        f2756 = new Handler(handlerThread.getLooper());
        f2756.postDelayed(new C0681(), 180000);
        application.registerReceiver(new C0873(), new IntentFilter("com.wpengapp.xposed.0l0al1s"));
    }

    /* renamed from: ؠ */
    public static IMainService m2614() {
        return m2612((byte[]) null);
    }

    /* renamed from: ހ */
    public static String m2615() {
        if (TextUtils.isEmpty(f2757)) {
            return "com.android.systemui";
        }
        return f2757;
    }

    /* renamed from: ށ */
    public static void m2616() {
        m2618();
        f2756.post(f2755);
    }

    /* renamed from: ނ */
    public static /* synthetic */ void m2617() {
        m2618();
        f2756.post(f2755);
    }

    /* renamed from: ރ */
    public static void m2618() {
        synchronized (C0983.class) {
            f2753 = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(3:5|6|7)|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0021 */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.wpengapp.support.PluginRunningInfo m2611() {
        /*
            com.wpengapp.support.Ž r0 = new com.wpengapp.support.Ž
            r0.<init>()
            java.lang.String r1 = m2615()
            com.wpengapp.support.Ć r2 = new com.wpengapp.support.Ć
            java.lang.String r3 = f2754
            r2.<init>(r3, r0)
            r3 = 0
            java.lang.String r4 = "com.wpengapp.xposed.0l0als"
            r5 = 1
            com.wpengapp.support.IPCManager.m1690(r4, r1, r5, r3, r2)
            monitor-enter(r0)
            int r1 = r0.f905     // Catch:{ all -> 0x0023 }
            if (r1 > 0) goto L_0x0021
            r1 = 5000(0x1388, double:2.4703E-320)
            r0.wait(r1)     // Catch:{ InterruptedException -> 0x0021 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return r0
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0983.m2611():com.wpengapp.support.Ž");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|(3:(1:19)(1:20)|21|22)|23|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:28|29|30|31|32) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0070, code lost:
        com.wpengapp.support.outline.m2552("getService ", (java.lang.Object) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0075, code lost:
        return r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006d */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.wpengapp.support.MainServiceProxy m2612(byte[] r9) {
        /*
            com.wpengapp.support.Վ r0 = f2753
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            java.lang.Class<com.wpengapp.support.ߥ> r1 = com.wpengapp.support.C0983.class
            monitor-enter(r1)
            com.wpengapp.support.Վ r2 = f2753     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0013
            monitor-exit(r1)     // Catch:{ all -> 0x0079 }
            return r2
        L_0x0013:
            r2 = 0
            f2753 = r2     // Catch:{ all -> 0x0079 }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0079 }
            r3.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = "plsid"
            r5 = 10003(0x2713, float:1.4017E-41)
            r3.putInt(r4, r5)     // Catch:{ all -> 0x0079 }
            if (r9 == 0) goto L_0x0029
            java.lang.String r4 = "plsdt"
            r3.putByteArray(r4, r9)     // Catch:{ all -> 0x0079 }
        L_0x0029:
            java.lang.String r4 = m2615()     // Catch:{ all -> 0x0079 }
            java.lang.String r5 = "com.wpengapp.xposed.0l0als"
            r6 = 2
            com.wpengapp.support.Ē r7 = new com.wpengapp.support.Ē     // Catch:{ all -> 0x0079 }
            java.lang.String r8 = f2754     // Catch:{ all -> 0x0079 }
            r7.<init>(r8, r0)     // Catch:{ all -> 0x0079 }
            com.wpengapp.support.IPCManager.m1690(r5, r4, r6, r3, r7)     // Catch:{ all -> 0x0079 }
            monitor-enter(r0)     // Catch:{ all -> 0x0079 }
            java.lang.Object r3 = r0.get()     // Catch:{ all -> 0x0076 }
            if (r3 != 0) goto L_0x004b
            if (r9 != 0) goto L_0x0046
            r3 = 5000(0x1388, double:2.4703E-320)
            goto L_0x0048
        L_0x0046:
            r3 = 10000(0x2710, double:4.9407E-320)
        L_0x0048:
            r0.wait(r3)     // Catch:{ InterruptedException -> 0x004b }
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            java.lang.Object r9 = r0.get()     // Catch:{ all -> 0x0079 }
            if (r9 == 0) goto L_0x006f
            com.wpengapp.support.Վ r2 = new com.wpengapp.support.Վ     // Catch:{ all -> 0x0079 }
            java.lang.Object r9 = r0.get()     // Catch:{ all -> 0x0079 }
            android.os.IBinder r9 = (android.os.IBinder) r9     // Catch:{ all -> 0x0079 }
            com.wpengapp.support.ʗ r9 = com.wpengapp.support.IMainService.C0598.m1480(r9)     // Catch:{ all -> 0x0079 }
            r2.<init>(r9)     // Catch:{ all -> 0x0079 }
            com.wpengapp.support.ʗ r9 = r2.f2051     // Catch:{ RemoteException -> 0x006d }
            android.os.IBinder r9 = r9.asBinder()     // Catch:{ RemoteException -> 0x006d }
            com.wpengapp.support.Α r0 = com.wpengapp.support.C0633.f1610     // Catch:{ RemoteException -> 0x006d }
            r3 = 0
            r9.linkToDeath(r0, r3)     // Catch:{ RemoteException -> 0x006d }
        L_0x006d:
            f2753 = r2     // Catch:{ all -> 0x0079 }
        L_0x006f:
            monitor-exit(r1)     // Catch:{ all -> 0x0079 }
            java.lang.String r9 = "getService "
            com.wpengapp.support.outline.m2552((java.lang.String) r9, (java.lang.Object) r2)
            return r2
        L_0x0076:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            throw r9     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0079 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0983.m2612(byte[]):com.wpengapp.support.Վ");
    }
}
