package com.aaa.mobile11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(@Nullable Context context) {
        super(context, "groupDB2", null, 1);
        Log.d("sqlite3DDL", "데이터베이스 생성 호출함……—");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE groupTBL2 (gName char(20), gNumber INTEGER);");
        Log.d("sqlite3DDL", "CREATE TABLE 호출함……—");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS groupTBL2");
        Log.d("sqlite3DDL", "DROP TABLE 호출함……—");
        onCreate(db);
    }
}