package com.wpengapp.support;

import android.content.Context;
import android.support.p000v4.text.BidiFormatter;
import android.util.SparseArray;

/* renamed from: com.wpengapp.support.ƻ */
public class XPFramework {

    /* renamed from: ֏ */
    public static final SparseArray<String> f963 = new SparseArray<>();

    /* renamed from: ؠ */
    public static Integer f964;

    static {
        f963.put(0, BidiFormatter.EMPTY_STRING);
        f963.put(1, "de.robv.android.xposed.installer");
        f963.put(2, "org.meowcat.edxposed.manager");
        f963.put(3, "me.weishu.exp");
    }

    /* renamed from: ֏ */
    public static int m1235(Context context) {
        Integer num = f964;
        if (num != null) {
            return num.intValue();
        }
        int i = 0;
        while (i < f963.size()) {
            try {
                if (context.getPackageManager().getPackageInfo(f963.valueAt(i), 0) != null) {
                    f964 = Integer.valueOf(f963.keyAt(i));
                    return f964.intValue();
                }
                i++;
            } catch (Exception unused) {
            }
        }
        f964 = 0;
        return f964.intValue();
    }
}
