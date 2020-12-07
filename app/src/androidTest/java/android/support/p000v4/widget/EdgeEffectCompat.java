package android.support.p000v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.widget.EdgeEffect;

/* renamed from: android.support.v4.widget.EdgeEffectCompat */
public final class EdgeEffectCompat {
    public static final EdgeEffectBaseImpl IMPL = new EdgeEffectApi21Impl();
    public EdgeEffect mEdgeEffect;

    @RequiresApi(21)
    /* renamed from: android.support.v4.widget.EdgeEffectCompat$EdgeEffectApi21Impl */
    static class EdgeEffectApi21Impl extends EdgeEffectBaseImpl {
        public void onPull(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$EdgeEffectBaseImpl */
    static class EdgeEffectBaseImpl {
        public void onPull(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
    }

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i) {
        this.mEdgeEffect.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean onPull(float f) {
        this.mEdgeEffect.onPull(f);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i, int i2) {
        this.mEdgeEffect.setSize(i, i2);
    }

    @Deprecated
    public boolean onPull(float f, float f2) {
        IMPL.onPull(this.mEdgeEffect, f, f2);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f, float f2) {
        IMPL.onPull(edgeEffect, f, f2);
    }
}
