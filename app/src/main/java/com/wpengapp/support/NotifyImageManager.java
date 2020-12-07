package com.wpengapp.support;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.view.ViewCompat;
import com.wpengapp.lightstart.R$color;
import com.wpengapp.lightstart.R$dimen;
import java.io.File;

/* renamed from: com.wpengapp.support.ҭ */
public class NotifyImageManager {

    /* renamed from: ֏ */
    public static final String f1902 = new File(AppUtils.getApplication().getFilesDir(), "notimg").getAbsolutePath();

    /* renamed from: ؠ */
    public static final int f1903 = ContextCompat.getColor(AppUtils.getApplication(), R$color.notify_small_icon_color);

    /* renamed from: ހ */
    public static final int f1904 = AppUtils.getApplication().getResources().getDimensionPixelSize(R$dimen.notify_small_icon_size);

    /* renamed from: ށ */
    public static final int f1905 = AppUtils.getApplication().getResources().getDimensionPixelSize(R$dimen.notify_large_icon_size);

    /* renamed from: ֏ */
    public static boolean m1919(Icon icon, String str, int i, int i2) {
        Bitmap bitmap;
        boolean z;
        if (icon == null || Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            Drawable loadDrawable = icon.loadDrawable(AppUtils.getApplication());
            if (loadDrawable == null) {
                return false;
            }
            if (loadDrawable.getIntrinsicWidth() > i2 || loadDrawable.getIntrinsicHeight() > i2) {
                bitmap = Utils.m1863(loadDrawable, i2, i2);
            } else {
                bitmap = Utils.m1862(loadDrawable);
            }
            if (i != 0) {
                int[] iArr = new int[(bitmap.getHeight() * bitmap.getWidth())];
                bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
                int length = iArr.length;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = true;
                        break;
                    }
                    int i5 = iArr[i3];
                    if (Color.alpha(i5) >= 255) {
                        if (i4 == 0) {
                            i4 = i5;
                        }
                        if (i4 != i5) {
                            z = false;
                            break;
                        }
                    }
                    i3++;
                }
                if (z) {
                    int[] iArr2 = new int[(bitmap.getHeight() * bitmap.getWidth())];
                    bitmap.getPixels(iArr2, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
                    int i6 = i & ViewCompat.MEASURED_SIZE_MASK;
                    for (int i7 = 0; i7 < iArr2.length; i7++) {
                        int i8 = iArr2[i7] & ViewCompat.MEASURED_STATE_MASK;
                        if (i8 != 0) {
                            iArr2[i7] = i8 | i6;
                        }
                    }
                    bitmap = Bitmap.createBitmap(iArr2, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                }
            }
            return Utils.m1883(bitmap, Bitmap.CompressFormat.PNG, str);
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    /* renamed from: ؠ */
    public static String m1920(String str, long j) {
        return f1902 + File.separator + str + "_" + j + "S";
    }

    /* renamed from: ؠ */
    public static void m1921(long j) {
        File[] listFiles = new File(f1902).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.lastModified() < j) {
                    FileUtils.m1130(file);
                }
            }
        }
    }

    /* renamed from: ֏ */
    public static String m1916(String str, long j) {
        return f1902 + File.separator + str + "_" + j + "L";
    }

    /* renamed from: ֏ */
    public static void m1917(long j) {
        File[] listFiles = new File(f1902).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                if (name.endsWith("_" + j + "L")) {
                    FileUtils.m1130(file);
                } else {
                    if (name.endsWith("_" + j + "S")) {
                        FileUtils.m1130(file);
                    }
                }
            }
        }
    }

    /* renamed from: ֏ */
    public static void m1918(String str) {
        File[] listFiles = new File(f1902).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    FileUtils.m1130(file);
                }
            }
        }
    }

    /* renamed from: ֏ */
    public static long m1915() {
        File databasePath = AppUtils.getApplication().getDatabasePath("main.db");
        long length = (databasePath == null || !databasePath.exists()) ? 0 : databasePath.length() + 0;
        File[] listFiles = new File(f1902).listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File length2 : listFiles) {
            length += length2.length();
        }
        return length;
    }
}
