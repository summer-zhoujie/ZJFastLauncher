package com.wpengapp.support;

import android.content.ComponentName;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.བྷ */
public class Xiaomi implements BrandConfig {
    public String getName() {
        return "XIAOMI";
    }

    /* renamed from: ֏ */
    public boolean mo8222() {
        return true;
    }

    /* renamed from: ؠ */
    public List<ComponentName> mo8223() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsContainerManagementActivity"));
        arrayList.add(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
        return arrayList;
    }

    /* renamed from: ހ */
    public List<ComponentName> mo8224() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
        return arrayList;
    }
}
