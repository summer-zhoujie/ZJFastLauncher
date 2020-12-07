package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Ԇ */
/* compiled from: FileStorage */
class C0761 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Object f1960;

    /* renamed from: ؠ */
    public final /* synthetic */ C1323 f1961;

    public C0761(C1323 r1, Object obj) {
        this.f1961 = r1;
        this.f1960 = obj;
    }

    public void run() {
        byte[] bArr;
        try {
            if (this.f1960 == null) {
                bArr = new byte[0];
            } else if (this.f1961.f3786 == null) {
                bArr = C1323.m3619((String) this.f1960, this.f1961.f3789);
            } else {
                bArr = C1323.m3619(GsonUtil.m2742(this.f1960), this.f1961.f3789);
            }
            FileUtils.m1136(this.f1961.f3790.f2512, bArr);
            C1323.m3617(this.f1961, true);
            this.f1961.mo9615();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
