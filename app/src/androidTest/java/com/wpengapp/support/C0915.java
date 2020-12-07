package com.wpengapp.support;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.support.p003v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wpengapp.baseui.R$id;
import com.wpengapp.baseui.R$layout;
import com.wpengapp.baseui.R$style;
import com.wpengapp.baseui.widget.dialog.DialogView;
import java.util.List;

/* renamed from: com.wpengapp.support.ܐ */
/* compiled from: DialogBuilder */
public class C0915 {

    /* renamed from: ֏ */
    public Context f2461;

    /* renamed from: ؠ */
    public int f2462;

    /* renamed from: ހ */
    public View f2463;

    /* renamed from: ށ */
    public CharSequence f2464;

    /* renamed from: ނ */
    public CharSequence f2465;

    /* renamed from: ރ */
    public CharSequence f2466;

    /* renamed from: ބ */
    public OnDialogClickListener f2467;

    /* renamed from: ޅ */
    public OnDialogClickListener f2468;

    /* renamed from: ކ */
    public boolean f2469 = true;

    /* renamed from: އ */
    public boolean f2470 = true;

    /* renamed from: ވ */
    public OnDismissListener f2471;

    /* renamed from: މ */
    public DialogInterface.OnCancelListener f2472;

    /* renamed from: ފ */
    public BaseAdapter f2473;

    /* renamed from: ދ */
    public List<CharSequence> f2474;

    /* renamed from: ތ */
    public AdapterView.OnItemClickListener f2475;

    /* renamed from: ލ */
    public int f2476 = -1;

    /* renamed from: ގ */
    public CharSequence f2477;

    /* renamed from: ޏ */
    public int f2478 = 51;

    /* renamed from: ސ */
    public boolean f2479;

    /* renamed from: ޑ */
    public HtmlTextHelper f2480;

    /* renamed from: ޒ */
    public int f2481 = -100;

    /* renamed from: ޓ */
    public int f2482 = -2;

    /* renamed from: ޔ */
    public int f2483 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    /* renamed from: ޕ */
    public int f2484;

    public C0915(Context context) {
        int i = R$style.WpengApp_BaseAppTheme;
        this.f2462 = i;
        this.f2461 = context;
    }

    /* renamed from: ֏ */
    public C0915 mo8897(float f) {
        this.f2481 = (int) (((float) m2398(this.f2461).x) * f);
        return this;
    }

    /* renamed from: ؠ */
    public C0915 mo8905(int i) {
        mo8902((CharSequence) this.f2461.getString(i), 19);
        return this;
    }

    /* renamed from: ހ */
    public C0915 mo8909(int i) {
        this.f2464 = this.f2461.getString(i);
        return this;
    }

    /* renamed from: ށ */
    public AlertDialog mo8910() {
        AlertDialog r0 = mo8896();
        C0936.m2467(r0);
        return r0;
    }

    /* renamed from: ֏ */
    public C0915 mo8899(int i, int i2) {
        this.f2477 = this.f2461.getString(i);
        this.f2478 = i2;
        return this;
    }

    /* renamed from: ؠ */
    public C0915 mo8906(int i, OnDialogClickListener r3) {
        this.f2466 = this.f2461.getString(i);
        this.f2468 = r3;
        return this;
    }

    /* renamed from: ހ */
    public PopupDialog mo8908() {
        DialogView r0 = mo8904();
        PopupDialog r1 = new PopupDialog(this.f2461, this.f2481, this.f2482, r0);
        r0.f403 = r1;
        if (this.f2471 != null) {
            r1.setOnDismissListener(new C0973(this));
        }
        r1.f2323 = this.f2470;
        r1.f2324 = this.f2469;
        return r1;
    }

    /* renamed from: ֏ */
    public C0915 mo8902(CharSequence charSequence, int i) {
        this.f2477 = charSequence;
        this.f2478 = i;
        return this;
    }

    /* renamed from: ؠ */
    public C0915 mo8907(CharSequence charSequence, OnDialogClickListener r2) {
        this.f2466 = charSequence;
        this.f2468 = r2;
        return this;
    }

    /* renamed from: ֏ */
    public C0915 mo8898(int i) {
        mo8903((CharSequence) this.f2461.getString(i), (OnDialogClickListener) null);
        return this;
    }

