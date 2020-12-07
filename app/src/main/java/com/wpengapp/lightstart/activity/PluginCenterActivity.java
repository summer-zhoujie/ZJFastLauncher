package com.wpengapp.lightstart.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.wpengapp.baseui.widget.SwitchButton;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0651;
import com.wpengapp.support.C0777;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0882;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C1114;
import com.wpengapp.support.C1278;
import com.wpengapp.support.C1279;
import com.wpengapp.support.CommonSP;
import com.wpengapp.support.MiadManager;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.QueryCallback;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.permission.RequestPermissionHelper;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PluginCenterActivity extends WPengBaseActivity {
    public FrameLayout mItemMiuiModel;
    public SwitchButton mSwMiuiModel;

    /* renamed from: ֏ */
    public C1114 f459;

    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131165368) {
            mo7420((Class<?>) ToastRecordActivity.class);
        } else if (id == 2131165328) {
            mo7420((Class<?>) AutoLoginActivity.class);
        } else if (id == 2131165346) {
            this.mSwMiuiModel.toggle();
        } else if (id == 2131165348) {
            mo7420((Class<?>) NotifyRecordActivity.class);
        } else if (id == 2131165354) {
            mo7420((Class<?>) QuickScanActivity.class);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R$layout.activity_plugin_center);
        mo7434().setBackgroundColor(0);
        findViewById(2131165487).setVisibility(4);
        this.f459 = new C1114(this);
        if (MiadManager.m2214()) {
            this.mSwMiuiModel.setChecked(SpHandler.f1753.mo8104().booleanValue());
            this.mSwMiuiModel.setOnCheckedChangeListener(new C1278(this));
        } else {
            this.mItemMiuiModel.setVisibility(8);
        }
        if (SpHandler.f1753.mo8104().booleanValue()) {
            AppUtils.m1146((Runnable) new C0651(this));
        }
        if (C1279.m3421("SHORTCUT")) {
            String[] strArr = {"SHORTCUT"};
            Set stringSet = CommonSP.f935.getStringSet("readmark", (Set) null);
            if (stringSet == null) {
                stringSet = new HashSet();
            }
            stringSet.addAll(Arrays.asList(strArr));
            CommonSP.m1229().putStringSet("readmark", stringSet).apply();
            TextView textView = (TextView) findViewById(R$id.tv_new_mark);
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 2131099796, 0);
            textView.setCompoundDrawablePadding(C0826.m2168(10.0f));
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7666(CompoundButton compoundButton, boolean z) {
        if (RequestPermissionHelper.m902()) {
            this.mSwMiuiModel.mo7525(false, false);
            return;
        }
        SpHandler.f1753.mo8105(Boolean.valueOf(z));
        MiadManager.m2210(z);
        if (z) {
            AppUtils.m1146((Runnable) new C0651(this));
        }
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, 2131099746);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return null;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ގ */
    public /* synthetic */ void mo7668() {
        this.f459.mo9299(false, false, false, (QueryCallback) new C0882(this));
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7667(C1114 r2, boolean z, boolean z2, int i) {
        if (!z2 && this.mSwMiuiModel.isChecked()) {
            String string = getString(2131493337);
            this.mSwMiuiModel.setChecked(false);
            C0915 r3 = new C0915(this);
            r3.f2464 = string;
            r3.mo8902((CharSequence) getString(2131493346, new Object[]{SystemUtils.m3519(getPackageName())}), 19);
            r3.mo8898(2131493347);
            r3.mo8906(2131493370, (OnDialogClickListener) C0777.f1996);
            r3.mo8910();
        }
    }
}
