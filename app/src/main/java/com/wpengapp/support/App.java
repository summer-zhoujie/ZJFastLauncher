package com.wpengapp.support;

import android.os.Parcel;
import android.os.Parcelable;
import com.wpengapp.support.model.App;

/* renamed from: com.wpengapp.support.ര */
class App implements Parcelable.Creator<App.AppVersion> {
    public Object createFromParcel(Parcel parcel) {
        return new App.AppVersion(parcel);
    }

    public Object[] newArray(int i) {
        return new App.AppVersion[i];
    }
}
