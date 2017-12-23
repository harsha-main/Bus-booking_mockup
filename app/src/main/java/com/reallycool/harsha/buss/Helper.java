package com.reallycool.harsha.buss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harsha on 19/12/17.
 */

public class Helper extends SQLiteOpenHelper {
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DATE = "date";

    String str;
    String busa="busa",busb="busb", busc = "busc";
    public Helper(Context context,String s) {
        super(context, "Tdata", null, 1);
        Log.e("Newtable", "newhope");
    str=s;}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("Table", "Table Created");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+busa+" (id INTEGER PRIMARY KEY, name TEXT, date TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+busb+" (id INTEGER PRIMARY KEY, name TEXT, date TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+busc+" (id INTEGER PRIMARY KEY, name TEXT, date TEXT)");
    }

    @Override
    public void onOpen(SQLiteDatabase sqLiteDatabase) {

          }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    void addseat(Seat seat){
SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", seat.id);
        values.put("name", seat.name);
        values.put("date",seat.date);
        db.insert(str, null, values);
        db.close();
    }


    Seat getSeat(int id){
    SQLiteDatabase db=getReadableDatabase();
    Cursor cursor= db.query(str,new String[]{"id","name", "date"},"date = '"+MainActivity.bdate+"'",
            new String[]{String.valueOf(id)}, null, null, null);
if(cursor!=null)cursor.moveToFirst();
        Seat seat = new Seat(Integer.parseInt(cursor.getString(0)), cursor.getString(1),cursor.getString(2));
        return seat;
    }
    List<Seat> getallseats(int n){
        List<Seat> contactList = new ArrayList<Seat>();
        String t=" WHERE date = '"+ MainActivity.bdate+"'";
        if(n==0) t = "";
        String selectQuery = "SELECT  * FROM "+str +t;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Seat contact = new Seat();
                contact.id=(Integer.parseInt(cursor.getString(0)));
                contact.name=(cursor.getString(1));
                contact.date=(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
    public int updateContact(Seat contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.name);
        values.put(KEY_DATE, contact.date);
        // updating row
        return db.update(str, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.id) });
    }
}