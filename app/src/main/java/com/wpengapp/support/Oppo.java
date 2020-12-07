package com.wpengapp.support;

import android.content.ComponentName;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.ङ */
public class Oppo implements BrandConfig {
    public String getName() {
        return "OPPO";
    }

    /* renamed from: ֏ */
    public boolean mo8222() {
        return true;
    }

    /* renamed from: ؠ */
    public List<ComponentName> mo8223() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity"));
        arrayList.add(new ComponentName("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity"));
        arrayList.add(new ComponentName("com.coloros.oppoguardelf", "com.coloros.oppoguardelf.MonitoredPkgActivity"));
        return arrayList;
    }

    /* renamed from: ހ */
    public List<ComponentName> mo8224() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.startup.StartupAppListActivity"));
        arrayList.add(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
        arrayList.add(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startupapp.StartupAppListActivity"));
        arrayList.add(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity"));
        arrayList.add(new ComponentName("com.coloros.safecenter", "com.coloros.privacypermissionsentry.PermissionTopActivity"));
        arrayList.add(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.newrequest.SecurityScanActivity"));
        return arrayList;
    }
}
