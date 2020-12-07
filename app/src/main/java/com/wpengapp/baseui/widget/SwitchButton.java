package com.wpengapp.baseui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.p000v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.wpengapp.baseui.R$styleable;
import java.lang.reflect.Field;

public class SwitchButton extends CompoundButton {

    /* renamed from: ֏ */
    public static boolean f317 = false;

    /* renamed from: ؠ */
    public boolean f318;

    /* renamed from: ހ */
    public C0432 f319;

    /* renamed from: ށ */
    public Rect f320;

    /* renamed from: ނ */
    public Rect f321;

    /* renamed from: ރ */
    public Rect f322;

    /* renamed from: ބ */
    public RectF f323;

    /* renamed from: ޅ */
    public C0427 f324;

    /* renamed from: ކ */
    public C0431 f325;

    /* renamed from: އ */
    public boolean f326;

    /* renamed from: ވ */
    public float f327;

    /* renamed from: މ */
    public float f328;

    /* renamed from: ފ */
    public float f329;

    /* renamed from: ދ */
    public float f330;

    /* renamed from: ތ */
    public int f331;

    /* renamed from: ލ */
    public int f332;

    /* renamed from: ގ */
    public Paint f333;

    /* renamed from: ޏ */
    public Rect f334;

    /* renamed from: ސ */
    public OnCheckedChangeListener f335;

    /* renamed from: com.wpengapp.baseui.widget.SwitchButton$ؠ */
    private static class C0430 extends Handler {
        public /* synthetic */ C0430(SwitchButton r1) {
        }

        public void handleMessage(Message message) {
            Object obj;
            if (message.what == C0427.f336 && (obj = message.obj) != null) {
                ((Runnable) obj).run();
            }
        }
    }

    /* renamed from: com.wpengapp.baseui.widget.SwitchButton$ހ */
    class C0431 implements C0427.C0428 {
        public C0431() {
        }

        /* renamed from: ֏ */
        public void mo7531() {
            SwitchButton switchButton = SwitchButton.this;
            switchButton.mo7527(switchButton.getStatusBasedOnPos(), true);
            boolean unused = SwitchButton.this.f326 = false;
        }
    }

    /* renamed from: com.wpengapp.baseui.widget.SwitchButton$ށ */
    public static class C0432 implements Cloneable {

        /* renamed from: ֏ */
        public Drawable f348 = null;

        /* renamed from: ؠ */
        public Drawable f349 = null;

        /* renamed from: ހ */
        public Drawable f350 = null;

        /* renamed from: ށ */
        public GradientDrawable f351 = null;

        /* renamed from: ނ */
        public GradientDrawable f352 = null;

        /* renamed from: ރ */
        public GradientDrawable f353 = null;

        /* renamed from: ބ */
        public int f354 = -14038636;

        /* renamed from: ޅ */
        public int f355 = -723724;

        /* renamed from: ކ */
        public int f356 = -1;

        /* renamed from: އ */
        public int f357 = SwipeRefreshLayout.CIRCLE_BG_LIGHT;

        /* renamed from: ވ */
        public int f358 = -2565928;

        /* renamed from: މ */
        public int f359 = -2565928;

        /* renamed from: ފ */
        public int f360 = -14571917;

        /* renamed from: ދ */
        public int f361 = 0;

        /* renamed from: ތ */
        public int f362 = 0;

        /* renamed from: ލ */
        public int f363 = 0;

        /* renamed from: ގ */
        public int f364 = 0;

        /* renamed from: ޏ */
        public int f365 = -1;

        /* renamed from: ސ */
        public int f366 = -1;

        /* renamed from: ޑ */
        public int f367 = 0;

        /* renamed from: ޒ */
        public float f368;

        /* renamed from: ޓ */
        public int f369 = -1;

        /* renamed from: ޔ */
        public float f370 = 1000.0f;

        /* renamed from: ޕ */
        public float f371 = 1.75f;

        /* renamed from: ޖ */
        public Rect f372;

