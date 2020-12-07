package android.support.p000v4.widget;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.PopupMenu;

/* renamed from: android.support.v4.widget.PopupMenuCompat */
public final class PopupMenuCompat {
    @Nullable
    public static View.OnTouchListener getDragToOpenListener(@NonNull Object obj) {
        int i = Build.VERSION.SDK_INT;
        return ((PopupMenu) obj).getDragToOpenListener();
    }
}