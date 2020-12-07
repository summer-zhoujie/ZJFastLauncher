package com.wpengapp.lightstart.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.text.BidiFormatter;
import android.support.p000v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.lightstart.R$drawable;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.config.DefaultConfig;
import com.wpengapp.lightstart.report.SkipRecord;
import com.wpengapp.lightstart.service.AccService;
import com.wpengapp.lightstart.service.AccService24;
import com.wpengapp.support.AccServiceHelper;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.BaseApplication;
import com.wpengapp.support.C0471;
import com.wpengapp.support.C0491;
import com.wpengapp.support.C0494;
import com.wpengapp.support.C0501;
import com.wpengapp.support.C0536;
import com.wpengapp.support.C0582;
import com.wpengapp.support.C0597;
import com.wpengapp.support.C0711;
import com.wpengapp.support.C0729;
import com.wpengapp.support.C0771;
import com.wpengapp.support.C0786;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0883;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0919;
import com.wpengapp.support.C0922;
import com.wpengapp.support.C0993;
import com.wpengapp.support.C1063;
import com.wpengapp.support.C1074;
import com.wpengapp.support.C1110;
import com.wpengapp.support.C1149;
import com.wpengapp.support.C1177;
import com.wpengapp.support.C1205;
import com.wpengapp.support.C1277;
import com.wpengapp.support.C1279;
import com.wpengapp.support.C1307;
import com.wpengapp.support.C1322;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.DevHelper;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.RemoteSP;
import com.wpengapp.support.RetCallback;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.SystemApi;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.UpdateHelper;
import com.wpengapp.support.activity.AboutActivity;
import com.wpengapp.support.activity.CommonWebActivity;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.activity.WechatSubscriptionActivity;
import com.wpengapp.support.model.App;
import com.wpengapp.support.model.GzhConfig;
import com.wpengapp.support.permission.ServicePermissionActivity;
import java.util.Map;

public class MainActivity extends WPengBaseActivity {
    public ItemView mItemAppEnable;
    public ItemView mItemPluginCenter;
    public View mItemSyncError;
    public TextView mTvGzh;
    public TextView mTvSkipCount;

    /* renamed from: ֏ */
    public int f443;

    /* renamed from: ؠ */
    public boolean f444;

    /* renamed from: ހ */
    public C1063.C1065 f445 = new C0501(this);

    /* renamed from: ށ */
    public boolean f446;

    /* renamed from: ނ */
    public BroadcastReceiver f447 = new C1233(this);

    /* renamed from: ރ */
    public BroadcastReceiver f448 = new MainActivity(this);

