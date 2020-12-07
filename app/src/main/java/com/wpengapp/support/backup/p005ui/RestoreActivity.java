package com.wpengapp.support.backup.p005ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.text.BidiFormatter;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wpengapp.support.BackupPackage;
import com.wpengapp.support.C0527;
import com.wpengapp.support.C0536;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C1279;
import com.wpengapp.support.CountLimitHelper;
import com.wpengapp.support.DateUtils;
import com.wpengapp.support.IBackupItem;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.UserInfo;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.permission.RequestPermissionHelper;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.wpengapp.support.backup.ui.RestoreActivity */
public class RestoreActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public static String f669 = "fvl";

    /* renamed from: ؠ */
    public static String f670 = "bkfil";

    /* renamed from: ހ */
    public LinearLayout f671;

    /* renamed from: ށ */
    public boolean f672 = true;

    /* renamed from: ނ */
    public BackupPackage f673;

    public void onClick(View view) {
        if (!CountLimitHelper.m997("restoreclick", 800)) {
            UserInfo r5 = C0536.m1309();
            if (!this.f672 || (r5 != null && C0536.m1313(r5))) {
                HashSet hashSet = new HashSet();
                for (int i = 0; i < this.f671.getChildCount(); i++) {
                    CheckBox checkBox = (CheckBox) this.f671.getChildAt(i);
                    if (checkBox.isChecked()) {
                        hashSet.add((String) checkBox.getTag());
                    }
                }
                if (hashSet.size() == 0) {
                    C0826.m2179(R$string.pw_restore_select_empty, new Object[0]);
                } else if (!RequestPermissionHelper.m902()) {
                    C0915 r0 = new C0915(this);
                    r0.mo8905(R$string.pw_restore_confirm);
                    r0.mo8900(R$string.pw_cancel, (OnDialogClickListener) new C1124(this));
                    r0.mo8906(R$string.pw_ok, (OnDialogClickListener) new RestoreActivity(this, hashSet));
                    r0.mo8910();
                }
            } else {
                C0915 r52 = new C0915(this);
                r52.mo8909(R$string.wpengpay_function_disable2);
                r52.mo8902((CharSequence) getString(R$string.wpengpay_limit_tips, new Object[]{SystemUtils.m3519(getPackageName())}), 19);
                r52.mo8898(R$string.wpengpay_limit_tips_cancel);
                r52.mo8906(R$string.wpengpay_pro_dialog_ok, (OnDialogClickListener) new C0653(this));
                r52.mo8910();
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.pw_backup_restore);
        this.f671 = (LinearLayout) findViewById(R$id.layout_item);
        this.f672 = getIntent().getBooleanExtra(f669, true);
        String stringExtra = getIntent().getStringExtra(f670);
        if (TextUtils.isEmpty(stringExtra)) {
            C0826.m2172(R$string.pw_restore_read_fail, new Object[0]);
            finish();
            return;
        }
        mo7431(R$string.pw_wait);
        TaskManager.m2715((Runnable) new C0527(this, stringExtra));
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return getString(R$string.pw_restore);
    }

    /* renamed from: ֏ */
    public static void m851(Context context, boolean z, String str) {
        Intent intent = new Intent(context, RestoreActivity.class);
        intent.putExtra(f669, z);
        intent.putExtra(f670, str);
        SystemUtils.m3510(context, intent);
    }

    /* renamed from: ֏ */
    public final void mo7852(BackupPackage r7) {
        TextView textView = (TextView) findViewById(R$id.tv_note);
        String r1 = DateUtils.m2698(new Date(r7.f2319));
        String str = r7.f2318;
        if (str == null) {
            str = BidiFormatter.EMPTY_STRING;
        }
        textView.setText(Html.fromHtml(getString(R$string.pw_restore_info, new Object[]{str, r1})));
        for (String str2 : C1279.f3606.mo8865()) {
            if (!TextUtils.isEmpty(r7.f2321.get(str2))) {
                CheckBox checkBox = (CheckBox) View.inflate(this, R$layout.pw_backup_item, (ViewGroup) null);
                checkBox.setTag(str2);
                IBackupItem r4 = C1279.f3606.mo8859(str2);
                if (r4 != null) {
                    str2 = r4.getName();
                }
                checkBox.setText(str2);
                this.f671.addView(checkBox);
            }
        }
    }

    /* renamed from: ֏ */
    public final void mo7853(Set<String> set) {
        TaskManager.m2715((Runnable) new C0565(this, set));
    }
}
