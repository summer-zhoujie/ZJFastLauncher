package com.wpengapp.lightstart.activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.DividerItemDecoration;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.adaptor.CreateShortcutAdaptor;
import com.wpengapp.lightstart.activity.adaptor.CreateTileAdaptor;
import com.wpengapp.support.AppShortcut;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0543;
import com.wpengapp.support.C0578;
import com.wpengapp.support.C0719;
import com.wpengapp.support.C0774;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0937;
import com.wpengapp.support.C1202;
import com.wpengapp.support.C1323;
import com.wpengapp.support.Image;
import com.wpengapp.support.OnDismissListener;
import com.wpengapp.support.QuickScanConfig;
import com.wpengapp.support.SimpleImageLoadingListener;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.Utils;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.outline;
import java.util.ArrayList;
import java.util.List;

public class QuickScanActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public View f460;

    /* renamed from: ֏ */
    public static /* synthetic */ void m526(CreateTileAdaptor createTileAdaptor) {
        List<Model> list = createTileAdaptor.f2806;
        ArrayList arrayList = new ArrayList();
        for (Model model : list) {
            if (model.f944.booleanValue()) {
                arrayList.add(model.f936);
            }
        }
        T r3 = C0774.m2086();
        r3.f2408 = arrayList;
        C1323<QuickScanConfig> r0 = C0774.f1993;
        r0.f3785 = r3;
        r0.f3791 = true;
        outline.m2551((C1323) r0, (Object) r3);
        TaskManager.m2715((Runnable) C0937.f2544);
    }

    public void onClick(View view) {
        boolean z;
        int id = view.getId();
        if (id != 2131165326) {
            if (id == 2131165343) {
                View inflate = View.inflate(this, R$layout.dialog_create_shortcut, (ViewGroup) null);
                ((TextView) inflate.findViewById(2131165529)).setText(R$string.quick_scan_create_launcher);
                inflate.findViewById(2131165518).setVisibility(8);
                TextView textView = (TextView) inflate.findViewById(2131165552);
                textView.setVisibility(0);
                textView.setText(AppUtils.m1141((int) R$string.quick_if_fail, new Object[0]) + AppUtils.m1141((int) R$string.need_shortcut_permission, new Object[0]));
                RecyclerView recyclerView = (RecyclerView) inflate.findViewById(2131165405);
                recyclerView.addItemDecoration(new DividerItemDecoration(this, 0));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
                linearLayoutManager.setOrientation(1);
                recyclerView.setLayoutManager(linearLayoutManager);
                CreateShortcutAdaptor createShortcutAdaptor = new CreateShortcutAdaptor(this);
                recyclerView.setAdapter(createShortcutAdaptor);
                createShortcutAdaptor.mo9058(C0774.m2088());
                C0915 r0 = new C0915(this);
                r0.f2463 = inflate;
                r0.mo8898(2131493133);
                r0.mo8910();
            } else if (id == 2131165365) {
                if (Build.VERSION.SDK_INT < 24) {
                    C0826.m2172((int) R$string.system_version_tips, "7.0");
                    return;
                }
                String string = getString(R$string.quick_tile_tips);
                if (C0719.m1832()) {
                    StringBuilder r11 = outline.m2549(string);
                    r11.append(getString(R$string.quick_tile_tips_miui));
                    string = r11.toString();
                }
                mo7670(string, "https://wpengapp.com/res/image/wpengapp/lightstart/guide_tile.jpg");
            }
        } else if (Build.VERSION.SDK_INT < 25) {
            C0826.m2172((int) R$string.system_version_tips, "7.1");
        } else {
            View inflate2 = View.inflate(this, R$layout.dialog_create_shortcut, (ViewGroup) null);
            ((TextView) inflate2.findViewById(2131165529)).setText(R$string.quick_scan_create_menu);
            inflate2.findViewById(2131165518).setOnClickListener(new C0543(this));
            RecyclerView recyclerView2 = (RecyclerView) inflate2.findViewById(2131165405);
            recyclerView2.addItemDecoration(new DividerItemDecoration(this, 0));
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, 1, false);
            linearLayoutManager2.setOrientation(1);
            recyclerView2.setLayoutManager(linearLayoutManager2);
            CreateTileAdaptor createTileAdaptor = new CreateTileAdaptor(this, 0);
            recyclerView2.setAdapter(createTileAdaptor);
            List<AppShortcut> r02 = C0774.m2088();
            for (AppShortcut next : r02) {
                String str = next.f936;
                if (C0774.m2086().f2408 == null) {
                    z = false;
                } else {
                    z = C0774.m2086().f2408.contains(str);
                }
                next.f944 = Boolean.valueOf(z);
            }
            createTileAdaptor.mo9058(r02);
            C0915 r03 = new C0915(this);
            r03.f2463 = inflate2;
            r03.mo8898(2131493133);
            r03.mo8901((OnDismissListener) new C1202(createTileAdaptor));
            r03.mo8910();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R$layout.activity_quick_scan);
        mo7434().setBackgroundColor(0);
        findViewById(2131165487).setVisibility(4);
        this.f460 = findViewById(R$id.tv_bg_start_activity);
        this.f460.setOnClickListener(C0578.f1248);
    }

    public void onStart() {
        super.onStart();
        View view = this.f460;
        boolean z = true;
        int i = 0;
        if (C0719.m1832() && Utils.m1856(10021) != 0) {
            z = false;
        }
        if (z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* renamed from: ހ */
    public /* synthetic */ void mo7671(View view) {
        mo7670(getString(R$string.quick_appmenu_tips), "https://wpengapp.com/res/image/wpengapp/lightstart/guide_appmenu.jpg");
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

    /* renamed from: ֏ */
    public final void mo7670(String str, String str2) {
        View inflate = View.inflate(this, R$layout.dialog_guide_appmenu, (ViewGroup) null);
        ((TextView) inflate.findViewById(2131165552)).setText(str);
        Image.m3366().mo8350(str2, (ImageView) inflate.findViewById(R$id.img_demo), (SimpleImageLoadingListener) new QuickScanActivity(this, inflate));
        C0915 r4 = new C0915(this);
        r4.mo8897(0.9f);
        r4.f2463 = inflate;
        r4.mo8898(2131493124);
        r4.mo8910();
    }
}
