package android.support.p000v4.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.wpengapp.support.outline;

/* renamed from: android.support.v4.view.GestureDetectorCompat */
public final class GestureDetectorCompat {
    public final GestureDetectorCompatImpl mImpl;

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl */
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase */
    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        public static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        public static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        public static final int LONG_PRESS = 2;
        public static final int SHOW_PRESS = 1;
        public static final int TAP = 3;
        public static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        public boolean mAlwaysInBiggerTapRegion;
        public boolean mAlwaysInTapRegion;
        public MotionEvent mCurrentDownEvent;
        public boolean mDeferConfirmSingleTap;
        public GestureDetector.OnDoubleTapListener mDoubleTapListener;
        public int mDoubleTapSlopSquare;
        public float mDownFocusX;
        public float mDownFocusY;
        public final Handler mHandler;
        public boolean mInLongPress;
        public boolean mIsDoubleTapping;
        public boolean mIsLongpressEnabled;
        public float mLastFocusX;
        public float mLastFocusY;
        public final GestureDetector.OnGestureListener mListener;
        public int mMaximumFlingVelocity;
        public int mMinimumFlingVelocity;
        public MotionEvent mPreviousUpEvent;
        public boolean mStillDown;
        public int mTouchSlopSquare;
        public VelocityTracker mVelocityTracker;

