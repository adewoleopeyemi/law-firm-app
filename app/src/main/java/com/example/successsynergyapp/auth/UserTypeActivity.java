package com.example.successsynergyapp.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.databinding.ActivityUserTypeBinding;

public class UserTypeActivity extends AppCompatActivity {
    ActivityUserTypeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_type);
        initViews(binding);
    }

    private void initViews(ActivityUserTypeBinding binding){
        binding.btnServiceProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserTypeActivity.this, LoginActivity.class);
                i.putExtra("for", "ServiceProvider");
                startActivity(i);
            }
        });
        binding.btnUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserTypeActivity.this, LoginActivity.class);
                i.putExtra("for", "User");
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}