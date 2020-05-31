package com.example.assessment2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "registration.db";
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "user_id";
    public static final String COLUMN_USER = "username";
    public static final String COLUMN_PWD = "password";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (user_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
       onCreate(db);
    }

    public long insert (String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long newRowId = db.insert(TABLE_NAME, null, contentValues);
        db.close();

        return newRowId;
    }

    public boolean fetchUser (String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"user_id"};
        String selection = COLUMN_USER + "= ? and " + COLUMN_PWD + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int numberOfRows = cursor.getCount();
        cursor.close();
        db.close();

        if (numberOfRows > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
