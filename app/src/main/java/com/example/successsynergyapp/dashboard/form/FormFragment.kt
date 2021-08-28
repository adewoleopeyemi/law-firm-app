package com.example.successsynergyapp.dashboard.form

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
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

class FormFragment : Fragment() {
    lateinit var binding: FragmentFormBinding
    lateinit var firebaseRef: DatabaseReference
    var allForms = ArrayList<ModelForm>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_form, container, false)
        firebaseRef = Firebase.database.reference.child("Forms")
        fetchAllForms()
        binding.fbNewForm.onClick {
            startActivity(Intent(requireActivity(), UserFormActivity::class.java))
        }
        return binding.root
    }

    private fun fetchAllForms() {
        val postListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children){
                    if (data.key.toString().equals(FirebaseAuth.getInstance().currentUser!!.uid)){
                        for (form in data.children){
                            var singleForm: ModelForm? = form!!.getValue<ModelForm>()
                            allForms.add(singleForm!!)
                        }
                    }
                }
                var adapter = AdapterSingleForm(context, allForms);
                binding.rvAllForms.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvAllForms.adapter = adapter
            }
        }
        firebaseRef.addListenerForSingleValueEvent(postListener)
    }
}