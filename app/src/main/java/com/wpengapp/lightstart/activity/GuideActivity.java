package com.wpengapp.lightstart.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import com.wpengapp.baseui.widget.ImageGuideView;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C1063;
import com.wpengapp.support.NetworkUtils;
import com.wpengapp.support.activity.WPengBaseActivity;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

public class GuideActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public static final String[] f441 = {"http://wpengapp.com/file/image/wpengapp/apppage/lightstart2/1.jpg", "http://wpengapp.com/file/image/wpengapp/apppage/lightstart2/2.jpg", "http://wpengapp.com/file/image/wpengapp/apppage/lightstart2/3.jpg", "http://wpengapp.com/file/image/wpengapp/apppage/lightstart2/4.jpg"};

    /* renamed from: ؠ */
    public ImageGuideView f442;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!NetworkUtils.m1800()) {
            C0826.m2179(2131493129, new Object[0]);
            return;
        }
        this.f442 = new ImageGuideView(this);
        setContentView((View) this.f442);
        this.f442.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        String r4 = C1063.m2859("skad_guide_images", (String) null);
        if (TextUtils.isEmpty(r4)) {
            this.f442.setImages(Arrays.asList(f441));
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(r4);
            if (jSONArray.length() == 0) {
                this.f442.setImages(Arrays.asList(f441));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            this.f442.setImages(arrayList);
        } catch (JSONException e) {
            e.getMessage();
            this.f442.setImages(Arrays.asList(f441));
        }
    }

    /* renamed from: ފ */
    public boolean mo7443() {
        return false;
    }
}
