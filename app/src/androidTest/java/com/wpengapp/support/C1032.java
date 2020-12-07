package com.wpengapp.support;

import android.accessibilityservice.AccessibilityService;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.projection.MediaProjection;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.wpengapp.lightstart.R$dimen;
import com.wpengapp.lightstart.R$drawable;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.CustomActivity;
import com.wpengapp.lightstart.activity.CustomRuleEditActivity;
import com.wpengapp.lightstart.service.AccService;
import com.wpengapp.lightstart.service.AccService24;
import com.wpengapp.lightstart.service.custom.CustomView;
import com.wpengapp.support.accservice.BaseAccessibilityService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.व */
/* compiled from: CustomManager */
public class C1032 {

    /* renamed from: ֏ */
    public static final String f2953 = (AppUtils.m1163() + "." + "CustomManager");

    /* renamed from: ؠ */
    public static C0837 f2954;

    /* renamed from: ހ */
    public static FloatWindow f2955;

    /* renamed from: ށ */
    public static String f2956;

    /* renamed from: ނ */
    public static String f2957;

    /* renamed from: ރ */
    public static SharedPreferences f2958;

    /* renamed from: ބ */
    public static C1033 f2959;

    /* renamed from: ޅ */
    public static C1035 f2960;

    /* renamed from: ކ */
    public static C1034 f2961;

    /* renamed from: އ */
    public static Display f2962 = ((WindowManager) AppUtils.m1153("window")).getDefaultDisplay();

    /* renamed from: ވ */
    public static boolean f2963 = true;

    /* renamed from: މ */
    public static HandlerThread f2964;

    /* renamed from: ފ */
    public static Handler f2965;

    /* renamed from: ދ */
    public static NodeInfo f2966;

    /* renamed from: ތ */
    public static LinkedHashMap<String, String> f2967;

    /* renamed from: ލ */
    public static final RemoteMethod f2968 = new C0942("CustomManager");

    /* renamed from: ގ */
    public static C0837.C0838 f2969 = new C1044();

    /* renamed from: com.wpengapp.support.व$֏ */
    /* compiled from: CustomManager */
    private static class C1033 extends BroadcastReceiver {
        public /* synthetic */ C1033(C0942 r1) {
        }

        public void onReceive(Context context, Intent intent) {
            C0837 r1 = C1032.f2954;
            if (r1 != null && r1.mo8735()) {
                C1032.m2771();
            }
            C1032.m2743();
        }
    }

    /* renamed from: com.wpengapp.support.व$ؠ */
    /* compiled from: CustomManager */
    private static class C1034 extends BroadcastReceiver {
        public /* synthetic */ C1034(C0942 r1) {
        }

        public void onReceive(Context context, Intent intent) {
            C1032.m2743();
        }
    }

    /* renamed from: com.wpengapp.support.व$ހ */
    /* compiled from: CustomManager */
    private static class C1035 extends BroadcastReceiver {
        public /* synthetic */ C1035(C0942 r1) {
        }

        public void onReceive(Context context, Intent intent) {
            C1032.m2756();
        }
    }

    static {
        if (C1146.m3072()) {
            f2968.mo8565();
        }
    }

    /* renamed from: ؠ */
    public static void m2756() {
        if (!C1146.m3072()) {
            f2968.mo8564("dismissCustomFloat");
            return;
        }
        MediaProjection mediaProjection = ScreencapHelper.f579;
        if (mediaProjection != null) {
            mediaProjection.stop();
            ScreencapHelper.f579 = null;
        }
        m2743();
        ((NotificationManager) AppUtils.m1153("notification")).cancel(7342123);
        if (f2954 != null) {
            AppUtils.m1155((Runnable) C0579.f1250);
        }
        System.gc();
    }

