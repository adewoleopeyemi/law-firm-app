package com.example.successsynergyapp.dashboard.form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.model.ModelForm;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class ViewFormActivity extends AppCompatActivity {
    String id, bulletPoint;
    ModelForm form;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_form);
    }

    private void fetchDataFormFirebase(){
        FirebaseDatabase.getInstance().getReference().child("Forms")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        for (DataSnapshot ds: snapshot.getChildren()){
                            ModelForm t = ds.getValue(ModelForm.class);
                            if (t.getBullet_point().equals(bulletPoint)){
                                form = t;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
    }
}