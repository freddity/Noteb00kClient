package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;

public class ActivityMain extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentNote fragmentNotes = new FragmentNote();
    private FragmentSettings fragmentSettings = new FragmentSettings();
    private FragmentTags fragmentTags = new FragmentTags();
    private FragmentManager fm = getSupportFragmentManager();
    private Fragment active = fragmentNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm.beginTransaction().add(R.id.main_container, fragmentSettings).hide(fragmentSettings).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentTags).hide(fragmentTags).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentNotes).commit();

        BottomNavigationView bottomNav = findViewById(R.id.nav_view);

        bottomNav.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_notes:

                fm.beginTransaction().hide(active).show(fragmentNotes).commit();
                active = fragmentNotes;
                return true;

            case R.id.navigation_settings:

                fm.beginTransaction().hide(active).show(fragmentSettings).commit();
                active = fragmentSettings;
                return true;

            case R.id.navigation_tags:

                fm.beginTransaction().hide(active).show(fragmentTags).commit();
                active = fragmentTags;
                return true;
        }
        return false;
    }

    public void fabClicked(View view) {
        new DialogNoteCreator(fragmentNotes).show(getSupportFragmentManager(), "note creator dialog");
    }
}
