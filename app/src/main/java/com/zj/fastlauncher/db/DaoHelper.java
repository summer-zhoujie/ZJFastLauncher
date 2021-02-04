package com.zj.fastlauncher.db;

import android.database.sqlite.SQLiteDatabase;

import com.zj.fastlauncher.BaseApplication;
import com.zj.fastlauncher.db.entities.DaoMaster;
import com.zj.fastlauncher.db.entities.DaoSession;

public class DaoHelper {

    private static final String DB_NAME = "FAST_ACT_DB";

    private static volatile DaoHelper sInstance;
    private final SQLiteDatabase mDb;
    private final DaoMaster mDaoMaster;
    private final DaoSession mSession;


    private DaoHelper() {
        //封装数据库的创建、更新、删除
        GreendaoUpgradeHelper upgradeHelper = new GreendaoUpgradeHelper(BaseApplication.getApp().getApplicationContext(), DB_NAME, null);
        //获取数据库
        mDb = upgradeHelper.getWritableDatabase();
        //封装数据库中表的创建、更新、删除
        mDaoMaster = new DaoMaster(mDb);  //合起来就是对数据库的操作
        //对表操作的对象。
        mSession = mDaoMaster.newSession(); //可以认为是对数据的操作
    }

    public static DaoHelper getInstance() {
        if (sInstance == null) {
            synchronized (DaoHelper.class) {
                if (sInstance == null) {
                    sInstance = new DaoHelper();
                }
            }
        }
        return sInstance;
    }

    public DaoSession getSession() {
        return mSession;
    }

    public SQLiteDatabase getDatabase() {
        return mDb;
    }

    public DaoSession getNewSession() {
        return mDaoMaster.newSession();
    }
}
