package com.wpengapp.support;

import android.app.Activity;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.support.p000v4.text.BidiFormatter;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;

/* renamed from: com.wpengapp.support.ס */
/* compiled from: UIUtils */
public final class C0826 {

    /* renamed from: ֏ */
    public static C0827 f2150;

    /* renamed from: ؠ */
    public static boolean f2151 = SystemUtils.m3529();

    /* renamed from: com.wpengapp.support.ס$֏ */
    /* compiled from: UIUtils */
    public static class C0827 {

        /* renamed from: ֏ */
        public int f2152;

        /* renamed from: ؠ */
        public int f2153;
    }

    static {
        AppUtils.getApplication().registerReceiver(new C0749(), new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }

    /* renamed from: ֏ */
    public static void m2172(int i, Object... objArr) {
        m2177((CharSequence) AppUtils.getApplication().getString(i, objArr));
    }

    /* renamed from: ؠ */
    public static void m2179(int i, Object... objArr) {
        m2180((CharSequence) Utils.m1864(i, objArr));
    }

    /* renamed from: ֏ */
    public static void m2177(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            AppUtils.m1155((Runnable) new C1039(charSequence));
        }
    }

    /* renamed from: ؠ */
    public static void m2180(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            AppUtils.m1155((Runnable) new UIUtils(charSequence));
        }
    }

    /* renamed from: ֏ */
    public static C0827 m2169() {
        C0827 r0 = f2150;
        if (r0 != null) {
            return r0;
        }
        C0827 r02 = new C0827();
        int i = Build.VERSION.SDK_INT;
        Point point = new Point();
        ((WindowManager) AppUtils.m1153("window")).getDefaultDisplay().getRealSize(point);
        r02.f2152 = Math.min(point.x, point.y);
        r02.f2153 = Math.max(point.x, point.y);
        f2150 = r02;
        return r02;
    }

    /* renamed from: ؠ */
    public static int m2178(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: ؠ */
    public static boolean m2181(String str) {
        return str != null && str.contains("@") && str.contains(".");
    }

    /* renamed from: ֏ */
    public static int m2168(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: ֏ */
    public static void m2174(View view) {
        if (view != null) {
            ((InputMethodManager) AppUtils.m1153("input_method")).showSoftInput(view, 1);
        }
    }

    /* renamed from: ֏ */
    public static void m2173(Activity activity) {
        if (activity != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = activity.getWindow().getDecorView();
            }
            if (currentFocus != null) {
                ((InputMethodManager) AppUtils.m1153("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    /* renamed from: ֏ */
    public static void m2176(TextView textView) {
        textView.getPaint().setFlags(9);
    }

    /* renamed from: ֏ */
    public static void m2175(EditText editText, InputFilter inputFilter) {
        InputFilter[] inputFilterArr;
        InputFilter[] filters = editText.getFilters();
        if (filters == null) {
            inputFilterArr = new InputFilter[1];
        } else {
            inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        }
        inputFilterArr[inputFilterArr.length - 1] = inputFilter;
        editText.setFilters(inputFilterArr);
    }

    /* renamed from: ֏ */
    public static String m2170(EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return BidiFormatter.EMPTY_STRING;
        }
        String obj = text.toString();
        return !TextUtils.isEmpty(obj) ? obj : BidiFormatter.EMPTY_STRING;
    }

    /* renamed from: ֏ */
    public static String m2171(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            return "*";
        }
        if (str.length() == 2) {
            StringBuilder r0 = outline.m2549("*");
            r0.append(str.charAt(1));
            return r0.toString();
        }
        if (m2181(str)) {
            int lastIndexOf = str.lastIndexOf("@");
            String substring = str.substring(0, lastIndexOf);
            String substring2 = str.substring(lastIndexOf);
            return m2171(substring) + substring2;
        } else if (str.length() == 11) {
            return str.substring(0, 3) + "****" + str.substring(7, 11);
        } else {
            int length = str.length() / 3;
            StringBuilder sb = new StringBuilder(str.substring(0, length));
            for (int i = 0; i < length; i++) {
                sb.append("*");
            }
            sb.append(str.substring(sb.length()));
            return sb.toString();
        }
    }
}