    /* renamed from: ހ */
    public static synchronized void m2758() {
        int i;
        synchronized (C1032.class) {
            BaseAccessibilityService baseAccessibilityService = BaseAccessibilityService.f600;
            if (baseAccessibilityService != null) {
                if (AccServiceHelper.m2016(AccService.class, AccService24.class)) {
                    m2743();
                    if (C0909.m2387()) {
                        m2756();
                        Intent intent = new Intent(baseAccessibilityService, CustomActivity.class);
                        intent.putExtra("autostart", true);
                        SystemUtils.m3510((Context) baseAccessibilityService, intent);
                        return;
                    }
                    if (f2954 != null) {
                        AppUtils.m1146((Runnable) C1097.f3119);
                    }
                    MediaProjection mediaProjection = ScreencapHelper.f579;
                    if (mediaProjection == null) {
                        TaskManager.m2715((Runnable) new C1123(baseAccessibilityService, (Bitmap) null));
                        return;
                    }
                    int i2 = 1080;
                    if (C0826.m2169().f2152 <= 1080) {
                        if (m2760()) {
                            i2 = C0826.m2169().f2153;
                            i = C0826.m2169().f2152;
                        } else {
                            i2 = C0826.m2169().f2152;
                            i = C0826.m2169().f2153;
                        }
                    } else if (m2760()) {
                        i2 = (int) ((((float) C0826.m2169().f2153) / ((float) C0826.m2169().f2152)) * ((float) 1080));
                        i = 1080;
                    } else {
                        i = (int) ((((float) C0826.m2169().f2153) / ((float) C0826.m2169().f2152)) * ((float) 1080));
                    }
                    ScreencapHelper.m730(mediaProjection, i2, i, f2965, new C0793(baseAccessibilityService));
                    return;
                }
            }
            C0826.m2179(R$string.service_not_enable, new Object[0]);
        }
    }

