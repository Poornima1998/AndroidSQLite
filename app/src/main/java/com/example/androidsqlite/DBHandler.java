package com.example.androidsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PROFILE.db";
    public static final String TABLE_PERSONAL = "PersonalProfile";

    private static String ID = "id";
    private static String NAME = "name";
    private static String EMAIL = "email";
    private static String PHONE = "phone";

    public DBHandler(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PERSONAL + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name text, email text, phone INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONAL);
        onCreate(sqLiteDatabase);
    }
    public boolean addData (String FullName, String Email, String Mobile)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, FullName);
        cv.put(EMAIL, Email);
        cv.put(PHONE, Mobile);

        long results = db.insert(TABLE_PERSONAL, null, cv);
        db.close();
        if (results == -1)
            return false;
        else
            return true;
    }
}
