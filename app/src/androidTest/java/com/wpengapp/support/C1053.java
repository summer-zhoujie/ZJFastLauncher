package com.wpengapp.support;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.wpengapp.support.ছ */
/* compiled from: AdvertisingId */
public final class C1053 implements IInterface {

    /* renamed from: ֏ */
    public IBinder f3013;

    public C1053(IBinder iBinder) {
        this.f3013 = iBinder;
    }

    public IBinder asBinder() {
        return this.f3013;
    }

    /* renamed from: ֏ */
    public String mo9224() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f3013.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    /* renamed from: ֏ */
    public boolean mo9225(boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean z2 = true;
            obtain.writeInt(z ? 1 : 0);
            this.f3013.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z2 = false;
            }
            return z2;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
