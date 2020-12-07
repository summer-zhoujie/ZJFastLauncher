package com.wpengapp.support;

import android.support.annotation.NonNull;
import com.wpengapp.support.activity.LauncherActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.wpengapp.support.ژ */
public class TheBackupHandler {

    /* renamed from: ֏ */
    public List<IBackupItem> f2412 = new ArrayList();

    public TheBackupHandler() {
        this.f2412.add(new ItemSettings());
        this.f2412.add(new ItemCustom());
        this.f2412.add(new ItemAutoLogin());
        this.f2412.add(new ItemShortcut());
        this.f2412.add(new ItemToastRecord());
        this.f2412.add(new C0687());
    }

    /* renamed from: ֏ */
    public final IBackupItem mo8859(String str) {
        for (IBackupItem next : this.f2412) {
            if (str.equals(next.getKey())) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    /* renamed from: ֏ */
    public String mo8860() {
        return "lsbackup";
    }

    /* renamed from: ؠ */
    public String mo8863() {
        return AppUtils.m1163();
    }

    /* renamed from: ހ */
    public Map mo8864() {
        return null;
    }

    @NonNull
    /* renamed from: ށ */
    public String[] mo8865() {
        String[] strArr = new String[this.f2412.size()];
        for (int i = 0; i < this.f2412.size(); i++) {
            strArr[i] = this.f2412.get(i).getKey();
        }
        return strArr;
    }

    /* renamed from: ނ */
    public int mo8866() {
        return 0;
    }

    /* renamed from: ֏ */
    public boolean mo8861(BackupPackage r2) {
        return AppUtils.m1163().equals(r2.f2320);
    }

    /* renamed from: ֏ */
    public boolean mo8862(@NonNull BackupPackage r5, Set<String> set) {
        Map<String, String> map = r5.f2321;
        boolean z = false;
        if (map == null) {
            return false;
        }
        for (String next : map.keySet()) {
            if (set != null) {
                try {
                    if (!set.contains(next)) {
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            IBackupItem r2 = mo8859(next);
            if (r2 != null && r2.mo8365(r5)) {
                z = true;
            }
        }
        if (z) {
            LauncherActivity.m799();
        }
        return z;
    }
}
