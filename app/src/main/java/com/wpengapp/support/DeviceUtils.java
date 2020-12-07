package com.wpengapp.support;

import java.io.File;
import java.io.FileFilter;

/* renamed from: com.wpengapp.support.ƶ */
class DeviceUtils implements FileFilter {
    public boolean accept(File file) {
        char charAt;
        String name = file.getName();
        if (!name.startsWith("cpu") || name.length() < 4 || (charAt = name.charAt(3)) < '0' || charAt > '9') {
            return false;
        }
        return true;
    }
}
