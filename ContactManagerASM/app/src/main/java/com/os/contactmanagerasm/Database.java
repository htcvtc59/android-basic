package com.os.contactmanagerasm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by MacOS on 25/01/2018.
 */

public class Database extends SQLiteOpenHelper {

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void QueryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor GetData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    public void InsertContact(String name, String phone, byte[] img) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "insert into Contact values(null,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindString(2, phone);
        statement.bindBlob(3, img);

        statement.executeInsert();

    }

    public void UpdateContact(String name, String phone, byte[] img, int id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "update Contact set Name=?, Phone=?, ImgC=? where id='" + id + "'";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindString(2, phone);
        statement.bindBlob(3, img);
        statement.executeUpdateDelete();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
