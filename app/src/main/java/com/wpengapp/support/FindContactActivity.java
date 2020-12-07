package com.wpengapp.support;

import com.wpengapp.support.licensing.model.FindContactDto;

/* renamed from: com.wpengapp.support.Π */
class FindContactActivity implements RetCallback<FindContactDto> {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.support.licensing.activity.FindContactActivity f1635;

    public FindContactActivity(com.wpengapp.support.licensing.activity.FindContactActivity findContactActivity) {
        this.f1635 = findContactActivity;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        this.f1635.mo7430();
        this.f1635.mo7855((FindContactDto) obj);
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        this.f1635.mo7430();
        this.f1635.mo7424(R$string.wpengpay_find_contact_fail);
    }
}
