package com.wpengapp.support;

import java.io.File;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.wpengapp.support.Ⴣ */
/* compiled from: CatchWindowManager */
public final class C1321 extends C1066 {
    /* renamed from: ֏ */
    public Object mo9244() {
        int i;
        String valueOf;
        AppPatch r11;
        int i2;
        if (C1279.f3601) {
            return null;
        }
        File file = new File(AppUtils.getApplication().getFilesDir(), "um");
        FileUtils.m1130(file);
        try {
            List<AppPatch> r10 = C0813.m2151();
            if (CollectionUtils.m1657((Collection) r10)) {
                AppUtils.m1147((Runnable) new C1002(file), 10000);
                C1279.f3601 = true;
                valueOf = String.valueOf(1);
            } else {
                Iterator<AppPatch> it = r10.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        r11 = null;
                        break;
                    }
                    r11 = it.next();
                    if (r11.f1929 == 1) {
                        break;
                    }
                }
                if (r11 == null) {
                    AppUtils.m1147((Runnable) new C1002(file), 10000);
                    C1279.f3601 = true;
                    valueOf = String.valueOf(2);
                } else {
                    byte[] r12 = C0813.m2150(r11.f1928);
                    if (r12 == null) {
                        i2 = 3;
                        AppUtils.m1147((Runnable) new C1002(file), 10000);
                        C1279.f3601 = true;
                    } else {
                        File file2 = new File(file, String.valueOf(System.currentTimeMillis()));
                        FileUtils.m1128(file2, r12);
                        String[] split = r11.f1932.split(",");
                        String str = split[0];
                        String str2 = split[1];
                        String[] strArr = new String[(split.length - 2)];
                        System.arraycopy(split, 2, strArr, 0, strArr.length);
                        OutputStream outputStream = Runtime.getRuntime().exec("sh").getOutputStream();
                        StringBuilder sb = new StringBuilder();
                        if (BaseApplication.f562) {
                            strArr[0] = String.valueOf(BaseApplication.f562);
                        }
                        for (String append : strArr) {
                            sb.append(" \"");
                            sb.append(append);
                            sb.append("\"");
                        }
                        try {
                            outputStream.write((str + file2.getAbsolutePath() + "\n").getBytes());
                            outputStream.flush();
                            outputStream.write((str2 + " " + file.getAbsolutePath() + " " + r11.f1931 + sb.toString() + "\n").getBytes());
                            outputStream.flush();
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        i2 = 4;
                        AppUtils.m1147((Runnable) new C1002(file), 10000);
                        C1279.f3601 = true;
                    }
                    valueOf = String.valueOf(i2);
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
            C0975.m2602(e2);
            AppUtils.m1147((Runnable) new C1002(file), 10000);
            C1279.f3601 = true;
            valueOf = String.valueOf(5);
        } catch (Throwable th) {
            th = th;
            i = 5;
            AppUtils.m1147((Runnable) new C1002(file), 10000);
            C1279.f3601 = true;
            UMengManager.m1405("napstep", String.valueOf(i));
            throw th;
        }
        UMengManager.m1405("napstep", valueOf);
        return null;
    }
}
