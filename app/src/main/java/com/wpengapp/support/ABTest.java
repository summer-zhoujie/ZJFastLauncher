package com.wpengapp.support;

import android.content.Context;
import android.text.TextUtils;
import com.wpengapp.support.ImprintHandler;

/* renamed from: com.wpengapp.support.դ */
public class ABTest implements OnImprintChangedListener {

    /* renamed from: ֏ */
    public static ABTest f2062;

    /* renamed from: ؠ */
    public boolean f2063 = false;

    /* renamed from: ހ */
    public int f2064 = -1;

    /* renamed from: ށ */
    public int f2065 = -1;

    /* renamed from: ނ */
    public int f2066 = -1;

    /* renamed from: ރ */
    public float f2067 = 0.0f;

    /* renamed from: ބ */
    public float f2068 = 0.0f;

    /* renamed from: ޅ */
    public Context f2069 = null;

    public ABTest(Context context, String str, int i) {
        this.f2069 = context;
        mo8683(str, i);
    }

    /* renamed from: ֏ */
    public static synchronized ABTest m2129(Context context) {
        ABTest r4;
        synchronized (ABTest.class) {
            if (f2062 == null) {
                ImprintHandler.C0654 r1 = ImprintHandler.m1668(context).f1682;
                f2062 = new ABTest(context, r1.mo8415((String) null), r1.mo8413(0));
            }
            r4 = f2062;
        }
        return r4;
    }

    public String toString() {
        StringBuilder r0 = outline.m2549(" p13:");
        r0.append(this.f2067);
        r0.append(" p07:");
        r0.append(this.f2068);
        r0.append(" policy:");
        r0.append(this.f2064);
        r0.append(" interval:");
        r0.append(this.f2065);
        return r0.toString();
    }

    /* renamed from: ؠ */
    public final float mo8684(String str, int i) {
        int i2 = i * 2;
        if (str == null) {
            return 0.0f;
        }
        return ((float) Integer.valueOf(str.substring(i2, i2 + 5), 16).intValue()) / 1048576.0f;
    }

    /* renamed from: ؠ */
    public final void mo8685(String str) {
        if (str != null) {
            String[] split = str.split("\\|");
            float f = 0.0f;
            if (split[2].equals("SIG13")) {
                f = Float.valueOf(split[3]).floatValue();
            }
            if (this.f2067 > f) {
                this.f2063 = false;
                return;
            }
            int intValue = split[0].equals("FIXED") ? Integer.valueOf(split[1]).intValue() : -1;
            int[] iArr = null;
            if (split[4].equals("RPT")) {
                String[] split2 = split[5].split(",");
                iArr = new int[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    iArr[i] = Integer.valueOf(split2[i]).intValue();
                }
            } else if (split[4].equals("DOM")) {
                if (DeviceConfig.m2331(this.f2069)) {
                    this.f2063 = false;
                    return;
                }
                try {
                    String[] split3 = split[5].split(",");
                    iArr = new int[split3.length];
                    for (int i2 = 0; i2 < split3.length; i2++) {
                        iArr[i2] = Integer.valueOf(split3[i2]).intValue();
                    }
                } catch (Exception unused) {
                }
            }
            if (intValue != -1) {
                this.f2063 = true;
                this.f2066 = intValue;
                if (iArr != null) {
                    this.f2064 = iArr[intValue - 1];
                    return;
                }
                return;
            }
            this.f2063 = false;
        }
    }

    /* renamed from: ֏ */
    public void mo8683(String str, int i) {
        this.f2065 = i;
        String r4 = Envelope.m3063(this.f2069);
        if (TextUtils.isEmpty(r4) || TextUtils.isEmpty(str)) {
            this.f2063 = false;
            return;
        }
        try {
            this.f2067 = mo8684(r4, 12);
            this.f2068 = mo8684(r4, 6);
            if (str.startsWith("SIG7")) {
                mo8682(str);
            } else if (str.startsWith("FIXED")) {
                mo8685(str);
            }
        } catch (Exception e) {
            this.f2063 = false;
            MLog.m1777(MLog.f1805, outline.m2556("v:", str), e);
        }
    }

    /* renamed from: ֏ */
    public final void mo8682(String str) {
        float[] fArr;
        if (str != null) {
            String[] split = str.split("\\|");
            float f = 0.0f;
            if (this.f2067 > (split[2].equals("SIG13") ? Float.valueOf(split[3]).floatValue() : 0.0f)) {
                this.f2063 = false;
                return;
            }
            int[] iArr = null;
            if (split[0].equals("SIG7")) {
                String[] split2 = split[1].split(",");
                fArr = new float[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    fArr[i] = Float.valueOf(split2[i]).floatValue();
                }
            } else {
                fArr = null;
            }
            if (split[4].equals("RPT")) {
                String[] split3 = split[5].split(",");
                iArr = new int[split3.length];
                for (int i2 = 0; i2 < split3.length; i2++) {
                    iArr[i2] = Integer.valueOf(split3[i2]).intValue();
                }
            } else if (split[4].equals("DOM")) {
                if (DeviceConfig.m2331(this.f2069)) {
                    this.f2063 = false;
                    return;
                }
                try {
                    String[] split4 = split[5].split(",");
                    iArr = new int[split4.length];
                    for (int i3 = 0; i3 < split4.length; i3++) {
                        iArr[i3] = Integer.valueOf(split4[i3]).intValue();
                    }
                } catch (Exception unused) {
                }
            }
            int i4 = 0;
            while (true) {
                if (i4 >= fArr.length) {
                    i4 = -1;
                    break;
                }
                f += fArr[i4];
                if (this.f2068 < f) {
                    break;
                }
                i4++;
            }
            if (i4 != -1) {
                this.f2063 = true;
                this.f2066 = i4 + 1;
                if (iArr != null) {
                    this.f2064 = iArr[i4];
                    return;
                }
                return;
            }
            this.f2063 = false;
        }
    }

    /* renamed from: ֏ */
    public int mo8681() {
        return this.f2064;
    }

    /* renamed from: ֏ */
    public void mo8091(ImprintHandler.C0654 r3) {
        mo8683(r3.mo8415((String) null), r3.mo8413(0));
    }
}
