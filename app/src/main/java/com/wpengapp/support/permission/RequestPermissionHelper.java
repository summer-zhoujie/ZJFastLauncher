package com.wpengapp.support.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.ActivityCompat;
import android.support.p000v4.content.PermissionChecker;
import com.wpengapp.baseui.BaseActivity;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0915;
import com.wpengapp.support.ObjectCache;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.R$string;
import com.wpengapp.support.SystemUtils;
import java.util.ArrayList;

public class RequestPermissionHelper extends BaseActivity {

    /* renamed from: ފ */
    public String[] f708;

    /* renamed from: ދ */
    public C0458 f709;

    /* renamed from: ތ */
    public boolean f710;

    /* renamed from: ލ */
    public String f711;

    /* renamed from: com.wpengapp.support.permission.RequestPermissionHelper$֏ */
    public interface C0457 {
    }

    /* renamed from: com.wpengapp.support.permission.RequestPermissionHelper$ؠ */
    public interface C0458 {
        /* renamed from: ֏ */
        void mo7894(@NonNull String[] strArr, @NonNull String[] strArr2);
    }

    /* renamed from: ގ */
    public static boolean m901() {
        return m899("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
    }

    /* renamed from: ސ */
    public static boolean m902() {
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        if (m899(strArr)) {
            return false;
        }
        m897(strArr, (C0458) new C1242(strArr));
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200) {
            mo7891(true);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        this.f710 = getIntent().getBooleanExtra("EXTRA_FORCE", false);
        this.f708 = getIntent().getStringArrayExtra("EXTRA_PERMISSIONS");
        this.f711 = getIntent().getStringExtra("EXTRA_RATIONALE");
        int intExtra = getIntent().getIntExtra("EXTRA_CALLBACK", -1);
        C0458 r1 = (C0458) ObjectCache.m1662(intExtra);
        ObjectCache.m1663(intExtra);
        String[] strArr = this.f708;
        if (strArr == null || strArr.length == 0) {
            finish();
            return;
        }
        this.f709 = new C1325(this, r1);
        String[] strArr2 = this.f708;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, strArr2[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            mo7892(false);
        } else {
            ActivityCompat.requestPermissions(this, this.f708, 100);
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        String[] strArr2;
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            boolean z = false;
            if (strArr == null) {
                strArr2 = new String[0];
            } else {
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (PermissionChecker.checkSelfPermission(AppUtils.getApplication(), str) != 0) {
                        arrayList.add(str);
                    }
                }
                strArr2 = new String[arrayList.size()];
                arrayList.toArray(strArr2);
            }
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (!ActivityCompat.shouldShowRequestPermissionRationale(this, strArr2[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            mo7891(z);
        }
    }

    /* renamed from: ހ */
    public final void mo7891(boolean z) {
        if (!this.f710) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str : this.f708) {
                if (PermissionChecker.checkSelfPermission(AppUtils.getApplication(), str) == 0) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
            String[] strArr = new String[arrayList2.size()];
            arrayList2.toArray(strArr);
            String[] strArr2 = new String[arrayList.size()];
            arrayList.toArray(strArr2);
            this.f709.mo7894(strArr2, strArr);
        } else if (m899(this.f708)) {
            this.f709.mo7894(this.f708, new String[0]);
        } else {
            mo7892(z);
        }
    }

    /* renamed from: ށ */
    public final void mo7892(boolean z) {
        C0915 r0 = new C0915(this);
        r0.f2469 = false;
        r0.f2470 = false;
        r0.mo8902((CharSequence) this.f711, 19);
        r0.mo8906(R$string.pw_permission_goto_open, (OnDialogClickListener) new C0852(this, z));
        if (!this.f710) {
            r0.mo8900(R$string.pw_cancel, (OnDialogClickListener) new C1008(this));
        }
        r0.mo8910();
    }

    /* renamed from: ޏ */
    public final void mo7893() {
        startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", getPackageName(), (String) null)), 200);
    }

    /* renamed from: ֏ */
    public static void m897(String[] strArr, C0458 r4) {
        m896(false, strArr, AppUtils.m1141(R$string.pw_permission_rationale, new Object[0]), r4);
    }

    /* renamed from: ֏ */
    public static void m898(String[] strArr, String str, C0457 r3) {
        m896(true, strArr, str, new RequestPermissionHelper(r3));
    }

    /* renamed from: ֏ */
    public static void m896(boolean z, String[] strArr, String str, C0458 r6) {
        if (AppUtils.m1169()) {
            if (!(strArr == null || strArr.length == 0)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (m899(strArr)) {
                        AppUtils.m1146((Runnable) new C0713(r6, strArr));
                        return;
                    }
                    Context r0 = AppUtils.m1168();
                    if (r0 == null) {
                        r0 = AppUtils.getApplication();
                    }
                    Intent intent = new Intent(r0, RequestPermissionHelper.class);
                    intent.putExtra("EXTRA_FORCE", z);
                    intent.putExtra("EXTRA_PERMISSIONS", strArr);
                    intent.putExtra("EXTRA_CALLBACK", ObjectCache.m1661((Object) r6));
                    intent.putExtra("EXTRA_RATIONALE", str);
                    SystemUtils.m3510(r0, intent);
                    return;
                }
            }
            AppUtils.m1146((Runnable) new C0759(r6));
            return;
        }
        throw new RuntimeException("Pls run on main process");
    }

    /* renamed from: ֏ */
    public static boolean m899(String... strArr) {
        if (!(strArr == null || strArr.length == 0)) {
            for (String checkSelfPermission : strArr) {
                if (PermissionChecker.checkSelfPermission(AppUtils.getApplication(), checkSelfPermission) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
