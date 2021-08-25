package com.example.successsynergyapp.dashboard.home.adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.successsynergyapp.R;
import com.example.successsynergyapp.model.ModelServiceProvider;

import java.util.ArrayList;

public class AdapterItemGeneral extends RecyclerView.Adapter<AdapterItemGeneral.Holder>{
    Context context;
    ArrayList<ModelServiceProvider> users;

    public AdapterItemGeneral(Context context, ArrayList<ModelServiceProvider> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public AdapterItemGeneral.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_general, parent, false);
        return new AdapterItemGeneral.Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItemGeneral.Holder holder, int position) {
        holder.name.setText(users.get(position).getFullname());
        holder.category.setText(users.get(position).getCategory());
        holder.rating.setRating(users.get(position).getRating());
        holder.location.setText(users.get(position).getState());
        Glide.with(context).load(users.get(position).getCor_profile()).placeholder(R.drawable.test_law_profile).into(holder.profile);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView name, category, location;
        ImageView profile;
        RatingBar rating;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            category = itemView.findViewById(R.id.tv_category);
            rating = itemView.findViewById(R.id.ratings);
            profile = itemView.findViewById(R.id.iv_profile);
            location = itemView.findViewById(R.id.tv_location);
        }
    }
}