        public GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.mHandler = new GestureHandler(handler);
            } else {
                this.mHandler = new GestureHandler();
            }
            this.mListener = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void init(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.mListener != null) {
                this.mIsLongpressEnabled = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
                this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.mAlwaysInBiggerTapRegion || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) DOUBLE_TAP_TIMEOUT)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((y * y) + (x * x) < this.mDoubleTapSlopSquare) {
                return true;
            }
            return false;
        }

        public void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x020a  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x0221  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(MotionEvent r13) {
            /*
                r12 = this;
                int r0 = r13.getAction()
                android.view.VelocityTracker r1 = r12.mVelocityTracker
                if (r1 != 0) goto L_0x000e
                android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
                r12.mVelocityTracker = r1
            L_0x000e:
                android.view.VelocityTracker r1 = r12.mVelocityTracker
                r1.addMovement(r13)
                r0 = r0 & 255(0xff, float:3.57E-43)
                r1 = 6
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x001c
                r4 = 1
                goto L_0x001d
            L_0x001c:
                r4 = 0
            L_0x001d:
                if (r4 == 0) goto L_0x0024
                int r5 = r13.getActionIndex()
                goto L_0x0025
            L_0x0024:
                r5 = -1
            L_0x0025:
                int r6 = r13.getPointerCount()
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
            L_0x002d:
                if (r8 >= r6) goto L_0x0041
                if (r5 != r8) goto L_0x0032
                goto L_0x003e
            L_0x0032:
                float r11 = r13.getX(r8)
                float r11 = r11 + r9
                float r9 = r13.getY(r8)
                float r9 = r9 + r10
                r10 = r9
                r9 = r11
            L_0x003e:
                int r8 = r8 + 1
                goto L_0x002d
            L_0x0041:
                if (r4 == 0) goto L_0x0046
                int r4 = r6 + -1
                goto L_0x0047
            L_0x0046:
                r4 = r6
            L_0x0047:
                float r4 = (float) r4
                float r9 = r9 / r4
                float r10 = r10 / r4
                r4 = 2
                r5 = 3
                if (r0 == 0) goto L_0x01c1
                r8 = 1000(0x3e8, float:1.401E-42)
                if (r0 == r2) goto L_0x0133
                if (r0 == r4) goto L_0x00bc
                if (r0 == r5) goto L_0x00b7
                r2 = 5
                if (r0 == r2) goto L_0x00aa
                if (r0 == r1) goto L_0x005d
                goto L_0x0250
            L_0x005d:
                r12.mLastFocusX = r9
                r12.mDownFocusX = r9
                r12.mLastFocusY = r10
                r12.mDownFocusY = r10
                android.view.VelocityTracker r0 = r12.mVelocityTracker
                int r1 = r12.mMaximumFlingVelocity
                float r1 = (float) r1
                r0.computeCurrentVelocity(r8, r1)
                int r0 = r13.getActionIndex()
                int r1 = r13.getPointerId(r0)
                android.view.VelocityTracker r2 = r12.mVelocityTracker
                float r2 = r2.getXVelocity(r1)
                android.view.VelocityTracker r4 = r12.mVelocityTracker
                float r1 = r4.getYVelocity(r1)
                r4 = 0
            L_0x0082:
                if (r4 >= r6) goto L_0x0250
                if (r4 != r0) goto L_0x0087
                goto L_0x00a7
            L_0x0087:
                int r5 = r13.getPointerId(r4)
                android.view.VelocityTracker r8 = r12.mVelocityTracker
                float r8 = r8.getXVelocity(r5)
                float r8 = r8 * r2
                android.view.VelocityTracker r9 = r12.mVelocityTracker
                float r5 = r9.getYVelocity(r5)
                float r5 = r5 * r1
                float r5 = r5 + r8
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L_0x00a7
                android.view.VelocityTracker r13 = r12.mVelocityTracker
                r13.clear()
                goto L_0x0250
            L_0x00a7:
                int r4 = r4 + 1
                goto L_0x0082
            L_0x00aa:
                r12.mLastFocusX = r9
                r12.mDownFocusX = r9
                r12.mLastFocusY = r10
                r12.mDownFocusY = r10
                r12.cancelTaps()
                goto L_0x0250
            L_0x00b7:
                r12.cancel()
                goto L_0x0250
            L_0x00bc:
                boolean r0 = r12.mInLongPress
                if (r0 == 0) goto L_0x00c2
                goto L_0x0250
            L_0x00c2:
                float r0 = r12.mLastFocusX
                float r0 = r0 - r9
                float r1 = r12.mLastFocusY
                float r1 = r1 - r10
                boolean r6 = r12.mIsDoubleTapping
                if (r6 == 0) goto L_0x00d5
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.mDoubleTapListener
                boolean r13 = r0.onDoubleTapEvent(r13)
                r3 = r3 | r13
                goto L_0x0250
            L_0x00d5:
                boolean r6 = r12.mAlwaysInTapRegion
                if (r6 == 0) goto L_0x0113
                float r6 = r12.mDownFocusX
                float r6 = r9 - r6
                int r6 = (int) r6
                float r7 = r12.mDownFocusY
                float r7 = r10 - r7
                int r7 = (int) r7
                int r6 = r6 * r6
                int r7 = r7 * r7
                int r7 = r7 + r6
                int r6 = r12.mTouchSlopSquare
                if (r7 <= r6) goto L_0x010a
                android.view.GestureDetector$OnGestureListener r6 = r12.mListener
                android.view.MotionEvent r8 = r12.mCurrentDownEvent
                boolean r13 = r6.onScroll(r8, r13, r0, r1)
                r12.mLastFocusX = r9
                r12.mLastFocusY = r10
                r12.mAlwaysInTapRegion = r3
                android.os.Handler r0 = r12.mHandler
                r0.removeMessages(r5)
                android.os.Handler r0 = r12.mHandler
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.mHandler
                r0.removeMessages(r4)
                goto L_0x010b
            L_0x010a:
                r13 = 0
            L_0x010b:
                int r0 = r12.mTouchSlopSquare
                if (r7 <= r0) goto L_0x01be
                r12.mAlwaysInBiggerTapRegion = r3
                goto L_0x01be
            L_0x0113:
                float r2 = java.lang.Math.abs(r0)
                r4 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 >= 0) goto L_0x0125
                float r2 = java.lang.Math.abs(r1)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x0250
            L_0x0125:
                android.view.GestureDetector$OnGestureListener r2 = r12.mListener
                android.view.MotionEvent r3 = r12.mCurrentDownEvent
                boolean r3 = r2.onScroll(r3, r13, r0, r1)
                r12.mLastFocusX = r9
                r12.mLastFocusY = r10
                goto L_0x0250
            L_0x0133:
                r12.mStillDown = r3
                android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r13)
                boolean r1 = r12.mIsDoubleTapping
                if (r1 == 0) goto L_0x0145
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.mDoubleTapListener
                boolean r13 = r1.onDoubleTapEvent(r13)
                r13 = r13 | r3
                goto L_0x019d
            L_0x0145:
                boolean r1 = r12.mInLongPress
                if (r1 == 0) goto L_0x0151
                android.os.Handler r13 = r12.mHandler
                r13.removeMessages(r5)
                r12.mInLongPress = r3
                goto L_0x0193
            L_0x0151:
                boolean r1 = r12.mAlwaysInTapRegion
                if (r1 == 0) goto L_0x0168
                android.view.GestureDetector$OnGestureListener r1 = r12.mListener
                boolean r1 = r1.onSingleTapUp(r13)
                boolean r5 = r12.mDeferConfirmSingleTap
                if (r5 == 0) goto L_0x0166
                android.view.GestureDetector$OnDoubleTapListener r5 = r12.mDoubleTapListener
                if (r5 == 0) goto L_0x0166
                r5.onSingleTapConfirmed(r13)
            L_0x0166:
                r13 = r1
                goto L_0x019d
            L_0x0168:
                android.view.VelocityTracker r1 = r12.mVelocityTracker
                int r5 = r13.getPointerId(r3)
                int r6 = r12.mMaximumFlingVelocity
                float r6 = (float) r6
                r1.computeCurrentVelocity(r8, r6)
                float r6 = r1.getYVelocity(r5)
                float r1 = r1.getXVelocity(r5)
                float r5 = java.lang.Math.abs(r6)
                int r7 = r12.mMinimumFlingVelocity
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 > 0) goto L_0x0195
                float r5 = java.lang.Math.abs(r1)
                int r7 = r12.mMinimumFlingVelocity
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 <= 0) goto L_0x0193
                goto L_0x0195
            L_0x0193:
                r13 = 0
                goto L_0x019d
            L_0x0195:
                android.view.GestureDetector$OnGestureListener r5 = r12.mListener
                android.view.MotionEvent r7 = r12.mCurrentDownEvent
                boolean r13 = r5.onFling(r7, r13, r1, r6)
            L_0x019d:
                android.view.MotionEvent r1 = r12.mPreviousUpEvent
                if (r1 == 0) goto L_0x01a4
                r1.recycle()
            L_0x01a4:
                r12.mPreviousUpEvent = r0
                android.view.VelocityTracker r0 = r12.mVelocityTracker
                if (r0 == 0) goto L_0x01b0
                r0.recycle()
                r0 = 0
                r12.mVelocityTracker = r0
            L_0x01b0:
                r12.mIsDoubleTapping = r3
                r12.mDeferConfirmSingleTap = r3
                android.os.Handler r0 = r12.mHandler
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.mHandler
                r0.removeMessages(r4)
            L_0x01be:
                r3 = r13
                goto L_0x0250
            L_0x01c1:
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.mDoubleTapListener
                if (r0 == 0) goto L_0x01fd
                android.os.Handler r0 = r12.mHandler
                boolean r0 = r0.hasMessages(r5)
                if (r0 == 0) goto L_0x01d2
                android.os.Handler r1 = r12.mHandler
                r1.removeMessages(r5)
            L_0x01d2:
                android.view.MotionEvent r1 = r12.mCurrentDownEvent
                if (r1 == 0) goto L_0x01f5
                android.view.MotionEvent r6 = r12.mPreviousUpEvent
                if (r6 == 0) goto L_0x01f5
                if (r0 == 0) goto L_0x01f5
                boolean r0 = r12.isConsideredDoubleTap(r1, r6, r13)
                if (r0 == 0) goto L_0x01f5
                r12.mIsDoubleTapping = r2
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.mDoubleTapListener
                android.view.MotionEvent r1 = r12.mCurrentDownEvent
                boolean r0 = r0.onDoubleTap(r1)
                r0 = r0 | r3
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.mDoubleTapListener
                boolean r1 = r1.onDoubleTapEvent(r13)
                r0 = r0 | r1
                goto L_0x01fe
            L_0x01f5:
                android.os.Handler r0 = r12.mHandler
                int r1 = DOUBLE_TAP_TIMEOUT
                long r6 = (long) r1
                r0.sendEmptyMessageDelayed(r5, r6)
            L_0x01fd:
                r0 = 0
            L_0x01fe:
                r12.mLastFocusX = r9
                r12.mDownFocusX = r9
                r12.mLastFocusY = r10
                r12.mDownFocusY = r10
                android.view.MotionEvent r1 = r12.mCurrentDownEvent
                if (r1 == 0) goto L_0x020d
                r1.recycle()
            L_0x020d:
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r13)
                r12.mCurrentDownEvent = r1
                r12.mAlwaysInTapRegion = r2
                r12.mAlwaysInBiggerTapRegion = r2
                r12.mStillDown = r2
                r12.mInLongPress = r3
                r12.mDeferConfirmSingleTap = r3
                boolean r1 = r12.mIsLongpressEnabled
                if (r1 == 0) goto L_0x0239
                android.os.Handler r1 = r12.mHandler
                r1.removeMessages(r4)
                android.os.Handler r1 = r12.mHandler
                android.view.MotionEvent r3 = r12.mCurrentDownEvent
                long r5 = r3.getDownTime()
                int r3 = TAP_TIMEOUT
                long r7 = (long) r3
                long r5 = r5 + r7
                int r3 = LONGPRESS_TIMEOUT
                long r7 = (long) r3
                long r5 = r5 + r7
                r1.sendEmptyMessageAtTime(r4, r5)
            L_0x0239:
                android.os.Handler r1 = r12.mHandler
                android.view.MotionEvent r3 = r12.mCurrentDownEvent
                long r3 = r3.getDownTime()
                int r5 = TAP_TIMEOUT
                long r5 = (long) r5
                long r3 = r3 + r5
                r1.sendEmptyMessageAtTime(r2, r3)
                android.view.GestureDetector$OnGestureListener r1 = r12.mListener
                boolean r13 = r1.onDown(r13)
                r3 = r0 | r13
            L_0x0250:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.GestureDetectorCompat.GestureDetectorCompatImplBase.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mIsLongpressEnabled = z;
        }

        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDoubleTapListener = onDoubleTapListener;
        }

        /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler */
        private class GestureHandler extends Handler {
            public GestureHandler() {
            }

            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    GestureDetectorCompatImplBase gestureDetectorCompatImplBase = GestureDetectorCompatImplBase.this;
                    gestureDetectorCompatImplBase.mListener.onShowPress(gestureDetectorCompatImplBase.mCurrentDownEvent);
                } else if (i == 2) {
                    GestureDetectorCompatImplBase.this.dispatchLongPress();
                } else if (i == 3) {
                    GestureDetectorCompatImplBase gestureDetectorCompatImplBase2 = GestureDetectorCompatImplBase.this;
                    GestureDetector.OnDoubleTapListener onDoubleTapListener = gestureDetectorCompatImplBase2.mDoubleTapListener;
                    if (onDoubleTapListener == null) {
                        return;
                    }
                    if (!gestureDetectorCompatImplBase2.mStillDown) {
                        onDoubleTapListener.onSingleTapConfirmed(gestureDetectorCompatImplBase2.mCurrentDownEvent);
                    } else {
                        gestureDetectorCompatImplBase2.mDeferConfirmSingleTap = true;
                    }
                } else {
                    throw new RuntimeException(outline.m2554("Unknown message ", (Object) message));
                }
            }

            public GestureHandler(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2 */
    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        public final GestureDetector mDetector;

        public GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.mDetector = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mDetector.onTouchEvent(motionEvent);
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mDetector.setIsLongpressEnabled(z);
        }

        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        int i = Build.VERSION.SDK_INT;
        this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, (Handler) null);
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mImpl.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        int i = Build.VERSION.SDK_INT;
        this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
    }
}
