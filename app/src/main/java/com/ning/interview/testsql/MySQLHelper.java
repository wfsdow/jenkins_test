package com.ning.interview.testsql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MySQLHelper extends SQLiteOpenHelper {
    public static final String TAG = "DatabaseHelper";
    private static final String DB_NAME = "practice.db";
    private static final int DB_VERSION = 1;
    public static final String createTable = "create table test(content text);";
    private static MySQLHelper helper ;
   public MySQLHelper(Context context) {
       super(context,DB_NAME,null,DB_VERSION);

   }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static synchronized MySQLHelper getInstance(Context context) {
       if (helper == null) {
           helper = new MySQLHelper(context.getApplicationContext());
       }
       return helper;
    }
}
