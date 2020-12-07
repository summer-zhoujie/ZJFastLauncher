package com.wpengapp.support;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.wpengapp.support.UpdateHelper;
import com.wpengapp.support.activity.WechatSubscriptionActivity;
import com.wpengapp.support.model.App;
import com.wpengapp.support.permission.RequestPermissionHelper;
import java.io.File;

/* renamed from: com.wpengapp.support.ဖ */
/* compiled from: UpdateHelper */
public final class C1288 implements OnDialogClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ App.AppVersion f3622;

    /* renamed from: ؠ */
    public final /* synthetic */ UpdateHelper.C0447 f3623;

    public C1288(App.AppVersion appVersion, UpdateHelper.C0447 r2) {
        this.f3622 = appVersion;
        this.f3623 = r2;
    }

    public boolean onClick(View view) {
        if (this.f3622.gzh && UpdateHelper.m745() && WechatSubscriptionActivity.m839(view.getContext(), "Update")) {
            return this.f3622.forceUpdate;
        }
        if (!TextUtils.isEmpty(this.f3622.exDlUrl)) {
            SystemUtils.m3527(this.f3622.exDlUrl);
            return this.f3622.forceUpdate;
        }
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        if (RequestPermissionHelper.m899(strArr)) {
            UpdateHelper.f594 = true;
            if (this.f3622.forceUpdate) {
                view.setEnabled(false);
                view.setClickable(false);
                try {
                    ((TextView) view).setText(R$string.pw_update_updating);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            if (this.f3622.versionCode == UpdateHelper.f596) {
                File file = new File(UpdateHelper.f595);
                if (TextUtils.equals(UpdateHelper.f597, MD5Utils.m1341(file)) && FileManager.m1197(file)) {
                    UpdateHelper.f594 = false;
                    if (this.f3622.forceUpdate && this.f3623 != null) {
                        AppUtils.m1147((Runnable) new C0645(this), 1000);
                    }
                    return this.f3622.forceUpdate;
                }
            }
            if (!this.f3622.forceUpdate) {
                C0826.m2179(R$string.pw_update_downloading, new Object[0]);
            }
            UpdateHelper.m737(this.f3622, this.f3623, (TextView) view);
            return this.f3622.forceUpdate;
        } else if (UpdateHelper.f598 || !AppUtils.m1169()) {
            SystemUtils.m3527(this.f3622.dlUrl);
            return this.f3622.forceUpdate;
        } else {
            UpdateHelper.f598 = true;
            RequestPermissionHelper.m897(strArr, (RequestPermissionHelper.C0458) new C0723(this, strArr));
            return true;
        }
    }
}
