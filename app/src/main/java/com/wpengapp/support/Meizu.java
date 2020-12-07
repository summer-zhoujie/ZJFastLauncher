package com.wpengapp.support;

import android.content.ComponentName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.wpengapp.support.ഭ */
public class Meizu implements BrandConfig {
    public String getName() {
        return "MEIZU";
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
        arrayList.add(new ComponentName("com.meizu.safe", "com.meizu.safe.permission.SmartBGActivity"));
        arrayList.add(new ComponentName("com.meizu.safe", "com.meizu.safe.permission.PermissionMainActivity"));
        arrayList.add(new ComponentName("com.meizu.safe", "com.meizu.safe.security.HomeActivity"));
        return arrayList;
    }
}
