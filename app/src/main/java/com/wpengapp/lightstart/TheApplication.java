package com.wpengapp.lightstart;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.text.BidiFormatter;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.wpengapp.http.RequestHelper;
import com.wpengapp.lightstart.activity.MainActivity;
import com.wpengapp.lightstart.service.AccService;
import com.wpengapp.lightstart.service.AccService24;
import com.wpengapp.support.ActivityKiller;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.AutoLoginConfig;
import com.wpengapp.support.BaseApplication;
import com.wpengapp.support.C0514;
import com.wpengapp.support.C0520;
import com.wpengapp.support.C0536;
import com.wpengapp.support.C0541;
import com.wpengapp.support.C0623;
import com.wpengapp.support.C0632;
import com.wpengapp.support.C0639;
import com.wpengapp.support.C0665;
import com.wpengapp.support.C0669;
import com.wpengapp.support.C0678;
import com.wpengapp.support.C0682;
import com.wpengapp.support.C0719;
import com.wpengapp.support.C0728;
import com.wpengapp.support.C0813;
import com.wpengapp.support.C0818;
import com.wpengapp.support.C0824;
import com.wpengapp.support.C0841;
import com.wpengapp.support.C0844;
import com.wpengapp.support.C0881;
import com.wpengapp.support.C0885;
import com.wpengapp.support.C0901;
import com.wpengapp.support.C0909;
import com.wpengapp.support.C0919;
import com.wpengapp.support.C0975;
import com.wpengapp.support.C1004;
import com.wpengapp.support.C1057;
import com.wpengapp.support.C1063;
import com.wpengapp.support.C1099;
import com.wpengapp.support.C1110;
import com.wpengapp.support.C1146;
import com.wpengapp.support.C1149;
import com.wpengapp.support.C1275;
import com.wpengapp.support.C1279;
import com.wpengapp.support.C1323;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.CrashHandler;
import com.wpengapp.support.CustomAppConfig;
import com.wpengapp.support.CustomConfig;
import com.wpengapp.support.CustomPageConfig;
import com.wpengapp.support.DevHelper;
import com.wpengapp.support.GsonUtil;
import com.wpengapp.support.MiadManager;
import com.wpengapp.support.RemoteSP;
import com.wpengapp.support.SP;
import com.wpengapp.support.SSLContextFactory;
import com.wpengapp.support.SimpleX509TrustManager;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.StatisticsManager;
import com.wpengapp.support.SystemApi;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.TheBackupHandler;
import com.wpengapp.support.TrustedHostnameVerifier;
import com.wpengapp.support.UMengManager;
import com.wpengapp.support.UpdateHelper;
import com.wpengapp.support.UserInfo;
import com.wpengapp.support.Utils;
import com.wpengapp.support.ValCallback;
import com.wpengapp.support.WPengServer;
import com.wpengapp.support.activity.AboutActivity;
import com.wpengapp.support.activity.LauncherActivity;
import com.wpengapp.support.activity.WechatSubscriptionActivity;
import com.wpengapp.support.outline;
import com.wpengapp.support.permission.ServicePermissionActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;

public class TheApplication extends BaseApplication {

    /* renamed from: com.wpengapp.lightstart.TheApplication$֏ */
    private static class C0434 extends AboutActivity.C0450 {
        public /* synthetic */ C0434(TheApplication r1) {
        }

