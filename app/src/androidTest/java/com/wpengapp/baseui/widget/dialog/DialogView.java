package com.wpengapp.baseui.widget.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wpengapp.baseui.R$id;
import com.wpengapp.baseui.R$layout;
import com.wpengapp.support.IDialog;

public class DialogView extends RelativeLayout {

    /* renamed from: ֏ */
    public RelativeLayout f395;

    /* renamed from: ؠ */
    public MaxHeightLayout f396;

    /* renamed from: ހ */
    public TextView f397;

    /* renamed from: ށ */
    public View f398;

    /* renamed from: ނ */
    public TextView f399;

    /* renamed from: ރ */
    public TextView f400;

    /* renamed from: ބ */
    public View f401;

    /* renamed from: ޅ */
    public View f402;

    /* renamed from: ކ */
    public IDialog f403;

    public DialogView(Context context) {
        super(context);
        mo7549();
    }

    public void setContentView(int i) {
        setContentView(RelativeLayout.inflate(getContext(), i, (ViewGroup) null));
    }

    /* renamed from: ֏ */
    public final void mo7549() {
        RelativeLayout.inflate(getContext(), R$layout.baseui_vw_dialog_base, this);
        this.f396 = (MaxHeightLayout) findViewById(R$id.root);
        this.f395 = (RelativeLayout) findViewById(R$id.base_content);
        this.f397 = (TextView) findViewById(R$id.tv_title);
        this.f398 = findViewById(R$id.layout_dialog_button);
        this.f399 = (TextView) findViewById(R$id.dialog_left_button);
        this.f400 = (TextView) findViewById(R$id.dialog_right_button);
        this.f401 = findViewById(R$id.dialog_button_divider);
        this.f402 = findViewById(R$id.button_top_divider);
    }

    public void setContentView(View view) {
        this.f395.addView(view, new LayoutParams(-1, -2));
    }

    public DialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo7549();
    }

    public DialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo7549();
    }
}
