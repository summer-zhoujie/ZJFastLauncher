package android.support.p000v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.content.Loader;
import android.support.p000v4.p002os.CancellationSignal;
import android.support.p000v4.p002os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* renamed from: android.support.v4.content.CursorLoader */
public class CursorLoader extends AsyncTaskLoader<Cursor> {
    public CancellationSignal mCancellationSignal;
    public Cursor mCursor;
    public final Loader<Cursor>.ForceLoadContentObserver mObserver = new Loader.ForceLoadContentObserver();
    public String[] mProjection;
    public String mSelection;
    public String[] mSelectionArgs;
    public String mSortOrder;
    public Uri mUri;

    public CursorLoader(@NonNull Context context) {
        super(context);
    }

    public void cancelLoadInBackground() {
        synchronized (this) {
            if (this.mCancellationSignal != null) {
                this.mCancellationSignal.cancel();
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.mUri);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.mProjection));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.mSelection);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.mSelectionArgs));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.mSortOrder);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.mCursor);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }

    @Nullable
    public String[] getProjection() {
        return this.mProjection;
    }

    @Nullable
    public String getSelection() {
        return this.mSelection;
    }

    @Nullable
    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    @Nullable
    public String getSortOrder() {
        return this.mSortOrder;
    }

    @NonNull
    public Uri getUri() {
        return this.mUri;
    }

    public void onReset() {
        onStopLoading();
        Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            this.mCursor.close();
        }
        this.mCursor = null;
    }

    public void onStartLoading() {
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.mCursor == null) {
            forceLoad();
        }
    }

    public void onStopLoading() {
        cancelLoad();
    }

    public void setProjection(@Nullable String[] strArr) {
        this.mProjection = strArr;
    }

    public void setSelection(@Nullable String str) {
        this.mSelection = str;
    }

    public void setSelectionArgs(@Nullable String[] strArr) {
        this.mSelectionArgs = strArr;
    }

    public void setSortOrder(@Nullable String str) {
        this.mSortOrder = str;
    }

    public void setUri(@NonNull Uri uri) {
        this.mUri = uri;
    }

    public void deliverResult(Cursor cursor) {
        Loader.OnLoadCompleteListener<D> onLoadCompleteListener;
        if (!isReset()) {
            Cursor cursor2 = this.mCursor;
            this.mCursor = cursor;
            if (isStarted() && (onLoadCompleteListener = this.mListener) != null) {
                onLoadCompleteListener.onLoadComplete(this, cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public Cursor loadInBackground() {
        Cursor query;
        synchronized (this) {
            if (!isLoadInBackgroundCanceled()) {
                this.mCancellationSignal = new CancellationSignal();
            } else {
                throw new OperationCanceledException((String) null);
            }
        }
        try {
            query = ContentResolverCompat.query(getContext().getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);
            if (query != null) {
                query.getCount();
                query.registerContentObserver(this.mObserver);
            }
            synchronized (this) {
                this.mCancellationSignal = null;
            }
            return query;
        } catch (RuntimeException e) {
            query.close();
            throw e;
        } catch (Throwable th) {
            synchronized (this) {
                this.mCancellationSignal = null;
                throw th;
            }
        }
    }

    public void onCanceled(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public CursorLoader(@NonNull Context context, @NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        super(context);
        this.mUri = uri;
        this.mProjection = strArr;
        this.mSelection = str;
        this.mSelectionArgs = strArr2;
        this.mSortOrder = str2;
    }
}
