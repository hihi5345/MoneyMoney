package com.example.kimhun.moneymoney;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by kimhun on 2017-05-31.
 */

public class DBHelper {
    private static final String dbName = "List.db";
    private static final String tableName = "LIST";
    public static final int dbVersion = 1;
    private OpenHelper opener;
    private SQLiteDatabase db;
    private Context context;

    public DBHelper(Context context) {
        this.context = context;
        this.opener = new OpenHelper(context, dbName, null, dbVersion);
        db = opener.getWritableDatabase();
    }

    private class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String createsql = "create table " + tableName + " (" + "id integer primary key autoincrement, " + "day text, " + " cate text, " + "money integer);";
            sqLiteDatabase.execSQL(createsql);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

    }

    public void insert(String day, String cate, int amount) {
        String sql = "insert into " + tableName + " values(null, '" + day + "', '" + cate + "', " + amount + ");";
        db.execSQL(sql);
    }

    public String getHistory_day() {
        Calendar cal = Calendar.getInstance();
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
        formatter.setTimeZone(cal.getTimeZone());
        String formatted = formatter.format(cal.getTime());
        String result = "";
        Cursor cursor = db.rawQuery("SELECT *  FROM LIST", null);
        while (cursor.moveToNext()) {
            if (formatted.equals(cursor.getString(1))) {
                result += cursor.getString(1)
                        + " | "
                        + cursor.getString(2)
                        + " | "
                        + cursor.getInt(3)
                        + "\n";
            }
        }
        return result;
    }

    public String getHistory_week() throws ParseException {
        Calendar cal = Calendar.getInstance();
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
        formatter.setTimeZone(cal.getTimeZone());
        String result = "";
        Cursor cursor = db.rawQuery("SELECT *  FROM LIST", null);
        while (cursor.moveToNext()) {
            java.text.SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyy.MM.dd.");
            java.util.Date date1 = format1.parse(cursor.getString(1));
            java.text.SimpleDateFormat format2 = new java.text.SimpleDateFormat("yyyy.MM.dd.");
            java.util.Date date2 = format2.parse(formatter.format(cal.getTime()));
            date2.setDate(date2.getDate() - 7);

            if (date1.compareTo(date2) >= 0) {
                result += cursor.getString(1)
                        + " | "
                        + cursor.getString(2)
                        + " | "
                        + cursor.getInt(3)
                        + "\n";
            }
        }

        return result;
    }

    public String getHistory_month() throws ParseException {
        Calendar cal = Calendar.getInstance();
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
        formatter.setTimeZone(cal.getTimeZone());
        String result = "";
        Cursor cursor = db.rawQuery("SELECT *  FROM LIST", null);
        while (cursor.moveToNext()) {
            java.text.SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyy.MM.dd.");
            java.util.Date date1 = format1.parse(cursor.getString(1));
            java.text.SimpleDateFormat format2 = new java.text.SimpleDateFormat("yyyy.MM.dd.");
            java.util.Date date2 = format2.parse(formatter.format(cal.getTime()));
            date2.setDate(date2.getDate() - 30);
            if (date1.compareTo(date2) >= 0) {
                result += cursor.getString(1)
                        + " | "
                        + cursor.getString(2)
                        + " | "
                        + cursor.getInt(3)
                        + "\n";
            }
        }

        return result;
    }
}
