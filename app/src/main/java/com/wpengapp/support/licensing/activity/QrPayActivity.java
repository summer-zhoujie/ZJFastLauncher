package com.wpengapp.support.licensing.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.text.BidiFormatter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.wpengapp.baseui.widget.BaseWebView;
import com.wpengapp.support.ActivityKiller;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0536;
import com.wpengapp.support.C0678;
import com.wpengapp.support.C0691;
import com.wpengapp.support.C0702;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0966;
import com.wpengapp.support.C1027;
import com.wpengapp.support.C1264;
import com.wpengapp.support.IPayResultChecker;
import com.wpengapp.support.ObjectCache;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.R$color;
import com.wpengapp.support.R$drawable;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.licensing.model.QrPayDto;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicInteger;

public class QrPayActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public C0454 f684;

    /* renamed from: ؠ */
    public boolean f685;

    /* renamed from: ހ */
    public TextView f686;

    /* renamed from: ށ */
    public QrPayDto f687;

    /* renamed from: ނ */
    public boolean f688;

    /* renamed from: ރ */
    public FrameLayout f689;

    /* renamed from: ބ */
    public BaseWebView f690;

    /* renamed from: ޅ */
    public boolean f691;

    /* renamed from: ކ */
    public Runnable f692 = new C1208(this);

    /* renamed from: com.wpengapp.support.licensing.activity.QrPayActivity$֏ */
    public interface C0454 {
        /* renamed from: ֏ */
        void mo7862(boolean z, String str);
    }

    /* renamed from: ބ */
    public static /* synthetic */ void m872(QrPayActivity qrPayActivity) {
        qrPayActivity.f685 = true;
        C0536.m1326();
        qrPayActivity.finish();
    }

    public void onBackPressed() {
        if (this.f690 != null) {
            mo7859();
            return;
        }
        C0915 r0 = new C0915(this);
        r0.mo8905(R$string.wpengpay_exit_pay_msg);
        r0.mo8900(R$string.wpengpay_exit_pay, (OnDialogClickListener) new C0756(this));
        r0.mo8906(R$string.wpengpay_has_paid, (OnDialogClickListener) new C0537(this));
        r0.mo8910();
    }

    public void onClick(View view) {
        if (view.getId() == R$id.tv_demo) {
            mo7420((Class<?>) WechatReadQrDemoActivity.class);
        } else if (view.getId() == R$id.tv_open_alipay) {
            mo7860();
        } else if (view.getId() == R$id.tv_has_paid) {
            mo7861();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f691 = true;
        }
        setContentView(R$layout.pw_activity_qr_pay);
        mo7434().setBackgroundColor(0);
        findViewById(R$id.toolbarLine).setVisibility(4);
        this.f686 = (TextView) findViewById(R$id.tv_wait);
        this.f689 = (FrameLayout) findViewById(R$id.webview_container);
        this.f687 = (QrPayDto) getIntent().getSerializableExtra("pay_model");
        this.f684 = (C0454) ObjectCache.m1662(getIntent().getIntExtra("callback_index", -1));
        if (this.f687 == null) {
            finish();
            return;
        }
        this.f688 = getIntent().getBooleanExtra("alipay", false);
        ActivityKiller.f1598.put(this, this);
        QrPayDto qrPayDto = this.f687;
        String valueOf = String.valueOf(C0678.m1723(qrPayDto.needPayAmount));
        ((TextView) findViewById(R$id.tv_amount)).setText(getString(R$string.wpengpay_format_price, new Object[]{valueOf}));
        ImageView imageView = (ImageView) findViewById(R$id.img_qr);
        imageView.post(new C0966(this, imageView, qrPayDto));
        if (qrPayDto.supportSaveQr) {
            findViewById(R$id.layout_save_qr).setVisibility(0);
        }
        if (this.f688) {
            findViewById(R$id.tv_open_alipay).setVisibility(0);
            ((TextView) findViewById(R$id.tv_title)).setText(R$string.wpengpay_scan_alipay_qr);
            findViewById(R$id.layout_top).setBackgroundResource(R$color.pw_alipay_bg);
            findViewById(R$id.tv_has_paid).setBackgroundResource(R$color.pw_alipay_bg);
            ((ImageView) findViewById(R$id.img_qr_icon)).setImageResource(R$drawable.pw_ic_alipay);
            if (!this.f691) {
                C0915 r6 = new C0915(this);
                r6.mo8905(R$string.wpengpay_open_alipay_tips);
                r6.mo8900(R$string.pw_cancel, (OnDialogClickListener) new com.wpengapp.support.QrPayActivity(this));
                r6.mo8906(R$string.wpengpay_open_alipay, (OnDialogClickListener) new C1027(this));
                r6.mo8910();
            }
        } else {
            findViewById(R$id.tv_open_alipay).setVisibility(8);
            ((TextView) findViewById(R$id.tv_title)).setText(R$string.wpengpay_scan_wx_qr);
            findViewById(R$id.layout_top).setBackgroundResource(R$color.pw_wechat_bg);
            findViewById(R$id.tv_has_paid).setBackgroundResource(R$color.pw_wechat_bg);
            ((ImageView) findViewById(R$id.img_qr_icon)).setImageResource(R$drawable.pw_ic_wechat);
        }
        if (this.f691) {
            AppUtils.m1147(this.f692, 100);
        } else {
            AppUtils.m1147(this.f692, 10000);
        }
        AppUtils.m1147((Runnable) new C0691(this), 600);
    }

    public void onDestroy() {
        super.onDestroy();
        AppUtils.m1152(this.f692);
        mo7859();
        C0454 r0 = this.f684;
        if (r0 != null) {
            boolean z = this.f685;
            r0.mo7862(z, z ? BidiFormatter.EMPTY_STRING : getString(R$string.wpengpay_error_user_cancel));
        }
    }

    /* renamed from: ֏ */
    public boolean mo7423() {
        return true;
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return BidiFormatter.EMPTY_STRING;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ގ */
    public final void mo7859() {
        this.f689.setVisibility(8);
        BaseWebView baseWebView = this.f690;
        if (baseWebView != null) {
            baseWebView.destroy();
            this.f690 = null;
            mo7430();
        }
        this.f689.removeAllViews();
    }

    /* renamed from: ޏ */
    public final void mo7860() {
        if (this.f688) {
            String str = this.f687.qrContent;
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (Exception e) {
                e.getMessage();
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp?saId=10000007&qrcode=" + str));
            intent.setFlags(268435456);
            try {
                startActivity(intent);
            } catch (Exception e2) {
                e2.getMessage();
                this.f689.setVisibility(0);
                this.f690 = new BaseWebView(this);
                this.f690.setWebViewClient(new C1264(this));
                this.f690.setWebChromeClient(new C0702(this));
                this.f689.addView(this.f690, -1, -1);
                this.f690.loadUrl(this.f687.qrContent);
            }
        }
    }

    /* renamed from: ސ */
    public final void mo7861() {
        if (this.f684 != null) {
            int i = this.f687.biz;
            C0602 r1 = new C0602(this);
            C1330 r2 = new C1330(this);
            IPayResultChecker r0 = C0678.f1771.get(i);
            if (r0 == null) {
                r2.run();
            } else {
                r0.mo8392(r1, r2);
            }
        }
    }

    /* renamed from: ֏ */
    public static void m865(Activity activity, boolean z, QrPayDto qrPayDto, C0454 r5) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(ObjectCache.m1661((Object) new C0898(atomicInteger, r5)));
        Intent intent = new Intent(activity, QrPayActivity.class);
        intent.putExtra("pay_model", qrPayDto);
        intent.putExtra("callback_index", atomicInteger.get());
        intent.putExtra("alipay", z);
        activity.startActivity(intent);
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, R$drawable.baseui_ic_toolbar_close);
    }
}
