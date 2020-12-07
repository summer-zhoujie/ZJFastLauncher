package android.support.p003v7.widget.helper;

import android.graphics.Canvas;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.recyclerview.C0179R;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;

/* renamed from: android.support.v7.widget.helper.ItemTouchUIUtilImpl */
public class ItemTouchUIUtilImpl {

    /* renamed from: android.support.v7.widget.helper.ItemTouchUIUtilImpl$Api21Impl */
    static class Api21Impl extends BaseImpl {
        private float findMaxElevation(RecyclerView recyclerView, View view) {
            int childCount = recyclerView.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    float elevation = ViewCompat.getElevation(childAt);
                    if (elevation > f) {
                        f = elevation;
                    }
                }
            }
            return f;
        }

        public void clearView(View view) {
            Object tag = view.getTag(C0179R.C0181id.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                ViewCompat.IMPL.setElevation(view, ((Float) tag).floatValue());
            }
            view.setTag(C0179R.C0181id.item_touch_helper_previous_elevation, (Object) null);
            super.clearView(view);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(C0179R.C0181id.item_touch_helper_previous_elevation) == null) {
                Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
                ViewCompat.IMPL.setElevation(view, findMaxElevation(recyclerView, view) + 1.0f);
                view.setTag(C0179R.C0181id.item_touch_helper_previous_elevation, valueOf);
            }
            view.setTranslationX(f);
            view.setTranslationY(f2);
        }
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchUIUtilImpl$BaseImpl */
    static class BaseImpl implements ItemTouchUIUtil {
        public void clearView(View view) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            view.setTranslationX(f);
            view.setTranslationY(f2);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        }

        public void onSelected(View view) {
        }
    }
}
