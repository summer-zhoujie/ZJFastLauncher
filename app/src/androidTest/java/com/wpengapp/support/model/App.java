package com.wpengapp.support.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;

@Keep
public class App {
    public String appId;
    public String des;
    public String dlUrl;
    public String iconUrl;
    public String indexUrl;
    public boolean mark;
    public String name;
    public int sellPrice;
    public String shortName;
    public int sort;
    public int trial;
    public AppVersion version;

    @Keep
    public static class AppVersion implements Parcelable {
        public static final Creator<AppVersion> CREATOR = new App();
        public String appId;
        public String changeLog;
        public String dlUrl;
        public String exDlUrl;
        public boolean forceUpdate;
        public boolean gzh;
        public String md5;
        public boolean needUpdate;
        public long size;
        public int versionCode;
        public String versionName;

        public AppVersion(Parcel parcel) {
            this.appId = parcel.readString();
            this.versionName = parcel.readString();
            this.versionCode = parcel.readInt();
            this.dlUrl = parcel.readString();
            this.exDlUrl = parcel.readString();
            this.md5 = parcel.readString();
            this.size = parcel.readLong();
            boolean z = true;
            this.forceUpdate = parcel.readByte() != 0;
            this.needUpdate = parcel.readByte() != 0;
            this.changeLog = parcel.readString();
            this.gzh = parcel.readByte() == 0 ? false : z;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.versionName);
            parcel.writeInt(this.versionCode);
            parcel.writeString(this.dlUrl);
            parcel.writeString(this.exDlUrl);
            parcel.writeString(this.md5);
            parcel.writeLong(this.size);
            parcel.writeByte(this.forceUpdate ? (byte) 1 : 0);
            parcel.writeByte(this.needUpdate ? (byte) 1 : 0);
            parcel.writeString(this.changeLog);
            parcel.writeByte(this.gzh ? (byte) 1 : 0);
        }
    }

    public String getAppMark() {
        AppVersion appVersion = this.version;
        int i = appVersion == null ? 0 : appVersion.versionCode;
        return this.appId + "_" + i;
    }

    public boolean isMeizuApp() {
        AppVersion appVersion = this.version;
        return appVersion == null || appVersion.versionCode <= 0;
    }
}
