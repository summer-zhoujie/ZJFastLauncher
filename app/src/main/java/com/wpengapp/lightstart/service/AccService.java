package com.wpengapp.lightstart.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.GestureDescription;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.p000v4.text.BidiFormatter;
import android.support.p000v4.view.InputDeviceCompat;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.lightstart.R$dimen;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.config.DefaultConfig;
import com.wpengapp.support.AccActionHelper;
import com.wpengapp.support.AccServiceHelper;
import com.wpengapp.support.ApManager;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.AutoLoginConfig;
import com.wpengapp.support.BaseApplication;
import com.wpengapp.support.C0461;
import com.wpengapp.support.C0470;
import com.wpengapp.support.C0471;
import com.wpengapp.support.C0487;
import com.wpengapp.support.C0488;
import com.wpengapp.support.C0502;
import com.wpengapp.support.C0591;
import com.wpengapp.support.C0643;
import com.wpengapp.support.C0647;
import com.wpengapp.support.C0703;
import com.wpengapp.support.C0706;
import com.wpengapp.support.C0722;
import com.wpengapp.support.C0742;
import com.wpengapp.support.C0780;
import com.wpengapp.support.C0805;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0858;
import com.wpengapp.support.C0917;
import com.wpengapp.support.C0919;
import com.wpengapp.support.C0929;
import com.wpengapp.support.C0986;
import com.wpengapp.support.C0995;
import com.wpengapp.support.C1005;
import com.wpengapp.support.C1032;
import com.wpengapp.support.C1057;
import com.wpengapp.support.C1076;
import com.wpengapp.support.C1079;
import com.wpengapp.support.C1149;
import com.wpengapp.support.C1156;
import com.wpengapp.support.C1170;
import com.wpengapp.support.C1219;
import com.wpengapp.support.C1266;
import com.wpengapp.support.C1273;
import com.wpengapp.support.C1279;
import com.wpengapp.support.C1285;
import com.wpengapp.support.CountLimitHelper;
import com.wpengapp.support.CustomPageConfig;
import com.wpengapp.support.DevHelper;
import com.wpengapp.support.FileUtils;
import com.wpengapp.support.FloatWindow;
import com.wpengapp.support.ForegroundAppManager;
import com.wpengapp.support.IMainService;
import com.wpengapp.support.InputEventUtils;
import com.wpengapp.support.NotificationEventHandler;
import com.wpengapp.support.PageConfig;
import com.wpengapp.support.RemoteSP;
import com.wpengapp.support.RetCallback;
import com.wpengapp.support.SafeToastHooker;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.StatisticsManager;
import com.wpengapp.support.SyncPayStatus;
import com.wpengapp.support.SystemApi;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.WPengServer;
import com.wpengapp.support.accservice.AccNodeSelector;
import com.wpengapp.support.accservice.BaseAccessibilityService;
import com.wpengapp.support.accservice.SafeAccService;
import com.wpengapp.support.outline;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class AccService extends SafeAccService {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: ލ */
    public static AccService f500;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: ގ */
    public static AccService f501;

    /* renamed from: ޏ */
    public HandlerThread f502;

    /* renamed from: ސ */
    public Handler f503;

    /* renamed from: ޑ */
    public volatile String f504;

    /* renamed from: ޒ */
    public volatile String f505;

    /* renamed from: ޓ */
    public long f506;

    /* renamed from: ޔ */
    public FloatWindow f507;

    /* renamed from: ޕ */
    public Toast f508;

    /* renamed from: ޖ */
    public C1079 f509;

    /* renamed from: ޗ */
    public Set<String> f510 = new HashSet();

    /* renamed from: ޘ */
    public ConcurrentHashMap<Integer, Long> f511 = new ConcurrentHashMap<>();

    /* renamed from: ޙ */
    public PageConfig f512;

    /* renamed from: ޚ */
    public boolean f513;

    /* renamed from: ޛ */
    public boolean f514;

    /* renamed from: ޜ */
    public final long f515 = SystemClock.elapsedRealtime();

    /* renamed from: ޝ */
    public boolean f516;

    /* renamed from: ޞ */
    public int f517;

    /* renamed from: ޟ */
    public boolean f518;

    /* renamed from: ޠ */
    public BroadcastReceiver f519 = new C0931(this);

    /* renamed from: ޡ */
    public Runnable f520 = new C0858(this);

    /* renamed from: ޢ */
    public long f521 = SystemClock.uptimeMillis();

    /* renamed from: ޣ */
    public Runnable f522 = new C1170(this);

    /* renamed from: ޤ */
    public TextView f523;

    /* renamed from: ޥ */
    public ImageView f524;

    /* renamed from: ޱ */
    public boolean f525;

    /* renamed from: ࢠ */
    public BroadcastReceiver f526 = new AccService(this);

    /* renamed from: com.wpengapp.lightstart.service.AccService$֏ */
    private static class C0441 {

        /* renamed from: ֏ */
        public String f527;

        /* renamed from: ؠ */
        public boolean f528;

        /* renamed from: ހ */
        public AccessibilityNodeInfo f529;

        public /* synthetic */ C0441(C0931 r1) {
        }
    }

    /* renamed from: com.wpengapp.lightstart.service.AccService$ؠ */
    private static class C0442 {

        /* renamed from: ֏ */
        public String f530 = BidiFormatter.EMPTY_STRING;

        /* renamed from: ؠ */
        public String f531;

        /* renamed from: ހ */
        public Float f532;

        public /* synthetic */ C0442(C0931 r1) {
        }
    }

    public void onCreate() {
        super.onCreate();
        this.f502 = new C1076("AccServiceHandlerThread");
        this.f502.start();
        this.f503 = new Handler(this.f502.getLooper());
        this.f503.post(new C0470(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.f519, intentFilter);
        registerReceiver(this.f526, new IntentFilter(getPackageName() + AppUtils.m1159()));
        long r0 = (AnalyticsConstants.f107j - WPengServer.m1070()) + C1149.m3085();
        if (r0 <= 0) {
            r0 = 8000;
        } else if (r0 > AnalyticsConstants.f107j) {
            r0 = 86400000;
        }
        this.f503.postDelayed(new C0929(this, AnalyticsConstants.f107j), r0);
        this.f512 = new PageConfig();
        this.f512.f2981 = 0;
        this.f509 = new C1079(this);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this instanceof AccService24) {
            f501 = null;
        } else {
            f500 = null;
        }
        AccService accService = f501;
        if (accService != null) {
            BaseAccessibilityService.f600 = accService;
        } else {
            AccService accService2 = f500;
            if (accService2 != null) {
                BaseAccessibilityService.f600 = accService2;
            }
        }
        FloatWindow r0 = this.f507;
        if (r0 != null) {
            r0.mo9027();
        }
        this.f502.quit();
        unregisterReceiver(this.f519);
        unregisterReceiver(this.f526);
        C1032.m2756();
        C1032.f2954 = null;
        if (BaseAccessibilityService.f600 == null) {
            C0986.m2622(this);
            StatisticsManager.m735();
        }
        if (C0919.m2416() == 2) {
            AppUtils.m1147((Runnable) C0805.f2087, (long) ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
        }
    }

    public void onServiceConnected() {
        super.onServiceConnected();
        if (this instanceof AccService24) {
            f501 = this;
        } else {
            f500 = this;
        }
        if (!(f501 == null || f500 == null)) {
            if (C0919.m2416() == 1) {
                AccServiceHelper.m2013((AccessibilityService) f500);
                BaseAccessibilityService.f600 = f501;
            } else {
                AccServiceHelper.m2013((AccessibilityService) f501);
                BaseAccessibilityService.f600 = f500;
            }
        }
        try {
            AccessibilityServiceInfo serviceInfo = getServiceInfo();
            ((DevHelper.C0474) DevHelper.m1039()).mo7971();
            serviceInfo.eventTypes = 96;
            int i = Build.VERSION.SDK_INT;
            serviceInfo.flags |= 64;
            serviceInfo.flags |= 16;
            setServiceInfo(serviceInfo);
        } catch (Exception unused) {
        }
        TaskManager.m2715((Runnable) new C0461(this));
        if (SpHandler.f1758.mo8104().booleanValue()) {
            C1273.m3361((Service) this);
        }
    }

    /* renamed from: ֏ */
    public final void mo7731(String str) {
        boolean z;
        AutoLoginConfig r3 = C1057.f3020.mo9612();
        if (r3 == null) {
            z = true;
        } else {
            z = r3.f3553;
        }
        if (z) {
            String string = getString(R$string.skip_anim_text_login);
            if (!this.f525) {
                AppUtils.m1146((Runnable) new C0703(this, string, (Drawable) null));
            }
        }
    }

    /* renamed from: ހ */
    public final void mo7750() {
        FloatWindow r0 = this.f507;
        if (r0 != null) {
            if (!r0.f2732) {
                r0.mo9027();
                return;
            }
            r0.f2735.findViewById(R$id.tv_dont_skip).setOnClickListener((View.OnClickListener) null);
            this.f507.f2735.findViewById(R$id.tv_skip).setOnClickListener((View.OnClickListener) null);
            View findViewById = this.f507.f2735.findViewById(R$id.layout_content);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new C0995(findViewById));
            ofFloat.setDuration(170);
            ofFloat.addListener(new C1289(this));
            ofFloat.start();
        }
    }

    /* renamed from: ށ */
    public /* synthetic */ void mo7751() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException unused) {
        }
        ApManager.f3346 = BaseApplication.f562;
        FileUtils.m1130(new File(AppUtils.getApplication().getFilesDir(), "ap"));
        if (ApManager.m3175()) {
            RemoteSP.m1206("1jda923jf1d", (Object) Long.valueOf(System.currentTimeMillis()), false);
            if (!ApManager.f3347) {
                this.f518 = true;
            }
        }
        this.f516 = false;
    }

    /* renamed from: ނ */
    public /* synthetic */ void mo7752() {
        C1219.m3286();
        if (C1149.m3075(false).size() > 0) {
            C1149.m3077((RetCallback<DefaultConfig>) null);
        }
        mo7756();
    }

    /* renamed from: ރ */
    public /* synthetic */ void mo7753() {
        AccessibilityNodeInfo r1;
        try {
            String[] r0 = C0647.m1654();
            if (r0.length != 0 && (r1 = C1279.m3436()) != null) {
                for (String str : r0) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = null;
                        AccessibilityNodeInfo r6 = C1279.m3390(r1, str, (C1156) null);
                        if (r6 != null) {
                            if (str.equals("青少年")) {
                                str2 = m630(r1);
                            }
                            C0471.m1013(r6, String.valueOf(r6.getPackageName()), this.f504, str, str2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ބ */
    public /* synthetic */ void mo7754() {
        C1149.m3088();
        C1149.m3084();
        C1219.m3276();
        C1219.m3286();
        mo7756();
    }

    /* renamed from: ޅ */
    public /* synthetic */ void mo7755() {
        boolean z = SystemApi.m2051(this) == 0;
        if (!z && BaseAccessibilityService.f600 != null) {
            C0986.m2621(this);
        }
        if (BaseAccessibilityService.f600 != null) {
            mo7723(C0919.m2416(), z);
        }
    }

    /* renamed from: ކ */
    public final void mo7756() {
        this.f510 = new HashSet();
        for (ComponentName next : SystemUtils.m3520()) {
            this.f510.add(ForegroundAppManager.m1393(next.getPackageName(), next.getClassName()));
        }
    }

    /* renamed from: ؠ */
    public final void mo7747(C0441 r8, AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, @NonNull PageConfig r12, float f) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        AccessibilityNodeInfo accessibilityNodeInfo3;
        C0502 r5;
        C0487 r6;
        C0487 r62;
        String str3 = r12.f2982;
        boolean z = true;
        AccessibilityNodeInfo accessibilityNodeInfo4 = null;
        if (str3 != null && str3.startsWith("-1")) {
            String str4 = r12.f2982;
            Float f2 = r12.f2984;
            if (f2 == null) {
                r62 = null;
            } else {
                r62 = new C0487(f2);
            }
            accessibilityNodeInfo2 = C1279.m3391(accessibilityNodeInfo, str2, (C1156) r62, str4.split(","));
        } else {
            String str5 = r12.f2982;
            if (!TextUtils.isEmpty(str5)) {
                Float f3 = r12.f2984;
                if (f3 == null) {
                    r6 = null;
                } else {
                    r6 = new C0487(f3);
                }
                accessibilityNodeInfo3 = C1279.m3391(accessibilityNodeInfo, str2, (C1156) r6, str5.split(","));
            } else {
                accessibilityNodeInfo3 = null;
            }
            if (accessibilityNodeInfo3 == null) {
                Float f4 = r12.f2984;
                Integer valueOf = Integer.valueOf(C1149.m3086());
                if (f4 == null && valueOf == null) {
                    r5 = null;
                } else {
                    r5 = new C0502(f4, valueOf);
                }
                accessibilityNodeInfo2 = C1279.m3391(accessibilityNodeInfo, str2, (C1156) r5, C0647.m1656());
            } else {
                accessibilityNodeInfo2 = accessibilityNodeInfo3;
            }
        }
        if (accessibilityNodeInfo2 != null) {
            if (!this.f513 || !r12.mo9157()) {
                z = false;
            }
            if (!z) {
                accessibilityNodeInfo4 = C1279.m3437(accessibilityNodeInfo2);
            }
            if (accessibilityNodeInfo4 == null) {
                r8.f529 = accessibilityNodeInfo2;
            } else {
                r8.f529 = accessibilityNodeInfo4;
            }
            if (m634(r8.f529, false, f) && mo7743(str, r12.mo9158())) {
                r8.f527 = "text";
                if (z) {
                    r8.f528 = mo7749(r8.f529);
                } else {
                    r8.f528 = r8.f529.performAction(16);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x01e1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0272  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo7730(@NonNull PageConfig r22, String r23, String r24, String r25, AccessibilityEvent r26, boolean r27) {
        /*
            r21 = this;
            r14 = r21
            r4 = r22
            r3 = r23
            r0 = r25
            java.lang.Integer r1 = r4.f2985
            r2 = 0
            if (r1 == 0) goto L_0x0016
            int r1 = r1.intValue()
            if (r1 > 0) goto L_0x0016
            r1 = 1
            r8 = 1
            goto L_0x0018
        L_0x0016:
            r1 = 0
            r8 = 0
        L_0x0018:
            int r7 = com.wpengapp.support.AccServiceHelper.m2006((android.view.accessibility.AccessibilityEvent) r26)
            if (r8 != 0) goto L_0x0099
            if (r27 != 0) goto L_0x0099
            long r5 = android.os.SystemClock.uptimeMillis()
            long r9 = r14.f521
            long r9 = r5 - r9
            r11 = 1800000(0x1b7740, double:8.89318E-318)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0061
            r14.f521 = r5
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Long> r1 = r14.f511
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x003b:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L_0x0061
            java.lang.Object r9 = r1.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getValue()
            if (r10 == 0) goto L_0x005d
            java.lang.Object r9 = r9.getValue()
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            long r9 = r5 - r9
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x003b
        L_0x005d:
            r1.remove()
            goto L_0x003b
        L_0x0061:
            if (r7 <= 0) goto L_0x007d
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Long> r1 = r14.f511
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            java.lang.Object r1 = r1.get(r5)
            java.lang.Long r1 = (java.lang.Long) r1
            if (r1 == 0) goto L_0x007d
            long r5 = r1.longValue()
            r9 = 0
            int r1 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x007d
            r1 = 1
            goto L_0x007e
        L_0x007d:
            r1 = 0
        L_0x007e:
            if (r1 == 0) goto L_0x0099
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "PagePolicy[windowHasSkipped] windowId: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = ", page: "
            r0.append(r1)
            r0.append(r3)
            r0.toString()
            return
        L_0x0099:
            boolean r1 = r14.f518
            if (r1 == 0) goto L_0x009e
            return
        L_0x009e:
            java.lang.String r1 = "]: "
            java.lang.String r5 = "]["
            java.lang.String r6 = "PagePolicy["
            java.lang.String r9 = "UnknownPage"
            r10 = 2
            boolean r11 = r22.mo9158()     // Catch:{ all -> 0x02ab }
            java.lang.String r12 = "BlackPage"
            if (r11 == 0) goto L_0x00e6
            boolean r11 = com.wpengapp.support.SyncPayStatus.m1962()     // Catch:{ all -> 0x02ab }
            if (r11 == 0) goto L_0x00ce
            boolean r11 = com.wpengapp.support.C1057.m2854((java.lang.String) r24)     // Catch:{ all -> 0x02ab }
            if (r11 == 0) goto L_0x00ce
            java.lang.String r9 = "LoginPage"
            boolean r11 = com.wpengapp.support.C1057.m2853()     // Catch:{ all -> 0x00ca }
            if (r11 == 0) goto L_0x00c8
            com.wpengapp.support.з r11 = com.wpengapp.support.C0701.f1811     // Catch:{ all -> 0x00ca }
            com.wpengapp.support.TaskManager.m2715((java.lang.Runnable) r11)     // Catch:{ all -> 0x00ca }
        L_0x00c8:
            r11 = 1
            goto L_0x00d0
        L_0x00ca:
            r0 = move-exception
            r10 = 1
            goto L_0x02ad
        L_0x00ce:
            r11 = 2
            r9 = r12
        L_0x00d0:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r6)
            r12.append(r11)
            r12.append(r5)
            r12.append(r9)
            r13 = r24
            r9 = r12
            goto L_0x0156
        L_0x00e6:
            java.lang.String r11 = r21.getPackageName()     // Catch:{ all -> 0x02ab }
            r13 = r24
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x02ab }
            if (r11 == 0) goto L_0x010f
            if (r0 == 0) goto L_0x010f
            java.lang.String r11 = "TestActivity"
            boolean r11 = r0.endsWith(r11)     // Catch:{ all -> 0x02ab }
            if (r11 != 0) goto L_0x010f
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            r9.append(r10)
            r9.append(r5)
            r9.append(r12)
            goto L_0x017b
        L_0x010f:
            com.wpengapp.support.ঢ r11 = com.wpengapp.support.C1219.m3271((java.lang.String) r24)     // Catch:{ all -> 0x02ab }
            if (r11 == 0) goto L_0x0126
            boolean r15 = r11.f3016     // Catch:{ all -> 0x02ab }
            if (r15 == 0) goto L_0x0126
            java.lang.String r9 = "BlackApp"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
        L_0x0120:
            r20 = r11
            r11 = r9
            r9 = r20
            goto L_0x016f
        L_0x0126:
            java.util.Set<java.lang.String> r15 = r14.f510     // Catch:{ all -> 0x02ab }
            boolean r15 = r15.contains(r3)     // Catch:{ all -> 0x02ab }
            if (r15 == 0) goto L_0x0136
            java.lang.String r9 = "HomeApp"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            goto L_0x0120
        L_0x0136:
            com.wpengapp.support.ग़ r15 = r14.f512     // Catch:{ all -> 0x02ab }
            if (r4 == r15) goto L_0x0161
            boolean r11 = r4.f2973     // Catch:{ all -> 0x02ab }
            if (r11 == 0) goto L_0x0141
            r9 = 2
            r11 = 2
            goto L_0x0145
        L_0x0141:
            java.lang.String r12 = "WhitePage"
            r9 = 1
            r11 = 1
        L_0x0145:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            r9.append(r11)
            r9.append(r5)
            r9.append(r12)
        L_0x0156:
            r9.append(r1)
            r9.append(r3)
            r9.toString()
            goto L_0x01df
        L_0x0161:
            if (r11 == 0) goto L_0x0185
            boolean r11 = r11.f3018     // Catch:{ all -> 0x02ab }
            if (r11 == 0) goto L_0x0185
            java.lang.String r9 = "ReversePage"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            goto L_0x0120
        L_0x016f:
            r9.append(r6)
            r9.append(r10)
            r9.append(r5)
            r9.append(r11)
        L_0x017b:
            r9.append(r1)
            r9.append(r3)
            r9.toString()
            goto L_0x01de
        L_0x0185:
            boolean r11 = com.wpengapp.support.C1149.m3091()     // Catch:{ all -> 0x02ab }
            if (r11 == 0) goto L_0x01a6
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
        L_0x0190:
            r11.append(r6)
            r11.append(r2)
            r11.append(r5)
            r11.append(r9)
            r11.append(r1)
            r11.append(r3)
            r11.toString()
            goto L_0x01c2
        L_0x01a6:
            boolean r11 = com.wpengapp.support.C1219.m3280(r23)     // Catch:{ all -> 0x02a9 }
            if (r11 == 0) goto L_0x01b4
            java.lang.String r9 = "LauncherPage"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            goto L_0x0190
        L_0x01b4:
            boolean r11 = com.wpengapp.support.C0647.m1653(r25)     // Catch:{ all -> 0x02a9 }
            if (r11 == 0) goto L_0x01c4
            java.lang.String r9 = "SplashText"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            goto L_0x0190
        L_0x01c2:
            r11 = 0
            goto L_0x01df
        L_0x01c4:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r6)
            r11.append(r10)
            r11.append(r5)
            r11.append(r9)
            r11.append(r1)
            r11.append(r3)
            r11.toString()
        L_0x01de:
            r11 = 2
        L_0x01df:
            if (r11 != r10) goto L_0x01e2
            return
        L_0x01e2:
            if (r11 != 0) goto L_0x01e7
            r1 = 1
            r12 = 1
            goto L_0x01e9
        L_0x01e7:
            r1 = 0
            r12 = 0
        L_0x01e9:
            boolean r0 = com.wpengapp.support.C0647.m1653(r25)
            if (r0 != 0) goto L_0x01f9
            boolean r0 = com.wpengapp.support.C1219.m3280(r23)
            if (r0 == 0) goto L_0x01f6
            goto L_0x01f9
        L_0x01f6:
            r0 = 0
            r15 = 0
            goto L_0x01fb
        L_0x01f9:
            r0 = 1
            r15 = 1
        L_0x01fb:
            if (r12 == 0) goto L_0x01fe
            goto L_0x020d
        L_0x01fe:
            java.lang.Integer r0 = r4.f2981
            if (r0 != 0) goto L_0x0204
            r5 = r15
            goto L_0x020f
        L_0x0204:
            int r0 = r0.intValue()
            if (r0 == 0) goto L_0x020d
            r0 = 1
            r5 = 1
            goto L_0x020f
        L_0x020d:
            r0 = 0
            r5 = 0
        L_0x020f:
            java.lang.Integer r0 = r4.f2980
            if (r0 != 0) goto L_0x0214
            goto L_0x0218
        L_0x0214:
            int r2 = r0.intValue()
        L_0x0218:
            r0 = 1000(0x3e8, float:1.401E-42)
            if (r12 == 0) goto L_0x0225
            r1 = 800(0x320, double:3.953E-321)
            r6 = 1000(0x3e8, float:1.401E-42)
            r16 = r1
            r2 = 1000(0x3e8, float:1.401E-42)
            goto L_0x0233
        L_0x0225:
            if (r8 == 0) goto L_0x022a
            r9 = 1000(0x3e8, double:4.94E-321)
            goto L_0x0231
        L_0x022a:
            if (r5 == 0) goto L_0x022f
            r9 = 500(0x1f4, double:2.47E-321)
            goto L_0x0231
        L_0x022f:
            r9 = 200(0xc8, double:9.9E-322)
        L_0x0231:
            r16 = r9
        L_0x0233:
            long r9 = java.lang.System.currentTimeMillis()
            r26 = r12
            long r12 = (long) r2
            long r9 = r9 + r12
            java.lang.Integer r1 = r4.f2985
            if (r1 != 0) goto L_0x0272
            int r1 = com.wpengapp.support.C1149.f3270
            if (r1 <= 0) goto L_0x0244
            goto L_0x0270
        L_0x0244:
            java.lang.String r1 = "skad_try_time"
            r6 = 0
            java.lang.String r1 = com.wpengapp.support.C1063.m2859((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ Exception -> 0x0258 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x0258 }
            com.wpengapp.support.C1149.f3270 = r1     // Catch:{ Exception -> 0x0258 }
            int r1 = com.wpengapp.support.C1149.f3270     // Catch:{ Exception -> 0x0258 }
            if (r1 >= r0) goto L_0x0260
            com.wpengapp.support.C1149.f3270 = r0     // Catch:{ Exception -> 0x0258 }
            goto L_0x0260
        L_0x0258:
            r0 = move-exception
            r0.getMessage()
            r0 = 3500(0xdac, float:4.905E-42)
            com.wpengapp.support.C1149.f3270 = r0
        L_0x0260:
            java.lang.String r0 = "getTryTime "
            java.lang.StringBuilder r0 = com.wpengapp.support.outline.m2549(r0)
            int r1 = com.wpengapp.support.C1149.f3270
            r0.append(r1)
            r0.toString()
            int r1 = com.wpengapp.support.C1149.f3270
        L_0x0270:
            r11 = r1
            goto L_0x0277
        L_0x0272:
            int r0 = r1.intValue()
            r11 = r0
        L_0x0277:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "skip startDelay "
            r0.append(r1)
            r0.append(r2)
            r0.toString()
            android.os.Handler r0 = r14.f503
            com.wpengapp.support.ၔ r6 = new com.wpengapp.support.ၔ
            r1 = r6
            r2 = r21
            r3 = r23
            r4 = r22
            r25 = r0
            r0 = r6
            r6 = r24
            r18 = r12
            r12 = r26
            r13 = r15
            r14 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14)
            r3 = r25
            r1 = r18
            r3.postDelayed(r0, r1)
            return
        L_0x02a9:
            r0 = move-exception
            goto L_0x02ad
        L_0x02ab:
            r0 = move-exception
            r10 = 0
        L_0x02ad:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r10)
            r2.append(r5)
            r2.append(r9)
            r2.append(r1)
            r2.append(r3)
            r2.toString()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.lightstart.service.AccService.mo7730(com.wpengapp.support.ग़, java.lang.String, java.lang.String, java.lang.String, android.view.accessibility.AccessibilityEvent, boolean):void");
    }

    /* renamed from: ؠ */
    public final void mo7746(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, String str3, boolean z) {
        if (this.f507 == null) {
            this.f507 = new FloatWindow((Context) this, new WindowManager.LayoutParams(getResources().getDimensionPixelSize(R$dimen.dialog_ask_skip_width), getResources().getDimensionPixelSize(R$dimen.dialog_ask_skip_height), 2003, 262920, -2), (int) R$layout.dialog_ask_skip);
            this.f507.f2735.setOnTouchListener(new C0917(this));
        }
        this.f507.f2735.findViewById(R$id.tv_dont_skip).setOnClickListener(new C0706(this, str2, str, z));
        this.f507.f2735.findViewById(R$id.tv_skip).setOnClickListener(new C1285(this, accessibilityNodeInfo, str2, str, str3, z));
        View findViewById = this.f507.f2735.findViewById(R$id.layout_content);
        findViewById.setAlpha(0.0f);
        int i = C0826.m2169().f2152;
        int i2 = C0826.m2169().f2153;
        int r13 = C0826.m2168(64.0f);
        if (SystemUtils.m3529()) {
            FloatWindow r14 = this.f507;
            r14.mo9028((i2 - r14.f2734.width) / 2, (i - this.f507.f2734.height) - r13);
        } else {
            FloatWindow r142 = this.f507;
            r142.mo9028((i - r142.f2734.width) / 2, (i2 - this.f507.f2734.height) - r13);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new C0742(findViewById));
        ofFloat.setDuration(200);
        ofFloat.start();
    }

    /* renamed from: ؠ */
    public final C0442 mo7745(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, @NonNull PageConfig r15) {
        "try skip: " + str2 + ", " + str;
        if (accessibilityNodeInfo == null || !mo7743(str, r15.mo9158())) {
            return new C0442((C0931) null);
        }
        try {
            C0441 r1 = new C0441((C0931) null);
            Integer num = r15.f2983;
            if (num != null && num.intValue() == 1 && mo7743(str, r15.mo9158())) {
                r1.f527 = "back";
                AccServiceHelper.m2014((AccessibilityService) this, 1);
                r1.f528 = true;
            }
            Float f = r15.f2984;
            float floatValue = f == null ? Float.MAX_VALUE : f.floatValue();
            if (r15.mo8702()) {
                if (!r1.f528) {
                    mo7747(r1, accessibilityNodeInfo, str, str2, r15, floatValue);
                }
                if (!r1.f528) {
                    mo7729(r1, accessibilityNodeInfo, str, str2, r15, floatValue);
                }
                if (!r1.f528) {
                    mo7728(r1, accessibilityNodeInfo, str, r15, floatValue);
                }
                if (!r1.f528) {
                    mo7727(r1, accessibilityNodeInfo, str2, r15);
                }
            } else {
                if (!r1.f528) {
                    mo7729(r1, accessibilityNodeInfo, str, str2, r15, floatValue);
                }
                if (!r1.f528) {
                    mo7728(r1, accessibilityNodeInfo, str, r15, floatValue);
                }
                if (!r1.f528) {
                    mo7727(r1, accessibilityNodeInfo, str2, r15);
                }
                if (!r1.f528) {
                    mo7747(r1, accessibilityNodeInfo, str, str2, r15, floatValue);
                }
            }
            if (mo7741(accessibilityNodeInfo, str2, str, r15)) {
                r1.f527 = "jump";
                r1.f528 = true;
            }
            if (!r1.f528) {
                r1.f527 = BidiFormatter.EMPTY_STRING;
                r1.f529 = null;
            }
            C0442 r12 = new C0442((C0931) null);
            r12.f530 = r1.f527;
            r12.f531 = C1279.m3440(r1.f529);
            r12.f532 = C1279.m3430(r1.f529);
            return r12;
        } catch (Exception e) {
            e.getMessage();
            return new C0442((C0931) null);
        }
    }

    /* renamed from: ֏ */
    public void mo7723(int i, boolean z) {
        if (i == 1 && (this instanceof AccService24) && Build.VERSION.SDK_INT >= 24) {
            this.f513 = true;
            this.f514 = false;
        } else if (i != 2 || !z) {
            this.f513 = false;
            this.f514 = false;
        } else {
            this.f513 = true;
            this.f514 = true;
        }
    }

    /* renamed from: ֏ */
    public void mo7724(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 1) {
            ((DevHelper.C0474) DevHelper.m1039()).mo7970(accessibilityEvent);
            return;
        }
        C0488.m1082(accessibilityEvent);
        if (eventType == 64) {
            NotificationEventHandler.m995(accessibilityEvent);
        } else if (eventType == 32) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (!SpHandler.f1750.mo8104().booleanValue()) {
                    return;
                }
                if (!C1032.m2761()) {
                    if (accessibilityEvent.getPackageName() == null) {
                        return;
                    }
                    if (accessibilityEvent.getClassName() != null) {
                        String r2 = ForegroundAppManager.m1393(accessibilityEvent.getPackageName().toString(), accessibilityEvent.getClassName().toString());
                        if (r2.equals(ForegroundAppManager.m1391()) && !r2.equals("com.osp.app.signin/com.samsung.android.samsungaccount.authentication.ui.requestAccessToken.RequestAccessTokenActivity")) {
                            mo7735(r2, String.valueOf(accessibilityEvent.getPackageName()), String.valueOf(accessibilityEvent.getClassName()), accessibilityEvent);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            StringBuilder r6 = outline.m2549("time cost ");
                            r6.append(currentTimeMillis2 - currentTimeMillis);
                            r6.append("ms");
                            r6.toString();
                        }
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c8, code lost:
        if (com.wpengapp.support.CollectionUtils.m1657((java.util.Collection) r0) != false) goto L_0x00ca;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo7735(String r17, String r18, String r19, AccessibilityEvent r20) {
        /*
            r16 = this;
            r7 = r16
            r8 = r17
            r9 = r18
            r0 = 0
            boolean r1 = r7.mo7743((java.lang.String) r8, (boolean) r0)
            if (r1 == 0) goto L_0x000e
            return
        L_0x000e:
            r7.f504 = r8
            java.lang.String r1 = r7.f505
            boolean r1 = r9.equals(r1)
            r10 = 1
            r1 = r1 ^ r10
            r7.f505 = r9
            long r2 = android.os.SystemClock.elapsedRealtime()
            if (r1 == 0) goto L_0x0024
            r7.f506 = r2
            r11 = r1
            goto L_0x0030
        L_0x0024:
            long r4 = r7.f506
            long r4 = r2 - r4
            r11 = 3000(0xbb8, double:1.482E-320)
            int r1 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x002f
            r0 = 1
        L_0x002f:
            r11 = r0
        L_0x0030:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "cl-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r1 = 5
            r4 = 8000(0x1f40, double:3.9525E-320)
            boolean r0 = com.wpengapp.support.CountLimitHelper.m998(r0, r4, r1)
            if (r0 == 0) goto L_0x006a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "clr-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.wpengapp.support.CountLimitHelper.m997(r0, r4)
            if (r0 != 0) goto L_0x0064
            com.wpengapp.support.C0471.m1026(r17)
        L_0x0064:
            java.lang.String r0 = "PagePolicy[CountLimit] page: "
            com.wpengapp.support.outline.m2555((java.lang.String) r0, (java.lang.String) r8)
            return
        L_0x006a:
            boolean r0 = r7.f516
            if (r0 != 0) goto L_0x00a4
            boolean r0 = com.wpengapp.support.ApManager.f3347
            if (r0 != 0) goto L_0x00a4
            long r0 = r7.f515
            long r2 = r2 - r0
            long r0 = r7.f604
            r4 = 3
            long r0 = r0 * r4
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x00a4
            r0 = 0
            java.lang.String r2 = "1jda923jf1d"
            long r0 = com.wpengapp.support.RemoteSP.m1201((java.lang.String) r2, (long) r0)
            long r2 = java.lang.System.currentTimeMillis()
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 < 0) goto L_0x009a
            long r2 = r2 - r0
            long r0 = r7.f604
            r4 = 72
            long r0 = r0 * r4
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x00a4
        L_0x009a:
            r7.f516 = r10
            com.wpengapp.support.ப r0 = new com.wpengapp.support.ப
            r0.<init>(r7)
            com.wpengapp.support.TaskManager.m2718(r0)
        L_0x00a4:
            com.wpengapp.support.ϯ r0 = com.wpengapp.support.C0909.m2390()
            java.util.Map<java.lang.String, com.wpengapp.support.ۈ> r0 = r0.f1747
            java.lang.Object r0 = r0.get(r9)
            com.wpengapp.support.ۈ r0 = (com.wpengapp.support.CustomAppConfig) r0
            r12 = 0
            if (r0 == 0) goto L_0x00ca
            java.util.Map<java.lang.String, java.util.List<com.wpengapp.support.և>> r1 = r0.f2437
            boolean r1 = com.wpengapp.support.CollectionUtils.m1658((java.util.Map) r1)
            if (r1 == 0) goto L_0x00bc
            goto L_0x00ca
        L_0x00bc:
            java.util.Map<java.lang.String, java.util.List<com.wpengapp.support.և>> r0 = r0.f2437
            java.lang.Object r0 = r0.get(r8)
            java.util.List r0 = (java.util.List) r0
            boolean r1 = com.wpengapp.support.CollectionUtils.m1657((java.util.Collection) r0)
            if (r1 == 0) goto L_0x00cb
        L_0x00ca:
            r0 = r12
        L_0x00cb:
            boolean r1 = com.wpengapp.support.CollectionUtils.m1657((java.util.Collection) r0)
            if (r1 == 0) goto L_0x00d2
            goto L_0x00e4
        L_0x00d2:
            com.wpengapp.lightstart.config.DefaultConfig r1 = com.wpengapp.support.C1149.m3083()
            java.lang.Integer r1 = r1.type
            if (r1 == 0) goto L_0x00e6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00e6
        L_0x00e4:
            r1 = r12
            goto L_0x0109
        L_0x00e6:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x00ef:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0109
            java.lang.Object r2 = r0.next()
            com.wpengapp.support.և r2 = (com.wpengapp.support.CustomPageConfig) r2
            java.lang.Boolean r3 = r2.f2108
            if (r3 == 0) goto L_0x0105
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x00ef
        L_0x0105:
            r1.add(r2)
            goto L_0x00ef
        L_0x0109:
            com.wpengapp.support.ग़ r13 = com.wpengapp.support.C1219.m3270((java.lang.String) r9, (java.lang.String) r8)
            boolean r14 = com.wpengapp.support.CollectionUtils.m1659((java.util.Collection) r1)
            if (r14 == 0) goto L_0x013d
            java.util.Iterator r15 = r1.iterator()
        L_0x0117:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x013d
            java.lang.Object r0 = r15.next()
            r1 = r0
            com.wpengapp.support.և r1 = (com.wpengapp.support.CustomPageConfig) r1
            if (r1 != 0) goto L_0x0127
            goto L_0x0117
        L_0x0127:
            boolean r0 = com.wpengapp.support.C1266.m3357(r1)
            if (r0 == 0) goto L_0x012e
            goto L_0x0117
        L_0x012e:
            r0 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r0.mo7730((com.wpengapp.support.PageConfig) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (android.view.accessibility.AccessibilityEvent) r5, (boolean) r6)
            goto L_0x0117
        L_0x013d:
            if (r14 == 0) goto L_0x0147
            if (r13 == 0) goto L_0x0164
            boolean r0 = r13.mo9158()
            if (r0 == 0) goto L_0x0164
        L_0x0147:
            if (r13 != 0) goto L_0x0155
            if (r11 == 0) goto L_0x014f
            com.wpengapp.support.ग़ r13 = com.wpengapp.support.C1219.m3270((java.lang.String) r9, (java.lang.String) r9)
        L_0x014f:
            if (r13 != 0) goto L_0x0155
            com.wpengapp.support.ग़ r0 = r7.f512
            r1 = r0
            goto L_0x0156
        L_0x0155:
            r1 = r13
        L_0x0156:
            r0 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r0.mo7730((com.wpengapp.support.PageConfig) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (android.view.accessibility.AccessibilityEvent) r5, (boolean) r6)
        L_0x0164:
            java.lang.String[] r0 = com.wpengapp.support.C0647.m1654()
            int r0 = r0.length
            if (r0 != 0) goto L_0x016c
            goto L_0x019e
        L_0x016c:
            int r0 = r7.f517
            int r0 = r0 + r10
            r7.f517 = r0
            int r0 = r7.f517
            java.lang.Integer r1 = com.wpengapp.support.C0647.f1662
            if (r1 == 0) goto L_0x017c
            int r1 = r1.intValue()
            goto L_0x0192
        L_0x017c:
            java.lang.String r1 = "skad_report_texts_simple"
            java.lang.String r1 = com.wpengapp.support.C1063.m2859((java.lang.String) r1, (java.lang.String) r12)
            r2 = 10
            int r1 = com.wpengapp.support.Utils.m1857((java.lang.String) r1, (int) r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.wpengapp.support.C0647.f1662 = r1
            int r1 = r1.intValue()
        L_0x0192:
            int r0 = r0 % r1
            if (r0 != 0) goto L_0x019e
            android.os.Handler r0 = r7.f503
            java.lang.Runnable r1 = r7.f522
            r2 = 1500(0x5dc, double:7.41E-321)
            r0.postDelayed(r1, r2)
        L_0x019e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.lightstart.service.AccService.mo7735(java.lang.String, java.lang.String, java.lang.String, android.view.accessibility.AccessibilityEvent):void");
    }

    /* renamed from: ؠ */
    public final void mo7748(String str) {
        if (!SyncPayStatus.m1962() || SpHandler.f1751.mo8104().booleanValue()) {
            String r0 = SpHandler.f1752.mo8104();
            if (!this.f525) {
                AppUtils.m1146((Runnable) new C0703(this, r0, (Drawable) null));
            }
        }
    }

    /* renamed from: ؠ */
    public final Toast mo7744() {
        View inflate = View.inflate(this, R$layout.dialog_skip_anim, (ViewGroup) null);
        inflate.setTag(2131165305, (ImageView) inflate.findViewById(2131165305));
        inflate.setTag(R$id.tv_text, (TextView) inflate.findViewById(R$id.tv_text));
        Toast toast = new Toast(this);
        toast.setView(inflate);
        toast.setDuration(0);
        return toast;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: ؠ */
    public final boolean mo7749(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect r6;
        if (accessibilityNodeInfo == null || (r6 = C1279.m3433(accessibilityNodeInfo)) == null) {
            return false;
        }
        int centerX = r6.centerX();
        int centerY = r6.centerY();
        if (centerX <= 0 || centerY <= 0) {
            return false;
        }
        this.f503.postDelayed(new C0643(this, centerX, centerY), 200);
        return true;
    }

    /* renamed from: ֏ */
    public static String m630(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo r5 = C1279.m3392(accessibilityNodeInfo, "知道", "确定");
        CharSequence charSequence = null;
        if (r5 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        CharSequence r2 = C1279.m3441(r5);
        if (r2 == null || r2.length() <= 20) {
            charSequence = r2;
        }
        jSONObject.put("btx", charSequence);
        jSONObject.put("bid", C1279.m3440(r5));
        jSONObject.put("cli", r5.isClickable());
        return jSONObject.toString();
    }

    /* renamed from: ֏ */
    public final boolean mo7742(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, boolean z, boolean z2) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        outline.m2555("try ask: ", str);
        if (accessibilityNodeInfo == null) {
            return false;
        }
        try {
            AccessibilityNodeInfo r1 = C1279.m3388(accessibilityNodeInfo, accessibilityNodeInfo.getPackageName(), C0647.m1655());
            if (r1 == null) {
                r1 = C1279.m3391(accessibilityNodeInfo, (String) null, (C1156) null, C0647.m1656());
                if (r1 == null) {
                    return false;
                }
                CharSequence r9 = C1279.m3441(r1);
                if (r9 != null && r9.length() > C1149.m3086()) {
                    return false;
                }
            }
            if (z2) {
                accessibilityNodeInfo2 = r1;
            } else {
                accessibilityNodeInfo2 = C1279.m3437(r1);
            }
            if (accessibilityNodeInfo2 != null) {
                if (m634(accessibilityNodeInfo2, z, C1149.m3080())) {
                    String r92 = C1279.m3440(accessibilityNodeInfo2);
                    if (TextUtils.isEmpty(r92)) {
                        r92 = C1279.m3440(r1);
                    }
                    mo7746(accessibilityNodeInfo2, str, str2, r92, z2);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ boolean mo7740(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) {
            return false;
        }
        mo7750();
        return false;
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7738(String str, String str2, boolean z, View view) {
        mo7750();
        this.f503.post(new C0722(this, str, str2, z));
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7737(String str, String str2, boolean z) {
        mo7739(false, (AccessibilityNodeInfo) null, str, str2, (String) null, z);
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7726(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, String str3, boolean z, View view) {
        mo7750();
        this.f503.post(new C0780(this, accessibilityNodeInfo, str, str2, str3, z));
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7725(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, String str3, boolean z) {
        mo7739(true, accessibilityNodeInfo, str, str2, str3, z);
    }

    /* renamed from: ֏ */
    public final void mo7739(boolean z, AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, String str3, boolean z2) {
        boolean z3;
        if (z && accessibilityNodeInfo != null) {
            if (z2) {
                try {
                    z3 = mo7749(accessibilityNodeInfo);
                } catch (Exception e) {
                    e.getMessage();
                }
            } else {
                z3 = accessibilityNodeInfo.performAction(16);
            }
            if (z3) {
                "Skip success by user: " + str2;
            } else {
                "Skip fail by user: " + str2;
            }
            C0471.m1022(str);
        }
        if (z) {
            C1219.m3273(str, str2, false, str3, (AccNodeSelector) null, (String) null);
        } else {
            C1219.m3273(str, str2, true, (String) null, (AccNodeSelector) null, (String) null);
        }
        C0471.m1016(str, str2, !z, str3);
        C0826.m2172((int) R$string.user_skip_tips, new Object[0]);
    }

    /* renamed from: ֏ */
    public final boolean mo7743(String str, boolean z) {
        return z || str.equals(this.f504);
    }

    /* renamed from: ֏ */
    public final void mo7729(C0441 r5, AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, @NonNull PageConfig r9, float f) {
        AccessibilityNodeInfo r6;
        AccessibilityNodeInfo r0;
        String str3 = r9.f2978;
        if (str3 != null && (r0 = C1279.m3388(accessibilityNodeInfo, (CharSequence) str2, str3.split(","))) != null && m634(r0, false, f) && mo7743(str, r9.mo9158())) {
            r5.f527 = "bid";
            if (!this.f513 || !r9.mo9157()) {
                r5.f528 = C1279.m3429(r0);
            } else {
                r5.f528 = mo7749(r0);
            }
        }
        if (!r5.f528 && (r6 = C1279.m3388(accessibilityNodeInfo, (CharSequence) str2, C0647.m1655())) != null && m634(r6, false, f) && mo7743(str, r9.mo9158())) {
            r5.f527 = "bid";
            if (!this.f513 || !r9.mo9157()) {
                r5.f528 = C1279.m3429(r6);
            } else {
                r5.f528 = mo7749(r6);
            }
        }
    }

    /* renamed from: ֏ */
    public final void mo7728(C0441 r4, AccessibilityNodeInfo accessibilityNodeInfo, String str, @NonNull PageConfig r7, float f) {
        AccessibilityNodeInfo node;
        AccNodeSelector accNodeSelector = r7.f2977;
        if (accNodeSelector != null && (node = AccNodeSelector.getNode(accessibilityNodeInfo, accNodeSelector)) != null) {
            boolean z = this.f513 && r7.mo9157();
            AccessibilityNodeInfo accessibilityNodeInfo2 = null;
            if (!z) {
                accessibilityNodeInfo2 = C1279.m3437(node);
            }
            if (accessibilityNodeInfo2 == null) {
                r4.f529 = node;
            } else {
                r4.f529 = accessibilityNodeInfo2;
            }
            if (m634(r4.f529, false, f) && mo7743(str, r7.mo9158())) {
                r4.f527 = "selector";
                if (z) {
                    r4.f528 = mo7749(r4.f529);
                } else {
                    r4.f528 = r4.f529.performAction(16);
                }
            }
        }
    }

    /* renamed from: ֏ */
    public final void mo7727(C0441 r2, AccessibilityNodeInfo accessibilityNodeInfo, String str, @NonNull PageConfig r5) {
        Rect r3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.f513 && r5.mo9157() && r5.f2987 != null && r5.f2988 != null && TextUtils.equals(accessibilityNodeInfo.getPackageName(), str) && (r3 = C1279.m3433(accessibilityNodeInfo)) != null && r3.width() > 0 && r3.height() > 0) {
            r2.f527 = "inj";
            r2.f529 = null;
            if (r5.f2987.intValue() >= 0) {
                i = C0826.m2168((float) r5.f2987.intValue());
            } else {
                if (C0826.f2151) {
                    i6 = C0826.m2169().f2153;
                    i5 = C0826.m2168((float) (-r5.f2987.intValue()));
                } else {
                    i6 = C0826.m2169().f2152;
                    i5 = C0826.m2168((float) (-r5.f2987.intValue()));
                }
                i = i6 - i5;
            }
            if (r5.f2988.intValue() >= 0) {
                i2 = C0826.m2168((float) r5.f2988.intValue());
            } else {
                if (C0826.f2151) {
                    i4 = C0826.m2169().f2152;
                    i3 = C0826.m2168((float) (-r5.f2988.intValue()));
                } else {
                    i4 = C0826.m2169().f2153;
                    i3 = C0826.m2168((float) (-r5.f2988.intValue()));
                }
                i2 = i4 - i3;
            }
            this.f503.postDelayed(new C0643(this, i, i2), 200);
            r2.f528 = true;
        }
    }

    /* renamed from: ֏ */
    public static boolean m634(AccessibilityNodeInfo accessibilityNodeInfo, boolean z, float f) {
        Float r2;
        if (z || f >= 1.0f || (r2 = C1279.m3430(accessibilityNodeInfo)) == null || r2.floatValue() <= 0.0f || r2.floatValue() <= f) {
            return true;
        }
        "check ar fail: " + r2 + ">" + f;
        return false;
    }

    /* renamed from: ֏ */
    public final void mo7734(String str, String str2, String str3, int i, String str4, Float f, PageConfig r13) {
        "Skip success by " + str3 + ": " + str;
        if (i > 0) {
            this.f511.put(Integer.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()));
        }
        if ("jump".equals(str3) || "inject".equals(str3)) {
            this.f503.postDelayed(new C0591(this, str, str2, r13), ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
        } else {
            mo7736(str, str2, str4, f, r13);
        }
    }

    /* renamed from: ֏ */
    public final void mo7736(String str, String str2, String str3, Float f, @NonNull PageConfig r5) {
        C0471.m1022(str2);
        C0471.m1018(str, true, str3, f);
        this.f509.mo9253();
        if (r5.mo8702()) {
            C1266.m3358((CustomPageConfig) r5);
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7733(String str, String str2, PageConfig r9) {
        if (this.f504.equals(str)) {
            C0471.m1018(str, false, (String) null, (Float) null);
        } else {
            mo7736(str, str2, (String) null, (Float) null, r9);
        }
    }

    /* renamed from: ֏ */
    public final boolean mo7741(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, @NonNull PageConfig r12) {
        String str3;
        String str4 = r12.f2979;
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        if (str.contains("weibo") && C1279.m3392(accessibilityNodeInfo, "同意", "开启") != null) {
            return false;
        }
        StringBuilder r9 = outline.m2549("try jump to ");
        r9.append(r12.f2979);
        r9.toString();
        String[] split = str4.split("/");
        if (split.length < 2) {
            str3 = split[0];
        } else {
            str = split[0];
            str3 = split[1];
        }
        List<ResolveInfo> r2 = SystemUtils.m3522(str, str3);
        if (r2 != null && r2.size() >= 2) {
            outline.m2555("try jump fail, has multiple app: ", str4);
            return false;
        } else if (CountLimitHelper.m998("jump", 5000, 2)) {
            return true;
        } else {
            if (mo7743(str2, r12.mo9158())) {
                try {
                    Intent intent = new Intent();
                    intent.setPackage(str);
                    intent.setClassName(str, str3);
                    SystemUtils.m3510((Context) null, intent);
                    "jumpPage: " + str4;
                    return true;
                } catch (Exception e) {
                    StringBuilder r10 = outline.m2549("jumpPage: ");
                    r10.append(e.getMessage());
                    r10.toString();
                }
            }
            return false;
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7732(String str, Drawable drawable) {
        try {
            if (this.f508 == null) {
                this.f508 = mo7744();
                if (!SafeToastHooker.m2641(this.f508)) {
                    this.f508 = mo7744();
                }
                this.f523 = (TextView) this.f508.getView().getTag(R$id.tv_text);
                this.f524 = (ImageView) this.f508.getView().getTag(2131165305);
                this.f524.addOnAttachStateChangeListener(new C1005(this));
            }
            this.f523.setText(str);
            if (drawable != null) {
                this.f524.setImageDrawable(drawable);
            }
            this.f508.show();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7722(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f514) {
            "click " + i3 + ", " + i4;
            IMainService r3 = SystemApi.m2056();
            if (r3 != null) {
                try {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    float f = (float) i3;
                    float f2 = (float) i4;
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, f, f2, 1.0f, 1.0f, 0, 1.0f, 1.0f, InputEventUtils.f2811, 0);
                    obtain.setSource(InputDeviceCompat.SOURCE_TOUCHSCREEN);
                    MotionEvent obtain2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, f, f2, 0.0f, 1.0f, 0, 1.0f, 1.0f, InputEventUtils.f2811, 0);
                    obtain2.setSource(InputDeviceCompat.SOURCE_TOUCHSCREEN);
                    r3.mo8268((InputEvent) obtain, InputEventUtils.f2810);
                    r3.mo8268((InputEvent) obtain2, InputEventUtils.f2810);
                } catch (Exception e) {
                    e.getMessage();
                    SystemApi.f1981.mo7964("injc", Log.getStackTraceString(e));
                }
            }
        } else if (Build.VERSION.SDK_INT >= 24 && this != null) {
            "dispatchGesture " + i3 + ", " + i4;
            try {
                Path path = new Path();
                path.moveTo((float) i3, (float) i4);
                dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0, 50)).build(), new AccActionHelper(), (Handler) null);
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ boolean m638(Float f, AccessibilityNodeInfo accessibilityNodeInfo) {
        Float r1 = C1279.m3430(accessibilityNodeInfo);
        return r1 != null && r1.floatValue() > f.floatValue();
    }

    /* renamed from: ֏ */
    public static /* synthetic */ boolean m639(Float f, Integer num, AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence r2;
        Float r1;
        if (f != null && (r1 = C1279.m3430(accessibilityNodeInfo)) != null && r1.floatValue() > f.floatValue()) {
            return true;
        }
        if (num == null || (r2 = C1279.m3441(accessibilityNodeInfo)) == null || r2.length() <= num.intValue()) {
            return false;
        }
        return true;
    }
}
