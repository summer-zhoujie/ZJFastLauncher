package android.support.p000v4.view;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.NestedScrollingParentHelper */
public class NestedScrollingParentHelper {
    public int mNestedScrollAxes;
    public final ViewGroup mViewGroup;

    public NestedScrollingParentHelper(@NonNull ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxes;
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i, int i2) {
        this.mNestedScrollAxes = i;
    }

    public void onStopNestedScroll(@NonNull View view, int i) {
        this.mNestedScrollAxes = 0;
    }
}