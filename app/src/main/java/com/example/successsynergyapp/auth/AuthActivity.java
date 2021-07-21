package com.example.successsynergyapp.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.successsynergyapp.R;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        getSupportActionBar().hide();

    }
}