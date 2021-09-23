package com.example.successsynergyapp.dashboard.notification;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.dashboard.notification.adapters.AdapterNotification;
import com.example.successsynergyapp.databinding.FragmentNotificationBinding;
import com.example.successsynergyapp.model.ModelForm;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class NotificationFragment extends Fragment {
    ArrayList<ModelForm> forms = new ArrayList<>();
    FragmentNotificationBinding binding;
    ProgressDialog pd;
    public NotificationFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false);
        pd = new ProgressDialog(getContext());
        pd.setMessage("Loading notifications...");
        pd.setCancelable(false);
        pd.show();
        fetchNotificationsFromFirebase();
        return binding.getRoot();
    }
    private void fetchNotificationsFromFirebase(){
        FirebaseDatabase.getInstance().getReference()
                .child("Notifications")
                .child("ServiceProvider")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        for (DataSnapshot ds: snapshot.getChildren()){
                            Log.d("Testing", "XXXonDataChange: "+ds.getValue(ModelForm.class));
                            forms.add(ds.getValue(ModelForm.class));
                        }
                        initRv();
                        pd.dismiss();
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
    }

    private void initRv() {
        Collections.reverse(forms);
        AdapterNotification adapter = new AdapterNotification(getContext(), forms);
        binding.notificationsRv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.notificationsRv.setAdapter(adapter);
    }
}