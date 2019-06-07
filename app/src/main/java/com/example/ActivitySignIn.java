package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

public class ActivitySignIn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void signInClicked(View view) {
        Snackbar.make(view, R.string.sign_in, Snackbar.LENGTH_SHORT).show();
    }

    public void forgotPasswordClicked(View view) {
        Snackbar.make(view, R.string.forgot_password, Snackbar.LENGTH_SHORT).show();
    }

    public void goToSignUpClicked(View view) {
        Intent intent = new Intent(this, ActivitySignUp.class);
        startActivity(intent);
    }
}
