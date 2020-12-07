package com.wpengapp.support;

import android.content.Context;
import android.util.Base64;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.DataHelper;
import com.umeng.analytics.StoreHelper;
import com.wpengapp.support.TBinaryProtocol;
import java.io.ByteArrayOutputStream;

/* renamed from: com.wpengapp.support.đ */
public class Sender {

    /* renamed from: ֏ */
    public static Context f759;

    /* renamed from: ؠ */
    public IdTracker f760;

    /* renamed from: ހ */
    public ImprintHandler f761;

    /* renamed from: ށ */
    public StatTracer f762;

    /* renamed from: ނ */
    public NetworkHelper f763;

    /* renamed from: ރ */
    public UMEntry f764;

    /* renamed from: ބ */
    public boolean f765 = false;

    /* renamed from: ޅ */
    public boolean f766;

    public Sender(Context context, StatTracer r3) {
        this.f760 = IdTracker.m984(context);
        this.f761 = ImprintHandler.m1668(context);
        f759 = context;
        this.f762 = r3;
        this.f763 = new NetworkHelper(context);
        this.f763.f1095 = this.f762;
    }

    /* renamed from: ֏ */
    public void mo7927() {
        Envelope r0;
        int i;
        if (this.f764 != null) {
            this.f760.mo7934();
            UMEntry r02 = this.f764;
            try {
                C1187 r1 = this.f760.f777;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                TCompactProtocol r6 = new TCompactProtocol(new TIOStreamTransport(byteArrayOutputStream), -1);
                byteArrayOutputStream.reset();
                r1.mo9122((TProtocol) r6);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                r02.f1102.f1186 = Base64.encodeToString(byteArray, 0);
            } catch (Exception e) {
                MLog.m1772((Throwable) e);
            }
            byte[] b = StoreHelper.m156a(f759).mo7344b(r02);
            if (!DataHelper.m60a(f759, b)) {
                if (!this.f765) {
                    Context context = f759;
                    r0 = Envelope.m3062(context, AnalyticsConfig.getAppkey(context), b);
                } else {
                    Context context2 = f759;
                    r0 = Envelope.m3064(context2, AnalyticsConfig.getAppkey(context2), b);
                }
                byte[] r03 = r0.mo9340();
                StoreHelper.m156a(f759).mo7351h();
                byte[] r12 = this.f763.mo8165(r03);
                if (r12 == null) {
                    i = 1;
                } else {
                    i = mo7926(r12);
                }
                if (i != 1) {
                    if (i == 2) {
                        if (this.f762.mo8195()) {
                            this.f762.mo8194();
                        }
                        this.f760.mo7937();
                        this.f762.mo8193();
                        UMEntry.f1101 = 0;
                    } else if (i == 3) {
                        this.f762.mo8193();
                    }
                } else if (!this.f766) {
                    StoreHelper.m156a(f759).mo7340a(r03);
                }
            }
        } else {
            StoreHelper.m156a(f759).mo7353j().mo7357a((StoreHelper.C0405b) new C0830(this));
        }
    }

    /* renamed from: ֏ */
    public final int mo7926(byte[] bArr) {
        C1309 r0 = new C1309();
        try {
            new TDeserializer(new TBinaryProtocol.C1098()).mo9309(r0, bArr);
            if (r0.f3748 == 1) {
                this.f761.mo8410(r0.f3750);
                this.f761.mo8412();
            }
            MLog.m1769("send log:" + r0.f3749);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r0.f3748 == 1 ? 2 : 3;
    }
}
