package com.wpengapp.support;

import com.wpengapp.baseui.filepicker.FilePicker;
import java.io.File;

/* renamed from: com.wpengapp.support.ང */
/* compiled from: FilePicker */
class C1243 implements FilePicker.C0422 {

    /* renamed from: ֏ */
    public final /* synthetic */ FilePicker f3529;

    public C1243(FilePicker filePicker) {
        this.f3529 = filePicker;
    }

    /* renamed from: ֏ */
    public void mo7459(File file) {
        if (file.isDirectory()) {
            this.f3529.setDir(file.getAbsolutePath());
        } else if (this.f3529.f287 != null) {
            this.f3529.f287.mo7459(file);
        }
    }
}
