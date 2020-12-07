package com.wpengapp.support;

import android.content.ComponentName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.wpengapp.support.ʁ */
public class Samsung implements BrandConfig {
    public String getName() {
        return "SAMSUNG";
    }

    /* renamed from: ֏ */
    public boolean mo8222() {
        return true;
    }

    /* renamed from: ؠ */
    public List<ComponentName> mo8223() {
        return Collections.emptyList();
    }

    /* renamed from: ހ */
    public List<ComponentName> mo8224() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.samsung.android.sm", "com.samsung.android.sm.app.dashboard.SmartManagerDashBoardActivity"));
        arrayList.add(new ComponentName("com.samsung.android.sm_cn", "com.samsung.android.sm.ui.ram.AutoRunActivity"));
        arrayList.add(new ComponentName("com.samsung.android.sm_cn", "com.samsung.android.sm.ui.appmanagement.AppManagementActivity"));
        arrayList.add(new ComponentName("com.samsung.android.sm_cn", "com.samsung.android.sm.ui.cstyleboard.SmartManagerDashBoardActivity"));
        return arrayList;
    }
}
