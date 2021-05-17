package com.zj.fastlauncher;

import android.content.Context;
import android.graphics.PixelFormat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.zj.tools.mylibrary.ZJConvertUtils;
import com.zj.tools.mylibrary.ZJLog;
import com.zj.tools.mylibrary.ZJScreenUtils;
import com.zj.tools.mylibrary.ZJToast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 辅助点击帮助类
 */
public class ClickOptsHelper implements View.OnClickListener {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // variables

    private static volatile ClickOptsHelper instance = null;
    /**
     * 操作菜单:
     * 1. 新增辅助点击位置
     * 2. 开启点击辅助
     * 3. 暂停点击辅助
     * 4. 退出操作菜单
     */
    private ViewGroup menu = null;
    private Listener listener;
    private WindowManager windowManager;
    private Context context;
    /**
     * 记录点击按钮对应的菜单组件
     */
    private HashMap<View, View> clickPointMenuMap = new HashMap<>();
    /**
     * 写死clickpoint的菜单的长宽
     */
    private static final int CLICK_POINT_MENU_W = ZJConvertUtils.dp2px(400);
    private static final int CLICK_POINT_MENU_H = ZJConvertUtils.dp2px(50);
    /**
     * 记录点击按钮对应的脚本策略
     */
    private HashMap<View, ClickPointOptions> clickPointOptionsMap = new HashMap<>();
    /**
     * 记录所有点击控件
     */
    private List<View> clickPoints = new ArrayList<>();
    private int screen_width = 0;
    private int screen_height = 0;
    /**
     * 当前是否开启了点击辅助
     */
    private boolean isCurStart = false;
    /**
     * 记录正在运行的点击模拟事件
     */
    private List<Timer> timers = new ArrayList<>();

    public interface Listener {
        void onDismiss();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // out-funcs

