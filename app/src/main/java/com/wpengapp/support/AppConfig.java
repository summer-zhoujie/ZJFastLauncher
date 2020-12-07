package com.wpengapp.support;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.wpengapp.support.ঢ */
public class AppConfig {
    @SerializedName("is_black")

    /* renamed from: ֏ */
    public boolean f3016;
    @SerializedName("user_modify")

    /* renamed from: ؠ */
    public boolean f3017;
    @SerializedName("reverse")

    /* renamed from: ހ */
    public boolean f3018;
    @SerializedName("page_configs")

    /* renamed from: ށ */
    public Map<String, PageConfig> f3019;

    public AppConfig() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AppConfig.class != obj.getClass()) {
            return false;
        }
        AppConfig r5 = (AppConfig) obj;
        if (this.f3016 == r5.f3016 && this.f3018 == r5.f3018 && Objects.equals(this.f3019, r5.f3019)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.f3016), Boolean.valueOf(this.f3018), this.f3019});
    }

    /* renamed from: ֏ */
    public void mo9231(AppConfig r2) {
        this.f3016 = r2.f3016;
        this.f3017 = r2.f3017;
        this.f3018 = r2.f3018;
        mo9232(r2.f3019);
    }

    public AppConfig(AppConfig r1) {
        mo9231(r1);
    }

    /* renamed from: ֏ */
    public void mo9232(Map<String, PageConfig> map) {
        if (map == null) {
            this.f3019 = null;
            return;
        }
        this.f3019 = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() != null) {
                this.f3019.put(next.getKey(), new PageConfig((PageConfig) next.getValue()));
            }
        }
    }
}
