package com.wpengapp.support;

import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.RecyclerView;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* renamed from: com.wpengapp.support.Ź */
public class FileUtils {

    /* renamed from: ֏ */
    public static final String f893 = Environment.getExternalStorageDirectory().getPath();

    /* renamed from: ֏ */
    public static File m1123(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(outline.m2548(outline.m2549(str), File.separator, str2.replace('/', '_').replace(':', '_').replace("?", "_")));
        try {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            file.createNewFile();
            return file;
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: ؠ */
    public static String m1134(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr, 0, bArr.length);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byteArrayOutputStream.flush();
                            String str = new String(byteArrayOutputStream.toByteArray());
                            close((Closeable) fileInputStream);
                            close((Closeable) byteArrayOutputStream);
                            return str;
                        }
                    } catch (Exception e) {
                        e = e;
                        try {
                            e.getMessage();
                            close((Closeable) fileInputStream);
                            close((Closeable) byteArrayOutputStream);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            close((Closeable) fileInputStream);
                            close((Closeable) byteArrayOutputStream);
                            throw th;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = null;
                e.getMessage();
                close((Closeable) fileInputStream);
                close((Closeable) byteArrayOutputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                close((Closeable) fileInputStream);
                close((Closeable) byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            byteArrayOutputStream = null;
            e.getMessage();
            close((Closeable) fileInputStream);
            close((Closeable) byteArrayOutputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            byteArrayOutputStream = null;
            close((Closeable) fileInputStream);
            close((Closeable) byteArrayOutputStream);
            throw th;
        }
    }

    /* renamed from: ހ */
    public static String m1137(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(m1135(str));
        return TextUtils.isEmpty(mimeTypeFromExtension) ? "*/*" : mimeTypeFromExtension;
    }

    /* renamed from: ހ */
    public static byte[] m1138(File file) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            if (!file.exists()) {
                close((Closeable) null);
                close((Closeable) null);
                close((Closeable) null);
                return null;
            }
            synchronized (file.getAbsolutePath().intern()) {
                try {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        fileChannel2 = randomAccessFile.getChannel();
                        try {
                            if (m1125(fileChannel2, true) == null) {
                                close((Closeable) null);
                                close((Closeable) randomAccessFile);
                                close((Closeable) fileChannel2);
                                return null;
                            }
                            byte[] bArr = new byte[3072];
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int read = randomAccessFile.read(bArr, 0, bArr.length);
                                    if (read != -1) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } else {
                                        byteArrayOutputStream.flush();
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        close((Closeable) byteArrayOutputStream);
                                        close((Closeable) randomAccessFile);
                                        close((Closeable) fileChannel2);
                                        return byteArray;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        throw th;
                                    } catch (Exception e) {
                                        e = e;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = null;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileChannel2 = null;
                        byteArrayOutputStream = null;
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileChannel2 = null;
                    randomAccessFile = null;
                    byteArrayOutputStream = null;
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            fileChannel2 = null;
            randomAccessFile = null;
            byteArrayOutputStream = null;
            try {
                e.getMessage();
                close((Closeable) byteArrayOutputStream);
                close((Closeable) randomAccessFile);
                close((Closeable) fileChannel2);
                return null;
            } catch (Throwable th6) {
                fileChannel = fileChannel2;
                th = th6;
                byteArrayOutputStream2 = byteArrayOutputStream;
                close((Closeable) byteArrayOutputStream2);
                close((Closeable) randomAccessFile);
                close((Closeable) fileChannel);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            fileChannel = null;
            randomAccessFile = null;
            close((Closeable) byteArrayOutputStream2);
            close((Closeable) randomAccessFile);
            close((Closeable) fileChannel);
            throw th;
        }
    }

    /* renamed from: ֏ */
    public static boolean m1132(String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File absolutePath : listFiles) {
                m1132(absolutePath.getAbsolutePath());
            }
        }
        return file.delete();
    }

    /* renamed from: ؠ */
    public static String m1135(String str) {
        if (str.lastIndexOf(".") == -1) {
            return BidiFormatter.EMPTY_STRING;
        }
        return str.substring(str.lastIndexOf(".") + 1, str.length()).toLowerCase();
    }

    /* renamed from: ֏ */
    public static boolean m1130(File file) {
        File[] listFiles;
        if (file != null) {
            if (!file.exists()) {
                return true;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File absolutePath : listFiles) {
                    m1132(absolutePath.getAbsolutePath());
                }
            }
            if (!file.isDirectory()) {
                return file.delete();
            }
            File[] listFiles2 = file.listFiles();
            if (listFiles2 != null && listFiles2.length == 0) {
                return file.delete();
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m1136(File r5, byte[] r6) {
        /*
            java.lang.String r0 = r5.getAbsolutePath()
            java.lang.String r0 = r0.intern()
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            boolean r3 = r5.exists()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            if (r3 != 0) goto L_0x001b
            java.io.File r3 = r5.getParentFile()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r3.mkdirs()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r5.createNewFile()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
        L_0x001b:
            boolean r3 = r5.exists()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            if (r3 != 0) goto L_0x0029
            m1126((java.io.Closeable) r1)     // Catch:{ all -> 0x0073 }
            m1126((java.io.Closeable) r1)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            return r2
        L_0x0029:
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.String r4 = "rw"
            r3.<init>(r5, r4)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.nio.channels.FileChannel r1 = r3.getChannel()     // Catch:{ Exception -> 0x0057, all -> 0x0053 }
            java.nio.channels.FileLock r5 = m1125((java.nio.channels.FileChannel) r1, (boolean) r2)     // Catch:{ Exception -> 0x0057, all -> 0x0053 }
            if (r5 != 0) goto L_0x0042
            m1126((java.io.Closeable) r3)     // Catch:{ all -> 0x0073 }
            m1126((java.io.Closeable) r1)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            return r2
        L_0x0042:
            r3.write(r6)     // Catch:{ Exception -> 0x0057, all -> 0x0053 }
            int r5 = r6.length     // Catch:{ Exception -> 0x0057, all -> 0x0053 }
            long r5 = (long) r5     // Catch:{ Exception -> 0x0057, all -> 0x0053 }
            r3.setLength(r5)     // Catch:{ Exception -> 0x0057, all -> 0x0053 }
            r5 = 1
            m1126((java.io.Closeable) r3)     // Catch:{ all -> 0x0073 }
            m1126((java.io.Closeable) r1)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            return r5
        L_0x0053:
            r5 = move-exception
            r6 = r1
            r1 = r3
            goto L_0x006c
        L_0x0057:
            r5 = move-exception
            r6 = r1
            r1 = r3
            goto L_0x0060
        L_0x005b:
            r5 = move-exception
            r6 = r1
            goto L_0x006c
        L_0x005e:
            r5 = move-exception
            r6 = r1
        L_0x0060:
            r5.getMessage()     // Catch:{ all -> 0x006b }
            m1126((java.io.Closeable) r1)     // Catch:{ all -> 0x0073 }
            m1126((java.io.Closeable) r6)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            return r2
        L_0x006b:
            r5 = move-exception
        L_0x006c:
            m1126((java.io.Closeable) r1)     // Catch:{ all -> 0x0073 }
            m1126((java.io.Closeable) r6)     // Catch:{ all -> 0x0073 }
            throw r5     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.FileUtils.m1136(java.io.File, byte[]):boolean");
    }

    /* renamed from: ֏ */
    public static byte[] m1133(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr2, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e = e;
                try {
                    e.getMessage();
                    close((Closeable) byteArrayOutputStream);
                    close((Closeable) inputStream);
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            byteArrayOutputStream = null;
            e.getMessage();
            close((Closeable) byteArrayOutputStream);
            close((Closeable) inputStream);
            return bArr;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            byteArrayOutputStream = null;
            th = th3;
            close((Closeable) byteArrayOutputStream);
            close((Closeable) inputStream);
            throw th;
        }
        close((Closeable) byteArrayOutputStream);
        close((Closeable) inputStream);
        return bArr;
    }

    /* renamed from: ֏ */
    public static void m1129(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[3072];
                while (true) {
                    int read = inputStream.read(bArr, 0, 3072);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                close((Closeable) fileOutputStream2);
            } catch (IOException e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    e.getMessage();
                    close((Closeable) fileOutputStream);
                    close((Closeable) inputStream);
                } catch (Throwable th) {
                    th = th;
                    close((Closeable) fileOutputStream);
                    close((Closeable) inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                close((Closeable) fileOutputStream);
                close((Closeable) inputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.getMessage();
            close((Closeable) fileOutputStream);
            close((Closeable) inputStream);
        }
        close((Closeable) inputStream);
    }

    /* renamed from: ֏ */
    public static void m1127(File file, String str) {
        FileWriter fileWriter = null;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str);
                fileWriter2.flush();
                close((Closeable) fileWriter2);
            } catch (Exception e) {
                e = e;
                fileWriter = fileWriter2;
                try {
                    e.getMessage();
                    close((Closeable) fileWriter);
                } catch (Throwable th) {
                    th = th;
                    close((Closeable) fileWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileWriter = fileWriter2;
                close((Closeable) fileWriter);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.getMessage();
            close((Closeable) fileWriter);
        }
    }

    /* renamed from: ֏ */
    public static void m1128(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                close((Closeable) fileOutputStream2);
            } catch (Exception e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    e.getMessage();
                    close((Closeable) fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    close((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                close((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.getMessage();
            close((Closeable) fileOutputStream);
        }
    }

    /* renamed from: ֏ */
    public static boolean m1131(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            if (file.exists()) {
                file2.getParentFile().mkdirs();
                file2.createNewFile();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    try {
                        e.getMessage();
                        close((Closeable) fileInputStream);
                        close((Closeable) fileOutputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        close((Closeable) fileInputStream);
                        close((Closeable) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    close((Closeable) fileInputStream);
                    close((Closeable) fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1444];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            close((Closeable) fileInputStream2);
                            close((Closeable) fileOutputStream);
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.getMessage();
                    close((Closeable) fileInputStream);
                    close((Closeable) fileOutputStream);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    close((Closeable) fileInputStream);
                    close((Closeable) fileOutputStream);
                    throw th;
                }
            } else {
                close((Closeable) null);
                close((Closeable) null);
                return false;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            e.getMessage();
            close((Closeable) fileInputStream);
            close((Closeable) fileOutputStream);
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            close((Closeable) fileInputStream);
            close((Closeable) fileOutputStream);
            throw th;
        }
    }

    /* renamed from: ֏ */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: ֏ */
    public static String m1124(Uri uri) {
        try {
            if ("content".equals(uri.getScheme())) {
                String[] strArr = {"_data"};
                Cursor query = AppUtils.getApplication().getContentResolver().query(uri, strArr, (String) null, (String[]) null, (String) null);
                if (query == null) {
                    return null;
                }
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(strArr[0]));
                query.close();
                return string;
            } else if ("file".equals(uri.getScheme())) {
                return new File(uri.getPath()).getAbsolutePath();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static FileLock m1125(FileChannel fileChannel, boolean z) {
        while (true) {
            try {
                FileLock tryLock = fileChannel.tryLock(0, RecyclerView.FOREVER_NS, z);
                if (tryLock != null && tryLock.isValid()) {
                    return tryLock;
                }
            } catch (IllegalArgumentException | ClosedChannelException e) {
                e.getMessage();
                return null;
            } catch (Exception unused) {
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException unused2) {
            }
        }
    }
}
