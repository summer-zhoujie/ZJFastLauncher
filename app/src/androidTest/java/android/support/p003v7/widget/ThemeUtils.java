package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.p000v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

/* renamed from: android.support.v7.widget.ThemeUtils */
public class ThemeUtils {
    public static final int[] ACTIVATED_STATE_SET = {16843518};
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int[] DISABLED_STATE_SET = {-16842910};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public static final int[] FOCUSED_STATE_SET = {16842908};
    public static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET = {-16842919, -16842908};
    public static final int[] PRESSED_STATE_SET = {16842919};
    public static final int[] SELECTED_STATE_SET = {16842913};
    public static final int[] TEMP_ARRAY = new int[1];
    public static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal<>();

    public static ColorStateList createDisabledStateList(int i, int i2) {
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    public static int getDisabledThemeAttrColor(Context context, int i) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(DISABLED_STATE_SET, themeAttrColorStateList.getDefaultColor());
        }
        TypedValue typedValue = getTypedValue();
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return getThemeAttrColor(context, i, typedValue.getFloat());
    }

    public static int getThemeAttrColor(Context context, int i) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int i) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static TypedValue getTypedValue() {
        TypedValue typedValue = TL_TYPED_VALUE.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        TL_TYPED_VALUE.set(typedValue2);
        return typedValue2;
    }

    public static int getThemeAttrColor(Context context, int i, float f) {
        int themeAttrColor = getThemeAttrColor(context, i);
        return ColorUtils.setAlphaComponent(themeAttrColor, Math.round(((float) Color.alpha(themeAttrColor)) * f));
    }
}
