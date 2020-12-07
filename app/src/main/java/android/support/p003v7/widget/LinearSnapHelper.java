package android.support.p003v7.widget;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p003v7.widget.ActivityChooserView;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;

/* renamed from: android.support.v7.widget.LinearSnapHelper */
public class LinearSnapHelper extends SnapHelper {
    public static final float INVALID_DISTANCE = 1.0f;
    @Nullable
    public OrientationHelper mHorizontalHelper;
    @Nullable
    public OrientationHelper mVerticalHelper;

    private float computeDistancePerChild(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int max;
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int position = layoutManager.getPosition(childAt);
            if (position != -1) {
                if (position < i) {
                    view = childAt;
                    i = position;
                }
                if (position > i2) {
                    view2 = childAt;
                    i2 = position;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(orientationHelper.getDecoratedEnd(view), orientationHelper.getDecoratedEnd(view2)) - Math.min(orientationHelper.getDecoratedStart(view), orientationHelper.getDecoratedStart(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i2 - i) + 1));
    }

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        int i;
        int decoratedMeasurement = (orientationHelper.getDecoratedMeasurement(view) / 2) + orientationHelper.getDecoratedStart(view);
        if (layoutManager.getClipToPadding()) {
            i = (orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding();
        } else {
            i = orientationHelper.getEnd() / 2;
        }
        return decoratedMeasurement - i;
    }

    private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2) {
        int[] calculateScrollDistance = calculateScrollDistance(i, i2);
        float computeDistancePerChild = computeDistancePerChild(layoutManager, orientationHelper);
        if (computeDistancePerChild <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1]) ? calculateScrollDistance[0] : calculateScrollDistance[1])) / computeDistancePerChild);
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int i;
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        if (layoutManager.getClipToPadding()) {
            i = (orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding();
        } else {
            i = orientationHelper.getEnd() / 2;
        }
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int abs = Math.abs(((orientationHelper.getDecoratedMeasurement(childAt) / 2) + orientationHelper.getDecoratedStart(childAt)) - i);
            if (abs < i2) {
                view = childAt;
                i2 = abs;
            }
        }
        return view;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mHorizontalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mHorizontalHelper = new OrientationHelper(layoutManager) {
                public int getDecoratedEnd(View view) {
                    return this.mLayoutManager.getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
                }

                public int getDecoratedMeasurement(View view) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
                }

                public int getDecoratedMeasurementInOther(View view) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
                }

                public int getDecoratedStart(View view) {
                    return this.mLayoutManager.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
                }

                public int getEnd() {
                    return this.mLayoutManager.getWidth();
                }

                public int getEndAfterPadding() {
                    return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
                }

                public int getEndPadding() {
                    return this.mLayoutManager.getPaddingRight();
                }

                public int getMode() {
                    return this.mLayoutManager.getWidthMode();
                }

                public int getModeInOther() {
                    return this.mLayoutManager.getHeightMode();
                }

                public int getStartAfterPadding() {
                    return this.mLayoutManager.getPaddingLeft();
                }

                public int getTotalSpace() {
                    return (this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft()) - this.mLayoutManager.getPaddingRight();
                }

                public int getTransformedEndWithDecoration(View view) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.right;
                }

                public int getTransformedStartWithDecoration(View view) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.left;
                }

                public void offsetChild(View view, int i) {
                    view.offsetLeftAndRight(i);
                }

                public void offsetChildren(int i) {
                    this.mLayoutManager.offsetChildrenHorizontal(i);
                }
            };
        }
        return this.mHorizontalHelper;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mVerticalHelper = new OrientationHelper(layoutManager) {
                public int getDecoratedEnd(View view) {
                    return this.mLayoutManager.getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
                }

                public int getDecoratedMeasurement(View view) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
                }

                public int getDecoratedMeasurementInOther(View view) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    return this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
                }

                public int getDecoratedStart(View view) {
                    return this.mLayoutManager.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
                }

                public int getEnd() {
                    return this.mLayoutManager.getHeight();
                }

                public int getEndAfterPadding() {
                    return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
                }

                public int getEndPadding() {
                    return this.mLayoutManager.getPaddingBottom();
                }

                public int getMode() {
                    return this.mLayoutManager.getHeightMode();
                }

                public int getModeInOther() {
                    return this.mLayoutManager.getWidthMode();
                }

                public int getStartAfterPadding() {
                    return this.mLayoutManager.getPaddingTop();
                }

                public int getTotalSpace() {
                    return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
                }

                public int getTransformedEndWithDecoration(View view) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.bottom;
                }

                public int getTransformedStartWithDecoration(View view) {
                    this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                    return this.mTmpRect.top;
                }

                public void offsetChild(View view, int i) {
                    view.offsetTopAndBottom(i);
                }

                public void offsetChildren(int i) {
                    this.mLayoutManager.offsetChildrenVertical(i);
                }
            };
        }
        return this.mVerticalHelper;
    }

    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(layoutManager, view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(layoutManager, view, getVerticalHelper(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int itemCount;
        View findSnapView;
        int position;
        int i3;
        PointF computeScrollVectorForPosition;
        int i4;
        int i5;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (itemCount = layoutManager.getItemCount()) == 0 || (findSnapView = findSnapView(layoutManager)) == null || (position = layoutManager.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i3)) == null) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            i4 = estimateNextPositionDiffForFling(layoutManager, getHorizontalHelper(layoutManager), i, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i5 = estimateNextPositionDiffForFling(layoutManager, getVerticalHelper(layoutManager), 0, i2);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i6 = position + i4;
        if (i6 < 0) {
            i6 = 0;
        }
        return i6 >= itemCount ? itemCount - 1 : i6;
    }
}
