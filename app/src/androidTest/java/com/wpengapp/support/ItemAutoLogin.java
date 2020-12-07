package com.wpengapp.support;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.wpengapp.lightstart.R$string;

/* renamed from: com.wpengapp.support.ϳ */
public class ItemAutoLogin implements IBackupItem {
    @NonNull
    public String getKey() {
        return "autologin";
    }

    @NonNull
    public String getName() {
        return AppUtils.m1141((int) R$string.auto_login2, new Object[0]);
    }

    /* renamed from: ֏ */
    public boolean mo8365(@NonNull BackupPackage r4) {
        String str = r4.f2321.get("autologin");
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        T t = (AutoLoginConfig) GsonUtil.m2740(str, AutoLoginConfig.class);
        C1323<AutoLoginConfig> r0 = C1057.f3020;
        r0.f3785 = t;
        r0.f3791 = true;
        TaskManager.m2720(new C0761(r0, t));
        return true;
    }

    /* renamed from: ֏ */
    public String mo8364() {
        AutoLoginConfig r0 = C1057.f3020.mo9612();
        if (r0 == null) {
            return null;
        }
        return GsonUtil.m2742(r0);
    }
}
