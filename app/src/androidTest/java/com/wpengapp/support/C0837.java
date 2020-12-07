package com.wpengapp.support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.support.annotation.LayoutRes;
import android.support.p000v4.content.ContextCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.wpengapp.baseui.R$drawable;
import com.wpengapp.baseui.R$id;
import com.wpengapp.baseui.R$layout;

/* renamed from: com.wpengapp.support.إ */
/* compiled from: FloatBall */
public class C0837 implements View.OnTouchListener {

    /* renamed from: ֏ */
    public FloatWindow f2182;

    /* renamed from: ؠ */
    public View f2183;

    /* renamed from: ހ */
    public View f2184;

    /* renamed from: ށ */
    public View f2185;

    /* renamed from: ނ */
    public C0838 f2186;

    /* renamed from: ރ */
    public int f2187 = 1;

    /* renamed from: ބ */
    public float f2188;

    /* renamed from: ޅ */
    public float f2189;

    /* renamed from: ކ */
    public float f2190;

    /* renamed from: އ */
    public float f2191;

    /* renamed from: ވ */
    public float f2192;

    /* renamed from: މ */
    public float f2193;

    /* renamed from: ފ */
    public float f2194;

    /* renamed from: ދ */
    public byte f2195 = -2;

    /* renamed from: ތ */
    public int f2196;

    /* renamed from: ލ */
    public Vibrator f2197;

    /* renamed from: ގ */
    public boolean f2198 = true;

    /* renamed from: ޏ */
    public long f2199 = 80;

    /* renamed from: ސ */
    public long f2200 = 300;

    /* renamed from: ޑ */
    public SparseArray<C0839> f2201 = new SparseArray<>();

    /* renamed from: ޒ */
    public byte f2202 = 8;

    /* renamed from: ޓ */
    public float f2203;

    /* renamed from: ޔ */
    public float f2204;

    /* renamed from: ޕ */
    public float f2205;

    /* renamed from: ޖ */
    public float f2206;

    /* renamed from: ޗ */
    public boolean f2207;

    /* renamed from: ޘ */
    public boolean f2208;

    /* renamed from: ޙ */
    public boolean f2209;

    /* renamed from: ޚ */
    public boolean f2210;

    /* renamed from: ޛ */
    public boolean f2211;

    /* renamed from: ޜ */
    public byte f2212 = -2;

    /* renamed from: ޝ */
    public int f2213;

    /* renamed from: ޞ */
    public Runnable f2214 = new C1268(this);

    /* renamed from: ޟ */
    public Runnable f2215 = new C0685(this);

    /* renamed from: ޠ */
    public Runnable f2216 = new C0743(this);

    /* renamed from: com.wpengapp.support.إ$֏ */
    /* compiled from: FloatBall */
    public interface C0838 {
    }

    /* renamed from: com.wpengapp.support.إ$ؠ */
    /* compiled from: FloatBall */
    private class C0839 {

        /* renamed from: ֏ */
        public byte f2217;

        /* renamed from: ؠ */
        public byte f2218 = 0;

        /* renamed from: ހ */
        public float f2219;

        /* renamed from: ށ */
        public float f2220;

        public C0839(C0837 r1, byte b, float f, float f2) {
            this.f2217 = b;
            this.f2219 = f;
            this.f2220 = f2;
        }
    }

    public C0837(Context context, int i, boolean z, @LayoutRes int i2, int i3) {
        this.f2197 = (Vibrator) context.getSystemService("vibrator");
        this.f2196 = i3 / 2;
        this.f2182 = new FloatWindow(context, new WindowManager.LayoutParams(i3, i3, i, z ? 262920 : 262408, -2), i2);
        this.f2183 = this.f2182.f2735;
        this.f2183.setContentDescription("FloatBall");
        this.f2184 = this.f2183.findViewById(R$id.foreground);
        this.f2185 = this.f2183.findViewById(R$id.background);
        if (i2 == R$layout.baseui_float_ball) {
            Drawable drawable = ContextCompat.getDrawable(AppUtils.getApplication(), R$drawable.baseui_float_ball_skin_01_fore);
            this.f2185.setBackground(ContextCompat.getDrawable(AppUtils.getApplication(), R$drawable.baseui_float_ball_skin_01_back));
            this.f2184.setBackground(drawable);
        }
        this.f2184.post(new C0690(this));
    }

