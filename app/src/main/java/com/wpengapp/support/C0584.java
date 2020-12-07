package com.wpengapp.support;

import android.content.Context;
import android.view.WindowManager;
import android.widget.TextView;
import com.wpengapp.baseui.R$id;
import com.wpengapp.baseui.R$layout;
import com.wpengapp.baseui.R$style;
import com.wpengapp.baseui.filepicker.FilePicker;
import java.io.File;

/* renamed from: com.wpengapp.support.ɾ */
/* compiled from: FilePickerDialog */
public class C0584 extends AlertDialog {

    /* renamed from: ֏ */
    public FilePicker f1268 = ((FilePicker) findViewById(R$id.file_picker));

    /* renamed from: ؠ */
    public TextView f1269;

    /* renamed from: ހ */
    public TextView f1270;

    /* renamed from: ށ */
    public TextView f1271;

    /* renamed from: ނ */
    public FilePicker.C0422 f1272;

    public C0584(Context context) {
        super(context, R$style.WpengApp_BaseDialogTheme);
        setContentView(R$layout.baseui_filepicker);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((float) C0826.m2169().f2152) * 0.95f);
        attributes.height = (int) (((float) C0826.m2169().f2153) * 0.9f);
        getWindow().setAttributes(attributes);
        findViewById(R$id.layout_title).setOnClickListener(new C0987(this));
        this.f1269 = (TextView) findViewById(R$id.tv_dir);
        this.f1268.setOnDirChangedListener(new FilePickerDialog(this));
        findViewById(R$id.img_close).setOnClickListener(new C1204(this));
        findViewById(R$id.img_back).setOnClickListener(new C0540(this));
        this.f1270 = (TextView) findViewById(R$id.tv_choose);
        this.f1270.setOnClickListener(new C0478(this));
        this.f1270.setVisibility(4);
        this.f1271 = (TextView) findViewById(R$id.tv_title);
        mo8219(this.f1268.getDir());
    }

    public void setTitle(CharSequence charSequence) {
        this.f1271.setText(charSequence);
    }

    public void show() {
        super.show();
        this.f1268.mo7457();
    }

    /* renamed from: ؠ */
    public final void mo8219(File file) {
        this.f1269.setText(FilePicker.m267(file.getAbsolutePath()));
    }
}
