package com.umeng.analytics.social;

import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import com.wpengapp.support.outline;
import java.util.Locale;

public class UMPlatformData {

    /* renamed from: a */
    public UMedia f224a;

    /* renamed from: b */
    public String f225b = BidiFormatter.EMPTY_STRING;

    /* renamed from: c */
    public String f226c = BidiFormatter.EMPTY_STRING;

    /* renamed from: d */
    public String f227d;

    /* renamed from: e */
    public GENDER f228e;

    public enum GENDER {
        MALE(0) {
            public String toString() {
                return String.format(Locale.US, "Male:%d", new Object[]{Integer.valueOf(this.value)});
            }
        },
        FEMALE(1) {
            public String toString() {
                return String.format(Locale.US, "Female:%d", new Object[]{Integer.valueOf(this.value)});
            }
        };
        
        public int value;

        /* access modifiers changed from: public */
        GENDER(int i) {
            this.value = i;
        }
    }

    public enum UMedia {
        SINA_WEIBO {
            public String toString() {
                return "sina";
            }
        },
        TENCENT_WEIBO {
            public String toString() {
                return "tencent";
            }
        },
        TENCENT_QZONE {
            public String toString() {
                return "qzone";
            }
        },
        TENCENT_QQ {
            public String toString() {
                return "qq";
            }
        },
        WEIXIN_FRIENDS {
            public String toString() {
                return "wxsesion";
            }
        },
        WEIXIN_CIRCLE {
            public String toString() {
                return "wxtimeline";
            }
        },
        RENREN {
            public String toString() {
                return "renren";
            }
        },
        DOUBAN {
            public String toString() {
                return "douban";
            }
        }
    }

    public UMPlatformData(UMedia uMedia, String str) {
        if (uMedia == null || TextUtils.isEmpty(str)) {
            boolean z = UMSocialConstants.f263v;
            return;
        }
        this.f224a = uMedia;
        this.f225b = str;
    }

    public GENDER getGender() {
        return this.f228e;
    }

    public UMedia getMeida() {
        return this.f224a;
    }

    public String getName() {
        return this.f227d;
    }

    public String getUsid() {
        return this.f225b;
    }

    public String getWeiboId() {
        return this.f226c;
    }

    public boolean isValid() {
        return this.f224a != null && !TextUtils.isEmpty(this.f225b);
    }

    public void setGender(GENDER gender) {
        this.f228e = gender;
    }

    public void setName(String str) {
        this.f227d = str;
    }

    public void setWeiboId(String str) {
        this.f226c = str;
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("UMPlatformData [meida=");
        r0.append(this.f224a);
        r0.append(", usid=");
        r0.append(this.f225b);
        r0.append(", weiboId=");
        r0.append(this.f226c);
        r0.append(", name=");
        r0.append(this.f227d);
        r0.append(", gender=");
        return outline.m2546(r0, (Object) this.f228e, "]");
    }
}
