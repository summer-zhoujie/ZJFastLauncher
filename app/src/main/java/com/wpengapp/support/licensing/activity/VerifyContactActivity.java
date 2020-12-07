package com.wpengapp.support.licensing.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wpengapp.support.ActivityKiller;
import com.wpengapp.support.ApiConstant;
import com.wpengapp.support.C0536;
import com.wpengapp.support.C0719;
import com.wpengapp.support.C0870;
import com.wpengapp.support.C0915;
import com.wpengapp.support.ObjectCache;
import com.wpengapp.support.R$color;
import com.wpengapp.support.R$drawable;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.activity.WPengBaseActivity;
import java.util.HashMap;

public class VerifyContactActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public static boolean f693;

    /* renamed from: ؠ */
    public EditText f694;

    /* renamed from: ހ */
    public EditText f695;

    /* renamed from: ށ */
    public View f696;

    /* renamed from: ނ */
    public TextView f697;

    /* renamed from: ރ */
    public C0455 f698;

    /* renamed from: ބ */
    public CountDownTimer f699;

    /* renamed from: com.wpengapp.support.licensing.activity.VerifyContactActivity$֏ */
    public interface C0455 {
    }

    /* renamed from: ֏ */
    public static void m885(Context context, C0455 r3) {
        int r32 = ObjectCache.m1661((Object) r3);
        Intent intent = new Intent(context, VerifyContactActivity.class);
        intent.putExtra("callback", r32);
        SystemUtils.m3510(context, intent);
    }

    public void onClick(View view) {
        String replaceAll = this.f694.getText().toString().trim().replaceAll(" ", BidiFormatter.EMPTY_STRING);
        if (TextUtils.isEmpty(replaceAll)) {
            mo7424(R$string.wpengpay_input_contact_input);
        } else if (view.getId() == R$id.tv_submit) {
            String replaceAll2 = this.f695.getText().toString().trim().replaceAll(" ", BidiFormatter.EMPTY_STRING);
            if (TextUtils.isEmpty(replaceAll2)) {
                mo7424(R$string.wpengpay_verify_code_input);
            } else {
                ((C0870) this.f698).mo8824(replaceAll, replaceAll2, this);
            }
        } else if (view.getId() == R$id.tv_send_code) {
            ((C0870) this.f698).mo8823(replaceAll, this);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        this.f698 = (C0455) ObjectCache.m1662(getIntent().getIntExtra("callback", 0));
        if (this.f698 == null) {
            finish();
            return;
        }
        ActivityKiller.f1598.put(this, this);
        setContentView(R$layout.pw_activity_verify_contact);
        mo7434().setBackgroundColor(0);
        findViewById(R$id.toolbarLine).setVisibility(4);
        this.f694 = (EditText) findViewById(R$id.et_contact);
        this.f695 = (EditText) findViewById(R$id.et_code);
        ScrollView scrollView = (ScrollView) findViewById(R$id.scroll);
        this.f696 = findViewById(R$id.progress);
        this.f697 = (TextView) findViewById(R$id.tv_send_code);
        HashMap hashMap = new HashMap();
        hashMap.put("did", C0719.m1820());
        hashMap.put("app_id", C0536.m1299());
        mo7431(R$string.pw_wait);
        new com.wpengapp.support.VerifyContactActivity(this, ApiConstant.f2725, hashMap, "contact").mo8757(false);
        findViewById(R$id.tv_forget_contact).setOnClickListener(new C0732(this));
    }

    public void onDestroy() {
        super.onDestroy();
        ObjectCache.m1663(getIntent().getIntExtra("callback", 0));
        CountDownTimer countDownTimer = this.f699;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* renamed from: ހ */
    public void mo7865(boolean z) {
        int i = 0;
        this.f696.setVisibility(z ? 0 : 8);
        TextView textView = this.f697;
        if (z) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, R$drawable.baseui_icon_toolbar_back_dark);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return null;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ֏ */
    public void mo7864(long j) {
        if (!isFinishing() && !mo7442()) {
            if (this.f694.getText().toString().contains("@")) {
                if (f693) {
                    C0915 r0 = new C0915(this);
                    r0.mo8905(R$string.wpengpay_verify_dustbin_tips);
                    r0.mo8898(R$string.pw_ok);
                    r0.mo8896().show();
                }
                f693 = true;
            }
            this.f697.setEnabled(false);
            int defaultColor = this.f697.getTextColors().getDefaultColor();
            this.f697.setTextColor(ContextCompat.getColor(this, R$color.material_textBlack_disable));
            CountDownTimer countDownTimer = this.f699;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f699 = new C0854(this, j < 120000 ? 120000 : j, 1000, defaultColor);
            this.f699.start();
            this.f695.requestFocus();
        }
    }
}
