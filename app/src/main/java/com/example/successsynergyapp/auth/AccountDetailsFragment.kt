package com.example.successsynergyapp.auth

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.successsynergyapp.R
import com.example.successsynergyapp.databinding.FragmentAccountDetailsBinding
import com.example.successsynergyapp.model.ModelServiceProvider
import com.example.successsynergyapp.model.ModelUser
import com.example.successsynergyapp.utils.theme3bottomnavigation.theme11utils.onClick

class AccountDetailsFragment : Fragment() {
    lateinit var binding: FragmentAccountDetailsBinding
    lateinit var serviceProviderModel: ModelServiceProvider
    lateinit var userModel: ModelUser
    lateinit var forWhat: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account_details, container,false)
        forWhat = requireArguments().getString("for").toString()
        if (forWhat.equals("ServiceProvider")){
            serviceProviderModel = requireArguments().getSerializable("user") as ModelServiceProvider
            userModel = ModelUser()
            binding.btnNext1.onClick {
                validateInputs(serviceProviderModel)
            }
        }
        else{
            binding.indicator.text = "User Details"
            binding.chamber.hint = "Enter Address"
            binding.yearsOfExperience.inputType = InputType.TYPE_CLASS_PHONE
            binding.yearsOfExperience.hint = "Enter Phone Number"
            binding.stateJustification.visibility = GONE
            binding.rollCallNumber.visibility = GONE
            binding.address.visibility = GONE
            userModel = requireArguments().getSerializable("user") as ModelUser
            serviceProviderModel = ModelServiceProvider()
            binding.btnNext1.onClick {
                validateInputsForUser(userModel)
            }
        }

        return binding.root
    }

    private fun setUserDetails() {
        serviceProviderModel.chamber = binding.chamber.text.toString()
        serviceProviderModel.roll_call_number = binding.rollCallNumber.text.toString()
        serviceProviderModel.state_justification = binding.stateJustification.text.toString()
        serviceProviderModel.years_of_exp = binding.yearsOfExperience.text.toString().toInt()
        serviceProviderModel.address = binding.address.text.toString()
    }
    private fun setUserDetailsForUSer() {
        userModel.phone_number = binding.yearsOfExperience.text.toString()
        userModel.address = binding.chamber.text.toString()
    }

    private fun validateInputs(user: ModelServiceProvider){
        if (binding.chamber.text.isEmpty()){
            Toast.makeText(context, "PLease fill in your chamber", Toast.LENGTH_SHORT).show()
        }
        else if (binding.rollCallNumber.text.isEmpty()){
            Toast.makeText(context, "PLease fill in your roll call number", Toast.LENGTH_SHORT).show()
        }
        else if (binding.stateJustification.text.isEmpty()){
            Toast.makeText(context, "PLease fill in your state justification", Toast.LENGTH_SHORT).show()
        }
        else if (binding.yearsOfExperience.text.isEmpty()){
            Toast.makeText(context, "PLease fill in your years of experience", Toast.LENGTH_SHORT).show()
        }
        else if (binding.address.text.isEmpty()){
            Toast.makeText(context, "PLease fill in your address", Toast.LENGTH_SHORT).show()
        }
        else{
            setUserDetails()
            (activity as EditProfileActivity).loadSocialFragment(user, userModel, forWhat)
        }
    }
    private fun validateInputsForUser(user: ModelUser){
        if (binding.chamber.text.isEmpty()){
            Toast.makeText(context, "PLease fill in your chamber", Toast.LENGTH_SHORT).show()
        }
        else if (binding.yearsOfExperience.text.isEmpty()){
            Toast.makeText(context, "PLease fill in your years of experience", Toast.LENGTH_SHORT).show()
        }
        else{
            setUserDetailsForUSer()
            (activity as EditProfileActivity).loadSocialFragment(serviceProviderModel, user, forWhat)
        }
    }
}