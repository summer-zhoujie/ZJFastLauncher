package com.wpengapp.support.permission;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.support.AccServiceHelper;
import com.wpengapp.support.ActivityKiller;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0601;
import com.wpengapp.support.C0719;
import com.wpengapp.support.C0786;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0936;
import com.wpengapp.support.C0986;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.R$color;
import com.wpengapp.support.R$drawable;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.Utils;
import com.wpengapp.support.activity.WPengBaseActivity;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServicePermissionActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public static final String f712 = (AppUtils.m1163() + ".ALL_GRANTED");

    /* renamed from: ؠ */
    public static C0459 f713;

    /* renamed from: ހ */
    public static List<C0460> f714;

    /* renamed from: ށ */
    public TextView f715;

    /* renamed from: ނ */
    public ItemView f716;

    /* renamed from: ރ */
    public ItemView f717;

    /* renamed from: ބ */
    public LinearLayout f718;

    /* renamed from: ޅ */
    public BroadcastReceiver f719;

    /* renamed from: ކ */
    public boolean f720;

    /* renamed from: އ */
    public boolean f721 = true;

    /* renamed from: ވ */
    public Runnable f722 = new C0677(this);

    public static class InnerActivity extends AppCompatActivity {

        /* renamed from: ֏ */
        public boolean f723 = true;

        public void onResume() {
            super.onResume();
            if (this.f723) {
                Utils.m1911();
                this.f723 = false;
                return;
            }
            finish();
        }
    }

    /* renamed from: com.wpengapp.support.permission.ServicePermissionActivity$֏ */
    public static class C0459 {

        /* renamed from: ֏ */
        public final List<Runnable> f724 = new CopyOnWriteArrayList();

        /* renamed from: ֏ */
        public String[] mo7899() {
            throw null;
        }

        /* renamed from: ؠ */
        public List<C0460> mo7900() {
            return null;
        }

        /* renamed from: ހ */
        public boolean mo7901() {
            return true;
        }
    }

    /* renamed from: com.wpengapp.support.permission.ServicePermissionActivity$ؠ */
    public interface C0460 {
        String getName();

        /* renamed from: ֏ */
        void mo7903(Context context);

        /* renamed from: ֏ */
        boolean mo7904();
    }

    /* renamed from: ގ */
    public static boolean m913() {
        f713.mo7901();
        if (!Utils.m1893()) {
            return false;
        }
        if (f713.mo7899() != null && !AccServiceHelper.m2017(f713.mo7899())) {
            return false;
        }
        if (CollectionUtils.m1657((Collection) f714)) {
            return true;
        }
        for (C0460 r3 : f714) {
            if (!r3.mo7904()) {
                return false;
            }
        }
        return true;
    }

    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_ALL_GRANTED", m913());
        setResult(-1, intent);
        super.finish();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (f713 == null) {
            finish();
            return;
        }
        ActivityKiller.f1598.put(this, this);
        setContentView(R$layout.pw_activity_service_permission);
        mo7434().setBackgroundColor(0);
        findViewById(R$id.toolbarLine).setVisibility(4);
        this.f718 = (LinearLayout) findViewById(R$id.layout_custom_items);
        this.f715 = (TextView) findViewById(R$id.tv_title_necessary);
        this.f716 = (ItemView) findViewById(R$id.item_float);
        this.f717 = (ItemView) findViewById(R$id.item_acc_service);
        ItemView itemView = this.f716;
        f713.mo7901();
        itemView.setVisibility(0);
        this.f717.setVisibility(f713.mo7899() == null ? 8 : 0);
        if (C0719.m1831()) {
            this.f717.setDes((CharSequence) getString(R$string.pw_permission_acc_service_tips_meizu, new Object[]{SystemUtils.m3519(getPackageName())}));
        } else if (C0719.m1832()) {
            this.f717.setDes((CharSequence) getString(R$string.pw_permission_acc_service_tips_miui, new Object[]{SystemUtils.m3519(getPackageName())}));
        }
        this.f716.setOnClickListener(new C1056(this));
        this.f717.setOnClickListener(new C0877(this));
        if (CollectionUtils.m1659((Collection) f714)) {
            this.f717.setBottomLine(true);
            int size = f714.size();
            for (int i = 0; i < size; i++) {
                C0460 r2 = f714.get(i);
                ItemView itemView2 = (ItemView) View.inflate(this, R$layout.pw_item_custom_perm, (ViewGroup) null);
                itemView2.setTag(r2);
                itemView2.setTitle((CharSequence) r2.getName());
                itemView2.setOnClickListener(new C0601(this, r2));
                if (i == size - 1) {
                    itemView2.setBottomLine(false);
                }
                this.f718.addView(itemView2);
            }
            this.f718.setVisibility(0);
        }
        this.f719 = new C0646(this);
        registerReceiver(this.f719, new IntentFilter(C0986.f2760));
        f713.f724.add(this.f722);
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f719);
        C0459 r0 = f713;
        r0.f724.remove(this.f722);
    }

    public void onResume() {
        super.onResume();
        this.f722.run();
        if (this.f720) {
            this.f720 = false;
            if (!AccServiceHelper.m2017(f713.mo7899())) {
                C0915 r1 = new C0915(this);
                r1.f2470 = false;
                r1.mo8905(R$string.pw_permission_acc_need_reboot);
                r1.mo8907((CharSequence) r1.f2461.getString(R$string.pw_i_know), (OnDialogClickListener) null);
                r1.mo8910();
            }
        }
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, R$drawable.baseui_icon_toolbar_back_dark);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return BidiFormatter.EMPTY_STRING;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ޏ */
    public final void mo7896() {
        f713.mo7901();
        boolean r0 = Utils.m1893();
        this.f716.setRightText(r0 ? R$string.pw_permission_granted : R$string.pw_permission_request);
        this.f716.f312.setTextColor(ContextCompat.getColor(this, r0 ? R$color.material_green_500 : R$color.material_red_500));
        if (f713.mo7899() != null) {
            boolean r02 = AccServiceHelper.m2017(f713.mo7899());
            this.f717.setRightText(r02 ? R$string.pw_permission_granted : R$string.pw_permission_request);
            this.f717.f312.setTextColor(ContextCompat.getColor(this, r02 ? R$color.material_green_500 : R$color.material_red_500));
        }
        for (int i = 0; i < this.f718.getChildCount(); i++) {
            ItemView itemView = (ItemView) this.f718.getChildAt(i);
            boolean r2 = ((C0460) itemView.getTag()).mo7904();
            itemView.setRightText(r2 ? R$string.pw_permission_granted : R$string.pw_permission_request);
            itemView.f312.setTextColor(ContextCompat.getColor(this, r2 ? R$color.material_green_500 : R$color.material_red_500));
        }
        this.f715.setTextColor(ContextCompat.getColor(this, m913() ? R$color.material_green_500 : R$color.material_red_500));
    }

    /* renamed from: ސ */
    public final void mo7897() {
        C0786.m2105((Context) this, new Intent(f712), true);
    }

    /* renamed from: ޑ */
    public final void mo7898() {
        int color = ContextCompat.getColor(this, R$color.material_red_500);
        TextView textView = (TextView) findViewById(R$id.tv_tips_background);
        ((TextView) findViewById(R$id.tv_title_background)).setTextColor(color);
        textView.setText(R$string.pw_permission_background_tips2);
        textView.setTextColor(color);
        int i = Build.VERSION.SDK_INT;
        View findViewById = findViewById(R$id.layout_title_background);
        findViewById.setOnClickListener(new C0717(this));
        int width = findViewById.getWidth() / 2;
        int height = findViewById.getHeight() / 2;
        for (int i2 = 0; i2 < 3; i2++) {
            findViewById.postDelayed(new C0933(this, width, height, findViewById), (long) (i2 * 600));
        }
    }

    /* renamed from: ֏ */
    public static Dialog m907(Context context) {
        C0915 r0 = new C0915(context);
        r0.f2469 = false;
        r0.mo8899(R$string.pw_permission_dialog_title, 17);
        r0.mo8900(R$string.pw_cancel, (OnDialogClickListener) null);
        r0.mo8906(R$string.pw_permission_request, (OnDialogClickListener) new ServicePermissionActivity(context));
        return r0.mo8896();
    }

    /* renamed from: ؠ */
    public static void m909(Context context) {
        SystemUtils.m3510(context, new Intent(context, ServicePermissionActivity.class));
    }

    /* renamed from: ހ */
    public static void m911(Context context) {
        C0936.m2467(m907(context));
    }
}
