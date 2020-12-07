package android.support.p003v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* renamed from: android.support.v7.widget.TintInfo */
public class TintInfo {
    public boolean mHasTintList;
    public boolean mHasTintMode;
    public ColorStateList mTintList;
    public PorterDuff.Mode mTintMode;

    public void clear() {
        this.mTintList = null;
        this.mHasTintList = false;
        this.mTintMode = null;
        this.mHasTintMode = false;
    }
}
