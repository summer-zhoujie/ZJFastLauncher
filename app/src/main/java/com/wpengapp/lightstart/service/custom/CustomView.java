package com.wpengapp.lightstart.service.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.p000v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.wpengapp.lightstart.R$color;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0856;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.NodeInfo;
import com.wpengapp.support.SystemUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomView extends FrameLayout {

    /* renamed from: ֏ */
    public List<NodeInfo> f535 = new ArrayList();

    /* renamed from: ؠ */
    public NodeInfo f536;

    /* renamed from: ހ */
    public Point f537;

    /* renamed from: ށ */
    public Paint f538;

    /* renamed from: ނ */
    public Paint f539;

    /* renamed from: ރ */
    public Paint f540;

    /* renamed from: ބ */
    public Paint f541;

    /* renamed from: ޅ */
    public Paint f542;

    /* renamed from: ކ */
    public int[] f543;

    /* renamed from: އ */
    public int f544;

    /* renamed from: ވ */
    public int f545;

    /* renamed from: މ */
    public int f546;

    /* renamed from: ފ */
    public int f547;

    /* renamed from: ދ */
    public int f548;

    /* renamed from: ތ */
    public int f549;

    /* renamed from: ލ */
    public boolean f550;

    /* renamed from: ގ */
    public int f551;

    /* renamed from: ޏ */
    public int f552;

    /* renamed from: ސ */
    public C0443 f553;

    /* renamed from: ޑ */
    public boolean f554;

    /* renamed from: ޒ */
    public PaintFlagsDrawFilter f555 = new PaintFlagsDrawFilter(0, 3);

    /* renamed from: ޓ */
    public float f556;

    /* renamed from: ޔ */
    public float f557;

    /* renamed from: ޕ */
    public final int f558 = C0826.m2168(12.0f);

    /* renamed from: ޖ */
    public final int f559 = C0826.m2168(9.0f);

    /* renamed from: ޗ */
    public final int f560 = C0826.m2168(10.0f);

    /* renamed from: com.wpengapp.lightstart.service.custom.CustomView$֏ */
    public interface C0443 {
        /* renamed from: ֏ */
        void mo7781(@Nullable NodeInfo r1, int i, int i2);
    }

    public CustomView(@NonNull Context context) {
        super(context);
        mo7777();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new C0856(this));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.setDrawFilter(this.f555);
        canvas.drawColor(0);
        Point point = this.f537;
        if (point != null) {
            canvas.drawCircle((float) point.x, (float) point.y, (float) this.f560, this.f542);
            Point point2 = this.f537;
            canvas.drawCircle((float) point2.x, (float) point2.y, (float) this.f559, this.f541);
            return;
        }
        NodeInfo r0 = this.f536;
        if (r0 != null) {
            Rect rect = r0.f3030;
            int max = Math.max(rect.left - this.f543[0], this.f546);
            int max2 = Math.max(rect.top - this.f543[1], this.f547);
            int min = Math.min(rect.right - this.f543[0], this.f548);
            int min2 = Math.min(rect.bottom - this.f543[1], this.f549);
            if (max < min && max2 < min2) {
                float f = (float) min2;
                int i = this.f552;
                float f2 = (float) max;
                float f3 = (float) max2;
                float f4 = (float) min;
                float f5 = f;
                canvas.drawRoundRect(f2, f3, f4, f5, (float) i, (float) i, this.f540);
                int i2 = this.f552;
                canvas.drawRoundRect(f2, f3, f4, f5, (float) i2, (float) i2, this.f539);
            }
        } else if (this.f554) {
            for (int i3 = 0; i3 < this.f535.size(); i3++) {
                Rect rect2 = this.f535.get(i3).f3030;
                int max3 = Math.max(rect2.left - this.f543[0], this.f546) + this.f551;
                int max4 = Math.max(rect2.top - this.f543[1], this.f547) + this.f551;
                int min3 = Math.min(rect2.right - this.f543[0], this.f548) - this.f551;
                int min4 = Math.min(rect2.bottom - this.f543[1], this.f549) - this.f551;
                if (max3 < min3 && max4 < min4) {
                    float f6 = (float) min4;
                    int i4 = this.f552;
                    canvas.drawRoundRect((float) max3, (float) max4, (float) min3, f6, (float) i4, (float) i4, this.f538);
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f556 = motionEvent.getRawX();
            this.f557 = motionEvent.getRawY();
        } else if (actionMasked == 1 && motionEvent.getRawX() - this.f556 < ((float) this.f558) && motionEvent.getRawY() - this.f557 < ((float) this.f558)) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            C0443 r2 = this.f553;
            if (r2 != null) {
                NodeInfo r3 = null;
                if (CollectionUtils.m1659((Collection) this.f535)) {
                    float f = Float.MAX_VALUE;
                    for (NodeInfo next : this.f535) {
                        if (next.f3030.contains(rawX, rawY)) {
                            float f2 = next.f3031;
                            if (f2 <= f) {
                                r3 = next;
                                f = f2;
                            }
                        }
                    }
                }
                r2.mo7781(r3, rawX, rawY);
            }
        }
        return true;
    }

    public void setClickableNodes(List<NodeInfo> list) {
        this.f535 = list;
    }

    public void setHeightLightNode(NodeInfo r1) {
        this.f536 = r1;
        postInvalidate();
    }

    public void setHeightLightPoint(Point point) {
        this.f537 = point;
        postInvalidate();
    }

    public void setOnNodeClickListener(C0443 r1) {
        this.f553 = r1;
    }

    /* renamed from: ֏ */
    public final void mo7777() {
        this.f538 = new Paint();
        this.f538.setColor(ContextCompat.getColor(getContext(), R$color.app_color_primary));
        this.f538.setStyle(Paint.Style.STROKE);
        this.f551 = C0826.m2168(1.2f);
        this.f538.setStrokeWidth((float) this.f551);
        this.f543 = new int[2];
        this.f552 = C0826.m2168(2.0f);
        this.f539 = new Paint(this.f538);
        this.f539.setStrokeWidth((float) C0826.m2168(2.0f));
        this.f540 = new Paint(this.f538);
        this.f540.setStyle(Paint.Style.FILL);
        this.f540.setColor(this.f538.getColor() & 872415231);
        this.f541 = new Paint();
        this.f541.setStyle(Paint.Style.FILL);
        this.f541.setColor(-868708804);
        this.f542 = new Paint();
        this.f542.setStyle(Paint.Style.FILL);
        this.f542.setColor(-855638017);
    }

    /* renamed from: ؠ */
    public /* synthetic */ void mo7779() {
        mo7780();
        invalidate();
    }

    /* renamed from: ހ */
    public void mo7780() {
        getLocationOnScreen(this.f543);
        int[] iArr = this.f543;
        this.f546 = iArr[0] >= 0 ? 0 : -iArr[0];
        int[] iArr2 = this.f543;
        this.f547 = iArr2[1] >= 0 ? 0 : -iArr2[1];
        this.f550 = SystemUtils.m3529();
        this.f544 = this.f550 ? C0826.m2169().f2153 : C0826.m2169().f2152;
        this.f545 = this.f550 ? C0826.m2169().f2152 : C0826.m2169().f2153;
        int width = getWidth();
        int[] iArr3 = this.f543;
        int i = width + iArr3[0];
        int i2 = this.f544;
        this.f548 = i <= i2 ? getWidth() : i2 - iArr3[0];
        int height = getHeight();
        int[] iArr4 = this.f543;
        int i3 = height + iArr4[1];
        int i4 = this.f545;
        this.f549 = i3 <= i4 ? getHeight() : i4 - iArr4[1];
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        mo7777();
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo7777();
    }

    /* renamed from: ֏ */
    public void mo7778(boolean z) {
        this.f554 = z;
        postInvalidate();
    }

    @RequiresApi(api = 21)
    public CustomView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        mo7777();
    }
}
