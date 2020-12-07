package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import com.wpengapp.baseui.BaseActivity;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(api = 21)
public class ScreencapHelper extends BaseActivity {

    /* renamed from: ފ */
    public static RetCallback<MediaProjection> f578;

    /* renamed from: ދ */
    public static MediaProjection f579;

    /* renamed from: ތ */
    public static final AtomicInteger f580 = new AtomicInteger();

    /* renamed from: ֏ */
    public static void m731(@NonNull RetCallback<MediaProjection> r3) {
        int i = Build.VERSION.SDK_INT;
        MediaProjection mediaProjection = f579;
        if (mediaProjection != null) {
            r3.mo7931(mediaProjection);
            return;
        }
        f578 = new C0907(r3);
        try {
            SystemUtils.m3510((Context) null, new Intent(AppUtils.getApplication(), ScreencapHelper.class));
        } catch (Exception e) {
            e.getMessage();
            f578 = null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            super.onActivityResult(i, i2, intent);
            finish();
            if (i == 1) {
                MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getApplication().getSystemService("media_projection");
                if (mediaProjectionManager == null) {
                    f578.mo7932("request error 2");
                    return;
                }
                MediaProjection mediaProjection = mediaProjectionManager.getMediaProjection(-1, intent);
                if (mediaProjection == null) {
                    f578.mo7932("request error 3");
                } else {
                    f578.mo7931(mediaProjection);
                }
            } else if (f578 != null) {
                f578.mo7932("request error");
            }
        } catch (Exception e) {
            RetCallback<MediaProjection> r3 = f578;
            if (r3 != null) {
                StringBuilder r4 = outline.m2549("request error ");
                r4.append(e.getMessage());
                r3.mo7932(r4.toString());
            }
            e.getMessage();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        int i = Build.VERSION.SDK_INT;
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getApplication().getSystemService("media_projection");
        if (mediaProjectionManager == null) {
            f578.mo7932("No support");
            finish();
            return;
        }
        try {
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 1);
        } catch (Exception e) {
            f578.mo7932(e.getMessage());
            e.getMessage();
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        f578 = new C0696(this);
    }

    /* renamed from: ֏ */
    public static void m730(MediaProjection mediaProjection, int i, int i2, Handler handler, @NonNull RetCallback<Bitmap> r15) {
        int i3;
        if (handler == null) {
            handler = AppUtils.m1171();
        }
        Handler handler2 = handler;
        ImageReader imageReader = null;
        AtomicReference atomicReference = new AtomicReference();
        try {
            imageReader = ImageReader.newInstance(i, i2, 1, 1);
            i3 = ObjectCache.m1661((Object) imageReader);
            try {
                imageReader.setOnImageAvailableListener(new C0803(imageReader, r15, i3, atomicReference), handler2);
                atomicReference.set(mediaProjection.createVirtualDisplay(AppUtils.m1163() + ".scp" + f580.getAndIncrement(), i, i2, Resources.getSystem().getDisplayMetrics().densityDpi, 16, imageReader.getSurface(), (VirtualDisplay.Callback) null, handler2));
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            i3 = -1;
            e.getMessage();
            if (imageReader != null) {
                try {
                    imageReader.close();
                } catch (Exception e3) {
                    e3.getMessage();
                }
            }
            ObjectCache.m1663(i3);
            r15.mo7932(e.getMessage());
            AppUtils.m1147((Runnable) new C1142(i3, new WeakReference(imageReader), new WeakReference((VirtualDisplay) atomicReference.get())), 5000);
        }
        AppUtils.m1147((Runnable) new C1142(i3, new WeakReference(imageReader), new WeakReference((VirtualDisplay) atomicReference.get())), 5000);
    }

    /* renamed from: ֏ */
    public static /* synthetic */ Bitmap m729(Image image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        int pixelStride = planes[0].getPixelStride();
        int r2 = outline.m2540(pixelStride, width, planes[0].getRowStride(), pixelStride);
        Bitmap createBitmap = Bitmap.createBitmap(width + r2, height, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(buffer);
        image.close();
        if (r2 <= 0) {
            return createBitmap;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, width, height);
        createBitmap.recycle();
        return createBitmap2;
    }
}
