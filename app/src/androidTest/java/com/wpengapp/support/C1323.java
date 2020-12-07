package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import com.wpengapp.http.RequestHelper;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.WeakHashMap;

/* renamed from: com.wpengapp.support.ბ */
/* compiled from: FileStorage */
public class C1323<T> {

    /* renamed from: ֏ */
    public static final String f3782 = new File(AppUtils.getApplication().getFilesDir(), "filestorage").getAbsolutePath();

    /* renamed from: ؠ */
    public static String f3783;

    /* renamed from: ހ */
    public static final WeakHashMap<String, C1323<?>> f3784 = new WeakHashMap<>();

    /* renamed from: ށ */
    public T f3785;

    /* renamed from: ނ */
    public Type f3786;

    /* renamed from: ރ */
    public String f3787;

    /* renamed from: ބ */
    public String f3788;

    /* renamed from: ޅ */
    public String f3789;

    /* renamed from: ކ */
    public SyncFileHandler f3790;

    /* renamed from: އ */
    public volatile boolean f3791;

    /* renamed from: ވ */
    public final WeakHashMap<OnFileChangeListener, Object> f3792 = new WeakHashMap<>();

    static {
        f3783 = BidiFormatter.EMPTY_STRING;
        try {
            f3783 = RequestHelper.m333("XzNsVxgM4OSMFOSCOHPk1qur47zD8uAamOUOwqeGNIPwBlWfob7JgfK+elDfx/+Hopei7xp9C1F5RZOmu9GsgGUpR6k0IxpZelKvoxJoRlj8jvMVqemo4fVzncsdLEBefcoYXYvrdhqqFNWoAgdDNQDyJWwL6moyxqj4OCs26ck=");
        } catch (Exception e) {
            e.getMessage();
        }
        C0786.m2103((Context) AppUtils.getApplication(), (BroadcastReceiver) new C0670(), new IntentFilter("FileStorage"));
    }

    public C1323(String str, Type type, String str2, String str3) {
        this.f3787 = str;
        this.f3786 = type;
        this.f3788 = str2;
        this.f3789 = str3;
        this.f3790 = new SyncFileHandler(new File(f3782, str));
    }

    /* renamed from: ֏ */
    public static <T> C1323<T> m3613(String str, Type type) {
        return m3615(str, type, (String) null, (String) null);
    }

    /* renamed from: ؠ */
    public T mo9612() {
        if (this.f3791) {
            return this.f3785;
        }
        synchronized (f3784) {
            if (this.f3791) {
                T t = this.f3785;
                return t;
            }
            mo9614();
            if (this.f3785 == null && !TextUtils.isEmpty(this.f3788) && !this.f3790.f2512.exists() && mo9613()) {
                mo9614();
                if (this.f3792.size() > 0) {
                    AppUtils.m1155((Runnable) new FileStorage(this, true));
                }
            }
            T t2 = this.f3785;
            return t2;
        }
    }

