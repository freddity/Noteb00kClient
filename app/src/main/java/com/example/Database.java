package com.example;

import android.database.sqlite.SQLiteDatabase;

public class Database {

    private static SQLiteDatabase database;

    public Database(SQLiteDatabase database) {
        this.database = database;
    }

    public static SQLiteDatabase getDatabase() {
        return database;
    }
}
