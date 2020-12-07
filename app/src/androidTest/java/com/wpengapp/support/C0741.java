package com.wpengapp.support;

import com.wpengapp.support.model.App;
import java.util.Map;

/* renamed from: com.wpengapp.support.ҹ */
/* compiled from: UpdateHelper */
class C0741 extends HttpGsonRequest<App.AppVersion> {

    /* renamed from: ދ */
    public final /* synthetic */ RetCallback f1913;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0741(String str, Map map, String str2, RetCallback r4) {
        super(str, map, str2);
        this.f1913 = r4;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<App.AppVersion> r3, ErrorCode r4) {
        if (!(r4 == ErrorCode.SUCCESS || r4 == ErrorCode.SUCCESS_WITH_MSG)) {
            App.AppVersion r32 = UpdateHelper.m743();
            if (r32 == null) {
                this.f1913.mo7932(r4.f1083);
            } else {
                this.f1913.mo7931(r32);
            }
        } else {
            App.AppVersion appVersion = (App.AppVersion) r3.f3518;
            if (appVersion == null) {
                UpdateHelper.m744((App.AppVersion) null);
                this.f1913.mo7931(null);
            } else if (appVersion.versionCode <= AppUtils.m1158()) {
                UpdateHelper.m744((App.AppVersion) null);
                this.f1913.mo7931(null);
            } else {
                UpdateHelper.m744(appVersion);
                this.f1913.mo7931(appVersion);
            }
        }
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        App.AppVersion r0 = UpdateHelper.m743();
        if (r0 == null) {
            this.f1913.mo7932(exc.getMessage());
        } else {
            this.f1913.mo7931(r0);
        }
    }
}
