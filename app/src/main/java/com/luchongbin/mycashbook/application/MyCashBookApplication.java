package com.luchongbin.mycashbook.application;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.luchongbin.mycashbook.greendao.DaoMaster;
import com.luchongbin.mycashbook.greendao.DaoSession;
//import com.luchongbin.mycashbook.http.RestApi;


/**
 * Created by luchongbin on 2017/6/23.
 */

public class MyCashBookApplication extends Application {
    private static Context mContext;
    private static MyCashBookApplication instance;

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
//        RestApi.getInstance().bug(BuildConfig.DEBUG);
        super.onCreate();
        mContext = getApplicationContext();
        setDatabase();

    }

    public static MyCashBookApplication getInstance() {
        if (instance == null) {
            instance = new MyCashBookApplication();
        }
        return instance;
    }

    public Context getContext() {
        return mContext;
    }

    /**
     *      * 设置greenDao
     *     
     */
    private void setDatabase() {
// 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
// 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        // 此处sport-db表示数据库名称 可以任意填写
        mHelper = new DaoMaster.DevOpenHelper(this, "luchongwen-db", null);
        db = mHelper.getWritableDatabase();
// 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
