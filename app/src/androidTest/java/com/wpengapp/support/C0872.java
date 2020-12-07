package com.wpengapp.support;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.wpengapp.support.ٺ */
/* compiled from: CrashHandler */
class C0872 implements FilenameFilter {
    public boolean accept(File file, String str) {
        return str.endsWith(".err");
    }
}