        public /* synthetic */ C0432(C0433 r2, SwitchButton r3) {
            this.f355 = r2.f378;
            this.f350 = r2.f376;
            this.f359 = r2.f382;
            this.f354 = r2.f377;
            this.f349 = r2.f375;
            this.f360 = r2.f383;
            this.f356 = r2.f379;
            this.f348 = r2.f374;
            this.f358 = r2.f381;
            this.f357 = r2.f380;
            this.f365 = r2.f388;
            this.f366 = r2.f389;
            this.f367 = r2.f390;
            this.f369 = r2.f391;
            this.f368 = r2.f373;
            this.f372 = r2.f394;
            this.f371 = r2.f393;
            this.f370 = r2.f392;
            this.f363 = r2.f386;
            this.f361 = r2.f384;
            this.f364 = r2.f387;
            this.f362 = r2.f385;
        }

        /* renamed from: ֏ */
        public static C0433 m315(float f) {
            return new C0433(f);
        }

        /* renamed from: ؠ */
        public Drawable mo7534() {
            if (this.f353 == null) {
                this.f353 = new GradientDrawable();
                this.f353.setColor(this.f359);
                this.f353.setCornerRadius(mo7537());
            }
            Rect copyBounds = mo7532().copyBounds();
            int i = copyBounds.left;
            int i2 = this.f367;
            copyBounds.left = i - i2;
            copyBounds.top -= i2;
            copyBounds.right += i2;
            copyBounds.bottom += i2;
            this.f353.setBounds(copyBounds);
            return this.f353;
        }

        /* renamed from: ހ */
        public Drawable mo7535() {
            Drawable drawable = this.f349;
            if (drawable != null) {
                return drawable;
            }
            return mo7533(this.f354);
        }

        /* renamed from: ށ */
        public Drawable mo7536() {
            if (this.f367 <= 0) {
                return null;
            }
            if (this.f352 == null) {
                this.f352 = new GradientDrawable();
                this.f352.setColor(this.f360);
                this.f352.setCornerRadius(mo7537());
            }
            Rect copyBounds = mo7535().copyBounds();
            int i = copyBounds.left;
            int i2 = this.f367;
            copyBounds.left = i - i2;
            copyBounds.top -= i2;
            copyBounds.right += i2;
            copyBounds.bottom += i2;
            this.f352.setBounds(copyBounds);
            return this.f352;
        }

        /* renamed from: ނ */
        public float mo7537() {
            float f = this.f370;
            if (f < 0.0f) {
                return 1000.0f;
            }
            return f;
        }

        /* renamed from: ރ */
        public int mo7538() {
            Rect rect = this.f372;
            return rect.left + rect.right;
        }

        /* renamed from: ބ */
        public int mo7539() {
            Rect rect = this.f372;
            return rect.top + rect.bottom;
        }

