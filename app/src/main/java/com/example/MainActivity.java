package com.example;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            MenuItem notesItem = findViewById(R.id.navigation_notes);
            MenuItem settingsItem = findViewById(R.id.navigation_settings);
            MenuItem tagsItem = findViewById(R.id.navigation_tags);

            switch (item.getItemId()) {
                case R.id.navigation_notes:

                    mTextMessage.setText(R.string.title_notes);
                    return true;

                case R.id.navigation_settings:

                    mTextMessage.setText(R.string.title_settings);
                    return true;

                case R.id.navigation_tags:

                    mTextMessage.setText(R.string.title_tags);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
