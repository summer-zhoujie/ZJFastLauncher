package com.wpengapp.support;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.wpengapp.support.licensing.activity.InputContactActivity;
import com.wpengapp.support.licensing.model.CheckDeviceDto;
import java.util.HashMap;

/* renamed from: com.wpengapp.support.Ⴖ */
/* compiled from: CheckDeviceManager */
public class C1307 {

    /* renamed from: ֏ */
    public static String f3738;

    /* renamed from: ؠ */
    public static SP<Boolean> f3739 = new BooleanSP("cktsfr", true);

    /* renamed from: ֏ */
    public static void m3560(@NonNull RetCallback<CheckDeviceDto> r7) {
        if (!m3564()) {
            r7.mo7932((String) null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("oid", m3554());
        hashMap.put("di", Utils.m1907());
        hashMap.put("app_id", C0536.m1299());
        hashMap.put("lid", C0536.m1315());
        hashMap.put("lsv", "2");
        new C0544("POST", ApiConstant.f2713, hashMap, (String) null, r7).mo8757(true);
    }

    /* renamed from: ؠ */
    public static String m3561() {
        return C0536.m1299() + C0719.m1826() + "k";
    }

    /* renamed from: ހ */
    public static String m3563() {
        return MD5Utils.m1342(C0719.m1826() + "ui");
    }

    /* renamed from: ށ */
    public static boolean m3564() {
        return f3739.mo8104().booleanValue();
    }

    /* renamed from: ނ */
    public static void m3565() {
        f3739.mo8105(false);
    }

    /* renamed from: ؠ */
    public static /* synthetic */ void m3562(Activity activity, UserInfo r4) {
        C0915 r0 = new C0915(activity);
        r0.mo8905(R$string.wpengpay_transfer_tips);
        r0.f2469 = false;
        r0.mo8900(R$string.pw_ok, (OnDialogClickListener) new C0574(activity, r4));
        r0.mo8896().show();
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m3559(UserInfo r7, String str, RetCallback r9) {
        if (!C0536.m1307(r7)) {
            r9.mo7932(AppUtils.m1141(R$string.wpengpay_error_order_info, new Object[0]));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("oid", m3554());
        hashMap.put("di", Utils.m1907());
        hashMap.put("contact", str);
        hashMap.put("lid", C0536.m1315());
        hashMap.put("app_id", C0536.m1299());
        hashMap.put("lsv", "2");
        new C0725("POST", ApiConstant.f2714, hashMap, (String) null, r9).mo8757(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089 A[SYNTHETIC, Splitter:B:25:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"MissingPermission"})
    @Deprecated
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m3554() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L_0x0009
            java.lang.String r0 = ""
            return r0
        L_0x0009:
            java.lang.String r0 = f3738
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = f3738
            return r0
        L_0x0014:
            r0 = 0
            java.lang.String r1 = m3563()     // Catch:{ Exception -> 0x002e }
            java.lang.String r1 = com.wpengapp.support.RemoteSP.m1202((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x002e }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x002e }
            if (r2 != 0) goto L_0x002f
            java.lang.String r2 = m3561()     // Catch:{ Exception -> 0x002e }
            java.lang.String r1 = com.wpengapp.support.Utils.m1868((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x002e }
            f3738 = r1     // Catch:{ Exception -> 0x002e }
            goto L_0x002f
        L_0x002e:
        L_0x002f:
            java.lang.String r1 = f3738
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x003a
            java.lang.String r0 = f3738
            return r0
        L_0x003a:
            java.lang.String r1 = com.wpengapp.support.C0719.f1856
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x007d
            java.lang.String r1 = com.wpengapp.support.C0719.m1826()
            java.lang.String r2 = com.wpengapp.support.C0719.m1822()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x007d
            java.lang.String r3 = "SM_"
            java.lang.StringBuilder r3 = com.wpengapp.support.outline.m2549(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            java.lang.String r1 = com.wpengapp.support.MD5Utils.m1342((java.lang.String) r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.wpengapp.support.C0719.f1856 = r1
            java.lang.String r1 = com.wpengapp.support.C0719.f1856
            java.lang.String r1 = r1.toUpperCase()
            com.wpengapp.support.C0719.f1856 = r1
            java.lang.String r1 = com.wpengapp.support.C0719.f1856
            goto L_0x007f
        L_0x007d:
            java.lang.String r1 = com.wpengapp.support.C0719.f1856
        L_0x007f:
            f3738 = r1
            java.lang.String r1 = f3738
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x009d
            java.lang.String r0 = f3738     // Catch:{ Exception -> 0x009b }
            java.lang.String r1 = m3561()     // Catch:{ Exception -> 0x009b }
            java.lang.String r0 = com.wpengapp.support.Utils.m1891((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x009b }
            java.lang.String r1 = m3563()     // Catch:{ Exception -> 0x009b }
            r2 = 0
            com.wpengapp.support.RemoteSP.m1206((java.lang.String) r1, (java.lang.Object) r0, (boolean) r2)     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            java.lang.String r0 = f3738
        L_0x009d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1307.m3554():java.lang.String");
    }

    /* renamed from: ֏ */
    public static void m3558(Context context, @NonNull UserInfo r8) {
        InputContactActivity.m862(context, context.getString(R$string.wpengpay_input_contact_tips_transfer), false, 0, 0, new C1292(r8));
    }

    /* renamed from: ֏ */
    public static void m3557(Activity activity, Runnable runnable) {
        if (runnable == null) {
            runnable = new C0576();
        }
        if (!m3564()) {
            runnable.run();
            return;
        }
        UserInfo r0 = C0536.m1309();
        if (!C0536.m1307(r0)) {
            C0536.m1306(false, (SyncUserInfoListener) new C0638(runnable, activity));
        } else if (C0536.m1313(r0) || C0536.m1322()) {
            m3565();
            runnable.run();
        } else {
            m3560(new CheckDeviceManager(runnable, activity, r0));
        }
    }

    /* renamed from: ֏ */
    public static void m3556(Activity activity, UserInfo r2, Runnable runnable) {
        m3560(new CheckDeviceManager(runnable, activity, r2));
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m3555(Activity activity, UserInfo r4) {
        C0915 r0 = new C0915(activity);
        r0.mo8905(R$string.wpengpay_recovery_tips);
        r0.f2469 = false;
        r0.mo8898(R$string.pw_cancel);
        r0.mo8906(R$string.wpengpay_pro_dialog_ok, (OnDialogClickListener) new C0893(activity, r4));
        r0.mo8896().show();
    }
}
