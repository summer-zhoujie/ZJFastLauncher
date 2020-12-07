package com.wpengapp.support;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wpengapp.support.activity.CommonWebActivity;

/* renamed from: com.wpengapp.support.ધ */
/* compiled from: UserPrivacyManager */
public class C1110 {

    /* renamed from: ֏ */
    public static int f3162 = -1;

    /* renamed from: ֏ */
    public static boolean m2991() {
        if (BaseApplication.f561.mo7555() && CommonSP.m1228("priagree", -1) < CommonSP.m1228("prinew", 0)) {
            return true;
        }
        return false;
    }

    /* renamed from: ؠ */
    public static void m2992(Context context) {
        CommonWebActivity.m784(context, ApiConstant.m2593() + "/" + C1279.m3425().toLowerCase() + "/swservice?v=" + AppUtils.m1158(), (String) null, false, "file:///android_asset/sw_service.html");
    }

    /* renamed from: ֏ */
    public static void m2989(Context context) {
        CommonWebActivity.m784(context, ApiConstant.m2593() + "/" + C1279.m3425().toLowerCase() + "/privacy?v=" + AppUtils.m1158(), (String) null, false, "file:///android_asset/privacy.html");
    }

    /* renamed from: ֏ */
    public static void m2990(Context context, OnDialogClickListener r6, OnDialogClickListener r7) {
        if (f3162 != -1) {
            View inflate = View.inflate(context, R$layout.pw_dialog_privacy, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R$id.tv_msg);
            int i = f3162;
            C1279.m3412(textView, (CharSequence) textView.getContext().getString(i), (HtmlTextHelper) new C1212(context));
            C0915 r1 = new C0915(context);
            r1.f2463 = inflate;
            r1.f2469 = false;
            r1.mo8900(R$string.pw_exit, r6);
            r1.mo8906(R$string.pw_agree, (OnDialogClickListener) new UserPrivacyManager(r7));
            r1.mo8910();
        }
    }
}
