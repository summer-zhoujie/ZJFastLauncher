package com.wpengapp.support;

import android.support.annotation.NonNull;

/* renamed from: com.wpengapp.support.Ⴑ */
public class SubscribeTaskGroup extends AccTaskGroup {
    public SubscribeTaskGroup(@NonNull String str) {
        mo8201((AccTask) new LaunchMainTask());
        mo8201((AccTask) new ClickMainSearchTask());
        mo8201((AccTask) new InputGZHTask(str));
        mo8201((AccTask) new ClickSearchGZHTask());
    }
}
