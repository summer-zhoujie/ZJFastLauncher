package com.wpengapp.support;

import android.os.SystemClock;
import android.text.TextUtils;
import com.wpengapp.http.R$string;
import com.wpengapp.http.RequestHelper;
import com.wpengapp.support.Request;
import com.wpengapp.support.WPengServer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.ذ */
/* compiled from: HttpBaseRequest */
public abstract class C0849<T> extends C0968<T> {

    /* renamed from: ރ */
    public final String f2295;

    /* renamed from: ބ */
    public final Map<String, String> f2296;

    /* renamed from: ޅ */
    public boolean f2297;

    /* renamed from: ކ */
    public boolean f2298;

    /* renamed from: އ */
    public C0849<T> f2299;

    /* renamed from: ވ */
    public C0849<T> f2300;

    /* renamed from: މ */
    public String f2301;

    /* renamed from: ފ */
    public boolean f2302;

    public C0849(String str) {
        this("GET", str, (Map<String, String>) null, (String) null);
    }

    /* renamed from: ֏ */
    public abstract T mo8206(String str);

    /* renamed from: ֏ */
    public abstract void mo7980(HttpResponse<T> r1, ErrorCode r2);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0849(String str, String str2, Map<String, String> map, String str3) {
        super(str, C1279.m3419(str) ? str2 : RequestHelper.m339(str2, map));
        this.f2301 = str2;
        this.f2295 = str3;
        if (C1279.m3419(str) && ApiConstant.m2594(str2)) {
            map = map == null ? new HashMap<>() : map;
            map.putAll(RequestHelper.m335());
            RequestHelper.m336(str2, map);
        }
        this.f2296 = map;
        this.f2300 = this;
        this.f2298 = this.f2301.startsWith(ApiConstant.f2707);
        this.f2297 = !this.f2298;
    }

