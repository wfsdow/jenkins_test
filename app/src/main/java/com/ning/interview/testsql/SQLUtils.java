package com.ning.interview.testsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLUtils {
    public static Context context ;
    public static void insert(String content) {
        MySQLHelper helper = MySQLHelper.getInstance(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into test values(\""+content+"\");");
        db.close();
    }

    public static void delete() {
        MySQLHelper helper = MySQLHelper.getInstance(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from test;");
        db.close();
    }
}
