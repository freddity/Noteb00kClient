package com.example;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLConnector {

    private Object dbPen = new Object();
    private SQLiteDatabase database;

    public SQLConnector() {
        database = Database.getDatabase();
    }

    public ArrayList getAllNotes() throws SQLException {
        Log.d("Stack", "SQLConnector.getAllNotes()");

        Cursor cursor = database.rawQuery("SELECT * FROM notes", null);

        cursor.moveToFirst();

        ArrayList<Note> notes = new ArrayList<>();

        /*while (cursor.moveToLast()) {

            System.out.println("4444 " + notes.add(new Note(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2)
            )));
        }*/

        if (cursor.moveToFirst())
        {
            do
            {
                System.out.println("4444 " + notes.add(new Note(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)
                )));

            } while (cursor.moveToNext());
        }

        return notes;
    }

    public ArrayList addNote(String title, String description, String tag) throws SQLException {
        Log.d("Stack", "SQLConnector.addNote()");

        synchronized (dbPen) {
            database.execSQL("INSERT INTO notes VALUES('" + title + "','" + description + "','" + tag + "');");
        }

        return getAllNotes();
    }
}
