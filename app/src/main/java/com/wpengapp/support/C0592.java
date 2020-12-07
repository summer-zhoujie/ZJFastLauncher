package com.wpengapp.support;

import android.content.Context;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.wpengapp.baseui.BaseActivity;
import com.wpengapp.support.UpdateHelper;
import com.wpengapp.support.model.App;

/* renamed from: com.wpengapp.support.ʅ */
/* compiled from: UpdateHelper */
public final class C0592 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ boolean f1330;

    /* renamed from: ؠ */
    public final /* synthetic */ App.AppVersion f1331;

    /* renamed from: ހ */
    public final /* synthetic */ UpdateHelper.C0447 f1332;

    public C0592(boolean z, App.AppVersion appVersion, UpdateHelper.C0447 r3) {
        this.f1330 = z;
        this.f1331 = appVersion;
        this.f1332 = r3;
    }

    public void run() {
        boolean z = this.f1330;
        App.AppVersion appVersion = this.f1331;
        UpdateHelper.C0447 r2 = this.f1332;
        UpdateHelper.f594 = false;
        boolean z2 = UpdateHelper.m745() && appVersion.gzh;
        String r6 = appVersion.forceUpdate ? Utils.m1864(R$string.pw_exit_app, new Object[0]) : Utils.m1864(R$string.pw_cancel, new Object[0]);
        String r7 = z2 ? Utils.m1864(R$string.pw_update_gzh, new Object[0]) : Utils.m1864(R$string.pw_update_now, new Object[0]);
        Context r8 = AppUtils.m1161();
        if (!(r8 instanceof BaseActivity)) {
            r8 = r8.getApplicationContext();
        }
        View inflate = View.inflate(r8, R$layout.pw_dialog_update, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_msg);
        String str = appVersion.changeLog;
        if (TextUtils.isEmpty(str)) {
            str = BidiFormatter.EMPTY_STRING;
        }
        textView.setText(str);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R$id.cb_ignore);
        View findViewById = inflate.findViewById(R$id.layout_ignore);
        findViewById.setOnClickListener(new C0628(checkBox));
        int i = 8;
        if (appVersion.forceUpdate || z) {
            findViewById.setVisibility(8);
        }
        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_gzh);
        if (!z2) {
            i = 0;
        }
        textView2.setVisibility(i);
        textView2.setOnClickListener(new C1327());
        String r0 = AppUtils.m1141(R$string.pw_update_success_title, SystemUtils.m3519(AppUtils.m1163()), appVersion.versionName);
        C0915 r4 = new C0915(r8);
        r4.f2469 = false;
        r4.f2464 = r0;
        r4.f2463 = inflate;
        r4.mo8903((CharSequence) r6, (OnDialogClickListener) new C0490(appVersion, r2, checkBox));
        r4.mo8907((CharSequence) r7, (OnDialogClickListener) new C1288(appVersion, r2));
        C0936.m2467(r4.mo8896());
    }
}
