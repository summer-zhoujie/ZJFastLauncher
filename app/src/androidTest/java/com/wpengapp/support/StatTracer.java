package com.wpengapp.support;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.StoreHelper;

/* renamed from: com.wpengapp.support.ɒ */
public class StatTracer implements IRequestStat {

    /* renamed from: ֏ */
    public int f1222;

    /* renamed from: ؠ */
    public int f1223;

    /* renamed from: ހ */
    public int f1224;

    /* renamed from: ށ */
    public long f1225;

    /* renamed from: ނ */
    public long f1226 = 0;

    /* renamed from: ރ */
    public long f1227 = 0;

    /* renamed from: ބ */
    public Context f1228;

    public StatTracer(Context context) {
        this.f1228 = context.getApplicationContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        this.f1222 = sharedPreferences.getInt("successful_request", 0);
        this.f1223 = sharedPreferences.getInt("failed_requests ", 0);
        this.f1224 = sharedPreferences.getInt("last_request_spent_ms", 0);
        this.f1225 = sharedPreferences.getLong("last_request_time", 0);
        this.f1226 = sharedPreferences.getLong("last_req", 0);
    }

    /* renamed from: ֏ */
    public void mo8190() {
        this.f1226 = System.currentTimeMillis();
    }

    /* renamed from: ؠ */
    public void mo8191() {
        this.f1224 = (int) (System.currentTimeMillis() - this.f1226);
    }

    /* renamed from: ހ */
    public boolean mo8192() {
        boolean z = this.f1225 == 0;
        boolean z2 = !StoreHelper.m156a(this.f1228).mo7352i();
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    /* renamed from: ށ */
    public void mo8193() {
        Utils.m1861(this.f1228).edit().putInt("successful_request", this.f1222).putInt("failed_requests ", this.f1223).putInt("last_request_spent_ms", this.f1224).putLong("last_request_time", this.f1225).putLong("last_req", this.f1226).commit();
    }

    /* renamed from: ނ */
    public void mo8194() {
        Utils.m1861(this.f1228).edit().putLong("first_activate_time", System.currentTimeMillis()).commit();
    }

    /* renamed from: ރ */
    public boolean mo8195() {
        if (this.f1227 == 0) {
            this.f1227 = Utils.m1861(this.f1228).getLong("first_activate_time", 0);
        }
        return this.f1227 == 0;
    }

    /* renamed from: ބ */
    public long mo8196() {
        return this.f1226;
    }
}