    /* renamed from: ބ */
    public static /* synthetic */ void m2229(C0837 r4) {
        r4.mo8734(20);
        C0839 r0 = r4.f2201.get(-1);
        if (r0 != null) {
            if (r0.f2218 == 0) {
                r4.mo8737();
                return;
            }
            C0838 r1 = r4.f2186;
            if (r1 != null) {
                ((C1044) r1).mo9180();
            }
            if (r0.f2218 == 2) {
                r4.f2212 = r0.f2217;
                r4.f2183.postDelayed(r4.f2214, r4.f2200);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v54, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v64, resolved type: android.graphics.Point} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v68, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v69, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v70, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v71, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v72, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v73, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v74, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v75, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v76, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v77, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v78, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v79, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v80, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v81, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v82, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v83, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v84, resolved type: com.wpengapp.support.إ$ؠ} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(View r18, android.view.MotionEvent r19) {
        /*
            r17 = this;
            r0 = r17
            int r1 = r19.getPointerCount()
            r2 = 1
            if (r1 <= r2) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r19.getActionMasked()
            r3 = 1067030938(0x3f99999a, float:1.2)
            r4 = 100
            r6 = 0
            if (r1 == 0) goto L_0x030f
            if (r1 == r2) goto L_0x0257
            r8 = 4
            r9 = 3
            r10 = 2
            if (r1 == r10) goto L_0x002c
            if (r1 == r9) goto L_0x0257
            if (r1 == r8) goto L_0x0024
            goto L_0x0347
        L_0x0024:
            com.wpengapp.support.إ$֏ r1 = r0.f2186
            if (r1 == 0) goto L_0x0347
            com.wpengapp.support.ই r1 = (com.wpengapp.support.C1044) r1
            goto L_0x0347
        L_0x002c:
            boolean r1 = r0.f2211
            if (r1 == 0) goto L_0x0047
            com.wpengapp.support.ߗ r1 = r0.f2182
            float r3 = r19.getRawX()
            int r3 = (int) r3
            int r4 = r0.f2196
            int r3 = r3 - r4
            float r4 = r19.getRawY()
            int r4 = (int) r4
            int r5 = r0.f2196
            int r4 = r4 - r5
            r1.mo9028(r3, r4)
            goto L_0x0347
        L_0x0047:
            byte r1 = r0.f2202
            r3 = 0
            if (r1 != 0) goto L_0x00bb
            float r1 = r19.getX()
            float r8 = r19.getY()
            boolean r9 = r0.f2208
            if (r9 != 0) goto L_0x009d
            float r3 = r0.f2203
            float r3 = r1 - r3
            float r9 = r0.f2204
            float r9 = r8 - r9
            float r10 = r0.f2188
            float r10 = r10 + r3
            float r3 = r0.f2189
            float r3 = r3 + r9
            boolean r3 = r0.mo8736(r10, r3)
            if (r3 != 0) goto L_0x006e
            goto L_0x0347
        L_0x006e:
            r0.f2208 = r2
            android.view.View r3 = r0.f2183
            java.lang.Runnable r9 = r0.f2215
            r3.removeCallbacks(r9)
            android.view.View r3 = r0.f2183
            java.lang.Runnable r9 = r0.f2214
            r3.removeCallbacks(r9)
            android.graphics.Point r3 = r0.mo8731((float) r1, (float) r8)
            android.view.View r9 = r0.f2184
            android.view.ViewPropertyAnimator r9 = r9.animate()
            int r10 = r3.x
            float r10 = (float) r10
            android.view.ViewPropertyAnimator r9 = r9.x(r10)
            int r10 = r3.y
            float r10 = (float) r10
            android.view.ViewPropertyAnimator r9 = r9.y(r10)
            android.view.ViewPropertyAnimator r6 = r9.setStartDelay(r6)
            r6.setDuration(r4)
        L_0x009d:
            if (r3 != 0) goto L_0x00b3
            android.graphics.Point r1 = r0.mo8731((float) r1, (float) r8)
            android.view.View r3 = r0.f2184
            int r4 = r1.x
            float r4 = (float) r4
            r3.setX(r4)
            android.view.View r3 = r0.f2184
            int r1 = r1.y
            float r1 = (float) r1
            r3.setY(r1)
        L_0x00b3:
            com.wpengapp.support.إ$֏ r1 = r0.f2186
            if (r1 == 0) goto L_0x0347
            com.wpengapp.support.ই r1 = (com.wpengapp.support.C1044) r1
            goto L_0x0347
        L_0x00bb:
            float r1 = r19.getX()
            float r11 = r19.getY()
            float r12 = r0.f2203
            float r1 = r1 - r12
            float r12 = r0.f2204
            float r11 = r11 - r12
            float r12 = r0.f2188
            float r12 = r12 + r1
            float r13 = r0.f2189
            float r13 = r13 + r11
            boolean r14 = r0.mo8736(r12, r13)
            if (r14 != 0) goto L_0x00d7
            goto L_0x01f9
        L_0x00d7:
            byte r14 = r0.f2202
            r15 = 8
            if (r14 != r8) goto L_0x012d
            float r1 = java.lang.Math.abs(r1)
            float r9 = java.lang.Math.abs(r11)
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x010b
            float r1 = r0.f2191
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x00fa
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r2)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x00fa:
            float r1 = r0.f2193
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x01f9
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r8)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x010b:
            float r1 = r0.f2192
            int r1 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x011c
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r10)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x011c:
            float r1 = r0.f2194
            int r1 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x01f9
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r15)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x012d:
            if (r14 != r15) goto L_0x01f9
            r3 = 0
            int r12 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r12 != 0) goto L_0x0137
            r1 = 981668463(0x3a83126f, float:0.001)
        L_0x0137:
            float r12 = r11 / r1
            float r12 = java.lang.Math.abs(r12)
            r13 = 1054110392(0x3ed472b8, float:0.41493773)
            r14 = 1075461489(0x401a3d71, float:2.41)
            int r16 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r16 >= 0) goto L_0x0174
            int r16 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r16 >= 0) goto L_0x0174
            int r1 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x015a
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r10)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x015a:
            int r1 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r1 <= 0) goto L_0x0169
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r9)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x0169:
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r2)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x0174:
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x01a4
            int r9 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x01a4
            int r1 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x018b
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r10)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x018b:
            int r1 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r1 <= 0) goto L_0x019a
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            r3 = 6
            java.lang.Object r1 = r1.get(r3)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x019a:
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r8)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x01a4:
            if (r1 < 0) goto L_0x01d2
            int r1 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x01d2
            int r1 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x01b8
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r15)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x01b8:
            int r1 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r1 <= 0) goto L_0x01c8
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            r3 = 12
            java.lang.Object r1 = r1.get(r3)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x01c8:
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r8)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x01d2:
            int r1 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x01e0
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r15)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x01e0:
            int r1 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r1 <= 0) goto L_0x01f0
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            r3 = 9
            java.lang.Object r1 = r1.get(r3)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
            goto L_0x01f9
        L_0x01f0:
            android.util.SparseArray<com.wpengapp.support.إ$ؠ> r1 = r0.f2201
            java.lang.Object r1 = r1.get(r2)
            r3 = r1
            com.wpengapp.support.إ$ؠ r3 = (com.wpengapp.support.C0837.C0839) r3
        L_0x01f9:
            if (r3 != 0) goto L_0x01fd
            goto L_0x0347
        L_0x01fd:
            byte r1 = r3.f2217
            byte r8 = r0.f2195
            if (r1 != r8) goto L_0x0205
            goto L_0x0347
        L_0x0205:
            r0.f2207 = r2
            r0.f2195 = r1
            android.view.View r1 = r0.f2183
            java.lang.Runnable r8 = r0.f2215
            r1.removeCallbacks(r8)
            android.view.View r1 = r0.f2183
            java.lang.Runnable r8 = r0.f2214
            r1.removeCallbacks(r8)
            byte r1 = r3.f2218
            if (r1 != 0) goto L_0x0220
            r17.mo8737()
            goto L_0x0347
        L_0x0220:
            android.view.View r1 = r0.f2184
            android.view.ViewPropertyAnimator r1 = r1.animate()
            float r8 = r3.f2219
            android.view.ViewPropertyAnimator r1 = r1.x(r8)
            float r8 = r3.f2220
            android.view.ViewPropertyAnimator r1 = r1.y(r8)
            android.view.ViewPropertyAnimator r1 = r1.setStartDelay(r6)
            r1.setDuration(r4)
            com.wpengapp.support.إ$֏ r1 = r0.f2186
            if (r1 == 0) goto L_0x0244
            byte r4 = r3.f2217
            com.wpengapp.support.ই r1 = (com.wpengapp.support.C1044) r1
            r1.mo9181(r4)
        L_0x0244:
            byte r1 = r3.f2218
            if (r1 != r10) goto L_0x0347
            byte r1 = r3.f2217
            r0.f2212 = r1
            android.view.View r1 = r0.f2183
            java.lang.Runnable r3 = r0.f2214
            long r4 = r0.f2200
            r1.postDelayed(r3, r4)
            goto L_0x0347
        L_0x0257:
            android.view.View r1 = r0.f2183
            java.lang.Runnable r8 = r0.f2215
            r1.removeCallbacks(r8)
            android.view.View r1 = r0.f2183
            java.lang.Runnable r8 = r0.f2214
            r1.removeCallbacks(r8)
            android.view.View r1 = r0.f2184
            android.view.ViewPropertyAnimator r1 = r1.animate()
            android.view.ViewPropertyAnimator r1 = r1.scaleX(r3)
            android.view.ViewPropertyAnimator r1 = r1.scaleY(r3)
            android.view.ViewPropertyAnimator r1 = r1.setStartDelay(r6)
            android.view.ViewPropertyAnimator r1 = r1.setDuration(r4)
            com.wpengapp.support.າ r3 = new com.wpengapp.support.າ
            r3.<init>(r0)
            r1.withEndAction(r3)
            com.wpengapp.support.إ$֏ r1 = r0.f2186
            if (r1 == 0) goto L_0x02ca
            float r3 = r0.f2205
            com.wpengapp.support.ߗ r4 = r0.f2182
            android.view.WindowManager$LayoutParams r4 = r4.f2734
            int r5 = r4.x
            float r5 = (float) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x029b
            float r3 = r0.f2206
            int r4 = r4.y
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
        L_0x029b:
            com.wpengapp.support.ߗ r3 = r0.f2182
            android.view.WindowManager$LayoutParams r3 = r3.f2734
            int r4 = r3.x
            int r3 = r3.y
            com.wpengapp.support.ই r1 = (com.wpengapp.support.C1044) r1
            boolean r1 = com.wpengapp.support.C1032.m2760()
            if (r1 == 0) goto L_0x02b4
            com.wpengapp.support.ס$֏ r1 = com.wpengapp.support.C0826.m2169()
            int r1 = r1.f2152
            int r1 = r1 - r3
            r3 = r4
            goto L_0x02b5
        L_0x02b4:
            r1 = r4
        L_0x02b5:
            android.content.SharedPreferences r4 = com.wpengapp.support.C1032.f2958
            android.content.SharedPreferences$Editor r4 = r4.edit()
            java.lang.String r5 = "x"
            android.content.SharedPreferences$Editor r1 = r4.putInt(r5, r1)
            java.lang.String r4 = "y"
            android.content.SharedPreferences$Editor r1 = r1.putInt(r4, r3)
            r1.apply()
        L_0x02ca:
            boolean r1 = r0.f2207
            if (r1 != 0) goto L_0x02fe
            boolean r1 = r0.f2208
            if (r1 != 0) goto L_0x02fe
            boolean r1 = r0.f2210
            if (r1 != 0) goto L_0x02fe
            boolean r1 = r0.f2211
            if (r1 != 0) goto L_0x02fe
            r3 = 20
            r0.mo8734((long) r3)
            android.view.View r1 = r0.f2183
            java.lang.Runnable r3 = r0.f2216
            r1.removeCallbacks(r3)
            int r1 = r0.f2213
            int r1 = r1 + r2
            r0.f2213 = r1
            int r1 = r0.f2213
            int r3 = r0.f2187
            if (r1 != r3) goto L_0x02f5
            r17.mo8733()
            goto L_0x02fe
        L_0x02f5:
            android.view.View r1 = r0.f2183
            java.lang.Runnable r3 = r0.f2216
            r4 = 300(0x12c, double:1.48E-321)
            r1.postDelayed(r3, r4)
        L_0x02fe:
            r1 = 0
            r0.f2209 = r1
            r0.f2210 = r1
            r0.f2207 = r1
            r0.f2208 = r1
            r0.f2211 = r1
            r1 = -2
            r0.f2195 = r1
            r0.f2212 = r1
            goto L_0x0347
        L_0x030f:
            float r1 = r19.getX()
            r0.f2203 = r1
            float r1 = r19.getY()
            r0.f2204 = r1
            com.wpengapp.support.ߗ r1 = r0.f2182
            android.view.WindowManager$LayoutParams r1 = r1.f2734
            int r8 = r1.x
            float r8 = (float) r8
            r0.f2205 = r8
            int r1 = r1.y
            float r1 = (float) r1
            r0.f2206 = r1
            android.view.View r1 = r0.f2183
            java.lang.Runnable r8 = r0.f2215
            long r9 = r0.f2200
            r1.postDelayed(r8, r9)
            android.view.View r1 = r0.f2184
            android.view.ViewPropertyAnimator r1 = r1.animate()
            android.view.ViewPropertyAnimator r1 = r1.scaleX(r3)
            android.view.ViewPropertyAnimator r1 = r1.scaleY(r3)
            android.view.ViewPropertyAnimator r1 = r1.setStartDelay(r6)
            r1.setDuration(r4)
        L_0x0347:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0837.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: ؠ */
    public boolean mo8735() {
        return this.f2182.f2732;
    }

    /* renamed from: ހ */
    public void mo8737() {
        this.f2211 = true;
        if (this.f2184.getX() != this.f2188 || this.f2184.getY() != this.f2189) {
            this.f2184.animate().setDuration(100).x(this.f2188).y(this.f2189);
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2221(C0837 r7) {
        r7.f2188 = r7.f2184.getX();
        r7.f2189 = r7.f2184.getY();
        r7.f2191 = (((float) r7.f2184.getWidth()) * 0.20000005f) / 2.0f;
        r7.f2192 = (((float) r7.f2184.getHeight()) * 0.20000005f) / 2.0f;
        if (r7.f2191 == 0.0f) {
            float r0 = (float) C0826.m2168(10.0f);
            r7.f2192 = r0;
            r7.f2191 = r0;
        }
        r7.f2193 = ((float) (r7.f2183.getWidth() - r7.f2184.getWidth())) - r7.f2191;
        r7.f2194 = ((float) (r7.f2183.getHeight() - r7.f2184.getHeight())) - r7.f2192;
        float width = ((float) r7.f2183.getWidth()) / 2.0f;
        r7.f2190 = ((float) r7.f2184.getWidth()) / 2.0f;
        float f = width - (r7.f2190 * 1.2f);
        float sqrt = (float) Math.sqrt((double) ((f * f) / 2.0f));
        r7.f2201.put(-1, new C0839(r7, (byte) -1, 0.0f, 0.0f));
        r7.f2201.put(1, new C0839(r7, (byte) 1, r7.f2191, r7.f2189));
        r7.f2201.put(2, new C0839(r7, (byte) 2, r7.f2188, r7.f2192));
        r7.f2201.put(4, new C0839(r7, (byte) 4, r7.f2193, r7.f2189));
        r7.f2201.put(8, new C0839(r7, (byte) 8, r7.f2188, r7.f2194));
        SparseArray<C0839> sparseArray = r7.f2201;
        float f2 = width - sqrt;
        float f3 = f2 - r7.f2190;
        sparseArray.put(3, new C0839(r7, (byte) 3, f3, f3));
        SparseArray<C0839> sparseArray2 = r7.f2201;
        float f4 = r7.f2190;
        float f5 = width + sqrt;
        sparseArray2.put(9, new C0839(r7, (byte) 9, f2 - f4, f5 - f4));
        SparseArray<C0839> sparseArray3 = r7.f2201;
        float f6 = r7.f2190;
        sparseArray3.put(6, new C0839(r7, (byte) 6, f5 - f6, f2 - f6));
        SparseArray<C0839> sparseArray4 = r7.f2201;
        float f7 = f5 - r7.f2190;
        sparseArray4.put(12, new C0839(r7, (byte) 12, f7, f7));
        r7.f2184.animate().setInterpolator(new AccelerateDecelerateInterpolator());
        r7.f2183.setOnTouchListener(r7);
    }

    /* renamed from: ؠ */
    public final boolean mo8736(float f, float f2) {
        return f < this.f2191 || f > this.f2193 || f2 < this.f2192 || f2 > this.f2194;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: ֏ */
    public final void mo8734(long j) {
        if (this.f2198) {
            try {
                this.f2197.vibrate(j);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: ֏ */
    public C0837 mo8732(byte b, byte b2) {
        this.f2184.post(new FloatBall(this, b, b2));
        return this;
    }

    /* renamed from: ֏ */
    public final Point mo8731(float f, float f2) {
        Point point = new Point();
        int i = this.f2196;
        float f3 = f - ((float) i);
        float f4 = f2 - ((float) i);
        if (f3 == 0.0f && f4 == 0.0f) {
            point.x = (int) this.f2188;
            point.y = (int) this.f2189;
            return point;
        }
        int i2 = this.f2196;
        float f5 = ((float) i2) - this.f2191;
        float f6 = this.f2190;
        float sqrt = ((float) Math.sqrt((double) ((f4 * f4) + (f3 * f3)))) / (f5 - f6);
        point.x = (int) (((f3 / sqrt) + ((float) i2)) - f6);
        point.y = (int) (((f4 / sqrt) + ((float) i2)) - f6);
        return point;
    }

    /* renamed from: ֏ */
    public final void mo8733() {
        int i = this.f2213;
        this.f2213 = 0;
        C0838 r0 = this.f2186;
        if (r0 != null) {
            C1044 r02 = (C1044) r0;
            if (!CountLimitHelper.m997("CustomManager", 1000)) {
                C1032.m2758();
            }
        }
    }
}
