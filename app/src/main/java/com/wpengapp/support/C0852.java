package com.wpengapp.support;

import android.support.p000v4.app.ActivityCompat;
import android.view.View;
import com.wpengapp.support.permission.RequestPermissionHelper;

/* renamed from: com.wpengapp.support.ط */
/* compiled from: RequestPermissionHelper */
class C0852 implements OnDialogClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ boolean f2306;

    /* renamed from: ؠ */
    public final /* synthetic */ RequestPermissionHelper f2307;

    public C0852(RequestPermissionHelper requestPermissionHelper, boolean z) {
        this.f2307 = requestPermissionHelper;
        this.f2306 = z;
    }

    public boolean onClick(View view) {
        if (this.f2306) {
            this.f2307.mo7893();
            return false;
        }
        ActivityCompat.requestPermissions(this.f2307, this.f2307.f708, 100);
        return false;
    }
}
