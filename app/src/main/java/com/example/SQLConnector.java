package com.example;

import android.database.Cursor;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;

public class SQLConnector {

    private Object dbPen = new Object();

    public ArrayList getAllNotes() throws SQLException {
        Log.d("Stack", "SQLConnector.getAllNotes()");

        ArrayList<Note> notes = new ArrayList<>();

        Cursor rs = DatabaseVar.getDatabase().rawQuery("SELECT * FROM notes", null);

        rs.moveToFirst();

        notes.add(new Note(
                rs.getString(0),
                rs.getString(1),
                rs.getString(2)
        ));

        return notes;
    }

    public ArrayList addNote(String title, String description, String tag) throws SQLException {
        Log.d("Stack", "SQLConnector.addNote()");

        DatabaseVar.getDatabase().execSQL(
                "INSERT INTO notes (title, description, tag) VALUES('" + title + "', '" + description + "', '" + tag + "')");

        return getAllNotes();
    }
}
