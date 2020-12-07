package com.wpengapp.lightstart.activity;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.CompoundButton;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.C0500;
import com.wpengapp.support.C0542;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0832;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0918;
import com.wpengapp.support.C1109;
import com.wpengapp.support.C1261;
import com.wpengapp.support.C1273;
import com.wpengapp.support.C1293;
import com.wpengapp.support.DeviceAdminHelper;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.activity.LauncherActivity;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.permission.ServicePermissionActivity;

public class MoreSettingsActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public ItemView f449;

    /* renamed from: ؠ */
    public ItemView f450;

    /* renamed from: ֏ */
    public static /* synthetic */ boolean m478(CompoundButton compoundButton, boolean z) {
        SpHandler.f1758.mo8105(Boolean.valueOf(z));
        C1273.m3362(z);
        return false;
    }

    /* renamed from: ށ */
    public static /* synthetic */ boolean m480(CompoundButton compoundButton, boolean z) {
        if (z) {
            DeviceAdminHelper.m721(compoundButton.getContext());
            return true;
        }
        DeviceAdminHelper.m722(compoundButton.getContext().getApplicationContext());
        return false;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R$layout.activity_more_settings);
        findViewById(R$id.item_permission).setOnClickListener(new C1293(this));
        ItemView itemView = (ItemView) findViewById(R$id.item_status_notifi);
        itemView.setChecked(SpHandler.f1758.mo8104().booleanValue());
        itemView.setOnCheckedChangeListener(C0832.f2171);
        this.f449 = (ItemView) findViewById(R$id.item_hide_launcher);
        this.f449.setChecked(SpHandler.f1755.mo8104().booleanValue());
        this.f449.setOnCheckedChangeListener(new C0918(this));
        ItemView itemView2 = (ItemView) findViewById(R$id.item_share_cfg);
        itemView2.setChecked(SpHandler.f1759.mo8104().booleanValue());
        itemView2.setOnCheckedChangeListener(C0542.f1087);
        if (!DeviceAdminHelper.m725()) {
            DeviceAdminHelper.m723(true);
        }
        this.f450 = (ItemView) findViewById(R$id.item_device_admin);
        this.f450.setDes((CharSequence) Html.fromHtml(getString(R$string.deviceadmin_des)));
        this.f450.setOnCheckedChangeListener(C1109.f3161);
    }

    public void onResume() {
        super.onResume();
        this.f450.mo7504(DeviceAdminHelper.m724(), false);
    }

    /* renamed from: ؠ */
    public /* synthetic */ boolean mo7645(CompoundButton compoundButton, boolean z) {
        ComponentName componentName = new ComponentName(this, LauncherActivity.class);
        if (!z) {
            SpHandler.f1755.mo8105(Boolean.valueOf(z));
            getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        } else if (Build.VERSION.SDK_INT >= 29) {
            C0826.m2179(R$string.hide_launcher_des2, new Object[0]);
        } else {
            C0915 r1 = new C0915(this);
            r1.f2469 = false;
            r1.mo8897(0.9f);
            r1.mo8909(R$string.hide_launcher_warn);
            r1.mo8905(R$string.hide_launcher_des);
            r1.mo8900(2131493077, (OnDialogClickListener) new C0500(this));
            r1.mo8906(2131493133, (OnDialogClickListener) new C1261(this, z, componentName));
            r1.mo8910();
        }
        return false;
    }

    /* renamed from: ހ */
    public /* synthetic */ void mo7646(View view) {
        ServicePermissionActivity.m909((Context) this);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return getString(R$string.more_settings);
    }

    /* renamed from: ֏ */
    public /* synthetic */ boolean mo7643(boolean z, ComponentName componentName, View view) {
        SpHandler.f1755.mo8105(Boolean.valueOf(z));
        getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
        return false;
    }

    /* renamed from: ؠ */
    public /* synthetic */ boolean mo7644(View view) {
        this.f449.mo7504(false, false);
        return false;
    }
}
