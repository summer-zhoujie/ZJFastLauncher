package android.support.p000v4.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.WindowInsets;

/* renamed from: android.support.v4.view.WindowInsetsCompat */
public class WindowInsetsCompat {
    public final Object mInsets;

    public WindowInsetsCompat(Object obj) {
        this.mInsets = obj;
    }

    public static Object unwrap(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat == null) {
            return null;
        }
        return windowInsetsCompat.mInsets;
    }

    public static WindowInsetsCompat wrap(Object obj) {
        if (obj == null) {
            return null;
        }
        return new WindowInsetsCompat(obj);
    }

    public WindowInsetsCompat consumeStableInsets() {
        int i = Build.VERSION.SDK_INT;
        return new WindowInsetsCompat((Object) ((WindowInsets) this.mInsets).consumeStableInsets());
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        int i = Build.VERSION.SDK_INT;
        return new WindowInsetsCompat((Object) ((WindowInsets) this.mInsets).consumeSystemWindowInsets());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WindowInsetsCompat.class != obj.getClass()) {
            return false;
        }
        WindowInsetsCompat windowInsetsCompat = (WindowInsetsCompat) obj;
        Object obj2 = this.mInsets;
        if (obj2 != null) {
            return obj2.equals(windowInsetsCompat.mInsets);
        }
        if (windowInsetsCompat.mInsets == null) {
            return true;
        }
        return false;
    }

    public int getStableInsetBottom() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).getStableInsetBottom();
    }

    public int getStableInsetLeft() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).getStableInsetLeft();
    }

    public int getStableInsetRight() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).getStableInsetRight();
    }

    public int getStableInsetTop() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).getStableInsetTop();
    }

    public int getSystemWindowInsetBottom() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).getSystemWindowInsetBottom();
    }

    public int getSystemWindowInsetLeft() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).getSystemWindowInsetLeft();
    }

    public int getSystemWindowInsetRight() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).getSystemWindowInsetRight();
    }

    public int getSystemWindowInsetTop() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).getSystemWindowInsetTop();
    }

    public boolean hasInsets() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).hasInsets();
    }

    public boolean hasStableInsets() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).hasStableInsets();
    }

    public boolean hasSystemWindowInsets() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).hasSystemWindowInsets();
    }

    public int hashCode() {
        Object obj = this.mInsets;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isConsumed() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).isConsumed();
    }

    public boolean isRound() {
        int i = Build.VERSION.SDK_INT;
        return ((WindowInsets) this.mInsets).isRound();
    }

    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        return new WindowInsetsCompat((Object) ((WindowInsets) this.mInsets).replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets;
        int i = Build.VERSION.SDK_INT;
        if (windowInsetsCompat == null) {
            windowInsets = null;
        } else {
            windowInsets = new WindowInsets((WindowInsets) windowInsetsCompat.mInsets);
        }
        this.mInsets = windowInsets;
    }

    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        int i = Build.VERSION.SDK_INT;
        return new WindowInsetsCompat((Object) ((WindowInsets) this.mInsets).replaceSystemWindowInsets(rect));
    }
}
