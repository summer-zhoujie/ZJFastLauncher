package com.wpengapp.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.support.p003v7.appcompat.C0176R;
import android.support.p003v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.wpengapp.baseui.R$drawable;
import com.wpengapp.baseui.R$styleable;

public class ClearEditText extends AppCompatEditText implements View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {

    /* renamed from: ֏ */
    public Drawable f298;

    /* renamed from: ؠ */
    public boolean f299;

    /* renamed from: ހ */
    public boolean f300;

    /* renamed from: ށ */
    public OnFocusChangeListener f301;

    /* renamed from: ނ */
    public OnTouchListener f302;

    public ClearEditText(Context context) {
        super(context);
        mo7484((AttributeSet) null);
    }

    private void setClearIconVisible(boolean z) {
        if (this.f299 != z) {
            this.f299 = z;
            Drawable drawable = z ? this.f298 : null;
            Drawable[] compoundDrawables = getCompoundDrawables();
            setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onFocusChange(View view, boolean z) {
        OnFocusChangeListener onFocusChangeListener = this.f301;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z);
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        setClearIconVisible(charSequence.length() > 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r0 != 3) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(View r5, MotionEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.f299
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0035
            int r0 = r6.getAction()
            if (r0 == 0) goto L_0x0012
            if (r0 == r2) goto L_0x001b
            r3 = 3
            if (r0 == r3) goto L_0x002e
            goto L_0x0030
        L_0x0012:
            boolean r0 = r4.mo7485((android.view.MotionEvent) r6)
            if (r0 == 0) goto L_0x001b
            r4.f300 = r2
            return r2
        L_0x001b:
            boolean r0 = r4.f300
            if (r0 == 0) goto L_0x002e
            boolean r0 = r4.mo7485((android.view.MotionEvent) r6)
            if (r0 == 0) goto L_0x002e
            r0 = 0
            r4.setError(r0)
            java.lang.String r0 = ""
            r4.setText(r0)
        L_0x002e:
            r4.f300 = r1
        L_0x0030:
            boolean r0 = r4.f300
            if (r0 == 0) goto L_0x0035
            return r2
        L_0x0035:
            android.view.View$OnTouchListener r0 = r4.f302
            if (r0 == 0) goto L_0x0040
            boolean r5 = r0.onTouch(r5, r6)
            if (r5 == 0) goto L_0x0040
            r1 = 1
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.baseui.widget.ClearEditText.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f301 = onFocusChangeListener;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f302 = onTouchListener;
    }

    /* renamed from: ֏ */
    public final void mo7484(AttributeSet attributeSet) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[2];
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(getContext(), R$drawable.baseui_ic_clear);
        } else {
            setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], (Drawable) null, compoundDrawables[3]);
        }
        this.f298 = DrawableCompat.wrap(drawable);
        this.f298.mutate();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ClearEditText);
            int color = obtainStyledAttributes.getColor(R$styleable.ClearEditText_clearIconColor, -1);
            obtainStyledAttributes.recycle();
            if (color != -1) {
                DrawableCompat.setTint(this.f298, color);
            }
        }
        this.f298.setBounds(0, 0, (int) getTextSize(), (int) getTextSize());
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    public ClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo7484(attributeSet);
    }

    public ClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, C0176R.attr.editTextStyle);
        mo7484(attributeSet);
    }

    /* renamed from: ֏ */
    public final boolean mo7485(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int width = (int) ((((double) this.f298.getBounds().width()) * 1.1d) + ((double) getTotalPaddingRight()));
        int width2 = getWidth() - width;
        int height = (int) (((double) this.f298.getBounds().height()) * 1.2d);
        int height2 = (getHeight() - height) / 2;
        return (x > width2 && x < width2 + width) && (y > height2 && y < height2 + height);
    }
}
