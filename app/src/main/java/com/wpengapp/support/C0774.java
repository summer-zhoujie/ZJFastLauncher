package com.wpengapp.support;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.content.ContextCompat;
import android.text.TextUtils;
import com.wpengapp.lightstart.R$drawable;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.ShortcutActivity;
import com.wpengapp.lightstart.service.shortcut.ShortcutException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ը */
/* compiled from: QuickScanManager */
public class C0774 {

    /* renamed from: ֏ */
    public static final C1323<QuickScanConfig> f1993 = C1323.m3615("qsc", new QuickScanManager().getType(), (String) null, "com.tencent.mm");

    /* renamed from: ؠ */
    public static List<AppShortcut> f1994;

    /* renamed from: ހ */
    public static final Map<String, Runnable> f1995 = new HashMap();

    /* renamed from: ֏ */
    public static Intent m2080(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClass(AppUtils.getApplication(), ShortcutActivity.class);
        intent.putExtra("sid", str);
        intent.putExtra("tp", str2);
        return intent;
    }

    /* renamed from: ؠ */
    public static QuickScanConfig m2086() {
        QuickScanConfig r0 = f1993.mo9612();
        if (r0 != null) {
            return r0;
        }
        QuickScanConfig r02 = new QuickScanConfig();
        r02.f2409 = new ArrayList();
        r02.f2408 = new ArrayList();
        return r02;
    }

    /* renamed from: ހ */
    public static List<AppShortcut> m2087() {
        List<AppShortcut> list = f1994;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        AppShortcut r1 = new AppShortcut();
        r1.f936 = "wechatscan";
        r1.f937 = "com.tencent.mm";
        r1.f938 = AppUtils.m1141((int) R$string.quick_scan_wechat, new Object[0]);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI"));
        intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
        intent.setFlags(335544320);
        r1.f939 = new String[]{intent.toUri(1)};
        r1.f942 = Integer.valueOf(ContextCompat.getColor(AppUtils.getApplication(), 2130968933));
        r1.f941 = 1;
        arrayList.add(r1);
        AppShortcut r12 = new AppShortcut();
        r12.f936 = "wechatbarcode";
        r12.f937 = "com.tencent.mm";
        r12.f938 = AppUtils.m1141((int) R$string.quick_scan_wechat_barcode, new Object[0]);
        r12.f942 = Integer.valueOf(ContextCompat.getColor(AppUtils.getApplication(), 2130968933));
        r12.f941 = 2;
        arrayList.add(r12);
        AppShortcut r13 = new AppShortcut();
        r13.f936 = "aliscan";
        r13.f937 = "com.eg.android.AlipayGphone";
        r13.f938 = AppUtils.m1141((int) R$string.quick_scan_alipay, new Object[0]);
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp?saId=10000007"));
        intent2.setComponent(new ComponentName("com.eg.android.AlipayGphone", "com.alipay.mobile.quinox.LauncherActivity.alias"));
        intent2.putExtra("directly", true);
        intent2.setPackage("com.eg.android.AlipayGphone");
        Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp?saId=10000007"));
        intent3.putExtra("directly", true);
        intent3.setPackage("com.eg.android.AlipayGphone");
        r13.f939 = new String[]{intent2.toUri(1), intent3.toUri(1)};
        r13.f942 = Integer.valueOf(ContextCompat.getColor(AppUtils.getApplication(), 2130968932));
        r13.f941 = 1;
        arrayList.add(r13);
        AppShortcut r14 = new AppShortcut();
        r14.f936 = "alibarcode";
        r14.f937 = "com.eg.android.AlipayGphone";
        r14.f938 = AppUtils.m1141((int) R$string.quick_scan_alipay_barcode, new Object[0]);
        Intent intent4 = new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp?saId=20000056"));
        intent4.setComponent(new ComponentName("com.eg.android.AlipayGphone", "com.eg.android.AlipayGphone.FastStartActivity"));
        intent4.putExtra("directly", true);
        intent4.setPackage("com.eg.android.AlipayGphone");
        Intent intent5 = new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp?saId=20000056"));
        intent5.putExtra("directly", true);
        intent5.setPackage("com.eg.android.AlipayGphone");
        r14.f939 = new String[]{intent4.toUri(1), intent5.toUri(1)};
        r14.f942 = Integer.valueOf(ContextCompat.getColor(AppUtils.getApplication(), 2130968932));
        r14.f941 = 2;
        arrayList.add(r14);
        f1994 = arrayList;
        return arrayList;
    }

    /* renamed from: ށ */
    public static List<AppShortcut> m2088() {
        if (CollectionUtils.m1659((Collection) m2086().f2409)) {
            return m2086().f2409;
        }
        return m2087();
    }

