package android.support.p000v4.provider;

import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.p000v4.util.Preconditions;
import android.util.Base64;
import com.wpengapp.support.outline;
import java.util.List;

/* renamed from: android.support.v4.provider.FontRequest */
public final class FontRequest {
    public final List<List<byte[]>> mCertificates;
    public final int mCertificatesArray;
    public final String mIdentifier;
    public final String mProviderAuthority;
    public final String mProviderPackage;
    public final String mQuery;

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        if (str != null) {
            this.mProviderAuthority = str;
            if (str2 != null) {
                this.mProviderPackage = str2;
                if (str3 != null) {
                    this.mQuery = str3;
                    if (list != null) {
                        this.mCertificates = list;
                        this.mCertificatesArray = 0;
                        this.mIdentifier = this.mProviderAuthority + "-" + this.mProviderPackage + "-" + this.mQuery;
                        return;
                    }
                    throw new NullPointerException();
                }
                throw new NullPointerException();
            }
            throw new NullPointerException();
        }
        throw new NullPointerException();
    }

    @Nullable
    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    @ArrayRes
    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getIdentifier() {
        return this.mIdentifier;
    }

    @NonNull
    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    @NonNull
    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    @NonNull
    public String getQuery() {
        return this.mQuery;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder r1 = outline.m2549("FontRequest {mProviderAuthority: ");
        r1.append(this.mProviderAuthority);
        r1.append(", mProviderPackage: ");
        r1.append(this.mProviderPackage);
        r1.append(", mQuery: ");
        r1.append(this.mQuery);
        r1.append(", mCertificates:");
        sb.append(r1.toString());
        for (int i = 0; i < this.mCertificates.size(); i++) {
            sb.append(" [");
            List list = this.mCertificates.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.mCertificatesArray);
        return sb.toString();
    }

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @ArrayRes int i) {
        if (str != null) {
            this.mProviderAuthority = str;
            if (str2 != null) {
                this.mProviderPackage = str2;
                if (str3 != null) {
                    this.mQuery = str3;
                    this.mCertificates = null;
                    Preconditions.checkArgument(i != 0);
                    this.mCertificatesArray = i;
                    this.mIdentifier = this.mProviderAuthority + "-" + this.mProviderPackage + "-" + this.mQuery;
                    return;
                }
                throw new NullPointerException();
            }
            throw new NullPointerException();
        }
        throw new NullPointerException();
    }
}
