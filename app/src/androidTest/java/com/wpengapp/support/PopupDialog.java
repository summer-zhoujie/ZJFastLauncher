package com.wpengapp.support;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.wpengapp.baseui.BaseActivity;

/* renamed from: com.wpengapp.support.ه */
public class PopupDialog extends PopupWindow implements IDialog, View.OnTouchListener, View.OnKeyListener {

    /* renamed from: ֏ */
    public boolean f2323 = true;

    /* renamed from: ؠ */
    public boolean f2324 = true;

    /* renamed from: ހ */
    public BaseActivity.C0419 f2325;

    /* renamed from: ށ */
    public Context f2326;

    public PopupDialog(Context context, int i, int i2, View view) {
        super(context);
        this.f2326 = context;
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(true);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setOnTouchListener(this);
        view.setOnKeyListener(this);
        setBackgroundDrawable((Drawable) null);
        if (context instanceof BaseActivity) {
            this.f2325 = new C0997(this);
        }
    }

    public void dismiss() {
        super.dismiss();
        BaseActivity.C0419 r0 = this.f2325;
        if (r0 != null) {
            ((BaseActivity) this.f2326).mo7426(r0);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (!this.f2324 || keyEvent.getKeyCode() != 4) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            dismiss();
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        if ((r6.getX() < 0.0f || r6.getX() > ((float) getContentView().getWidth()) || r6.getY() < 0.0f || r6.getY() > ((float) getContentView().getHeight())) != false) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(View r5, android.view.MotionEvent r6) {
        /*
            r4 = this;
            boolean r5 = r4.f2324
            r0 = 0
            if (r5 == 0) goto L_0x0057
            boolean r5 = r4.f2323
            if (r5 != 0) goto L_0x000a
            goto L_0x0057
        L_0x000a:
            int r5 = r6.getAction()
            r1 = 4
            r2 = 1
            if (r5 == r1) goto L_0x0053
            int r5 = r6.getAction()
            if (r5 != 0) goto L_0x0052
            float r5 = r6.getX()
            r1 = 0
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 < 0) goto L_0x004e
            float r5 = r6.getX()
            android.view.View r3 = r4.getContentView()
            int r3 = r3.getWidth()
            float r3 = (float) r3
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x004e
            float r5 = r6.getY()
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 < 0) goto L_0x004e
            float r5 = r6.getY()
            android.view.View r6 = r4.getContentView()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r5 = 0
            goto L_0x004f
        L_0x004e:
            r5 = 1
        L_0x004f:
            if (r5 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            return r0
        L_0x0053:
            r4.dismiss()
            return r2
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.PopupDialog.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        super.showAsDropDown(view, i, i2, i3);
        BaseActivity.C0419 r1 = this.f2325;
        if (r1 != null) {
            ((BaseActivity) this.f2326).mo7418(r1);
        }
        DialogLifecycleCallbacks.m1408(this);
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        BaseActivity.C0419 r1 = this.f2325;
        if (r1 != null) {
            ((BaseActivity) this.f2326).mo7418(r1);
        }
        DialogLifecycleCallbacks.m1408(this);
    }
}
