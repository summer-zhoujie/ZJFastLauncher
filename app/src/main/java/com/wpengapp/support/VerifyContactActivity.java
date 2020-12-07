package com.wpengapp.support;

import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.wpengapp.support.ȅ */
public class VerifyContactActivity extends HttpSimpleRequest {

    /* renamed from: ދ */
    public final /* synthetic */ com.wpengapp.support.licensing.activity.VerifyContactActivity f1048;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerifyContactActivity(com.wpengapp.support.licensing.activity.VerifyContactActivity verifyContactActivity, String str, Map map, String str2) {
        super(str, map, str2);
        this.f1048 = verifyContactActivity;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<String> r2, ErrorCode r3) {
        this.f1048.mo7430();
        if (r3.mo8157() && !TextUtils.isEmpty((CharSequence) r2.f3518)) {
            this.f1048.f694.setText((CharSequence) r2.f3518);
        }
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        this.f1048.mo7430();
    }
}
