package com.example;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.inflate;
import static java.security.AccessController.getContext;

public class ActivityMain extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    final Fragment fragmentNotes = new FragmentNote();
    final Fragment fragmentSettings = new FragmentSettings();
    final Fragment fragmentTags = new FragmentTags();
    final FragmentManager fm = getSupportFragmentManager();
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
        LinearLayout linearLayout = findViewById(R.id.notes_container);

        View view2 = getLayoutInflater().inflate(R.layout.note, null);
        linearLayout.addView(view2);

        RelativeLayout titleRelative = findViewById(R.id.note_title);
        TextView titleTextView = new TextView(getApplicationContext());
        titleTextView.setText("Title of your Note");
        titleRelative.addView(titleTextView);

        RelativeLayout contentRelative = findViewById(R.id.note_content);
        TextView contentTextView = new TextView(getApplicationContext());
        contentRelative.addView(contentTextView);
        contentTextView.setText("Content of your Note");
    }
}
