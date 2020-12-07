package com.wpengapp.support;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.WeakHashMap;

/* renamed from: com.wpengapp.support.ߗ */
public class FloatWindow {

    /* renamed from: ֏ */
    public static final WeakHashMap<FloatWindow, Object> f2731 = new WeakHashMap<>();

    /* renamed from: ؠ */
    public boolean f2732 = false;

    /* renamed from: ހ */
    public WindowManager f2733;

    /* renamed from: ށ */
    public WindowManager.LayoutParams f2734;

    /* renamed from: ނ */
    public View f2735;

    /* renamed from: ރ */
    public float f2736 = 1.0f;

    /* renamed from: ބ */
    public int f2737;

    /* renamed from: ޅ */
    public int f2738;

    /* renamed from: ކ */
    public Context f2739;

    public FloatWindow(Context context, WindowManager.LayoutParams layoutParams, int i) {
        new Handler();
        this.f2734 = layoutParams;
        this.f2734.gravity = 51;
        this.f2739 = context;
        this.f2735 = ViewGroup.inflate(context, i, (ViewGroup) null);
        mo9030();
    }

    /* renamed from: ֏ */
    public synchronized void mo9027() {
        if (this.f2732) {
            this.f2733.removeView(this.f2735);
            this.f2732 = false;
        }
    }

    /* renamed from: ؠ */
    public final void mo9030() {
        f2731.put(this, this);
        this.f2737 = this.f2734.width;
        this.f2738 = this.f2734.height;
        this.f2733 = (WindowManager) this.f2739.getSystemService("window");
        if (SystemUtils.f3711 >= 26) {
            WindowManager.LayoutParams layoutParams = this.f2734;
            if (layoutParams.type >= 2000) {
                layoutParams.type = 2038;
            }
        }
    }

    /* renamed from: ހ */
    public synchronized void mo9031() {
        try {
            if (this.f2732) {
                this.f2733.updateViewLayout(this.f2735, this.f2734);
            } else {
                this.f2733.addView(this.f2735, this.f2734);
                this.f2732 = true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return;
    }

    /* renamed from: ֏ */
    public void mo9028(int i, int i2) {
        WindowManager.LayoutParams layoutParams = this.f2734;
        layoutParams.x = i;
        layoutParams.y = i2;
        mo9031();
    }

    /* renamed from: ֏ */
    public void mo9029(int i, int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams = this.f2734;
        layoutParams.x = i;
        layoutParams.y = i2;
        this.f2737 = i3;
        this.f2738 = i4;
        float f = this.f2736;
        this.f2736 = f;
        layoutParams.width = Math.round(((float) this.f2737) * f);
        this.f2734.height = Math.round(((float) this.f2738) * f);
        mo9031();
    }

    public FloatWindow(Context context, WindowManager.LayoutParams layoutParams, View view) {
        new Handler();
        layoutParams.gravity = 51;
        this.f2734 = layoutParams;
        this.f2739 = context;
        this.f2735 = view;
        mo9030();
    }
}
