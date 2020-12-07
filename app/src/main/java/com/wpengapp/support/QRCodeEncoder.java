package com.wpengapp.support;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.ธ */
public final class QRCodeEncoder {

    /* renamed from: ֏ */
    public static final Map<EncodeHintType, Object> f3378 = new EnumMap(EncodeHintType.class);

    static {
        f3378.put(EncodeHintType.CHARACTER_SET, "utf-8");
        f3378.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        f3378.put(EncodeHintType.MARGIN, 0);
    }

    /* renamed from: ֏ */
    public static Bitmap m3204(String str, int i) {
        try {
            BitMatrix r10 = new MultiFormatWriter().mo9001(str, BarcodeFormat.QR_CODE, i, i, f3378);
            int[] iArr = new int[(i * i)];
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    if (r10.mo9092(i3, i2)) {
                        iArr[(i2 * i) + i3] = -16777216;
                    } else {
                        iArr[(i2 * i) + i3] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i);
            return m3203(createBitmap, (Bitmap) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static Bitmap m3203(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        float f = ((((float) width) * 1.0f) / 5.0f) / ((float) width2);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f, f, (float) (width / 2), (float) (height / 2));
            canvas.drawBitmap(bitmap2, (float) ((width - width2) / 2), (float) ((height - height2) / 2), (Paint) null);
            canvas.save();
            canvas.restore();
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
