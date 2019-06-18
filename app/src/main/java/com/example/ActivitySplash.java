package com.example;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class ActivitySplash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SQLiteDatabase database = openOrCreateDatabase("database",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notes(title TEXT, description TEXT, tag TEXT);");


        Intent intent = new Intent(this, ActivitySignIn.class);
        startActivity(intent);
        finish();
    }
}
