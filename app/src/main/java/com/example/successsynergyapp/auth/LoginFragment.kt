package com.example.successsynergyapp.auth

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.successsynergyapp.MainActivity
import com.example.successsynergyapp.R
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemGeneral
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemPopular
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemTopRated
import com.example.successsynergyapp.databinding.FragmentLoginBinding
import com.example.successsynergyapp.extensions.onClick
import com.example.successsynergyapp.model.ModelServiceProvider
import com.example.successsynergyapp.model.ModelUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var firebaseAuth: FirebaseAuth
    var serviceProviderRef: DatabaseReference? = null
    var userRef: DatabaseReference? = null
    var forWhat: String? = null
    var category: String? = null
    var pd: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        forWhat = arguments?.getString("for")
        firebaseAuth = FirebaseAuth.getInstance()
        serviceProviderRef = Firebase.database.getReference("ServiceProvider")
        userRef = Firebase.database.getReference("Users")
        pd = ProgressDialog(context)
        pd?.setMessage("Logging in")
        pd?.setCancelable(false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.btnLogin.onClick {
            if (binding.etPassword.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Passwords is too empty", Toast.LENGTH_SHORT).show()
            }
            else if(binding.email.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Please type an email", Toast.LENGTH_SHORT).show()
            }
            else{
                pd?.show()
                initFirebaseLogin()
            }
        }
    }

    private fun initFirebaseLogin() {
        var booleanUserFound = false
        if (forWhat.equals("ServiceProvider")){
            val postListener = object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    pd!!.dismiss()
                    Toast.makeText(context, ""+error.message, Toast.LENGTH_SHORT).show()
                }


                override fun onDataChange(snapshot: DataSnapshot) {
                    for (data in snapshot.children){
                        for (cat in data.children){
                            var user: ModelServiceProvider? = cat!!.getValue<ModelServiceProvider>()
                            if (user!!.email == binding.email.text.toString()){
                                booleanUserFound = true;
                                firebaseAuth.signInWithEmailAndPassword(binding.email.text.toString(),
                                        binding.etPassword.text.toString())
                                        .addOnCompleteListener(requireActivity()) { task ->
                                            if(task.isSuccessful){
                                                fetchUserCategory(firebaseAuth.currentUser!!.uid.toString())
                                                pd?.dismiss()
                                                var i = Intent(context, MainActivity::class.java)
                                                i.putExtra("for", "ServiceProvider")
                                                activity?.startActivity(i)
                                            }
                                            else{
                                                pd?.dismiss()
                                                Toast.makeText(context, "Couldn't login", Toast.LENGTH_SHORT).show()
                                            }
                                        }
                            }
                        }
                    }
                    if (!booleanUserFound){
                        pd!!.dismiss()
                        Toast.makeText(context, "Email not registered as a service provider", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            serviceProviderRef!!.addListenerForSingleValueEvent(postListener)
        }
        else{
            val postListener = object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    for (data in snapshot.children){
                        var user: ModelUser? = data!!.getValue<ModelUser>()
                        if (user!!.email == binding.email.text.toString()){
                            booleanUserFound = true
                            firebaseAuth.signInWithEmailAndPassword(binding.email.text.toString(),
                                    binding.etPassword.text.toString())
                                    .addOnCompleteListener(requireActivity()) { task ->
                                        if(task.isSuccessful){
                                            val prefs = activity?.getSharedPreferences("SuccessSynergy", Context.MODE_PRIVATE)
                                            with (prefs!!.edit()){
                                                putBoolean("HasLogggedIn", true)
                                                putString("userType", forWhat!!)
                                                putString("userId", firebaseAuth.uid.toString())
                                                putString("category", "")
                                                putString("email", binding.email.text.toString())
                                                putString("gender", user!!.gender)
                                                putString("full_name", user!!.first_name)
                                                apply()
                                            }
                                            //fetchUserCategory(firebaseAuth.currentUser!!.uid.toString())
                                            pd?.dismiss()
                                            var i = Intent(context, MainActivity::class.java)
                                            i.putExtra("for", "User")
                                            activity?.startActivity(i)
                                        }
                                        else{
                                            pd?.dismiss()
                                            Toast.makeText(context, "Couldn't login", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                        }
                    }
                    if (!booleanUserFound){
                        pd!!.dismiss()
                        Toast.makeText(context, "Email not registered as a user", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            userRef!!.addListenerForSingleValueEvent(postListener)
        }
    }

    private fun fetchUserCategory(uid: String) {
        val postListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children){
                    for (user in data.children){
                        if (user.key!!.toString().equals(uid))
                        {
                            Toast.makeText(context, "reached", Toast.LENGTH_SHORT).show()
                            var user: ModelServiceProvider? = user!!.getValue<ModelServiceProvider>()
                            if (forWhat!!.equals("ServiceProvider")){
                                category = data.key
                            }
                            else{
                                category = ""
                            }
                            val prefs = activity?.getSharedPreferences("SuccessSynergy", Context.MODE_PRIVATE)
                            with (prefs!!.edit()){
                                putBoolean("HasLogggedIn", true)
                                putString("userType", forWhat!!)
                                putString("userId", firebaseAuth.uid.toString())
                                putString("category", category)
                                putString("email", binding.email.text.toString())
                                putString("gender", user!!.gender)
                                putString("full_name", user!!.fullname)
                                apply()
                            }
                        }
                    }
                }
            }
        }
        serviceProviderRef!!.addListenerForSingleValueEvent(postListener)
    }
}