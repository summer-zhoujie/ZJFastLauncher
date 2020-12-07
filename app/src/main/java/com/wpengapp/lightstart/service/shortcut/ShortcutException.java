package com.wpengapp.lightstart.service.shortcut;

import android.support.annotation.Keep;

@Keep
public class ShortcutException extends Exception {
    public ShortcutException(Throwable th, String str, String str2) {
        super("[id] " + str + " [type] " + str2, th);
    }
}
