package com.wpengapp.support;

import android.view.View;
import java.io.File;

/* renamed from: com.wpengapp.support.ར */
public class FilePickerAdapter implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ File f3570;

    /* renamed from: ؠ */
    public final /* synthetic */ C1276 f3571;

    public FilePickerAdapter(C1276 r1, File file) {
        this.f3571 = r1;
        this.f3570 = file;
    }

    public void onClick(View view) {
        this.f3571.f3579.mo7459(this.f3570);
    }
}
