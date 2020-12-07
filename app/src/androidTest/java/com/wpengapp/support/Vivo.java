package com.wpengapp.support;

import android.content.ComponentName;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.ݗ */
public class Vivo implements BrandConfig {
    public String getName() {
        return "VIVO";
    }

    /* renamed from: ֏ */
    public boolean mo8222() {
        return true;
    }

    /* renamed from: ؠ */
    public List<ComponentName> mo8223() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"));
        return arrayList;
    }

    /* renamed from: ހ */
    public List<ComponentName> mo8224() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager"));
        return arrayList;
    }
}
