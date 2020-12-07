package android.support.p003v7.recyclerview.extensions;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p003v7.recyclerview.extensions.AsyncDifferConfig;
import android.support.p003v7.util.AdapterListUpdateCallback;
import android.support.p003v7.util.DiffUtil;
import android.support.p003v7.util.ListUpdateCallback;
import android.support.p003v7.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v7.recyclerview.extensions.AsyncListDiffer */
public class AsyncListDiffer<T> {
    public final AsyncDifferConfig<T> mConfig;
    @Nullable
    public List<T> mList;
    public int mMaxScheduledGeneration;
    @NonNull
    public List<T> mReadOnlyList = Collections.emptyList();
    public final ListUpdateCallback mUpdateCallback;

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this.mUpdateCallback = new AdapterListUpdateCallback(adapter);
        this.mConfig = new AsyncDifferConfig.Builder(itemCallback).build();
    }

    public static /* synthetic */ void access$200(AsyncListDiffer asyncListDiffer, List list, DiffUtil.DiffResult diffResult) {
        asyncListDiffer.mList = list;
        asyncListDiffer.mReadOnlyList = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(asyncListDiffer.mUpdateCallback);
    }

    private void latchList(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult) {
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    public void submitList(final List<T> list) {
        final List<T> list2 = this.mList;
        if (list != list2) {
            final int i = this.mMaxScheduledGeneration + 1;
            this.mMaxScheduledGeneration = i;
            if (list == null) {
                int size = list2.size();
                this.mList = null;
                this.mReadOnlyList = Collections.emptyList();
                this.mUpdateCallback.onRemoved(0, size);
            } else if (list2 == null) {
                this.mList = list;
                this.mReadOnlyList = Collections.unmodifiableList(list);
                this.mUpdateCallback.onInserted(0, list.size());
            } else {
                this.mConfig.getBackgroundThreadExecutor().execute(new Runnable() {
                    public void run() {
                        final DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                            public boolean areContentsTheSame(int i, int i2) {
                                return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(list2.get(i), list.get(i2));
                            }

                            public boolean areItemsTheSame(int i, int i2) {
                                return AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(list2.get(i), list.get(i2));
                            }

                            @Nullable
                            public Object getChangePayload(int i, int i2) {
                                return AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(list2.get(i), list.get(i2));
                            }

                            public int getNewListSize() {
                                return list.size();
                            }

                            public int getOldListSize() {
                                return list2.size();
                            }
                        });
                        AsyncListDiffer.this.mConfig.getMainThreadExecutor().execute(new Runnable() {
                            public void run() {
                                C01831 r0 = C01831.this;
                                AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                                if (asyncListDiffer.mMaxScheduledGeneration == i) {
                                    AsyncListDiffer.access$200(asyncListDiffer, list, calculateDiff);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
    }
}
