package com.wpengapp.lightstart.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.wpengapp.baseui.widget.SwitchButton;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$menu;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.C0662;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0909;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C1219;
import com.wpengapp.support.C1282;
import com.wpengapp.support.C1323;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.CustomAppConfig;
import com.wpengapp.support.CustomConfig;
import com.wpengapp.support.CustomPageConfig;
import com.wpengapp.support.DateUtils;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.Utils;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.outline;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CustomRuleEditActivity extends WPengBaseActivity {
    public CheckBox mCbDaily;
    public CheckBox mCbLoop;
    public EditText mEtBtnText;
    public EditText mEtDelay;
    public EditText mEtNote;
    public RadioGroup mRadioGroupAction;
    public SwitchButton mSwitchButton;
    public TextView mTvApp;
    public TextView mTvPage;
    public TextView mTvStatus;

    /* renamed from: ֏ */
    public String f438;

    /* renamed from: ؠ */
    public String f439;

    /* renamed from: ހ */
    public CustomPageConfig f440;

    /* renamed from: ֏ */
    public static void m447(Context context, String str, String str2, CustomPageConfig r5) {
        Intent intent = new Intent(context, CustomRuleEditActivity.class);
        intent.putExtra("EXTRA_PKG", str);
        intent.putExtra("EXTRA_PAGE", str2);
        intent.putExtra("EXTRA_CONFIG", r5);
        SystemUtils.m3510(context, intent);
    }

    public void onCreate(@Nullable Bundle bundle) {
        Boolean bool;
        super.onCreate(bundle);
        this.f438 = getIntent().getStringExtra("EXTRA_PKG");
        this.f439 = getIntent().getStringExtra("EXTRA_PAGE");
        this.f440 = (CustomPageConfig) getIntent().getSerializableExtra("EXTRA_CONFIG");
        if (TextUtils.isEmpty(this.f438) || TextUtils.isEmpty(this.f439) || this.f440 == null) {
            finish();
            return;
        }
        setContentView((int) R$layout.activity_edit_rule);
        String r5 = SystemUtils.m3519(this.f438);
        if (TextUtils.isEmpty(r5)) {
            r5 = this.f438;
        }
        this.mEtNote.setText(this.f440.f2107);
        TextView textView = this.mTvApp;
        StringBuilder r52 = outline.m2550(r5, " (");
        r52.append(DateUtils.m2698(new Date(this.f440.f2106)));
        r52.append(")");
        textView.setText(r52.toString());
        TextView textView2 = this.mTvPage;
        String str = this.f439;
        textView2.setText(str.substring(str.lastIndexOf("/") + 1));
        EditText editText = this.mEtDelay;
        Integer num = this.f440.f2980;
        boolean z = false;
        editText.setText(String.valueOf(num == null ? 0 : num.intValue()));
        this.mEtBtnText.setText(this.f440.f2982);
        RadioGroup radioGroup = this.mRadioGroupAction;
        Integer num2 = this.f440.f2983;
        radioGroup.check((num2 == null || num2.intValue() == 0) ? R$id.radio_action_btn : R$id.radio_action_back);
        this.mSwitchButton.setChecked(!C1219.m3278(this.f438) && ((bool = this.f440.f2108) == null || bool.booleanValue()));
        this.mSwitchButton.setOnCheckedChangeListener(new C1282(this));
        CheckBox checkBox = this.mCbLoop;
        Integer num3 = this.f440.f2981;
        checkBox.setChecked((num3 == null || num3.intValue() == 0) ? false : true);
        CheckBox checkBox2 = this.mCbDaily;
        Integer num4 = this.f440.f2109;
        if (!(num4 == null || num4.intValue() == 0)) {
            z = true;
        }
        checkBox2.setChecked(z);
        findViewById(R$id.focus_content).requestFocus();
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131165219) {
            this.f440.f2107 = this.mEtNote.getText().toString().trim();
            if (TextUtils.isEmpty(this.f440.f2107)) {
                this.f440.f2107 = null;
            }
            int r5 = Utils.m1857(this.mEtDelay.getText().toString(), -1);
            if (r5 <= 0) {
                this.f440.f2980 = null;
            } else {
                this.f440.f2980 = Integer.valueOf(r5);
            }
            this.f440.f2982 = this.mEtBtnText.getText().toString().trim();
            if (TextUtils.isEmpty(this.f440.f2982)) {
                this.f440.f2982 = null;
            }
            if (this.mRadioGroupAction.getCheckedRadioButtonId() == 2131165430) {
                this.f440.f2983 = null;
            } else {
                this.f440.f2983 = 1;
            }
            if (this.mSwitchButton.isChecked()) {
                this.f440.f2108 = null;
            } else {
                this.f440.f2108 = false;
            }
            if (this.mCbLoop.isChecked()) {
                this.f440.f2981 = 1;
            } else {
                this.f440.f2981 = 0;
            }
            if (this.mCbDaily.isChecked()) {
                this.f440.f2109 = 1;
            } else {
                this.f440.f2109 = null;
            }
            C0909.m2386(this.f438, this.f439, this.f440);
            C0826.m2179(R$string.btn_saved, new Object[0]);
            finish();
        } else if (menuItem.getItemId() == 2131165208) {
            C0915 r52 = new C0915(this);
            r52.mo8905(R$string.btn_deleted_confirm);
            r52.mo8898(2131493077);
            r52.mo8906(2131493133, (OnDialogClickListener) new C0662(this));
            r52.mo8910();
        }
        return false;
    }

    /* renamed from: ؠ */
    public /* synthetic */ boolean mo7625(View view) {
        String str = this.f438;
        String str2 = this.f439;
        CustomPageConfig r1 = this.f440;
        T r2 = C0909.m2390();
        CustomAppConfig r8 = r2.f1747.get(str);
        if (r8 != null && !CollectionUtils.m1658((Map) r8.f2437)) {
            List list = r8.f2437.get(str2);
            if (!CollectionUtils.m1657((Collection) list)) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        i = -1;
                        break;
                    } else if (TextUtils.equals(r1.f2105, ((CustomPageConfig) list.get(i)).f2105)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    list.remove(i);
                    C1323<CustomConfig> r82 = C0909.f2440;
                    r82.f3785 = r2;
                    r82.f3791 = true;
                    outline.m2551((C1323) r82, (Object) r2);
                }
            }
        }
        C0826.m2179(R$string.btn_deleted, new Object[0]);
        finish();
        return false;
    }

    /* renamed from: ބ */
    public int mo7437() {
        return R$menu.activity_edit_rule;
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return getString(R$string.custom_rule);
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7624(CompoundButton compoundButton, boolean z) {
        if (C1219.m3278(this.f438)) {
            this.mSwitchButton.mo7525(false, false);
            C0826.m2179(R$string.custom_app_black, new Object[0]);
        } else if (!z || !C0909.m2387()) {
            this.mTvStatus.setText(z ? R$string.custom_enable_rule : R$string.custom_disable_rule);
        } else {
            CustomActivity.m425((Context) this);
            this.mSwitchButton.mo7525(false, false);
        }
    }
}