    public static ClickOptsHelper get() {
        if (instance == null) {
            synchronized (ClickOptsHelper.class) {
                if (instance == null) {
                    instance = new ClickOptsHelper();
                }
            }
        }

        return instance;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void show(Context context) {
        if (windowManager == null) {
            windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        }
        this.context = context;
        screen_height = ZJScreenUtils.getScreenHeight(context);
        screen_width = ZJScreenUtils.getScreenWidth(context);
        initMenuIfNeed(context, windowManager);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // in-funcs

    /**
     * 初始化菜单组件
     */
    private void initMenuIfNeed(Context context, WindowManager windowManager) {
        if (menu == null) {
            menu = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.opts_menu_layout, null);
            menu.findViewById(R.id.add).setOnClickListener(this);
            menu.findViewById(R.id.start).setOnClickListener(this);
            menu.findViewById(R.id.stop).setOnClickListener(this);
            menu.findViewById(R.id.exits).setOnClickListener(this);
        }

        if (menu.getParent() == null) {
            windowManager.addView(menu, getMenuDefaultLayoutParams());
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.add) {
            addNewClickPoint(context, windowManager);
        } else if (id == R.id.start) {
            startClickHelp();
        } else if (id == R.id.stop) {
            stopClickHelp();
        } else if (id == R.id.exits) {
            exits();
        }
    }

    /**
     * 退出点击操作台,释放资源
     */
    private void exits() {

        // 清空资源
        for (View clickPoint : clickPoints) {
            if (clickPoint.getParent() != null) {
                windowManager.removeView(clickPoint);
            }
        }
        clickPoints.clear();

        for (Map.Entry<View, View> viewViewEntry : clickPointMenuMap.entrySet()) {
            View value = viewViewEntry.getValue();
            if (value.getParent() != null) {
                windowManager.removeView(value);
            }
        }
        clickPointMenuMap.clear();

        for (Timer timer : timers) {
            timer.cancel();
        }
        timers.clear();
        clickPointOptionsMap.clear();
        if (menu != null && menu.getParent() != null) {
            windowManager.removeView(menu);
        }

        // 回调
        if (listener != null) {
            listener.onDismiss();
        }
    }

    private void stopClickHelp() {
        if (!isCurStart) {
            return;
        }

        // 停止模拟点击
        for (int i = 0; i < timers.size(); i++) {
            Timer timer = timers.get(i);
            timer.cancel();
        }
        timers.clear();

        // 显示被隐藏的点击控件
        for (View point : clickPoints) {
            point.setVisibility(View.VISIBLE);
        }
        isCurStart = false;
    }

    private void startClickHelp() {
        if (isCurStart) {
            return;
        }
        if (clickPoints.isEmpty()) {
            ZJToast.show("没有配置项, 请至少配置一个点击点!");
            return;
        }
        isCurStart = true;
        for (View point : clickPoints) {

            // 计算点击位置
            int[] outLocation = new int[2];
            point.getLocationOnScreen(outLocation);
            final float x = outLocation[0] + point.getWidth() / 2;
            final float y = outLocation[1] + point.getHeight() / 2;

            // 获取点击的配置项
            final ClickPointOptions options = clickPointOptionsMap.get(point);

            // 隐藏点击的配置控件
            point.setVisibility(View.GONE);
            View view = clickPointMenuMap.get(point);
            if (view != null) {
                view.setVisibility(View.GONE);
            }

            // 开始模拟点击
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (options.isDouble) {
                        mockDoubleClick(x, y);
                    } else {
                        mockClick(x, y);
                    }
                }
            }, 0, options.timeInterval);
            timers.add(timer);
        }
    }

    private void mockClick(float x, float y) {
        if (BaseAccessibilityService.service != null) {
            BaseAccessibilityService.service.mockClick(x, y);
        }
    }

    private void mockDoubleClick(float x, float y) {
        if (BaseAccessibilityService.service != null) {
            BaseAccessibilityService.service.mockDoubleClick(x, y);
        }
    }

    /**
     * 新增一个点击的点位
     */
    private void addNewClickPoint(Context context, final WindowManager windowManager) {
        View clickPointNew = LayoutInflater.from(context).inflate(R.layout.click_points_layout, null);
        final WindowManager.LayoutParams lp = getClickPointsDefaultLayoutParams();
        // 设置随手指移动
        clickPointNew.setOnTouchListener(new View.OnTouchListener() {
            int lastX;
            int lastY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int rawX = (int) event.getRawX();
                int rawY = (int) event.getRawY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = rawX;
                        lastY = rawY;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        lp.x += rawX - lastX;
                        lp.y += rawY - lastY;
                        windowManager.updateViewLayout(v, lp);
                        lastX = rawX;
                        lastY = rawY;
                        break;
                }
                return false;
            }
        });
        // 弹出按钮的编辑菜单
        clickPointNew.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                switchShowClickPoint(v);
                return false;
            }
        });

        clickPoints.add(clickPointNew);

        windowManager.addView(clickPointNew, getClickPointsDefaultLayoutParams());
    }

    /**
     * 隐藏/显示点击控件的菜单项
     * <p>
     * 长按点击控件调用此方法, 用于展示点击控件的菜单项, 在菜单中用户可以使用以下功能:
     * 1. 切换单击/双击
     * 2. 设置点击间隔(单位: ms)
     * 3. 删除这个点击位置项
     *
     * @param clickPoint 点击控件 clickPoint
     */
    private void switchShowClickPoint(View clickPoint) {
        View menu = clickPointMenuMap.get(clickPoint);

        // 隐藏
        if (menu != null && menu.getParent() != null) {
            windowManager.removeView(menu);
            return;
        }
        // 展示
        if (menu == null) {
            menu = createOnPointsMenu(clickPoint);
            clickPointMenuMap.put(clickPoint, menu);
        }
        int[] outLocation = new int[2];
        clickPoint.getLocationOnScreen(outLocation);

        WindowManager.LayoutParams lp = getClickPointsDefaultLayoutParams();
        lp.width = CLICK_POINT_MENU_W;
        lp.height = CLICK_POINT_MENU_H;
        lp.gravity = Gravity.START | Gravity.TOP;
        lp.x = outLocation[0];
        lp.y = outLocation[1] + clickPoint.getHeight();
        int offsetx = screen_width - (lp.x + CLICK_POINT_MENU_W);
        if (offsetx < 0) {
            lp.x += offsetx;
        }

        int offsety = screen_height - (lp.y + CLICK_POINT_MENU_H);
        if (offsety < 0) {
            lp.y += -(CLICK_POINT_MENU_H + clickPoint.getHeight());
        }
        windowManager.addView(menu, lp);
    }

    /**
     * 创建一个新的clickPoint的菜单视图
     */
    private View createOnPointsMenu(final View clickPoint) {

        ClickPointOptions options;
        options = clickPointOptionsMap.get(clickPoint);
        if (options == null) {
            options = new ClickPointOptions();
            clickPointOptionsMap.put(clickPoint, options);
        }
        options.reset();
        final ClickPointOptions finalOptions = options;

        View menu = LayoutInflater.from(context).inflate(R.layout.click_points_menu_layout, null);
        Switch switchbtn = menu.findViewById(R.id.s_double_or_single);
        switchbtn.setChecked(options.isDouble);
        switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                finalOptions.isDouble = isChecked;
            }
        });
        EditText et = menu.findViewById(R.id.et_interval);
        et.setText(options.timeInterval + "");
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    finalOptions.timeInterval = Integer.parseInt(s.toString().trim());
                } catch (NumberFormatException e) {
                    ZJLog.e("error = " + Log.getStackTraceString(e));
                }
            }
        });
        menu.findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalOptions.isDel = true;

                // do del
                View remove = clickPointMenuMap.remove(clickPoint);
                if (remove.getParent() != null) {
                    windowManager.removeView(remove);
                }
                clickPointOptionsMap.remove(clickPoint);
                if (clickPoint.getParent() != null) {
                    windowManager.removeView(clickPoint);
                }
                clickPoints.remove(clickPoint);
            }
        });

        return menu;
    }

    private WindowManager.LayoutParams getMenuDefaultLayoutParams() {
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        // 设置为始终
        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        // 设置弹出的Window不持有焦点
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 大小
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        // 位置
        layoutParams.gravity = Gravity.START | Gravity.TOP;
        // 设置背景透明
        layoutParams.format = PixelFormat.TRANSLUCENT;
        return layoutParams;
    }

    private WindowManager.LayoutParams getClickPointsDefaultLayoutParams() {
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        // 设置为始终
        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        // 设置弹出的Window不持有焦点
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 大小
        layoutParams.width = ZJConvertUtils.dp2px(30);
        layoutParams.height = ZJConvertUtils.dp2px(30);
        // 位置
        layoutParams.gravity = Gravity.CENTER;
        // 设置背景透明
        layoutParams.format = PixelFormat.TRANSLUCENT;
        return layoutParams;
    }

    private static class ClickPointOptions {
        /**
         * 默认是双击
         */
        public boolean isDouble = true;

        /**
         * 时间间隔 (单位: ms), 默认3s
         */
        public int timeInterval = 3000;

        /**
         * 是否删除, 默认没有删除
         */
        public boolean isDel = false;

        /**
         * 重置状态(特定情况下可以被重复使用, 避免new对象产生的时间浪费)
         */
        public void reset() {
            isDouble = true;
            timeInterval = 20000;
            isDel = false;
        }
    }
}

