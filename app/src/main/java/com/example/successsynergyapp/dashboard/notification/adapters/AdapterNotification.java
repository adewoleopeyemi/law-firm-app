package com.example.successsynergyapp.dashboard.notification.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.dashboard.form.ViewFormActivity;
import com.example.successsynergyapp.model.ModelForm;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.holder>{
    Context context;
    ArrayList<ModelForm> forms;

    public AdapterNotification(Context context, ArrayList<ModelForm> forms) {
        this.context = context;
        this.forms = forms;
    }

    @NonNull
    @NotNull
    @Override
    public holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new holder(LayoutInflater.from(context).inflate(R.layout.item_notification, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull holder holder, int position) {
        holder.budget.setText(forms.get(position).getBudget());
        holder.email.setText(forms.get(position).getEmail_address());
        holder.name.setText(forms.get(position).getFirst_name());
        holder.phone_number.setText(forms.get(position).getPhone_number());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationIntent = new Intent(context, ViewFormActivity.class);
                notificationIntent.putExtra("for", "ServiceProvider");
                notificationIntent.putExtra("id", forms.get(position).getUid());
                notificationIntent.putExtra("bulletPoint", forms.get(position).getBullet_point());
                context.startActivity(notificationIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return forms.size();
    }

    class holder extends RecyclerView.ViewHolder{
        TextView name, email, phone_number, budget;
        public holder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            email = itemView.findViewById(R.id.tv_email);
            phone_number = itemView.findViewById(R.id.tv_phone_number);
            budget = itemView.findViewById(R.id.tv_budget);
        }
    }
}
