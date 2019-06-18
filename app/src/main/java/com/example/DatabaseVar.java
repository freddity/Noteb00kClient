package com.example;

import android.database.sqlite.SQLiteDatabase;

public class DatabaseVar {

    private static SQLiteDatabase database;

    public DatabaseVar(SQLiteDatabase database) {
        this.database = database;
    }

    public static SQLiteDatabase getDatabase() {
        return database;
    }
}
