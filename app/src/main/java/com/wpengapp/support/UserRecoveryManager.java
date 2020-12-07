package com.wpengapp.support;

import com.wpengapp.support.licensing.activity.VerifyContactActivity;
import com.wpengapp.support.licensing.model.TryRecoveryDto;

/* renamed from: com.wpengapp.support.ņ */
class UserRecoveryManager implements RetCallback<TryRecoveryDto> {

    /* renamed from: ֏ */
    public final /* synthetic */ VerifyContactActivity f822;

    /* renamed from: ؠ */
    public final /* synthetic */ C0870 f823;

    public UserRecoveryManager(C0870 r1, VerifyContactActivity verifyContactActivity) {
        this.f823 = r1;
        this.f822 = verifyContactActivity;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        TryRecoveryDto tryRecoveryDto = (TryRecoveryDto) obj;
        C0870 r0 = this.f823;
        r0.f2360 = tryRecoveryDto.codeId;
        RemoteSP.m1206("csmscod1l", (Object) Long.valueOf(r0.f2360), false);
        this.f822.mo7865(false);
        this.f822.mo7864(tryRecoveryDto.repeatLimit);
        C0826.m2179(R$string.wpengpay_verify_code_sent, new Object[0]);
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        this.f822.mo7865(false);
        C0826.m2177((CharSequence) str);
    }
}