        /* renamed from: ֏ */
        public List<File> mo7558() {
            try {
                ArrayList arrayList = new ArrayList();
                String r1 = SystemApi.m2054();
                if (!TextUtils.isEmpty(r1)) {
                    arrayList.addAll(Arrays.asList(new File(r1).listFiles()));
                }
                String r12 = SystemApi.m2055();
                if (!TextUtils.isEmpty(r12)) {
                    arrayList.addAll(Arrays.asList(new File(r12).listFiles()));
                }
                return arrayList;
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: ؠ */
        public Drawable mo7559() {
            return ContextCompat.getDrawable(AppUtils.getApplication(), R$mipmap.ic_launcher2);
        }

        /* renamed from: ހ */
        public String mo7560() {
            return AppUtils.m1141((int) R$string.pro_intro, new Object[0]);
        }

        /* renamed from: ށ */
        public String mo7561() {
            return C1063.m2859("qqgroup_lightstart", (String) null);
        }

        /* renamed from: ބ */
        public boolean mo7562() {
            return true;
        }
    }

    /* renamed from: com.wpengapp.lightstart.TheApplication$ؠ */
    private static class C0435 implements ValCallback<Void, Map<String, String>> {
        public C0435() {
        }

        /* renamed from: ֏ */
        public Object mo7563(Object obj) {
            int i;
            ArrayMap<String, AutoLoginConfig.C1256> arrayMap;
            Void voidR = (Void) obj;
            HashMap hashMap = new HashMap();
            hashMap.put("engine", String.valueOf(C0919.m2416()));
            hashMap.put("enable", String.valueOf(SpHandler.f1750.mo8104()));
            hashMap.put("status_notify", String.valueOf(SpHandler.f1758.mo8104()));
            hashMap.put("share_cfg", String.valueOf(SpHandler.f1759.mo8104()));
            boolean z = false;
            if (CollectionUtils.m1658((Map) C0909.m2390().f1747)) {
                i = 0;
            } else {
                i = 0;
                for (Map.Entry next : C0909.m2390().f1747.entrySet()) {
                    if (!CollectionUtils.m1658((Map) ((CustomAppConfig) next.getValue()).f2437)) {
                        for (Map.Entry<String, List<CustomPageConfig>> value : ((CustomAppConfig) next.getValue()).f2437.entrySet()) {
                            i += ((List) value.getValue()).size();
                        }
                    }
                }
            }
            hashMap.put("custom_rule_count", String.valueOf(i));
            AutoLoginConfig r0 = C1057.f3020.mo9612();
            if (r0 != null && (arrayMap = r0.f3551) != null) {
                Iterator<Map.Entry<String, AutoLoginConfig.C1256>> it = arrayMap.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry next2 = it.next();
                    if (next2.getValue() != null && ((AutoLoginConfig.C1256) next2.getValue()).f3554) {
                        z = true;
                        break;
                    }
                }
            }
            hashMap.put("active_auto_login", String.valueOf(z));
            if (MiadManager.m2214()) {
                hashMap.put("active_miui_model", String.valueOf(SpHandler.f1753.mo8104()));
            }
            hashMap.put("active_toast_record", String.valueOf(SpHandler.f1760.mo8104()));
            hashMap.put("active_notify_record", String.valueOf(SpHandler.f1763.mo8104()));
            return hashMap;
        }

        public /* synthetic */ C0435(TheApplication r1) {
        }
    }

    /* renamed from: މ */
    public static /* synthetic */ void m341() {
        WechatSubscriptionActivity.f660 = new Class[]{AccService.class, AccService24.class};
        if (WechatSubscriptionActivity.f660 != null && C1146.m3072()) {
            WechatSubscriptionActivity.f661.mo8565();
        }
    }

