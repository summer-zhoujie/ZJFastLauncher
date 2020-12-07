package android.support.p000v4.p002os;

import android.os.Build;
import android.os.Trace;

/* renamed from: android.support.v4.os.TraceCompat */
public final class TraceCompat {
    public static void beginSection(String str) {
        int i = Build.VERSION.SDK_INT;
        Trace.beginSection(str);
    }

    public static void endSection() {
        int i = Build.VERSION.SDK_INT;
        Trace.endSection();
    }
}
