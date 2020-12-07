package com.wpengapp.lightstart.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.wpengapp.lightstart.R$menu;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.adaptor.NotifyRecordAdaptor;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0466;
import com.wpengapp.support.C0488;
import com.wpengapp.support.C0571;
import com.wpengapp.support.C0624;
import com.wpengapp.support.C0975;
import com.wpengapp.support.C1240;
import com.wpengapp.support.C1271;
import com.wpengapp.support.C1279;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.DBHelper;
import com.wpengapp.support.NotifyRecord;
import com.wpengapp.support.SwipeDeleteHelper;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.activity.WPengBaseActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class NotifyRecordBaseActivity extends WPengBaseActivity {
    public RecyclerView mList;

    /* renamed from: ֏ */
    public View f455;

    /* renamed from: ؠ */
    public NotifyRecordAdaptor f456;

    /* renamed from: ހ */
    public AtomicInteger f457 = new AtomicInteger(-1);

    /* renamed from: ށ */
    public boolean f458;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131296298);
        mo7434().setBackgroundColor(-570425345);
        findViewById(2131165487).setVisibility(4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        linearLayoutManager.setOrientation(1);
        this.mList.setLayoutManager(linearLayoutManager);
        this.f456 = new NotifyRecordAdaptor(this);
        this.mList.setAdapter(this.f456);
        this.f456.mo9173(mo7653());
        this.f455 = this.f456.mo9171(2131296310, this.mList);
        new SwipeDeleteHelper(new C1271(this)).attachToRecyclerView(this.mList);
        this.mList.addOnScrollListener(new NotifyRecordBaseActivity(this));
        this.f455.findViewById(2131165409).setVisibility(0);
        ((TextView) this.f455.findViewById(2131165552)).setVisibility(8);
        this.f456.mo9058(new ArrayList());
        this.f458 = false;
        this.f457.set(-1);
        mo7663();
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131165204) {
            return false;
        }
        mo7651();
        return false;
    }

    /* renamed from: ؠ */
    public void mo7660(NotifyRecord r3) {
        Intent intent = new Intent(this, NotifyRecordAppActivity.class);
        intent.putExtra("app", r3.f3460);
        startActivityForResult(intent, 0);
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
        return null;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ގ */
    public abstract void mo7651();

    /* renamed from: ޏ */
    public abstract String mo7652();

    /* renamed from: ސ */
    public abstract View mo7653();

    /* renamed from: ޑ */
    public /* synthetic */ void mo7661() {
        int incrementAndGet = this.f457.incrementAndGet();
        String r1 = mo7652();
        ArrayList<NotifyRecord> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            String str = (incrementAndGet * 50) + "," + 50;
            ArrayList arrayList2 = new ArrayList();
            if (!TextUtils.isEmpty(r1)) {
                arrayList2.add("a=\"" + r1 + "\"");
            }
            cursor = DBHelper.m1180().query("t_nr", (String[]) null, arrayList2.size() > 0 ? TextUtils.join(" AND ", arrayList2) : null, (String[]) null, (String) null, (String) null, "_id desc", str);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    arrayList.add(C1279.m3393(cursor));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.getMessage();
            C0975.m2602(e);
        } catch (Throwable th) {
            DBHelper.m1179((Cursor) null);
            throw th;
        }
        DBHelper.m1179(cursor);
        if (CollectionUtils.m1657((Collection) arrayList) || arrayList.size() < 50) {
            this.f458 = true;
        }
        if (!CollectionUtils.m1657((Collection) arrayList)) {
            for (NotifyRecord r12 : arrayList) {
                if (!TextUtils.isEmpty(r12.f3461)) {
                    r12.f3461 = C0488.m1080(r12.f3461);
                }
                if (!TextUtils.isEmpty(r12.f3462)) {
                    r12.f3462 = C0488.m1080(r12.f3462);
                }
            }
            runOnUiThread(new C0624(this, arrayList));
        }
        if (this.f458) {
            runOnUiThread(new C0571(this));
        } else {
            AppUtils.m1147((Runnable) new C1240(this), 500);
        }
    }

    /* renamed from: ޒ */
    public /* synthetic */ void mo7662() {
        if (!this.mList.canScrollVertically(1)) {
            mo7663();
        }
    }

    /* renamed from: ޓ */
    public final void mo7663() {
        if (!this.f458) {
            TaskManager.m2720(new C0466(this));
        }
    }

    /* renamed from: ޔ */
    public void mo7664() {
        this.f455.findViewById(2131165409).setVisibility(8);
        TextView textView = (TextView) this.f455.findViewById(2131165552);
        textView.setText(R$string.load_finish);
        textView.setVisibility(0);
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7658(RecyclerView.ViewHolder viewHolder, int i) {
        mo7656((NotifyRecord) this.f456.getItem(i - this.f456.mo9179()));
    }

    /* renamed from: ֏ */
    public void mo7656(NotifyRecord r5) {
        if (r5 != null) {
            C0488.m1084(r5.f3459);
            List<Model> list = this.f456.f2806;
            for (int i = 0; i < list.size(); i++) {
                Long l = ((NotifyRecord) list.get(i)).f3459;
                if (l != null && l.equals(r5.f3459)) {
                    this.f456.mo9172(i, 1);
                }
            }
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7659(List list) {
        if (this.f456.mo9057() == 0) {
            this.f456.mo9058(list);
        } else {
            this.f456.mo9177(list);
        }
    }
}
