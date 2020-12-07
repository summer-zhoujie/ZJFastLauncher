package com.wpengapp.lightstart.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.activity.WPengBaseActivity;

public class CustomGuideActivity extends WPengBaseActivity {
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R$layout.activity_custom_guide);
        if (SpHandler.f1756.mo8104().booleanValue()) {
            SpHandler.f1756.mo8105(false);
        }
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return getString(R$string.custom_guide);
    }
}
