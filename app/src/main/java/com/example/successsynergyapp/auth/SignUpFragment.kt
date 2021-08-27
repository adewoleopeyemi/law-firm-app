package com.example.successsynergyapp.auth

import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.successsynergyapp.MainActivity
import com.example.successsynergyapp.R
import com.example.successsynergyapp.databinding.FragmentSignUpBinding
import com.example.successsynergyapp.extensions.onClick
import com.example.successsynergyapp.model.ModelServiceProvider
import com.example.successsynergyapp.model.ModelUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class SignUpFragment : Fragment() {
    var TAG: String = "SignUpFragment"
    var forWhat: String? = null
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var binding: FragmentSignUpBinding
    var serviceProviderRef: DatabaseReference? = null
    var userRef: DatabaseReference? = null
    lateinit var genders:Array<String>
    var pd: ProgressDialog? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        firebaseAuth = FirebaseAuth.getInstance()
        forWhat = arguments?.getString("for")
        pd = ProgressDialog(context)
        pd?.setMessage("Registering User...")
        pd?.setCancelable(false)
        userRef = Firebase.database.getReference("Users")
        genders = arrayOf("Male", "Female")
        binding.spinnerGender.adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item,  genders) }
        serviceProviderRef = Firebase.database.getReference("ServiceProvider")
        if (forWhat.equals("ServiceProvider")){
            val value = arrayOf("Criminal Law", "Civil Law", "Human Rights", "Maritime", "Corporate Affairs",
                    "International and Cross Border Legal", "Debt  Recoveries", "Litigation Services", "Offshore Legal Representation",
            "Real Estate Solutions", "Title Documents Registration", "Cross Border Real Estate Services", "Purchase of land for Nigerians in the Diasporas",
            "Company Secretarial Services", "Maritime and International Trade Laws", "Legal drafting and contract documentations", "Family Law",
            "Matrimonial Courses and Child Right Laws", "Human Rights matter", "Intellectual Property Law", "Legal Opinions on all areas of law",
            "pro bono services", "Entertainment law", "Sports law")
            binding.spinnerServiceProvider.visibility = View.VISIBLE
            binding.spinnerServiceProvider.adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item,  value) }
        }
        initViews(binding)
        return binding.root
    }

    private fun initViews(binding: FragmentSignUpBinding?) {
        binding!!.btnSignup.onClick {
            if (!(binding.etPassword.text.toString().equals(binding.btnConfirmPassword.text.toString()))){
                Toast.makeText(requireContext(), "Passwords don't match", Toast.LENGTH_SHORT).show()
            }
            else if(binding.email.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Please type an email", Toast.LENGTH_SHORT).show()
            }
            else if (binding.etFullName.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Please enter your full name", Toast.LENGTH_SHORT).show()
            }
            else if (binding.etPassword.text.length < 8){
                Toast.makeText(requireContext(), "Password too short", Toast.LENGTH_SHORT).show()
            }
            else{
                pd?.show()
                initFirebaseLogin()
            }
        }
    }

    private fun initFirebaseLogin() {
        if (forWhat.toString().equals("ServiceProvider")){
            var user = ModelServiceProvider()
            firebaseAuth.createUserWithEmailAndPassword(binding.email.text.toString(), binding.etPassword.text.toString())
                    .addOnCompleteListener(requireActivity()){
                        if (it.isSuccessful) {
                            var i = Intent(activity, EditProfileActivity::class.java)
                            i.putExtra("uid", firebaseAuth.currentUser!!.uid)
                            pd?.dismiss()
                            val prefs = activity?.getSharedPreferences("SuccessSynergy", Context.MODE_PRIVATE)
                            with (prefs!!.edit()){
                                putBoolean("HasLogggedIn", true)
                                putString("userType", forWhat!!)
                                putString("userId", firebaseAuth.currentUser!!.uid)
                                putString("category", binding.spinnerServiceProvider.selectedItem.toString())
                                putString("email", binding.email.text.toString())
                                putString("gender", binding.spinnerGender.selectedItem.toString())
                                apply()
                            }
                            i.putExtra("email", binding.email.text.toString())
                            i.putExtra("category", binding.spinnerServiceProvider.selectedItem.toString())
                            i.putExtra("gender", binding.spinnerGender.selectedItem.toString())
                            i.putExtra("full_name", binding.etFullName.text.toString())
                            i.putExtra("forReg", true)
                            i.putExtra("for", forWhat)
                            startActivity(i)
                            /*val firebaseId = firebaseAuth.uid
                            user.uid = firebaseId
                            user.email = binding.email.text.toString()
                            user.fullname = binding.etFullName.text.toString()
                            user.chamber = ""
                            user.years_of_exp = 0
                            user.rating = 0.0f
                            user.cor_profile = ""
                            user.state_justification = ""
                            user.phone_number = ""
                            user.category = binding.spinnerServiceProvider.selectedItem.toString()
                            user.roll_call_number = ""
                            user.description = ""
                            user.gender = ""
                            user.dob = ""
                            user.state = ""
                            user.address = ""
                            user.approved = false
                            user.num_cases_solved = 0
                            firebaseAuth.uid?.let { serviceProviderRef?.child(binding.spinnerServiceProvider.selectedItem.toString())!!.child(it).setValue(user).addOnSuccessListener {
                                activity?.startActivity(Intent(context, MainActivity::class.java))
                            }}*/
                        }
                        else {
                            if (it.exception != null) {
                            } else {
                                pd?.dismiss()
                                Toast.makeText(requireContext(), "Could not register user",
                                        Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
        }
        else{
            var user = ModelUser()
            firebaseAuth.createUserWithEmailAndPassword(binding.email.text.toString(), binding.etPassword.text.toString())
                    .addOnCompleteListener(requireActivity()){
                        if (it.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val firebaseId = firebaseAuth.currentUser!!.uid
                            user.uid = firebaseId
                            user.email = binding.email.text.toString()
                            user.profile_pic = ""
                            user.first_name = binding.etFullName.text.toString()
                            user.dob = ""
                            user.gender = ""
                            firebaseAuth.uid?.let { userRef?.child(it)!!.setValue(user).addOnSuccessListener {
                                var i = Intent(activity, EditProfileActivity::class.java)
                                i.putExtra("uid", firebaseAuth.currentUser!!.uid)
                                pd?.dismiss()
                                val prefs = activity?.getSharedPreferences("SuccessSynergy", Context.MODE_PRIVATE)
                                with (prefs!!.edit()){
                                    putBoolean("HasLogggedIn", true)
                                    putString("userType", forWhat!!)
                                    putString("userId", firebaseAuth.currentUser!!.uid)
                                    putString("category", "")
                                    putString("email", binding.email.text.toString())
                                    putString("gender", binding.spinnerGender.selectedItem.toString())
                                    apply()
                                }
                                i.putExtra("email", binding.email.text.toString())
                                i.putExtra("category", "")
                                i.putExtra("gender", binding.spinnerGender.selectedItem.toString())
                                i.putExtra("full_name", binding.etFullName.text.toString())
                                i.putExtra("forReg", true)
                                i.putExtra("for", forWhat)
                                startActivity(i)
                            }}
                        }
                        else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", it.exception)
                            if (it.exception != null) {
                            } else {
                                Toast.makeText(requireContext(), "Could not log you in",
                                        Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
        }
    }
}