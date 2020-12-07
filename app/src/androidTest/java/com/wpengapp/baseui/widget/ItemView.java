package com.wpengapp.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wpengapp.baseui.R$dimen;
import com.wpengapp.baseui.R$drawable;
import com.wpengapp.baseui.R$id;
import com.wpengapp.baseui.R$layout;
import com.wpengapp.baseui.R$styleable;

public class ItemView extends RelativeLayout implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: ֏ */
    public int f307;

    /* renamed from: ؠ */
    public SwitchButton f308;

    /* renamed from: ހ */
    public TextView f309;

    /* renamed from: ށ */
    public TextView f310;

    /* renamed from: ނ */
    public TextView f311;

    /* renamed from: ރ */
    public TextView f312;

    /* renamed from: ބ */
    public ImageView f313;

    /* renamed from: ޅ */
    public View f314;

    /* renamed from: ކ */
    public View f315;

    /* renamed from: އ */
    public C0425 f316;

    /* renamed from: com.wpengapp.baseui.widget.ItemView$֏ */
    public interface C0425 {
        /* renamed from: ֏ */
        boolean mo7506(CompoundButton compoundButton, boolean z);
    }

    public ItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo7503(context, attributeSet, 0);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C0425 r0 = this.f316;
        if (r0 != null && r0.mo7506(compoundButton, z)) {
            this.f308.mo7525(!z, false);
        }
    }

    public void onClick(View view) {
        SwitchButton switchButton;
        if (this.f307 == 3 && (switchButton = this.f308) != null) {
            switchButton.toggle();
        }
    }

    public void setBottomLine(boolean z) {
        this.f315.setVisibility(z ? 0 : 8);
    }

    public void setChecked(boolean z) {
        SwitchButton switchButton = this.f308;
        if (switchButton != null) {
            switchButton.setChecked(z);
        }
    }

    public void setDes(int i) {
        setDes((CharSequence) getContext().getString(i));
    }

    public void setEnterIcon(int i) {
        this.f313.setImageResource(i);
        this.f313.setVisibility(0);
    }

    public void setOnCheckedChangeListener(C0425 r1) {
        this.f316 = r1;
    }

    public void setRightText(int i) {
        setRightText((CharSequence) getContext().getString(i));
    }

    public void setTitle(int i) {
        setTitle((CharSequence) getContext().getString(i));
    }

    /* renamed from: ֏ */
    public final void mo7503(Context context, AttributeSet attributeSet, int i) {
        Context context2 = context;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.ItemView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.ItemView_layout, -1);
        int i2 = obtainStyledAttributes.getInt(R$styleable.ItemView_size, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ItemView_iconSrc);
        String string = obtainStyledAttributes.getString(R$styleable.ItemView_titleText);
        String string2 = obtainStyledAttributes.getString(R$styleable.ItemView_desText);
        String string3 = obtainStyledAttributes.getString(R$styleable.ItemView_rightText);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.ItemView_checked, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.ItemView_bottomLine, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ItemView_contentPadding, getResources().getDimensionPixelSize(R$dimen.baseui_item_view_padding));
        this.f307 = obtainStyledAttributes.getInt(R$styleable.ItemView_type, 0);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            if (this.f307 == 4) {
                resourceId = R$layout.baseui_item_small;
            } else if (i2 == 0) {
                resourceId = R$layout.baseui_item_normal;
            } else if (i2 == 1) {
                resourceId = R$layout.baseui_item_small;
            } else {
                resourceId = R$layout.baseui_item_normal;
            }
        }
        RelativeLayout.inflate(context2, resourceId, this);
        this.f314 = findViewById(R$id.layout_item);
        this.f314.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        this.f309 = (TextView) findViewById(R$id.tv_title);
        this.f311 = (TextView) findViewById(R$id.tv_title2);
        setTitle((CharSequence) string);
        this.f310 = (TextView) findViewById(R$id.tv_des);
        setDes((CharSequence) string2);
        this.f312 = (TextView) findViewById(R$id.tv_right);
        setRightText((CharSequence) string3);
        this.f313 = (ImageView) findViewById(R$id.img_enter);
        int i3 = this.f307;
        if (i3 == 1) {
            setEnterIcon(R$drawable.baseui_icon_arrow_next_right);
        } else if (i3 != 2) {
            if (i3 == 3) {
                this.f308 = (SwitchButton) findViewById(R$id.switch_button);
                this.f308.setVisibility(0);
                this.f308.setChecked(z);
                this.f308.setOnCheckedChangeListener(this);
                setOnClickListener(this);
            } else if (i3 == 4) {
                findViewById(R$id.layout_normal).setVisibility(8);
                this.f311.setVisibility(0);
                setClickable(false);
                this.f314.setBackgroundColor(0);
            }
        }
        if (this.f307 != 0) {
            findViewById(R$id.layout_right).setVisibility(0);
        }
        this.f315 = findViewById(R$id.bottom_line);
        setBottomLine(z2);
        if (drawable != null) {
            ImageView imageView = (ImageView) findViewById(R$id.img_icon);
            imageView.setVisibility(0);
            imageView.setImageDrawable(drawable);
        }
    }

    public void setDes(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f310.setVisibility(8);
            return;
        }
        this.f310.setVisibility(0);
        this.f310.setText(charSequence);
    }

    public void setRightText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f312.setVisibility(8);
            return;
        }
        this.f312.setVisibility(0);
        this.f312.setText(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        if (this.f307 == 4) {
            this.f311.setText(charSequence);
        } else {
            this.f309.setText(charSequence);
        }
    }

    public ItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo7503(context, attributeSet, i);
    }

    /* renamed from: ֏ */
    public boolean mo7505() {
        SwitchButton switchButton = this.f308;
        return switchButton != null && switchButton.isChecked();
    }

    /* renamed from: ֏ */
    public void mo7504(boolean z, boolean z2) {
        SwitchButton switchButton = this.f308;
        if (switchButton != null) {
            switchButton.mo7525(z, z2);
        }
    }
}
