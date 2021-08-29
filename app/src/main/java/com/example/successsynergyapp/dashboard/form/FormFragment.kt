package com.example.successsynergyapp.dashboard.form

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.successsynergyapp.R
import com.example.successsynergyapp.dashboard.form.adapters.AdapterSingleForm
import com.example.successsynergyapp.databinding.FragmentFormBinding
import com.example.successsynergyapp.extensions.onClick
import com.example.successsynergyapp.model.ModelForm
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class FormFragment : Fragment(), AdapterSingleForm.onAdapterClicked {
    lateinit var binding: FragmentFormBinding
    lateinit var firebaseRef: DatabaseReference
    var allForms = ArrayList<ModelForm>()
    lateinit var pd: ProgressDialog
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_form, container, false)
        firebaseRef = Firebase.database.reference.child("Forms")
        pd = ProgressDialog(activity)
        pd.setCancelable(false)
        pd.setMessage("Loading all your forms.....")
        pd.show()
        fetchAllForms()
        binding.fbNewForm.onClick {
            startActivity(Intent(requireActivity(), UserFormActivity::class.java))
            onDestroy()
        }
        return binding.root
    }

    private fun fetchAllForms() {
        val postListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                pd.dismiss()
                Toast.makeText(context, "Something went wrong please try again", Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                pd.dismiss()
                for (data in snapshot.children){
                    if (data.key.toString().equals(FirebaseAuth.getInstance().currentUser!!.uid)){
                        for (form in data.children){
                            var singleForm: ModelForm? = form!!.getValue<ModelForm>()
                            allForms.add(singleForm!!)
                        }
                    }
                }
                if (allForms.size == 0){
                    binding.rlNoForm.visibility = VISIBLE
                }
                else{
                    var adapter = AdapterSingleForm(context, allForms, this@FormFragment);
                    binding.rvAllForms.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.rvAllForms.adapter = adapter
                }
            }
        }
        firebaseRef.addListenerForSingleValueEvent(postListener)
    }

    fun hideFormDetail(){
        binding.formDetail.root.animate()
            .translationY(binding.formDetail.root.getHeight().toFloat())
            .alpha(1.0f)
            .setListener(null)
    }
    fun showFormDetail(){
        binding.formDetail.root.setVisibility(View.VISIBLE)

        binding.formDetail.root.animate()
            .translationY(0f)
            .alpha(1.0f)
            .setListener(null)
    }

    override fun onFormClicked(clicked: Boolean?, form: ModelForm?) {
        if (clicked!!){
            binding.formDetail.tvAnswerFirstName.text = form!!.first_name
            binding.formDetail.tvAnswerLastName.text = form!!.surname
            binding.formDetail.tvAnswerBudget.text = form!!.budget
            binding.formDetail.tvCategory.text = form!!.type_of_service
            binding.formDetail.tvAnswerStatus.text = form!!.status
            binding.formDetail.tvAnswerBulletPoint.text = form!!.bullet_point
            showFormDetail()
            binding.rlAll.onClick { hideFormDetail() }
        }
        else{
            hideFormDetail()
        }
    }
}