package com.wpengapp.support.licensing.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.wpengapp.support.ApiConstant;
import com.wpengapp.support.C0536;
import com.wpengapp.support.C0719;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0944;
import com.wpengapp.support.C1279;
import com.wpengapp.support.R$drawable;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.licensing.model.FindContactDto;
import java.util.HashMap;
import java.util.Map;

public class FindContactActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public EditText f674;

    public void onClick(View view) {
        String trim = this.f674.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            mo7424(R$string.wpengpay_find_contact_hint);
            return;
        }
        mo7431(R$string.pw_wait);
        FindContactActivity r0 = new FindContactActivity(this);
        HashMap hashMap = new HashMap();
        hashMap.put("trid", trim);
        hashMap.put("dm", C0719.m1816());
        hashMap.put("app_id", C0536.m1299());
        C1279.m3415((Map<String, String>) hashMap);
        hashMap.put("lsv", "2");
        new C0944(ApiConstant.f2726, hashMap, r0).mo8757(false);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.pw_activity_find_contact);
        mo7434().setBackgroundColor(0);
        findViewById(R$id.toolbarLine).setVisibility(4);
        this.f674 = (EditText) findViewById(R$id.et_info);
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
    public final void mo7855(FindContactDto findContactDto) {
        String str;
        if (!findContactDto.exist) {
            mo7413(R$string.wpengpay_find_contact_notexist);
            return;
        }
        if (findContactDto.canLogin) {
            str = getString(R$string.wpengpay_find_contact_canlogin);
        } else if (getPackageName().equals(findContactDto.appPkg)) {
            str = getString(R$string.wpengpay_find_contact_cannotlogin2, new Object[]{findContactDto.device, C0719.m1816()});
        } else {
            str = getString(R$string.wpengpay_find_contact_cannotlogin1, new Object[]{findContactDto.appName, SystemUtils.m3519(getPackageName())});
        }
        String obj = Html.fromHtml(getString(R$string.wpengpay_find_contact_ret, new Object[]{findContactDto.contact, str})).toString();
        C0915 r0 = new C0915(this);
        r0.mo8909(R$string.wpengpay_find_contact_ret_title);
        r0.mo8902((CharSequence) obj, 19);
        r0.f2469 = false;
        r0.mo8898(R$string.pw_i_know);
        r0.mo8910();
    }
}
