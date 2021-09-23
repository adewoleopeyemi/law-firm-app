package com.example.successsynergyapp

import android.os.Bundle
import android.os.Handler
import android.text.Html
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.successsynergyapp.auth.Theme6BaseActivity
import com.example.successsynergyapp.dashboard.form.FormFragment
import com.example.successsynergyapp.dashboard.home.HomeFragment
import com.example.successsynergyapp.dashboard.profile.ProfileFragment
import com.example.successsynergyapp.databinding.ActivityMainBinding
import com.example.successsynergyapp.extensions.addFragment
import com.example.successsynergyapp.extensions.replaceFragment
import com.example.successsynergyapp.notification.Token
import com.example.successsynergyapp.utils.theme3bottomnavigation.BottomNavigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.theme3_toolbar.*


class MainActivity : Theme6BaseActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var homeFragment: HomeFragment
    lateinit var profileFragment: ProfileFragment
    var search: String? = null
    lateinit var forWhat: String
    companion object {
        private const val ID_HOME = 1
        private const val ID_MESSAGE = 3
        private const val ID_NOTIFICATION = 4
        private const val ID_ACCOUNT = 5
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        homeFragment = HomeFragment()
        profileFragment = ProfileFragment()
        try{
            search = intent.extras!!.getString("search").toString()
        }
        catch (e: Exception){
            search = null
        }
        forWhat = intent.extras!!.getString("for").toString()
        var bundle = Bundle()
        bundle.putString("search", search)
        homeFragment.arguments = bundle
        addFragment(homeFragment, R.id.frameLayout)
        //setToolbar(toolbar)
        title=getString(R.string.theme3_lbl_bottom_naivgation)


        binding.bottomNavigation.add(BottomNavigation.Model(ID_HOME, R.drawable.theme3_ic_home))
        binding.bottomNavigation.add(BottomNavigation.Model(ID_ACCOUNT, R.drawable.theme3_ic_account))
        if (forWhat.equals("ServiceProvider")){
            UpdateToken(true)
            binding.bottomNavigation.add(BottomNavigation.Model(ID_MESSAGE, R.drawable.theme3_ic_notification))
        }
        else{
            UpdateToken(false)
            binding.bottomNavigation.add(BottomNavigation.Model(ID_MESSAGE, R.drawable.theme3_ic_message))
        }

        binding.bottomNavigation.setCount(ID_NOTIFICATION, "12")

        binding.bottomNavigation.setOnShowListener {
            val name = when (it.id) {
                ID_HOME -> "HOME"
                ID_MESSAGE -> "MESSAGE"
                ID_NOTIFICATION -> "NOTIFICATION"
                ID_ACCOUNT -> "ACCOUNT"
                else -> ""
            }
        }

        binding.bottomNavigation.setOnClickMenuListener {
            if (it.id == ID_HOME){
                replaceFragment(homeFragment, R.id.frameLayout)

            }
            else if (it.id == ID_ACCOUNT){
                var bundle = Bundle()
                bundle.putString("for", forWhat)
                profileFragment.arguments = bundle
                replaceFragment(profileFragment, R.id.frameLayout)
            }
            else if (it.id == ID_MESSAGE){
                replaceFragment(FormFragment(), R.id.frameLayout)
            }
            val name = when (it.id) {
                ID_HOME -> "HOME"
                ID_MESSAGE -> "MESSAGE"
                ID_NOTIFICATION -> "NOTIFICATION"
                ID_ACCOUNT -> "ACCOUNT"
                else -> ""
            }
        }
        Handler().postDelayed(Runnable {
            binding.bottomNavigation.show(ID_HOME,true)

        },800)
    }

    override fun onBackPressed() {
        val dialogBuilder = AlertDialog.Builder(this!!)
        dialogBuilder.setMessage("Do you want to quit my lawyer app? ")
            // if the dialog is cancelable
            .setCancelable(false)
            .setPositiveButton(Html.fromHtml("<font color='#B2020005'>No</font>")) { dialog, id ->
                dialog.dismiss()
            }
            .setNegativeButton(Html.fromHtml("<font color='#B2020005'>Yes</font>")) { dialog, which ->
                finishAffinity()
            }


        val alert = dialogBuilder.create()
        alert.show()
    }

    private fun UpdateToken(forServiceProvider: Boolean) {
        val firebaseUser = FirebaseAuth.getInstance().currentUser
        val refreshToken = FirebaseInstanceId.getInstance().token
        val token = Token(refreshToken)
        if (forServiceProvider){
            FirebaseDatabase.getInstance().getReference("Tokens")
                .child("ServiceProvider")
                .child(
                FirebaseAuth.getInstance().currentUser!!.uid
            ).setValue(token)
        }
        else{
            FirebaseDatabase.getInstance().getReference("Tokens")
                .child("Users")
                .child(
                    FirebaseAuth.getInstance().currentUser!!.uid
                ).setValue(token)
        }
    }
}
