package com.wpengapp.support;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.ActivityChooserModel;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.wpengapp.support.Ż */
public final class AppUtils {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: ֏ */
    public static Application application = null;

    /* renamed from: ؠ */
    public static String f897 = null;

    /* renamed from: ހ */
    public static boolean f898 = true;

    /* renamed from: ށ */
    public static Handler f899 = m1171();

    /* renamed from: ނ */
    public static WeakReference<Activity> f900;

    /* renamed from: ރ */
    public static String f901;

    /* renamed from: ބ */
    public static final WeakHashMap<Activity, Object> f902 = new WeakHashMap<>();

    /* renamed from: ޅ */
    public static WeakHashMap<Activity, WeakHashMap<C0503, Object>> activityMaps;

    /* renamed from: com.wpengapp.support.Ż$֏ */
    /* compiled from: AppUtils */
    public static class C0503 {
        /* renamed from: ֏ */
        public void mo8042() {
        }

        /* renamed from: ֏ */
        public void mo8043(Bundle bundle) {
        }

        /* renamed from: ؠ */
        public void mo8044() {
        }

        /* renamed from: ؠ */
        public void mo8045(Bundle bundle) {
        }

        /* renamed from: ހ */
        public void mo8046() {
        }

        /* renamed from: ށ */
        public void mo8047() {
        }

        /* renamed from: ނ */
        public void mo8048() {
        }
    }

    /* renamed from: ֏ */
    public static void init(Application application) {
        AppUtils.application = application;
        if (application == null) {
            getApplication();
        }
        if (activityMaps == null) {
            synchronized (AppUtils.class) {
                if (activityMaps == null) {
                    activityMaps = new WeakHashMap<>();
                    getApplication().registerActivityLifecycleCallbacks(new MyActivityLifecycleCallbacks());
                }
            }
        }
    }

    /* renamed from: ؠ */
    public static synchronized void removeActivity(Activity activity) {
        synchronized (AppUtils.class) {
            if (activityMaps != null) {
                activityMaps.remove(activity);
            }
        }
    }

