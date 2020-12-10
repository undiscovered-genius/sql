package com.example.bank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "people_table";
    private static final String COL1 = "ID";
    private  static  final String COL2 = "name";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("+COL1+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData(databaseHandler handler) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL1, handler.getId());
        contentValues.put(COL2,handler.getName());

        Log.d(TAG, "addData: Adding " + handler.getId()+" to " + TABLE_NAME);
         db.insert(TABLE_NAME,null,contentValues);

        db.close();
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

//    databaseHandler getData(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_NAME, new String[] { COL1,
//                        COL2}, COL1 + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        databaseHandler handler = new databaseHandler(Integer.parseInt(cursor.getString(0)),
//                cursor.getString(1));
//        // return contact
//        return handler;
//    }

    public  List<databaseHandler> getAllContacts() {
        List<databaseHandler> contactList = new ArrayList<databaseHandler>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

//        return cursor;
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                databaseHandler handler = new databaseHandler();

//                handler.setId(Integer.parseInt(cursor.getString(0)));
//                handler.setName(cursor.getString(1));

                handler.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("ID")).toString()));
                handler.setName(cursor.getString(cursor.getColumnIndex("name")).toString());
                //contact.setPhoneNumber(cursor.getString(2));
                // Adding contact to list
                contactList.add(handler);

            } while (cursor.moveToNext());
        }
//
//        // return contact list
        return contactList;
    }
}
