package com.example.successsynergyapp.dashboard.form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.auth.Theme6BaseActivity;
import com.example.successsynergyapp.databinding.ActivityViewFormBinding;
import com.example.successsynergyapp.model.ModelForm;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class ViewFormActivity extends Theme6BaseActivity {
    String id, bulletPoint;
    ModelForm form;
    ActivityViewFormBinding binding;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_form);
        bulletPoint = getIntent().getExtras().getString("bulletPoint");
        fetchDataFormFirebase();
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching data...");
        pd.setCancelable(false);
        pd.show();
    }

    private void fetchDataFormFirebase(){
        FirebaseDatabase.getInstance().getReference().child("Forms")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        for (DataSnapshot ds: snapshot.getChildren()){
                            ModelForm t = ds.getValue(ModelForm.class);
                            Log.d("ViewForm", "XXXonDataChange: "+t.getBullet_point());
                            if (t.getBullet_point().equals(bulletPoint)){
                                form = t;
                            }
                        }
                        initView();
                        pd.dismiss();
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
    }

    private void initView() {
        binding.status.setText(form.getStatus());
        binding.tvBudget.setText(form.getBudget());
        binding.tvLocation.setText(form.getLocation());
        binding.tvFirstName.setText(form.getFirst_name());
        binding.tvBulletPoint.setText(form.getBullet_point());
        binding.tvEmail.setText(form.getEmail_address());
        binding.tvTypeOfSevice.setText(form.getType_of_service());
        binding.tvFullLocation.setText(form.getLocation() + " "+form.getState() + " "+form.getStreet());
        binding.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acceptOffer();
            }
        });
        binding.btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rejectOffer();
            }
        });
    }

    private void acceptOffer() {

    }
    private void rejectOffer(){

    }
}