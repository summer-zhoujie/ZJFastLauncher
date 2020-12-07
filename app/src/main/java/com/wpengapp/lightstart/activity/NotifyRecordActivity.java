package com.wpengapp.lightstart.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.BaseApplication;
import com.wpengapp.support.C0488;
import com.wpengapp.support.C0661;
import com.wpengapp.support.C0791;
import com.wpengapp.support.C0799;
import com.wpengapp.support.C0808;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C1015;
import com.wpengapp.support.C1114;
import com.wpengapp.support.C1260;
import com.wpengapp.support.C1267;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.NotifyImageManager;
import com.wpengapp.support.NotifyRecord;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.QueryCallback;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.TaskManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class NotifyRecordActivity extends NotifyRecordBaseActivity {

    /* renamed from: ނ */
    public ItemView f451;

    /* renamed from: ރ */
    public C1114 f452;

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 100 && intent != null) {
            String stringExtra = intent.getStringExtra("app");
            if (!TextUtils.isEmpty(stringExtra)) {
                HashSet hashSet = (HashSet) intent.getSerializableExtra("ids");
                ArrayList arrayList = new ArrayList(this.f456.f2806);
                if (!CollectionUtils.m1657((Collection) arrayList)) {
                    boolean z = false;
                    if (CollectionUtils.m1659((Collection) hashSet)) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (hashSet.contains(((NotifyRecord) it.next()).f3459)) {
                                it.remove();
                                z = true;
                            }
                        }
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            if (stringExtra.equals(((NotifyRecord) it2.next()).f3460)) {
                                it2.remove();
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        this.f456.mo9058(arrayList);
                    }
                }
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f452 = new C1114(this);
        if (BaseApplication.f562) {
            TaskManager.m2715((Runnable) new C1267(this));
        }
        if (SpHandler.f1763.mo8104().booleanValue()) {
            AppUtils.m1146((Runnable) new C0799(this));
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ boolean mo7648(CompoundButton compoundButton, boolean z) {
        SpHandler.f1763.mo8105(Boolean.valueOf(z));
        AppUtils.m1146((Runnable) new C0799(this));
        return false;
    }

    /* renamed from: ؠ */
    public /* synthetic */ void mo7649(String str) {
        this.f451.setDes((CharSequence) getString(R$string.notify_record_enable_des, new Object[]{str.toUpperCase()}));
    }

    /* renamed from: ގ */
    public void mo7651() {
        C0915 r0 = new C0915(this);
        r0.mo8905(R$string.record_clear_tips);
        r0.mo8898(2131493077);
        r0.mo8906(2131493133, (OnDialogClickListener) new C0808(this));
        r0.mo8910();
    }

    /* renamed from: ޏ */
    public String mo7652() {
        return null;
    }

    /* renamed from: ސ */
    public View mo7653() {
        View inflate = LayoutInflater.from(this).inflate(R$layout.view_notify_record_header, this.mList, false);
        this.f451 = (ItemView) inflate.findViewById(R$id.item_enable);
        this.f451.setChecked(SpHandler.f1763.mo8104().booleanValue());
        this.f451.setOnCheckedChangeListener(new C0661(this));
        if (BaseApplication.f562) {
            inflate.setOnClickListener(new com.wpengapp.support.NotifyRecordActivity(this));
        }
        return inflate;
    }

    /* renamed from: ޕ */
    public /* synthetic */ void mo7654() {
        this.f452.mo9299(false, false, false, (QueryCallback) new C1260(this));
    }

    /* renamed from: ޖ */
    public /* synthetic */ void mo7655() {
        long r0 = NotifyImageManager.m1915();
        if (r0 > 0) {
            runOnUiThread(new C0791(this, Formatter.formatFileSize(AppUtils.getApplication(), r0)));
        }
    }

    /* renamed from: ؠ */
    public /* synthetic */ boolean mo7650(View view) {
        C0488.m1085((Long) null, (String) null);
        mo7664();
        this.f456.mo9058(new ArrayList());
        return false;
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7647(C1114 r2, boolean z, boolean z2, int i) {
        if (!z2 && SpHandler.f1763.mo8104().booleanValue()) {
            SpHandler.f1763.mo8105(false);
            this.f451.mo7504(false, false);
            String string = getString(2131493337);
            C0915 r4 = new C0915(this);
            r4.f2464 = string;
            r4.mo8902((CharSequence) getString(2131493346, new Object[]{SystemUtils.m3519(getPackageName())}), 19);
            r4.mo8898(2131493347);
            r4.mo8906(2131493370, (OnDialogClickListener) C1015.f2914);
            r4.mo8910();
        }
    }
}
