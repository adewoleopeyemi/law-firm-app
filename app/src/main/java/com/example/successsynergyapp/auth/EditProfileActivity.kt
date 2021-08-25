package com.example.successsynergyapp.auth

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.successsynergyapp.R
import com.example.successsynergyapp.databinding.ActivityEditProfileBinding
import com.example.successsynergyapp.extensions.addFragment
import com.example.successsynergyapp.extensions.replaceFragment
import com.example.successsynergyapp.model.ModelServiceProvider
import com.example.successsynergyapp.model.ModelUser
import com.example.successsynergyapp.utils.theme3bottomnavigation.theme11utils.color
import com.example.successsynergyapp.utils.theme3bottomnavigation.theme11utils.onClick
import com.example.successsynergyapp.utils.theme3bottomnavigation.theme11utils.setStrokedBackground
import kotlinx.android.synthetic.main.activity_edit_profile.
*
class EditProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditProfileBinding
    lateinit var serviceProviderModel: ModelServiceProvider
    lateinit var userModel: ModelUser
    var email :String? = null
    var category :String? = null
    var gender :String? = null
    var uid :String? = null
    var fullName :String? = null
    var forReg = true
    lateinit var forWhat: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile)
        supportActionBar?.hide()
        val sharedPrefs = getSharedPreferences("SuccessSynergy", Context.MODE_PRIVATE)
        forReg = intent.extras!!.getBoolean("forReg")
        forWhat = intent.extras!!.getString("for").toString()
        if (forReg){
            uid = intent.extras!!.getString("uid")
            email = intent.extras!!.getString("email")
            category = intent.extras!!.getString("category")
            gender = intent.extras!!.getString("gender")
            fullName = intent.extras!!.getString("full_name")
        }
        else{
            uid = sharedPrefs!!.getString("userId", "").toString()
            category = sharedPrefs!!.getString("category", "").toString()
            gender = sharedPrefs!!.getString("gender", "").toString()
            email = sharedPrefs!!.getString("email", "").toString()
            fullName = intent.extras!!.getString("full_name", "").toString()
        }
        if (forWhat.equals("ServiceProvider")){
            serviceProviderModel = ModelServiceProvider()
            serviceProviderModel.uid = uid
            serviceProviderModel.category = category
            serviceProviderModel.email = email
            serviceProviderModel.gender = gender
            serviceProviderModel.fullname = fullName
            binding.tvStep1.onClick {
                loadAccountDetailFragment()
            }
            binding.tvStep2.setOnClickListener {
                //loadSocialFragment()
            }
            binding.tvStep3.onClick {
                //loadTocFragment()
            }
            var accountDetails1: AccountDetailsFragment = AccountDetailsFragment()
            var bundle = Bundle()
            bundle.putSerializable("user", serviceProviderModel)
            bundle.putString("for", forWhat)
            accountDetails1.arguments = bundle
            addFragment(accountDetails1, R.id.container)
        }
        else{
            userModel = ModelUser()
            userModel.uid = uid
            userModel.email = email
            userModel.gender = gender
            userModel.first_name = fullName
            userModel.use_count = ""
            var accountDetails1: AccountDetailsFragment = AccountDetailsFragment()
            var bundle = Bundle()
            bundle.putSerializable("user", userModel)
            bundle.putString("for", forWhat)
            accountDetails1.arguments = bundle
            addFragment(accountDetails1, R.id.container)
        }
    }

    fun loadAccountDetailFragment() {
        binding.tvStep1.setStrokedBackground(color(R.color.theme11_colorPrimary))
        binding.tvStep2.apply {
            disable()
        }
        binding.tvStep3.apply {
            disable()
        }
        var accountDetails1: AccountDetailsFragment = AccountDetailsFragment()
        var bundle = Bundle()
        if (forWhat.equals("ServiceProvider")){
            bundle.putSerializable("user", serviceProviderModel)
            bundle.putString("for", forWhat)

        }
        else{
            bundle.putSerializable("user", userModel)
            bundle.putString("for", forWhat)
        }
        accountDetails1.arguments = bundle
        replaceFragment(accountDetails1, R.id.container)
    }

    fun loadSocialFragment(serviceProvider: ModelServiceProvider, user: ModelUser, forWhat: String) {
        binding.tvStep2.enable()
        binding.tvStep1.apply {
            enable()
        }
        binding.tvStep3.apply {
            disable()
        }
        var accountDetails1: AccountDetails2Fragment = AccountDetails2Fragment()
        var bundle = Bundle()
        if (forWhat.equals("ServiceProvider")){
            bundle.putSerializable("user", serviceProvider)
        }
        else{
            bundle.putSerializable("user", user)
        }
        bundle.putString("for", forWhat)
        accountDetails1.arguments = bundle
        replaceFragment(accountDetails1, R.id.container)
    }

    fun loadTocFragment(user: ModelUser, serviceProvider: ModelServiceProvider, img: Uri, forWhat: String) {
        binding.tvStep3.enable()
        binding.tvStep2.apply {
            enable()
        }
        var accountDetails1: AccountDetails3Fragment = AccountDetails3Fragment()
        var bundle = Bundle()
        if (forWhat.equals("ServiceProvider")){
            bundle.putSerializable("user", serviceProvider)
        }
        else{
            bundle.putSerializable("user", user)
        }
        bundle.putString("for", forWhat)
        accountDetails1.arguments = bundle
        accountDetails1.setImgUri(img)
        replaceFragment(accountDetails1, R.id.container)
    }

    fun TextView.enable() {
        setBackgroundResource(R.drawable.theme11_bg_ract_cornered)
        setTextColor(color(R.color.theme11_white))
    }

    fun TextView.disable() {
        //setStrokedBackground(color(R.color.theme11_white))
        setTextColor(color(R.color.t12_colorPrimary))
        setBackgroundResource(R.drawable.theme3_item_shadow)
    }
}