package com.zj.fastlauncher.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.zj.fastlauncher.db.entities.ActCanJumpDao;
import com.zj.fastlauncher.db.entities.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * greendao 数据库升级辅助类
 */
public class GreendaoUpgradeHelper extends DaoMaster.OpenHelper {

    public GreendaoUpgradeHelper(Context context, String name) {
        super(context, name);
    }

    public GreendaoUpgradeHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, ActCanJumpDao.class);
    }
}
