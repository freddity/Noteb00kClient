package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ActivitySplash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, ActivitySignIn.class);
        startActivity(intent);
        finish();
    }
}
