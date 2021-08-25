package com.example.successsynergyapp.dashboard.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.successsynergyapp.R
import com.example.successsynergyapp.auth.EditProfileActivity
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemGeneral
import com.example.successsynergyapp.databinding.FragmentProfileBinding
import com.example.successsynergyapp.databinding.LayoutUserProfileBinding
import com.example.successsynergyapp.extensions.onClick
import com.example.successsynergyapp.model.ModelServiceProvider
import com.example.successsynergyapp.model.ModelUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var bindingUSer: LayoutUserProfileBinding
    lateinit var serviceProviderRef: DatabaseReference
    lateinit var uid: String
    lateinit var category: String
    lateinit var forWhat: String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        forWhat = requireArguments().getString("for").toString()
        if (forWhat.equals("ServiceProvider")){
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
            val sharedPrefs = activity?.getSharedPreferences("SuccessSynergy", Context.MODE_PRIVATE)
            uid = sharedPrefs!!.getString("userId", "").toString()
            category = sharedPrefs!!.getString("category", "").toString()
            serviceProviderRef = Firebase.database.getReference("ServiceProvider").child(category)
            fetchUserDetails()
            initOnClickListeners()
            return binding.root
        }
        else{
            bindingUSer = DataBindingUtil.inflate(inflater, R.layout.layout_user_profile, container, false)
            val sharedPrefs = activity?.getSharedPreferences("SuccessSynergy", Context.MODE_PRIVATE)
            uid = sharedPrefs!!.getString("userId", "").toString()
            fetchRealUserDetails()
            bindingUSer.tvSave.onClick {
                var i = Intent(activity, EditProfileActivity::class.java)
                i.putExtra("for", forWhat)
                i.putExtra("forReg", false)
                startActivity(i)
            }
            bindingUSer.tvEditCoverPhoto.onClick {
                var i = Intent(activity, EditProfileActivity::class.java)
                i.putExtra("for", forWhat)
                i.putExtra("forReg", false)
                startActivity(i)
            }
            return bindingUSer.root
        }
    }

    private fun fetchUserDetails() {
        val postListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children){
                    if (data.key == uid){
                        var user: ModelServiceProvider? = data!!.getValue<ModelServiceProvider>()
                        binding.tvName.text = user!!.fullname.toString()
                        binding.tvEmail.text = user!!.email.toString()
                        binding.casesHandled.text = user!!.num_cases_solved.toString()
                        binding.tvRating.text = user!!.rating.toString()
                        Glide.with(context!!).load(user!!.cor_profile).placeholder(resources.getDrawable(R.drawable.ic_outline_person_outline)).into(binding.ivProfile)
                    }
                }
            }
        }
        serviceProviderRef!!.addListenerForSingleValueEvent(postListener)
    }

    private fun fetchRealUserDetails(){
        val dbRef = Firebase.database.getReference("Users")
        val postListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children){
                    if (data.key == uid){
                        var user: ModelUser? = data!!.getValue<ModelUser>()
                        bindingUSer.tvUserName.text = user!!.first_name.toString()
                        bindingUSer.tvUserEmail.text = user!!.email.toString()
                        bindingUSer.address.text = user!!.address.toString()
                        bindingUSer.personalEmail.text = user!!.email.toString()
                        bindingUSer.phoneNumber.text = user!!.phone_number.toString()
                        Glide.with(context!!).load(user!!.profile_pic).placeholder(resources.getDrawable(R.drawable.ic_outline_person_outline)).into(bindingUSer.ivUserProfile)
                    }
                }
            }
        }
        dbRef.addListenerForSingleValueEvent(postListener)
    }

    private fun initOnClickListeners() {
        binding.tvEditProfile.onClick {
            var i = Intent(activity, EditProfileActivity::class.java)
            i.putExtra("for", forWhat)
            i.putExtra("forReg", false)
            startActivity(i)
        }
    }

}