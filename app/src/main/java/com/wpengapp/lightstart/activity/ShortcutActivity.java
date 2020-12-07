package com.wpengapp.lightstart.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0675;
import com.wpengapp.support.C0774;
import com.wpengapp.support.C0826;
import com.wpengapp.support.UnpaidCountLimit;

public class ShortcutActivity extends Activity {

    /* renamed from: ֏ */
    public static UnpaidCountLimit f461 = new UnpaidCountLimit(3);

    public void onCreate(@Nullable Bundle bundle) {
        boolean z = false;
        if (f461.mo8264()) {
            C0826.m2172((int) R$string.trial_tips, new Object[0]);
        } else {
            String stringExtra = getIntent().getStringExtra("sid");
            try {
                C0774.m2083(stringExtra);
                z = true;
                e = null;
            } catch (Exception e) {
                e = e;
                e.toString();
                C0826.m2179(R$string.launch_error, new Object[0]);
                f461.mo8263();
            }
            C0774.m2084(stringExtra, getIntent().getStringExtra("tp"), e);
        }
        super.onCreate(bundle);
        if (z) {
            AppUtils.m1147((Runnable) new C0675(this), 1000);
        } else {
            finish();
        }
    }
}
