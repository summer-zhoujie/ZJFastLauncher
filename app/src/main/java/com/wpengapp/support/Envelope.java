package com.wpengapp.support;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.DataHelper;
import com.wpengapp.support.TCompactProtocol;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* renamed from: com.wpengapp.support.ଡ଼ */
public class Envelope {

    /* renamed from: ֏ */
    public final byte[] f3252 = {0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: ؠ */
    public String f3253 = "1.0";

    /* renamed from: ހ */
    public String f3254;

    /* renamed from: ށ */
    public byte[] f3255;

    /* renamed from: ނ */
    public byte[] f3256;

    /* renamed from: ރ */
    public byte[] f3257;

    /* renamed from: ބ */
    public int f3258;

    /* renamed from: ޅ */
    public int f3259;

    /* renamed from: ކ */
    public int f3260;

    /* renamed from: އ */
    public byte[] f3261;

    /* renamed from: ވ */
    public byte[] f3262;

    /* renamed from: މ */
    public boolean f3263;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Envelope(byte[] r5, String r6, byte[] r7) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 8
            byte[] r0 = new byte[r0]
            r0 = {0, 0, 0, 0, 0, 0, 0, 0} // fill-array
            r4.f3252 = r0
            java.lang.String r0 = "1.0"
            r4.f3253 = r0
            r0 = 0
            r4.f3254 = r0
            r4.f3255 = r0
            r4.f3256 = r0
            r4.f3257 = r0
            r1 = 0
            r4.f3258 = r1
            r4.f3259 = r1
            r4.f3260 = r1
            r4.f3261 = r0
            r4.f3262 = r0
            r4.f3263 = r1
            if (r5 == 0) goto L_0x0080
            int r2 = r5.length
            if (r2 == 0) goto L_0x0080
            r4.f3254 = r6
            int r6 = r5.length
            r4.f3260 = r6
            int r6 = r5.length
            if (r6 > 0) goto L_0x0034
            goto L_0x0067
        L_0x0034:
            java.util.zip.Deflater r6 = new java.util.zip.Deflater
            r6.<init>()
            r6.setInput(r5)
            r6.finish()
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]
            com.wpengapp.support.Utils.f1898 = r1
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0079 }
            r2.<init>()     // Catch:{ all -> 0x0079 }
        L_0x004a:
            boolean r0 = r6.finished()     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x005d
            int r0 = r6.deflate(r5)     // Catch:{ all -> 0x0076 }
            int r3 = com.wpengapp.support.Utils.f1898     // Catch:{ all -> 0x0076 }
            int r3 = r3 + r0
            com.wpengapp.support.Utils.f1898 = r3     // Catch:{ all -> 0x0076 }
            r2.write(r5, r1, r0)     // Catch:{ all -> 0x0076 }
            goto L_0x004a
        L_0x005d:
            r6.end()     // Catch:{ all -> 0x0076 }
            r2.close()
            byte[] r0 = r2.toByteArray()
        L_0x0067:
            r4.f3261 = r0
            long r5 = java.lang.System.currentTimeMillis()
            r0 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r0
            int r6 = (int) r5
            r4.f3259 = r6
            r4.f3262 = r7
            return
        L_0x0076:
            r5 = move-exception
            r0 = r2
            goto L_0x007a
        L_0x0079:
            r5 = move-exception
        L_0x007a:
            if (r0 == 0) goto L_0x007f
            r0.close()
        L_0x007f:
            throw r5
        L_0x0080:
            java.lang.Exception r5 = new java.lang.Exception
            java.lang.String r6 = "entity is null or empty"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Envelope.<init>(byte[], java.lang.String, byte[]):void");
    }

    /* renamed from: ֏ */
    public static String m3063(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("signature", (String) null);
    }

    /* renamed from: ؠ */
    public static Envelope m3064(Context context, String str, byte[] bArr) {
        try {
            String r3 = DeviceConfig.m2334(context);
            String r4 = DeviceConfig.m2324(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
            String string = sharedPreferences.getString("signature", (String) null);
            int i = sharedPreferences.getInt("serial", 1);
            Envelope r9 = new Envelope(bArr, str, (r4 + r3).getBytes());
            r9.f3263 = true;
            r9.f3255 = DataHelper.m61a(string);
            r9.f3258 = i;
            r9.mo9337();
            sharedPreferences.edit().putInt("serial", i + 1).putString("signature", DataHelper.m59a(r9.f3255)).commit();
            r9.mo9339(context);
            return r9;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return String.format("version : %s\n", new Object[]{this.f3253}) + String.format("address : %s\n", new Object[]{this.f3254}) + String.format("signature : %s\n", new Object[]{DataHelper.m59a(this.f3255)}) + String.format("serial : %s\n", new Object[]{Integer.valueOf(this.f3258)}) + String.format("timestamp : %d\n", new Object[]{Integer.valueOf(this.f3259)}) + String.format("length : %d\n", new Object[]{Integer.valueOf(this.f3260)}) + String.format("guid : %s\n", new Object[]{DataHelper.m59a(this.f3256)}) + String.format("checksum : %s ", new Object[]{DataHelper.m59a(this.f3257)}) + String.format("codex : %d", new Object[]{Integer.valueOf(this.f3263 ? 1 : 0)});
    }

    /* renamed from: ֏ */
    public static Envelope m3062(Context context, String str, byte[] bArr) {
        try {
            String r3 = DeviceConfig.m2334(context);
            String r4 = DeviceConfig.m2324(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
            String string = sharedPreferences.getString("signature", (String) null);
            int i = sharedPreferences.getInt("serial", 1);
            Envelope r9 = new Envelope(bArr, str, (r4 + r3).getBytes());
            r9.f3255 = DataHelper.m61a(string);
            r9.f3258 = i;
            r9.mo9337();
            sharedPreferences.edit().putInt("serial", i + 1).putString("signature", DataHelper.m59a(r9.f3255)).commit();
            r9.mo9339(context);
            return r9;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: ؠ */
    public byte[] mo9340() {
        ByteBuffer byteBuffer;
        UMEnvelope r0 = new UMEnvelope();
        r0.f3421 = this.f3253;
        r0.f3422 = this.f3254;
        r0.f3423 = DataHelper.m59a(this.f3255);
        r0.f3424 = this.f3258;
        r0.mo9436(true);
        r0.f3425 = this.f3259;
        r0.mo9437(true);
        r0.f3426 = this.f3260;
        r0.mo9438(true);
        byte[] bArr = this.f3261;
        if (bArr == null) {
            byteBuffer = null;
        } else {
            byteBuffer = ByteBuffer.wrap(bArr);
        }
        r0.f3427 = byteBuffer;
        r0.f3430 = this.f3263 ? 1 : 0;
        r0.mo9442(true);
        r0.f3428 = DataHelper.m59a(this.f3256);
        r0.f3429 = DataHelper.m59a(this.f3257);
        try {
            TCompactProtocol.C1221 r1 = new TCompactProtocol.C1221();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            TProtocol r12 = r1.mo9274(new TIOStreamTransport(byteArrayOutputStream));
            byteArrayOutputStream.reset();
            r0.mo9122(r12);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: ֏ */
    public void mo9337() {
        if (this.f3255 == null) {
            this.f3255 = mo9338(this.f3252, (int) (System.currentTimeMillis() / 1000));
        }
        if (this.f3263) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.f3255, 1, bArr, 0, 16);
                this.f3261 = DataHelper.m62a(this.f3261, bArr);
            } catch (Exception unused) {
            }
        }
        this.f3256 = mo9338(this.f3255, this.f3259);
        this.f3257 = DataHelper.m64b((DataHelper.m59a(this.f3255) + this.f3258 + this.f3259 + this.f3260 + DataHelper.m59a(this.f3256)).getBytes());
    }

    /* renamed from: ֏ */
    public final byte[] mo9338(byte[] bArr, int i) {
        byte[] b = DataHelper.m64b(this.f3262);
        byte[] b2 = DataHelper.m64b(this.f3261);
        int length = b.length;
        byte[] bArr2 = new byte[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr2[i3] = b2[i2];
            bArr2[i3 + 1] = b[i2];
        }
        for (int i4 = 0; i4 < 2; i4++) {
            bArr2[i4] = bArr[i4];
            bArr2[(bArr2.length - i4) - 1] = bArr[(bArr.length - i4) - 1];
        }
        byte[] bArr3 = {(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) (i >>> 24)};
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            bArr2[i5] = (byte) (bArr2[i5] ^ bArr3[i5 % 4]);
        }
        return bArr2;
    }

    /* renamed from: ؠ */
    public void mo9339(Context context) {
        String str = this.f3254;
        String str2 = ImprintHandler.m1668(context).f1682.f1692;
        String a = DataHelper.m59a(this.f3255);
        byte[] bArr = new byte[16];
        System.arraycopy(this.f3255, 2, bArr, 0, 16);
        String a2 = DataHelper.m59a(DataHelper.m64b(bArr));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", str);
            if (str2 != null) {
                jSONObject.put("umid", str2);
            }
            jSONObject.put("signature", a);
            jSONObject.put("checksum", a2);
            String jSONObject2 = jSONObject.toString();
            File file = new File(context.getFilesDir(), ".umeng");
            if (!file.exists()) {
                file.mkdir();
            }
            HelperUtils.m2470(new File(file, "exchangeIdentity.json"), jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
