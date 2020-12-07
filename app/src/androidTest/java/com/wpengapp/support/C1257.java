package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.wpengapp.lightstart.activity.CustomActivity;
import com.wpengapp.lightstart.activity.MainActivity;

/* renamed from: com.wpengapp.support.པ */
/* compiled from: lambda */
public final /* synthetic */ class C1257 implements OnDialogClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ Context f3555;

    public /* synthetic */ C1257(Context context) {
        this.f3555 = context;
    }

    public final boolean onClick(View view) {
        boolean unused = this.f3555.startActivities(new Intent[]{new Intent(this.f3555, MainActivity.class), new Intent(this.f3555, CustomActivity.class)});
        return false;
    }
}
