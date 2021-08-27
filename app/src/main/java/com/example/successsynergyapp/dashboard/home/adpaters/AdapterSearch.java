package com.example.successsynergyapp.dashboard.home.adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.model.ModelServiceProvider;

import java.util.ArrayList;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.Holder> {
    Context context;
    ArrayList<ModelServiceProvider> users;


    public AdapterSearch(Context context, ArrayList<ModelServiceProvider> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_search, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(users.get(position).getFullname());
        holder.category.setText(users.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView name, category;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            category = itemView.findViewById(R.id.tv_category);
        }
    }
}
