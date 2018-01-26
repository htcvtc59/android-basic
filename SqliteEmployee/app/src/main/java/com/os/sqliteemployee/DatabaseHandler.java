package com.os.sqliteemployee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MacOS on 18/01/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "employeeManager";
    private static final String TABLE_EMPLOYEES = "employees";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_EMPLOYEES_TABLE = "CREATE TABLE " + TABLE_EMPLOYEES + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_EMPLOYEES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_EMPLOYEES;
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, employee.getName());
        db.insert(TABLE_EMPLOYEES, null, values);
        db.close();
    }

    public void deleteEmployee(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMPLOYEES, KEY_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_EMPLOYEES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Employee employee = new Employee();
                employee.setId(cursor.getInt(0));
                employee.setName(cursor.getString(1));
                list.add(employee);
                Log.v("Demo", employee.getName());
            } while (cursor.moveToNext());
        }
        return list;
    }
}
