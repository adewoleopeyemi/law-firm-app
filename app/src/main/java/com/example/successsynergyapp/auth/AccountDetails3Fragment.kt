package com.example.successsynergyapp.auth

import android.app.Activity.RESULT_OK
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.successsynergyapp.MainActivity
import com.example.successsynergyapp.R
import com.example.successsynergyapp.databinding.FragmentAccountDetails3Binding
import com.example.successsynergyapp.model.ModelServiceProvider
import com.example.successsynergyapp.model.ModelUser
import com.example.successsynergyapp.utils.theme3bottomnavigation.theme11utils.onClick
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class AccountDetails3Fragment : Fragment() {
    lateinit var binding: FragmentAccountDetails3Binding
    lateinit var serviceProvider: ModelServiceProvider
    lateinit var userModel: ModelUser
    lateinit var storageRef: StorageReference
    private lateinit var firebaseDatabase: FirebaseDatabase
    private var uri: Uri? = null
    lateinit var forWhat: String
    lateinit var pd: ProgressDialog

    fun setImgUri(img: Uri){
        uri = img
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account_details3, container, false)
        storageRef = FirebaseStorage.getInstance().getReference().child("Images")
        firebaseDatabase = FirebaseDatabase.getInstance()
        forWhat = requireArguments().getString("for").toString()
        pd = ProgressDialog(context)
        pd.setMessage("Editing profile...")
        pd.setCancelable(false)
        if (forWhat.equals("ServiceProvider")){
            serviceProvider = requireArguments().getSerializable("user") as ModelServiceProvider
            userModel = ModelUser()
            binding.registerBtn.onClick {
                validateData()
            }
        }
        else{
            userModel = requireArguments().getSerializable("user") as ModelUser
            serviceProvider = ModelServiceProvider()
            binding.registerBtn.onClick {
                validateDataForUSer()
            }
        }
        return binding.root
    }
    private fun validateDataForUSer(){
        if (!binding.checkboxAgree.isChecked){
            Toast.makeText(context, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show()
        }
        else{
            updateUserProfile()
        }
    }

    private fun validateData(){
        if (!binding.checkboxAgree.isChecked){
            Toast.makeText(context, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show()
        }
        else{
            updateUserProfile()
        }
    }

    private fun updateUserProfile() {
        uploadImage()
    }
    private fun uploadImage(){
        val sharedPrefs = activity?.getSharedPreferences("SuccessSynergy", Context.MODE_PRIVATE)
        var uid = sharedPrefs!!.getString("userId", "").toString()
        var category = sharedPrefs!!.getString("category", "").toString()
        val storageReference = storageRef.child(uid)
        if (forWhat.equals("ServiceProvider")){
            if(serviceProvider.cor_profile != null) {
                pd.show()
                //binding.progressBar.visibility = View.VISIBLE
                storageReference.putFile(uri!!).addOnSuccessListener {

                    val imageRef = FirebaseStorage.getInstance().getReference("Images").child(uid)
                    imageRef.downloadUrl.addOnSuccessListener {Uri->

                        val imageURL = Uri.toString()
                        serviceProvider.cor_profile = imageURL
                        serviceProvider.approved = false
                        firebaseDatabase.reference.child("ServiceProvider").child(category).child(uid).setValue(serviceProvider)
                                .addOnSuccessListener {
                                    pd.dismiss()
                                    val sharedPrefs = activity?.getSharedPreferences("SuccessSynergy", Context.MODE_PRIVATE)
                                    var i = Intent(context, MainActivity::class.java)
                                    var forWhat = sharedPrefs!!.getString("userType", "").toString()
                                    i.putExtra("for", forWhat)
                                    startActivity(i)
                                }
                                .addOnFailureListener {
                                    pd.dismiss()
                                    Toast.makeText(context, "Error updating profile", Toast.LENGTH_SHORT).show()
                                }
                    }

                }?.addOnCompleteListener {

                }.addOnFailureListener {
                    pd.dismiss()
                    Toast.makeText(context, "Error Updating profile", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(context,
                        "Please tap image to select image to upload",
                        Toast.LENGTH_SHORT).show()
            }
        }
        else{
            if(userModel.profile_pic != null) {
                pd.show()
                //binding.progressBar.visibility = View.VISIBLE
                storageReference.putFile(uri!!).addOnSuccessListener {

                    val imageRef = FirebaseStorage.getInstance().getReference("Images").child(uid)
                    imageRef.downloadUrl.addOnSuccessListener {Uri->

                        val imageURL = Uri.toString()
                        userModel.profile_pic = imageURL
                        firebaseDatabase.reference.child("Users").child(uid).setValue(userModel)
                                .addOnSuccessListener {
                                    val sharedPrefs = activity?.getSharedPreferences("SuccessSynergy", Context.MODE_PRIVATE)
                                    var i = Intent(context, MainActivity::class.java)
                                    var forWhat = sharedPrefs!!.getString("userType", "").toString()
                                    i.putExtra("for", forWhat)
                                    startActivity(i)
                                    pd.dismiss()
                                }
                                .addOnFailureListener {
                                    pd.dismiss()
                                    Toast.makeText(context, "error updating profile please try again", Toast.LENGTH_SHORT).show()
                                }
                    }

                }?.addOnCompleteListener {

                }.addOnFailureListener {
                    pd.dismiss()
                    Toast.makeText(context, "Error Updating profile", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(context,
                        "Please tap image to select image to upload",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }
}