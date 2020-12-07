package com.wpengapp.support;

import android.content.Intent;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.view.InputEvent;

/* renamed from: com.wpengapp.support.Վ */
public class MainServiceProxy implements IMainService {

    /* renamed from: ֏ */
    public IMainService f2051;

    public MainServiceProxy(IMainService r1) {
        this.f2051 = r1;
    }

    public IBinder asBinder() {
        return this.f2051.asBinder();
    }

    /* renamed from: ֏ */
    public void mo8267(String str) {
        try {
            this.f2051.mo8267(str);
        } catch (DeadObjectException e) {
            C0983.m2616();
            throw e;
        }
    }

    /* renamed from: ֏ */
    public void mo8266(IBinder iBinder, int i, Intent intent, long j) {
        try {
            this.f2051.mo8266(iBinder, i, intent, j);
        } catch (DeadObjectException e) {
            C0983.m2616();
            throw e;
        }
    }

    /* renamed from: ֏ */
    public boolean mo8270(String str, String str2) {
        try {
            return this.f2051.mo8270(str, str2);
        } catch (DeadObjectException e) {
            C0983.m2616();
            throw e;
        }
    }

    /* renamed from: ֏ */
    public boolean mo8269(String str, int i) {
        try {
            return this.f2051.mo8269(str, i);
        } catch (DeadObjectException e) {
            C0983.m2616();
            throw e;
        }
    }

    /* renamed from: ֏ */
    public boolean mo8268(InputEvent inputEvent, int i) {
        try {
            return this.f2051.mo8268(inputEvent, i);
        } catch (DeadObjectException e) {
            C0983.m2616();
            throw e;
        }
    }
}
