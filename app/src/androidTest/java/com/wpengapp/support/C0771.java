package com.wpengapp.support;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.text.BidiFormatter;
import android.support.p000v4.view.ViewCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.wpengapp.support.activity.AboutActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ե */
/* compiled from: ShareHelper */
public class C0771 {

    /* renamed from: ֏ */
    public static final SP<String> f1989 = new StringSP("GRADE_VERSION", BidiFormatter.EMPTY_STRING);

    /* renamed from: ؠ */
    public static final SP<Long> f1990 = new LongSP("GRADE_DATE", -1L);

    /* renamed from: ހ */
    public static Map<String, String> f1991 = new HashMap();

    /* renamed from: com.wpengapp.support.Ե$֏ */
    /* compiled from: ShareHelper */
    public interface C0772 {
        /* renamed from: ֏ */
        void mo8216(String str, String str2);
    }

    static {
        f1991.put("252408582", "mfBkXLoZQfuDWL0gt3cFc5nm8c9UrzKe");
        f1991.put("97688746", "HfTEsVcCBEihwbRDp-v70rqADrxCXFIK");
        f1991.put("234365425", "6RqIAAiffN4_ZgoCfgztV1KJPlXkzEJv");
        f1991.put("250812186", "I0AvdF3_QrSVltz2jCymy6b_9qQQBGTZ");
        f1991.put("793441874", "dfmwVYH_ZqBKyjuFFrKicc-QaZP-tZNL");
        f1991.put("1082744863", "GjTmF2k0DG_UQTLK6LCCs0wpkJ0Yalmn");
        f1991.put("1070747458", "Th2BiU5G4VrD_FXIrKO-bO8af2YTIfcN");
        f1991.put("1070753939", "DTpTan4HOyQX375mc7B9vQ1YFpVLlicZ");
        f1991.put("1070753315", "YvMpmwwwAeWEntMBlsjM8Ze-3-5QXqDL");
        f1991.put("1071111769", "xRevdW7zEgxgOCUsGOS6hG3lzW_OaqWI");
        f1991.put("197258140", "OCOz1uIBIlipm77pIutd6NNL40L1e3is");
        f1991.put("211682616", "dT1RVncGUVyW1cxpuTZIkm3FE7Da0xem");
        f1991.put("234364634", "F_IFpCpqA1YcAp1DFRfahZDC-Vy7pT-U");
        f1991.put("234364945", "p9GaZkSshrhWf6xTCQ18EuqLp0TGzTTa");
        f1991.put("234365228", "FGKmzaqFMvo9jKeFo4Od48H5pUx7ZMLU");
        try {
            String r0 = C1063.m2859("qq_group_keys", (String) null);
            if (!TextUtils.isEmpty(r0)) {
                f1991.putAll((Map) GsonUtil.m2741(r0, new C0726().getType()));
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ Intent m2063(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SEND");
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                intent.setComponent(new ComponentName(str, str2));
            } else {
                intent.setPackage(str);
            }
        }
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.putExtra("android.intent.extra.TITLE", str3);
        return intent;
    }

    /* renamed from: ؠ */
    public static Bitmap m2070(String str, Bitmap bitmap) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(34.285713f);
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, 448, Layout.Alignment.ALIGN_CENTER, 1.0f, 6.8571424f, false);
        int height = staticLayout.getHeight();
        int max = bitmap == null ? Math.max(height + 32, 180) : height + 320 + 48;
        Bitmap createBitmap = Bitmap.createBitmap(480, max, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        int i = 16;
        if (bitmap == null) {
            i = (max - height) / 2;
        } else {
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            int i2 = height + 16 + 16;
            Rect rect2 = new Rect(80, i2, 400, i2 + 320);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            canvas.drawBitmap(bitmap, rect, rect2, paint);
        }
        canvas.translate(16.0f, (float) i);
        staticLayout.draw(canvas);
        return createBitmap;
    }

