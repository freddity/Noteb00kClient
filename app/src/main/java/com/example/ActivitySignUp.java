package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

public class ActivitySignUp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void signUpClicked(View view) {
        Snackbar.make(view, R.string.sign_up, Snackbar.LENGTH_SHORT).show();
    }

    public void goToSignInClicked(View view) {
        Intent intent = new Intent(this, ActivitySignIn.class);
        finish();
    }
}
