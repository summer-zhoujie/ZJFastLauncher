package android.support.p003v7.widget;

import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import com.wpengapp.support.outline;

/* renamed from: android.support.v7.widget.LayoutState */
public class LayoutState {
    public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    public static final int ITEM_DIRECTION_HEAD = -1;
    public static final int ITEM_DIRECTION_TAIL = 1;
    public static final int LAYOUT_END = 1;
    public static final int LAYOUT_START = -1;
    public static final String TAG = "LayoutState";
    public int mAvailable;
    public int mCurrentPosition;
    public int mEndLine = 0;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLayoutDirection;
    public boolean mRecycle = true;
    public int mStartLine = 0;
    public boolean mStopInFocusable;

    public boolean hasMore(RecyclerView.State state) {
        int i = this.mCurrentPosition;
        return i >= 0 && i < state.getItemCount();
    }

    public View next(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return viewForPosition;
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("LayoutState{mAvailable=");
        r0.append(this.mAvailable);
        r0.append(", mCurrentPosition=");
        r0.append(this.mCurrentPosition);
        r0.append(", mItemDirection=");
        r0.append(this.mItemDirection);
        r0.append(", mLayoutDirection=");
        r0.append(this.mLayoutDirection);
        r0.append(", mStartLine=");
        r0.append(this.mStartLine);
        r0.append(", mEndLine=");
        r0.append(this.mEndLine);
        r0.append('}');
        return r0.toString();
    }
}
