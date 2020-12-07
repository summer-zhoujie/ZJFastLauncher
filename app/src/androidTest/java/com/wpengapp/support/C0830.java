package com.wpengapp.support;

import com.umeng.analytics.StoreHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* renamed from: com.wpengapp.support.ת */
/* compiled from: Sender */
public class C0830 implements StoreHelper.C0405b {

    /* renamed from: ֏ */
    public final /* synthetic */ Sender f2167;

    public C0830(Sender r1) {
        this.f2167 = r1;
    }

    /* renamed from: a */
    public void mo7364a(File file) {
    }

    /* renamed from: b */
    public boolean mo7365b(File file) {
        int i;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] r4 = HelperUtils.m2473((InputStream) fileInputStream2);
                try {
                    HelperUtils.m2474(fileInputStream2);
                    byte[] r42 = this.f2167.f763.mo8165(r4);
                    if (r42 == null) {
                        i = 1;
                    } else {
                        i = this.f2167.mo7926(r42);
                    }
                    if (i == 2 && this.f2167.f762.mo8195()) {
                        this.f2167.f762.mo8194();
                    }
                    if (!this.f2167.f766 && i == 1) {
                        return false;
                    }
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                HelperUtils.m2474(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            HelperUtils.m2474(fileInputStream);
            throw th;
        }
    }

    /* renamed from: c */
    public void mo7366c(File file) {
        this.f2167.f762.mo8193();
    }
}
