package com.wpengapp.support;

import android.app.Activity;
import com.wpengapp.support.licensing.model.CheckDeviceDto;

/* renamed from: com.wpengapp.support.Ė */
class CheckDeviceManager implements RetCallback<CheckDeviceDto> {

    /* renamed from: ֏ */
    public final /* synthetic */ Runnable f769;

    /* renamed from: ؠ */
    public final /* synthetic */ Activity f770;

    /* renamed from: ހ */
    public final /* synthetic */ UserInfo f771;

    public CheckDeviceManager(Runnable runnable, Activity activity, UserInfo r3) {
        this.f769 = runnable;
        this.f770 = activity;
        this.f771 = r3;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        CheckDeviceDto checkDeviceDto = (CheckDeviceDto) obj;
        if (checkDeviceDto == null) {
            this.f769.run();
        } else if (checkDeviceDto.deviceHasPaid) {
            C1307.m3555(this.f770, this.f771);
        } else if (checkDeviceDto.needTransfer) {
            C1307.m3562(this.f770, this.f771);
        } else {
            this.f769.run();
        }
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        outline.m2555("checkDevice error: ", str);
        this.f769.run();
    }
}