    /* renamed from: ށ */
    public static void m2759() {
        if (C1146.m3072()) {
            f2958 = AppUtils.m1149("CustomManager");
            f2959 = new C1033((C0942) null);
            AppUtils.getApplication().registerReceiver(f2959, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            f2960 = new C1035((C0942) null);
            AppUtils.getApplication().registerReceiver(f2960, new IntentFilter(f2953));
            f2961 = new C1034((C0942) null);
            AppUtils.getApplication().registerReceiver(f2961, new IntentFilter("android.intent.action.SCREEN_OFF"));
            f2964 = new C1076("CustomManager");
            f2964.start();
            f2965 = new Handler(f2964.getLooper());
            if (C1146.m3072()) {
                f2967 = new LinkedHashMap<>();
                ForegroundAppManager.m1395((OnForegroundChangeListener) C0941.f2572);
            }
        }
    }

    /* renamed from: ނ */
    public static boolean m2760() {
        int rotation = f2962.getRotation();
        return rotation == 3 || rotation == 1;
    }

    /* renamed from: ރ */
    public static boolean m2761() {
        if (!C1146.m3072()) {
            return f2968.mo8564("isShowingCustomFloat").mo9280();
        }
        C0837 r0 = f2954;
        return r0 != null && r0.mo8735();
    }

    /* renamed from: ބ */
    public static /* synthetic */ void m2762() {
        FloatWindow r0 = f2955;
        if (r0 != null) {
            r0.f2735.setBackground((Drawable) null);
            f2955.mo9027();
            f2955 = null;
        }
        C0837 r02 = f2954;
        if (r02 != null) {
            r02.f2185.setAlpha(0.9f);
        }
    }

    /* renamed from: ޅ */
    public static /* synthetic */ void m2763() {
        C0837 r0 = f2954;
        if (r0 != null) {
            r0.f2184.animate().scaleX(0.0f).scaleY(0.0f).setDuration(250).alpha(0.3f).withEndAction(new C0708(r0, r0.f2184.getScaleX(), r0.f2184.getScaleY(), r0.f2184.getAlpha()));
            r0.f2185.animate().scaleX(0.0f).scaleY(0.0f).setDuration(250).alpha(0.3f).withEndAction(new C1236(r0, r0.f2184.getScaleX(), r0.f2184.getScaleY(), r0.f2184.getAlpha()));
            f2954 = null;
        }
    }

    /* renamed from: ދ */
    public static boolean m2769() {
        if (!C1146.m3072()) {
            return f2968.mo8564("needRequestMediaProjection").mo9280();
        }
        return f2963;
    }

    /* renamed from: ތ */
    public static boolean m2770() {
        if (!C1146.m3072()) {
            return f2968.mo8564("showCustomFloat").mo9280();
        }
        BaseAccessibilityService baseAccessibilityService = BaseAccessibilityService.f600;
        if (baseAccessibilityService == null) {
            return false;
        }
        ScreencapHelper.m731((RetCallback<MediaProjection>) new C0769(baseAccessibilityService));
        AppUtils.m1155((Runnable) new C1054(baseAccessibilityService));
        return true;
    }

    /* renamed from: ލ */
    public static void m2771() {
        int i = f2958.getInt("x", (int) (((float) C0826.m2169().f2152) * 0.618f));
        int i2 = f2958.getInt("y", (C0826.m2169().f2153 * 3) / 4);
        if (m2760()) {
            C0837 r2 = f2954;
            int i3 = C0826.m2169().f2152 - i;
            FloatWindow r0 = r2.f2182;
            WindowManager.LayoutParams layoutParams = r0.f2734;
            layoutParams.x = i2;
            layoutParams.y = i3;
            r0.mo9031();
            return;
        }
        FloatWindow r22 = f2954.f2182;
        WindowManager.LayoutParams layoutParams2 = r22.f2734;
        layoutParams2.x = i;
        layoutParams2.y = i2;
        r22.mo9031();
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2752(String str, String str2) {
        try {
            f2967.remove(str);
            f2967.put(str, str2);
            if (f2967.size() > 5) {
                f2967.remove((String) f2967.entrySet().iterator().next().getKey());
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2745(Context context) {
        if (f2954 == null) {
            C0837 r4 = new C0837(context, 2003, false, R$layout.view_custom_float, context.getResources().getDimensionPixelSize(R$dimen.custom_float_ball_size));
            r4.f2200 = 400;
            r4.f2198 = false;
            r4.f2183.setContentDescription("CustomButton");
            r4.f2186 = f2969;
            r4.f2202 = 4;
            r4.mo8732((byte) -1, (byte) 1);
            r4.mo8732((byte) 1, (byte) 0);
            r4.mo8732((byte) 2, (byte) 0);
            r4.mo8732((byte) 4, (byte) 0);
            r4.mo8732((byte) 8, (byte) 0);
            f2954 = r4;
        }
        m2771();
        Application r10 = AppUtils.getApplication();
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) AppUtils.m1153("notification")).createNotificationChannel(new NotificationChannel("CustomManager", AppUtils.m1141((int) R$string.custom_rule, new Object[0]), 2));
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(r10, "CustomManager");
        String string = r10.getString(R$string.custom_notification);
        builder.setContentTitle(string);
        builder.setContentText(r10.getString(R$string.custom_notification_des));
        builder.setLargeIcon(Utils.m1862(SystemUtils.m3508(AppUtils.m1163())));
        builder.setSmallIcon(R$drawable.ic_tile);
        builder.setTicker(string);
        builder.setOngoing(true);
        builder.setAutoCancel(true);
        builder.setOnlyAlertOnce(true);
        builder.setSound((Uri) null);
        builder.setContentIntent(PendingIntent.getBroadcast(r10, 7342123, new Intent(f2953), 268435456));
        ((NotificationManager) AppUtils.m1153("notification")).notify(7342123, builder.build());
    }

    /* renamed from: ؠ */
    public static /* synthetic */ void m2757(AccessibilityService accessibilityService, Bitmap bitmap) {
        List<NodeInfo> list;
        String str;
        if (accessibilityService != null) {
            AccessibilityNodeInfo r0 = AccServiceHelper.m2018(accessibilityService);
            if (r0 != null && TextUtils.equals("CustomButton", r0.getContentDescription())) {
                r0 = AccServiceHelper.m2010(accessibilityService, (CharSequence) ForegroundAppManager.f1241).f1951;
            }
            if (r0 == null) {
                C0826.m2172((int) R$string.custom_no_nodes, new Object[0]);
                if (f2954 != null) {
                    AppUtils.m1146((Runnable) C1048.f3010);
                    return;
                }
                return;
            }
            f2956 = String.valueOf(r0.getPackageName());
            if (!AppUtils.m1163().equals(f2956) || ((str = ForegroundAppManager.f1240) != null && str.endsWith("TestActivity"))) {
                if (TextUtils.equals(ForegroundAppManager.f1241, f2956)) {
                    f2957 = ForegroundAppManager.m1391();
                } else {
                    String str2 = f2967.get(f2956);
                    if (TextUtils.isEmpty(str2)) {
                        f2957 = null;
                    } else {
                        f2957 = ForegroundAppManager.m1393(f2956, str2);
                    }
                    StringBuilder r1 = outline.m2549("Foreground pkg do not match node pkg, ");
                    r1.append(ForegroundAppManager.m1391());
                    r1.append(", ");
                    r1.append(f2956);
                    r1.append(", ");
                    r1.append(f2957);
                    r1.toString();
                }
                if (TextUtils.isEmpty(f2957)) {
                    C0826.m2179(R$string.custom_page_error, new Object[0]);
                    if (f2954 != null) {
                        AppUtils.m1146((Runnable) C0914.f2460);
                    }
                    C0471.m1014(f2956, ForegroundAppManager.m1391());
                    return;
                }
                int r12 = C0919.m2420();
                boolean z = r12 == 1 || r12 == 2;
                if (z) {
                    list = C1279.m3403(r0, 0.04f, false);
                } else {
                    list = C1279.m3403(r0, 0.4f, true);
                }
                AppUtils.m1146((Runnable) new C0806(list, bitmap, z));
                return;
            }
            C0826.m2179(R$string.custom_app_error, new Object[0]);
            if (f2954 != null) {
                AppUtils.m1146((Runnable) C0757.f1954);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        return;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m2753(List<com.wpengapp.support.NodeInfo> r8, Bitmap r9, boolean r10) {
        /*
            java.lang.Class<com.wpengapp.support.व> r0 = com.wpengapp.support.C1032.class
            monitor-enter(r0)
            com.wpengapp.support.accservice.BaseAccessibilityService r1 = com.wpengapp.support.accservice.BaseAccessibilityService.f600     // Catch:{ all -> 0x00d4 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            r2 = 0
            if (r10 != 0) goto L_0x0025
            boolean r3 = com.wpengapp.support.CollectionUtils.m1657((java.util.Collection) r8)     // Catch:{ all -> 0x00d4 }
            if (r3 == 0) goto L_0x0025
            r8 = 2131492987(0x7f0c007b, float:1.8609441E38)
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x00d4 }
            com.wpengapp.support.C0826.m2172((int) r8, (java.lang.Object[]) r9)     // Catch:{ all -> 0x00d4 }
            com.wpengapp.support.إ r8 = f2954     // Catch:{ all -> 0x00d4 }
            if (r8 == 0) goto L_0x0023
            com.wpengapp.support.н r8 = com.wpengapp.support.C0705.f1818     // Catch:{ all -> 0x00d4 }
            com.wpengapp.support.AppUtils.m1146((java.lang.Runnable) r8)     // Catch:{ all -> 0x00d4 }
        L_0x0023:
            monitor-exit(r0)
            return
        L_0x0025:
            r3 = 2131296377(0x7f090079, float:1.8210669E38)
            r4 = 0
            android.view.View r3 = android.view.View.inflate(r1, r3, r4)     // Catch:{ all -> 0x00d4 }
            if (r9 == 0) goto L_0x0037
            com.wpengapp.support.כ r4 = new com.wpengapp.support.כ     // Catch:{ all -> 0x00d4 }
            r4.<init>(r3, r9)     // Catch:{ all -> 0x00d4 }
            r3.post(r4)     // Catch:{ all -> 0x00d4 }
        L_0x0037:
            r9 = 2131165552(0x7f070170, float:1.7945324E38)
            android.view.View r9 = r3.findViewById(r9)     // Catch:{ all -> 0x00d4 }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ all -> 0x00d4 }
            if (r10 == 0) goto L_0x0049
            r4 = 2131492966(0x7f0c0066, float:1.8609399E38)
            r9.setText(r4)     // Catch:{ all -> 0x00d4 }
            goto L_0x004f
        L_0x0049:
            r4 = 2131492965(0x7f0c0065, float:1.8609397E38)
            r9.setText(r4)     // Catch:{ all -> 0x00d4 }
        L_0x004f:
            r9 = 2131165514(0x7f07014a, float:1.7945247E38)
            android.view.View r9 = r3.findViewById(r9)     // Catch:{ all -> 0x00d4 }
            com.wpengapp.support.ɤ r4 = com.wpengapp.support.C0577.f1244     // Catch:{ all -> 0x00d4 }
            r9.setOnClickListener(r4)     // Catch:{ all -> 0x00d4 }
            r9 = 2131165394(0x7f0700d2, float:1.7945004E38)
            android.view.View r9 = r3.findViewById(r9)     // Catch:{ all -> 0x00d4 }
            com.wpengapp.support.પ r4 = new com.wpengapp.support.પ     // Catch:{ all -> 0x00d4 }
            r4.<init>(r9)     // Catch:{ all -> 0x00d4 }
            r9.post(r4)     // Catch:{ all -> 0x00d4 }
            r4 = 2131165264(0x7f070050, float:1.794474E38)
            android.view.View r4 = r3.findViewById(r4)     // Catch:{ all -> 0x00d4 }
            com.wpengapp.lightstart.service.custom.CustomView r4 = (com.wpengapp.lightstart.service.custom.CustomView) r4     // Catch:{ all -> 0x00d4 }
            r4.setBackgroundColor(r2)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "CustomManager"
            r4.setContentDescription(r5)     // Catch:{ all -> 0x00d4 }
            com.wpengapp.support.մ r5 = new com.wpengapp.support.մ     // Catch:{ all -> 0x00d4 }
            r5.<init>(r9, r4, r10)     // Catch:{ all -> 0x00d4 }
            r4.setOnNodeClickListener(r5)     // Catch:{ all -> 0x00d4 }
            android.view.WindowManager$LayoutParams r9 = new android.view.WindowManager$LayoutParams     // Catch:{ all -> 0x00d4 }
            r5 = 2003(0x7d3, float:2.807E-42)
            r6 = 776(0x308, float:1.087E-42)
            r7 = -2
            r9.<init>(r5, r6, r7)     // Catch:{ all -> 0x00d4 }
            boolean r5 = m2760()     // Catch:{ all -> 0x00d4 }
            r6 = 1
            if (r5 == 0) goto L_0x0097
            r9.screenOrientation = r2     // Catch:{ all -> 0x00d4 }
            goto L_0x0099
        L_0x0097:
            r9.screenOrientation = r6     // Catch:{ all -> 0x00d4 }
        L_0x0099:
            com.wpengapp.support.ߗ r5 = new com.wpengapp.support.ߗ     // Catch:{ all -> 0x00d4 }
            r5.<init>((android.content.Context) r1, (android.view.WindowManager.LayoutParams) r9, (android.view.View) r3)     // Catch:{ all -> 0x00d4 }
            f2955 = r5     // Catch:{ all -> 0x00d4 }
            boolean r9 = m2760()     // Catch:{ all -> 0x00d4 }
            if (r9 == 0) goto L_0x00b8
            com.wpengapp.support.ߗ r9 = f2955     // Catch:{ all -> 0x00d4 }
            com.wpengapp.support.ס$֏ r1 = com.wpengapp.support.C0826.m2169()     // Catch:{ all -> 0x00d4 }
            int r1 = r1.f2153     // Catch:{ all -> 0x00d4 }
            com.wpengapp.support.ס$֏ r3 = com.wpengapp.support.C0826.m2169()     // Catch:{ all -> 0x00d4 }
            int r3 = r3.f2152     // Catch:{ all -> 0x00d4 }
            r9.mo9029(r2, r2, r1, r3)     // Catch:{ all -> 0x00d4 }
            goto L_0x00c9
        L_0x00b8:
            com.wpengapp.support.ߗ r9 = f2955     // Catch:{ all -> 0x00d4 }
            com.wpengapp.support.ס$֏ r1 = com.wpengapp.support.C0826.m2169()     // Catch:{ all -> 0x00d4 }
            int r1 = r1.f2152     // Catch:{ all -> 0x00d4 }
            com.wpengapp.support.ס$֏ r3 = com.wpengapp.support.C0826.m2169()     // Catch:{ all -> 0x00d4 }
            int r3 = r3.f2153     // Catch:{ all -> 0x00d4 }
            r9.mo9029(r2, r2, r1, r3)     // Catch:{ all -> 0x00d4 }
        L_0x00c9:
            r4.setClickableNodes(r8)     // Catch:{ all -> 0x00d4 }
            if (r10 != 0) goto L_0x00cf
            r2 = 1
        L_0x00cf:
            r4.mo7778(r2)     // Catch:{ all -> 0x00d4 }
            monitor-exit(r0)
            return
        L_0x00d4:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1032.m2753(java.util.List, android.graphics.Bitmap, boolean):void");
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2747(View view, Bitmap bitmap) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[0] == 0 && iArr[1] == 0) {
                view.setBackground(new BitmapDrawable(view.getResources(), bitmap));
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            Rect rect = new Rect(iArr[0], iArr[1], bitmap.getWidth() - iArr[0], bitmap.getHeight() - iArr[1]);
            canvas.drawBitmap(bitmap, rect, new Rect(0, 0, rect.width(), rect.height()), (Paint) null);
            bitmap.recycle();
            view.setBackground(new BitmapDrawable(view.getResources(), createBitmap));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2748(View view, CustomView customView, boolean z, NodeInfo r14, int i, int i2) {
        boolean z2;
        View view2 = view;
        CustomView customView2 = customView;
        NodeInfo r7 = r14;
        if (z || r7 != null) {
            customView.mo7778(false);
            if (z) {
                if (r7 == null || f2966 == r7) {
                    customView.setHeightLightNode((NodeInfo) null);
                    int i3 = i;
                    customView.setHeightLightPoint(new Point(i, i2));
                    z2 = true;
                } else {
                    customView.setHeightLightNode(r14);
                    customView.setHeightLightPoint((Point) null);
                    int i4 = i;
                    int i5 = i2;
                    z2 = false;
                }
                f2966 = r7;
            } else {
                int i6 = i;
                int i7 = i2;
                customView.setHeightLightNode(r14);
                customView.setHeightLightPoint((Point) null);
                z2 = false;
            }
            TextView textView = (TextView) view.findViewById(2131165552);
            if (z) {
                textView.setText(R$string.custom_confirm2);
            } else {
                textView.setText(R$string.custom_confirm);
            }
            TextView textView2 = (TextView) view.findViewById(R$id.tv_reselect);
            textView2.setVisibility(0);
            TextView textView3 = (TextView) view.findViewById(R$id.tv_exit);
            textView3.setText(2131493133);
            textView3.setOnClickListener(new C0656(z2, z, i, i2, r14));
            textView2.setOnClickListener(new C0476(customView, z, textView, textView2, textView3));
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2754(boolean z, boolean z2, int i, int i2, NodeInfo r4, View view) {
        if (z) {
            m2751((NodeInfo) null, z2, i, i2);
        } else {
            m2751(r4, z2, i, i2);
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2749(CustomView customView, boolean z, TextView textView, TextView textView2, TextView textView3, View view) {
        f2966 = null;
        customView.setHeightLightNode((NodeInfo) null);
        customView.setHeightLightPoint((Point) null);
        customView.mo7778(!z);
        if (z) {
            textView.setText(R$string.custom_click_btn2);
        } else {
            textView.setText(R$string.custom_click_btn);
        }
        textView2.setVisibility(8);
        textView3.setText(R$string.custom_exit);
        textView3.setOnClickListener(C1163.f3305);
    }

    /* renamed from: ֏ */
    public static void m2751(NodeInfo r8, boolean z, int i, int i2) {
        int i3;
        int i4;
        String str;
        m2743();
        CustomPageConfig r0 = new CustomPageConfig();
        r0.f2106 = System.currentTimeMillis();
        if (r8 != null) {
            r0.f2978 = r8.f3033;
            if (!TextUtils.isEmpty(r8.f3032)) {
                str = r8.f3032.toString().trim().toLowerCase();
                String[] r3 = C0647.m1656();
                int length = r3.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    String str2 = r3[i5];
                    if (str.contains(str2)) {
                        str = str2;
                        break;
                    }
                    i5++;
                }
            } else {
                str = null;
            }
            r0.f2982 = str;
            if (TextUtils.isEmpty(r0.f2982) && TextUtils.isEmpty(r8.f3033)) {
                r0.f2977 = r8.f3029;
            }
            r0.f2984 = Float.valueOf(new BigDecimal((double) (r8.f3031 * 2.0f)).setScale(4, 4).floatValue());
            if (r0.f2984.floatValue() == 0.0f) {
                r0.f2984 = Float.valueOf(r8.f3031 * 2.0f);
            }
        }
        r0.f2981 = 0;
        if (z) {
            r0.f2986 = 1;
        }
        if (z && r8 == null) {
            int r82 = C0826.m2178((float) i);
            int r9 = C0826.m2178((float) i2);
            if (m2760()) {
                i4 = C0826.m2178((float) C0826.m2169().f2153);
                i3 = C0826.m2178((float) C0826.m2169().f2152);
            } else {
                i4 = C0826.m2178((float) C0826.m2169().f2152);
                i3 = C0826.m2178((float) C0826.m2169().f2153);
            }
            if (r82 > i4 / 2) {
                r82 = -(i4 - r82);
            }
            if (r9 > i3 / 2) {
                r9 = -(i3 - r9);
            }
            r0.f2987 = Integer.valueOf(r82);
            r0.f2988 = Integer.valueOf(r9);
        }
        String str3 = f2956;
        String str4 = f2957;
        T r10 = C0909.m2390();
        CustomAppConfig r11 = r10.f1747.get(str3);
        if (r11 == null) {
            r11 = new CustomAppConfig();
            r11.f2437 = new HashMap();
            r10.f1747.put(str3, r11);
        }
        r0.f2105 = C0909.m2389();
        Map<String, List<CustomPageConfig>> map = r11.f2437;
        List list = map.get(str4);
        if (list == null) {
            list = new ArrayList();
            map.put(str4, list);
        }
        list.add(r0);
        C1323<CustomConfig> r83 = C0909.f2440;
        r83.f3785 = r10;
        r83.f3791 = true;
        outline.m2551((C1323) r83, (Object) r10);
        C0471.m1024(f2956, f2957, r0);
        AppUtils.m1147((Runnable) new C0695(r0), 300);
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2750(CustomPageConfig r3) {
        CustomRuleEditActivity.m447(AppUtils.getApplication(), f2956, f2957, r3);
        C0826.m2179(R$string.custom_success, new Object[0]);
    }

    /* renamed from: ֏ */
    public static void m2743() {
        f2966 = null;
        if (f2955 != null) {
            AppUtils.m1155((Runnable) C0762.f1962);
        }
    }
}
