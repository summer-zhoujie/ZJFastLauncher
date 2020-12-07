package com.wpengapp.support;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Base64;
import com.wpengapp.support.Request;
import com.wpengapp.support.licensing.thirdpart.p006wp.PayResult;
import dalvik.system.DexClassLoader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: com.wpengapp.support.Ⴌ */
/* compiled from: WpAlipay */
public class C1305 {

    /* renamed from: ֏ */
    public static Class<?> f3716;

    /* renamed from: ؠ */
    public Activity f3717;

    /* renamed from: ހ */
    public String f3718;

    /* renamed from: ށ */
    public String f3719;

    /* renamed from: ނ */
    public String f3720;

    /* renamed from: ރ */
    public String f3721;

    /* renamed from: ބ */
    public float f3722;

    /* renamed from: ޅ */
    public String f3723;

    /* renamed from: ކ */
    public String f3724;

    /* renamed from: އ */
    public String f3725;

    /* renamed from: ވ */
    public String f3726;

    /* renamed from: މ */
    public String f3727;

    /* renamed from: ފ */
    public String f3728;

    /* renamed from: ދ */
    public String f3729;

    /* renamed from: ތ */
    public String f3730;

    /* renamed from: ލ */
    public String f3731;

    /* renamed from: ގ */
    public String f3732;

    /* renamed from: ޏ */
    public WpAlipayCallback f3733;

    /* renamed from: ސ */
    public ProgressDialog f3734;

    public C1305(Activity activity, String str, String str2, String str3, String str4, float f, String str5, String str6, String str7, String str8, WpAlipayCallback r11) {
        this.f3717 = activity;
        this.f3718 = str;
        this.f3719 = str2;
        this.f3721 = str4;
        this.f3722 = f;
        this.f3723 = str5;
        this.f3724 = str6;
        this.f3725 = str7;
        if (!TextUtils.isEmpty(this.f3725)) {
            this.f3725 = this.f3725.replace("https", "http");
        }
        this.f3726 = str8;
        this.f3720 = str3;
        if (TextUtils.isEmpty(this.f3719)) {
            this.f3719 = "WPeng";
        }
        this.f3733 = new C0768(this, r11);
        if (TextUtils.isEmpty(this.f3718)) {
            this.f3718 = "f848677affc4ceab4adc6c5718c061df";
        }
        if (TextUtils.isEmpty(this.f3723)) {
            this.f3723 = SystemUtils.m3519(activity.getPackageName());
        }
        if (TextUtils.isEmpty(this.f3724)) {
            this.f3724 = this.f3723;
        }
        String r1 = DateUtils.m2699(new Date(), "yyyyMMddHHmmss");
        Random random = new Random();
        StringBuilder r12 = outline.m2549(r1);
        r12.append(Math.abs(random.nextInt()));
        this.f3727 = r12.toString();
    }

