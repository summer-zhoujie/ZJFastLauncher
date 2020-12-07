package com.wpengapp.support.licensing.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wpengapp.support.ActivityKiller;
import com.wpengapp.support.C0678;
import com.wpengapp.support.C1063;
import com.wpengapp.support.ObjectCache;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.RemoteSP;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.activity.WPengBaseActivity;

public class InputContactActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public EditText f675;

    /* renamed from: ؠ */
    public EditText f676;

    /* renamed from: ހ */
    public TextView f677;

    /* renamed from: ށ */
    public ScrollView f678;

    /* renamed from: ނ */
    public View f679;

    /* renamed from: ރ */
    public View f680;

    /* renamed from: ބ */
    public RadioButton f681;

    /* renamed from: ޅ */
    public RadioButton f682;

    /* renamed from: ކ */
    public C0453 f683;

    /* renamed from: com.wpengapp.support.licensing.activity.InputContactActivity$֏ */
    public interface C0453 {
        /* renamed from: ֏ */
        void mo7857(String str, boolean z, InputContactActivity inputContactActivity);
    }

    /* renamed from: ֏ */
    public static void m862(Context context, String str, boolean z, int i, int i2, C0453 r7) {
        int r72 = ObjectCache.m1661((Object) r7);
        Intent intent = new Intent(context, InputContactActivity.class);
        intent.putExtra("callback", r72);
        intent.putExtra("tips", str);
        intent.putExtra("showRadio", z);
        intent.putExtra("singlePrice", i);
        intent.putExtra("changePrice", i2);
        SystemUtils.m3510(context, intent);
    }

    public void onClick(View view) {
        if (view.getId() == R$id.tv_submit) {
            String replaceAll = this.f675.getText().toString().trim().replaceAll(" ", BidiFormatter.EMPTY_STRING);
            String replaceAll2 = this.f676.getText().toString().trim().replaceAll(" ", BidiFormatter.EMPTY_STRING);
            if (TextUtils.isEmpty(replaceAll)) {
                mo7424(R$string.wpengpay_input_contact_input);
            } else if (!replaceAll.equals(replaceAll2)) {
                mo7424(R$string.wpengpay_input_contact_input2_error);
            } else {
                RemoteSP.m1206("inputcontact", (Object) replaceAll, false);
                this.f683.mo7857(replaceAll, this.f682.isChecked(), this);
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        this.f683 = (C0453) ObjectCache.m1662(getIntent().getIntExtra("callback", 0));
        if (this.f683 == null) {
            finish();
            return;
        }
        ActivityKiller.f1598.put(this, this);
        setContentView(R$layout.pw_activity_input_contact);
        this.f675 = (EditText) findViewById(R$id.et_contact);
        this.f676 = (EditText) findViewById(R$id.et_contact2);
        TextView textView = (TextView) findViewById(R$id.tv_submit);
        this.f677 = (TextView) findViewById(R$id.tv_tips);
        this.f678 = (ScrollView) findViewById(R$id.scroll);
        this.f679 = findViewById(R$id.layout_single_device);
        this.f680 = findViewById(R$id.layout_change_device);
        this.f681 = (RadioButton) findViewById(R$id.radio_single_device);
        this.f682 = (RadioButton) findViewById(R$id.radio_change_device);
        this.f677.setText(getIntent().getStringExtra("tips"));
        this.f676.setText(RemoteSP.m1202("inputcontact", BidiFormatter.EMPTY_STRING));
        if (getIntent().getBooleanExtra("showRadio", false)) {
            int intExtra = getIntent().getIntExtra("changePrice", 0);
            boolean equals = "1".equals(C1063.m2859("sp_fullpycd", "1"));
            int intExtra2 = getIntent().getIntExtra("singlePrice", 0);
            this.f681.setText(getString(R$string.wpengpay_format_price, new Object[]{String.valueOf(C0678.m1723(intExtra2))}));
            this.f681.setOnCheckedChangeListener(new C0692(this));
            if (!equals || intExtra <= 0) {
                this.f681.setChecked(true);
                this.f682.setChecked(false);
                this.f680.setVisibility(8);
            } else {
                this.f681.setChecked(false);
                this.f682.setChecked(true);
                this.f682.setText(getString(R$string.wpengpay_format_price, new Object[]{String.valueOf(C0678.m1723(intExtra))}));
                this.f682.setOnCheckedChangeListener(new C0773(this));
                this.f679.setOnClickListener(new InputContactActivity(this));
                this.f680.setOnClickListener(new C1120(this));
            }
        } else {
            this.f679.setVisibility(8);
            this.f680.setVisibility(8);
            this.f681.setChecked(true);
            this.f682.setChecked(false);
        }
        this.f678.getViewTreeObserver().addOnGlobalLayoutListener(new C1071(this));
    }

    public void onDestroy() {
        super.onDestroy();
        ObjectCache.m1663(getIntent().getIntExtra("callback", 0));
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return getString(R$string.wpengpay_input_contact_title);
    }
}
