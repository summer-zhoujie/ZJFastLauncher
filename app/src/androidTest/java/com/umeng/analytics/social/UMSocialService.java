package com.umeng.analytics.social;

import android.content.Context;
import android.os.AsyncTask;
import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import org.json.JSONObject;

public abstract class UMSocialService {

    /* renamed from: com.umeng.analytics.social.UMSocialService$b */
    public interface C0418b {
        /* renamed from: a */
        void mo7392a();

        /* renamed from: a */
        void mo7393a(UMResult dVar, UMPlatformData... uMPlatformDataArr);
    }

    /* renamed from: a */
    public static void m196a(Context context, C0418b bVar, String str, UMPlatformData... uMPlatformDataArr) {
        if (uMPlatformDataArr != null) {
            try {
                int length = uMPlatformDataArr.length;
                int i = 0;
                while (i < length) {
                    if (uMPlatformDataArr[i].isValid()) {
                        i++;
                    } else {
                        throw new UMException("parameter is not valid.");
                    }
                }
            } catch (UMException | Exception unused) {
                return;
            }
        }
        new C0417a(UMUtils.m226a(context, str, uMPlatformDataArr), bVar, uMPlatformDataArr).execute(new Void[0]);
    }

    public static void share(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        m196a(context, (C0418b) null, str, uMPlatformDataArr);
    }

    public static void share(Context context, UMPlatformData... uMPlatformDataArr) {
        m196a(context, (C0418b) null, (String) null, uMPlatformDataArr);
    }

    /* renamed from: com.umeng.analytics.social.UMSocialService$a */
    private static class C0417a extends AsyncTask<Void, Void, UMResult> {

        /* renamed from: a */
        public String f231a;

        /* renamed from: b */
        public String f232b;

        /* renamed from: c */
        public C0418b f233c;

        /* renamed from: d */
        public UMPlatformData[] f234d;

        public C0417a(String[] strArr, C0418b bVar, UMPlatformData[] uMPlatformDataArr) {
            this.f231a = strArr[0];
            this.f232b = strArr[1];
            this.f233c = bVar;
            this.f234d = uMPlatformDataArr;
        }

        /* renamed from: a */
        public UMResult doInBackground(Void... voidArr) {
            String str;
            if (TextUtils.isEmpty(this.f232b)) {
                str = UMNetwork.m213a(this.f231a);
            } else {
                str = UMNetwork.m214a(this.f231a, this.f232b);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("st");
                if (optInt == 0) {
                    optInt = UMSocialConstants.f261t;
                }
                UMResult dVar = new UMResult(optInt);
                String optString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                if (!TextUtils.isEmpty(optString)) {
                    dVar.mo7398a(optString);
                }
                String optString2 = jSONObject.optString(UMSocialConstants.f255n);
                if (!TextUtils.isEmpty(optString2)) {
                    dVar.mo7400b(optString2);
                }
                return dVar;
            } catch (Exception e) {
                return new UMResult(-99, e);
            }
        }

        public void onPreExecute() {
            C0418b bVar = this.f233c;
            if (bVar != null) {
                bVar.mo7392a();
            }
        }

        /* renamed from: a */
        public void onPostExecute(UMResult dVar) {
            C0418b bVar = this.f233c;
            if (bVar != null) {
                bVar.mo7393a(dVar, this.f234d);
            }
        }
    }
}