    /* renamed from: ֏ */
    public final void mo8759(HttpResponse<T> r8) {
        ErrorCode r4;
        WPengServer.C0485 r0;
        ErrorCode[] values = ErrorCode.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                r4 = ErrorCode.FAILED;
                break;
            }
            r4 = values[i];
            if (r4.f1082 == r8.f3515) {
                int ordinal = r4.ordinal();
                if (ordinal == 5) {
                    ErrorCode.m1335(r8, r4);
                    r4 = ErrorCode.SUCCESS;
                } else if (ordinal == 6) {
                    ErrorCode.m1335(r8, r4);
                    r4 = ErrorCode.FAILED;
                }
            } else {
                i++;
            }
        }
        if (r4 == ErrorCode.INVALID_SIGNATURE) {
            if (this.f2297) {
                this.f2297 = false;
                WPengServer.m1072(new HttpBaseRequest(this), this.f2302);
                return;
            }
            WPengServer.m1074(r4.f1083);
        } else if (r4 == ErrorCode.MAINTAIN && (r0 = WPengServer.f851) != null) {
            ((C1004) r0).mo9114();
        }
        mo7980(r8, r4);
    }

    /* renamed from: ֏ */
    public C0968 mo8757(boolean z) {
        FormBody r6;
        Map<String, String> map;
        boolean z2 = false;
        this.f2302 = false;
        WPengServer.C0485 r2 = WPengServer.f851;
        if (r2 != null) {
            C1004 r22 = (C1004) r2;
            long longValue = BaseApplication.this.f567.m1925().longValue();
            if (longValue > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (longValue > currentTimeMillis) {
                    BaseApplication.this.f567.mo8554((Long) 0L);
                } else if (!"com.wpengapp.admin".equals(BaseApplication.this.getPackageName()) && currentTimeMillis - longValue < 21600000) {
                    z2 = true;
                }
            }
            if (z2) {
                mo7981((Exception) new MaintainException(WPengServer.m1071(R$string.error_maintain)));
                return this;
            }
        }
        if (this.f2298 || !TextUtils.isEmpty(WPengServer.f845) || !ApiConstant.m2594(this.f2301)) {
            this.f2698 = SystemClock.elapsedRealtime();
            Request.C0874 r1 = new Request.C0874();
            r1.mo8833(this.f2696);
            if (C1279.m3419(this.f2697)) {
                map = this.f2296;
                if (map == null) {
                    r6 = new FormBody(new ArrayList(), new ArrayList());
                } else {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Map.Entry next : map.entrySet()) {
                        if (!(next.getKey() == null || next.getValue() == null)) {
                            String str = (String) next.getKey();
                            String str2 = (String) next.getValue();
                            if (str == null) {
                                throw new NullPointerException("name == null");
                            } else if (str2 != null) {
                                arrayList.add(HttpUrl.m3119(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, (Charset) null));
                                arrayList2.add(HttpUrl.m3119(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, (Charset) null));
                            } else {
                                throw new NullPointerException("value == null");
                            }
                        }
                    }
                    r6 = new FormBody(arrayList, arrayList2);
                }
            } else {
                map = null;
                r6 = null;
            }
            r1.mo8834(this.f2697, r6);
            Request r12 = r1.mo8835();
            if (z) {
                this.f2695 = C1279.f3603.mo8741(r12);
            } else {
                this.f2695 = C1279.f3602.mo8741(r12);
            }
            String str3 = this.f2696;
            String str4 = this.f2697;
            if (!C1279.m3419(str4)) {
                map = null;
            }
            if (Logger.f1344) {
                StringBuilder sb = new StringBuilder();
                sb.append("\nHttp url : ");
                sb.append(str3);
                sb.append("\nHttp method : ");
                sb.append(str4);
                if (!CollectionUtils.m1660((Map) null)) {
                    if (CollectionUtils.m1660((Map) map)) {
                        sb.append("\nHttp params: ");
                        sb.append(map.toString());
                    }
                    Logger.m1473("Request", sb.toString(), 4);
                } else {
                    sb.append("\nHttp headers: ");
                    throw null;
                }
            }
            C0968.f2694.execute(new BaseRequest(this));
            return this;
        }
        WPengServer.m1072(new HttpBaseRequest(this), this.f2302);
        return this;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:1|2|(1:4)(1:5)|6|7|8|9|10|11|12|(2:14|15)(2:16|(1:18))|19|(1:21)|22|(1:24)(1:25)|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        r8.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0089, code lost:
        return r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051 A[SYNTHETIC, Splitter:B:14:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058 A[Catch:{ JsonParseException | JSONException -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[Catch:{ JsonParseException | JSONException -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[Catch:{ JsonParseException | JSONException -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b A[Catch:{ JsonParseException | JSONException -> 0x0083 }] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.wpengapp.support.HttpResponse<T> mo8758(com.wpengapp.support.Response r8) {
        /*
            r7 = this;
            java.lang.String r0 = "encrypt"
            java.lang.String r1 = "message"
            java.lang.String r2 = "msg"
            com.wpengapp.support.ໂ r3 = new com.wpengapp.support.ໂ
            r3.<init>()
            com.wpengapp.support.ம r4 = r8.f1355
            com.wpengapp.support.ਟ r5 = r4.mo7908()
            com.wpengapp.support.ظ r4 = r4.mo7907()     // Catch:{ all -> 0x008a }
            if (r4 == 0) goto L_0x001e
            java.nio.charset.Charset r6 = com.wpengapp.support.Util.f737     // Catch:{ all -> 0x008a }
            java.nio.charset.Charset r4 = r4.mo8765((java.nio.charset.Charset) r6)     // Catch:{ all -> 0x008a }
            goto L_0x0020
        L_0x001e:
            java.nio.charset.Charset r4 = com.wpengapp.support.Util.f737     // Catch:{ all -> 0x008a }
        L_0x0020:
            java.nio.charset.Charset r4 = com.wpengapp.support.Util.m939((com.wpengapp.support.BufferedSource) r5, (java.nio.charset.Charset) r4)     // Catch:{ all -> 0x008a }
            java.lang.String r4 = r5.mo8488((java.nio.charset.Charset) r4)     // Catch:{ all -> 0x008a }
            com.wpengapp.support.Util.m946((java.io.Closeable) r5)
            r3.f3519 = r4
            com.wpengapp.support.ம r8 = r8.f1355     // Catch:{ NullPointerException -> 0x003b }
            com.wpengapp.support.ظ r8 = r8.mo7907()     // Catch:{ NullPointerException -> 0x003b }
            r5 = 0
            java.nio.charset.Charset r8 = r8.mo8765((java.nio.charset.Charset) r5)     // Catch:{ NullPointerException -> 0x003b }
            r8.toString()     // Catch:{ NullPointerException -> 0x003b }
        L_0x003b:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            r8.<init>(r4)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            java.lang.String r5 = "code"
            r6 = -1
            int r5 = r8.optInt(r5, r6)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            r3.f3515 = r5     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            boolean r5 = r8.has(r2)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0058
            java.lang.String r1 = r8.optString(r2, r6)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            r3.f3516 = r1     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            goto L_0x0064
        L_0x0058:
            boolean r2 = r8.has(r1)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            if (r2 == 0) goto L_0x0064
            java.lang.String r1 = r8.optString(r1, r6)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            r3.f3516 = r1     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
        L_0x0064:
            boolean r1 = r8.has(r0)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            if (r1 == 0) goto L_0x0070
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            r3.f3517 = r0     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
        L_0x0070:
            java.lang.String r8 = com.wpengapp.http.RequestHelper.m334((org.json.JSONObject) r8)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            if (r0 != 0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r8 = r4
        L_0x007c:
            java.lang.Object r8 = r7.mo8206((java.lang.String) r8)     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            r3.f3518 = r8     // Catch:{ JSONException -> 0x0085, JsonParseException -> 0x0083 }
            return r3
        L_0x0083:
            r8 = move-exception
            goto L_0x0086
        L_0x0085:
            r8 = move-exception
        L_0x0086:
            r8.getMessage()
            return r3
        L_0x008a:
            r8 = move-exception
            com.wpengapp.support.Util.m946((java.io.Closeable) r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0849.mo8758(com.wpengapp.support.ʚ):com.wpengapp.support.ໂ");
    }
}
