package com.example.kimhun.moneymoney;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kimhun on 2017-05-31.
 */

public class DBLogin{
    private static final String dbName = "User.db";
    private static final String tableName = "USER";
    public static final int dbVersion = 1;
    private OpenHelper opener;
    private SQLiteDatabase db;
    private Context context;
    public DBLogin(Context context){
        this.context = context;
        this.opener = new OpenHelper(context, dbName, null, dbVersion);
        db = opener.getWritableDatabase();
    }
    private class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,  int version){
            super(context, name, null, version);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String createsql = "create table "+ tableName + " (" + "id integer primary key autoincrement, " + " name text, " + "money integer)";
            sqLiteDatabase.execSQL(createsql);

        }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

    }
    public void insert(String name, int amount){
        String sql = "insert into " + tableName + " values(NULL, '" + name + "', " + amount + ");";
        db.execSQL(sql);
    }
    public void update(String name, int amount){
        String sql = "update " + tableName + " set money = " + amount + " where name = '" + name + "';";
        db.execSQL(sql);
    }
    public String getName(){
        String result = "";
        Cursor cursor = db.rawQuery("SELECT *  FROM USER",null);
        while (cursor.moveToNext()){
            result += cursor.getString(1);
        }
        return result;
    }
    public int getMoney(){
        int result = 0;
        Cursor cursor = db.rawQuery("SELECT *  FROM USER",null);
        while (cursor.moveToNext()){
            result += cursor.getInt(2);
        }
        return result;
    }
}
