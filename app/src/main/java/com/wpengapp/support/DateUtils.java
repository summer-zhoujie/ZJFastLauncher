package com.wpengapp.support;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.wpengapp.support.च */
public final class DateUtils {
    static {
        new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        new String[]{"Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
    }

    /* renamed from: ֏ */
    public static Date m2700() {
        return Calendar.getInstance().getTime();
    }

    /* renamed from: ؠ */
    public static Date m2701() {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    /* renamed from: ֏ */
    public static String m2699(Date date, String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(date);
    }

    /* renamed from: ֏ */
    public static String m2698(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(date);
    }
}
