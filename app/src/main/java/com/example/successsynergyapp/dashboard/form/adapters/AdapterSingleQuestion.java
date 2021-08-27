package com.example.successsynergyapp.dashboard.form.adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.model.ModelForm;
import com.example.successsynergyapp.model.SingleQuestionModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static android.view.View.GONE;

public class AdapterSingleQuestion extends RecyclerView.Adapter<AdapterSingleQuestion.holder> {
    ArrayList<SingleQuestionModel> questions;
    Context context;
    SingleQuestionModel curQuestionAns = new SingleQuestionModel();

    public AdapterSingleQuestion(ArrayList<SingleQuestionModel> questions, Context context) {
        this.questions = questions;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new holder(LayoutInflater.from(context).inflate(R.layout.layout_single_form_question, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.tv_question.setText(questions.get(position).getQuestion());
        curQuestionAns = questions.get(holder.getLayoutPosition());
        if (questions.get(holder.position).getRequiresTyping()){
            holder.btn_yes.setVisibility(GONE);
            holder.btn_no.setVisibility(GONE);
            holder.et_answer.setVisibility(View.VISIBLE);
            holder.et_answer.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    curQuestionAns.setAnswer(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
        else{
            holder.btn_no.setVisibility(View.VISIBLE);
            holder.btn_yes.setVisibility(View.VISIBLE);
            holder.et_answer.setVisibility(GONE);
            holder.btn_yes.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked){
                    curQuestionAns.setAnswer("Yes");
                }
                else{
                    curQuestionAns.setAnswer("No");
                }
            });

            holder.btn_no.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked){
                    curQuestionAns.setAnswer("Yes");
                }
                else{
                    curQuestionAns.setAnswer("No");
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull @NotNull holder holder) {
        super.onViewAttachedToWindow(holder);
    }

    public SingleQuestionModel getCurrentAnswer(){
        return curQuestionAns;
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class holder extends RecyclerView.ViewHolder{
        EditText et_answer;
        RadioButton btn_yes, btn_no;
        int position = 0;
        TextView tv_question;
        SingleQuestionModel questionModel;
        public holder(@NonNull View itemView) {
            super(itemView);
            et_answer = itemView.findViewById(R.id.et_answer);
            btn_yes = itemView.findViewById(R.id.btn_yes);
            btn_no = itemView.findViewById(R.id.btn_no);
            tv_question = itemView.findViewById(R.id.tvQuestion);
        }
    }

}
