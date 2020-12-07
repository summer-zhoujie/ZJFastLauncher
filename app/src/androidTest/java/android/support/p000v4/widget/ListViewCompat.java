package android.support.p000v4.widget;

import android.os.Build;
import android.support.annotation.NonNull;
import android.widget.ListView;

/* renamed from: android.support.v4.widget.ListViewCompat */
public final class ListViewCompat {
    public static boolean canScrollList(@NonNull ListView listView, int i) {
        int i2 = Build.VERSION.SDK_INT;
        return listView.canScrollList(i);
    }

    public static void scrollListBy(@NonNull ListView listView, int i) {
        int i2 = Build.VERSION.SDK_INT;
        listView.scrollListBy(i);
    }
}
