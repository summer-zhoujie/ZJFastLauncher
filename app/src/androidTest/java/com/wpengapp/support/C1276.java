package com.wpengapp.support;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.wpengapp.baseui.R$drawable;
import com.wpengapp.baseui.R$id;
import com.wpengapp.baseui.R$layout;
import com.wpengapp.baseui.filepicker.FilePicker;
import java.io.File;

/* renamed from: com.wpengapp.support.ཪ */
/* compiled from: FilePickerAdapter */
public class C1276 extends BaseRecyclerAdapter<File, ViewHolder> {

    /* renamed from: ހ */
    public FilePicker.C0422 f3579;

    public C1276(Context context, FilePicker.C0422 r2) {
        super(context);
        this.f3579 = r2;
    }

    /* renamed from: ֏ */
    public static <T> T m3364(View view, int i) {
        T tag = view.getTag(i);
        if (tag != null) {
            return tag;
        }
        T findViewById = view.findViewById(i);
        view.setTag(i, findViewById);
        return findViewById;
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder r4 = (ViewHolder) viewHolder;
        File file = (File) getItem(i);
        ImageView imageView = (ImageView) m3364(r4.itemView, R$id.img_icon);
        ((TextView) m3364(r4.itemView, R$id.tv_name)).setText(file.getName());
        if (file.isDirectory()) {
            imageView.setImageResource(R$drawable.baseui_folder);
        } else {
            imageView.setImageResource(R$drawable.baseui_file);
        }
        r4.itemView.setOnClickListener(new FilePickerAdapter(this, file));
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.f2805).inflate(R$layout.baseui_item_filepicker, viewGroup, false));
    }
}
