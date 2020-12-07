package com.wpengapp.support.permission;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.Huawei;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.Utils;
import java.util.Collection;

public class KeepAlivePermissionView extends FrameLayout {
    public KeepAlivePermissionView(Context context) {
        super(context);
        mo7890();
    }

    /* renamed from: ֏ */
    public final void mo7890() {
        FrameLayout.inflate(getContext(), R$layout.pw_view_keep_alive, this);
        boolean r0 = CollectionUtils.m1659((Collection) Utils.m1905().mo8224());
        boolean z = true;
        if (!CollectionUtils.m1659((Collection) Utils.m1905().mo8223()) && Build.VERSION.SDK_INT < 23) {
            z = false;
        }
        boolean r1 = Utils.m1905().mo8222();
        ItemView itemView = (ItemView) findViewById(R$id.item_selfRun);
        if (r0) {
            itemView.setVisibility(0);
            itemView.setOnClickListener(new C0748(this));
            if (Utils.m1905() instanceof Huawei) {
                itemView.setTitle(R$string.pw_permission_selfrun_huawei);
                itemView.setDes(R$string.pw_permission_selfrun_huawei_tips);
            }
        }
        ItemView itemView2 = (ItemView) findViewById(R$id.item_powerSave);
        if (z) {
            itemView2.setVisibility(0);
            itemView2.setOnClickListener(new C0934(this));
        }
        ItemView itemView3 = (ItemView) findViewById(R$id.item_lock_recent);
        if (r1) {
            itemView3.setVisibility(0);
            itemView3.setOnClickListener(new C0894(this));
        }
        ((ItemView) findViewById(R$id.item_close_save_model)).setOnClickListener(new C0666(this));
        findViewById(R$id.tv_guide).setOnClickListener(new KeepAlivePermissionView(this));
    }

    public KeepAlivePermissionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        mo7890();
    }

    public KeepAlivePermissionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo7890();
    }

    @RequiresApi(api = 21)
    public KeepAlivePermissionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        mo7890();
    }
}
