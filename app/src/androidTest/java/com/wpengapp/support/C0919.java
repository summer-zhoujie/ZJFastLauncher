package com.wpengapp.support;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.p003v7.widget.TooltipCompatHandler;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.util.Base64;
import com.wpengapp.lightstart.service.AccService;
import com.wpengapp.lightstart.service.AccService24;
import com.wpengapp.xposed.sdk.BootService;
import java.io.File;

/* renamed from: com.wpengapp.support.ܘ */
/* compiled from: EngineManager */
public class C0919 {

    /* renamed from: ֏ */
    public static final SP<Integer> f2488 = new IntSP("ENGINE", 0);

    /* renamed from: ؠ */
    public static final RemoteMethod f2489 = new EngineManager("ENGM");

    /* renamed from: com.wpengapp.support.ܘ$֏ */
    /* compiled from: EngineManager */
    private static class C0920 implements StatCallback {
        public /* synthetic */ C0920(EngineManager r1) {
        }

        /* renamed from: ֏ */
        public void mo7963(int i) {
            UMengManager.m1405("xp_status2", String.valueOf(i));
        }

        /* renamed from: ؠ */
        public void mo7967(boolean z) {
            UMengManager.m1405("xp_openacc", String.valueOf(z));
        }

        /* renamed from: ֏ */
        public void mo7966(boolean z, int i, long j, String str) {
            C0471.m1020(z, i, j, str);
        }

        /* renamed from: ֏ */
        public void mo7965(boolean z) {
            UMengManager.m1405("xp_restore", String.valueOf(z));
        }

        /* renamed from: ֏ */
        public void mo7964(String str, String str2) {
            C0471.m1023(str, str2);
        }

        /* renamed from: ֏ */
        public void mo7962() {
            C0471.m1012();
        }
    }

    /* renamed from: ֏ */
    public static int m2416() {
        int intValue = f2488.mo8104().intValue();
        if (intValue != 1 || Build.VERSION.SDK_INT >= 24) {
            return intValue;
        }
        return 0;
    }

    /* renamed from: ֏ */
    public static boolean m2419(int i, int i2) {
        if (i == i2) {
            return false;
        }
        return i == 1 || i2 == 1;
    }

    /* renamed from: ؠ */
    public static int m2420() {
        int r0 = m2416();
        if (r0 == 2) {
            return r0;
        }
        boolean r2 = AccServiceHelper.m2016(AccService.class);
        if (r2 == AccServiceHelper.m2016(AccService24.class)) {
            return r0;
        }
        if (r2) {
            return 0;
        }
        return 1;
    }

    /* renamed from: ހ */
    public static void m2423() {
        SystemApi.m2046(AppUtils.getApplication());
        SystemApi.f1981 = new C0920((EngineManager) null);
        if (C1146.m3072()) {
            f2489.mo8565();
            TaskManager.m2715((Runnable) C0504.f908);
            AppUtils.m1147((Runnable) C0596.f1338, 7200000);
        }
    }

    /* renamed from: ށ */
    public static boolean m2424() {
        boolean z = false;
        for (int i = 0; i < 3 && !(z = SystemApi.m2048()); i++) {
            try {
                Thread.sleep(TooltipCompatHandler.HOVER_HIDE_TIMEOUT_SHORT_MS);
            } catch (InterruptedException unused) {
            }
        }
        if (!z) {
            return false;
        }
        if (m2416() == 2) {
            String packageName = SystemApi.f1979.getPackageName();
            String name = BootService.class.getName();
            Intent intent = new Intent();
            intent.setClassName(packageName, name);
            SystemApi.m2045(0, intent);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException unused2) {
        }
        m2427();
        return true;
    }

    /* renamed from: ނ */
    public static /* synthetic */ void m2425() {
        if (m2416() == 2) {
            m2424();
        }
    }

    /* renamed from: ރ */
    public static /* synthetic */ void m2426() {
        try {
            String[] list = new File(AppUtils.getApplication().getApplicationInfo().nativeLibraryDir).list();
            if (list != null) {
                int i = 0;
                String str = new String(Base64.decode(C0678.f1768, 0), "UTF-8");
                String str2 = new String(Base64.decode(C0678.f1769, 0), "UTF-8");
                int length = list.length;
                while (i < length) {
                    String str3 = list[i];
                    if (!str3.toLowerCase().contains(str)) {
                        if (!str3.toLowerCase().contains(str2)) {
                            i++;
                        }
                    }
                    C1149.m3087();
                    C0909.m2388();
                    C0536.m1311("8");
                    return;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ބ */
    public static void m2427() {
        if (!AccServiceHelper.m2016(AccService.class, AccService24.class)) {
            SystemApi.m2049(AppUtils.getApplication(), AppUtils.m1163(), (m2416() == 1 ? AccService24.class : AccService.class).getName());
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2417(int i) {
        if (i == 0 || i == 2) {
            m2422(AccService.class);
            m2418(AccService24.class);
            return;
        }
        m2422(AccService24.class);
        m2418(AccService.class);
    }

    /* renamed from: ؠ */
    public static void m2421(int i, int i2) {
        "switchEngine " + i2;
        if (i2 != 1 || Build.VERSION.SDK_INT >= 24) {
            f2488.mo8106(Integer.valueOf(i2));
            if (i == 1 || i2 == 1) {
                f2489.mo8564("stsc");
                AppUtils.m1147((Runnable) new C1246(i2), (long) ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
                return;
            }
            f2489.mo8564(i2 == 2 ? "htshxp" : "htshnl");
        }
    }

    /* renamed from: ֏ */
    public static void m2418(Class cls) {
        AppUtils.getApplication().getPackageManager().setComponentEnabledSetting(new ComponentName(AppUtils.getApplication(), cls), 2, 1);
    }

    /* renamed from: ؠ */
    public static void m2422(Class cls) {
        PackageManager packageManager = AppUtils.getApplication().getPackageManager();
        ComponentName componentName = new ComponentName(AppUtils.getApplication(), cls);
        if (packageManager.getComponentEnabledSetting(componentName) != 1) {
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }
}
