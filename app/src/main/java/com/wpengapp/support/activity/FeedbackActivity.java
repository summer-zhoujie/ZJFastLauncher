package com.wpengapp.support.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0719;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C1279;
import com.wpengapp.support.CountLimitHelper;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.StatisticsManager;
import com.wpengapp.support.SystemUtils;
import java.util.HashMap;

public class FeedbackActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public EditText f633;

    /* renamed from: ؠ */
    public EditText f634;

    /* renamed from: ֏ */
    public static void m795(Context context) {
        SystemUtils.m3510(context, new Intent(context, FeedbackActivity.class));
    }

    public void onClick(View view) {
        String obj = this.f633.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            C0826.m2179(R$string.pw_feedback_hint, new Object[0]);
        } else if (CountLimitHelper.m998(FeedbackActivity.class.getSimpleName(), 60000, 2)) {
            C0826.m2179(R$string.pw_count_limit, new Object[0]);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("app", C1279.m3425());
            hashMap.put("content", obj);
            hashMap.put("ver", String.valueOf(AppUtils.m1158()));
            hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("device", C0719.m1816());
            String obj2 = this.f634.getText().toString();
            if (!TextUtils.isEmpty(obj2)) {
                hashMap.put("contact", obj2);
            }
            StatisticsManager.m733("def", "feedback", hashMap);
            StatisticsManager.m735();
            finish();
            C0826.m2179(R$string.pw_feedback_ok, new Object[0]);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.pw_activity_feedback);
        this.f633 = (EditText) findViewById(R$id.et_content);
        this.f634 = (EditText) findViewById(R$id.et_contact);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return getString(R$string.pw_feedback);
    }
}
