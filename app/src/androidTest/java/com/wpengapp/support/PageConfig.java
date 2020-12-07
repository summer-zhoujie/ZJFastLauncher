package com.wpengapp.support;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.wpengapp.support.accservice.AccNodeSelector;
import java.io.Serializable;
import java.util.Objects;

/* renamed from: com.wpengapp.support.ग़ */
public class PageConfig implements Serializable {
    @SerializedName("is_black")

    /* renamed from: ֏ */
    public boolean f2973;
    @SerializedName("lst")

    /* renamed from: ؠ */
    public int f2974 = 0;
    @SerializedName("user_modify")

    /* renamed from: ހ */
    public boolean f2975;
    @SerializedName("type")

    /* renamed from: ށ */
    public Integer f2976;
    @SerializedName("node_selector")

    /* renamed from: ނ */
    public AccNodeSelector f2977;
    @SerializedName("bid")

    /* renamed from: ރ */
    public String f2978;
    @SerializedName("jump")

    /* renamed from: ބ */
    public String f2979;
    @SerializedName("delay")

    /* renamed from: ޅ */
    public Integer f2980;
    @SerializedName("loop")

    /* renamed from: ކ */
    public Integer f2981;
    @SerializedName("tx")

    /* renamed from: އ */
    public String f2982;
    @SerializedName("ac")

    /* renamed from: ވ */
    public Integer f2983;
    @SerializedName("ar")

    /* renamed from: މ */
    public Float f2984;
    @SerializedName("tt")

    /* renamed from: ފ */
    public Integer f2985;
    @SerializedName("inj")

    /* renamed from: ދ */
    public Integer f2986;
    @SerializedName("x")

    /* renamed from: ތ */
    public Integer f2987;
    @SerializedName("y")

    /* renamed from: ލ */
    public Integer f2988;

    public PageConfig() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PageConfig r5 = (PageConfig) obj;
        if (this.f2973 != r5.f2973 || !Objects.equals(this.f2976, r5.f2976) || !Objects.equals(this.f2977, r5.f2977) || !Objects.equals(this.f2978, r5.f2978) || !Objects.equals(this.f2979, r5.f2979) || !Objects.equals(this.f2980, r5.f2980) || !Objects.equals(this.f2981, r5.f2981) || !Objects.equals(this.f2982, r5.f2982) || !Objects.equals(this.f2983, r5.f2983) || !Objects.equals(this.f2984, r5.f2984) || !Objects.equals(this.f2985, r5.f2985) || !Objects.equals(this.f2986, r5.f2986) || !Objects.equals(this.f2987, r5.f2987) || !Objects.equals(this.f2988, r5.f2988)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.f2973), this.f2976, this.f2977, this.f2978, this.f2979, this.f2980, this.f2981, this.f2982, this.f2983, this.f2984, this.f2985, this.f2986, this.f2987, this.f2988});
    }

    @NonNull
    public String toString() {
        return GsonUtil.m2742(this);
    }

    /* renamed from: ֏ */
    public boolean mo8702() {
        return false;
    }

    /* renamed from: ؠ */
    public boolean mo9157() {
        Integer num = this.f2986;
        return num != null && num.intValue() == 1;
    }

    /* renamed from: ހ */
    public boolean mo9158() {
        Integer num = this.f2976;
        return num != null && num.intValue() == 1;
    }

    /* renamed from: ށ */
    public boolean mo9159() {
        return this.f2974 == 1 || this.f2975;
    }

    public PageConfig(PageConfig r3) {
        this.f2974 = r3.f2974;
        this.f2975 = r3.f2975;
        this.f2973 = r3.f2973;
        AccNodeSelector accNodeSelector = r3.f2977;
        this.f2977 = accNodeSelector == null ? null : new AccNodeSelector(accNodeSelector);
        this.f2978 = r3.f2978;
        this.f2979 = r3.f2979;
        this.f2980 = r3.f2980;
        this.f2981 = r3.f2981;
        this.f2976 = r3.f2976;
        this.f2982 = r3.f2982;
        this.f2983 = r3.f2983;
        this.f2984 = r3.f2984;
        this.f2985 = r3.f2985;
        this.f2986 = r3.f2986;
        this.f2987 = r3.f2987;
        this.f2988 = r3.f2988;
    }
}
