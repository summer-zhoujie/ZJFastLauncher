package com.wpengapp.support;

import android.support.annotation.NonNull;
import com.wpengapp.lightstart.R$string;

/* renamed from: com.wpengapp.support.ઙ */
public class ItemShortcut implements IBackupItem {
    @NonNull
    public String getKey() {
        return "shortcut";
    }

    @NonNull
    public String getName() {
        return AppUtils.m1141((int) R$string.quick_scan, new Object[0]);
    }

    /* renamed from: ֏ */
    public String mo8364() {
        return GsonUtil.m2742(C0774.m2086());
    }

    /* renamed from: ֏ */
    public boolean mo8365(@NonNull BackupPackage r4) {
        T t = (QuickScanConfig) GsonUtil.m2740(r4.f2321.get("shortcut"), QuickScanConfig.class);
        C1323<QuickScanConfig> r0 = C0774.f1993;
        r0.f3785 = t;
        r0.f3791 = true;
        TaskManager.m2720(new C0761(r0, t));
        C0774.m2082();
        return true;
    }
}
