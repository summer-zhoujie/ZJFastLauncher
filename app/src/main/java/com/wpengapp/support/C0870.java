package com.wpengapp.support;

import android.app.ProgressDialog;
import com.wpengapp.support.licensing.activity.VerifyContactActivity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.ٷ */
/* compiled from: UserRecoveryManager */
public final class C0870 implements VerifyContactActivity.C0455 {

    /* renamed from: ֏ */
    public long f2360;

    /* renamed from: ؠ */
    public final /* synthetic */ UserInfo f2361;

    public C0870(UserInfo r1) {
        this.f2361 = r1;
    }

    /* renamed from: ֏ */
    public void mo8824(String str, String str2, VerifyContactActivity verifyContactActivity) {
        ProgressDialog progressDialog = new ProgressDialog(verifyContactActivity);
        progressDialog.setMessage(verifyContactActivity.getString(R$string.pw_wait));
        progressDialog.setCancelable(false);
        C0936.m2467(progressDialog);
        if (this.f2360 == 0) {
            this.f2360 = RemoteSP.m1201("csmscod1l", 0);
        }
        UserInfo r2 = this.f2361;
        long j = this.f2360;
        C0595 r10 = new C0595(this, progressDialog, verifyContactActivity);
        if (!C0536.m1307(r2)) {
            r10.mo7932(AppUtils.m1141(R$string.wpengpay_error_order_info, new Object[0]));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lid", r2.f2111);
        hashMap.put("cid", String.valueOf(j));
        hashMap.put("code", str2);
        hashMap.put("contact", str);
        hashMap.put("dm", C0719.m1816());
        hashMap.put("app_id", r2.f2114);
        C1279.m3415((Map<String, String>) hashMap);
        hashMap.put("lsv", "2");
        new C0905("POST", ApiConstant.f2716, hashMap, (String) null, r10).mo8757(false);
    }

    /* renamed from: ֏ */
    public void mo8823(String str, VerifyContactActivity verifyContactActivity) {
        if (!CountLimitHelper.m997("sendSmsCode", 1000)) {
            verifyContactActivity.mo7865(true);
            UserRecoveryManager r6 = new UserRecoveryManager(this, verifyContactActivity);
            "tryRecovery " + str;
            HashMap hashMap = new HashMap();
            hashMap.put("contact", str);
            hashMap.put("dm", C0719.m1816());
            hashMap.put("did", C0719.m1820());
            hashMap.put("app_id", C0536.m1299());
            C1279.m3415((Map<String, String>) hashMap);
            hashMap.put("lsv", "2");
            new C0895("POST", ApiConstant.f2715, hashMap, (String) null, r6).mo8757(false);
        }
    }
}
