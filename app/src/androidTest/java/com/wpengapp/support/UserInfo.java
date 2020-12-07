package com.wpengapp.support;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.wpengapp.support.א */
public class UserInfo {
    @SerializedName("id")

    /* renamed from: ֏ */
    public long f2110;
    @SerializedName("local_id")

    /* renamed from: ؠ */
    public String f2111;
    @SerializedName("device_id")

    /* renamed from: ހ */
    public String f2112;
    @SerializedName("device_model")

    /* renamed from: ށ */
    public String f2113;
    @SerializedName("app_id")

    /* renamed from: ނ */
    public String f2114;
    @SerializedName("create_time")

    /* renamed from: ރ */
    public long f2115;
    @SerializedName("status")

    /* renamed from: ބ */
    public int f2116 = 0;
    @SerializedName("client_time")

    /* renamed from: ޅ */
    public long f2117;
    @SerializedName("data_millis")

    /* renamed from: ކ */
    public long f2118;
    @SerializedName("trial_millis")

    /* renamed from: އ */
    public long f2119;
    @SerializedName("display_id")

    /* renamed from: ވ */
    public String f2120;
    @SerializedName("pay_types")

    /* renamed from: މ */
    public String f2121;
    @SerializedName("sell_price")

    /* renamed from: ފ */
    public int f2122;
    @SerializedName("sell_price_cd")

    /* renamed from: ދ */
    public int f2123;
    @SerializedName("fb")

    /* renamed from: ތ */
    public int f2124;
    @SerializedName("change_device")

    /* renamed from: ލ */
    public boolean f2125;
    @SerializedName("contact")

    /* renamed from: ގ */
    public String f2126;

    /* renamed from: ޏ */
    public boolean f2127 = false;

    /* renamed from: ސ */
    public Set<Integer> f2128;

    public String toString() {
        StringBuilder r0 = outline.m2549("UserInfo{id=");
        r0.append(this.f2110);
        r0.append(", localId='");
        r0.append(this.f2111);
        r0.append('\'');
        r0.append(", deviceId='");
        r0.append(this.f2112);
        r0.append('\'');
        r0.append(", deviceModel='");
        r0.append(this.f2113);
        r0.append('\'');
        r0.append(", appId='");
        r0.append(this.f2114);
        r0.append('\'');
        r0.append(", createTime=");
        r0.append(this.f2115);
        r0.append(", status=");
        r0.append(this.f2116);
        r0.append(", clientTime=");
        r0.append(this.f2117);
        r0.append(", dataMillis=");
        r0.append(this.f2118);
        r0.append(", trialMillis=");
        r0.append(this.f2119);
        r0.append(", displayId='");
        r0.append(this.f2120);
        r0.append('\'');
        r0.append(", payTypes='");
        r0.append(this.f2121);
        r0.append('\'');
        r0.append(", sellPrice=");
        r0.append(this.f2122);
        r0.append(", sellPriceCd=");
        r0.append(this.f2123);
        r0.append(", isCache=");
        r0.append(this.f2127);
        r0.append(", payTypeSet=");
        r0.append(this.f2128);
        r0.append('}');
        return r0.toString();
    }

    /* renamed from: ֏ */
    public boolean mo8705() {
        return this.f2116 == 1;
    }

    /* renamed from: ֏ */
    public boolean mo8706(int i) {
        if (TextUtils.isEmpty(this.f2121)) {
            return false;
        }
        if (this.f2128 == null) {
            this.f2128 = new HashSet();
            for (String trim : this.f2121.split(",")) {
                try {
                    this.f2128.add(Integer.valueOf(trim.trim()));
                } catch (Exception unused) {
                }
            }
        }
        return this.f2128.contains(Integer.valueOf(i));
    }
}
