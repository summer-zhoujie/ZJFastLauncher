package com.wpengapp.support;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.wpengapp.lightstart.R$string;

/* renamed from: com.wpengapp.support.Ј */
/* compiled from: ItemNotifyRecord */
public class C0687 implements IBackupItem {

    /* renamed from: com.wpengapp.support.Ј$֏ */
    /* compiled from: ItemNotifyRecord */
    private static class C0688 {
        @SerializedName("eb")

        /* renamed from: ֏ */
        public Boolean f1782;

        public C0688() {
        }

        public /* synthetic */ C0688(ItemNotifyRecord r1) {
        }
    }

    @NonNull
    public String getKey() {
        return "notifyrecord";
    }

    @NonNull
    public String getName() {
        return AppUtils.m1141((int) R$string.notify_record_settings, new Object[0]);
    }

    /* renamed from: ֏ */
    public String mo8364() {
        C0688 r0 = new C0688((ItemNotifyRecord) null);
        r0.f1782 = SpHandler.f1763.mo8104();
        return GsonUtil.m2742(r0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        r4 = (com.wpengapp.support.C0687.C0688) com.wpengapp.support.GsonUtil.m2740(r4, com.wpengapp.support.C0687.C0688.class);
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo8365(@NonNull com.wpengapp.support.BackupPackage r4) {
        /*
            r3 = this;
            java.util.Map<java.lang.String, java.lang.String> r4 = r4.f2321
            java.lang.String r0 = "notifyrecord"
            java.lang.Object r4 = r4.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 1
            if (r0 == 0) goto L_0x0012
            return r1
        L_0x0012:
            java.lang.Class<com.wpengapp.support.Ј$֏> r0 = com.wpengapp.support.C0687.C0688.class
            java.lang.Object r4 = com.wpengapp.support.GsonUtil.m2740((java.lang.String) r4, r0)
            com.wpengapp.support.Ј$֏ r4 = (com.wpengapp.support.C0687.C0688) r4
            java.lang.Boolean r0 = r4.f1782
            if (r0 == 0) goto L_0x0031
            com.wpengapp.support.ɻ<java.lang.Boolean> r2 = com.wpengapp.support.SpHandler.f1763
            java.lang.Object r2 = r2.mo8104()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0031
            com.wpengapp.support.ɻ<java.lang.Boolean> r0 = com.wpengapp.support.SpHandler.f1763
            java.lang.Boolean r4 = r4.f1782
            r0.mo8105(r4)
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0687.mo8365(com.wpengapp.support.ل):boolean");
    }
}
