package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.p000v4.text.BidiFormatter;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.umeng.analytics.game.b */
public class GameState {

    /* renamed from: a */
    public String f157a;

    /* renamed from: b */
    public String f158b;

    /* renamed from: c */
    public Context f159c;

    /* renamed from: d */
    public final String f160d = "um_g_cache";

    /* renamed from: e */
    public final String f161e = "single_level";

    /* renamed from: f */
    public final String f162f = "stat_player_level";

    /* renamed from: g */
    public final String f163g = "stat_game_level";

    /* renamed from: h */
    public C0396a f164h = null;

    /* renamed from: com.umeng.analytics.game.b$a */
    /* compiled from: GameState */
    static class C0396a implements Serializable {

        /* renamed from: a */
        public static final long f165a = 20140327;

        /* renamed from: b */
        public String f166b;

        /* renamed from: c */
        public long f167c;

        /* renamed from: d */
        public long f168d;

        public C0396a(String str) {
            this.f166b = str;
        }

        /* renamed from: a */
        public boolean mo7317a(String str) {
            return this.f166b.equals(str);
        }

        /* renamed from: b */
        public void mo7318b() {
            this.f167c = (System.currentTimeMillis() - this.f168d) + this.f167c;
            this.f168d = 0;
        }

        /* renamed from: c */
        public void mo7319c() {
            mo7316a();
        }

        /* renamed from: d */
        public void mo7320d() {
            mo7318b();
        }

        /* renamed from: e */
        public long mo7321e() {
            return this.f167c;
        }

        /* renamed from: f */
        public String mo7322f() {
            return this.f166b;
        }

        /* renamed from: a */
        public void mo7316a() {
            this.f168d = System.currentTimeMillis();
        }
    }

    public GameState(Context context) {
        this.f159c = context;
    }

    /* renamed from: a */
    public C0396a mo7312a(String str) {
        this.f164h = new C0396a(str);
        this.f164h.mo7316a();
        return this.f164h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7315b() {
        /*
            r9 = this;
            android.content.Context r0 = r9.f159c
            r1 = 0
            java.lang.String r2 = "um_g_cache"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r1)
            r2 = 0
            java.lang.String r3 = "single_level"
            java.lang.String r3 = r0.getString(r3, r2)
            if (r3 == 0) goto L_0x0060
            int r4 = r3.length()
            if (r4 != 0) goto L_0x0019
            goto L_0x0054
        L_0x0019:
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0054 }
            int r5 = r3.length()     // Catch:{ Exception -> 0x0054 }
            int r5 = r5 / 2
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0054 }
        L_0x0023:
            int r6 = r3.length()     // Catch:{ Exception -> 0x0054 }
            if (r1 >= r6) goto L_0x0047
            char r6 = r3.charAt(r1)     // Catch:{ Exception -> 0x0054 }
            int r7 = r1 / 2
            int r6 = r6 + -97
            int r6 = r6 << 4
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x0054 }
            r5[r7] = r6     // Catch:{ Exception -> 0x0054 }
            int r6 = r1 + 1
            char r6 = r3.charAt(r6)     // Catch:{ Exception -> 0x0054 }
            byte r8 = r5[r7]     // Catch:{ Exception -> 0x0054 }
            int r6 = r6 + -97
            int r6 = r6 + r8
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x0054 }
            r5[r7] = r6     // Catch:{ Exception -> 0x0054 }
            int r1 = r1 + 2
            goto L_0x0023
        L_0x0047:
            r4.<init>(r5)     // Catch:{ Exception -> 0x0054 }
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x0054 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0054 }
            java.lang.Object r1 = r1.readObject()     // Catch:{ Exception -> 0x0054 }
            goto L_0x0055
        L_0x0054:
            r1 = r2
        L_0x0055:
            com.umeng.analytics.game.b$a r1 = (com.umeng.analytics.game.GameState.C0396a) r1
            r9.f164h = r1
            com.umeng.analytics.game.b$a r1 = r9.f164h
            if (r1 == 0) goto L_0x0060
            r1.mo7319c()
        L_0x0060:
            java.lang.String r1 = r9.f158b
            if (r1 != 0) goto L_0x0081
            java.lang.String r1 = "stat_player_level"
            java.lang.String r1 = r0.getString(r1, r2)
            r9.f158b = r1
            java.lang.String r1 = r9.f158b
            if (r1 != 0) goto L_0x0081
            android.content.Context r1 = r9.f159c
            android.content.SharedPreferences r1 = com.wpengapp.support.Utils.m1861((android.content.Context) r1)
            if (r1 != 0) goto L_0x0079
            return
        L_0x0079:
            java.lang.String r3 = "userlevel"
            java.lang.String r1 = r1.getString(r3, r2)
            r9.f158b = r1
        L_0x0081:
            java.lang.String r1 = r9.f157a
            if (r1 != 0) goto L_0x008d
            java.lang.String r1 = "stat_game_level"
            java.lang.String r0 = r0.getString(r1, r2)
            r9.f157a = r0
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.game.GameState.mo7315b():void");
    }

    /* renamed from: a */
    public void mo7313a() {
        String str;
        C0396a aVar = this.f164h;
        if (aVar != null) {
            aVar.mo7318b();
            SharedPreferences.Editor edit = this.f159c.getSharedPreferences("um_g_cache", 0).edit();
            C0396a aVar2 = this.f164h;
            if (aVar2 == null) {
                str = BidiFormatter.EMPTY_STRING;
            } else {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(aVar2);
                    objectOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 0; i < byteArray.length; i++) {
                        stringBuffer.append((char) (((byteArray[i] >> 4) & 15) + 97));
                        stringBuffer.append((char) ((byteArray[i] & 15) + 97));
                    }
                    str = stringBuffer.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    str = null;
                }
            }
            edit.putString("single_level", str);
            edit.putString("stat_player_level", this.f158b);
            edit.putString("stat_game_level", this.f157a);
            edit.commit();
        }
    }

    /* renamed from: b */
    public C0396a mo7314b(String str) {
        C0396a aVar = this.f164h;
        if (aVar != null) {
            aVar.mo7320d();
            if (this.f164h.mo7317a(str)) {
                C0396a aVar2 = this.f164h;
                this.f164h = null;
                return aVar2;
            }
        }
        return null;
    }
}
