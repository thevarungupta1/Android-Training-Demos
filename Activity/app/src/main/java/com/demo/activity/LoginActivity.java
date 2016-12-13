package com.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button resetButton = (Button) findViewById(R.id.resetButton);

        loginButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences("login_info", Context.MODE_PRIVATE);

        if (sharedPreferences.contains(KEY_USERNAME)) {
            usernameEditText.setText(sharedPreferences.getString(KEY_USERNAME, ""));
        }

        if (sharedPreferences.contains(KEY_PASSWORD)) {
            passwordEditText.setText(sharedPreferences.getString(KEY_PASSWORD, ""));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                showWelcomeScreen();
                break;
            case R.id.resetButton:
                resetContents();
                break;
        }
    }

    private void showWelcomeScreen() {

        Intent intent = new Intent(this, WelcomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(KEY_USERNAME, usernameEditText.getText().toString());
        bundle.putString(KEY_PASSWORD, passwordEditText.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void resetContents() {
        usernameEditText.setText("");
        passwordEditText.setText("");
        usernameEditText.requestFocus();
    }
}
