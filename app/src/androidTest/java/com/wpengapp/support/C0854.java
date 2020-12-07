package com.wpengapp.support;

import android.os.CountDownTimer;
import com.wpengapp.support.licensing.activity.VerifyContactActivity;

/* renamed from: com.wpengapp.support.غ */
/* compiled from: VerifyContactActivity */
class C0854 extends CountDownTimer {

    /* renamed from: ֏ */
    public final /* synthetic */ int f2312;

    /* renamed from: ؠ */
    public final /* synthetic */ VerifyContactActivity f2313;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0854(VerifyContactActivity verifyContactActivity, long j, long j2, int i) {
        super(j, j2);
        this.f2313 = verifyContactActivity;
        this.f2312 = i;
    }

    public void onFinish() {
        this.f2313.f697.setText(R$string.wpengpay_verify_code_get_retry);
        this.f2313.f697.setEnabled(true);
        this.f2313.f697.setTextColor(this.f2312);
    }

    public void onTick(long j) {
        String valueOf = String.valueOf((j + 1000) / 1000);
        VerifyContactActivity verifyContactActivity = this.f2313;
        verifyContactActivity.f697.setText(verifyContactActivity.getString(R$string.wpengpay_verify_code_countdown, new Object[]{valueOf}));
    }
}