    /* renamed from: ސ */
    public static boolean m455() {
        boolean booleanValue = SpHandler.f1750.mo8104().booleanValue();
        if (!booleanValue) {
            return booleanValue;
        }
        return AccServiceHelper.m2016(AccService.class, AccService24.class);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131165327) {
            mo7420((Class<?>) AppSetupListActivity.class);
        } else if (id == 2131165323) {
            AboutActivity.m760((Context) this);
        } else if (id == 2131165370) {
            String r2 = C1063.m2859("skad_readme_url", (String) null);
            if (TextUtils.isEmpty(r2)) {
                mo7420((Class<?>) GuideActivity.class);
            } else {
                CommonWebActivity.m783(this, r2, getString(R$string.user_guide));
            }
        } else if (id == 2131165333) {
            mo7420((Class<?>) CustomActivity.class);
        } else if (id == 2131165519) {
            WechatSubscriptionActivity.m839(this, "AppCodeMain");
        } else if (id == 2131165350) {
            this.mItemPluginCenter.setEnterIcon(2131099744);
            mo7420((Class<?>) PluginCenterActivity.class);
        }
    }

    public void onCreate(Bundle bundle) {
        BaseApplication.f561.mo7791("Main.onCreate");
        super.onCreate(bundle);
        BaseApplication.f561.mo7791("Main.onCreate setView1");
        setContentView((int) R$layout.activity_main);
        mo7434().setBackgroundColor(0);
        BaseApplication.f561.mo7791("Main.onCreate setView2");
        this.mItemSyncError.setOnClickListener(new C0729(this));
        this.mItemAppEnable.findViewById(2131165380).setBackground((Drawable) null);
        boolean r4 = m455();
        mo7630(r4);
        this.mItemAppEnable.setChecked(r4);
        this.mItemAppEnable.setOnCheckedChangeListener(new C1074(this));
        if (BaseApplication.f562) {
            findViewById(R$id.layout_logo).setOnClickListener(new C1277(this));
        }
        if (RemoteSP.m1210("forceUpdate", false)) {
            UpdateHelper.m740(false, (long) AnalyticsConstants.f107j, (UpdateHelper.C0447) C0993.f2782);
        } else {
            C1307.m3557((Activity) this, (Runnable) C0883.f2399);
        }
        registerReceiver(this.f447, new IntentFilter(ServicePermissionActivity.f712));
        C1063.C1065 r42 = this.f445;
        C1063.f3038.put(r42, r42);
        C0786.m2103((Context) this, this.f448, new IntentFilter("com.wpengapp.bas.open"));
        AppUtils.m1147((Runnable) C0922.f2491, 5000);
        C1149.m3077((RetCallback<DefaultConfig>) new C1177(this, false));
        mo7642();
        if (C1279.m3421("SHORTCUT")) {
            this.mItemPluginCenter.setEnterIcon(2131099796);
        }
        TaskManager.m2715((Runnable) new C0597(this));
        if (C0536.m1319()) {
            C0536.m1301((Context) this);
        }
        mo7637();
        BaseApplication.f561.mo7791("Main.onCreate END");
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f447);
        C1063.f3038.remove(this.f445);
        C0786.m2102(this, this.f448);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131165211) {
            if (!GzhConfig.getConfig().main) {
                C0826.m2179(2131493081, new Object[0]);
                return false;
            }
            WechatSubscriptionActivity.m839(this, "Main");
        } else if (menuItem.getItemId() == 2131165221) {
            C0771.m2067((Context) this, (C0771.C0772) C0582.f1263);
        }
        return false;
    }

    public void onResume() {
        super.onResume();
        BaseApplication.f561.mo7791("Main.onResume");
    }

    public void onStart() {
        super.onStart();
        this.f443++;
        if (this.f443 == 2 && SpHandler.f1750.mo8104().booleanValue()) {
            C0771.m2072(this);
        }
        mo7641();
        ItemView itemView = (ItemView) findViewById(R$id.item_about);
        App.AppVersion r1 = UpdateHelper.m743();
        if (r1 == null || !r1.needUpdate) {
            C0536.m1323();
            itemView.setEnterIcon(2131099744);
            return;
        }
        itemView.setEnterIcon(2131099796);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.mItemAppEnable.setChecked(m455());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ boolean mo7629(android.widget.CompoundButton r9, boolean r10) {
        /*
            r8 = this;
            r9 = 2131493077(0x7f0c00d5, float:1.8609624E38)
            r0 = 1
            r1 = 0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            if (r10 == 0) goto L_0x004c
            r3 = 2131493115(0x7f0c00fb, float:1.8609701E38)
            java.lang.String r3 = r8.getString(r3)
            r4 = 0
            long r6 = com.wpengapp.support.RemoteSP.m1201((java.lang.String) r3, (long) r4)
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x0020
            r8.f444 = r0
            r3 = 0
            goto L_0x0044
        L_0x0020:
            com.wpengapp.support.ܐ r3 = new com.wpengapp.support.ܐ
            r3.<init>(r8)
            r3.f2469 = r1
            r4 = 2131493288(0x7f0c01a8, float:1.8610052E38)
            r3.mo8909(r4)
            r4 = 2131493289(0x7f0c01a9, float:1.8610054E38)
            r3.mo8905(r4)
            r3.mo8898((int) r9)
            r4 = 2131493290(0x7f0c01aa, float:1.8610056E38)
            com.wpengapp.support.न r5 = com.wpengapp.support.C1024.f2944
            r3.mo8906((int) r4, (com.wpengapp.support.OnDialogClickListener) r5)
            r3.mo8910()
            r8.f444 = r0
            r3 = 1
        L_0x0044:
            if (r3 == 0) goto L_0x004c
            com.wpengapp.support.ɻ<java.lang.Boolean> r9 = com.wpengapp.support.SpHandler.f1750
            r9.mo8105(r2)
            return r0
        L_0x004c:
            if (r10 == 0) goto L_0x0090
            int r3 = com.wpengapp.support.C0919.m2416()
            r4 = 2
            if (r3 != r4) goto L_0x007c
            int r3 = com.wpengapp.support.SystemApi.m2044((android.content.Context) r8)
            if (r3 == 0) goto L_0x007c
            com.wpengapp.support.ܐ r3 = new com.wpengapp.support.ܐ
            r3.<init>(r8)
            r3.f2469 = r1
            r4 = 2131493411(0x7f0c0223, float:1.8610301E38)
            r5 = 17
            r3.mo8899((int) r4, (int) r5)
            r3.mo8898((int) r9)
            r9 = 2131493412(0x7f0c0224, float:1.8610303E38)
            com.wpengapp.support.ཆ r4 = new com.wpengapp.support.ཆ
            r4.<init>(r8)
            r3.mo8906((int) r9, (com.wpengapp.support.OnDialogClickListener) r4)
            r3.mo8910()
            goto L_0x0087
        L_0x007c:
            boolean r9 = com.wpengapp.support.permission.ServicePermissionActivity.m913()
            if (r9 == 0) goto L_0x0084
            r9 = 0
            goto L_0x0088
        L_0x0084:
            com.wpengapp.support.permission.ServicePermissionActivity.m911((android.content.Context) r8)
        L_0x0087:
            r9 = 1
        L_0x0088:
            if (r9 == 0) goto L_0x0090
            com.wpengapp.support.ɻ<java.lang.Boolean> r9 = com.wpengapp.support.SpHandler.f1750
            r9.mo8105(r2)
            return r0
        L_0x0090:
            if (r10 == 0) goto L_0x00b0
            boolean r9 = r8.f444
            if (r9 == 0) goto L_0x00a0
            com.wpengapp.support.ɻ<java.lang.Boolean> r9 = com.wpengapp.support.SpHandler.f1750
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r9.mo8105(r0)
            goto L_0x00b5
        L_0x00a0:
            java.lang.String r9 = com.wpengapp.support.C1279.m3439()
            com.wpengapp.support.SystemUtils.m3527(r9)
            r8.finish()
            com.wpengapp.support.ɻ<java.lang.Boolean> r9 = com.wpengapp.support.SpHandler.f1750
            r9.mo8105(r2)
            return r0
        L_0x00b0:
            com.wpengapp.support.ɻ<java.lang.Boolean> r9 = com.wpengapp.support.SpHandler.f1750
            r9.mo8105(r2)
        L_0x00b5:
            r8.mo7630((boolean) r10)
            if (r10 == 0) goto L_0x00d9
            r9 = 2131493035(0x7f0c00ab, float:1.8609539E38)
            java.lang.Object[] r10 = new java.lang.Object[r1]
            com.wpengapp.support.C0826.m2179(r9, r10)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            int r10 = com.wpengapp.support.C0919.m2416()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r0 = "engine"
            r9.put(r0, r10)
            java.lang.String r10 = "USER_ENABLE"
            com.wpengapp.support.UMengManager.m1406((java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r9)
        L_0x00d9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.lightstart.activity.MainActivity.mo7629(android.widget.CompoundButton, boolean):boolean");
    }

    /* renamed from: ހ */
    public final void mo7630(boolean z) {
        if (z) {
            this.mItemAppEnable.setBackgroundResource(R$drawable.bg_enable_item);
            this.mItemAppEnable.f309.setTextColor(-1);
            this.mItemAppEnable.setTitle((int) R$string.is_enabled);
            return;
        }
        this.mItemAppEnable.setBackgroundResource(R$drawable.bg_normal_item);
        this.mItemAppEnable.f309.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.mItemAppEnable.setTitle((int) R$string.is_disabled);
    }

    /* renamed from: ށ */
    public /* synthetic */ boolean mo7633(View view) {
        this.f446 = false;
        finish();
        BaseApplication.f561.mo7792();
        return false;
    }

    /* renamed from: ނ */
    public /* synthetic */ boolean mo7634(View view) {
        this.f446 = false;
        return false;
    }

    /* renamed from: ރ */
    public /* synthetic */ void mo7635(View view) {
        this.mItemSyncError.setVisibility(8);
        AppUtils.m1147((Runnable) C0922.f2491, 5000);
        C1149.m3077((RetCallback<DefaultConfig>) new C1177(this, true));
    }

    /* renamed from: ބ */
    public int mo7437() {
        return 2131361797;
    }

    /* renamed from: ބ */
    public /* synthetic */ void mo7636(View view) {
        ((DevHelper.C0474) DevHelper.m1039()).mo7969((Context) this);
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return null;
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return BidiFormatter.EMPTY_STRING;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ގ */
    public final void mo7637() {
        if (!this.f446 && C1110.m2991()) {
            this.f446 = true;
            C1110.m2990(this, new C0491(this), new C1322(this));
        }
    }

    /* renamed from: ޏ */
    public final void mo7638() {
        int r0;
        if (C0919.m2416() == 2 && (r0 = SystemApi.m2051(this)) != 0) {
            runOnUiThread(new C0494(this, r0));
        }
    }

    /* renamed from: ޑ */
    public /* synthetic */ void mo7639() {
        AppUtils.m1146((Runnable) new C1205(this));
    }

    /* renamed from: ޕ */
    public final void mo7640() {
        mo7642();
        mo7637();
        mo7641();
    }

    /* renamed from: ޖ */
    public final void mo7641() {
        int i;
        C0471.m1021();
        SkipRecord r0 = C0471.f804.mo9612();
        if (r0 == null || CollectionUtils.m1658((Map) r0.appRecord)) {
            i = 0;
        } else {
            i = 0;
            for (Map.Entry next : r0.appRecord.entrySet()) {
                if (next.getValue() != null) {
                    i += ((Integer) next.getValue()).intValue();
                }
            }
        }
        if (i <= 0 || !C1149.m3079()) {
            this.mTvSkipCount.setText(BidiFormatter.EMPTY_STRING);
            return;
        }
        this.mTvSkipCount.setText(getString(R$string.app_skip_count_2, new Object[]{String.valueOf(i)}));
    }

    /* renamed from: ޗ */
    public final void mo7642() {
        int i = 8;
        if (C0536.m1313(C0536.m1309())) {
            this.mTvGzh.setVisibility(8);
            return;
        }
        TextView textView = this.mTvGzh;
        if (GzhConfig.getConfig().appCode) {
            i = 0;
        }
        textView.setVisibility(i);
        this.mTvGzh.setText(GzhConfig.getConfig().intro);
    }

    /* renamed from: ށ */
    public /* synthetic */ void mo7632(int i) {
        C0915 r0 = new C0915(this);
        r0.f2469 = false;
        r0.mo8899((int) R$string.xposed_plugin_error, 17);
        r0.mo8898(2131493077);
        r0.mo8906((int) R$string.xposed_plugin_error_handle, (OnDialogClickListener) new C0711(this, i));
        r0.mo8910();
    }

    /* renamed from: ހ */
    public /* synthetic */ boolean mo7631(View view) {
        XPosedPluginActivity.m568(this, SystemApi.m2044((Context) this));
        return false;
    }

    /* renamed from: ֏ */
    public /* synthetic */ boolean mo7628(int i, View view) {
        XPosedPluginActivity.m568(this, i);
        return false;
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m453(String str, String str2) {
        AboutActivity.C0450 r0 = AboutActivity.f616;
        if (r0 != null) {
            r0.mo7822();
        }
    }
}
