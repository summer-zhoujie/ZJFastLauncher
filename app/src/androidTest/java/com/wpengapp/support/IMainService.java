package com.wpengapp.support;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.InputEvent;

/* renamed from: com.wpengapp.support.ʗ */
public interface IMainService extends IInterface {
    /* renamed from: ֏ */
    void mo8266(IBinder iBinder, int i, Intent intent, long j);

    /* renamed from: ֏ */
    void mo8267(String str);

    /* renamed from: ֏ */
    boolean mo8268(InputEvent inputEvent, int i);

    /* renamed from: ֏ */
    boolean mo8269(String str, int i);

    /* renamed from: ֏ */
    boolean mo8270(String str, String str2);

    /* renamed from: com.wpengapp.support.ʗ$֏ */
    /* compiled from: IMainService */
    public static abstract class C0598 extends Binder implements IMainService {
        /* renamed from: ֏ */
        public static IMainService m1480(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.wpengapp.xposed.IMainService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMainService)) {
                return new C0599(iBinder);
            }
            return (IMainService) queryLocalInterface;
        }

        /* renamed from: ֏ */
        public static IMainService m1479() {
            return C0599.f1346;
        }

        /* renamed from: com.wpengapp.support.ʗ$֏$֏ */
        /* compiled from: IMainService */
        private static class C0599 implements IMainService {

            /* renamed from: ֏ */
            public static IMainService f1346;

            /* renamed from: ؠ */
            public IBinder f1347;

            public C0599(IBinder iBinder) {
                this.f1347 = iBinder;
            }

            public IBinder asBinder() {
                return this.f1347;
            }

            /* renamed from: ֏ */
            public void mo8267(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wpengapp.xposed.IMainService");
                    obtain.writeString(str);
                    if (this.f1347.transact(1, obtain, obtain2, 0) || C0598.m1479() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C0598.m1479().mo8267(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ֏ */
            public void mo8266(IBinder iBinder, int i, Intent intent, long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wpengapp.xposed.IMainService");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    if (this.f1347.transact(2, obtain, obtain2, 0) || C0598.m1479() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C0598.m1479().mo8266(iBinder, i, intent, j);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ֏ */
            public boolean mo8270(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wpengapp.xposed.IMainService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    if (!this.f1347.transact(4, obtain, obtain2, 0) && C0598.m1479() != null) {
                        return C0598.m1479().mo8270(str, str2);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ֏ */
            public boolean mo8269(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wpengapp.xposed.IMainService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    boolean z = false;
                    if (!this.f1347.transact(5, obtain, obtain2, 0) && C0598.m1479() != null) {
                        return C0598.m1479().mo8269(str, i);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ֏ */
            public boolean mo8268(InputEvent inputEvent, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wpengapp.xposed.IMainService");
                    boolean z = true;
                    if (inputEvent != null) {
                        obtain.writeInt(1);
                        inputEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (!this.f1347.transact(8, obtain, obtain2, 0) && C0598.m1479() != null) {
                        return C0598.m1479().mo8268(inputEvent, i);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
