package com.wpengapp.support;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.ActivityChooserModel;
import android.support.p003v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.Ⴅ */
public class SystemUtils {

    /* renamed from: ֏ */
    public static final int f3711 = Build.VERSION.SDK_INT;

    /* renamed from: ֏ */
    public static ResolveInfo m3507(String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            List<ResolveInfo> queryIntentActivities = m3526().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return null;
            }
            return queryIntentActivities.get(0);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ؠ */
    public static List<ComponentName> m3520() {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        List<ResolveInfo> queryIntentActivities = m3526().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null) {
            for (ResolveInfo next : queryIntentActivities) {
                if (next != null) {
                    arrayList.add(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
                    if (!TextUtils.isEmpty(next.activityInfo.targetActivity)) {
                        arrayList.add(new ComponentName(next.activityInfo.packageName, next.activityInfo.targetActivity));
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ހ */
    public static PackageInfo m3524(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return m3526().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: ށ */
    public static PackageManager m3526() {
        return AppUtils.getApplication().getPackageManager();
    }

    /* renamed from: ނ */
    public static boolean m3530(String str) {
        try {
            Intent launchIntentForPackage = m3526().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.addFlags(272629760);
            AppUtils.getApplication().startActivity(launchIntentForPackage);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: ރ */
    public static boolean m3531() {
        PowerManager powerManager = (PowerManager) AppUtils.getApplication().getSystemService("power");
        if (f3711 >= 20) {
            return powerManager.isInteractive();
        }
        return powerManager.isScreenOn();
    }

    /* renamed from: ށ */
    public static boolean m3528(String str, String str2) {
        if (C0719.m1831()) {
            if ("com.android.gallery3d".equals(str) && "com.android.camera.CameraLauncher".equals(str2)) {
                AppUtils.getApplication().sendBroadcast(new Intent("android.intent.action.CAMERA_BUTTON"));
                return true;
            } else if ("com.android.Camera".equals(str)) {
                AppUtils.getApplication().sendBroadcast(new Intent("android.intent.action.CAMERA_BUTTON"));
                return true;
            }
        }
        try {
            Intent intent = new Intent();
            intent.addFlags(272629760);
            intent.setClassName(str, str2);
            AppUtils.getApplication().startActivity(intent);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: ހ */
    public static List<PackageInfo> m3525() {
        return m3526().getInstalledPackages(0);
    }

    /* renamed from: ހ */
    public static ActivityManager.RunningServiceInfo m3523(String str, String str2) {
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) AppUtils.m1153(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningServices(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (runningServices == null) {
                return null;
            }
            for (ActivityManager.RunningServiceInfo next : runningServices) {
                if (str.equals(next.service.getPackageName()) && str2.equals(next.service.getClassName())) {
                    return next;
                }
            }
            return null;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ނ */
    public static boolean m3529() {
        int rotation = ((WindowManager) AppUtils.m1153("window")).getDefaultDisplay().getRotation();
        return rotation == 3 || rotation == 1;
    }

    /* renamed from: ֏ */
    public static Drawable m3508(String str) {
        try {
            return m3526().getApplicationIcon(m3524(str).applicationInfo);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: ֏ */
    public static boolean m3517(Intent intent) {
        try {
            List<ResolveInfo> r0 = m3521(intent);
            if (r0 == null || r0.size() <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: ؠ */
    public static List<ResolveInfo> m3522(String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            return m3526().queryIntentActivities(intent, 0);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static void m3512(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:" + str));
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("android.intent.extra.SUBJECT", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                intent.putExtra("android.intent.extra.TEXT", str3);
            }
            m3510(context, Intent.createChooser(intent, "Mail To"));
        }
    }

    /* renamed from: ؠ */
    public static String m3519(String str) {
        try {
            return m3526().getApplicationLabel(m3524(str).applicationInfo).toString();
        } catch (Exception unused) {
            return BidiFormatter.EMPTY_STRING;
        }
    }

    /* renamed from: ؠ */
    public static List<ResolveInfo> m3521(Intent intent) {
        return m3526().queryIntentActivities(intent, 0);
    }

    /* renamed from: ށ */
    public static boolean m3527(String str) {
        return m3515((Context) null, str);
    }

    /* renamed from: ֏ */
    public static void m3510(Context context, Intent intent) {
        if (context == null) {
            context = AppUtils.getApplication();
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(272629760);
        }
        context.startActivity(intent);
    }

    /* renamed from: ֏ */
    public static void m3511(Context context, Intent intent, int i) {
        if (context == null) {
            context = AppUtils.getApplication();
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(272629760);
        context.startActivity(intent);
    }

    /* renamed from: ֏ */
    public static boolean m3518(Uri uri) {
        return m3514((Context) null, uri, (String) null);
    }

    /* renamed from: ֏ */
    public static boolean m3514(Context context, Uri uri, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (str == null) {
                intent.setData(uri);
            } else {
                intent.setDataAndType(uri, str);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            if (!m3517(intent)) {
                return false;
            }
            m3510(context, intent);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: ֏ */
    public static boolean m3516(Context context, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (str2 != null) {
                intent.setPackage(str2);
            }
            intent.setData(Uri.parse("market://details?id=" + str));
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            if (m3517(intent)) {
                m3510(context, intent);
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return m3518(Uri.parse("mstore:http://app.meizu.com/phone/apps/" + str));
    }

    /* renamed from: ֏ */
    public static boolean m3515(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http")) {
            str = outline.m2556("http://", str);
        }
        return m3514(context, Uri.parse(str), (String) null);
    }

    /* renamed from: ֏ */
    public static void m3513(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                ((ClipboardManager) AppUtils.m1153("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence) null, charSequence));
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: ֏ */
    public static void m3509() {
        Object systemService = AppUtils.getApplication().getSystemService("statusbar");
        if (systemService != null) {
            try {
                Class.forName("android.app.StatusBarManager").getMethod("collapsePanels", new Class[0]).invoke(systemService, new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }
}
