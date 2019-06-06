package com.example;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

public class ActivitySignIn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getActionBar();
        assert actionBar != null;
        actionBar.hide();
    }

    public void signInClicked(View view) {
        //Snackbar.make(view, R.string.sign_in, Snackbar.LENGTH_SHORT).show();
    }

    public void forgotPasswordClicked(View view) {


    }

    public void goToSignUpClicked(View view) {

    }
}
