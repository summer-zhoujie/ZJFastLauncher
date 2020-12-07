package com.wpengapp.lightstart.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$menu;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.adaptor.ToastRecordAdaptor;
import com.wpengapp.support.AppToastRecord;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.BaseApplication;
import com.wpengapp.support.C0488;
import com.wpengapp.support.C0521;
import com.wpengapp.support.C0593;
import com.wpengapp.support.C0605;
import com.wpengapp.support.C0735;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0851;
import com.wpengapp.support.C0884;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0924;
import com.wpengapp.support.C0930;
import com.wpengapp.support.C1007;
import com.wpengapp.support.C1063;
import com.wpengapp.support.C1114;
import com.wpengapp.support.C1175;
import com.wpengapp.support.C1194;
import com.wpengapp.support.C1213;
import com.wpengapp.support.C1265;
import com.wpengapp.support.C1269;
import com.wpengapp.support.C1279;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.PopupDialog;
import com.wpengapp.support.QueryCallback;
import com.wpengapp.support.SP;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.ToastRecord;
import com.wpengapp.support.Utils;
import com.wpengapp.support.activity.WPengBaseActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ToastRecordActivity extends WPengBaseActivity {
    public RecyclerView mList;

    /* renamed from: ֏ */
    public View f462;

    /* renamed from: ؠ */
    public ItemView f463;

    /* renamed from: ހ */
    public ToastRecordAdaptor f464;

    /* renamed from: ށ */
    public AtomicInteger f465 = new AtomicInteger(-1);

    /* renamed from: ނ */
    public boolean f466;

    /* renamed from: ރ */
    public int f467 = 10;

    /* renamed from: ބ */
    public C1114 f468;

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 100 && intent != null) {
            String stringExtra = intent.getStringExtra("app");
            if (!TextUtils.isEmpty(stringExtra)) {
                HashSet hashSet = (HashSet) intent.getSerializableExtra("ids");
                ArrayList<ToastRecord> arrayList = new ArrayList<>(this.f464.f2806);
                if (!CollectionUtils.m1657((Collection) arrayList)) {
                    boolean z = false;
                    if (!CollectionUtils.m1659((Collection) hashSet)) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (stringExtra.equals(((ToastRecord) it.next()).f1637)) {
                                it.remove();
                                z = true;
                            }
                        }
                    } else if (SpHandler.f1761.mo8104().booleanValue()) {
                        List<AppToastRecord> r8 = C1279.m3426(SpHandler.f1762.mo8104().booleanValue() ? this.f467 : 0, stringExtra);
                        if (CollectionUtils.m1657((Collection) r8)) {
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                if (stringExtra.equals(((ToastRecord) it2.next()).f1637)) {
                                    it2.remove();
                                    z = true;
                                }
                            }
                        } else {
                            boolean z2 = false;
                            for (ToastRecord r4 : arrayList) {
                                if (stringExtra.equals(r4.f1637)) {
                                    r4.f1638 = r8.get(0).f1638;
                                    r4.f1639 = r8.get(0).f1639;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        }
                    } else {
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            if (hashSet.contains(((ToastRecord) it3.next()).f1636)) {
                                it3.remove();
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        this.f464.mo9058(arrayList);
                    }
                }
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131296298);
        mo7434().setBackgroundColor(-570425345);
        findViewById(2131165487).setVisibility(4);
        this.f468 = new C1114(this);
        this.f467 = Utils.m1857(C1063.m2859("skad_toast_len", (String) null), this.f467);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        linearLayoutManager.setOrientation(1);
        this.mList.setLayoutManager(linearLayoutManager);
        this.f464 = new ToastRecordAdaptor(this);
        this.mList.setAdapter(this.f464);
        View r5 = this.f464.mo9176(R$layout.view_toast_record_header, this.mList);
        this.f462 = this.f464.mo9171(2131296310, this.mList);
        this.mList.getItemAnimator().setAddDuration(0);
        this.mList.getItemAnimator().setChangeDuration(0);
        this.mList.getItemAnimator().setMoveDuration(0);
        this.mList.getItemAnimator().setRemoveDuration(0);
        ((SimpleItemAnimator) this.mList.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f463 = (ItemView) r5.findViewById(R$id.item_enable);
        this.f463.setChecked(SpHandler.f1760.mo8104().booleanValue());
        this.f463.setOnCheckedChangeListener(new C1265(this));
        this.mList.addOnScrollListener(new ToastRecordActivity(this));
        mo7687();
        if (BaseApplication.f562) {
            r5.setOnClickListener(new C0593(this));
        }
        if (SpHandler.f1760.mo8104().booleanValue()) {
            AppUtils.m1146((Runnable) new C0884(this));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f277 != 0) {
            getMenuInflater().inflate(this.f277, menu);
        }
        int i = Build.VERSION.SDK_INT;
        menu.findItem(R$id.action_switch).setChecked(SpHandler.f1761.mo8104().booleanValue());
        menu.findItem(R$id.action_filter_short).setChecked(SpHandler.f1762.mo8104().booleanValue());
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131165222) {
            SP<Boolean> r0 = SpHandler.f1761;
            r0.mo8105(Boolean.valueOf(true ^ r0.mo8104().booleanValue()));
            menuItem.setChecked(SpHandler.f1761.mo8104().booleanValue());
            mo7687();
        } else if (itemId == 2131165210) {
            SP<Boolean> r02 = SpHandler.f1762;
            r02.mo8105(Boolean.valueOf(!r02.mo8104().booleanValue()));
            menuItem.setChecked(SpHandler.f1762.mo8104().booleanValue());
            if (SpHandler.f1762.mo8104().booleanValue()) {
                C0826.m2179(R$string.toast_record_filter_short_tips, Integer.valueOf(this.f467));
            }
            mo7687();
        } else if (itemId == 2131165204) {
            C0915 r5 = new C0915(this);
            r5.mo8905(R$string.record_clear_tips);
            r5.mo8898(2131493077);
            r5.mo8906(2131493133, (OnDialogClickListener) new C0605(this));
            r5.mo8910();
        }
        return false;
    }

    /* renamed from: ؠ */
    public /* synthetic */ boolean mo7680(View view) {
        C0488.m1089((Long) null, (String) null);
        mo7686();
        this.f464.mo9058(new ArrayList());
        return false;
    }

    /* renamed from: ބ */
    public int mo7437() {
        return R$menu.activity_toast_record;
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, 2131099746);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return null;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ގ */
    public /* synthetic */ void mo7681() {
        this.f468.mo9299(false, false, false, (QueryCallback) new C0735(this));
    }

    /* renamed from: ޏ */
    public /* synthetic */ void mo7682() {
        runOnUiThread(new C1175(this, C1279.m3426(SpHandler.f1762.mo8104().booleanValue() ? this.f467 : 0, (String) null)));
    }

    /* renamed from: ސ */
    public /* synthetic */ void mo7683() {
        int incrementAndGet = this.f465.incrementAndGet();
        "load page " + incrementAndGet;
        List<ToastRecord> r0 = C1279.m3402(incrementAndGet, 50, SpHandler.f1762.mo8104().booleanValue() ? this.f467 : 0, (String) null);
        if (CollectionUtils.m1657((Collection) r0) || r0.size() < 50) {
            this.f466 = true;
        }
        if (!CollectionUtils.m1657((Collection) r0)) {
            runOnUiThread(new C0851(this, r0));
        }
        if (this.f466) {
            runOnUiThread(new C0521(this));
        } else {
            AppUtils.m1147((Runnable) new C0924(this), 500);
        }
    }

    /* renamed from: ޑ */
    public /* synthetic */ void mo7684() {
        if (!this.mList.canScrollVertically(1)) {
            mo7685();
        }
    }

    /* renamed from: ޒ */
    public final void mo7685() {
        if (!this.f466) {
            TaskManager.m2720(new C1269(this));
        }
    }

    /* renamed from: ޓ */
    public final void mo7686() {
        this.f462.findViewById(2131165409).setVisibility(8);
        TextView textView = (TextView) this.f462.findViewById(2131165552);
        textView.setText(R$string.load_finish);
        textView.setVisibility(0);
    }

    /* renamed from: ޔ */
    public final void mo7687() {
        this.f462.findViewById(2131165409).setVisibility(0);
        ((TextView) this.f462.findViewById(2131165552)).setVisibility(8);
        this.f464.mo9058(new ArrayList());
        if (SpHandler.f1761.mo8104().booleanValue()) {
            TaskManager.m2715((Runnable) new C1213(this));
            return;
        }
        this.f466 = false;
        this.f465.set(-1);
        mo7685();
    }

    /* renamed from: ֏ */
    public /* synthetic */ boolean mo7678(CompoundButton compoundButton, boolean z) {
        SpHandler.f1760.mo8105(Boolean.valueOf(z));
        AppUtils.m1146((Runnable) new C0884(this));
        return false;
    }

    /* renamed from: ֏ */
    public void mo7674(ToastRecord r3) {
        Intent intent = new Intent(this, ToastRecordAppActivity.class);
        intent.putExtra("app", r3.f1637);
        startActivityForResult(intent, 0);
    }

    /* renamed from: ؠ */
    public /* synthetic */ void mo7679(List list) {
        this.f464.mo9177(list);
    }

    /* renamed from: ֏ */
    public void mo7673(View view, ToastRecord r7, int i) {
        View inflate = View.inflate(this, R$layout.dialog_toast_record, (ViewGroup) null);
        int r1 = C0826.m2168(120.0f);
        C0915 r2 = new C0915(this);
        r2.f2463 = inflate;
        r2.f2481 = r1;
        PopupDialog r22 = r2.mo8908();
        r22.showAsDropDown(view, (view.getWidth() - r1) - C0826.m2168(4.0f), ((-view.getHeight()) / 2) - C0826.m2168(16.0f));
        inflate.findViewById(R$id.tv_delete).setOnClickListener(new C1007(this, r22, r7, i));
        inflate.findViewById(R$id.tv_copy).setOnClickListener(new C0930(r22, r7));
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7675(PopupDialog r1, ToastRecord r2, int i, View view) {
        r1.dismiss();
        this.f464.mo9172(i, 1);
        this.f464.notifyDataSetChanged();
        if (r2 != null) {
            if (r2 instanceof AppToastRecord) {
                C0488.m1092(r2.f1637);
            } else {
                C0488.m1088(r2.f1636);
            }
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m534(PopupDialog r0, ToastRecord r1, View view) {
        r0.dismiss();
        SystemUtils.m3513((CharSequence) r1.f1638);
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7676(C1114 r2, boolean z, boolean z2, int i) {
        if (!z2 && SpHandler.f1760.mo8104().booleanValue()) {
            SpHandler.f1760.mo8105(false);
            this.f463.mo7504(false, false);
            String string = getString(2131493337);
            C0915 r4 = new C0915(this);
            r4.f2464 = string;
            r4.mo8902((CharSequence) getString(2131493346, new Object[]{SystemUtils.m3519(getPackageName())}), 19);
            r4.mo8898(2131493347);
            r4.mo8906(2131493370, (OnDialogClickListener) C1194.f3407);
            r4.mo8910();
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7677(List list) {
        this.f464.mo9058(list);
        mo7686();
    }
}
