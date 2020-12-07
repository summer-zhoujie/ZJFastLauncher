package com.wpengapp.lightstart.activity;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.text.Html;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.wpengapp.baseui.AppWrapper;
import com.wpengapp.baseui.widget.ChoiceAppListView;
import com.wpengapp.baseui.widget.ClearEditText;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.baseui.widget.SwitchButton;
import com.wpengapp.lightstart.R$color;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$menu;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.AlertDialog;
import com.wpengapp.support.AppConfig;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.BackupRestoreDialog;
import com.wpengapp.support.C0467;
import com.wpengapp.support.C0471;
import com.wpengapp.support.C0492;
import com.wpengapp.support.C0493;
import com.wpengapp.support.C0511;
import com.wpengapp.support.C0512;
import com.wpengapp.support.C0518;
import com.wpengapp.support.C0536;
import com.wpengapp.support.C0566;
import com.wpengapp.support.C0581;
import com.wpengapp.support.C0603;
import com.wpengapp.support.C0727;
import com.wpengapp.support.C0730;
import com.wpengapp.support.C0758;
import com.wpengapp.support.C0789;
import com.wpengapp.support.C0801;
import com.wpengapp.support.C0815;
import com.wpengapp.support.C0825;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0866;
import com.wpengapp.support.C0886;
import com.wpengapp.support.C0888;
import com.wpengapp.support.C0902;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0919;
import com.wpengapp.support.C0961;
import com.wpengapp.support.C0984;
import com.wpengapp.support.C0999;
import com.wpengapp.support.C1031;
import com.wpengapp.support.C1114;
import com.wpengapp.support.C1122;
import com.wpengapp.support.C1149;
import com.wpengapp.support.C1167;
import com.wpengapp.support.C1203;
import com.wpengapp.support.C1207;
import com.wpengapp.support.C1219;
import com.wpengapp.support.C1235;
import com.wpengapp.support.C1244;
import com.wpengapp.support.C1248;
import com.wpengapp.support.C1263;
import com.wpengapp.support.C1270;
import com.wpengapp.support.C1272;
import com.wpengapp.support.C1302;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.FullVersionTag;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.Oppo;
import com.wpengapp.support.PageConfig;
import com.wpengapp.support.PopupDialog;
import com.wpengapp.support.QueryCallback;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.SystemApi;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.UserInfo;
import com.wpengapp.support.Utils;
import com.wpengapp.support.activity.LauncherActivity;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.backup.p005ui.BackupActivity;
import com.wpengapp.support.outline;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AppSetupListActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public ChoiceAppListView f419;

    /* renamed from: ؠ */
    public boolean f420;

    /* renamed from: ހ */
    public C1114 f421;

    /* renamed from: ށ */
    public SwitchButton f422;

    /* renamed from: ނ */
    public ItemView f423;

    /* renamed from: ރ */
    public View f424;

    /* renamed from: ބ */
    public boolean f425;

    /* renamed from: com.wpengapp.lightstart.activity.AppSetupListActivity$֏ */
    private class C0437 extends C0961 {

        /* renamed from: އ */
        public Set<String> f426;

        /* renamed from: ވ */
        public boolean f427;

        public C0437(Context context) {
            super(context);
            if (C0919.m2416() == 0) {
                HashMap<String, AppConfig> r5 = C1219.m3276();
                HashSet hashSet = new HashSet();
                for (Map.Entry next : r5.entrySet()) {
                    if (next.getValue() != null) {
                        AppConfig r1 = (AppConfig) next.getValue();
                        if (!r1.f3016) {
                            String str = (String) next.getKey();
                            if (!CollectionUtils.m1658((Map) r1.f3019)) {
                                for (Map.Entry next2 : r1.f3019.entrySet()) {
                                    if (next2.getValue() != null && !((PageConfig) next2.getValue()).f2973 && ((PageConfig) next2.getValue()).mo9157()) {
                                        hashSet.add(str);
                                    }
                                }
                            }
                        }
                    }
                }
                this.f426 = hashSet;
            } else {
                this.f426 = new HashSet();
            }
            this.f427 = C1149.m3079();
        }

        /* renamed from: ֏ */
        public Comparator<AppWrapper> mo7599() {
            return C1235.f3507;
        }

        /* renamed from: ؠ */
        public int mo7565() {
            return R$layout.item_setup_app_list;
        }

        /* renamed from: ֏ */
        public static /* synthetic */ int m401(AppWrapper appWrapper, AppWrapper appWrapper2) {
            int r2;
            int r3;
            if (appWrapper == null) {
                return 1;
            }
            if (appWrapper2 == null || (r2 = C0471.m1011(appWrapper.packageName)) > (r3 = C0471.m1011(appWrapper2.packageName))) {
                return -1;
            }
            if (r2 < r3) {
                return 1;
            }
            return appWrapper.compareTo(appWrapper2);
        }

        /* renamed from: ֏ */
        public void mo7564(int i, View view, C0962 r7, AppWrapper appWrapper) {
            super.mo7564(i, view, r7, appWrapper);
            view.setOnClickListener(new C0999(this, appWrapper));
            View view2 = (View) view.getTag(R$id.layout_switch);
            if (view2 == null) {
                view2 = view.findViewById(R$id.layout_switch);
                view.setTag(R$id.layout_switch, view2);
            }
            view2.setOnClickListener(new C0566(r7));
            TextView textView = (TextView) view.getTag(2131165511);
            if (textView == null) {
                textView = (TextView) view.findViewById(2131165511);
                view.setTag(2131165511, textView);
            }
            AppConfig r5 = C1219.m3271(appWrapper.packageName);
            boolean z = r5 != null && r5.f3017;
            int r1 = C0471.m1011(appWrapper.packageName);
            boolean contains = this.f426.contains(appWrapper.packageName);
            if (z || ((r1 > 0 && this.f427) || contains)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            String string = z ? AppSetupListActivity.this.getString(R$string.app_has_modify) : BidiFormatter.EMPTY_STRING;
            if (r1 > 0 && this.f427) {
                if (string.length() > 0) {
                    string = outline.m2556(string, ", ");
                }
                StringBuilder r52 = outline.m2549(string);
                r52.append(AppSetupListActivity.this.getString(R$string.app_skip_count, new Object[]{String.valueOf(r1)}));
                string = r52.toString();
            }
            if (contains) {
                if (string.length() > 0) {
                    string = outline.m2556(string, "\n");
                }
                StringBuilder r53 = outline.m2549(string);
                r53.append(AppSetupListActivity.this.getString(R$string.super_engine_app));
                string = r53.toString();
            }
            textView.setText(string);
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo7600(AppWrapper appWrapper, View view) {
            AppSetupListActivity appSetupListActivity = AppSetupListActivity.this;
            appSetupListActivity.f420 = true;
            Intent intent = new Intent(appSetupListActivity, AppSetupActivity.class);
            intent.putExtra("EXTRA_PKG", appWrapper.packageName);
            AppSetupListActivity.this.startActivity(intent);
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m366(boolean z, AppWrapper appWrapper) {
        if (appWrapper != null) {
            C0471.m1017(appWrapper.packageName, !z);
            C1219.m3274(appWrapper.packageName, !z);
        }
    }

    public void onBackPressed() {
        if (this.f425) {
            mo7593();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R$layout.activity_choose_app);
        this.f421 = new C1114(this);
        this.f419 = (ChoiceAppListView) findViewById(R$id.list_app);
        ChoiceAppListView choiceAppListView = this.f419;
        this.f424 = View.inflate(this, R$layout.view_setup_header, (ViewGroup) null);
        this.f422 = (SwitchButton) this.f424.findViewById(R$id.sw_skip_anim);
        this.f422.setChecked(!SpHandler.f1751.mo8104().booleanValue());
        this.f422.setOnCheckedChangeListener(new C1167(this));
        this.f424.findViewById(R$id.layout_skip_anim_switch).setOnClickListener(new C1031(this));
        ViewGroup viewGroup = (ViewGroup) this.f424.findViewById(R$id.item_skip_anim);
        FullVersionTag.m1615(viewGroup);
        viewGroup.setOnClickListener(new C0467(this));
        ItemView itemView = (ItemView) this.f424.findViewById(R$id.item_backup_config);
        itemView.setOnClickListener(new C0984(this));
        FullVersionTag.m1615(itemView);
        this.f424.findViewById(R$id.tv_reset_all).setOnClickListener(new C0902(this));
        ItemView itemView2 = (ItemView) this.f424.findViewById(R$id.item_exclude_from_recents);
        if (Utils.m1905() instanceof Oppo) {
            itemView2.setDes(2131493107);
            if (SpHandler.f1754.mo8104().booleanValue()) {
                SpHandler.f1754.mo8105(false);
            }
        } else {
            itemView2.setDes(2131493106);
        }
        itemView2.setChecked(SpHandler.f1754.mo8104().booleanValue());
        itemView2.setOnCheckedChangeListener(new C0758(this));
        this.f423 = (ItemView) this.f424.findViewById(R$id.item_engine);
        mo7598();
        this.f423.setOnClickListener(new C1244(this));
        this.f424.findViewById(R$id.item_more).setOnClickListener(new C0492(this));
        choiceAppListView.addHeaderView(this.f424);
        this.f419.setAdapter(new C0437(this));
        this.f419.mo7474(C1219.m3281(), false);
        this.f419.setExcludePackages(Collections.singletonList(getPackageName()));
        this.f419.setOnAppMarkedChangedListener(C1263.f3563);
        this.f419.mo7475();
        mo7434().setLayoutTransition(new LayoutTransition());
        if (!SpHandler.f1751.mo8104().booleanValue() || SpHandler.f1753.mo8104().booleanValue()) {
            AppUtils.m1146((Runnable) new C0511(this));
        }
        mo7572(getIntent());
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131165220) {
            return false;
        }
        this.f425 = true;
        View inflate = View.inflate(this, R$layout.toolbar_input_text, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R$id.et_input);
        editText.setHint(R$string.app_search_hint);
        inflate.findViewById(R$id.tv_cancel).setOnClickListener(new C1207(this));
        editText.addTextChangedListener(new com.wpengapp.support.AppSetupListActivity(this, new C0789(this, editText)));
        setToolBarCustomView(inflate);
        this.f419.removeHeaderView(this.f424);
        editText.post(new C1272(editText));
        return false;
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mo7572(intent);
    }

    public void onStart() {
        super.onStart();
        if (this.f420) {
            this.f420 = false;
            this.f419.mo7474(C1219.m3281(), false);
        }
    }

    /* renamed from: ؠ */
    public /* synthetic */ void mo7579(View view) {
        this.f422.toggle();
    }

    /* renamed from: ހ */
    public /* synthetic */ void mo7582(Dialog dialog, View view) {
        dialog.dismiss();
        mo7588(0);
    }

    /* renamed from: ށ */
    public /* synthetic */ void mo7584(int i) {
        mo7431(2131493243);
        int r0 = SystemApi.m2051(AppUtils.getApplication());
        if (r0 == 4) {
            mo7430();
            C0826.m2179(R$string.xposed_system_app_not_install, SystemApi.m2052());
        } else if (r0 != 0) {
            mo7430();
            XPosedPluginActivity.m568(this, r0);
        } else {
            C0919.m2421(i, 2);
            runOnUiThread(new C1270(this, i));
        }
    }

    /* renamed from: ނ */
    public /* synthetic */ void mo7587(View view) {
        View inflate = View.inflate(this, R$layout.dialog_switch_engine, (ViewGroup) null);
        ((TextView) inflate.findViewById(R$id.super_tips)).setText(Html.fromHtml(getString(R$string.app_engine_super_tips)));
        C0915 r0 = new C0915(this);
        r0.mo8897(0.95f);
        r0.f2463 = inflate;
        AlertDialog r02 = r0.mo8910();
        RadioButton radioButton = (RadioButton) inflate.findViewById(R$id.rb_normal);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R$id.rb_super);
        RadioButton radioButton3 = (RadioButton) inflate.findViewById(R$id.rb_xposed);
        int r4 = C0919.m2420();
        if (r4 == 1) {
            radioButton2.setChecked(true);
            radioButton2.setTextColor(ContextCompat.getColor(this, R$color.app_color_primary_dark));
        } else if (r4 != 2) {
            radioButton.setChecked(true);
            radioButton.setTextColor(ContextCompat.getColor(this, R$color.app_color_primary_dark));
        } else {
            radioButton3.setChecked(true);
            radioButton3.setTextColor(ContextCompat.getColor(this, R$color.app_color_primary_dark));
        }
        radioButton.setClickable(false);
        radioButton2.setClickable(false);
        radioButton3.setClickable(false);
        inflate.findViewById(2131165383).setOnClickListener(new C0727(this, r02));
        inflate.findViewById(R$id.layout_super).setOnClickListener(new C0801(this, r02));
        inflate.findViewById(R$id.layout_xposed).setOnClickListener(new C0730(this, r02));
    }

    /* renamed from: ރ */
    public /* synthetic */ void mo7589(View view) {
        mo7420((Class<?>) MoreSettingsActivity.class);
    }

    /* renamed from: ބ */
    public int mo7437() {
        return R$menu.activity_app_setup_list;
    }

    /* renamed from: ކ */
    public /* synthetic */ boolean mo7590(View view) {
        C1219.m3287();
        this.f419.mo7474(C1219.m3281(), false);
        C0826.m2179(R$string.app_reset_success, new Object[0]);
        return false;
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return getString(2131493192);
    }

    /* renamed from: ވ */
    public final void mo7592(View view) {
        View inflate = View.inflate(this, R$layout.dialog_backup_config, (ViewGroup) null);
        int r1 = C0826.m2168(120.0f);
        C0915 r2 = new C0915(this);
        r2.f2463 = inflate;
        r2.f2481 = r1;
        PopupDialog r22 = r2.mo8908();
        r22.showAsDropDown(view, (view.getWidth() - r1) - C0826.m2168(4.0f), ((-view.getHeight()) / 2) - C0826.m2168(16.0f));
        inflate.findViewById(R$id.tv_backup).setOnClickListener(new C0866(this, r22));
        inflate.findViewById(R$id.tv_restore).setOnClickListener(new C1302(this, r22));
    }

    /* renamed from: ގ */
    public final void mo7593() {
        this.f425 = false;
        setToolBarCustomView((View) null);
        this.f419.mo7472((String) null);
        C0826.m2173((Activity) this);
        this.f419.addHeaderView(this.f424);
    }

    /* renamed from: ޏ */
    public /* synthetic */ void mo7594() {
        this.f421.mo9299(false, false, false, (QueryCallback) new C1203(this));
    }

    /* renamed from: ސ */
    public /* synthetic */ void mo7595() {
        mo7430();
        C0915 r0 = new C0915(this);
        r0.f2481 = -2;
        r0.mo8899((int) R$string.app_engine_reboot, 17);
        r0.f2469 = false;
        r0.mo8910();
    }

    /* renamed from: ޑ */
    public /* synthetic */ void mo7596() {
        C0826.m2173((Activity) this);
    }

    /* renamed from: ޒ */
    public /* synthetic */ void mo7597() {
        this.f423.performClick();
    }

    /* renamed from: ޓ */
    public final void mo7598() {
        int r0 = C0919.m2420();
        if (r0 == 1) {
            this.f423.setDes((int) R$string.app_engine_super);
        } else if (r0 != 2) {
            this.f423.setDes((int) R$string.app_engine_normal);
        } else {
            this.f423.setDes((int) R$string.app_engine_xposed);
        }
    }

    /* renamed from: ؠ */
    public /* synthetic */ boolean mo7581(CompoundButton compoundButton, boolean z) {
        if (!z || !(Utils.m1905() instanceof Oppo)) {
            SpHandler.f1754.mo8105(Boolean.valueOf(z));
            LauncherActivity.f635 = z;
            int i = Build.VERSION.SDK_INT;
            if (!AppUtils.m1148(z, Integer.valueOf(getTaskId()))) {
                C0915 r4 = new C0915(this);
                r4.mo8905(com.wpengapp.support.R$string.pw_show_in_recents_tip);
                r4.mo8898(com.wpengapp.support.R$string.pw_cancel);
                r4.f2470 = false;
                r4.mo8906(com.wpengapp.support.R$string.pw_restart, (OnDialogClickListener) new C1122());
                r4.mo8896().show();
            }
            return false;
        }
        C0826.m2172(2131493107, new Object[0]);
        return true;
    }

    /* renamed from: ރ */
    public final void mo7588(int i) {
        int r0 = C0919.m2420();
        if (r0 == i) {
            mo7598();
        } else if (i == 2) {
            TaskManager.m2715((Runnable) new C0825(this, r0));
        } else {
            if (C0919.m2419(r0, i)) {
                C0915 r1 = new C0915(this);
                r1.f2481 = -2;
                r1.mo8899((int) R$string.app_engine_reboot, 17);
                r1.f2469 = false;
                r1.mo8910();
            } else {
                C0826.m2179(R$string.app_engine_switched, new Object[0]);
            }
            C0919.m2421(r0, i);
            mo7598();
        }
    }

    /* renamed from: އ */
    public /* synthetic */ void mo7591(View view) {
        mo7593();
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7573(CompoundButton compoundButton, boolean z) {
        SpHandler.f1751.mo8105(Boolean.valueOf(!z));
        if (z) {
            AppUtils.m1146((Runnable) new C0511(this));
        }
    }

    /* renamed from: ހ */
    public /* synthetic */ void mo7583(View view) {
        View inflate = View.inflate(this, R$layout.dialog_input, (ViewGroup) null);
        ClearEditText clearEditText = (ClearEditText) inflate.findViewById(R$id.edit_text);
        String r1 = SpHandler.f1752.mo8104();
        if (TextUtils.isEmpty(r1)) {
            r1 = getString(R$string.skip_anim_text);
        }
        clearEditText.setText(r1);
        C0915 r12 = new C0915(this);
        r12.mo8909(R$string.modify_skip_anim);
        r12.mo8897(0.6f);
        r12.f2463 = inflate;
        r12.mo8898(2131493077);
        r12.mo8906(2131493133, (OnDialogClickListener) new C0581(this, clearEditText));
        r12.mo8910().setOnDismissListener(new C1248(this));
        clearEditText.postDelayed(new C0603(clearEditText), 100);
    }

    /* renamed from: ֏ */
    public final void mo7572(Intent intent) {
        if (intent != null && intent.getBooleanExtra("GUIDE_ENGINE", false)) {
            AppUtils.m1147((Runnable) new C0886(this), 600);
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7570(Dialog dialog, View view) {
        dialog.dismiss();
        if (Build.VERSION.SDK_INT < 24) {
            C0826.m2172((int) R$string.app_engine_super_7, new Object[0]);
        } else {
            mo7588(1);
        }
    }

    /* renamed from: ށ */
    public /* synthetic */ void mo7585(View view) {
        C0915 r3 = new C0915(this);
        r3.mo8899((int) R$string.app_reset_all_confirm, 17);
        r3.mo8898(2131493077);
        r3.mo8906(2131493133, (OnDialogClickListener) new C0815(this));
        r3.mo8910();
    }

    /* renamed from: ֏ */
    public /* synthetic */ boolean mo7577(ClearEditText clearEditText, View view) {
        String r4 = C0826.m2170((EditText) clearEditText);
        UserInfo r5 = C0536.m1309();
        if (r5 == null || !C0536.m1313(r5)) {
            C0915 r42 = new C0915(this);
            r42.mo8909(R$string.limit_skip_anim2);
            r42.mo8902((CharSequence) getString(2131493346, new Object[]{SystemUtils.m3519(getPackageName())}), 19);
            r42.mo8898(2131493347);
            r42.mo8906(2131493370, (OnDialogClickListener) C0512.f928);
            r42.mo8910();
        } else {
            if (TextUtils.isEmpty(r4.trim())) {
                r4 = getString(R$string.skip_anim_text);
            }
            SpHandler.f1752.mo8105(r4);
        }
        return false;
    }

    /* renamed from: ؠ */
    public /* synthetic */ void mo7578(Dialog dialog, View view) {
        dialog.dismiss();
        mo7588(2);
    }

    /* renamed from: ؠ */
    public static /* synthetic */ void m367(EditText editText) {
        editText.requestFocus();
        C0826.m2174((View) editText);
    }

    /* renamed from: ؠ */
    public /* synthetic */ void mo7580(PopupDialog r1, View view) {
        r1.dismiss();
        BackupRestoreDialog.m1075(this, true);
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7571(DialogInterface dialogInterface) {
        AppUtils.m1147((Runnable) new C0518(this), 200);
    }

    /* renamed from: ނ */
    public /* synthetic */ void mo7586(int i) {
        if (!isFinishing()) {
            mo7598();
            if (C0919.m2419(i, 2)) {
                AppUtils.m1147((Runnable) new C0888(this), (long) ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
                return;
            }
            mo7430();
            mo7420((Class<?>) XPosedSuccessActivity.class);
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7576(C1114 r2, boolean z, boolean z2, int i) {
        String str;
        if (!z2 && this.f422.isChecked()) {
            if (this.f422.isChecked()) {
                this.f422.setChecked(false);
                str = getString(R$string.limit_skip_anim);
            } else {
                str = BidiFormatter.EMPTY_STRING;
            }
            C0915 r4 = new C0915(this);
            r4.f2464 = str;
            r4.mo8902((CharSequence) getString(2131493346, new Object[]{SystemUtils.m3519(getPackageName())}), 19);
            r4.mo8898(2131493347);
            r4.mo8906(2131493370, (OnDialogClickListener) C0493.f874);
            r4.mo8910();
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7574(EditText editText) {
        this.f419.mo7472(editText.getText().toString());
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7575(PopupDialog r1, View view) {
        r1.dismiss();
        BackupActivity.m845(this, true);
    }
}
