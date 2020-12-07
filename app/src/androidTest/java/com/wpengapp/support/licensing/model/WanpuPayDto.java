package com.wpengapp.support.licensing.model;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import com.wpengapp.support.GsonUtil;

@Keep
public class WanpuPayDto {
    public String asdk;
    public int needPayAmount;
    public String notifyUrl;
    public String payId;
    public String wapsAppId;

    @NonNull
    public String toString() {
        return GsonUtil.m2742(this);
    }
}
