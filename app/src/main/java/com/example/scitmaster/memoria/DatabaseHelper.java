package com.example.scitmaster.memoria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by SCITMASTER on 2018-03-07.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Memoria.db";
    private static final String TABLE_NAME ="memoria";
    private static final String COL1 = "ID";        //rowid
    private static final String COL2 ="title";      //제목
    private static final String COL3 ="context";    //내용


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME ,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "title Text ," +
                "context Text)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP Table IF EXISTS "+TABLE_NAME);
      onCreate(db);
    }

    public boolean addData(String title, String context) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,title);
        contentValues.put(COL3,context);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //List
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return data;
    }

    //select List
    public Cursor getItemID(String title){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + title + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }



  //update
  public void updateName(String newtitle ,String newcontext, int id){
      SQLiteDatabase db = this.getWritableDatabase();
      String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
              " = '" + newtitle +"' , " + COL3 + " = '" + newcontext +
               "' WHERE " + COL1 + " = '" + id + "'";
      db.execSQL(query);
  }

    //delete
    public void deleteName(int id, String title,String context){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + title + "'"+
                " AND " + COL3 + " = '" + context + "'";
        db.execSQL(query);
    }

}
