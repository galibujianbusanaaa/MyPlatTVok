package myapplication.com.myplattvok.bean;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import myapplication.com.myplattvok.utils.SQLiteDBHelper;

/**
 * Created by Administrator on 2017/1/18.
 */

public class InfoDao {


    public boolean insert(Info info) {
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        try {
            db.execSQL("insert into shouchang (title,id,player) values(?,?,?)",
                    new Object[]{ info.getTitle(),info.getId(),info.getPlayer()});
            db.close();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;
    }

    public boolean query(String id){
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();

        Cursor cursor = db.rawQuery("select * from shouchang where id ="+id,null);
        Info info = null;
        while (cursor.moveToNext()) {
           return true;
        }
        return  false;
    }
    public void delete(String id) {
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();

        db.execSQL("delete from shouchang where id = " + id);
        db.close();
    }

    public List<Info> findAll() {
        List<Info> list = new ArrayList<Info>();
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();

        Cursor cursor = db.rawQuery("select * from shouchang",null);
        Info info = null;
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String player = cursor.getString(cursor.getColumnIndex("player"));

            info = new Info(title,id,player);
            list.add(info);
        }
        return list;
    }

}
