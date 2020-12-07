package com.wpengapp.lightstart.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.C0488;
import com.wpengapp.support.C0642;
import com.wpengapp.support.C0915;
import com.wpengapp.support.NotifyRecord;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.SystemUtils;
import java.util.HashSet;
import java.util.List;

public class NotifyRecordAppActivity extends NotifyRecordBaseActivity {

    /* renamed from: ނ */
    public String f453;

    /* renamed from: ރ */
    public HashSet<Long> f454 = new HashSet<>();

    public void onCreate(@Nullable Bundle bundle) {
        this.f453 = getIntent().getStringExtra("app");
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.f453)) {
            finish();
        }
    }

    /* renamed from: ֏ */
    public void mo7656(NotifyRecord r5) {
        Long l;
        if (r5 != null) {
            C0488.m1084(r5.f3459);
            List<Model> list = this.f456.f2806;
            for (int i = 0; i < list.size(); i++) {
                Long l2 = ((NotifyRecord) list.get(i)).f3459;
                if (l2 != null && l2.equals(r5.f3459)) {
                    this.f456.mo9172(i, 1);
                }
            }
        }
        if (r5 != null && (l = r5.f3459) != null) {
            this.f454.add(l);
            Intent intent = new Intent();
            intent.putExtra("app", this.f453);
            intent.putExtra("ids", this.f454);
            setResult(100, intent);
        }
    }

    /* renamed from: ؠ */
    public /* synthetic */ boolean mo7657(View view) {
        C0488.m1090(this.f453);
        Intent intent = new Intent();
        intent.putExtra("app", this.f453);
        setResult(100, intent);
        finish();
        return false;
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        String r0 = SystemUtils.m3519(this.f453);
        return TextUtils.isEmpty(r0) ? this.f453 : r0;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return false;
    }

    /* renamed from: ގ */
    public void mo7651() {
        C0915 r0 = new C0915(this);
        r0.mo8905(R$string.record_clear_tips);
        r0.mo8898(2131493077);
        r0.mo8906(2131493133, (OnDialogClickListener) new C0642(this));
        r0.mo8910();
    }

    /* renamed from: ޏ */
    public String mo7652() {
        return this.f453;
    }

    /* renamed from: ސ */
    public View mo7653() {
        return new View(this);
    }
}
