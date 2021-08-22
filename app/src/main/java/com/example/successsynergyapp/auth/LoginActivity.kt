package com.example.successsynergyapp.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.successsynergyapp.R
import com.example.successsynergyapp.databinding.ActivityLoginBinding
import com.example.successsynergyapp.extensions.tabSelectedListener
import com.google.android.material.tabs.TabLayout

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    var forWhat: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = resources.getColor(R.color.black)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Login")); binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Sign Up"))
        forWhat = intent.extras!!.getString("for")
        val adapter = MyAdapter(supportFragmentManager, 2); binding.viewPager.adapter = adapter

        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.tabSelectedListener { binding.viewPager.currentItem = it.position }
    }
    inner class MyAdapter(fm: FragmentManager, private var totalTabs: Int) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            var signUpFrag = SignUpFragment()
            var signUpBundle = Bundle()
            signUpFrag.arguments = signUpBundle
            if (forWhat!!.equals("User"))
                signUpBundle.putString("for", "User")
            else
                signUpBundle.putString("for", "ServiceProvider")

            var loginUpFrag = LoginFragment()
            var loginUpBundle = Bundle()
            if (forWhat!!.equals("User"))
                loginUpBundle.putString("for", "User")
            else
                loginUpBundle.putString("for", "ServiceProvider")
            loginUpFrag.arguments = loginUpBundle
            return when (position) {
                0 -> loginUpFrag
                1 -> signUpFrag
                else -> LoginFragment()
            }
        }

        override fun getCount(): Int = totalTabs
    }
}