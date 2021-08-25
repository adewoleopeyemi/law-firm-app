package com.example.successsynergyapp.dashboard.home;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemGeneral;
import com.example.successsynergyapp.databinding.FragmentIndividualAllBinding;
import com.example.successsynergyapp.model.ModelServiceProvider;

import java.util.ArrayList;

public class IndividualAllFragment extends Fragment {
    FragmentIndividualAllBinding binding;
    ArrayList<ModelServiceProvider> users;

    public IndividualAllFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_individual_all, container, false);
        users = (ArrayList<ModelServiceProvider>) getArguments().getSerializable("users");
        AdapterItemGeneral adapterItemGeneral = new AdapterItemGeneral(getContext(), users);
        binding.rvAll.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvAll.setAdapter(adapterItemGeneral);
        return binding.getRoot();
    }
}