    /* renamed from: ؠ */
    public static String m3546(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return BidiFormatter.EMPTY_STRING;
        }
        try {
            try {
                str2 = Base64.encodeToString(new DESUtil("12345678").mo8067(str.getBytes("UTF8")), 0);
            } catch (Exception e) {
                e.printStackTrace();
                str2 = BidiFormatter.EMPTY_STRING;
            }
            return URLEncoder.encode(str2, "UTF-8");
        } catch (Exception e2) {
            e2.getMessage();
            return BidiFormatter.EMPTY_STRING;
        }
    }

    /* renamed from: ֏ */
    public final String mo9567() {
        StringBuilder r0 = outline.m2550("partner=", "\"");
        r0.append(this.f3728);
        r0.append("\"");
        r0.append("&seller=");
        r0.append("\"");
        r0.append(this.f3729);
        r0.append("\"");
        r0.append("&out_trade_no=");
        r0.append("\"");
        r0.append(this.f3727);
        r0.append("\"");
        r0.append("&subject=");
        r0.append("\"");
        r0.append(this.f3723);
        r0.append("\"");
        r0.append("&body=");
        r0.append("\"");
        r0.append(this.f3724);
        r0.append("\"");
        r0.append("&total_fee=");
        r0.append("\"");
        r0.append(this.f3722);
        r0.append("\"");
        if (TextUtils.isEmpty(this.f3732)) {
            this.f3732 = "www";
        }
        r0.append("&notify_url=");
        r0.append("\"");
        return outline.m2548(r0, this.f3732, "\"");
    }

    /* renamed from: ހ */
    public final void mo9568(String str) {
        "handlePayResult " + str;
        PayResult payResult = new PayResult();
        payResult.parseAlipay(str);
        try {
            if (new AlipayResultChecker(str, "normal", this.f3730).mo8717() == 1) {
                this.f3733.mo8503(false, this.f3717.getString(R$string.wpengpay_error_wp_09));
            } else if (PayResult.STATUS_SUCCESS.equals(payResult.resultStatus)) {
                this.f3733.mo8503(true, this.f3717.getString(R$string.wpengpay_pay_success));
            } else {
                this.f3733.mo8503(false, payResult.memo);
            }
        } catch (Exception unused) {
            this.f3733.mo8503(false, payResult.memo);
        }
    }

    /* renamed from: ށ */
    public final synchronized String mo9569(String str) {
        Object newInstance;
        if (f3716 == null) {
            File r0 = FileManager.m1198();
            File file = new File(r0, "aipsd.jar");
            file.delete();
            Request.C0874 r2 = new Request.C0874();
            r2.mo8833(this.f3726);
            FileUtils.m1129(((C1140) C1279.f3602.mo8741(r2.mo8835())).mo9320().f1355.mo7908().mo8500(), file);
            f3716 = new DexClassLoader(file.getAbsolutePath(), r0.getAbsolutePath(), (String) null, ClassLoader.getSystemClassLoader()).loadClass("com.alipay.sdk.app.PayTask");
            file.delete();
        }
        newInstance = f3716.getConstructor(new Class[]{Activity.class}).newInstance(new Object[]{this.f3717});
        return (String) f3716.getMethod("pay", new Class[]{String.class, Boolean.TYPE}).invoke(newInstance, new Object[]{str, true});
    }

    /* renamed from: ނ */
    public final void mo9570(String str) {
        Document document;
        try {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            document = newInstance.newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.getMessage();
            document = null;
        }
        if (document == null) {
            this.f3733.mo8503(false, this.f3717.getString(R$string.wpengpay_error_wp_server_busy, new Object[]{"2"}));
            return;
        }
        NodeList elementsByTagName = document.getElementsByTagName("Partner");
        if (elementsByTagName == null) {
            this.f3733.mo8503(false, this.f3717.getString(R$string.wpengpay_error_wp_server_busy, new Object[]{"3"}));
            return;
        }
        String r2 = m3545(elementsByTagName);
        String r3 = m3545(document.getElementsByTagName("Seller"));
        String r4 = m3545(document.getElementsByTagName("Rsa_alipay_public"));
        String r5 = m3545(document.getElementsByTagName("Rsa_private"));
        String r6 = m3545(document.getElementsByTagName("Notice_Url"));
        String r7 = m3545(document.getElementsByTagName("Pay_Flag"));
        String r10 = m3545(document.getElementsByTagName("Check_Message"));
        if (!TextUtils.isEmpty(r2)) {
            this.f3728 = m3543(r2);
        }
        if (!TextUtils.isEmpty(r3)) {
            this.f3729 = m3543(r3);
        }
        if (!TextUtils.isEmpty(r4)) {
            this.f3730 = m3543(r4);
        }
        if (!TextUtils.isEmpty(r5)) {
            this.f3731 = m3543(r5);
        }
        if (!TextUtils.isEmpty(r6)) {
            this.f3732 = m3543(r6);
        }
        StringBuilder r22 = outline.m2549("result : partner_id=");
        r22.append(this.f3728);
        r22.append("   seller_id=");
        r22.append(this.f3729);
        r22.toString();
        if ("true".equals(r7)) {
            if (TextUtils.isEmpty(this.f3728) || TextUtils.isEmpty(this.f3729)) {
                this.f3733.mo8503(false, this.f3717.getString(R$string.wpengpay_error_wp_server_busy, new Object[]{"5"}));
                return;
            }
            AppUtils.m1147((Runnable) new C0538(this), (long) ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
            TaskManager.m2715((Runnable) new C0932(this));
        } else if (!TextUtils.isEmpty(r10)) {
            this.f3733.mo8503(false, r10);
        } else {
            this.f3733.mo8503(false, this.f3717.getString(R$string.wpengpay_error_wp_server_busy, new Object[]{"4"}));
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ String m3544(String str, String str2) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2, 0)));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initSign(generatePrivate);
            instance.update(str.getBytes("utf-8"));
            return Base64.encodeToString(instance.sign(), 0);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static String m3543(String str) {
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            try {
                return new String(new DESUtil("12345678").mo8066(Base64.decode(decode, 0)), "UTF8");
            } catch (Exception e) {
                e.printStackTrace();
                return BidiFormatter.EMPTY_STRING;
            }
        } catch (Exception e2) {
            e2.getMessage();
            return BidiFormatter.EMPTY_STRING;
        }
    }

    /* renamed from: ֏ */
    public static String m3545(NodeList nodeList) {
        Element element = (Element) nodeList.item(0);
        if (element != null) {
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            String str = BidiFormatter.EMPTY_STRING;
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item != null) {
                    StringBuilder r3 = outline.m2549(str);
                    r3.append(item.getNodeValue());
                    str = r3.toString();
                }
            }
            if (!TextUtils.isEmpty(str)) {
                return str.trim();
            }
        }
        return null;
    }
}
