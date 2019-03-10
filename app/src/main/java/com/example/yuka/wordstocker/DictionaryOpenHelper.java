package com.example.yuka.wordstocker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DictionaryOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DICTIONARY_TABLE_NAME = "dictionary";
    private static final String DATABASE_NAME = "test.db";
    public static final String SEARCH_WORD = "search_word";
    public static final String SEARCHED_URL = "url";
    public static final String SEARCHED_TIMESTAMP = "timestamp";
    private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + DICTIONARY_TABLE_NAME + " (" +
                    SEARCH_WORD + " TEXT, " +
                    SEARCHED_URL + " TEXT," +
                    SEARCHED_TIMESTAMP + "TEXT);";

    DictionaryOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}