        /* renamed from: ޅ */
        public Drawable mo7540() {
            Drawable drawable = this.f348;
            if (drawable != null) {
                return drawable;
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable r1 = mo7533(this.f356);
            Drawable r2 = mo7533(this.f357);
            int[] iArr = null;
            try {
                Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
                declaredField.setAccessible(true);
                iArr = (int[]) declaredField.get((Object) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (iArr != null) {
                stateListDrawable.addState(iArr, r2);
            }
            stateListDrawable.addState(new int[0], r1);
            return stateListDrawable;
        }

        /* renamed from: ކ */
        public Drawable mo7541() {
            if (this.f367 <= 0) {
                return null;
            }
            if (this.f351 == null) {
                this.f351 = new GradientDrawable();
                this.f351.setColor(this.f358);
                this.f351.setCornerRadius(mo7537());
            }
            Rect copyBounds = mo7540().copyBounds();
            int i = copyBounds.left;
            int i2 = this.f367;
            copyBounds.left = i - i2;
            copyBounds.top -= i2;
            copyBounds.right += i2;
            copyBounds.bottom += i2;
            this.f351.setBounds(copyBounds);
            return this.f351;
        }

        /* renamed from: އ */
        public int mo7542() {
            int intrinsicHeight;
            int i = this.f366;
            if (i >= 0) {
                return i;
            }
            Drawable drawable = this.f348;
            if (drawable == null || (intrinsicHeight = drawable.getIntrinsicHeight()) <= 0) {
                return (int) (this.f368 * 24.0f);
            }
            return intrinsicHeight;
        }

        /* renamed from: ވ */
        public int mo7543() {
            int intrinsicWidth;
            int i = this.f365;
            if (i >= 0) {
                return i;
            }
            Drawable drawable = this.f348;
            if (drawable == null || (intrinsicWidth = drawable.getIntrinsicWidth()) <= 0) {
                return (int) (this.f368 * 24.0f);
            }
            return intrinsicWidth;
        }

        /* renamed from: މ */
        public boolean mo7544() {
            Rect rect = this.f372;
            return ((rect.left + rect.right) + rect.top) + rect.bottom != 0;
        }

        /* renamed from: ֏ */
        public Drawable mo7532() {
            Drawable drawable = this.f350;
            if (drawable != null) {
                return drawable;
            }
            return mo7533(this.f355);
        }

        /* renamed from: com.wpengapp.baseui.widget.SwitchButton$ށ$֏ */
        public static class C0433 {

            /* renamed from: ֏ */
            public float f373;

            /* renamed from: ؠ */
            public Drawable f374 = null;

            /* renamed from: ހ */
            public Drawable f375 = null;

            /* renamed from: ށ */
            public Drawable f376 = null;

            /* renamed from: ނ */
            public int f377 = -14038636;

            /* renamed from: ރ */
            public int f378 = -723724;

            /* renamed from: ބ */
            public int f379 = -1;

            /* renamed from: ޅ */
            public int f380 = SwipeRefreshLayout.CIRCLE_BG_LIGHT;

            /* renamed from: ކ */
            public int f381 = -2565928;

            /* renamed from: އ */
            public int f382 = -2565928;

            /* renamed from: ވ */
            public int f383 = -14571917;

            /* renamed from: މ */
            public int f384 = 0;

            /* renamed from: ފ */
            public int f385 = 0;

            /* renamed from: ދ */
            public int f386 = 0;

            /* renamed from: ތ */
            public int f387 = 0;

            /* renamed from: ލ */
            public int f388 = -1;

            /* renamed from: ގ */
            public int f389 = -1;

            /* renamed from: ޏ */
            public int f390 = 0;

            /* renamed from: ސ */
            public int f391 = -1;

            /* renamed from: ޑ */
            public float f392 = -1.0f;

            /* renamed from: ޒ */
            public float f393 = 0.0f;

            /* renamed from: ޓ */
            public Rect f394;

            public C0433(float f) {
                this.f373 = f <= 0.0f ? 1.0f : f;
                this.f394 = new Rect(0, 0, 0, 0);
            }

            /* renamed from: ֏ */
            public C0433 mo7546(int i, int i2, int i3, int i4) {
                this.f386 = i;
                this.f384 = i2;
                this.f387 = i3;
                this.f385 = i4;
                return this;
            }

            /* renamed from: ֏ */
            public C0433 mo7545(int i, int i2) {
                if (i > 0) {
                    this.f388 = i;
                }
                if (i2 > 0) {
                    this.f389 = i2;
                }
                return this;
            }
        }

        /* renamed from: ֏ */
        public Drawable mo7533(int i) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(mo7537());
            gradientDrawable.setColor(i);
            return gradientDrawable;
        }
    }

    public SwitchButton(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    /* access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.f322.left) > this.f330;
    }

    private void setCheckedInClass(boolean z) {
        mo7527(z, true);
    }

    private void setDrawableState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        setDrawableState(this.f319.mo7540());
        setDrawableState(this.f319.mo7535());
        setDrawableState(this.f319.mo7532());
    }

    public void invalidate() {
        if (this.f334 == null || !this.f319.mo7544()) {
            super.invalidate();
        } else {
            invalidate(this.f334);
        }
    }

    public boolean isChecked() {
        return this.f318;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0067, code lost:
        if ((!(r5.f319.mo7540() instanceof android.graphics.drawable.StateListDrawable) || !(r5.f319.mo7535() instanceof android.graphics.drawable.StateListDrawable) || !(r5.f319.mo7532() instanceof android.graphics.drawable.StateListDrawable)) != false) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r6) {
        /*
            r5 = this;
            super.onDraw(r6)
            android.graphics.Rect r0 = r5.f334
            r6.getClipBounds(r0)
            android.graphics.Rect r0 = r5.f334
            if (r0 == 0) goto L_0x003d
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            boolean r0 = r0.mo7544()
            if (r0 == 0) goto L_0x003d
            android.graphics.Rect r0 = r5.f334
            com.wpengapp.baseui.widget.SwitchButton$ށ r1 = r5.f319
            int r1 = r1.mo7538()
            int r1 = r1 / 2
            com.wpengapp.baseui.widget.SwitchButton$ށ r2 = r5.f319
            int r2 = r2.mo7539()
            int r2 = r2 / 2
            r0.inset(r1, r2)
            android.graphics.Rect r0 = r5.f334
            android.graphics.Region$Op r1 = android.graphics.Region.Op.REPLACE
            r6.clipRect(r0, r1)
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.Rect r0 = r0.f372
            int r1 = r0.left
            float r1 = (float) r1
            int r0 = r0.top
            float r0 = (float) r0
            r6.translate(r1, r0)
        L_0x003d:
            boolean r0 = r5.isEnabled()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x006a
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7540()
            boolean r0 = r0 instanceof android.graphics.drawable.StateListDrawable
            com.wpengapp.baseui.widget.SwitchButton$ށ r3 = r5.f319
            android.graphics.drawable.Drawable r3 = r3.mo7535()
            boolean r3 = r3 instanceof android.graphics.drawable.StateListDrawable
            com.wpengapp.baseui.widget.SwitchButton$ށ r4 = r5.f319
            android.graphics.drawable.Drawable r4 = r4.mo7532()
            boolean r4 = r4 instanceof android.graphics.drawable.StateListDrawable
            if (r0 == 0) goto L_0x0066
            if (r3 == 0) goto L_0x0066
            if (r4 != 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r0 = 0
            goto L_0x0067
        L_0x0066:
            r0 = 1
        L_0x0067:
            if (r0 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r1 = 0
        L_0x006b:
            if (r1 == 0) goto L_0x0076
            android.graphics.RectF r0 = r5.f323
            r2 = 127(0x7f, float:1.78E-43)
            r3 = 31
            r6.saveLayerAlpha(r0, r2, r3)
        L_0x0076:
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7534()
            if (r0 == 0) goto L_0x0087
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7534()
            r0.draw(r6)
        L_0x0087:
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7532()
            r0.draw(r6)
            android.graphics.Rect r0 = r5.f320
            r2 = 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L_0x00b3
            int r3 = r0.right
            int r0 = r0.left
            if (r3 == r0) goto L_0x00b3
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            int r0 = r0.mo7543()
            int r3 = r3 - r0
            android.graphics.Rect r0 = r5.f320
            int r0 = r0.left
            int r3 = r3 - r0
            if (r3 <= 0) goto L_0x00b3
            android.graphics.Rect r4 = r5.f322
            int r4 = r4.left
            int r4 = r4 - r0
            int r4 = r4 * 255
            int r2 = r4 / r3
        L_0x00b3:
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7536()
            if (r0 == 0) goto L_0x00cd
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7536()
            r0.setAlpha(r2)
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7536()
            r0.draw(r6)
        L_0x00cd:
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7535()
            r0.setAlpha(r2)
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7535()
            r0.draw(r6)
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7541()
            if (r0 == 0) goto L_0x00f0
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7541()
            r0.draw(r6)
        L_0x00f0:
            com.wpengapp.baseui.widget.SwitchButton$ށ r0 = r5.f319
            android.graphics.drawable.Drawable r0 = r0.mo7540()
            r0.draw(r6)
            if (r1 == 0) goto L_0x00fe
            r6.restore()
        L_0x00fe:
            boolean r0 = f317
            if (r0 == 0) goto L_0x0138
            android.graphics.Paint r0 = r5.f333
            java.lang.String r1 = "#AA0000"
            int r1 = android.graphics.Color.parseColor(r1)
            r0.setColor(r1)
            android.graphics.Rect r0 = r5.f321
            android.graphics.Paint r1 = r5.f333
            r6.drawRect(r0, r1)
            android.graphics.Paint r0 = r5.f333
            java.lang.String r1 = "#00FF00"
            int r1 = android.graphics.Color.parseColor(r1)
            r0.setColor(r1)
            android.graphics.Rect r0 = r5.f320
            android.graphics.Paint r1 = r5.f333
            r6.drawRect(r0, r1)
            android.graphics.Paint r0 = r5.f333
            java.lang.String r1 = "#0000FF"
            int r1 = android.graphics.Color.parseColor(r1)
            r0.setColor(r1)
            android.graphics.Rect r0 = r5.f322
            android.graphics.Paint r1 = r5.f333
            r6.drawRect(r0, r1)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.baseui.widget.SwitchButton.onDraw(android.graphics.Canvas):void");
    }

    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        float r1 = (float) this.f319.mo7543();
        C0432 r2 = this.f319;
        if (r2.f371 <= 0.0f) {
            r2.f371 = 1.75f;
        }
        int paddingLeft = (int) ((r1 * r2.f371) + ((float) getPaddingLeft()) + ((float) getPaddingRight()));
        C0432 r22 = this.f319;
        int i3 = r22.f363 + r22.f364;
        if (i3 > 0) {
            paddingLeft += i3;
        }
        if (mode == 1073741824) {
            paddingLeft = Math.max(size, paddingLeft);
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(size, paddingLeft);
        }
        Rect rect = this.f319.f372;
        int i4 = rect.left + rect.right + paddingLeft;
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int paddingBottom = getPaddingBottom() + getPaddingTop() + this.f319.mo7542();
        C0432 r4 = this.f319;
        int i5 = r4.f361 + r4.f362;
        if (i5 > 0) {
            paddingBottom += i5;
        }
        if (mode2 == 1073741824) {
            paddingBottom = Math.max(size2, paddingBottom);
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingBottom = Math.min(size2, paddingBottom);
        }
        Rect rect2 = this.f319.f372;
        setMeasuredDimension(i4, rect2.top + rect2.bottom + paddingBottom);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mo7522();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r0 != 3) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.f326
            r1 = 0
            if (r0 != 0) goto L_0x0088
            boolean r0 = r9.isEnabled()
            if (r0 != 0) goto L_0x000d
            goto L_0x0088
        L_0x000d:
            int r0 = r10.getAction()
            float r2 = r10.getX()
            float r3 = r9.f327
            float r2 = r2 - r3
            float r3 = r10.getY()
            float r4 = r9.f328
            float r3 = r3 - r4
            boolean r4 = r9.f318
            r4 = 1
            if (r0 == 0) goto L_0x0068
            if (r0 == r4) goto L_0x003c
            r5 = 2
            if (r0 == r5) goto L_0x002d
            r5 = 3
            if (r0 == r5) goto L_0x003c
            goto L_0x0084
        L_0x002d:
            float r10 = r10.getX()
            float r0 = r9.f329
            float r0 = r10 - r0
            int r0 = (int) r0
            r9.mo7523((int) r0)
            r9.f329 = r10
            goto L_0x0084
        L_0x003c:
            r9.setPressed(r1)
            boolean r0 = r9.getStatusBasedOnPos()
            long r5 = r10.getEventTime()
            long r7 = r10.getDownTime()
            long r5 = r5 - r7
            float r10 = (float) r5
            int r1 = r9.f331
            float r5 = (float) r1
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0064
            float r1 = (float) r1
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0064
            int r1 = r9.f332
            float r1 = (float) r1
            int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x0064
            r9.performClick()
            goto L_0x0084
        L_0x0064:
            r9.mo7524((boolean) r0)
            goto L_0x0084
        L_0x0068:
            android.view.ViewParent r0 = r9.getParent()
            if (r0 == 0) goto L_0x0071
            r0.requestDisallowInterceptTouchEvent(r4)
        L_0x0071:
            float r0 = r10.getX()
            r9.f327 = r0
            float r10 = r10.getY()
            r9.f328 = r10
            float r10 = r9.f327
            r9.f329 = r10
            r9.setPressed(r4)
        L_0x0084:
            r9.invalidate()
            return r4
        L_0x0088:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.baseui.widget.SwitchButton.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void setChecked(boolean z) {
        mo7525(z, true);
    }

    public void setConfiguration(C0432.C0433 r3) {
        if (r3 != null) {
            this.f319 = new C0432(r3, (SwitchButton) null);
            this.f324.mo7528(this.f319.f369);
            int i = this.f319.f367;
            setPadding(i, i, i, i);
            requestLayout();
            mo7522();
            setChecked(this.f318);
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f335 = onCheckedChangeListener;
    }

    public void toggle() {
        mo7526(true);
    }

    /* renamed from: com.wpengapp.baseui.widget.SwitchButton$֏ */
    static class C0427 {

        /* renamed from: ֏ */
        public static int f336 = 256;

        /* renamed from: ؠ */
        public static int f337 = 7;

        /* renamed from: ހ */
        public static int f338 = 8;

        /* renamed from: ށ */
        public C0430 f339 = new C0430((SwitchButton) null);

        /* renamed from: ނ */
        public C0428 f340;

        /* renamed from: ރ */
        public boolean f341 = false;

        /* renamed from: ބ */
        public int f342;

        /* renamed from: ޅ */
        public int f343;

        /* renamed from: ކ */
        public int f344;

        /* renamed from: އ */
        public int f345 = f337;

        /* renamed from: com.wpengapp.baseui.widget.SwitchButton$֏$֏ */
        interface C0428 {
        }

        /* renamed from: com.wpengapp.baseui.widget.SwitchButton$֏$ؠ */
        class C0429 implements Runnable {
            public C0429() {
            }

            public void run() {
                C0427 r0 = C0427.this;
                if (r0.f341) {
                    C0431 r1 = (C0431) r0.f340;
                    SwitchButton.this.mo7523(r0.f342);
                    SwitchButton.this.postInvalidate();
                    C0431 r02 = (C0431) C0427.this.f340;
                    if (SwitchButton.this.f322.right < SwitchButton.this.f320.right && SwitchButton.this.f322.left > SwitchButton.this.f320.left) {
                        Message obtainMessage = C0427.this.f339.obtainMessage();
                        obtainMessage.what = C0427.f336;
                        obtainMessage.obj = this;
                        C0427.this.f339.sendMessageDelayed(obtainMessage, (long) C0427.f338);
                        return;
                    }
                    C0427 r03 = C0427.this;
                    r03.f341 = false;
                    C0431 r04 = (C0431) r03.f340;
                    SwitchButton switchButton = SwitchButton.this;
                    switchButton.mo7527(switchButton.getStatusBasedOnPos(), true);
                    boolean unused = SwitchButton.this.f326 = false;
                }
            }
        }

        /* renamed from: ֏ */
        public void mo7528(int i) {
            if (i <= 0) {
                this.f345 = f337;
            } else {
                this.f345 = i;
            }
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: ؠ */
    public void mo7526(boolean z) {
        if (z) {
            mo7524(!this.f318);
        } else {
            setChecked(!this.f318);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f325 = new C0431();
        this.f326 = false;
        this.f334 = null;
        this.f331 = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f332 = ViewConfiguration.getTapTimeout() + ViewConfiguration.getPressedStateDuration();
        C0427 r1 = new C0427();
        C0431 r2 = this.f325;
        if (r2 != null) {
            r1.f340 = r2;
            this.f324 = r1;
            this.f334 = new Rect();
            if (f317) {
                this.f333 = new Paint();
                this.f333.setStyle(Paint.Style.STROKE);
            }
            int i2 = Build.VERSION.SDK_INT;
            setLayerType(1, (Paint) null);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SwitchButton);
            float f = context.getResources().getDisplayMetrics().density;
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_thumb_margin, 0);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_thumb_marginTop, 0);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_thumb_marginLeft, 0);
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_thumb_marginRight, 0);
            int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_thumb_marginBottom, 0);
            int i3 = (int) (24.0f * f * 0.88f);
            int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_thumb_width, i3);
            int dimensionPixelSize7 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_thumb_height, i3);
            int dimensionPixelSize8 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_insetLeft, 0);
            int dimensionPixelSize9 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_insetTop, 0);
            int dimensionPixelSize10 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_insetRight, 0);
            int dimensionPixelSize11 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_insetBottom, 0);
            int color = obtainStyledAttributes.getColor(R$styleable.SwitchButton_offFrameColor, -2565928);
            int color2 = obtainStyledAttributes.getColor(R$styleable.SwitchButton_onFrameColor, -14571917);
            int color3 = obtainStyledAttributes.getColor(R$styleable.SwitchButton_thumbFrameColor, -2565928);
            int i4 = obtainStyledAttributes.getInt(R$styleable.SwitchButton_cornerRadius, 1000);
            int i5 = color;
            float f2 = obtainStyledAttributes.getFloat(R$styleable.SwitchButton_measureFactor, 1.75f);
            int i6 = dimensionPixelSize11;
            int dimensionPixelSize12 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SwitchButton_frame_size, 0);
            int integer = obtainStyledAttributes.getInteger(R$styleable.SwitchButton_animationVelocity, -1);
            C0432.C0433 r0 = C0432.m315(f);
            r0.mo7546(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            r0.mo7546(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize4, dimensionPixelSize5);
            float f3 = (float) i4;
            r0.f392 = f3;
            r0.mo7545(dimensionPixelSize6, dimensionPixelSize7);
            if (f2 <= 0.0f) {
                r0.f393 = 1.75f;
            }
            r0.f393 = f2;
            r0.f394.left = dimensionPixelSize8 > 0 ? -dimensionPixelSize8 : dimensionPixelSize8;
            r0.f394.top = dimensionPixelSize9 > 0 ? -dimensionPixelSize9 : dimensionPixelSize9;
            r0.f394.right = dimensionPixelSize10 > 0 ? -dimensionPixelSize10 : dimensionPixelSize10;
            r0.f394.bottom = i6 > 0 ? -i6 : i6;
            r0.f391 = integer;
            r0.f390 = dimensionPixelSize12;
            r0.f382 = i5;
            r0.f383 = color2;
            r0.f381 = color3;
            C0432.C0433 r7 = r0;
            TypedArray typedArray = obtainStyledAttributes;
            float f4 = f3;
            int i7 = i4;
            r7.f376 = mo7521(typedArray, R$styleable.SwitchButton_offDrawable, R$styleable.SwitchButton_offColor, -723724, i7);
            r7.f375 = mo7521(typedArray, R$styleable.SwitchButton_onDrawable, R$styleable.SwitchButton_onColor, -14038636, i7);
            Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.SwitchButton_thumbDrawable);
            if (drawable == null) {
                int color4 = obtainStyledAttributes.getColor(R$styleable.SwitchButton_thumbColor, -1);
                int color5 = obtainStyledAttributes.getColor(R$styleable.SwitchButton_thumbPressedColor, SwipeRefreshLayout.CIRCLE_BG_LIGHT);
                StateListDrawable stateListDrawable = new StateListDrawable();
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(f4);
                gradientDrawable.setColor(color4);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(f4);
                gradientDrawable2.setColor(color5);
                stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
                stateListDrawable.addState(new int[0], gradientDrawable);
                drawable = stateListDrawable;
            }
            r7.f374 = drawable;
            obtainStyledAttributes.recycle();
            setConfiguration(r7);
            setChecked(true);
            return;
        }
        throw new IllegalArgumentException("onAnimateListener can not be null");
    }

    /* renamed from: ֏ */
    public final Drawable mo7521(TypedArray typedArray, int i, int i2, int i3, int i4) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable != null) {
            return drawable;
        }
        int color = typedArray.getColor(i2, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) i4);
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }

    /* renamed from: ؠ */
    public final void mo7527(boolean z, boolean z2) {
        boolean z3 = z2 && this.f318 != z;
        this.f318 = z;
        OnCheckedChangeListener onCheckedChangeListener = this.f335;
        if (onCheckedChangeListener != null && z3) {
            onCheckedChangeListener.onCheckedChanged(this, this.f318);
        }
        super.setChecked(z);
    }

    /* renamed from: ֏ */
    public final void mo7522() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.f321 = null;
        } else {
            if (this.f321 == null) {
                this.f321 = new Rect();
            }
            int paddingLeft = getPaddingLeft();
            int i = this.f319.f363;
            int i2 = paddingLeft + (i > 0 ? 0 : -i);
            int paddingRight = measuredWidth - getPaddingRight();
            int i3 = this.f319.f364;
            int i4 = (paddingRight - (i3 > 0 ? 0 : -i3)) + (-this.f319.mo7538());
            int paddingTop = getPaddingTop();
            int i5 = this.f319.f361;
            int i6 = paddingTop + (i5 > 0 ? 0 : -i5);
            int paddingBottom = measuredHeight - getPaddingBottom();
            int i7 = this.f319.f362;
            this.f321.set(i2, i6, i4, (paddingBottom - (i7 > 0 ? 0 : -i7)) + (-this.f319.mo7539()));
        }
        int measuredWidth2 = getMeasuredWidth();
        int measuredHeight2 = getMeasuredHeight();
        if (measuredWidth2 <= 0 || measuredHeight2 <= 0) {
            this.f320 = null;
        } else {
            if (this.f320 == null) {
                this.f320 = new Rect();
            }
            int paddingLeft2 = getPaddingLeft();
            int i8 = this.f319.f363;
            if (i8 <= 0) {
                i8 = 0;
            }
            int i9 = paddingLeft2 + i8;
            int paddingRight2 = measuredWidth2 - getPaddingRight();
            int i10 = this.f319.f364;
            if (i10 <= 0) {
                i10 = 0;
            }
            int i11 = (paddingRight2 - i10) + (-this.f319.mo7538());
            int paddingTop2 = getPaddingTop();
            int i12 = this.f319.f361;
            if (i12 <= 0) {
                i12 = 0;
            }
            int i13 = paddingTop2 + i12;
            int paddingBottom2 = measuredHeight2 - getPaddingBottom();
            int i14 = this.f319.f362;
            if (i14 <= 0) {
                i14 = 0;
            }
            this.f320.set(i9, i13, i11, (paddingBottom2 - i14) + (-this.f319.mo7539()));
            Rect rect = this.f320;
            int i15 = rect.left;
            this.f330 = (float) ((((rect.right - i15) - this.f319.mo7543()) / 2) + i15);
        }
        int measuredWidth3 = getMeasuredWidth();
        int measuredHeight3 = getMeasuredHeight();
        if (measuredWidth3 <= 0 || measuredHeight3 <= 0) {
            this.f322 = null;
        } else {
            if (this.f322 == null) {
                this.f322 = new Rect();
            }
            int r0 = this.f318 ? this.f320.right - this.f319.mo7543() : this.f320.left;
            int i16 = this.f320.top;
            this.f322.set(r0, i16, this.f319.mo7543() + r0, this.f319.mo7542() + i16);
        }
        if (this.f321 != null) {
            this.f319.mo7535().setBounds(this.f321);
            this.f319.mo7532().setBounds(this.f321);
        }
        if (this.f322 != null) {
            this.f319.mo7540().setBounds(this.f322);
        }
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.f323 = new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    /* renamed from: ֏ */
    public void mo7525(boolean z, boolean z2) {
        if (this.f322 != null) {
            mo7523(z ? getMeasuredWidth() : -getMeasuredWidth());
        }
        mo7527(z, z2);
    }

    /* renamed from: ֏ */
    public void mo7524(boolean z) {
        if (!this.f326) {
            int i = this.f322.left;
            int r6 = z ? this.f320.right - this.f319.mo7543() : this.f320.left;
            C0427 r1 = this.f324;
            boolean z2 = true;
            r1.f341 = true;
            r1.f343 = i;
            r1.f344 = r6;
            int i2 = r1.f345;
            r1.f342 = i2;
            int i3 = r1.f344;
            int i4 = r1.f343;
            if (i3 > i4) {
                r1.f342 = Math.abs(i2);
            } else if (i3 < i4) {
                r1.f342 = -Math.abs(i2);
            } else {
                r1.f341 = false;
                ((C0431) r1.f340).mo7531();
                return;
            }
            boolean unused = SwitchButton.this.f326 = true;
            C0427.C0429 r62 = new C0427.C0429();
            C0427 r0 = C0427.this;
            if (r0.f341) {
                C0431 r12 = (C0431) r0.f340;
                SwitchButton.this.mo7523(r0.f342);
                SwitchButton.this.postInvalidate();
                C0431 r02 = (C0431) C0427.this.f340;
                if (SwitchButton.this.f322.right >= SwitchButton.this.f320.right || SwitchButton.this.f322.left <= SwitchButton.this.f320.left) {
                    z2 = false;
                }
                if (z2) {
                    Message obtainMessage = C0427.this.f339.obtainMessage();
                    obtainMessage.what = C0427.f336;
                    obtainMessage.obj = r62;
                    C0427.this.f339.sendMessageDelayed(obtainMessage, (long) C0427.f338);
                    return;
                }
                C0427 r63 = C0427.this;
                r63.f341 = false;
                ((C0431) r63.f340).mo7531();
            }
        }
    }

    /* renamed from: ֏ */
    public final void mo7523(int i) {
        Rect rect = this.f322;
        int i2 = rect.left + i;
        int i3 = rect.right + i;
        int i4 = this.f320.left;
        if (i2 < i4) {
            i3 = this.f319.mo7543() + i4;
        } else {
            i4 = i2;
        }
        int i5 = this.f320.right;
        if (i3 > i5) {
            i4 = i5 - this.f319.mo7543();
            i3 = i5;
        }
        Rect rect2 = this.f322;
        rect2.set(i4, rect2.top, i3, rect2.bottom);
        this.f319.mo7540().setBounds(this.f322);
    }
}
