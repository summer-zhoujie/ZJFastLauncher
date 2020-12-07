package com.wpengapp.support;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import android.util.SparseArray;
import com.umeng.analytics.social.UMSocialConstants;
import com.wpengapp.support.licensing.activity.InputContactActivity;
import com.wpengapp.support.licensing.model.WanpuPayDto;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ѐ */
/* compiled from: PayManager */
public class C0678 {

    /* renamed from: ֏ */
    public static Application f1766 = null;

    /* renamed from: ؠ */
    public static Handler f1767 = null;

    /* renamed from: ހ */
    public static String f1768 = "bXRob29r";

    /* renamed from: ށ */
    public static String f1769 = "Y25maXg=";

    /* renamed from: ނ */
    public static C0679 f1770;

    /* renamed from: ރ */
    public static final SparseArray<IPayResultChecker> f1771 = new SparseArray<>();

    /* renamed from: ބ */
    public static boolean f1772;

    /* renamed from: com.wpengapp.support.Ѐ$֏ */
    /* compiled from: PayManager */
    public static class C0679 {

        /* renamed from: ֏ */
        public String f1773;

        /* renamed from: ؠ */
        public String f1774;

        /* renamed from: ހ */
        public String f1775;
    }

    /* renamed from: com.wpengapp.support.Ѐ$ؠ */
    /* compiled from: PayManager */
    public interface C0680 {
        /* renamed from: ֏ */
        void mo8029(UserInfo r1, boolean z, String str);
    }

    /* renamed from: ֏ */
    public static void m1728(Context context, C0679 r2) {
        if (r2 != null) {
            f1766 = (Application) context.getApplicationContext();
            f1767 = AppUtils.m1171();
            f1770 = r2;
            if (TextUtils.isEmpty(r2.f1774)) {
                r2.f1774 = SystemUtils.m3519(f1766.getPackageName());
                if (TextUtils.isEmpty(r2.f1774)) {
                    r2.f1774 = f1766.getString(R$string.wpengpay_default_good_name);
                }
            }
            r2.f1775 = BidiFormatter.EMPTY_STRING;
            C0536.m1321();
            f1771.put(1, new C1067());
            f1771.put(2, new C0904());
            return;
        }
        throw new NullPointerException("Config can not be null");
    }

    /* renamed from: ؠ */
    public static boolean m1733(int i) {
        return i == 1 || i == 7;
    }

    /* renamed from: ހ */
    public static void m1734(int i) {
        C0536.m1306(true, (SyncUserInfoListener) new C0526(i));
    }

