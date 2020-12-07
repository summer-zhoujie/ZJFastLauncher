package android.support.p000v4.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

/* renamed from: android.support.v4.graphics.BitmapCompat */
public final class BitmapCompat {
    public static final BitmapCompatBaseImpl IMPL = new BitmapCompatApi19Impl();

    @RequiresApi(18)
    /* renamed from: android.support.v4.graphics.BitmapCompat$BitmapCompatApi18Impl */
    static class BitmapCompatApi18Impl extends BitmapCompatBaseImpl {
        public boolean hasMipMap(Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        public void setHasMipMap(Bitmap bitmap, boolean z) {
            bitmap.setHasMipMap(z);
        }
    }

    @RequiresApi(19)
    /* renamed from: android.support.v4.graphics.BitmapCompat$BitmapCompatApi19Impl */
    static class BitmapCompatApi19Impl extends BitmapCompatApi18Impl {
        public int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$BitmapCompatBaseImpl */
    static class BitmapCompatBaseImpl {
        public int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getByteCount();
        }

        public boolean hasMipMap(Bitmap bitmap) {
            return false;
        }

        public void setHasMipMap(Bitmap bitmap, boolean z) {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
    }

    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        return IMPL.getAllocationByteCount(bitmap);
    }

    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        return IMPL.hasMipMap(bitmap);
    }

    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean z) {
        IMPL.setHasMipMap(bitmap, z);
    }
}
