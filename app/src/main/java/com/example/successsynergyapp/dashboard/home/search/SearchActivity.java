package com.example.successsynergyapp.dashboard.home.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.successsynergyapp.MainActivity;
import com.example.successsynergyapp.R;
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterSearch;
import com.example.successsynergyapp.databinding.LayoutSearchBinding;
import com.example.successsynergyapp.model.ModelServiceProvider;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    LayoutSearchBinding binding;
    ArrayList<ModelServiceProvider> popularUsers = new ArrayList<>();
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_search);
        prefs = getSharedPreferences("success", Context.MODE_PRIVATE);
        getSupportActionBar().hide();
        popularUsers = (ArrayList<ModelServiceProvider>) getIntent().getSerializableExtra("popularUsers");
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        String lastSearch = prefs.getString("search", "");
        binding.tvLastSearchName.setText(lastSearch);
        binding.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId==KeyEvent.KEYCODE_ENTER){
                    if (!binding.etSearch.getText().toString().isEmpty()){
                        //start Activity

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("search", binding.etSearch.getText().toString());
                        editor.commit();
                        Intent i = new Intent(SearchActivity.this, MainActivity.class);
                        i.putExtra("search", binding.etSearch.getText().toString());
                        //i.putExtra("for", for)
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(SearchActivity.this, "Please Search for a name", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });

        binding.tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.etSearch.getText().toString().isEmpty()){
                    //start Activity
                    Intent i = new Intent(SearchActivity.this, MainActivity.class);
                    i.putExtra("search", binding.etSearch.getText().toString());
                    startActivity(i);
                }
                else{
                    Toast.makeText(SearchActivity.this, "Please Search for a name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        AdapterSearch adapterSearch = new AdapterSearch(getApplicationContext(), popularUsers);
        binding.rvPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.rvPopular.setAdapter(adapterSearch);
    }
}