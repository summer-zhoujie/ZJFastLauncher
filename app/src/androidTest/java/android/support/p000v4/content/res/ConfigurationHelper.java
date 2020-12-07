package android.support.p000v4.content.res;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;

/* renamed from: android.support.v4.content.res.ConfigurationHelper */
public final class ConfigurationHelper {
    public static int getDensityDpi(@NonNull Resources resources) {
        int i = Build.VERSION.SDK_INT;
        return resources.getConfiguration().densityDpi;
    }
}
