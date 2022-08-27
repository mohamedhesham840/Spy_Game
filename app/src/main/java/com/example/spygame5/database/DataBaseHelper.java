package com.example.spygame5.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String CATEGORY_COL = "category_col";
    public static final String ELEMENT_COL = "element_col";
    public static final String ID = "ID";
    public static final String CATEGORY_TABLE = "category_table";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "app_database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + CATEGORY_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CATEGORY_COL + " TEXT, " + ELEMENT_COL + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String element, String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CATEGORY_COL, category);
        cv.put(ELEMENT_COL, element);
        long done = db.insert(CATEGORY_TABLE, null, cv);
        return (done > 0);
    }

    public void delete(String element) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + CATEGORY_TABLE + " WHERE " + ELEMENT_COL + " = '" + element + "' ";
        db.execSQL(query);
    }

    public List<Pair<String, String>> getAllCategories() {
        List<Pair<String, String>> list = new ArrayList<>();

        String query = "SELECT * FROM " + CATEGORY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Pair<String, String> node =
                        new Pair<>(cursor.getString(1), cursor.getString(2));
                list.add(node);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return list;
    }
}