package com.zj.fastlauncher;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.Button;

public class MoveAbleBtn extends androidx.appcompat.widget.AppCompatButton {
    private int lastX;
    private int lastY;
    private float screenWidth;

    public MoveAbleBtn(Context context) {
        super(context);
    }

    public MoveAbleBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveAbleBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth =  dm.widthPixels;
    }

//    @SuppressLint("ClickableViewAccessibility")
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                lastX = x;
//                lastY = y;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int offsetX = x-lastX;
//                int offsetY = y-lastY;
//                //第一种方法
//                layout(getLeft()+offsetX,
//                        getTop()+offsetY,
//                        getRight()+offsetX,
//                        getBottom()+offsetY);
//                //第二种方法
//                //offsetLeftAndRight(offsetX);
//                //offsetTopAndBottom(offsetY);
//                break;
//            case MotionEvent.ACTION_UP:
////                adsorbAnim(event.getRawX(), event.getRawY());
//                break;
//        }
//        return super.onTouchEvent(event);
//    }

//    private void adsorbAnim(float rawX, float rawY){
//        //靠顶吸附
//        if (rawY <= MeasureUtil.dp2px(getContext(),200)){//注意rawY包含了标题栏的高
//            animate().setDuration(400)
//                    .setInterpolator(new OvershootInterpolator())
//                    .yBy(-getY()-getHeight()/2.0f)
//                    .start();
//        }else if (rawX >= screenWidth/2){//靠右吸附
//            animate().setDuration(400)
//                    .setInterpolator(new OvershootInterpolator())
//                    .xBy(screenWidth - getX() - getWidth()/2.0f)
//                    .start();
//        }else {//靠左吸附
//            ObjectAnimator animator = ObjectAnimator.ofFloat(this, "x", getX(), -getWidth()/2.0f);
//            animator.setInterpolator(new OvershootInterpolator());
//            animator.setDuration(400);
//            animator.start();
//        }
//    }
}