    /* renamed from: ފ */
    public static /* synthetic */ void m342() {
        C1279.f3606 = new TheBackupHandler();
        try {
            C1279.f3605 = RequestHelper.m333("RhDIl/v2jRFwKvGkA1VpyZYwb9eftBDTEC+hQChIJxHtuUmZw4wu0NWquk/iYSv2VfKTqRDx4Xv649dJrto2vqNpW/vTGXqBl/b0VMXhjoEFHTiIrh95L1J8rdK+POZdub4QAnalBW7Sv1Rra4lITQmFVQ9uOEaY2OR6sLEGOAY=");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ދ */
    public static void m343() {
        SpHandler.f1751.mo8105(true);
        boolean z = false;
        SpHandler.f1752.mo8105(AppUtils.m1141((int) R$string.skip_anim_text, new Object[0]));
        SpHandler.f1753.mo8105(false);
        MiadManager.m2210(false);
        AutoLoginConfig r0 = C1057.f3020.mo9612();
        if (r0 != null) {
            r0.f3551 = null;
            C1057.m2852(r0);
        }
        T r02 = C0909.m2390();
        if (!CollectionUtils.m1658((Map) r02.f1747)) {
            int r4 = C1149.m3082();
            int i = 0;
            for (Map.Entry next : r02.f1747.entrySet()) {
                if (!CollectionUtils.m1658((Map) ((CustomAppConfig) next.getValue()).f2437)) {
                    for (Map.Entry<String, List<CustomPageConfig>> value : ((CustomAppConfig) next.getValue()).f2437.entrySet()) {
                        for (CustomPageConfig r9 : (List) value.getValue()) {
                            i++;
                            if (i > r4) {
                                r9.f2108 = false;
                                z = true;
                            }
                        }
                    }
                }
            }
            if (z) {
                C1323<CustomConfig> r2 = C0909.f2440;
                r2.f3785 = r02;
                r2.f3791 = true;
                outline.m2551((C1323) r2, (Object) r02);
            }
        }
        SpHandler.f1760.mo8105(false);
    }

    public void onCreate() {
        super.onCreate();
    }

    /* renamed from: ֏ */
    public boolean mo7555() {
        return true;
    }

    /* renamed from: ށ */
    public String[] mo7556() {
        return null;
    }

    /* renamed from: ޅ */
    public void mo7557() {
        long j;
        if (!SystemApi.m2050(AppUtils.m1166())) {
            C0444 r3 = mo7789(false, "201130170742");
            if (r3.mo7800()) {
                RemoteSP.m1203((Context) r3.f571);
                BaseApplication.this.mo7791("RemoteSP.init");
            }
            if (r3.mo7800()) {
                String r5 = Utils.m1901((Context) r3.f571);
                if ("WPeng".equals(r5)) {
                    BaseApplication.this.mo7790((Context) r3.f571);
                } else {
                    WPengServer.f851 = new C1004(r3);
                    Application application = r3.f571;
                    String str = BaseApplication.f563;
                    WPengServer.f836 = false;
                    WPengServer.f843 = "https://wpengapp.com";
                    WPengServer.f837 = application;
                    WPengServer.f842 = r5;
                    WPengServer.f839 = application.getPackageName();
                    WPengServer.f838 = AppUtils.m1140(application.getPackageName());
                    WPengServer.f840 = C0719.m1820();
                    WPengServer.f844 = str;
                    try {
                        C0844.C0845 r0 = new C0844.C0845();
                        r0.mo8745(20, TimeUnit.SECONDS);
                        r0.mo8749(20, TimeUnit.SECONDS);
                        r0.mo8750(20, TimeUnit.SECONDS);
                        if (C1279.f3604 == null) {
                            C1279.f3604 = new TrustedHostnameVerifier();
                        }
                        r0.mo8746(C1279.f3604);
                        r0.mo8747(SSLContextFactory.m3060().mo9335().getSocketFactory(), (X509TrustManager) new SimpleX509TrustManager());
                        C0844 r02 = r0.mo8748();
                        C0844.C0845 r6 = r02.mo8744();
                        r6.mo8745(120, TimeUnit.SECONDS);
                        r6.mo8749(120, TimeUnit.SECONDS);
                        r6.mo8750(120, TimeUnit.SECONDS);
                        C0844 r62 = r6.mo8748();
                        C1279.f3602 = r02;
                        C1279.f3603 = r62;
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    new C0639().start();
                    Application application2 = r3.f571;
                    C0678.C0679 r63 = new C0678.C0679();
                    r63.f1773 = r5;
                    C0678.m1728((Context) application2, r63);
                    UserInfo r03 = C0536.m1309();
                    WPengServer.m1073(r03 != null ? String.valueOf(r03.f2110) : null);
                    WPengServer.f850 = new C0520(r3);
                    BaseApplication.this.mo7791("initWPL");
                }
            }
            C0435 r04 = new C0435((TheApplication) null);
            if (r3.mo7800()) {
                Application application3 = r3.f571;
                UMengManager.f1245 = r04;
                Application application4 = (Application) application3.getApplicationContext();
                MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(application4, "5d4aac2d3fc195ade80008ba", Utils.m1901((Context) application4)));
                MobclickAgent.f70b.mo7295a(true);
                if (AppUtils.m1169()) {
                    MobclickAgent.f70b.mo7304c(false);
                    TaskManager.m2715((Runnable) new C1275());
                }
                application4.registerActivityLifecycleCallbacks(UMengManager.f1246);
                Thread.setDefaultUncaughtExceptionHandler(new C0975(Thread.getDefaultUncaughtExceptionHandler()));
                if (Build.VERSION.SDK_INT >= 26) {
                    new Handler(Looper.getMainLooper()).post(new CrashHandler());
                }
                BaseApplication.this.mo7791("initUMeng");
            }
            C1063.m2863(new String[]{"skad_report_keyword", "skad_ask_all_page", "skad_try_time", "skad_full_rule", "skad_arelmt", "skad_cslmt", "skad_skip_texts", "skad_splash_texts", "skad_skip_ids", "skad_report_texts", "skad_report_texts_simple", "skad_readme_url", "qqgroup_lightstart", "skad_ctrcd", "skad_guide_images", "skad_auto_login_tips", "skad_toast_len"});
            String r05 = C1279.m3425();
            if (r3.mo7800()) {
                StatisticsManager.f585 = r05;
                String r06 = StatisticsManager.f581.mo9612();
                StatisticsManager.f581.mo9609();
                if (!TextUtils.isEmpty(r06)) {
                    try {
                        StatisticsManager.C0446 r07 = (StatisticsManager.C0446) GsonUtil.m2740(r06, StatisticsManager.C0446.class);
                        if (r07 != null) {
                            StatisticsManager.f583 = r07.f592;
                            List<StatisticsManager.EventModel> list = r07.f593;
                            if (list != null) {
                                StatisticsManager.f582.addAll(list);
                            }
                        }
                    } catch (Exception e2) {
                        e2.getMessage();
                        StatisticsManager.f583 = 0;
                    }
                }
                StatisticsManager.f587 = 36000000;
                long j2 = 60000;
                if (BaseApplication.f562) {
                    StatisticsManager.f587 = 60000;
                }
                StatisticsManager.f586 = StatisticsManager.f587;
                if (StatisticsManager.f583 > 0) {
                    j = (StatisticsManager.f586 - System.currentTimeMillis()) + StatisticsManager.f583;
                    if (j < 0) {
                        j = 60000;
                    }
                    long j3 = StatisticsManager.f586;
                    if (j > j3) {
                        j = j3;
                    }
                } else {
                    j = StatisticsManager.f586;
                }
                if (j <= 0) {
                    j = 10000;
                }
                AppUtils.m1147((Runnable) new C1099(), j);
                if (!BaseApplication.f562) {
                    j2 = 600000;
                }
                AppUtils.m1147((Runnable) new C0669(j2), j2);
                StatisticsManager.m734();
                C1063.C1065 r08 = StatisticsManager.f591;
                C1063.f3038.put(r08, r08);
                BaseApplication.this.mo7791("initStat");
            }
            if (r3.mo7800()) {
                if (C1146.m3072()) {
                    UpdateHelper.f599 = Utils.m1859(C1063.m2859("bg_update_time", (String) null), 604800000);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    AppUtils.getApplication().registerReceiver(new C0541(), intentFilter);
                }
                BaseApplication.this.mo7791("autoCheckUpdate");
            }
            TheApplication r09 = new TheApplication(this);
            if (r3.mo7800()) {
                ServicePermissionActivity.f713 = r09;
                r09.mo7900();
                ServicePermissionActivity.f714 = null;
                BaseApplication.this.mo7791("initServicePermission");
            }
            if (r3.mo7800()) {
                C1110.f3162 = R$string.privacy_dialog;
                BaseApplication.this.mo7791("initPrivacy");
            }
            if (r3.mo7800()) {
                C0813.m2152();
                BaseApplication.this.mo7791("initPatchLoader");
            }
            r3.mo7799(C0818.f2132);
            r3.mo7799(C0881.f2397);
            r3.mo7799(C0841.f2227);
            r3.mo7799(C0728.f1884);
            r3.mo7799(C0901.f2425);
            r3.mo7799(C0885.f2401);
            r3.mo7799(C0632.f1609);
            r3.f572 = BidiFormatter.EMPTY_STRING;
            if (r3.mo7800()) {
                TaskManager.m2720(new C0665(r3));
                BaseApplication.this.mo7791("updateConfig");
            }
            if (r3.mo7800()) {
                Application application5 = r3.f571;
                if (!ActivityKiller.f1599) {
                    ActivityKiller.f1599 = true;
                    ActivityKiller.f1600 = true;
                    application5.registerActivityLifecycleCallbacks(ActivityKiller.f1601);
                }
                BaseApplication.this.mo7791("initActivityKiller");
            }
            SP<Boolean> r010 = SpHandler.f1754;
            r010.getClass();
            C0623 r2 = new C0623(r010);
            Class<MainActivity> cls = MainActivity.class;
            if (r3.mo7800()) {
                try {
                    LauncherActivity.f635 = ((Boolean) r2.call()).booleanValue();
                } catch (Exception unused) {
                }
                LauncherActivity.f636 = cls;
                LauncherActivity.f637 = -1;
                BaseApplication.this.mo7791("initLauncher");
            }
            if (r3.mo7800()) {
                LauncherActivity.f638 = 0;
            }
            C0434 r011 = new C0434((TheApplication) null);
            if (r3.mo7800()) {
                AboutActivity.f616 = r011;
                BaseApplication.this.mo7791("initAbout");
            }
            r3.mo7799(C0824.f2147);
            r3.mo7799(C0514.f933);
            C0536.f1044 = C0682.f1776;
            ((DevHelper.C0474) DevHelper.m1039()).mo7968();
        }
    }
}