    /* renamed from: ހ */
    public static boolean m2074(Context context) {
        String r0 = m2075();
        if (TextUtils.isEmpty(r0)) {
            return false;
        }
        String str = f1991.get(r0);
        if (TextUtils.isEmpty(str)) {
            SystemUtils.m3513((CharSequence) r0);
            C0826.m2180((CharSequence) context.getString(R$string.pw_copy_success) + "\n" + r0);
            return false;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + str));
        try {
            SystemUtils.m3510(context, intent);
            return true;
        } catch (Exception unused) {
            SystemUtils.m3513((CharSequence) r0);
            C0826.m2180((CharSequence) context.getString(R$string.pw_copy_success) + "\n" + r0);
            return false;
        }
    }

    /* renamed from: ށ */
    public static String m2075() {
        AboutActivity.C0450 r0 = AboutActivity.f616;
        if (r0 == null || TextUtils.isEmpty(r0.mo7561())) {
            return C1063.m2859("qqgroup", Utils.m1864(R$string.wpengpay_pay_qqgroup, new Object[0]));
        }
        return AboutActivity.f616.mo7561();
    }

    /* renamed from: ނ */
    public static String m2077() {
        String r1 = C1063.m2859("special_app_store", (String) null);
        if (TextUtils.isEmpty(r1) || "*".equals(r1)) {
            return "*";
        }
        if ("-".equals(r1)) {
            return null;
        }
        for (String str : r1.split(",")) {
            if (SystemUtils.m3524(str) != null) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: ރ */
    public static String m2078() {
        return C1063.m2859("wechat", Utils.m1864(R$string.wpengpay_pay_wechat, new Object[0]));
    }

    /* renamed from: ށ */
    public static void m2076(Context context) {
        View inflate = View.inflate(context, R$layout.pw_dialog_grade, (ViewGroup) null);
        C0915 r1 = new C0915(context);
        r1.f2463 = inflate;
        r1.f2471 = new C0765();
        AlertDialog r12 = r1.mo8910();
        inflate.findViewById(R$id.btn_1).setOnClickListener(new ShareHelper(r12, context));
        inflate.findViewById(R$id.btn_2).setOnClickListener(new C1328(r12, context));
        inflate.findViewById(R$id.btn_3).setOnClickListener(new C0871(r12, context));
    }

    /* renamed from: ֏ */
    public static void m2066(Context context, Intent intent) {
        List<ResolveInfo> r0 = SystemUtils.m3521(intent);
        if (r0 != null && r0.size() > 0) {
            if (r0.size() > 1) {
                intent = Intent.createChooser(intent, context.getString(R$string.pw_share_to));
            }
            try {
                SystemUtils.m3511(context, intent, 1677);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: ހ */
    public static String m2073() {
        return C1063.m2859("qq", Utils.m1864(R$string.wpengpay_pay_qq, new Object[0]));
    }

    /* renamed from: ֏ */
    public static /* synthetic */ Intent m2062(String str, Bitmap bitmap) {
        Uri uri;
        if (!TextUtils.isEmpty(str)) {
            try {
                bitmap = m2070(str, bitmap);
            } catch (OutOfMemoryError e) {
                e.getMessage();
            }
        }
        try {
            File r3 = FileManager.m1198();
            File file = new File(r3, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI + System.currentTimeMillis() + ".jpg");
            Utils.m1883(bitmap, Bitmap.CompressFormat.JPEG, file.getAbsolutePath());
            uri = FileManager.m1192(file);
        } catch (Exception e2) {
            e2.getMessage();
            uri = null;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
        intent.setAction("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", uri);
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(3);
        }
        return intent;
    }

    /* renamed from: ؠ */
    public static String m2071() {
        return C1063.m2859(NotificationCompat.CATEGORY_EMAIL, Utils.m1864(R$string.wpengpay_pay_my_email, new Object[0]));
    }

    /* renamed from: ؠ */
    public static void m2072(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - RemoteSP.f915.mo8104().longValue() > 864000000;
        if (z) {
            z = TextUtils.isEmpty(f1989.mo8104());
        }
        if (z) {
            z = currentTimeMillis - f1990.mo8104().longValue() > 2592000000L;
        }
        if (m2077() != null && z) {
            m2076(context);
        }
    }

    /* renamed from: ֏ */
    public static void m2067(Context context, C0772 r8) {
        C0763 r0 = new C0763(context);
        String string = context.getString(R$string.pw_share_app_to);
        GridView gridView = new GridView(context);
        gridView.setNumColumns(3);
        int r3 = C0826.m2168(12.0f);
        gridView.setPadding(r3, r3, r3, r3);
        gridView.setClipToPadding(false);
        gridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        gridView.setHorizontalScrollBarEnabled(false);
        gridView.setVerticalScrollBarEnabled(false);
        C0915 r32 = new C0915(context);
        r32.f2463 = gridView;
        r32.f2464 = string;
        r32.f2483 = (int) (((float) C0915.m2398(r32.f2461).y) * 0.6f);
        AlertDialog r7 = r32.mo8896();
        gridView.setAdapter(r0);
        C0936.m2467(r7);
        r0.f2701 = new C1061(r7, r8);
    }

    /* renamed from: ֏ */
    public static /* synthetic */ List m2064() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
        arrayList.add(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI"));
        arrayList.add(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
        arrayList.add(new ComponentName("com.sina.weibo", BidiFormatter.EMPTY_STRING));
        arrayList.add(new ComponentName("com.android.mms", BidiFormatter.EMPTY_STRING));
        return arrayList;
    }

    /* renamed from: ֏ */
    public static void m2065(Context context) {
        String str;
        UserInfo r0 = C0536.m1309();
        String r1 = SystemUtils.m3519(context.getPackageName());
        if (r0 == null) {
            str = "X";
        } else {
            str = r0.f2120;
        }
        String string = context.getString(R$string.wpengpay_email_subject, new Object[]{r1, str});
        String r02 = C1114.m3001(r0);
        String str2 = Build.BRAND + " " + Build.MODEL;
        StringBuilder r8 = outline.m2549("Api");
        r8.append(Build.VERSION.SDK_INT);
        r8.append(", ");
        r8.append(Build.VERSION.INCREMENTAL);
        r8.append(", ");
        r8.append(Build.VERSION.RELEASE);
        r8.append(", ");
        r8.append(Build.DISPLAY);
        String sb = r8.toString();
        StringBuilder r12 = outline.m2550(r1, " ");
        r12.append(AppUtils.m1159());
        try {
            SystemUtils.m3512(context, m2071(), string, context.getString(R$string.wpengpay_email_text, new Object[]{r12.toString(), r02, str2, sb}));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.util.zip.ZipOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.util.zip.ZipOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.util.zip.ZipOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.util.zip.ZipOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.util.zip.ZipOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.util.zip.ZipOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m2069(Context r13, List<File> r14) {
        /*
            java.io.File[] r0 = com.wpengapp.support.C0975.m2603()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = com.wpengapp.support.CollectionUtils.m1657((java.util.Collection) r14)
            if (r2 != 0) goto L_0x0012
            r1.addAll(r14)
        L_0x0012:
            if (r0 == 0) goto L_0x001e
            int r14 = r0.length
            if (r14 <= 0) goto L_0x001e
            java.util.List r14 = java.util.Arrays.asList(r0)
            r1.addAll(r14)
        L_0x001e:
            boolean r14 = com.wpengapp.support.CollectionUtils.m1657((java.util.Collection) r1)
            r0 = 0
            if (r14 == 0) goto L_0x002d
            int r13 = com.wpengapp.support.R$string.wpengpay_email_no_logs
            java.lang.Object[] r14 = new java.lang.Object[r0]
            com.wpengapp.support.C0826.m2179(r13, r14)
            return
        L_0x002d:
            java.io.File r14 = new java.io.File
            java.io.File r2 = com.wpengapp.support.FileManager.m1198()
            java.lang.String r3 = "tmplog"
            r14.<init>(r2, r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0041:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x005d
            java.lang.Object r3 = r1.next()
            java.io.File r3 = (java.io.File) r3
            java.io.File r4 = new java.io.File
            java.lang.String r5 = r3.getName()
            r4.<init>(r14, r5)
            com.wpengapp.support.FileUtils.m1131((java.io.File) r3, (java.io.File) r4)
            r2.add(r4)
            goto L_0x0041
        L_0x005d:
            com.wpengapp.support.א r1 = com.wpengapp.support.C0536.m1309()
            java.lang.String r3 = r13.getPackageName()
            java.lang.String r3 = com.wpengapp.support.SystemUtils.m3519((java.lang.String) r3)
            if (r1 != 0) goto L_0x006e
            java.lang.String r4 = "X"
            goto L_0x0070
        L_0x006e:
            java.lang.String r4 = r1.f2120
        L_0x0070:
            int r5 = com.wpengapp.support.R$string.wpengpay_email_subject2
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r0] = r3
            r8 = 1
            r7[r8] = r4
            java.lang.String r5 = r13.getString(r5, r7)
            java.lang.String r1 = com.wpengapp.support.C1114.m3001(r1)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = android.os.Build.BRAND
            r7.append(r9)
            java.lang.String r9 = " "
            r7.append(r9)
            java.lang.String r10 = android.os.Build.MODEL
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            java.lang.String r10 = "Api"
            java.lang.StringBuilder r10 = com.wpengapp.support.outline.m2549(r10)
            int r11 = android.os.Build.VERSION.SDK_INT
            r10.append(r11)
            java.lang.String r11 = ", "
            r10.append(r11)
            java.lang.String r12 = android.os.Build.VERSION.INCREMENTAL
            r10.append(r12)
            r10.append(r11)
            java.lang.String r12 = android.os.Build.VERSION.RELEASE
            r10.append(r12)
            r10.append(r11)
            java.lang.String r11 = android.os.Build.DISPLAY
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.StringBuilder r3 = com.wpengapp.support.outline.m2550((java.lang.String) r3, (java.lang.String) r9)
            java.lang.String r9 = com.wpengapp.support.AppUtils.m1159()
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r9 = com.wpengapp.support.R$string.wpengpay_email_text
            r11 = 4
            java.lang.Object[] r11 = new java.lang.Object[r11]
            r11[r0] = r3
            r11[r8] = r1
            r11[r6] = r7
            r1 = 3
            r11[r1] = r10
            java.lang.String r1 = r13.getString(r9, r11)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "log-"
            r3.append(r6)
            r3.append(r4)
            java.lang.String r4 = "-"
            r3.append(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            java.lang.String r6 = "yyyyMMddHHmmss"
            java.lang.String r4 = com.wpengapp.support.DateUtils.m2699(r4, r6)
            r3.append(r4)
            java.lang.String r4 = ".zip"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.io.File r4 = new java.io.File
            java.io.File r6 = com.wpengapp.support.FileManager.m1198()
            r4.<init>(r6, r3)
            boolean r3 = com.wpengapp.support.CollectionUtils.m1657((java.util.Collection) r2)
            if (r3 == 0) goto L_0x011e
            goto L_0x0197
        L_0x011e:
            r3 = 0
            java.io.File r6 = r4.getParentFile()     // Catch:{ Exception -> 0x018c, all -> 0x0189 }
            r6.mkdirs()     // Catch:{ Exception -> 0x018c, all -> 0x0189 }
            r4.createNewFile()     // Catch:{ Exception -> 0x018c, all -> 0x0189 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x018c, all -> 0x0189 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x018c, all -> 0x0189 }
            java.util.zip.ZipOutputStream r7 = new java.util.zip.ZipOutputStream     // Catch:{ Exception -> 0x0187 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0187 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
        L_0x0137:
            boolean r8 = r2.hasNext()     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            if (r8 == 0) goto L_0x017d
            java.lang.Object r8 = r2.next()     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            java.io.File r8 = (java.io.File) r8     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            java.util.zip.ZipEntry r10 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            java.lang.String r11 = r8.getName()     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            r7.putNextEntry(r10)     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ Exception -> 0x016a, all -> 0x0168 }
            r10.<init>(r8)     // Catch:{ Exception -> 0x016a, all -> 0x0168 }
        L_0x0158:
            int r8 = r10.read(r9)     // Catch:{ Exception -> 0x0166 }
            r11 = -1
            if (r8 == r11) goto L_0x016f
            r7.write(r9, r0, r8)     // Catch:{ Exception -> 0x0166 }
            goto L_0x0158
        L_0x0163:
            r2 = move-exception
            r3 = r10
            goto L_0x0176
        L_0x0166:
            r8 = move-exception
            goto L_0x016c
        L_0x0168:
            r2 = move-exception
            goto L_0x0176
        L_0x016a:
            r8 = move-exception
            r10 = r3
        L_0x016c:
            r8.getMessage()     // Catch:{ all -> 0x0163 }
        L_0x016f:
            r7.closeEntry()     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r10)     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            goto L_0x0137
        L_0x0176:
            r7.closeEntry()     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r3)     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            throw r2     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
        L_0x017d:
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r7)
            goto L_0x0194
        L_0x0181:
            r13 = move-exception
            r3 = r7
            goto L_0x01af
        L_0x0184:
            r2 = move-exception
            r3 = r7
            goto L_0x018e
        L_0x0187:
            r2 = move-exception
            goto L_0x018e
        L_0x0189:
            r13 = move-exception
            r6 = r3
            goto L_0x01af
        L_0x018c:
            r2 = move-exception
            r6 = r3
        L_0x018e:
            r2.getMessage()     // Catch:{ all -> 0x01ae }
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r3)
        L_0x0194:
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r6)
        L_0x0197:
            java.lang.String r2 = m2071()     // Catch:{ Exception -> 0x01a6 }
            m2068(r13, r2, r5, r1, r4)     // Catch:{ Exception -> 0x01a6 }
            int r13 = com.wpengapp.support.R$string.wpengpay_email_send_logs     // Catch:{ Exception -> 0x01a6 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01a6 }
            com.wpengapp.support.C0826.m2172((int) r13, (java.lang.Object[]) r0)     // Catch:{ Exception -> 0x01a6 }
            goto L_0x01aa
        L_0x01a6:
            r13 = move-exception
            r13.getMessage()
        L_0x01aa:
            com.wpengapp.support.FileUtils.m1130((java.io.File) r14)
            return
        L_0x01ae:
            r13 = move-exception
        L_0x01af:
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r3)
            com.wpengapp.support.FileUtils.m1126((java.io.Closeable) r6)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0771.m2069(android.content.Context, java.util.List):void");
    }

    /* renamed from: ֏ */
    public static void m2068(Context context, String str, String str2, String str3, File file) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.SEND");
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("android.intent.extra.SUBJECT", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                intent.putExtra("android.intent.extra.TEXT", str3);
            }
            intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
            intent.putExtra("android.intent.extra.STREAM", FileManager.m1192(file));
            intent.setType("*/*");
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(3);
            }
            SystemUtils.m3510(context, Intent.createChooser(intent, "Mail To"));
        }
    }
}