    /* renamed from: ؠ */
    public final DialogView mo8904() {
        List<CharSequence> list;
        Context context = this.f2461;
        if (!(context instanceof Activity)) {
            context.getTheme().applyStyle(this.f2462, true);
        }
        DialogView dialogView = new DialogView(this.f2461);
        if (this.f2481 == -100) {
            mo8897(0.8f);
        }
        dialogView.f396.setMaxHeight(this.f2483);
        int i = this.f2484;
        if (i > 0) {
            dialogView.f396.setBackgroundResource(i);
        }
        if (TextUtils.isEmpty(this.f2464)) {
            dialogView.f397.setVisibility(8);
        } else {
            dialogView.f397.setVisibility(0);
            dialogView.f397.setText(this.f2464);
        }
        if (!TextUtils.isEmpty(this.f2465) || !TextUtils.isEmpty(this.f2466)) {
            dialogView.f398.setVisibility(0);
            dialogView.f402.setVisibility(0);
            if (TextUtils.isEmpty(this.f2465) || TextUtils.isEmpty(this.f2466)) {
                dialogView.f401.setVisibility(8);
            } else {
                dialogView.f401.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.f2465)) {
                dialogView.f399.setVisibility(8);
            } else {
                dialogView.f399.setVisibility(0);
                dialogView.f399.setText(this.f2465);
                dialogView.f399.setOnClickListener(new C0974(this, dialogView));
            }
            if (TextUtils.isEmpty(this.f2466)) {
                dialogView.f400.setVisibility(8);
            } else {
                dialogView.f400.setVisibility(0);
                dialogView.f400.setText(this.f2466);
                dialogView.f400.setOnClickListener(new C0482(this, dialogView));
            }
        } else {
            dialogView.f398.setVisibility(8);
            dialogView.f402.setVisibility(8);
        }
        View view = this.f2463;
        if (view != null) {
            dialogView.setContentView(view);
        } else if (!TextUtils.isEmpty(this.f2477)) {
            ScrollView scrollView = (ScrollView) View.inflate(this.f2461, R$layout.baseui_vw_dialog_message, (ViewGroup) null);
            TextView textView = (TextView) scrollView.findViewById(R$id.tv_msg);
            textView.setGravity(this.f2478);
            if (this.f2479) {
                C1279.m3412(textView, this.f2477, this.f2480);
            } else {
                textView.setText(this.f2477);
            }
            dialogView.setContentView((View) scrollView);
        } else if (this.f2473 != null || ((list = this.f2474) != null && !list.isEmpty())) {
            ListView listView = (ListView) View.inflate(this.f2461, R$layout.baseui_vw_dialog_list, (ViewGroup) null);
            BaseAdapter baseAdapter = this.f2473;
            if (baseAdapter != null) {
                listView.setAdapter(baseAdapter);
                listView.setOnItemClickListener(this.f2475);
            } else {
                List<CharSequence> list2 = this.f2474;
                if (list2 != null && !list2.isEmpty()) {
                    SimpleListAdapter r2 = new SimpleListAdapter(this.f2461, this.f2474, this.f2476);
                    listView.setAdapter(r2);
                    listView.setOnItemClickListener(new DialogBuilder(this, r2, dialogView));
                }
            }
            dialogView.setContentView((View) listView);
        }
        return dialogView;
    }

    /* renamed from: ֏ */
    public C0915 mo8900(int i, OnDialogClickListener r3) {
        this.f2465 = this.f2461.getString(i);
        this.f2467 = r3;
        return this;
    }

    /* renamed from: ֏ */
    public C0915 mo8903(CharSequence charSequence, OnDialogClickListener r2) {
        this.f2465 = charSequence;
        this.f2467 = r2;
        return this;
    }

    /* renamed from: ֏ */
    public C0915 mo8901(OnDismissListener r1) {
        this.f2471 = r1;
        return this;
    }

    /* renamed from: ֏ */
    public AlertDialog mo8896() {
        DialogView r0 = mo8904();
        AlertDialog r1 = new AlertDialog(this.f2461, R$style.WpengApp_BaseDialogTheme);
        r0.f403 = r1;
        r1.setContentView(r0);
        if (this.f2471 != null) {
            r1.setOnDismissListener(new C0978(this));
        }
        r1.setOnCancelListener(this.f2472);
        r1.setCanceledOnTouchOutside(this.f2470);
        r1.setCancelable(this.f2469);
        int i = this.f2481;
        int i2 = this.f2482;
        WindowManager.LayoutParams attributes = r1.getWindow().getAttributes();
        attributes.width = i;
        attributes.height = i2;
        r1.getWindow().setAttributes(attributes);
        return r1;
    }

    /* renamed from: ֏ */
    public static Point m2398(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Point point = new Point();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i > i2) {
            point.x = i2;
            point.y = i;
        } else {
            point.x = i;
            point.y = i2;
        }
        return point;
    }
}
