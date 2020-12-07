package com.wpengapp.support;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.wpengapp.lightstart.R$string;

/* renamed from: com.wpengapp.support.ͷ */
public class ItemToastRecord implements IBackupItem {

    /* renamed from: com.wpengapp.support.ͷ$֏ */
    /* compiled from: ItemToastRecord */
    private static class C0627 {
        @SerializedName("eb")

        /* renamed from: ֏ */
        public Boolean f1595;
        @SerializedName("am")

        /* renamed from: ؠ */
        public Boolean f1596;
        @SerializedName("fs")

        /* renamed from: ހ */
        public Boolean f1597;

        public C0627() {
        }

        public /* synthetic */ C0627(C1169 r1) {
        }
    }

    @NonNull
    public String getKey() {
        return "toastrecord";
    }

    @NonNull
    public String getName() {
        return AppUtils.m1141((int) R$string.toast_record_settings, new Object[0]);
    }

    /* renamed from: ֏ */
    public String mo8364() {
        C0627 r0 = new C0627((C1169) null);
        r0.f1595 = SpHandler.f1760.mo8104();
        r0.f1596 = SpHandler.f1761.mo8104();
        r0.f1597 = SpHandler.f1762.mo8104();
        return GsonUtil.m2742(r0);
    }

    /* renamed from: ֏ */
    public boolean mo8365(@NonNull BackupPackage r4) {
        String str = r4.f2321.get("toastrecord");
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        C0627 r42 = (C0627) GsonUtil.m2740(str, C0627.class);
        Boolean bool = r42.f1595;
        if (bool != null && !bool.equals(SpHandler.f1760.mo8104())) {
            SpHandler.f1760.mo8105(r42.f1595);
        }
        Boolean bool2 = r42.f1596;
        if (bool2 != null && !bool2.equals(SpHandler.f1761.mo8104())) {
            SpHandler.f1761.mo8105(r42.f1596);
        }
        Boolean bool3 = r42.f1597;
        if (bool3 != null && !bool3.equals(SpHandler.f1762.mo8104())) {
            SpHandler.f1762.mo8105(r42.f1597);
        }
        return true;
    }
}
