package com.wpengapp.support;

import android.app.ProgressDialog;
import android.content.Context;
import com.wpengapp.support.activity.WPengVersionActivity;
import com.wpengapp.support.licensing.model.CheckDeviceDto;

/* renamed from: com.wpengapp.support.ລ */
/* compiled from: WPengVersionActivity */
class C1227 implements RetCallback<CheckDeviceDto> {

    /* renamed from: ֏ */
    public final /* synthetic */ ProgressDialog f3499;

    /* renamed from: ؠ */
    public final /* synthetic */ UserInfo f3500;

    /* renamed from: ހ */
    public final /* synthetic */ WPengVersionActivity f3501;

    public C1227(WPengVersionActivity wPengVersionActivity, ProgressDialog progressDialog, UserInfo r3) {
        this.f3501 = wPengVersionActivity;
        this.f3499 = progressDialog;
        this.f3500 = r3;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        CheckDeviceDto checkDeviceDto = (CheckDeviceDto) obj;
        this.f3499.dismiss();
        if (checkDeviceDto == null || !checkDeviceDto.needTransfer) {
            C1279.m3410((Context) this.f3501, this.f3500);
        } else {
            C1307.m3558((Context) this.f3501, this.f3500);
        }
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        this.f3499.dismiss();
        C1279.m3410((Context) this.f3501, this.f3500);
    }
}
