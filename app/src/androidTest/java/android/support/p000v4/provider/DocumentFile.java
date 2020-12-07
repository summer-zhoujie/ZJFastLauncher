package android.support.p000v4.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import java.io.File;

/* renamed from: android.support.v4.provider.DocumentFile */
public abstract class DocumentFile {
    public static final String TAG = "DocumentFile";
    public final DocumentFile mParent;

    public DocumentFile(DocumentFile documentFile) {
        this.mParent = documentFile;
    }

    public static DocumentFile fromFile(File file) {
        return new RawDocumentFile((DocumentFile) null, file);
    }

    public static DocumentFile fromSingleUri(Context context, Uri uri) {
        int i = Build.VERSION.SDK_INT;
        return new SingleDocumentFile((DocumentFile) null, context, uri);
    }

    public static DocumentFile fromTreeUri(Context context, Uri uri) {
        int i = Build.VERSION.SDK_INT;
        return new TreeDocumentFile((DocumentFile) null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        int i = Build.VERSION.SDK_INT;
        return DocumentsContractApi19.isDocumentUri(context, uri);
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String str);

    public abstract DocumentFile createFile(String str, String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    public DocumentFile findFile(String str) {
        for (DocumentFile documentFile : listFiles()) {
            if (str.equals(documentFile.getName())) {
                return documentFile;
            }
        }
        return null;
    }

    public abstract String getName();

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String str);
}
