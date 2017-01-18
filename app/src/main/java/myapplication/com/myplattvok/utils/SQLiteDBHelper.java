package myapplication.com.myplattvok.utils;

import android.database.sqlite.SQLiteDatabase;

import java.io.File;

/**
 * Created by Administrator on 2017/1/18.
 */

public class SQLiteDBHelper {
    private static String DB_PATH = SDcardHelper.getSDCardPath();
    private static String DB_NAME = "shouchang.db";  // 数据库名称

    static {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DB_PATH+ File.separator+DB_NAME, null);
        db.execSQL("create table if not exists shouchang(" +
                "title varchar(600)," +
                "id varchar(20)," +
                "player varchar(100))");
        db.close();
    }

    public static SQLiteDatabase getSqLiteDatabase() {
        return SQLiteDatabase.openOrCreateDatabase(DB_PATH+File.separator+DB_NAME, null);
    }

}
