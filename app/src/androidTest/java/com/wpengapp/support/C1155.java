package com.wpengapp.support;

import android.util.Base64;
import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.lightstart.config.DefaultConfig;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.wpengapp.support.ர */
/* compiled from: DefaultConfigManager */
public final class C1155 extends HttpSimpleRequest {

    /* renamed from: ދ */
    public final /* synthetic */ RetCallback f3294;

    /* renamed from: ތ */
    public final /* synthetic */ Set f3295;

    /* renamed from: ލ */
    public final /* synthetic */ boolean f3296;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1155(String str, String str2, Map map, String str3, RetCallback r5, Set set, boolean z) {
        super(str, str2, map, str3);
        this.f3294 = r5;
        this.f3295 = set;
        this.f3296 = z;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<String> r7, ErrorCode r8) {
        if (r8 == ErrorCode.SKAD_CONFIG_NO_UPDATE) {
            RetCallback r72 = this.f3294;
            if (r72 != null) {
                r72.mo7931(C1149.m3083());
            }
            C1149.m3092();
        } else if (r8.mo8156() || r7.f3518 == null) {
            mo9350((Exception) null);
        } else {
            TaskManager.m2715((Runnable) new C1294(this, r7, this.f3295, this.f3296, this.f3294));
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo9349(HttpResponse r5, Set set, boolean z, RetCallback r8) {
        try {
            String r0 = Utils.m1902((String) r5.f3518);
            DefaultConfig defaultConfig = (DefaultConfig) GsonUtil.m2740(r0, DefaultConfig.class);
            defaultConfig.dataLen = ((String) r5.f3518).length();
            if (defaultConfig.configData == null) {
                defaultConfig.configData = new HashMap<>();
            }
            if (CollectionUtils.m1659((Collection) set)) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!defaultConfig.configData.containsKey(str)) {
                        defaultConfig.configData.put(str, new AppConfig());
                    }
                }
            }
            C1149.m3076(defaultConfig, z);
            "loadCloudConfig success, 压缩比：" + ((((float) defaultConfig.dataLen) * 1.0f) / ((float) r0.length()));
            Integer num = defaultConfig.type;
            if (num != null && num.equals(1)) {
                AppUtils.m1147((Runnable) C1291.f3625, (long) AnalyticsConstants.f108k);
            }
            if (r8 != null) {
                AppUtils.m1146((Runnable) new lambda(r8));
            }
            C1149.m3092();
        } catch (Exception e) {
            e.getMessage();
            AppUtils.m1146((Runnable) new C0575(this, e));
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m3101() {
        try {
            RemoteSP.m1206(new String(Base64.decode(C0536.f1032, 0), "UTF-8"), (Object) Long.valueOf(System.currentTimeMillis()), false);
            SpHandler.f1750.mo8105(false);
            C1219.m3283();
            SystemUtils.m3527(C1279.m3439());
        } catch (Exception unused) {
        }
    }

    /* renamed from: ֏ */
    public void mo9350(Exception exc) {
        RetCallback r0 = this.f3294;
        if (r0 == null) {
            return;
        }
        if (exc instanceof MaintainException) {
            r0.mo7932(ErrorCode.MAINTAIN.f1083);
        } else {
            r0.mo7932((String) null);
        }
    }
}
