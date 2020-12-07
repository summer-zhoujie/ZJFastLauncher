package android.support.p000v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.OperationCanceledException;
import android.support.p000v4.p002os.CancellationSignal;

/* renamed from: android.support.v4.content.ContentResolverCompat */
public final class ContentResolverCompat {
    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        Object obj;
        int i = Build.VERSION.SDK_INT;
        if (cancellationSignal != null) {
            try {
                obj = cancellationSignal.getCancellationSignalObject();
            } catch (Exception e) {
                if (e instanceof OperationCanceledException) {
                    throw new android.support.p000v4.p002os.OperationCanceledException((String) null);
                }
                throw e;
            }
        } else {
            obj = null;
        }
        return contentResolver.query(uri, strArr, str, strArr2, str2, (android.os.CancellationSignal) obj);
    }
}
