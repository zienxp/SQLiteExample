package com.example.sqliteexample;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ContactDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contact_db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "create table " + ContactContract.ContactEntry.TABLE_Name +
            "(" + ContactContract.ContactEntry.CONTACT_ID + "number," + ContactContract.ContactEntry.TABLE_Name + "text,"
            + ContactContract.ContactEntry.EMAIL + "text);";
    private static final String Drop_Table = "drop table if Exists " + ContactContract.ContactEntry.TABLE_Name;

    ContactDbHelper(Context context) {
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

    void addContact(int id, String name, String email, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.CONTACT_ID, id);
        contentValues.put(ContactContract.ContactEntry.NAME, name);
        contentValues.put(ContactContract.ContactEntry.EMAIL, email);

        database.insert(ContactContract.ContactEntry.TABLE_Name, null, contentValues);
        Log.d("Database Operation", "one Raw inserted... ");
    }

    public Cursor readContacts(SQLiteDatabase database) {
        String[] projection = {ContactContract.ContactEntry.CONTACT_ID, ContactContract.ContactEntry.NAME, ContactContract.ContactEntry.EMAIL};
        Cursor cursor = database.query(ContactContract.ContactEntry.TABLE_Name, projection, null, null, null, null, null);
        return cursor;
    }
}
