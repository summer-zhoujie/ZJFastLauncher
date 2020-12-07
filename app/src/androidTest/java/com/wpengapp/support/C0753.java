package com.wpengapp.support;

import android.net.Uri;
import android.widget.TextView;
import com.wpengapp.support.C1017;
import com.wpengapp.support.UpdateHelper;
import com.wpengapp.support.model.App;
import java.io.File;

/* renamed from: com.wpengapp.support.Ӯ */
/* compiled from: UpdateHelper */
class C0753 implements C1017.C1018 {

    /* renamed from: ֏ */
    public final /* synthetic */ App.AppVersion f1944;

    /* renamed from: ؠ */
    public final /* synthetic */ UpdateHelper.C0447 f1945;

    /* renamed from: ހ */
    public final /* synthetic */ TextView f1946;

    public C0753(App.AppVersion appVersion, UpdateHelper.C0447 r2, TextView textView) {
        this.f1944 = appVersion;
        this.f1945 = r2;
        this.f1946 = textView;
    }

    /* renamed from: ֏ */
    public void mo8570() {
        TextView textView;
        UpdateHelper.f594 = false;
        C0826.m2179(R$string.pw_update_error_download, new Object[0]);
        if (this.f1944.forceUpdate && (textView = this.f1946) != null) {
            textView.setEnabled(true);
            this.f1946.setClickable(true);
            try {
                this.f1946.setText(R$string.pw_update_now);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: ֏ */
    public void mo8571(Uri uri) {
        UpdateHelper.f594 = false;
        String r3 = FileUtils.m1124(uri);
        if (r3 != null) {
            UpdateHelper.f597 = MD5Utils.m1341(new File(r3));
            UpdateHelper.f595 = r3;
            UpdateHelper.f596 = this.f1944.versionCode;
        } else {
            UpdateHelper.f597 = null;
            UpdateHelper.f595 = null;
            UpdateHelper.f596 = 0;
        }
        if (this.f1944.forceUpdate && this.f1945 != null) {
            AppUtils.m1147((Runnable) new C0908(this), 1000);
        }
    }
}
