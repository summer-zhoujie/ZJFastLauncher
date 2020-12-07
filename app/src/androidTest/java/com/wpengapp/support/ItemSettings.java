package com.wpengapp.support;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.wpengapp.support.activity.LauncherActivity;
import com.wpengapp.support.permission.RequestPermissionHelper;
import java.util.HashMap;

/* renamed from: com.wpengapp.support.Հ */
public class ItemSettings implements IBackupItem {

    /* renamed from: com.wpengapp.support.Հ$֏ */
    /* compiled from: ItemSettings */
    private static class C0781 {
        @SerializedName("urap")

        /* renamed from: ֏ */
        public HashMap<String, AppConfig> f2010;
        @SerializedName("exrec")

        /* renamed from: ؠ */
        public Boolean f2011;
        @SerializedName("skam")

        /* renamed from: ހ */
        public Boolean f2012;
        @SerializedName("sktx")

        /* renamed from: ށ */
        public String f2013;
        @SerializedName("mmo")

        /* renamed from: ނ */
        public Boolean f2014;
        @SerializedName("ssn")

        /* renamed from: ރ */
        public Boolean f2015;
        @SerializedName("shrcf")

        /* renamed from: ބ */
        public Boolean f2016;

        public C0781() {
        }

        public /* synthetic */ C0781(C1251 r1) {
        }
    }

    @NonNull
    public String getKey() {
        return "settings";
    }

    @NonNull
    public String getName() {
        return AppUtils.m1141(2131493192, new Object[0]);
    }

    /* renamed from: ֏ */
    public String mo8364() {
        C0781 r0 = new C0781((C1251) null);
        r0.f2010 = C1219.m3279();
        r0.f2011 = SpHandler.f1754.mo8104();
        r0.f2012 = SpHandler.f1751.mo8104();
        r0.f2013 = SpHandler.f1752.mo8104();
        if (TextUtils.equals(r0.f2013, (CharSequence) SpHandler.f1752.f1265)) {
            r0.f2013 = null;
        }
        r0.f2014 = SpHandler.f1753.mo8104();
        r0.f2015 = SpHandler.f1758.mo8104();
        return GsonUtil.m2742(r0);
    }

    /* renamed from: ֏ */
    public boolean mo8365(@NonNull BackupPackage r3) {
        C0781 r32 = (C0781) GsonUtil.m2740(r3.f2321.get("settings"), C0781.class);
        HashMap<String, AppConfig> hashMap = r32.f2010;
        if (hashMap != null) {
            C1219.m3277(hashMap);
        }
        Boolean bool = r32.f2011;
        if (bool != null && !bool.equals(SpHandler.f1754.mo8104())) {
            SpHandler.f1754.mo8105(r32.f2011);
            Activity r0 = AppUtils.m1168();
            Integer num = null;
            if (r0 != null) {
                num = Integer.valueOf(r0.getTaskId());
            }
            LauncherActivity.f635 = r32.f2011.booleanValue();
            AppUtils.m1148(r32.f2011.booleanValue(), num);
        }
        Boolean bool2 = r32.f2012;
        if (bool2 != null && !bool2.equals(SpHandler.f1751.mo8104())) {
            SpHandler.f1751.mo8105(r32.f2012);
        }
        if (!TextUtils.isEmpty(r32.f2013)) {
            SpHandler.f1752.mo8105(r32.f2013);
        }
        Boolean bool3 = r32.f2014;
        if (bool3 != null && !bool3.equals(SpHandler.f1753.mo8104())) {
            if (!r32.f2014.booleanValue()) {
                SpHandler.f1753.mo8105(r32.f2014);
                MiadManager.m2210(r32.f2014.booleanValue());
            } else if (RequestPermissionHelper.m901()) {
                SpHandler.f1753.mo8105(r32.f2014);
                MiadManager.m2210(r32.f2014.booleanValue());
            }
        }
        Boolean bool4 = r32.f2015;
        if (bool4 != null && !bool4.equals(SpHandler.f1758.mo8104())) {
            SpHandler.f1758.mo8105(r32.f2015);
            C1273.m3362(r32.f2015.booleanValue());
        }
        Boolean bool5 = r32.f2016;
        if (bool5 == null || bool5.equals(SpHandler.f1759.mo8104())) {
            return true;
        }
        SpHandler.f1759.mo8105(r32.f2016);
        return true;
    }
}
