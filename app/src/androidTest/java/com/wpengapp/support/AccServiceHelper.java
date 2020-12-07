package com.wpengapp.support;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.wpengapp.support.accservice.BaseAccessibilityService;
import java.util.List;

/* renamed from: com.wpengapp.support.Ӳ */
public class AccServiceHelper {

    /* renamed from: ֏ */
    public static AccessibilityManager f1949 = ((AccessibilityManager) AppUtils.m1153("accessibility"));

    /* renamed from: com.wpengapp.support.Ӳ$֏ */
    /* compiled from: AccServiceHelper */
    public static class C0755 {

        /* renamed from: ֏ */
        public AccessibilityNodeInfo f1950;

        /* renamed from: ؠ */
        public AccessibilityNodeInfo f1951;
    }

    /* renamed from: ֏ */
    public static boolean m2016(Class... clsArr) {
        if (!(clsArr == null || clsArr.length == 0)) {
            for (Class name : clsArr) {
                if (m2020(name.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ؠ */
    public static BaseAccessibilityService m2019() {
        BaseAccessibilityService baseAccessibilityService = BaseAccessibilityService.f600;
        if (baseAccessibilityService == null) {
            return null;
        }
        if (m2017(baseAccessibilityService.getClass().getName())) {
            return BaseAccessibilityService.f600;
        }
        return null;
    }

    /* renamed from: ֏ */
    public static boolean m2017(String... strArr) {
        if (!(strArr == null || strArr.length == 0)) {
            for (String r3 : strArr) {
                if (m2020(r3)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ؠ */
    public static boolean m2020(String str) {
        BaseAccessibilityService baseAccessibilityService = BaseAccessibilityService.f600;
        if (baseAccessibilityService != null && str.equals(baseAccessibilityService.getClass().getName())) {
            return m2015(AppUtils.m1163());
        }
        String r0 = AppUtils.m1163();
        if (SystemUtils.m3523(r0, str) == null) {
            return false;
        }
        return m2015(r0);
    }

    /* renamed from: ֏ */
    public static boolean m2015(String str) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = f1949.getEnabledAccessibilityServiceList(-1);
        if (enabledAccessibilityServiceList == null) {
            return false;
        }
        for (AccessibilityServiceInfo resolveInfo : enabledAccessibilityServiceList) {
            try {
                if (str.equals(resolveInfo.getResolveInfo().serviceInfo.packageName)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: ֏ */
    public static void m2012(Context context) {
        try {
            if (Build.BRAND.toLowerCase().equals("samsung")) {
                Intent intent = new Intent();
                intent.setClassName("com.android.settings", "com.android.settings.Settings$AccessibilityInstalledServiceActivity");
                SystemUtils.m3510(context, intent);
                m2011();
                return;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            SystemUtils.m3510(context, new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            m2011();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    /* renamed from: ؠ */
    public static AccessibilityNodeInfo m2018(AccessibilityService accessibilityService) {
        return m2010(accessibilityService, (CharSequence) null).f1951;
    }

    /* renamed from: ֏ */
    public static void m2011() {
        if (AppUtils.m1169()) {
            C0786.m2104(AppUtils.getApplication(), new C1147(), new IntentFilter("com.wpengapp.bas.open"), (Handler) null, 300000);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0061 A[Catch:{ Exception -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062 A[Catch:{ Exception -> 0x0067 }] */
    @android.support.annotation.NonNull
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.wpengapp.support.AccServiceHelper.C0755 m2010(android.accessibilityservice.AccessibilityService r6, java.lang.CharSequence r7) {
        /*
            if (r6 != 0) goto L_0x0008
            com.wpengapp.support.Ӳ$֏ r6 = new com.wpengapp.support.Ӳ$֏
            r6.<init>()
            return r6
        L_0x0008:
            com.wpengapp.support.Ӳ$֏ r0 = new com.wpengapp.support.Ӳ$֏
            r0.<init>()
            android.view.accessibility.AccessibilityNodeInfo r1 = r6.getRootInActiveWindow()     // Catch:{ Exception -> 0x001c }
            r0.f1950 = r1     // Catch:{ Exception -> 0x001c }
            android.view.accessibility.AccessibilityNodeInfo r1 = r0.f1950     // Catch:{ Exception -> 0x001c }
            android.view.accessibility.AccessibilityNodeInfo r1 = m2009((android.view.accessibility.AccessibilityNodeInfo) r1, (java.lang.CharSequence) r7)     // Catch:{ Exception -> 0x001c }
            r0.f1951 = r1     // Catch:{ Exception -> 0x001c }
            goto L_0x0020
        L_0x001c:
            r1 = move-exception
            r1.getMessage()
        L_0x0020:
            android.view.accessibility.AccessibilityNodeInfo r1 = r0.f1951     // Catch:{ Exception -> 0x006e }
            if (r1 == 0) goto L_0x0028
            android.view.accessibility.AccessibilityNodeInfo r1 = r0.f1950     // Catch:{ Exception -> 0x006e }
            if (r1 != 0) goto L_0x0072
        L_0x0028:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x006e }
            java.util.List r6 = r6.getWindows()     // Catch:{ Exception -> 0x006e }
            int r1 = r6.size()     // Catch:{ Exception -> 0x006e }
            r2 = 1
            int r1 = r1 - r2
        L_0x0034:
            if (r1 < 0) goto L_0x0072
            java.lang.Object r3 = r6.get(r1)     // Catch:{ Exception -> 0x0067 }
            android.view.accessibility.AccessibilityWindowInfo r3 = (android.view.accessibility.AccessibilityWindowInfo) r3     // Catch:{ Exception -> 0x0067 }
            if (r3 != 0) goto L_0x003f
            goto L_0x006b
        L_0x003f:
            boolean r4 = r3.isActive()     // Catch:{ Exception -> 0x0067 }
            if (r4 != 0) goto L_0x004e
            boolean r4 = r3.isFocused()     // Catch:{ Exception -> 0x0067 }
            if (r4 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r4 = 0
            goto L_0x004f
        L_0x004e:
            r4 = 1
        L_0x004f:
            android.view.accessibility.AccessibilityNodeInfo r3 = r3.getRoot()     // Catch:{ Exception -> 0x0067 }
            android.view.accessibility.AccessibilityNodeInfo r5 = r0.f1950     // Catch:{ Exception -> 0x0067 }
            if (r5 != 0) goto L_0x005b
            if (r4 == 0) goto L_0x005b
            r0.f1950 = r3     // Catch:{ Exception -> 0x0067 }
        L_0x005b:
            android.view.accessibility.AccessibilityNodeInfo r3 = m2009((android.view.accessibility.AccessibilityNodeInfo) r3, (java.lang.CharSequence) r7)     // Catch:{ Exception -> 0x0067 }
            if (r3 != 0) goto L_0x0062
            goto L_0x006b
        L_0x0062:
            r0.f1951 = r3     // Catch:{ Exception -> 0x0067 }
            if (r4 == 0) goto L_0x006b
            goto L_0x0072
        L_0x0067:
            r3 = move-exception
            r3.getMessage()     // Catch:{ Exception -> 0x006e }
        L_0x006b:
            int r1 = r1 + -1
            goto L_0x0034
        L_0x006e:
            r6 = move-exception
            r6.getMessage()
        L_0x0072:
            android.view.accessibility.AccessibilityNodeInfo r6 = r0.f1950
            android.view.accessibility.AccessibilityNodeInfo r6 = m2008((android.view.accessibility.AccessibilityNodeInfo) r6)
            r0.f1950 = r6
            android.view.accessibility.AccessibilityNodeInfo r6 = r0.f1951
            android.view.accessibility.AccessibilityNodeInfo r6 = m2008((android.view.accessibility.AccessibilityNodeInfo) r6)
            r0.f1951 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.AccServiceHelper.m2010(android.accessibilityservice.AccessibilityService, java.lang.CharSequence):com.wpengapp.support.Ӳ$֏");
    }

    /* renamed from: ֏ */
    public static AccessibilityNodeInfo m2009(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        if (accessibilityNodeInfo == null || TextUtils.isEmpty(charSequence) || charSequence.equals(accessibilityNodeInfo.getPackageName())) {
            return accessibilityNodeInfo;
        }
        return null;
    }

    /* renamed from: ֏ */
    public static AccessibilityNodeInfo m2008(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        try {
            AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
            int i = 0;
            while (true) {
                AccessibilityNodeInfo accessibilityNodeInfo2 = parent;
                AccessibilityNodeInfo accessibilityNodeInfo3 = accessibilityNodeInfo;
                accessibilityNodeInfo = accessibilityNodeInfo2;
                if (accessibilityNodeInfo == null) {
                    return accessibilityNodeInfo3;
                }
                AccessibilityNodeInfo r1 = m2007(i, accessibilityNodeInfo3, accessibilityNodeInfo);
                if (r1 != null) {
                    return r1;
                }
                i++;
                parent = accessibilityNodeInfo.getParent();
            }
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static AccessibilityNodeInfo m2007(int i, AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo2 == null || i < 15) {
            return null;
        }
        CharSequence className = accessibilityNodeInfo2.getClassName();
        if (className == null || !className.toString().endsWith(FrameLayout.class.getName())) {
            CharSequence className2 = accessibilityNodeInfo.getClassName();
            if (className2 == null || !className2.toString().endsWith(FrameLayout.class.getName())) {
                outline.m2552("**** checkParentEndlessLoop return ", (Object) accessibilityNodeInfo2);
                return accessibilityNodeInfo2;
            }
            outline.m2552("**** checkParentEndlessLoop return ", (Object) accessibilityNodeInfo);
            return accessibilityNodeInfo;
        }
        outline.m2552("**** checkParentEndlessLoop return ", (Object) accessibilityNodeInfo2);
        return accessibilityNodeInfo2;
    }

    /* renamed from: ֏ */
    public static int m2006(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent == null) {
            return -1;
        }
        try {
            int windowId = accessibilityEvent.getWindowId();
            if (windowId == Integer.MAX_VALUE || windowId <= 0) {
                return -1;
            }
            return windowId;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public static boolean m2014(AccessibilityService accessibilityService, int i) {
        try {
            return accessibilityService.performGlobalAction(i);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: ֏ */
    public static boolean m2013(AccessibilityService accessibilityService) {
        outline.m2552("disable ", (Object) accessibilityService);
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        try {
            accessibilityService.disableSelf();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
