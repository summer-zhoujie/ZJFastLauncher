package android.support.p000v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.view.ViewCompat;
import android.view.animation.Animation;
import android.widget.ImageView;

/* renamed from: android.support.v4.widget.CircleImageView */
public class CircleImageView extends ImageView {
    public static final int FILL_SHADOW_COLOR = 1023410176;
    public static final int KEY_SHADOW_COLOR = 503316480;
    public static final int SHADOW_ELEVATION = 4;
    public static final float SHADOW_RADIUS = 3.5f;
    public static final float X_OFFSET = 0.0f;
    public static final float Y_OFFSET = 1.75f;
    public Animation.AnimationListener mListener;
    public int mShadowRadius;

    /* renamed from: android.support.v4.widget.CircleImageView$OvalShadow */
    private class OvalShadow extends OvalShape {
        public RadialGradient mRadialGradient;
        public Paint mShadowPaint = new Paint();

        public OvalShadow(int i) {
            CircleImageView.this.mShadowRadius = i;
            updateRadialGradient((int) rect().width());
        }

        private void updateRadialGradient(int i) {
            float f = (float) (i / 2);
            this.mRadialGradient = new RadialGradient(f, f, (float) CircleImageView.this.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.mShadowPaint.setShader(this.mRadialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = CircleImageView.this.getWidth() / 2;
            float f = (float) width;
            float height = (float) (CircleImageView.this.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.mShadowPaint);
            canvas.drawCircle(f, height, (float) (width - CircleImageView.this.mShadowRadius), paint);
        }

        public void onResize(float f, float f2) {
            super.onResize(f, f2);
            updateRadialGradient((int) f);
        }
    }

    public CircleImageView(Context context, int i) {
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        this.mShadowRadius = (int) (3.5f * f);
        int i2 = Build.VERSION.SDK_INT;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        ViewCompat.IMPL.setElevation(this, f * 4.0f);
        shapeDrawable.getPaint().setColor(i);
        ViewCompat.IMPL.setBackground(this, shapeDrawable);
    }

    private boolean elevationSupported() {
        int i = Build.VERSION.SDK_INT;
        return true;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = Build.VERSION.SDK_INT;
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(ContextCompat.getColor(getContext(), i));
    }
}