    /* renamed from: ހ */
    public static void m1155(Runnable runnable) {
        if (runnable != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                m1146(runnable);
            }
        }
    }

    /* renamed from: ށ */
    public static boolean m1157(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return m1169();
        }
        if (str.startsWith(":")) {
            str2 = m1163() + str;
        } else {
            str2 = m1163() + ":" + str;
        }
        return str2.equals(m1165());
    }

    /* renamed from: ނ */
    public static int m1158() {
        return m1140(m1163());
    }

    /* renamed from: ރ */
    public static String m1159() {
        try {
            return getApplication().getPackageManager().getPackageInfo(m1163(), 0).versionName;
        } catch (Exception unused) {
            return BidiFormatter.EMPTY_STRING;
        }
    }

    @NonNull
    /* renamed from: ބ */
    public static Application getApplication() {
        if (application == null) {
            try {
                application = (Application) Reflect.forName("android.app.ActivityThread").getMethod("currentApplication").cls;
            } catch (Exception e) {
                e.getMessage();
            }
            if (application == null) {
                try {
                    application = (Application) new Reflect(m1150()).getFeild("mInitialApplication");
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        return application;
    }

    /* renamed from: ޅ */
    public static Context m1161() {
        Activity r0 = m1168();
        return r0 == null ? getApplication() : r0;
    }

    /* renamed from: ކ */
    public static long m1162() {
        try {
            return getApplication().getPackageManager().getPackageInfo(m1163(), 0).firstInstallTime;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: އ */
    public static String m1163() {
        return getApplication().getPackageName();
    }

    /* renamed from: ވ */
    public static int m1164() {
        try {
            return getApplication().getPackageManager().getApplicationInfo(m1163(), 0).uid;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cb  */
    /* renamed from: މ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m1165() {
        String r0 = f897;
        if (!TextUtils.isEmpty(r0)) {
            return r0;
        } else {
            r0 = "android.app.ActivityThread";
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
                final Reflect currentProcessName = Reflect.forName(r0).getMethod("currentProcessName");
                currentProcessName.cls
            } else {
                r0 = android.app.Application.getProcessName();
                f897 = r0;
                if (TextUtils.isEmpty(r0)) {
                    final StringBuilder builder = new StringBuilder();
                    builder.append("/proc/");
                    builder.append(android.os.Process.myPid() + "");
                    builder.append("/cmdline");
                    try {
                        final FileReader fileReader = new FileReader(builder.toString());
                        final BufferedReader bufferedReader = new BufferedReader(fileReader);
                        final String s = bufferedReader.readLine().replace("\n", "").trim();
                        FileUtils.close(bufferedReader);
                        if (TextUtils.isEmpty(s)) {
                            f897 = s;
                            if (TextUtils.isEmpty(s)) {
                                f898
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /*
            java.lang.String r0 = f897
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = f897
            return r0
        L_0x000b:
            java.lang.String r0 = "android.app.ActivityThread"
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ ؠ -> 0x0029 }
            r3 = 28
            if (r2 < r3) goto L_0x0019
            java.lang.String r0 = android.app.Application.getProcessName()     // Catch:{ ؠ -> 0x0029 }
            goto L_0x0046
        L_0x0019:
            com.wpengapp.support.Ⴉ r2 = com.wpengapp.support.Reflect.m3536(r0)     // Catch:{ ؠ -> 0x0029 }
            java.lang.String r3 = "currentProcessName"
            com.wpengapp.support.Ⴉ r2 = r2.mo9561((java.lang.String) r3)     // Catch:{ ؠ -> 0x0029 }
            java.lang.Object r2 = r2.f3714     // Catch:{ ؠ -> 0x0029 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ ؠ -> 0x0029 }
            r0 = r2
            goto L_0x0046
        L_0x0029:
            r2 = move-exception
            r2.getMessage()
            com.wpengapp.support.Ⴉ r0 = com.wpengapp.support.Reflect.m3536(r0)     // Catch:{ ؠ -> 0x0042 }
            java.lang.String r3 = "currentActivityThread"
            com.wpengapp.support.Ⴉ r0 = r0.mo9561((java.lang.String) r3)     // Catch:{ ؠ -> 0x0042 }
            java.lang.String r3 = "getProcessName"
            com.wpengapp.support.Ⴉ r0 = r0.mo9561((java.lang.String) r3)     // Catch:{ ؠ -> 0x0042 }
            java.lang.Object r0 = r0.f3714     // Catch:{ ؠ -> 0x0042 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ؠ -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r2.getMessage()
            r0 = r1
        L_0x0046:
            f897 = r0
            java.lang.String r0 = f897
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00d9
            int r0 = android.os.Process.myPid()
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3.<init>()     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3.append(r0)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.lang.String r4 = "/cmdline"
            r3.append(r4)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.lang.String r2 = r3.readLine()     // Catch:{ Exception -> 0x008d }
            java.lang.String r4 = "\n"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.replace(r4, r5)     // Catch:{ Exception -> 0x008d }
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x008d }
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r3)
            goto L_0x009a
        L_0x008d:
            r2 = move-exception
            goto L_0x0093
        L_0x008f:
            r0 = move-exception
            goto L_0x00d5
        L_0x0091:
            r2 = move-exception
            r3 = r1
        L_0x0093:
            r2.getMessage()     // Catch:{ all -> 0x00d3 }
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r3)
            r2 = r1
        L_0x009a:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x00c1
            java.util.List r2 = m1167()
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x00c0
            java.util.Iterator r2 = r2.iterator()
        L_0x00ae:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00c0
            java.lang.Object r3 = r2.next()
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3
            int r4 = r3.pid
            if (r4 != r0) goto L_0x00ae
            java.lang.String r1 = r3.processName
        L_0x00c0:
            r2 = r1
        L_0x00c1:
            f897 = r2
            java.lang.String r0 = f897
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00d9
            r0 = 1
            f898 = r0
            java.lang.String r0 = m1163()
            return r0
        L_0x00d3:
            r0 = move-exception
            r1 = r3
        L_0x00d5:
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r1)
            throw r0
        L_0x00d9:
            java.lang.String r0 = m1163()
            java.lang.String r1 = f897
            boolean r0 = r0.equals(r1)
            f898 = r0
            java.lang.String r0 = f897
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.AppUtils.m1165():java.lang.String");
    }

    /* renamed from: ފ */
    public static String m1166() {
        String r0 = m1165();
        int lastIndexOf = r0.lastIndexOf(":");
        if (lastIndexOf < 0) {
            return BidiFormatter.EMPTY_STRING;
        }
        return r0.substring(lastIndexOf + 1);
    }

    /* renamed from: ދ */
    public static List<ActivityManager.RunningAppProcessInfo> m1167() {
        ActivityManager activityManager = (ActivityManager) getApplication().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activityManager == null) {
            return new ArrayList();
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        return runningAppProcesses == null ? new ArrayList() : runningAppProcesses;
    }

    /* renamed from: ތ */
    public static Activity m1168() {
        Activity activity;
        WeakReference<Activity> weakReference = f900;
        if (weakReference != null && (activity = (Activity) weakReference.get()) != null) {
            return activity;
        }
        Set<Activity> r0 = m1156();
        if (r0.isEmpty()) {
            return null;
        }
        for (Activity next : r0) {
            boolean z = false;
            try {
                z = ((Boolean) new Reflect((Object) next).getMethod("isResumed").cls).booleanValue();
                continue;
            } catch (Exception e) {
                e.getMessage();
                continue;
            }
            if (z) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: ލ */
    public static boolean m1169() {
        if (TextUtils.isEmpty(f897)) {
            m1165();
        }
        return f898;
    }

    /* renamed from: ގ */
    public static boolean m1170() {
        for (ActivityManager.RunningAppProcessInfo next : m1167()) {
            if (next.processName.equals(m1163())) {
                if (next.importance == 100) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: ޏ */
    public static Handler m1171() {
        return new Handler(Looper.getMainLooper());
    }

    /* renamed from: ހ */
    public static Set<Activity> m1154() {
        if (activityMaps != null) {
            return new HashSet(f902.keySet());
        }
        return m1156();
    }

    /* renamed from: ؠ */
    public static void m1152(Runnable runnable) {
        if (runnable != null) {
            f899.removeCallbacks(runnable);
        }
    }

    /* renamed from: ؠ */
    public static Object m1150() {
        try {
            return Reflect.forName("android.app.ActivityThread").getMethod("currentActivityThread").cls;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ހ */
    public static <T> T m1153(String str) {
        return getApplication().getSystemService(str);
    }

    /* renamed from: ށ */
    public static Set<Activity> m1156() {
        HashSet hashSet = new HashSet();
        try {
            Collection<Object> values = ((Map) new Reflect(m1150()).getFeild("mActivities")).values();
            if (values.size() == 0) {
                return hashSet;
            }
            for (Object r2 : values) {
                hashSet.add((Activity) new Reflect(r2).getFeild(ActivityChooserModel.ATTRIBUTE_ACTIVITY));
            }
            return hashSet;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ Set m1143(Activity activity) {
        WeakHashMap<Activity, WeakHashMap<C0503, Object>> weakHashMap = activityMaps;
        if (weakHashMap == null || activity == null) {
            return Collections.emptySet();
        }
        WeakHashMap weakHashMap2 = weakHashMap.get(activity);
        if (weakHashMap2 != null) {
            return new HashSet(weakHashMap2.keySet());
        }
        return Collections.emptySet();
    }

    /* renamed from: ؠ */
    public static SharedPreferences m1149(String str) {
        return getApplication().getSharedPreferences(str, 0);
    }

    /* renamed from: ֏ */
    public static void m1146(Runnable runnable) {
        if (runnable != null) {
            f899.post(runnable);
        }
    }

    /* renamed from: ֏ */
    public static void m1147(Runnable runnable, long j) {
        if (runnable != null) {
            f899.postDelayed(runnable, j);
        }
    }

    /* renamed from: ֏ */
    public static int m1140(String str) {
        try {
            return getApplication().getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: ֏ */
    public static void m1144() {
        m1146((Runnable) new C0698());
    }

    /* renamed from: ֏ */
    public static String m1141(int i, Object... objArr) {
        return getApplication().getString(i, objArr);
    }

    @RequiresApi(api = 21)
    /* renamed from: ֏ */
    public static boolean m1148(boolean z, Integer num) {
        int i;
        try {
            List<ActivityManager.AppTask> appTasks = ((ActivityManager) m1153(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getAppTasks();
            if (CollectionUtils.m1657((Collection) appTasks)) {
                return false;
            }
            for (ActivityManager.AppTask next : appTasks) {
                if (num != null) {
                    int intValue = num.intValue();
                    ActivityManager.RecentTaskInfo taskInfo = next.getTaskInfo();
                    if (Build.VERSION.SDK_INT >= 29) {
                        i = taskInfo.taskId;
                    } else {
                        i = taskInfo.id;
                    }
                    if (intValue != i) {
                    }
                }
                next.setExcludeFromRecents(z);
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: ֏ */
    public static String m1142(Thread thread) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement append : thread.getStackTrace()) {
            sb.append("\nat ");
            sb.append(append);
        }
        return sb.toString();
    }
}
