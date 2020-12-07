package com.wpengapp.support;

import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* renamed from: com.wpengapp.support.ˮ */
/* compiled from: DisplayImageOptions */
public final class C0621 {

    /* renamed from: ֏ */
    public final int f1555;

    /* renamed from: ؠ */
    public final int f1556;

    /* renamed from: ހ */
    public final int f1557;

    /* renamed from: ށ */
    public final Drawable f1558;

    /* renamed from: ނ */
    public final Drawable f1559;

    /* renamed from: ރ */
    public final Drawable f1560;

    /* renamed from: ބ */
    public final boolean f1561;

    /* renamed from: ޅ */
    public final boolean f1562;

    /* renamed from: ކ */
    public final boolean f1563;

    /* renamed from: އ */
    public final ImageScaleType f1564;

    /* renamed from: ވ */
    public final BitmapFactory.Options f1565;

    /* renamed from: މ */
    public final int f1566;

    /* renamed from: ފ */
    public final boolean f1567;

    /* renamed from: ދ */
    public final Object f1568;

    /* renamed from: ތ */
    public final SimpleBitmapDisplayer f1569;

    /* renamed from: ލ */
    public final Handler f1570;

    /* renamed from: ގ */
    public final boolean f1571;

    public /* synthetic */ C0621(C0622 r1, DisplayImageOptions r2) {
        this.f1555 = r1.f1572;
        this.f1556 = r1.f1573;
        this.f1557 = r1.f1574;
        this.f1558 = r1.f1575;
        this.f1559 = r1.f1576;
        this.f1560 = r1.f1577;
        this.f1561 = r1.f1578;
        this.f1562 = r1.f1579;
        this.f1563 = r1.f1580;
        this.f1564 = r1.f1581;
        this.f1565 = r1.f1582;
        this.f1566 = r1.f1583;
        this.f1567 = r1.f1584;
        this.f1568 = r1.f1585;
        this.f1569 = r1.f1586;
        this.f1570 = r1.f1587;
        this.f1571 = r1.f1588;
    }

    /* renamed from: ֏ */
    public boolean mo8354() {
        return false;
    }

    /* renamed from: ؠ */
    public boolean mo8355() {
        return false;
    }

    /* renamed from: com.wpengapp.support.ˮ$֏ */
    /* compiled from: DisplayImageOptions */
    public static class C0622 {

        /* renamed from: ֏ */
        public int f1572 = 0;

        /* renamed from: ؠ */
        public int f1573 = 0;

        /* renamed from: ހ */
        public int f1574 = 0;

        /* renamed from: ށ */
        public Drawable f1575 = null;

        /* renamed from: ނ */
        public Drawable f1576 = null;

        /* renamed from: ރ */
        public Drawable f1577 = null;

        /* renamed from: ބ */
        public boolean f1578 = false;

        /* renamed from: ޅ */
        public boolean f1579 = false;

        /* renamed from: ކ */
        public boolean f1580 = false;

        /* renamed from: އ */
        public ImageScaleType f1581 = ImageScaleType.IN_SAMPLE_POWER_OF_2;

        /* renamed from: ވ */
        public BitmapFactory.Options f1582 = new BitmapFactory.Options();

        /* renamed from: މ */
        public int f1583 = 0;

        /* renamed from: ފ */
        public boolean f1584 = false;

        /* renamed from: ދ */
        public Object f1585 = null;

        /* renamed from: ތ */
        public SimpleBitmapDisplayer f1586 = new SimpleBitmapDisplayer();

        /* renamed from: ލ */
        public Handler f1587 = null;

        /* renamed from: ގ */
        public boolean f1588 = false;

        /* renamed from: ֏ */
        public C0622 mo8357(C0621 r2) {
            this.f1572 = r2.f1555;
            this.f1573 = r2.f1556;
            this.f1574 = r2.f1557;
            this.f1575 = r2.f1558;
            this.f1576 = r2.f1559;
            this.f1577 = r2.f1560;
            this.f1578 = r2.f1561;
            this.f1579 = r2.f1562;
            this.f1580 = r2.f1563;
            this.f1581 = r2.f1564;
            this.f1582 = r2.f1565;
            this.f1583 = r2.f1566;
            this.f1584 = r2.f1567;
            this.f1585 = r2.f1568;
            this.f1586 = r2.f1569;
            this.f1587 = r2.f1570;
            this.f1588 = r2.f1571;
            return this;
        }

        /* renamed from: ֏ */
        public C0622 mo8356(BitmapFactory.Options options) {
            if (options != null) {
                this.f1582 = options;
                return this;
            }
            throw new IllegalArgumentException("decodingOptions can't be null");
        }

        /* renamed from: ֏ */
        public C0621 mo8358() {
            return new C0621(this, (DisplayImageOptions) null);
        }
    }
}