    /* renamed from: ֏ */
    public static void m1725(Activity activity, int i, UserInfo r9, C0680 r10) {
        "pay, callback:" + r10 + ", user:" + r9;
        if (r10 == null) {
            r10 = new C0498();
        }
        if (!C0536.m1307(r9)) {
            r10.mo8029(r9, false, activity.getString(R$string.wpengpay_error_order_info));
            return;
        }
        InputContactActivity.m862(activity, activity.getString(R$string.wpengpay_input_contact_tips), true, r9.f2122, r9.f2123, new C1137(r10, r9, activity, i));
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m1729(InputContactActivity inputContactActivity, Activity activity, int i, UserInfo r16, String str, boolean z, C0680 r19) {
        InputContactActivity inputContactActivity2 = inputContactActivity;
        UserInfo r7 = r16;
        ProgressDialog progressDialog = new ProgressDialog(inputContactActivity);
        progressDialog.setMessage(inputContactActivity.getString(R$string.pw_loading));
        progressDialog.setCancelable(false);
        C0936.m2467(progressDialog);
        HashMap hashMap = new HashMap();
        hashMap.put("lid", r7.f2111);
        hashMap.put("app_id", r7.f2114);
        hashMap.put("contact", str);
        hashMap.put("cd", String.valueOf(z));
        if (f1772) {
            hashMap.put("hmp", String.valueOf(true));
        }
        C1279.m3415((Map<String, String>) hashMap);
        boolean r10 = m1733(i);
        new PayManager("POST", r10 ? ApiConstant.f2718 : ApiConstant.f2717, hashMap, "pay_info", progressDialog, inputContactActivity, r16, r19, activity, r10).mo8757(false);
    }

    /* renamed from: ֏ */
    public static void m1724(Activity activity, int i, C0680 r13) {
        UserInfo r0 = C0536.m1309();
        if (r0 == null) {
            m1731(false, activity.getString(R$string.wpengpay_error_pay_id), r13);
            return;
        }
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(activity.getString(R$string.pw_loading));
        progressDialog.setCancelable(false);
        C0936.m2467(progressDialog);
        boolean r10 = m1733(i);
        String str = r10 ? ApiConstant.f2721 : ApiConstant.f2720;
        HashMap hashMap = new HashMap();
        hashMap.put("app_uid", String.valueOf(r0.f2110));
        if (f1772) {
            hashMap.put("hmp", String.valueOf(true));
        }
        new C1299("POST", str, hashMap, "pay_info", progressDialog, r13, activity, r10).mo8757(false);
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m1730(InputContactActivity inputContactActivity, Activity activity, UserInfo r14, String str, boolean z, C0680 r17) {
        InputContactActivity inputContactActivity2 = inputContactActivity;
        UserInfo r7 = r14;
        ProgressDialog progressDialog = new ProgressDialog(inputContactActivity);
        progressDialog.setMessage(inputContactActivity.getString(R$string.pw_loading));
        progressDialog.setCancelable(false);
        C0936.m2467(progressDialog);
        HashMap hashMap = new HashMap();
        hashMap.put("lid", r7.f2111);
        hashMap.put("app_id", r7.f2114);
        String str2 = str;
        hashMap.put("contact", str);
        hashMap.put("cd", String.valueOf(z));
        C1279.m3415((Map<String, String>) hashMap);
        if (f1772) {
            hashMap.put("hmp", String.valueOf(true));
        }
        new C0779("POST", ApiConstant.f2719, hashMap, "pay_info", progressDialog, inputContactActivity, r14, r17, activity).mo8757(false);
    }

    /* renamed from: ֏ */
    public static void m1726(Activity activity, C0680 r12) {
        UserInfo r8 = C0536.m1309();
        if (r8 == null) {
            m1731(false, activity.getString(R$string.wpengpay_error_pay_id), r12);
            return;
        }
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(activity.getString(R$string.pw_loading));
        progressDialog.setCancelable(false);
        C0936.m2467(progressDialog);
        HashMap hashMap = new HashMap();
        hashMap.put("app_uid", String.valueOf(r8.f2110));
        if (f1772) {
            hashMap.put("hmp", String.valueOf(true));
        }
        new C0585("POST", ApiConstant.f2722, hashMap, "pay_info", progressDialog, r12, activity, r8).mo8757(false);
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m1727(Activity activity, String str, WanpuPayDto wanpuPayDto, WpAlipayCallback r19) {
        WanpuPayDto wanpuPayDto2 = wanpuPayDto;
        if (TextUtils.isEmpty(wanpuPayDto2.wapsAppId)) {
            WpAlipayCallback r14 = r19;
            r14.mo8503(false, activity.getString(R$string.wpengpay_error_sdk_app_id));
            return;
        }
        Activity activity2 = activity;
        String str2 = wanpuPayDto2.wapsAppId;
        String str3 = f1770.f1773;
        String str4 = wanpuPayDto2.payId;
        float r9 = m1723(wanpuPayDto2.needPayAmount);
        C0679 r3 = f1770;
        Activity activity3 = activity;
        String str5 = str;
        C1305 r32 = new C1305(activity3, str2, str3, str4, str5, r9, r3.f1774, r3.f1775, wanpuPayDto2.notifyUrl, wanpuPayDto2.asdk, r19);
        String valueOf = String.valueOf(r32.f3722);
        if (valueOf.substring(valueOf.indexOf(".") + 1).length() > 2) {
            r32.f3733.mo8503(false, r32.f3717.getString(R$string.wpengpay_error_wp_06));
            return;
        }
        if (r32.f3734 == null) {
            r32.f3734 = new ProgressDialog(r32.f3717);
            r32.f3734.setMessage(r32.f3717.getString(R$string.wpengpay_pay_connecting));
            r32.f3734.setCancelable(false);
        }
        C0936.m2467(r32.f3734);
        StringBuilder sb = new StringBuilder();
        sb.append("app_id=");
        outline.m2553(r32.f3718, sb, "&channel=");
        sb.append(C1305.m3546(r32.f3719));
        String r33 = C0719.m1816();
        String r4 = C0719.m1822();
        if (r4 != null) {
            r4 = r4.replaceAll(":", BidiFormatter.EMPTY_STRING);
        }
        if (TextUtils.isEmpty(r33)) {
            r33 = outline.m2556(UMSocialConstants.f259r, r4);
        }
        sb.append("&udid=");
        sb.append(C1305.m3546(r33));
        sb.append("&mac=");
        sb.append(C1305.m3546(r4));
        sb.append("&imsi=");
        sb.append(BidiFormatter.EMPTY_STRING);
        sb.append("&pkg=");
        sb.append(C1305.m3546(r32.f3717.getPackageName()));
        sb.append("&device_type=");
        sb.append(C1305.m3546("android"));
        sb.append("&os_version=");
        outline.m2553(Build.VERSION.RELEASE, sb, "&device_name=");
        outline.m2553(Build.MODEL, sb, "&os_version=");
        sb.append(C1305.m3546(Build.VERSION.RELEASE));
        sb.append("&sdk_version=");
        sb.append(C1305.m3546("4.2.1p"));
        sb.append("&out_trade_no=");
        outline.m2553(r32.f3727, sb, "&cp_order_no=");
        outline.m2553(r32.f3720, sb, "&user_id=");
        outline.m2553(r32.f3721, sb, "&price=");
        sb.append(C1305.m3546(String.valueOf(r32.f3722)));
        sb.append("&sync_url=");
        sb.append(C1305.m3546(r32.f3725));
        try {
            sb.append("&goodsName=");
            sb.append(URLEncoder.encode(r32.f3723, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
        }
        try {
            sb.append("&goodsDesc=");
            sb.append(URLEncoder.encode(r32.f3724, "UTF-8"));
        } catch (UnsupportedEncodingException unused2) {
        }
        StringBuilder r0 = outline.m2549("http://pay.wapg.cn/connect?");
        r0.append(sb.toString().replaceAll(" ", "%20"));
        new C0787(r32, r0.toString()).mo8757(false);
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m1732(boolean z, String str, UserInfo r5, C0680 r6) {
        if (z) {
            C0536.m1326();
        } else if (!TextUtils.isEmpty(str)) {
            str = Utils.m1864(R$string.wpengpay_error_cause, new Object[0]) + str;
        }
        r6.mo8029(r5, z, str);
        m1734(2);
    }

    /* renamed from: ֏ */
    public static void m1731(boolean z, String str, C0680 r5) {
        m1734(2);
        if (!z && !TextUtils.isEmpty(str)) {
            str = Utils.m1864(R$string.wpengpay_error_cause, new Object[0]) + str;
        }
        r5.mo8029(C0536.m1309(), z, str);
    }

    /* renamed from: ֏ */
    public static float m1723(int i) {
        return new BigDecimal((double) (((float) i) * 0.01f)).setScale(2, 4).floatValue();
    }
}
