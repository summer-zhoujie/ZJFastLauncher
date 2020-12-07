package com.wpengapp.support;

import android.support.annotation.NonNull;
import com.wpengapp.lightstart.R$string;

/* renamed from: com.wpengapp.support.ӵ */
public class ItemCustom implements IBackupItem {
    @NonNull
    public String getKey() {
        return "customrule";
    }

    @NonNull
    public String getName() {
        return AppUtils.m1141((int) R$string.custom_rule, new Object[0]);
    }

    /* renamed from: ֏ */
    public String mo8364() {
        return GsonUtil.m2742(C0909.m2390());
    }

    /* renamed from: ֏ */
    public boolean mo8365(@NonNull BackupPackage r2) {
        C0909.m2385((CustomConfig) GsonUtil.m2740(r2.f2321.get("customrule"), CustomConfig.class));
        return true;
    }
}
