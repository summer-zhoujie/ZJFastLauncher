package com.wpengapp.support;

import android.accessibilityservice.AccessibilityService;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: com.wpengapp.support.ۇ */
public abstract class AccTask {

    /* renamed from: ֏ */
    public long f2429 = 5000;

    /* renamed from: ؠ */
    public TaskCallback f2430;

    /* renamed from: ހ */
    public TaskCallback f2431;

    /* renamed from: ށ */
    public boolean f2432;

    /* renamed from: ނ */
    public volatile boolean f2433;

    /* renamed from: ރ */
    public AccTaskGroup f2434;

    /* renamed from: ބ */
    public long f2435;

    /* renamed from: ޅ */
    public boolean f2436;

    @NonNull
    public String toString() {
        if (this.f2434 == null) {
            return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
        }
        return this.f2434.toString() + " - " + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

    /* renamed from: ֏ */
    public void mo8876() {
        if (!mo8878()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.f2435 >= 300) {
                this.f2435 = elapsedRealtime;
                mo8202((AccessibilityEvent) null, AccServiceHelper.m2018((AccessibilityService) AccServiceHelper.m2019()), this.f2431);
            }
        }
    }

    /* renamed from: ֏ */
    public abstract void mo8202(@Nullable AccessibilityEvent accessibilityEvent, @Nullable AccessibilityNodeInfo accessibilityNodeInfo, @NonNull TaskCallback r3);

    /* renamed from: ֏ */
    public abstract void mo8203(@NonNull TaskCallback r1);

    /* renamed from: ؠ */
    public void mo8877() {
        if (!mo8878()) {
            this.f2433 = true;
            "[Task error]: " + this;
            AppUtils.m1155((Runnable) new C1230(this));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f2434;
     */
    /* renamed from: ހ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo8878() {
        /*
            r1 = this;
            boolean r0 = r1.f2433
            if (r0 != 0) goto L_0x0011
            com.wpengapp.support.ɢ r0 = r1.f2434
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.mo8878()
            if (r0 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = 0
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.AccTask.mo8878():boolean");
    }

    /* renamed from: ށ */
    public void mo8879() {
        if (!mo8878()) {
            this.f2436 = true;
            this.f2433 = true;
            "[Task success]: " + this;
            AppUtils.m1155((Runnable) new C1119(this));
        }
    }
}