    /* renamed from: ނ */
    public static void m2089() {
        if (C1146.m3072()) {
            TaskManager.m2715((Runnable) C1332.f3804);
            f1995.put("wechatbarcode", new WechatBarcodeAction());
        }
    }

    /* renamed from: ֏ */
    public static void m2083(String str) {
        Intent intent;
        if (!TextUtils.isEmpty(str)) {
            "exec " + str;
            AppShortcut r0 = m2085(str);
            if (r0 != null) {
                Runnable runnable = f1995.get(str);
                if (runnable != null) {
                    try {
                        runnable.run();
                        return;
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
                String[] strArr = r0.f939;
                if (strArr != null) {
                    for (String parseUri : strArr) {
                        try {
                            intent = Intent.parseUri(parseUri, 1);
                        } catch (URISyntaxException e2) {
                            e2.getMessage();
                            intent = null;
                        }
                        if (intent != null) {
                            try {
                                SystemUtils.m3510((Context) null, intent);
                                return;
                            } catch (Exception e3) {
                                e3.toString();
                            }
                        }
                    }
                    throw new RuntimeException("intents error-2");
                }
                throw new RuntimeException("intents error-1");
            }
            throw new RuntimeException(outline.m2545("id[", str, "] is not found"));
        }
        throw new NullPointerException("id is null");
    }

    /* renamed from: ؠ */
    public static AppShortcut m2085(String str) {
        List<AppShortcut> r0;
        if (TextUtils.isEmpty(str) || (r0 = m2088()) == null) {
            return null;
        }
        for (AppShortcut next : r0) {
            if (str.equals(next.f936)) {
                return next;
            }
        }
        if (r0 != m2087()) {
            for (AppShortcut next2 : m2087()) {
                if (str.equals(next2.f936)) {
                    return next2;
                }
            }
        }
        return null;
    }

    /* renamed from: ֏ */
    public static void m2082() {
        if (Build.VERSION.SDK_INT >= 25) {
            try {
                List<String> list = m2086().f2408;
                if (CollectionUtils.m1657((Collection) list)) {
                    ArrayList arrayList = new ArrayList();
                    if (Build.VERSION.SDK_INT >= 25) {
                        ((ShortcutManager) AppUtils.m1153("shortcut")).setDynamicShortcuts(arrayList);
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (String next : list) {
                    AppShortcut r5 = m2085(next);
                    if (r5 != null) {
                        Bitmap r6 = r5.mo8070();
                        Icon icon = null;
                        if (r6 != null) {
                            icon = Icon.createWithBitmap(r6);
                        }
                        if (icon == null) {
                            icon = Icon.createWithResource(AppUtils.getApplication(), 2131099733);
                        }
                        Application r8 = AppUtils.getApplication();
                        arrayList2.add(new ShortcutInfo.Builder(r8, "menu_" + r5.f936).setShortLabel(r5.f938).setLongLabel(r5.f938).setIcon(icon).setIntent(m2080(next, "appmenu")).build());
                    }
                }
                if (Build.VERSION.SDK_INT >= 25) {
                    ((ShortcutManager) AppUtils.m1153("shortcut")).setDynamicShortcuts(arrayList2);
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: ֏ */
    public static Bitmap m2081(AppShortcut r11) {
        if (r11.f942 == null) {
            return null;
        }
        int i = r11.f941;
        int i2 = i == 1 ? R$drawable.ic_scan : i == 2 ? R$drawable.ic_barcode : -1;
        if (i2 == -1) {
            return null;
        }
        int intValue = r11.f942.intValue();
        try {
            int r2 = C0826.m2168(64.0f);
            Bitmap createBitmap = Bitmap.createBitmap(r2, r2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            float f = ((float) r2) / 2.0f;
            Paint paint = new Paint();
            paint.setColor(intValue);
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            canvas.drawCircle(f, f, f, paint);
            Bitmap r112 = Utils.m1862(AppUtils.getApplication().getDrawable(i2));
            Rect rect = new Rect(0, 0, r112.getWidth(), r112.getHeight());
            int i3 = (int) (((double) r2) * 0.625d);
            int i4 = (r2 - i3) / 2;
            int i5 = i3 + i4;
            Rect rect2 = new Rect(i4, i4, i5, i5);
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            canvas.drawBitmap(r112, rect, rect2, paint2);
            return createBitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static void m2084(String str, String str2, Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("sid", str);
        hashMap.put(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, str2);
        if (th != null) {
            hashMap.put(NotificationCompat.CATEGORY_ERROR, th.toString());
        }
        UMengManager.m1406("SHORTCUT", (Map<String, String>) hashMap);
        if (th != null) {
            UMengManager.m1407((Throwable) new ShortcutException(th, str, str2));
        }
    }
}
