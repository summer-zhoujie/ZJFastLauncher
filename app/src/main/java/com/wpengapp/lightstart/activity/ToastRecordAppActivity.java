package com.wpengapp.lightstart.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$menu;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.adaptor.ToastRecordAppAdaptor;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0488;
import com.wpengapp.support.C0517;
import com.wpengapp.support.C0811;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0976;
import com.wpengapp.support.C1063;
import com.wpengapp.support.C1105;
import com.wpengapp.support.C1247;
import com.wpengapp.support.C1262;
import com.wpengapp.support.C1279;
import com.wpengapp.support.C1301;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.PopupDialog;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.SpacesItemDecoration;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.ToastRecord;
import com.wpengapp.support.Utils;
import com.wpengapp.support.activity.WPengBaseActivity;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ToastRecordAppActivity extends WPengBaseActivity {
    public RecyclerView mList;

    /* renamed from: ֏ */
    public View f469;

    /* renamed from: ؠ */
    public ToastRecordAppAdaptor f470;

    /* renamed from: ހ */
    public AtomicInteger f471 = new AtomicInteger(-1);

    /* renamed from: ށ */
    public boolean f472;

    /* renamed from: ނ */
    public int f473 = 10;

    /* renamed from: ރ */
    public String f474;

    /* renamed from: ބ */
    public HashSet<Long> f475 = new HashSet<>();

    public void onCreate(@Nullable Bundle bundle) {
        this.f474 = getIntent().getStringExtra("app");
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.f474)) {
            finish();
            return;
        }
        setContentView(2131296298);
        mo7434().setBackgroundColor(-1);
        findViewById(2131165487).setVisibility(4);
        this.f473 = Utils.m1857(C1063.m2859("skad_toast_len", (String) null), this.f473);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        linearLayoutManager.setOrientation(1);
        this.mList.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView = this.mList;
        recyclerView.setPadding(recyclerView.getPaddingLeft(), C0826.m2168(16.0f), this.mList.getPaddingRight(), this.mList.getPaddingBottom());
        this.mList.addItemDecoration(new SpacesItemDecoration(C0826.m2168(10.0f)));
        this.f470 = new ToastRecordAppAdaptor(this);
        this.f470.mo9173(new View(this));
        this.f469 = this.f470.mo9171(2131296310, this.mList);
        this.mList.setAdapter(this.f470);
        this.mList.getItemAnimator().setAddDuration(0);
        this.mList.getItemAnimator().setChangeDuration(0);
        this.mList.getItemAnimator().setMoveDuration(0);
        ((SimpleItemAnimator) this.mList.getItemAnimator()).setSupportsChangeAnimations(false);
        this.mList.addOnScrollListener(new ToastRecordAppActivity(this));
        mo7694();
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131165204) {
            return false;
        }
        C0915 r3 = new C0915(this);
        r3.mo8905(R$string.record_clear_tips);
        r3.mo8898(2131493077);
        r3.mo8906(2131493133, (OnDialogClickListener) new C0976(this));
        r3.mo8910();
        return false;
    }

    /* renamed from: ؠ */
    public /* synthetic */ boolean mo7691(View view) {
        C0488.m1092(this.f474);
        Intent intent = new Intent();
        intent.putExtra("app", this.f474);
        setResult(100, intent);
        finish();
        return false;
    }

    /* renamed from: ބ */
    public int mo7437() {
        return R$menu.activity_toast_record_app;
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, 2131099746);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        String r0 = SystemUtils.m3519(this.f474);
        return TextUtils.isEmpty(r0) ? this.f474 : r0;
    }

    /* renamed from: ގ */
    public /* synthetic */ void mo7692() {
        int incrementAndGet = this.f471.incrementAndGet();
        "load page " + incrementAndGet;
        List<ToastRecord> r0 = C1279.m3402(incrementAndGet, 50, SpHandler.f1762.mo8104().booleanValue() ? this.f473 : 0, this.f474);
        if (CollectionUtils.m1657((Collection) r0) || r0.size() < 50) {
            this.f472 = true;
        }
        if (!CollectionUtils.m1657((Collection) r0)) {
            runOnUiThread(new C0811(this, r0));
        }
        if (this.f472) {
            runOnUiThread(new C1262(this));
        } else {
            AppUtils.m1147((Runnable) new C1301(this), 500);
        }
    }

    /* renamed from: ޏ */
    public /* synthetic */ void mo7693() {
        if (!this.mList.canScrollVertically(1)) {
            mo7694();
        }
    }

    /* renamed from: ސ */
    public final void mo7694() {
        if (!this.f472) {
            TaskManager.m2720(new C1105(this));
        }
    }

    /* renamed from: ޑ */
    public final void mo7695() {
        this.f469.findViewById(2131165409).setVisibility(8);
        TextView textView = (TextView) this.f469.findViewById(2131165552);
        textView.setText(R$string.load_finish);
        textView.setVisibility(0);
    }

    /* renamed from: ֏ */
    public void mo7688(View view, ToastRecord r7, int i) {
        View inflate = View.inflate(this, R$layout.dialog_toast_record, (ViewGroup) null);
        int r1 = C0826.m2168(120.0f);
        C0915 r2 = new C0915(this);
        r2.f2463 = inflate;
        r2.f2481 = r1;
        PopupDialog r22 = r2.mo8908();
        r22.showAsDropDown(view, (view.getWidth() - r1) - C0826.m2168(4.0f), ((-view.getHeight()) / 2) - C0826.m2168(16.0f));
        inflate.findViewById(R$id.tv_delete).setOnClickListener(new C1247(this, r22, r7, i));
        inflate.findViewById(R$id.tv_copy).setOnClickListener(new C0517(r22, r7));
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7689(PopupDialog r1, ToastRecord r2, int i, View view) {
        Long l;
        r1.dismiss();
        this.f470.mo9172(i, 1);
        this.f470.notifyDataSetChanged();
        if (r2 != null && (l = r2.f1636) != null) {
            this.f475.add(l);
            Intent intent = new Intent();
            intent.putExtra("app", this.f474);
            intent.putExtra("ids", this.f475);
            setResult(100, intent);
            C0488.m1088(r2.f1636);
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m556(PopupDialog r0, ToastRecord r1, View view) {
        r0.dismiss();
        SystemUtils.m3513((CharSequence) r1.f1638);
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7690(List list) {
        this.f470.mo9177(list);
    }
}
