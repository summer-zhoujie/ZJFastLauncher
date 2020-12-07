package com.wpengapp.support.backup.p005ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wpengapp.baseui.filepicker.FilePicker;
import com.wpengapp.support.C0536;
import com.wpengapp.support.C0572;
import com.wpengapp.support.C0584;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0936;
import com.wpengapp.support.C1279;
import com.wpengapp.support.C1331;
import com.wpengapp.support.CommonSP;
import com.wpengapp.support.CountLimitHelper;
import com.wpengapp.support.FileManager;
import com.wpengapp.support.IBackupItem;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.UserInfo;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.outline;
import com.wpengapp.support.permission.RequestPermissionHelper;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.wpengapp.support.backup.ui.BackupActivity */
public class BackupActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public static String f662 = "fvl";

    /* renamed from: ؠ */
    public static String f663 = outline.m2548(new StringBuilder(), FileManager.f914, "/backup");

    /* renamed from: ހ */
    public EditText f664;

    /* renamed from: ށ */
    public TextView f665;

    /* renamed from: ނ */
    public LinearLayout f666;

    /* renamed from: ރ */
    public String f667;

    /* renamed from: ބ */
    public boolean f668 = true;

    /* renamed from: ޏ */
    public static String m848() {
        return CommonSP.f935.getString("bkdir", f663);
    }

    public void onClick(View view) {
        if (!CountLimitHelper.m997("backupclick", 800)) {
            UserInfo r0 = C0536.m1309();
            if (this.f668 && (r0 == null || !C0536.m1313(r0))) {
                C0915 r7 = new C0915(this);
                r7.mo8909(R$string.wpengpay_function_disable2);
                r7.mo8902((CharSequence) getString(R$string.wpengpay_limit_tips, new Object[]{SystemUtils.m3519(getPackageName())}), 19);
                r7.mo8898(R$string.wpengpay_limit_tips_cancel);
                r7.mo8906(R$string.wpengpay_pro_dialog_ok, (OnDialogClickListener) new C0734(this));
                r7.mo8910();
            } else if (!RequestPermissionHelper.m902()) {
                String obj = this.f664.getText().toString();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.f666.getChildCount(); i++) {
                    CheckBox checkBox = (CheckBox) this.f666.getChildAt(i);
                    if (checkBox.isChecked()) {
                        arrayList.add((String) checkBox.getTag());
                    }
                }
                if (arrayList.size() == 0) {
                    C0826.m2179(R$string.pw_backup_select_empty, new Object[0]);
                    return;
                }
                int id = view.getId();
                if (id == R$id.tv_save_sdcard) {
                    new File(this.f667).mkdirs();
                    TaskManager.m2715((Runnable) new C0572(this, obj, arrayList));
                } else if (id == R$id.tv_send_to) {
                    TaskManager.m2715((Runnable) new C1331(this, obj, arrayList));
                }
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.pw_backup_index);
        this.f664 = (EditText) findViewById(R$id.et_note);
        C0826.m2175(this.f664, (InputFilter) new C1118(this));
        this.f666 = (LinearLayout) findViewById(R$id.layout_item);
        for (String str : C1279.f3606.mo8865()) {
            CheckBox checkBox = (CheckBox) View.inflate(this, R$layout.pw_backup_item, (ViewGroup) null);
            checkBox.setTag(str);
            IBackupItem r4 = C1279.f3606.mo8859(str);
            if (r4 != null) {
                str = r4.getName();
            }
            checkBox.setText(str);
            this.f666.addView(checkBox);
        }
        this.f667 = m848();
        this.f665 = (TextView) findViewById(R$id.tv_dir);
        this.f665.setText(FilePicker.m267(this.f667));
        this.f665.setOnClickListener(new C1077(this));
        this.f668 = getIntent().getBooleanExtra(f662, true);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return getString(R$string.pw_backup);
    }

    /* renamed from: ގ */
    public final void mo7850() {
        if (!RequestPermissionHelper.m902()) {
            C0584 r0 = new C0584(this);
            r0.f1268.setDir(this.f667);
            r0.f1268.setChooseDir(true);
            r0.f1270.setVisibility(0);
            r0.f1271.setText(getString(R$string.pw_backup_select));
            r0.f1272 = new BackupActivity(this);
            C0936.m2466(r0);
        }
    }

    /* renamed from: ֏ */
    public static void m845(Activity activity, boolean z) {
        Intent intent = new Intent(activity, BackupActivity.class);
        intent.putExtra(f662, z);
        activity.startActivity(intent);
    }
}
