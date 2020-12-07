package android.support.p003v7.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.p003v7.util.ThreadUtil;
import android.support.p003v7.util.TileList;
import com.wpengapp.support.outline;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: android.support.v7.util.MessageThreadUtil */
public class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* renamed from: android.support.v7.util.MessageThreadUtil$MessageQueue */
    static class MessageQueue {
        public SyncQueueItem mRoot;

        public synchronized SyncQueueItem next() {
            if (this.mRoot == null) {
                return null;
            }
            SyncQueueItem syncQueueItem = this.mRoot;
            this.mRoot = this.mRoot.next;
            return syncQueueItem;
        }

        public synchronized void removeMessages(int i) {
            while (this.mRoot != null && this.mRoot.what == i) {
                SyncQueueItem syncQueueItem = this.mRoot;
                this.mRoot = this.mRoot.next;
                syncQueueItem.recycle();
            }
            if (this.mRoot != null) {
                SyncQueueItem syncQueueItem2 = this.mRoot;
                SyncQueueItem access$000 = syncQueueItem2.next;
                while (access$000 != null) {
                    SyncQueueItem access$0002 = access$000.next;
                    if (access$000.what == i) {
                        SyncQueueItem unused = syncQueueItem2.next = access$0002;
                        access$000.recycle();
                    } else {
                        syncQueueItem2 = access$000;
                    }
                    access$000 = access$0002;
                }
            }
        }

        public synchronized void sendMessage(SyncQueueItem syncQueueItem) {
            if (this.mRoot == null) {
                this.mRoot = syncQueueItem;
                return;
            }
            SyncQueueItem syncQueueItem2 = this.mRoot;
            while (syncQueueItem2.next != null) {
                syncQueueItem2 = syncQueueItem2.next;
            }
            SyncQueueItem unused = syncQueueItem2.next = syncQueueItem;
        }

        public synchronized void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            SyncQueueItem unused = syncQueueItem.next = this.mRoot;
            this.mRoot = syncQueueItem;
        }
    }

    public BackgroundCallback<T> getBackgroundProxy(final BackgroundCallback<T> backgroundCallback) {
        return new BackgroundCallback<T>() {
            public static final int LOAD_TILE = 3;
            public static final int RECYCLE_TILE = 4;
            public static final int REFRESH = 1;
            public static final int UPDATE_RANGE = 2;
            public Runnable mBackgroundRunnable = new Runnable() {
                public void run() {
                    while (true) {
                        SyncQueueItem next = C01912.this.mQueue.next();
                        if (next == null) {
                            C01912.this.mBackgroundRunning.set(false);
                            return;
                        }
                        int i = next.what;
                        if (i == 1) {
                            C01912.this.mQueue.removeMessages(1);
                            backgroundCallback.refresh(next.arg1);
                        } else if (i == 2) {
                            C01912.this.mQueue.removeMessages(2);
                            C01912.this.mQueue.removeMessages(3);
                            backgroundCallback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                        } else if (i == 3) {
                            backgroundCallback.loadTile(next.arg1, next.arg2);
                        } else if (i != 4) {
                            StringBuilder r1 = outline.m2549("Unsupported message, what=");
                            r1.append(next.what);
                            r1.toString();
                        } else {
                            backgroundCallback.recycleTile((TileList.Tile) next.data);
                        }
                    }
                }
            };
            public AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
            public final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
            public final MessageQueue mQueue = new MessageQueue();

            private void maybeExecuteBackgroundRunnable() {
                if (this.mBackgroundRunning.compareAndSet(false, true)) {
                    this.mExecutor.execute(this.mBackgroundRunnable);
                }
            }

            private void sendMessage(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessage(syncQueueItem);
                maybeExecuteBackgroundRunnable();
            }

            private void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
                maybeExecuteBackgroundRunnable();
            }

            public void loadTile(int i, int i2) {
                this.mQueue.sendMessage(SyncQueueItem.obtainMessage(3, i, i2));
                maybeExecuteBackgroundRunnable();
            }

            public void recycleTile(TileList.Tile<T> tile) {
                this.mQueue.sendMessage(SyncQueueItem.obtainMessage(4, 0, (Object) tile));
                maybeExecuteBackgroundRunnable();
            }

            public void refresh(int i) {
                this.mQueue.sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, i, (Object) null));
                maybeExecuteBackgroundRunnable();
            }

            public void updateRange(int i, int i2, int i3, int i4, int i5) {
                this.mQueue.sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, i, i2, i3, i4, i5, (Object) null));
                maybeExecuteBackgroundRunnable();
            }
        };
    }

    public MainThreadCallback<T> getMainThreadProxy(final MainThreadCallback<T> mainThreadCallback) {
        return new MainThreadCallback<T>() {
            public static final int ADD_TILE = 2;
            public static final int REMOVE_TILE = 3;
            public static final int UPDATE_ITEM_COUNT = 1;
            public final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
            public Runnable mMainThreadRunnable = new Runnable() {
                public void run() {
                    SyncQueueItem next = C01891.this.mQueue.next();
                    while (next != null) {
                        int i = next.what;
                        if (i == 1) {
                            mainThreadCallback.updateItemCount(next.arg1, next.arg2);
                        } else if (i == 2) {
                            mainThreadCallback.addTile(next.arg1, (TileList.Tile) next.data);
                        } else if (i != 3) {
                            StringBuilder r1 = outline.m2549("Unsupported message, what=");
                            r1.append(next.what);
                            r1.toString();
                        } else {
                            mainThreadCallback.removeTile(next.arg1, next.arg2);
                        }
                        next = C01891.this.mQueue.next();
                    }
                }
            };
            public final MessageQueue mQueue = new MessageQueue();

            private void sendMessage(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessage(syncQueueItem);
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }

            public void addTile(int i, TileList.Tile<T> tile) {
                this.mQueue.sendMessage(SyncQueueItem.obtainMessage(2, i, (Object) tile));
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }

            public void removeTile(int i, int i2) {
                this.mQueue.sendMessage(SyncQueueItem.obtainMessage(3, i, i2));
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }

            public void updateItemCount(int i, int i2) {
                this.mQueue.sendMessage(SyncQueueItem.obtainMessage(1, i, i2));
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }
        };
    }

    /* renamed from: android.support.v7.util.MessageThreadUtil$SyncQueueItem */
    static class SyncQueueItem {
        public static SyncQueueItem sPool;
        public static final Object sPoolLock = new Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        public SyncQueueItem next;
        public int what;

        public static SyncQueueItem obtainMessage(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (sPoolLock) {
                if (sPool == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    syncQueueItem = sPool;
                    sPool = sPool.next;
                    syncQueueItem.next = null;
                }
                syncQueueItem.what = i;
                syncQueueItem.arg1 = i2;
                syncQueueItem.arg2 = i3;
                syncQueueItem.arg3 = i4;
                syncQueueItem.arg4 = i5;
                syncQueueItem.arg5 = i6;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        public void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (sPoolLock) {
                if (sPool != null) {
                    this.next = sPool;
                }
                sPool = this;
            }
        }

        public static SyncQueueItem obtainMessage(int i, int i2, int i3) {
            return obtainMessage(i, i2, i3, 0, 0, 0, (Object) null);
        }

        public static SyncQueueItem obtainMessage(int i, int i2, Object obj) {
            return obtainMessage(i, i2, 0, 0, 0, 0, obj);
        }
    }
}
