package com.example.successsynergyapp.dashboard.form.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.model.ModelForm;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AdapterSingleForm extends RecyclerView.Adapter<AdapterSingleForm.holder>{
    Context context;
    ArrayList<ModelForm> forms;

    public AdapterSingleForm(Context context, ArrayList<ModelForm> forms) {
        this.context = context;
        this.forms = forms;
    }

    @NonNull
    @NotNull
    @Override
    public holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new holder(LayoutInflater.from(context).inflate(R.layout.layout_single_form, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull holder holder, int position) {
        holder.tvStatus.setText(forms.get(position).getStatus());
        holder.tvTypeOfService.setText(forms.get(position).getType_of_service());
        holder.tvBudget.setText(forms.get(position).getBudget());
        holder.tvBulletPoint.setText(forms.get(position).getBullet_point());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Link to Activity for approving form and rating
            }
        });
    }

    @Override
    public int getItemCount() {
        return forms.size();
    }

    class holder extends RecyclerView.ViewHolder{
        TextView tvStatus, tvTypeOfService, tvBudget, tvBulletPoint;
        public holder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvStatus = itemView.findViewById(R.id.tv_status);
            tvTypeOfService = itemView.findViewById(R.id.tv_type_of_sevice);
            tvBudget = itemView.findViewById(R.id.tv_budget);
            tvBulletPoint = itemView.findViewById(R.id.tv_bullet_point);
        }
    }
}
