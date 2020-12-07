package com.wpengapp.support;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.wpengapp.support.ImageDownloader;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* renamed from: com.wpengapp.support.ʺ */
/* compiled from: ImageLoaderConfiguration */
public final class C0608 {

    /* renamed from: ֏ */
    public final Resources f1410;

    /* renamed from: ؠ */
    public final int f1411;

    /* renamed from: ހ */
    public final int f1412;

    /* renamed from: ށ */
    public final int f1413;

    /* renamed from: ނ */
    public final int f1414;

    /* renamed from: ރ */
    public final BitmapProcessor f1415;

    /* renamed from: ބ */
    public final Executor f1416;

    /* renamed from: ޅ */
    public final Executor f1417;

    /* renamed from: ކ */
    public final boolean f1418;

    /* renamed from: އ */
    public final boolean f1419;

    /* renamed from: ވ */
    public final int f1420;

    /* renamed from: މ */
    public final int f1421;

    /* renamed from: ފ */
    public final QueueProcessingType f1422;

    /* renamed from: ދ */
    public final MemoryCache f1423;

    /* renamed from: ތ */
    public final DiskCache f1424;

    /* renamed from: ލ */
    public final ImageDownloader f1425;

    /* renamed from: ގ */
    public final ImageDecoder f1426;

    /* renamed from: ޏ */
    public final C0621 f1427;

    /* renamed from: ސ */
    public final ImageDownloader f1428 = new C0610(this.f1425);

    /* renamed from: ޑ */
    public final ImageDownloader f1429 = new C0611(this.f1425);

    /* renamed from: com.wpengapp.support.ʺ$֏ */
    /* compiled from: ImageLoaderConfiguration */
    public static class C0609 {

        /* renamed from: ֏ */
        public static final QueueProcessingType f1430 = QueueProcessingType.FIFO;

        /* renamed from: ؠ */
        public Context f1431;

        /* renamed from: ހ */
        public int f1432 = 0;

        /* renamed from: ށ */
        public int f1433 = 0;

        /* renamed from: ނ */
        public int f1434 = 0;

        /* renamed from: ރ */
        public int f1435 = 0;

        /* renamed from: ބ */
        public Executor f1436 = null;

        /* renamed from: ޅ */
        public Executor f1437 = null;

        /* renamed from: ކ */
        public boolean f1438 = false;

        /* renamed from: އ */
        public boolean f1439 = false;

        /* renamed from: ވ */
        public int f1440 = 3;

        /* renamed from: މ */
        public int f1441 = 3;

        /* renamed from: ފ */
        public boolean f1442 = false;

        /* renamed from: ދ */
        public QueueProcessingType f1443 = f1430;

        /* renamed from: ތ */
        public int f1444 = 0;

        /* renamed from: ލ */
        public long f1445 = 0;

        /* renamed from: ގ */
        public int f1446 = 0;

        /* renamed from: ޏ */
        public MemoryCache f1447 = null;

        /* renamed from: ސ */
        public DiskCache f1448 = null;

        /* renamed from: ޑ */
        public FileNameGenerator f1449 = null;

        /* renamed from: ޒ */
        public ImageDownloader f1450 = null;

        /* renamed from: ޓ */
        public ImageDecoder f1451;

        /* renamed from: ޔ */
        public C0621 f1452 = null;

        /* renamed from: ޕ */
        public boolean f1453 = false;

        public C0609(Context context) {
            this.f1431 = context.getApplicationContext();
        }

        /* renamed from: ތ */
        public static /* synthetic */ void m1519(C0609 r0) {
        }
    }

    /* renamed from: com.wpengapp.support.ʺ$ؠ */
    /* compiled from: ImageLoaderConfiguration */
    private static class C0610 implements ImageDownloader {

        /* renamed from: ֏ */
        public final ImageDownloader f1454;

        public C0610(ImageDownloader r1) {
            this.f1454 = r1;
        }

        /* renamed from: ֏ */
        public InputStream mo8094(String str, Object obj) {
            int ordinal = ImageDownloader.C0912.m2393(str).ordinal();
            if (ordinal != 0 && ordinal != 1) {
                return this.f1454.mo8094(str, obj);
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: com.wpengapp.support.ʺ$ހ */
    /* compiled from: ImageLoaderConfiguration */
    private static class C0611 implements ImageDownloader {

        /* renamed from: ֏ */
        public final ImageDownloader f1455;

        public C0611(ImageDownloader r1) {
            this.f1455 = r1;
        }

        /* renamed from: ֏ */
        public InputStream mo8094(String str, Object obj) {
            InputStream r3 = this.f1455.mo8094(str, obj);
            int ordinal = ImageDownloader.C0912.m2393(str).ordinal();
            if (ordinal == 0 || ordinal == 1) {
                return new FlushedInputStream(r3);
            }
            return r3;
        }
    }

    public /* synthetic */ C0608(C0609 r2, ImageLoaderConfiguration r3) {
        this.f1410 = r2.f1431.getResources();
        this.f1411 = r2.f1432;
        this.f1412 = r2.f1433;
        this.f1413 = r2.f1434;
        this.f1414 = r2.f1435;
        C0609.m1519(r2);
        this.f1416 = r2.f1436;
        this.f1417 = r2.f1437;
        this.f1420 = r2.f1440;
        this.f1421 = r2.f1441;
        this.f1422 = r2.f1443;
        this.f1424 = r2.f1448;
        this.f1423 = r2.f1447;
        this.f1427 = r2.f1452;
        this.f1425 = r2.f1450;
        this.f1426 = r2.f1451;
        this.f1418 = r2.f1438;
        this.f1419 = r2.f1439;
        L.f2134 = r2.f1453;
    }

    /* renamed from: ֏ */
    public ImageSize mo8304() {
        DisplayMetrics displayMetrics = this.f1410.getDisplayMetrics();
        int i = this.f1411;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = this.f1412;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        return new ImageSize(i, i2);
    }
}
