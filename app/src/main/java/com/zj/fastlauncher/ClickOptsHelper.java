package com.zj.fastlauncher;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.zj.tools.mylibrary.ZJConvertUtils;
import com.zj.tools.mylibrary.ZJHandlerUtil;
import com.zj.tools.mylibrary.ZJLog;
import com.zj.tools.mylibrary.ZJSPUtils;
import com.zj.tools.mylibrary.ZJScreenUtils;
import com.zj.tools.mylibrary.ZJToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 辅助点击帮助类
 */
public class ClickOptsHelper implements View.OnClickListener {
    /**
     * 缓存配置
     */
    private static final String SP_CACHE_CONFIG = "sp_cache_config";

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
     * 写死clickpoint的菜单的长宽
     */
    private static final int CLICK_POINT_MENU_W = ZJConvertUtils.dp2px(400);
    private static final int CLICK_POINT_MENU_H = ZJConvertUtils.dp2px(50);
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
    private ClickPointOptions globalConfig = new ClickPointOptions();
    private View configMenu;

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
            menu.findViewById(R.id.exits).setOnClickListener(this);
            menu.findViewById(R.id.save).setOnClickListener(this);
            menu.findViewById(R.id.load).setOnClickListener(this);
            menu.findViewById(R.id.s_config).setOnClickListener(this);
            menu.findViewById(R.id.clear).setOnClickListener(this);
            menu.findViewById(R.id.hide_or_show).setOnClickListener(this);
        }

        if (menu.getParent() == null) {
            windowManager.addView(menu, getMenuDefaultLayoutParams());
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.add) {
            if (isCurStart) {
                return;
            }
            addNewClickPoint(context, windowManager);
        } else if (id == R.id.start) {
            v.setSelected(!v.isSelected());
            if (v.isSelected()) {
                final boolean b = startClickHelp();
                if (!b) {
                    return;
                }
            } else {
                stopClickHelp();
            }

            ((Button) v).setText(v.isSelected() ? "已开始" : "已停止");
            ((Button) v).setTextColor(Color.parseColor(v.isSelected() ? "#ff00ff" : "#000000"));
        } else if (id == R.id.exits) {
//            exits();
            v.setSelected(!v.isSelected());
            ((Button) v).setText(v.isSelected() ? "展开" : "收起");
            ((Button) v).setTextColor(Color.parseColor(v.isSelected() ? "#ff00ff" : "#000000"));
            for (int i = 0; i < menu.getChildCount(); i++) {
                final View childAt = menu.getChildAt(i);
                if (childAt == v) {
                    continue;
                }
                childAt.setVisibility(v.isSelected() ? View.GONE : View.VISIBLE);
            }
        } else if (id == R.id.s_config) {

            if (isCurStart) {
                return;
            }
            if (configMenu == null) {
                final int[] outLocation = new int[2];
                menu.getLocationOnScreen(outLocation);
                configMenu = createConfigMenu();
                configMenu.findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (configMenu.getParent() != null) {
                            configMenu.setVisibility(View.GONE);
                            final Button configBtn = menu.findViewById(R.id.s_config);
                            configBtn.setSelected(!configBtn.isSelected());
                            configBtn.setTextColor(Color.parseColor(configBtn.isSelected() ? "#ff00ff" : "#000000"));
                        }
                    }
                });
                WindowManager.LayoutParams lp = getConfigMenuDefaultLayoutParams();
                lp.width = CLICK_POINT_MENU_W;
                lp.height = CLICK_POINT_MENU_H;
                lp.gravity = Gravity.START | Gravity.TOP;
                lp.x = outLocation[0] + menu.getWidth();
                lp.y = outLocation[1];
                windowManager.addView(configMenu, lp);
            }

            v.setSelected(!v.isSelected());
            ((Button) v).setTextColor(Color.parseColor(v.isSelected() ? "#ff00ff" : "#000000"));
            configMenu.setVisibility(v.isSelected() ? View.VISIBLE : View.GONE);
        } else if (id == R.id.hide_or_show) {
            if (isCurStart) {
                return;
            }
            v.setSelected(!v.isSelected());
            for (View clickPoint : clickPoints) {
                clickPoint.setVisibility(v.isSelected() ? View.INVISIBLE : View.VISIBLE);
            }
            ((Button) v).setText(v.isSelected() ? "隐" : "显");
            ((Button) v).setTextColor(Color.parseColor(v.isSelected() ? "#ff00ff" : "#000000"));
        } else if (id == R.id.save) {
            if (isCurStart) {
                return;
            }

            doSaveConfigAndClickPoints();
        } else if (id == R.id.load) {
            if (isCurStart) {
                return;
            }
            loadConfigAndClickPointsFromCache();
        }else if (id == R.id.clear) {
            if (isCurStart) {
                return;
            }
            clearClickPoints();
            clearTimers();
        }
    }

    /**
     * 加载缓存的配置
     */
    private void loadConfigAndClickPointsFromCache() {
        final String cacheConfig = ZJSPUtils.getString(SP_CACHE_CONFIG, "");
        if (TextUtils.isEmpty(cacheConfig)) {
            ZJToast.show("还没有保存过配置!");
            return;
        }

        ZJLog.d("加载配置 = " + cacheConfig);
        clearClickPoints();
        clearTimers();

        final String[] split = cacheConfig.split(",");

        globalConfig.isDouble = Boolean.parseBoolean(split[0]);
        globalConfig.timeInterval = Integer.parseInt(split[1]);
        if (split.length > 4) {
            for (int i = 2; i < split.length - 1; i = i + 2) {
                final int x = Integer.parseInt(split[i]);
                final int y = Integer.parseInt(split[i + 1]);
                addNewClickPoint(context, windowManager, x, y);
            }
        }

    }

    /**
     * 保存当前的配置和点击位置
     */
    private void doSaveConfigAndClickPoints() {
        final StringBuilder b = new StringBuilder();
        b.append(globalConfig.isDouble + ",");
        b.append(globalConfig.timeInterval + "");
        for (View point : clickPoints) {
            final int[] outLocation = new int[2];
            point.getLocationOnScreen(outLocation);
            b.append(",");
            b.append(outLocation[0] + "");
            b.append(",");
            b.append(outLocation[1] + "");
        }
        final String value = b.toString();
        ZJSPUtils.putString(SP_CACHE_CONFIG, value);
        ZJToast.show("配置保存成功");
        ZJLog.d("保存配置 = " + value);
    }

    private WindowManager.LayoutParams getConfigMenuDefaultLayoutParams() {
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        // 设置为始终
        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        // 大小
        layoutParams.width = ZJConvertUtils.dp2px(30);
        layoutParams.height = ZJConvertUtils.dp2px(30);
        // 位置
        layoutParams.gravity = Gravity.CENTER;
        // 设置背景透明
        layoutParams.format = PixelFormat.TRANSLUCENT;
        return layoutParams;
    }

    /**
     * 退出点击操作台,释放资源
     */
    private void exits() {

        // 清空资源
        clearClickPoints();

        clearTimers();

        if (menu != null && menu.getParent() != null) {
            windowManager.removeView(menu);
        }

        // 回调
        if (listener != null) {
            listener.onDismiss();
        }
    }

    private void clearTimers() {
        for (Timer timer : timers) {
            timer.cancel();
        }
        timers.clear();
    }

    private void clearClickPoints() {
        for (View clickPoint : clickPoints) {
            if (clickPoint.getParent() != null) {
                windowManager.removeView(clickPoint);
            }
        }
        clickPoints.clear();
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

    private boolean startClickHelp() {
        if (isCurStart) {
            return false;
        }
        if (clickPoints.isEmpty()) {
            ZJToast.show("没有配置项, 请至少配置一个点击点!");
            return false;
        }
        isCurStart = true;
        for (int i = 0; i < clickPoints.size(); i++) {
            View point = clickPoints.get(i);
            // 计算点击位置
            int[] outLocation = new int[2];
            point.getLocationOnScreen(outLocation);
            final float x = outLocation[0] + point.getWidth() / 2;
            final float y = outLocation[1] + point.getHeight() / 2;

            // 获取点击的配置项
            final ClickPointOptions options = globalConfig;

            // 隐藏点击的配置控件
            point.setVisibility(View.GONE);

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
            }, 400 * i, options.timeInterval);
            timers.add(timer);
        }

        return true;
    }

    private void mockClick(final float x, final float y) {
        if (BaseAccessibilityService.service != null) {
            ZJHandlerUtil.postToMain(new Runnable() {
                @Override
                public void run() {
                    BaseAccessibilityService.service.mockClick(x, y);
                }
            });
        }
    }

    private void mockDoubleClick(final float x, final float y) {
        if (BaseAccessibilityService.service != null) {
            BaseAccessibilityService.service.mockClick(x, y);
            ZJHandlerUtil.postToMain(new Runnable() {
                @Override
                public void run() {
                    BaseAccessibilityService.service.mockClick(x, y);
                }
            }, 200);

        }
    }

    /**
     * 新增一个点击的点位
     */
    private void addNewClickPoint(Context context, final WindowManager windowManager) {
        addNewClickPoint(context, windowManager, -1, -1);
    }

    private void addNewClickPoint(Context context, final WindowManager windowManager, int x, int y) {
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
//        // 弹出按钮的编辑菜单
//        clickPointNew.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                switchShowClickPoint(v);
//                return false;
//            }
//        });

        clickPoints.add(clickPointNew);

        final int statusBarHeight = 0;
        getStatusBarHeight();
        if (x >= 0 && y >= statusBarHeight) {
            lp.x = x;
            lp.y = y - statusBarHeight;
            lp.gravity = Gravity.START | Gravity.TOP;
        }
        windowManager.addView(clickPointNew, lp);
    }

    public int getStatusBarHeight() {
        Resources resources = context.getResources();

        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");

        int height = resources.getDimensionPixelSize(resourceId);

        ZJLog.d("status bar>>> height:" + height);

        return height;

    }

    /**
     * 创建一个新的clickPoint的菜单视图
     */
    private View createConfigMenu() {

        final View menu = LayoutInflater.from(context).inflate(R.layout.click_points_menu_layout, null);
        Switch switchbtn = menu.findViewById(R.id.s_double_or_single);
        switchbtn.setChecked(globalConfig.isDouble);
        switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                globalConfig.isDouble = isChecked;
            }
        });
        EditText et = menu.findViewById(R.id.et_interval);
        et.setFocusable(true);
        et.setFocusableInTouchMode(true);
        et.setText(globalConfig.timeInterval + "");
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
                    globalConfig.timeInterval = Integer.parseInt(s.toString().trim());
                } catch (NumberFormatException e) {
                    ZJLog.e("error = " + Log.getStackTraceString(e));
                }
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