    /* renamed from: ހ */
    public final boolean mo9613() {
        boolean z = false;
        if (TextUtils.isEmpty(this.f3788)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        InputStream inputStream = null;
        try {
            inputStream = AppUtils.getApplication().getAssets().open(this.f3788);
            FileUtils.m1129(inputStream, this.f3790.f2512);
            z = this.f3790.f2512.exists();
        } catch (Exception e) {
            e.getMessage();
        } catch (Throwable th) {
            FileUtils.close((Closeable) null);
            long currentTimeMillis2 = System.currentTimeMillis();
            StringBuilder r4 = outline.m2549("FileStorage[");
            r4.append(this.f3787);
            r4.append("] load default: ");
            r4.append(this.f3788);
            r4.append(", ret: ");
            r4.append(false);
            r4.append(", ");
            r4.append(currentTimeMillis2 - currentTimeMillis);
            r4.append("ms");
            r4.toString();
            throw th;
        }
        FileUtils.close((Closeable) inputStream);
        long currentTimeMillis3 = System.currentTimeMillis();
        StringBuilder r42 = outline.m2549("FileStorage[");
        r42.append(this.f3787);
        r42.append("] load default: ");
        r42.append(this.f3788);
        r42.append(", ret: ");
        r42.append(z);
        r42.append(", ");
        r42.append(currentTimeMillis3 - currentTimeMillis);
        r42.append("ms");
        r42.toString();
        return z;
    }

    /* renamed from: ށ */
    public final void mo9614() {
        StringBuilder sb;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            byte[] r6 = FileUtils.m1138(this.f3790.f2512);
            if (r6 == null) {
                this.f3791 = true;
                this.f3785 = null;
                j = System.currentTimeMillis();
                sb = new StringBuilder();
            } else {
                T r62 = m3616(r6, this.f3789);
                if (TextUtils.isEmpty(r62)) {
                    this.f3791 = true;
                    this.f3785 = null;
                    j = System.currentTimeMillis();
                    sb = new StringBuilder();
                } else {
                    if (this.f3786 == null) {
                        this.f3785 = r62;
                    } else {
                        this.f3785 = GsonUtil.m2741((String) r62, this.f3786);
                    }
                    this.f3791 = true;
                    j = System.currentTimeMillis();
                    sb = new StringBuilder();
                }
            }
        } catch (Exception e) {
            e.getMessage();
            this.f3785 = null;
            this.f3791 = false;
            j = System.currentTimeMillis();
            sb = new StringBuilder();
        } catch (Throwable th) {
            long currentTimeMillis2 = System.currentTimeMillis();
            StringBuilder r2 = outline.m2549("FileStorage[");
            r2.append(this.f3787);
            r2.append("] loadFromDisk, ");
            r2.append(currentTimeMillis2 - currentTimeMillis);
            r2.append("ms");
            r2.toString();
            throw th;
        }
        sb.append("FileStorage[");
        sb.append(this.f3787);
        sb.append("] loadFromDisk, ");
        sb.append(j - currentTimeMillis);
        sb.append("ms");
        sb.toString();
    }

    /* renamed from: ނ */
    public final void mo9615() {
        Intent intent = new Intent("FileStorage");
        intent.putExtra("ex_pid", Process.myPid());
        intent.putExtra("ex_name", this.f3787);
        C0786.m2105((Context) AppUtils.getApplication(), intent, true);
    }

    /* renamed from: ֏ */
    public static <T> C1323<T> m3614(String str, Type type, String str2) {
        return m3615(str, type, str2, (String) null);
    }

    /* renamed from: ֏ */
    public static <T> C1323<T> m3615(String str, Type type, String str2, String str3) {
        C1323<T> r0 = f3784.get(str);
        if (r0 == null) {
            synchronized (f3784) {
                r0 = f3784.get(str);
                if (r0 == null) {
                    r0 = new C1323<>(str, type, str2, str3);
                    f3784.put(str, r0);
                }
            }
        }
        return r0;
    }

    /* renamed from: ֏ */
    public void mo9611(T t) {
        this.f3785 = t;
        this.f3791 = true;
        outline.m2551(this, (Object) t);
    }

    /* renamed from: ֏ */
    public void mo9609() {
        synchronized (f3784) {
            this.f3791 = false;
            this.f3785 = null;
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ byte[] m3619(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str.getBytes("UTF-8");
        }
        try {
            return Utils.m1904(str, str2 + f3783);
        } catch (Exception e) {
            e.getMessage();
            return str.getBytes("UTF-8");
        }
    }

    /* renamed from: ֏ */
    public static String m3616(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return new String(bArr, "UTF-8");
        }
        try {
            return Utils.m1870(bArr, str + f3783);
        } catch (Exception e) {
            e.getMessage();
            return new String(bArr, "UTF-8");
        }
    }

    /* renamed from: ֏ */
    public void mo9610(OnFileChangeListener r2) {
        this.f3792.put(r2, r2);
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m3617(C1323 r1, boolean z) {
        if (r1.f3792.size() > 0) {
            AppUtils.m1155((Runnable) new FileStorage(r1, z));
        }
    }
}
