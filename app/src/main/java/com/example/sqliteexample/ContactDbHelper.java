package com.example.sqliteexample;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ContactDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_TABLE = "create table" + ContactContract.ContactEntry.TABLE_Name +
            "(" + ContactContract.ContactEntry.CONTACT_ID + "number," + ContactContract.ContactEntry.TABLE_Name + "text,"
            + ContactContract.ContactEntry.EMAIL + "text);";
    public static final String Drop_Table = "drop table if exists" + ContactContract.ContactEntry.TABLE_Name;

    public ContactDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operation", "Database... ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database Operation", "Table Created ... ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Drop_Table);
        onCreate(db);

    }
}
