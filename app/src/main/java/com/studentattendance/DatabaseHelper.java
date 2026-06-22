package com.studentattendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Attendance.db";
    private static final String TABLE_NAME = "attendance";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "NAME";
    private static final String COL_3 = "STUDENT_ID";
    private static final String COL_4 = "COURSE";
    private static final String COL_5 = "DATE";
    private static final String COL_6 = "STATUS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, STUDENT_ID TEXT, COURSE TEXT, DATE TEXT, STATUS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertAttendance(String name, String studentId, String course, String date, String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, studentId);
        contentValues.put(COL_4, course);
        contentValues.put(COL_5, date);
        contentValues.put(COL_6, status);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllAttendance() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME, null);
    }
}