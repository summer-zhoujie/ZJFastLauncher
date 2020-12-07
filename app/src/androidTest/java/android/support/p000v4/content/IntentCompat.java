package android.support.p000v4.content;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;

/* renamed from: android.support.v4.content.IntentCompat */
public final class IntentCompat {
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";

    @NonNull
    public static Intent makeMainSelectorActivity(@NonNull String str, @NonNull String str2) {
        int i = Build.VERSION.SDK_INT;
        return Intent.makeMainSelectorActivity(str, str2);
    }
}
