package com.wpengapp.support;

import android.content.ComponentName;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.Ζ */
public class Huawei implements BrandConfig {
    public String getName() {
        return "HUAWEI";
    }

    /* renamed from: ֏ */
    public boolean mo8222() {
        return true;
    }

    /* renamed from: ؠ */
    public List<ComponentName> mo8223() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
        return arrayList;
    }

    /* renamed from: ހ */
    public List<ComponentName> mo8224() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"));
        arrayList.add(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity"));
        arrayList.add(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupAwakedAppListActivity"));
        arrayList.add(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity"));
        return arrayList;
    }
}
