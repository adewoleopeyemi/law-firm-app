package com.example.successsynergyapp.dashboard.home.adpaters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.successsynergyapp.dashboard.home.IndividualAllFragment;
import com.example.successsynergyapp.model.ModelServiceProvider;

import java.util.ArrayList;

public class AllTabLayoutAdapter extends FragmentPagerAdapter {
    Context mContext;
    ArrayList<ArrayList<ModelServiceProvider>> user;
    ArrayList<String> names;

    public AllTabLayoutAdapter(Context context, ArrayList<String> names, ArrayList<ArrayList<ModelServiceProvider>> user, @NonNull FragmentManager fm) {
        super(fm);
        mContext = context;
        this.user = user;
        this.names = names;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("users", user.get(position));
        IndividualAllFragment frag = new IndividualAllFragment();
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return names.get(position);
    }
}
