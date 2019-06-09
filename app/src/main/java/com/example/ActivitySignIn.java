package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ActivitySignIn extends Activity {

    private EditText loginEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        loginEditText = findViewById(R.id.edittext_login_signin);
        passwordEditText = findViewById(R.id.edittext_pass_signin);
    }

    public void signInClicked(View view) {
        Snackbar.make(view, R.string.sign_in, Snackbar.LENGTH_SHORT).show();
        new SignInAsyncTask().execute();
    }

    private class SignInAsyncTask extends AsyncTask<Void, Void, Void> {

        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        @Override
        protected Void doInBackground(Void... voids) {

            if (!login.equals("") &&
                    !password.equals("")) {
                try {
                    Socket socket = new Socket("192.168.2.106", 8080);

                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                    ArrayList<Comparable> arrayList = new ArrayList<>();
                    arrayList.add(0, FirstQuery.SIGN_IN);
                    arrayList.add(1, login);
                    arrayList.add(2, password);
                    out.writeObject(arrayList);

                    Error error = (Error) in.readObject();

                    if (error == Error.DONE) {
                        Intent intent = new Intent(ActivitySignIn.this, ActivityMain.class);
                        //intent.putExtra();
                        startActivity(intent);
                        finish();
                    } else if (error == Error.ACCOUNT_DOES_NOT_EXIST) {

                    } else if (error == Error.LOGIN_OR_PASSWORD_INCORRECT) {

                    } else if (error == Error.ERROR) {

                    }

                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public void forgotPasswordClicked(View view) {
        Snackbar.make(view, R.string.forgot_password, Snackbar.LENGTH_SHORT).show();
    }

    public void goToSignUpClicked(View view) {
        Intent intent = new Intent(this, ActivitySignUp.class);
        startActivity(intent);
    }
}
