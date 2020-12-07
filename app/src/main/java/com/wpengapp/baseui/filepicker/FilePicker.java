package com.wpengapp.baseui.filepicker;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.wpengapp.support.C1276;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.FileUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class FilePicker extends RecyclerView {

    /* renamed from: ֏ */
    public static final File f279 = new File(FileUtils.f893);

    /* renamed from: ؠ */
    public boolean f280;

    /* renamed from: ހ */
    public boolean f281;

    /* renamed from: ށ */
    public Set<String> f282;

    /* renamed from: ނ */
    public File f283;

    /* renamed from: ރ */
    public C1276 f284;

    /* renamed from: ބ */
    public LinearLayoutManager f285;

    /* renamed from: ޅ */
    public C0421 f286;

    /* renamed from: ކ */
    public C0422 f287;

    /* renamed from: އ */
    public Comparator f288;

    /* renamed from: com.wpengapp.baseui.filepicker.FilePicker$֏ */
    public static class C0420 implements Comparator<File> {
        public int compare(Object obj, Object obj2) {
            File file = (File) obj;
            File file2 = (File) obj2;
            if (file == null) {
                return 1;
            }
            if (file2 != null) {
                if (file.isDirectory() == file2.isDirectory()) {
                    return CollectionUtils.f1665.compare(file.getName(), file2.getName());
                }
                return file.isDirectory() ? -1 : 1;
            }
        }
    }

    /* renamed from: com.wpengapp.baseui.filepicker.FilePicker$ؠ */
    public interface C0421 {
    }

    /* renamed from: com.wpengapp.baseui.filepicker.FilePicker$ހ */
    public interface C0422 {
        /* renamed from: ֏ */
        void mo7459(File file);
    }

    public FilePicker(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo7456();
    }

    public File getDir() {
        return this.f283;
    }

    public void setChooseDir(boolean z) {
        this.f280 = z;
        mo7457();
    }

    public void setDir(String str) {
        this.f283 = new File(str);
        mo7457();
        C0421 r2 = this.f286;
        if (r2 != null) {
            ((FilePickerDialog) r2).f796.mo8219(getDir());
        }
    }

    public void setOnDirChangedListener(C0421 r1) {
        this.f286 = r1;
    }

    public void setOnFileClickListener(C0422 r1) {
        this.f287 = r1;
    }

    public void setSupportExts(Set<String> set) {
        this.f282 = set;
        mo7457();
    }

    /* renamed from: ֏ */
    public File mo7455() {
        if (f279.equals(this.f283)) {
            return f279;
        }
        setDir(this.f283.getParent());
        return getDir();
    }

    /* renamed from: ؠ */
    public final void mo7456() {
        this.f283 = f279;
        this.f282 = null;
        this.f288 = new C0420();
        this.f285 = new LinearLayoutManager(getContext());
        this.f285.setOrientation(1);
        setLayoutManager(this.f285);
        this.f284 = new C1276(getContext(), new C1243(this));
        setAdapter(this.f284);
    }

    /* renamed from: ހ */
    public void mo7457() {
        File[] listFiles = this.f283.listFiles(new FilePicker(this));
        if (listFiles == null || listFiles.length == 0) {
            this.f284.mo9058((List) null);
            return;
        }
        Arrays.sort(listFiles, this.f288);
        this.f284.mo9058(Arrays.asList(listFiles));
        this.f285.scrollToPosition(0);
    }

    public FilePicker(Context context) {
        super(context, (AttributeSet) null, 0);
        mo7456();
    }

    public FilePicker(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        mo7456();
    }

    /* renamed from: ֏ */
    public static String m267(String str) {
        String absolutePath = f279.getAbsolutePath();
        if (str.startsWith(absolutePath)) {
            str = str.substring(absolutePath.length());
        }
        return TextUtils.isEmpty(str) ? "/" : str;
    }
}
