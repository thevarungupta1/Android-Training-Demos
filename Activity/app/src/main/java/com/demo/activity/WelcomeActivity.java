package com.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class WelcomeActivity extends AppCompatActivity {

    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView usernameTextView = (TextView) findViewById(R.id.usernameTextView);
        TextView passwordTextView = (TextView) findViewById(R.id.passwordTextView);

        Bundle bundle = getIntent().getExtras();

        String username = bundle.getString(KEY_USERNAME);
        String password = bundle.getString(KEY_PASSWORD);

        usernameTextView.setText(username);
        passwordTextView.setText(password);
    }
}
