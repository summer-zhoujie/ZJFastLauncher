package com.wpengapp.support;

import java.io.File;
import java.io.FileFilter;

/* renamed from: com.wpengapp.support.ײ */
class FilePicker implements FileFilter {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.baseui.filepicker.FilePicker f2172;

    public FilePicker(com.wpengapp.baseui.filepicker.FilePicker filePicker) {
        this.f2172 = filePicker;
    }

    public boolean accept(File file) {
        String name = file.getName();
        if (!this.f2172.f281 && file.isHidden()) {
            return false;
        }
        if (this.f2172.f280) {
            return file.isDirectory();
        }
        if (this.f2172.f282 == null || file.isDirectory()) {
            return true;
        }
        return this.f2172.f282.contains(FileUtils.m1135(name));
    }
}
