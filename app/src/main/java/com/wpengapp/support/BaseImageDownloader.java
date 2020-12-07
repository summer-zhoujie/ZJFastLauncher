package com.wpengapp.support;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.wpengapp.support.ImageDownloader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.wpengapp.support.ǃ */
public class BaseImageDownloader implements ImageDownloader {

    /* renamed from: ֏ */
    public final Context f973;

    /* renamed from: ؠ */
    public final int f974 = 5000;

    /* renamed from: ހ */
    public final int f975 = 20000;

    public BaseImageDownloader(Context context) {
        this.f973 = context.getApplicationContext();
    }

    /* renamed from: ֏ */
    public InputStream mo8094(String str, Object obj) {
        int ordinal = C0912.m2393(str).ordinal();
        boolean z = false;
        boolean z2 = true;
        if (ordinal == 0 || ordinal == 1) {
            HttpURLConnection r9 = mo8095(str, obj);
            int i = 0;
            while (r9.getResponseCode() / 100 == 3 && i < 5) {
                r9 = mo8095(r9.getHeaderField("Location"), obj);
                i++;
            }
            try {
                InputStream inputStream = r9.getInputStream();
                if (r9.getResponseCode() == 200) {
                    z = true;
                }
                if (z) {
                    return new ContentLengthInputStream(new BufferedInputStream(inputStream, 32768), r9.getContentLength());
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
                StringBuilder r0 = outline.m2549("Image request failed with response code ");
                r0.append(r9.getResponseCode());
                throw new IOException(r0.toString());
            } catch (IOException e) {
                InputStream errorStream = r9.getErrorStream();
                do {
                    try {
                    } catch (IOException unused2) {
                        if (errorStream != null) {
                        }
                        throw e;
                    } catch (Throwable th) {
                        if (errorStream != null) {
                            try {
                                errorStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } while (errorStream.read(new byte[32768], 0, 32768) != -1);
                try {
                    errorStream.close();
                } catch (Exception unused4) {
                }
                throw e;
            }
        } else {
            ContentLengthInputStream r10 = null;
            if (ordinal == 2) {
                String r02 = C0912.FILE.mo8892(str);
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
                if (mimeTypeFromExtension == null || !mimeTypeFromExtension.startsWith("video/")) {
                    z2 = false;
                }
                if (z2) {
                    int i2 = Build.VERSION.SDK_INT;
                    Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(r02, 2);
                    if (createVideoThumbnail != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    }
                } else {
                    r10 = new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(r02), 32768), (int) new File(r02).length());
                }
                return r10;
            } else if (ordinal == 3) {
                ContentResolver contentResolver = this.f973.getContentResolver();
                Uri parse = Uri.parse(str);
                String type = this.f973.getContentResolver().getType(parse);
                if (type != null && type.startsWith("video/")) {
                    Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, (BitmapFactory.Options) null);
                    if (thumbnail != null) {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream2);
                        return new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());
                    }
                } else if (str.startsWith("content://com.android.contacts/")) {
                    ContentResolver contentResolver2 = this.f973.getContentResolver();
                    int i3 = Build.VERSION.SDK_INT;
                    return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver2, parse, true);
                }
                return contentResolver.openInputStream(parse);
            } else if (ordinal == 4) {
                return this.f973.getAssets().open(C0912.ASSETS.mo8892(str));
            } else if (ordinal == 5) {
                return this.f973.getResources().openRawResource(Integer.parseInt(C0912.DRAWABLE.mo8892(str)));
            } else {
                throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[]{str}));
            }
        }
    }

    /* renamed from: ؠ */
    public HttpURLConnection mo8095(String str, Object obj) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(this.f974);
        httpURLConnection.setReadTimeout(this.f975);
        return httpURLConnection;
    }
}
